package com.tencent.mm.plugin.sns.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView.2;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView.a;
import com.tencent.mm.plugin.story.api.AbsStoryHeaderTipView;
import com.tencent.mm.plugin.story.api.j;
import com.tencent.mm.plugin.story.api.l.c;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.bzi;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.z;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@SuppressLint({"UseSparseArrays"})
public class SnsHeader
  extends LinearLayout
{
  Animation Ajj;
  c Auq;
  private a Aur;
  private b Aus;
  private boolean Aut;
  private Map<Integer, View> Auu;
  private String Auv;
  Bitmap Auw;
  boolean Aux;
  Context context;
  private Dialog dialog;
  boolean dsB;
  String fHO;
  private String sessionId;
  private int type;
  String userName;
  private String zJR;
  
  public SnsHeader(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(98715);
    this.Aut = false;
    this.dsB = false;
    this.Auu = new HashMap();
    this.Auv = "";
    this.Auw = null;
    this.Ajj = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    this.Aux = false;
    init(paramContext);
    AppMethodBeat.o(98715);
  }
  
  public SnsHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98716);
    this.Aut = false;
    this.dsB = false;
    this.Auu = new HashMap();
    this.Auv = "";
    this.Auw = null;
    this.Ajj = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    this.Aux = false;
    init(paramContext);
    AppMethodBeat.o(98716);
  }
  
  private void init(final Context paramContext)
  {
    AppMethodBeat.i(98721);
    this.context = paramContext;
    com.tencent.mm.kernel.g.ajS();
    this.Aux = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryNewFeatureConfig().ekF();
    Object localObject = z.jV(paramContext).inflate(2131495552, this, true);
    FrameLayout localFrameLayout = (FrameLayout)((View)localObject).findViewById(2131305057);
    this.Auq = new c();
    this.Auq.nHR = ((TextView)((View)localObject).findViewById(2131302867));
    this.Auq.fTj = ((ImageView)((View)localObject).findViewById(2131297008));
    this.Auq.AfE = ((TextView)((View)localObject).findViewById(2131304821));
    this.Auq.AuB = ((ImageView)((View)localObject).findViewById(2131304937));
    this.Auq.AuC = ((ImageView)((View)localObject).findViewById(2131304938));
    this.Auq.AuD = ((LinearLayout)((View)localObject).findViewById(2131304613));
    this.Auq.AuE = ((LinearLayout)((View)localObject).findViewById(2131304976));
    this.Auq.AuH = ((RelativeLayout)((View)localObject).findViewById(2131304981));
    this.Auq.AuI = ((LinearLayout)((View)localObject).findViewById(2131304982));
    this.Auq.AuJ = ((ImageView)((View)localObject).findViewById(2131307247));
    this.Ajj.setDuration(1000L);
    this.Ajj.setRepeatCount(-1);
    localObject = new LinearInterpolator();
    this.Ajj.setInterpolator((Interpolator)localObject);
    localObject = this.Auq;
    com.tencent.mm.kernel.g.ajS();
    ((c)localObject).AuF = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().gx(paramContext);
    this.Auq.AuG = new SnsStoryHeaderView(paramContext);
    if (this.Aux)
    {
      localFrameLayout.addView(this.Auq.AuF);
      this.Auq.AuF.onCreateView();
    }
    for (;;)
    {
      this.Auq.AuB.setContentDescription(paramContext.getString(2131763783));
      this.Auq.AuB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(98712);
          Object localObject = new b();
          ((b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
          ae.d("MicroMsg.SnsHeader", "change backGround");
          if ((SnsHeader.a(SnsHeader.this) != null) && (SnsHeader.a(SnsHeader.this).isShowing()))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(98712);
            return;
          }
          if (SnsHeader.b(SnsHeader.this) != null) {
            SnsHeader.b(SnsHeader.this).efF();
          }
          if (SnsHeader.c(SnsHeader.this) == 1) {}
          final long l;
          for (paramAnonymousView = SnsHeader.d(SnsHeader.this);; paramAnonymousView = SnsHeader.e(SnsHeader.this))
          {
            paramAnonymousView = ah.dXI().aBw(paramAnonymousView);
            l = paramAnonymousView.field_snsBgId;
            if ((SnsHeader.f(SnsHeader.this)) || (l != 0L)) {
              break;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(98712);
            return;
          }
          SnsHeader.a(SnsHeader.this, paramAnonymousView.ece());
          if ((SnsHeader.c(SnsHeader.this) == 1) || (SnsHeader.d(SnsHeader.this).trim().equals(SnsHeader.e(SnsHeader.this).trim())))
          {
            paramAnonymousView = new String[1];
            paramAnonymousView[0] = paramContext.getString(2131764047);
            SnsHeader.a(SnsHeader.this, false);
            if (!SnsHeader.g(SnsHeader.this)) {
              break label387;
            }
            localObject = paramContext.getString(2131763965);
            label281:
            if (!SnsHeader.g(SnsHeader.this)) {
              break label394;
            }
            paramContext.getString(2131755835);
          }
          for (;;)
          {
            SnsHeader.a(SnsHeader.this, com.tencent.mm.ui.base.h.a(SnsHeader.this.getContext(), (String)localObject, paramAnonymousView, new h.c()
            {
              public final void lh(int paramAnonymous2Int)
              {
                AppMethodBeat.i(98711);
                switch (paramAnonymous2Int)
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(98711);
                  return;
                  if (!SnsHeader.g(SnsHeader.this)) {
                    SnsHeader.a(SnsHeader.this, l);
                  }
                }
              }
            }));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(98712);
            return;
            if (SnsHeader.g(SnsHeader.this))
            {
              paramAnonymousView = new String[0];
              break;
            }
            paramAnonymousView = new String[1];
            paramAnonymousView[0] = paramContext.getString(2131763889);
            break;
            label387:
            localObject = "";
            break label281;
            label394:
            paramContext.getString(2131755691);
          }
        }
      });
      this.Auq.fTj.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(98713);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = ah.dXs().BH(SnsHeader.e(SnsHeader.this));
          int i;
          if ((paramAnonymousView != null) && ((c.lO(paramAnonymousView.field_type)) || (SnsHeader.f(SnsHeader.this))))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("Contact_User", SnsHeader.e(SnsHeader.this));
            if ((SnsHeader.e(SnsHeader.this) != null) && (SnsHeader.e(SnsHeader.this).length() > 0))
            {
              if (SnsHeader.c(SnsHeader.this) != 1) {
                break label172;
              }
              i = 6;
              paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", i);
              com.tencent.mm.plugin.sns.c.a.iUz.c(paramAnonymousView, paramContext);
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(98713);
            return;
            label172:
            i = 1;
            break;
            paramAnonymousView = ((Activity)paramContext).getIntent();
            paramAnonymousView.putExtra("Contact_User", SnsHeader.e(SnsHeader.this));
            com.tencent.mm.plugin.sns.c.a.iUz.c(paramAnonymousView, paramContext);
          }
        }
      });
      AppMethodBeat.o(98721);
      return;
      localFrameLayout.addView(this.Auq.AuG);
      this.Auq.AuG.setSessionId(this.sessionId);
      this.Auq.AuG.setEnterObjectId(this.zJR);
    }
  }
  
  public final void efD()
  {
    AppMethodBeat.i(98723);
    String str1 = this.userName;
    if (this.type == 1) {
      str1 = this.fHO;
    }
    Object localObject1 = ah.getAccSnsPath();
    ae.d("MicroMsg.SnsHeader", "MagicAsyncTask ".concat(String.valueOf(str1)));
    com.tencent.mm.plugin.sns.storage.n localn = ah.dXI().aBw(str1);
    String str2 = localn.field_bgId;
    Object localObject3 = localn.field_older_bgId;
    ae.d("MicroMsg.SnsHeader", "showName " + str1 + " get bgId : " + str2 + "  olderBgId：　" + (String)localObject3);
    localObject3 = r.azk(str2);
    String str6 = str1 + "bg_";
    String str3 = str1 + "tbg_";
    String str4 = ap.jv((String)localObject1, str1);
    com.tencent.mm.vfs.o.aZI(str4);
    int i;
    String str5;
    if ((localn.field_local_flag & 0x1) > 0)
    {
      i = 1;
      if (i != 0)
      {
        ae.d("MicroMsg.SnsHeader", "bg is change");
        ah.dXI().aBv(str1);
        if (com.tencent.mm.vfs.o.fB(ap.jv((String)localObject1, str1) + str6))
        {
          com.tencent.mm.vfs.o.deleteFile(ap.jv((String)localObject1, str1) + str3);
          com.tencent.mm.vfs.o.bc(ap.jv((String)localObject1, str1), str6, str3);
        }
        localn.field_local_flag &= 0xFFFFFFFE;
        ah.dXI().c(localn);
      }
      if ((com.tencent.mm.vfs.o.fB(ap.jv(ah.getAccSnsPath(), str2) + (String)localObject3)) && (!com.tencent.mm.vfs.o.fB(ap.jv((String)localObject1, str1) + str6)))
      {
        com.tencent.mm.vfs.o.mF(ap.jv((String)localObject1, str2) + (String)localObject3, ap.jv((String)localObject1, str1) + str6);
        ae.d("MicroMsg.SnsHeader", "nwer id Name update");
      }
      str5 = localn.field_bgUrl;
      if (str2 == null) {
        break label780;
      }
      ah.dXB();
      localObject1 = str4 + str6;
      this.context.hashCode();
      localObject3 = com.tencent.mm.plugin.sns.model.g.a((String)localObject1, str5, str2, true, bk.JgC);
      ae.d("MicroMsg.SnsHeader", "set a new bg");
      localObject1 = localObject3;
      if (localObject3 == null) {
        com.tencent.mm.vfs.o.deleteFile(str4 + str6);
      }
    }
    label691:
    Object localObject2;
    label780:
    for (localObject1 = localObject3;; localObject2 = null)
    {
      localObject3 = localObject1;
      if (localObject1 == null)
      {
        localObject3 = localObject1;
        if (str2 != null)
        {
          ah.dXB();
          localObject1 = str4 + str3;
          this.context.hashCode();
          localObject3 = com.tencent.mm.plugin.sns.model.g.a((String)localObject1, str5, str2, false, bk.JgC);
        }
      }
      if (this.Auq.AuB != null)
      {
        this.Auq.AuB.setImageBitmap((Bitmap)localObject3);
        if (localObject3 == null) {
          break label691;
        }
        this.Auq.AuB.setBackgroundDrawable(null);
      }
      for (;;)
      {
        this.Auq.AuD.setVisibility(8);
        if ((localObject3 == null) && ((this.type == 1) || (this.fHO.equals(str1)))) {
          this.Auq.AuD.setVisibility(0);
        }
        this.Aut = localn.ece();
        AppMethodBeat.o(98723);
        return;
        i = 0;
        break;
        try
        {
          if ((this.Auw == null) || (this.Auw.isRecycled()))
          {
            ae.i("MicroMsg.SnsHeader", "decode bitmap by self");
            this.Auw = com.tencent.mm.sdk.platformtools.h.decodeStream(this.context.getAssets().open("resource/friendactivity_mycover_bg.jpg"));
          }
          localObject1 = new BitmapDrawable(this.Auw);
          this.Auq.AuB.setBackgroundDrawable((Drawable)localObject1);
        }
        catch (IOException localIOException)
        {
          ae.printErrStackTrace("MicroMsg.SnsHeader", localIOException, "", new Object[0]);
        }
      }
    }
  }
  
  public final boolean efE()
  {
    AppMethodBeat.i(98724);
    if (this.Auq.AuE == null)
    {
      AppMethodBeat.o(98724);
      return false;
    }
    Object localObject = al.dYb();
    LinkedList localLinkedList = new LinkedList();
    final int i = 0;
    p localp1;
    boolean bool;
    for (;;)
    {
      if (i >= ((List)localObject).size()) {
        break label114;
      }
      localp1 = (p)((List)localObject).get(i);
      try
      {
        bool = ((bzi)new bzi().parseFrom(localp1.field_postBuf)).HmX;
        if (!bool) {
          break;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localLinkedList.add(localp1);
        }
      }
      i += 1;
    }
    label114:
    localObject = "";
    i = 0;
    for (;;)
    {
      if (i >= localLinkedList.size()) {
        break label224;
      }
      localp1 = (p)localLinkedList.get(i);
      try
      {
        bool = ((bzi)new bzi().parseFrom(localp1.field_postBuf)).HmX;
        if (!bool) {
          break;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localObject = (String)localObject + ((p)localLinkedList.get(i)).eco() + " ";
        }
      }
      i += 1;
    }
    label224:
    ae.i("MicroMsg.SnsHeader", "refreshError %s %s %s", new Object[] { Integer.valueOf(localLinkedList.size()), localObject, this.Auv });
    if (((String)localObject).equals(this.Auv))
    {
      if (localLinkedList.size() > 0)
      {
        AppMethodBeat.o(98724);
        return true;
      }
      AppMethodBeat.o(98724);
      return false;
    }
    this.Auv = ((String)localObject);
    this.Auq.AuE.removeAllViews();
    localObject = this.Auq.AuE;
    label358:
    int j;
    final int k;
    label442:
    p localp2;
    TextView localTextView;
    if (localLinkedList.size() > 0)
    {
      i = 0;
      ((LinearLayout)localObject).setVisibility(i);
      Collections.sort(localLinkedList, new d());
      i = 0;
      if (i >= localLinkedList.size()) {
        break label670;
      }
      j = ((p)localLinkedList.get(i)).AdJ;
      k = localLinkedList.size();
      if ((!this.Auu.containsKey(Integer.valueOf(j))) || (this.Auu.get(Integer.valueOf(j)) == null)) {
        break label541;
      }
      localObject = (View)this.Auu.get(Integer.valueOf(j));
      localObject = (LinearLayout)localObject;
      ((LinearLayout)localObject).getChildAt(0).setTag(((p)localLinkedList.get(i)).eco());
      localp2 = (p)localLinkedList.get(i);
      localTextView = (TextView)((LinearLayout)localObject).findViewById(2131305032);
      if (localp2.field_type != 15) {
        break label598;
      }
      localTextView.setText(2131763947);
    }
    for (;;)
    {
      this.Auq.AuE.addView((View)localObject);
      i += 1;
      break label358;
      i = 8;
      break;
      label541:
      localObject = (LinearLayout)z.jV(this.context).inflate(2131494434, null);
      ((LinearLayout)localObject).getChildAt(0).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(98714);
          Object localObject1 = new b();
          ((b)localObject1).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsHeader$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).ahF());
          if ((paramAnonymousView.getTag() instanceof String))
          {
            Object localObject2 = (String)paramAnonymousView.getTag();
            ae.i("MicroMsg.SnsHeader", "sns Header localId ".concat(String.valueOf(localObject2)));
            paramAnonymousView = ah.dXE().aBr((String)localObject2);
            if ((SnsHeader.h(SnsHeader.this) != null) && (paramAnonymousView != null))
            {
              localObject1 = new Intent();
              ((Intent)localObject1).setClass(SnsHeader.h(SnsHeader.this), SnsCommentDetailUI.class);
              if ((paramAnonymousView == null) || (paramAnonymousView.field_userName == null) || (paramAnonymousView.field_userName.equals("")))
              {
                ae.i("MicroMsg.SnsHeader", "error cntinfo or username is null");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsHeader$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(98714);
                return;
              }
              ((Intent)localObject1).putExtra("INTENT_TALKER", paramAnonymousView.field_userName);
              ((Intent)localObject1).putExtra("INTENT_SNS_LOCAL_ID", (String)localObject2);
              ((Intent)localObject1).putExtra("INTENT_FROMGALLERY", true);
              localObject2 = com.tencent.mm.modelsns.e.pY(726);
              ((com.tencent.mm.modelsns.e)localObject2).qb(k).qb(i).qb(paramAnonymousView.field_createTime);
              ((com.tencent.mm.modelsns.e)localObject2).aLH();
              localObject2 = SnsHeader.h(SnsHeader.this);
              localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
              com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/sns/ui/SnsHeader$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/sns/ui/SnsHeader$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
          }
          try
          {
            localObject1 = (bzi)new bzi().parseFrom(paramAnonymousView.field_postBuf);
            if ((((bzi)localObject1).HmP == 201) || (((bzi)localObject1).HmP == 210) || (((bzi)localObject1).HmP != 211))
            {
              ((bzi)localObject1).HmX = true;
              paramAnonymousView.field_postBuf = ((bzi)localObject1).toByteArray();
              ah.dXE().b(paramAnonymousView.AdJ, paramAnonymousView);
            }
          }
          catch (Exception paramAnonymousView)
          {
            label361:
            break label361;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsHeader$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98714);
        }
      });
      this.Auu.put(Integer.valueOf(j), localObject);
      break label442;
      label598:
      if (localp2.field_type == 2) {
        localTextView.setText(2131766824);
      } else if (localp2.field_type == 1) {
        localTextView.setText(2131763942);
      } else if (localp2.field_type == 26) {
        localTextView.setText(2131766823);
      } else {
        localTextView.setText(2131766822);
      }
    }
    label670:
    if (localLinkedList.size() > 0)
    {
      AppMethodBeat.o(98724);
      return true;
    }
    AppMethodBeat.o(98724);
    return false;
  }
  
  public int getLoadingGroupHeight()
  {
    AppMethodBeat.i(219894);
    int j = 0;
    int i = j;
    if (this.Auq != null)
    {
      i = j;
      if (this.Auq.AuI != null) {
        i = this.Auq.AuI.getHeight() + aq.fromDPToPix(getContext(), 32);
      }
    }
    AppMethodBeat.o(219894);
    return i;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(98725);
    if ((this.Auq != null) && (this.Auq.AuF != null) && (this.Aux)) {
      this.Auq.AuF.eks();
    }
    if ((this.Auq != null) && (this.Auq.AuG != null) && (!this.Aux))
    {
      SnsStoryHeaderView localSnsStoryHeaderView = this.Auq.AuG;
      ae.i("MicroMsg.SnsStoryHeaderView", "resume: ");
      localSnsStoryHeaderView.dus = false;
      ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().ekN();
      localSnsStoryHeaderView.post(new SnsStoryHeaderView.2(localSnsStoryHeaderView));
    }
    AppMethodBeat.o(98725);
  }
  
  public void setAvatarOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(98722);
    if ((this.Auq != null) && (this.Auq.fTj != null)) {
      this.Auq.fTj.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(98722);
  }
  
  public void setBackClickListener(a parama)
  {
    this.Aur = parama;
  }
  
  public void setEnterObjectId(String paramString)
  {
    AppMethodBeat.i(98720);
    this.zJR = paramString;
    if ((this.Auq != null) && (this.Auq.AuG != null) && (!this.Aux)) {
      this.Auq.AuG.setEnterObjectId(paramString);
    }
    AppMethodBeat.o(98720);
  }
  
  public void setHeadBgListener(b paramb)
  {
    this.Aus = paramb;
  }
  
  public void setSessionId(String paramString)
  {
    AppMethodBeat.i(98719);
    this.sessionId = paramString;
    if ((this.Auq != null) && (this.Auq.AuG != null) && (!this.Aux)) {
      this.Auq.AuG.setSessionId(paramString);
    }
    AppMethodBeat.o(98719);
  }
  
  public void setStoryAction(SnsStoryHeaderView.a parama)
  {
    AppMethodBeat.i(98718);
    if ((this.Auq != null) && (this.Auq.AuG != null) && (!this.Aux)) {
      this.Auq.AuG.setStoryAction(parama);
    }
    AppMethodBeat.o(98718);
  }
  
  public void setType(int paramInt)
  {
    AppMethodBeat.i(98717);
    this.type = paramInt;
    if ((paramInt == 1) && (this.Auq.AfE != null)) {
      this.Auq.AfE.setVisibility(8);
    }
    if (this.Auq != null)
    {
      if ((this.Auq.AuF != null) && (this.Aux)) {
        this.Auq.AuF.setSnsType(paramInt);
      }
      if ((this.Auq.AuG != null) && (!this.Aux)) {
        this.Auq.AuG.setSnsType(paramInt);
      }
    }
    if (paramInt != 1)
    {
      if ((this.Auq.AuF != null) && (this.Auq.AuF.getParent() != null) && ((this.Auq.AuF.getParent() instanceof ViewGroup))) {
        ((ViewGroup)this.Auq.AuF.getParent()).removeView(this.Auq.AuF);
      }
      if ((this.Auq.AuG != null) && (this.Auq.AuG.getParent() != null) && ((this.Auq.AuG.getParent() instanceof ViewGroup))) {
        ((ViewGroup)this.Auq.AuG.getParent()).removeView(this.Auq.AuG);
      }
    }
    if (paramInt == 1)
    {
      this.Auq.AuI.setPadding(0, ar.dX(this.context) + ar.en(this.context) - getResources().getDimensionPixelSize(2131166841), 0, aq.fromDPToPix(this.context, 10));
      AppMethodBeat.o(98717);
      return;
    }
    if (paramInt == 2) {
      this.Auq.AuI.setPadding(0, ar.dX(this.context) + ar.en(this.context) + aq.fromDPToPix(getContext(), 90) + aq.fromDPToPix(getContext(), 48), 0, 0);
    }
    AppMethodBeat.o(98717);
  }
  
  public static abstract interface a
  {
    public abstract boolean AL(long paramLong);
    
    public abstract boolean efF();
  }
  
  public static abstract interface b {}
  
  final class c
  {
    TextView AfE;
    ImageView AuB;
    ImageView AuC;
    LinearLayout AuD;
    LinearLayout AuE;
    AbsStoryHeaderTipView AuF;
    SnsStoryHeaderView AuG;
    RelativeLayout AuH;
    LinearLayout AuI;
    ImageView AuJ;
    ImageView fTj;
    TextView nHR;
    
    c() {}
  }
  
  final class d
    implements Comparator<p>
  {
    d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsHeader
 * JD-Core Version:    0.7.0.1
 */