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
import com.tencent.mm.g.c.aw;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView.2;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView.a;
import com.tencent.mm.plugin.story.api.AbsStoryHeaderTipView;
import com.tencent.mm.plugin.story.api.j;
import com.tencent.mm.plugin.story.api.l.c;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.byo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.z;
import com.tencent.mm.vfs.i;
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
  c Ade;
  private a Adf;
  private b Adg;
  private boolean Adh;
  private Map<Integer, View> Adi;
  private String Adj;
  Bitmap Adk;
  boolean Adl;
  Context context;
  private Dialog dialog;
  boolean drv;
  String fFK;
  private String sessionId;
  private int type;
  String userName;
  Animation zSc;
  private String zsC;
  
  public SnsHeader(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(98715);
    this.Adh = false;
    this.drv = false;
    this.Adi = new HashMap();
    this.Adj = "";
    this.Adk = null;
    this.zSc = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    this.Adl = false;
    init(paramContext);
    AppMethodBeat.o(98715);
  }
  
  public SnsHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98716);
    this.Adh = false;
    this.drv = false;
    this.Adi = new HashMap();
    this.Adj = "";
    this.Adk = null;
    this.zSc = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    this.Adl = false;
    init(paramContext);
    AppMethodBeat.o(98716);
  }
  
  private void init(final Context paramContext)
  {
    AppMethodBeat.i(98721);
    this.context = paramContext;
    com.tencent.mm.kernel.g.ajD();
    this.Adl = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryNewFeatureConfig().egX();
    Object localObject = z.jO(paramContext).inflate(2131495552, this, true);
    FrameLayout localFrameLayout = (FrameLayout)((View)localObject).findViewById(2131305057);
    this.Ade = new c();
    this.Ade.nCw = ((TextView)((View)localObject).findViewById(2131302867));
    this.Ade.fRd = ((ImageView)((View)localObject).findViewById(2131297008));
    this.Ade.zOx = ((TextView)((View)localObject).findViewById(2131304821));
    this.Ade.Adp = ((ImageView)((View)localObject).findViewById(2131304937));
    this.Ade.Adq = ((ImageView)((View)localObject).findViewById(2131304938));
    this.Ade.Adr = ((LinearLayout)((View)localObject).findViewById(2131304613));
    this.Ade.Ads = ((LinearLayout)((View)localObject).findViewById(2131304976));
    this.Ade.Adv = ((RelativeLayout)((View)localObject).findViewById(2131304981));
    this.Ade.Adw = ((LinearLayout)((View)localObject).findViewById(2131304982));
    this.Ade.Adx = ((ImageView)((View)localObject).findViewById(2131307247));
    this.zSc.setDuration(1000L);
    this.zSc.setRepeatCount(-1);
    localObject = new LinearInterpolator();
    this.zSc.setInterpolator((Interpolator)localObject);
    localObject = this.Ade;
    com.tencent.mm.kernel.g.ajD();
    ((c)localObject).Adt = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().gs(paramContext);
    this.Ade.Adu = new SnsStoryHeaderView(paramContext);
    if (this.Adl)
    {
      localFrameLayout.addView(this.Ade.Adt);
      this.Ade.Adt.onCreateView();
    }
    for (;;)
    {
      this.Ade.Adp.setContentDescription(paramContext.getString(2131763783));
      this.Ade.Adp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(98712);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          ad.d("MicroMsg.SnsHeader", "change backGround");
          if ((SnsHeader.a(SnsHeader.this) != null) && (SnsHeader.a(SnsHeader.this).isShowing()))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(98712);
            return;
          }
          if (SnsHeader.b(SnsHeader.this) != null) {
            SnsHeader.b(SnsHeader.this).ebY();
          }
          if (SnsHeader.c(SnsHeader.this) == 1) {}
          final long l;
          for (paramAnonymousView = SnsHeader.d(SnsHeader.this);; paramAnonymousView = SnsHeader.e(SnsHeader.this))
          {
            paramAnonymousView = ag.dUi().aAf(paramAnonymousView);
            l = paramAnonymousView.field_snsBgId;
            if ((SnsHeader.f(SnsHeader.this)) || (l != 0L)) {
              break;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(98712);
            return;
          }
          SnsHeader.a(SnsHeader.this, paramAnonymousView.dYA());
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
            SnsHeader.a(SnsHeader.this, h.a(SnsHeader.this.getContext(), (String)localObject, paramAnonymousView, new h.c()
            {
              public final void lf(int paramAnonymous2Int)
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
      this.Ade.fRd.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(98713);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          paramAnonymousView = ag.dTS().Bf(SnsHeader.e(SnsHeader.this));
          int i;
          if ((paramAnonymousView != null) && ((com.tencent.mm.o.b.lM(paramAnonymousView.field_type)) || (SnsHeader.f(SnsHeader.this))))
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
              com.tencent.mm.plugin.sns.c.a.iRG.c(paramAnonymousView, paramContext);
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
            com.tencent.mm.plugin.sns.c.a.iRG.c(paramAnonymousView, paramContext);
          }
        }
      });
      AppMethodBeat.o(98721);
      return;
      localFrameLayout.addView(this.Ade.Adu);
      this.Ade.Adu.setSessionId(this.sessionId);
      this.Ade.Adu.setEnterObjectId(this.zsC);
    }
  }
  
  public final void ebW()
  {
    AppMethodBeat.i(98723);
    String str1 = this.userName;
    if (this.type == 1) {
      str1 = this.fFK;
    }
    Object localObject1 = ag.getAccSnsPath();
    ad.d("MicroMsg.SnsHeader", "MagicAsyncTask ".concat(String.valueOf(str1)));
    com.tencent.mm.plugin.sns.storage.n localn = ag.dUi().aAf(str1);
    String str2 = localn.field_bgId;
    Object localObject3 = localn.field_older_bgId;
    ad.d("MicroMsg.SnsHeader", "showName " + str1 + " get bgId : " + str2 + "  olderBgId：　" + (String)localObject3);
    localObject3 = com.tencent.mm.plugin.sns.data.q.axT(str2);
    String str6 = str1 + "bg_";
    String str3 = str1 + "tbg_";
    String str4 = ao.jo((String)localObject1, str1);
    i.aYg(str4);
    int i;
    String str5;
    if ((localn.field_local_flag & 0x1) > 0)
    {
      i = 1;
      if (i != 0)
      {
        ad.d("MicroMsg.SnsHeader", "bg is change");
        ag.dUi().aAe(str1);
        if (i.fv(ao.jo((String)localObject1, str1) + str6))
        {
          i.deleteFile(ao.jo((String)localObject1, str1) + str3);
          i.bb(ao.jo((String)localObject1, str1), str6, str3);
        }
        localn.field_local_flag &= 0xFFFFFFFE;
        ag.dUi().c(localn);
      }
      if ((i.fv(ao.jo(ag.getAccSnsPath(), str2) + (String)localObject3)) && (!i.fv(ao.jo((String)localObject1, str1) + str6)))
      {
        i.mz(ao.jo((String)localObject1, str2) + (String)localObject3, ao.jo((String)localObject1, str1) + str6);
        ad.d("MicroMsg.SnsHeader", "nwer id Name update");
      }
      str5 = localn.field_bgUrl;
      if (str2 == null) {
        break label780;
      }
      ag.dUb();
      localObject1 = str4 + str6;
      this.context.hashCode();
      localObject3 = f.a((String)localObject1, str5, str2, true, bj.ILV);
      ad.d("MicroMsg.SnsHeader", "set a new bg");
      localObject1 = localObject3;
      if (localObject3 == null) {
        i.deleteFile(str4 + str6);
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
          ag.dUb();
          localObject1 = str4 + str3;
          this.context.hashCode();
          localObject3 = f.a((String)localObject1, str5, str2, false, bj.ILV);
        }
      }
      if (this.Ade.Adp != null)
      {
        this.Ade.Adp.setImageBitmap((Bitmap)localObject3);
        if (localObject3 == null) {
          break label691;
        }
        this.Ade.Adp.setBackgroundDrawable(null);
      }
      for (;;)
      {
        this.Ade.Adr.setVisibility(8);
        if ((localObject3 == null) && ((this.type == 1) || (this.fFK.equals(str1)))) {
          this.Ade.Adr.setVisibility(0);
        }
        this.Adh = localn.dYA();
        AppMethodBeat.o(98723);
        return;
        i = 0;
        break;
        try
        {
          if ((this.Adk == null) || (this.Adk.isRecycled()))
          {
            ad.i("MicroMsg.SnsHeader", "decode bitmap by self");
            this.Adk = com.tencent.mm.sdk.platformtools.g.decodeStream(this.context.getAssets().open("resource/friendactivity_mycover_bg.jpg"));
          }
          localObject1 = new BitmapDrawable(this.Adk);
          this.Ade.Adp.setBackgroundDrawable((Drawable)localObject1);
        }
        catch (IOException localIOException)
        {
          ad.printErrStackTrace("MicroMsg.SnsHeader", localIOException, "", new Object[0]);
        }
      }
    }
  }
  
  public final boolean ebX()
  {
    AppMethodBeat.i(98724);
    if (this.Ade.Ads == null)
    {
      AppMethodBeat.o(98724);
      return false;
    }
    Object localObject = ak.dUB();
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
        bool = ((byo)new byo().parseFrom(localp1.field_postBuf)).GTw;
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
        bool = ((byo)new byo().parseFrom(localp1.field_postBuf)).GTw;
        if (!bool) {
          break;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localObject = (String)localObject + ((p)localLinkedList.get(i)).dYK() + " ";
        }
      }
      i += 1;
    }
    label224:
    ad.i("MicroMsg.SnsHeader", "refreshError %s %s %s", new Object[] { Integer.valueOf(localLinkedList.size()), localObject, this.Adj });
    if (((String)localObject).equals(this.Adj))
    {
      if (localLinkedList.size() > 0)
      {
        AppMethodBeat.o(98724);
        return true;
      }
      AppMethodBeat.o(98724);
      return false;
    }
    this.Adj = ((String)localObject);
    this.Ade.Ads.removeAllViews();
    localObject = this.Ade.Ads;
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
      j = ((p)localLinkedList.get(i)).zMC;
      k = localLinkedList.size();
      if ((!this.Adi.containsKey(Integer.valueOf(j))) || (this.Adi.get(Integer.valueOf(j)) == null)) {
        break label541;
      }
      localObject = (View)this.Adi.get(Integer.valueOf(j));
      localObject = (LinearLayout)localObject;
      ((LinearLayout)localObject).getChildAt(0).setTag(((p)localLinkedList.get(i)).dYK());
      localp2 = (p)localLinkedList.get(i);
      localTextView = (TextView)((LinearLayout)localObject).findViewById(2131305032);
      if (localp2.field_type != 15) {
        break label598;
      }
      localTextView.setText(2131763947);
    }
    for (;;)
    {
      this.Ade.Ads.addView((View)localObject);
      i += 1;
      break label358;
      i = 8;
      break;
      label541:
      localObject = (LinearLayout)z.jO(this.context).inflate(2131494434, null);
      ((LinearLayout)localObject).getChildAt(0).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(98714);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsHeader$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
          if ((paramAnonymousView.getTag() instanceof String))
          {
            Object localObject2 = (String)paramAnonymousView.getTag();
            ad.i("MicroMsg.SnsHeader", "sns Header localId ".concat(String.valueOf(localObject2)));
            paramAnonymousView = ag.dUe().aAa((String)localObject2);
            if ((SnsHeader.h(SnsHeader.this) != null) && (paramAnonymousView != null))
            {
              localObject1 = new Intent();
              ((Intent)localObject1).setClass(SnsHeader.h(SnsHeader.this), SnsCommentDetailUI.class);
              if ((paramAnonymousView == null) || (paramAnonymousView.field_userName == null) || (paramAnonymousView.field_userName.equals("")))
              {
                ad.i("MicroMsg.SnsHeader", "error cntinfo or username is null");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsHeader$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(98714);
                return;
              }
              ((Intent)localObject1).putExtra("INTENT_TALKER", paramAnonymousView.field_userName);
              ((Intent)localObject1).putExtra("INTENT_SNS_LOCAL_ID", (String)localObject2);
              ((Intent)localObject1).putExtra("INTENT_FROMGALLERY", true);
              localObject2 = com.tencent.mm.modelsns.e.pV(726);
              ((com.tencent.mm.modelsns.e)localObject2).pY(k).pY(i).pY(paramAnonymousView.field_createTime);
              ((com.tencent.mm.modelsns.e)localObject2).aLk();
              localObject2 = SnsHeader.h(SnsHeader.this);
              localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
              com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/sns/ui/SnsHeader$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/sns/ui/SnsHeader$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
          }
          try
          {
            localObject1 = (byo)new byo().parseFrom(paramAnonymousView.field_postBuf);
            if ((((byo)localObject1).GTo == 201) || (((byo)localObject1).GTo == 210) || (((byo)localObject1).GTo != 211))
            {
              ((byo)localObject1).GTw = true;
              paramAnonymousView.field_postBuf = ((byo)localObject1).toByteArray();
              ag.dUe().b(paramAnonymousView.zMC, paramAnonymousView);
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
      this.Adi.put(Integer.valueOf(j), localObject);
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
    AppMethodBeat.i(198356);
    int j = 0;
    int i = j;
    if (this.Ade != null)
    {
      i = j;
      if (this.Ade.Adw != null) {
        i = this.Ade.Adw.getHeight() + aq.fromDPToPix(getContext(), 32);
      }
    }
    AppMethodBeat.o(198356);
    return i;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(98725);
    if ((this.Ade != null) && (this.Ade.Adt != null) && (this.Adl)) {
      this.Ade.Adt.egK();
    }
    if ((this.Ade != null) && (this.Ade.Adu != null) && (!this.Adl))
    {
      SnsStoryHeaderView localSnsStoryHeaderView = this.Ade.Adu;
      ad.i("MicroMsg.SnsStoryHeaderView", "resume: ");
      localSnsStoryHeaderView.dtm = false;
      ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().ehf();
      localSnsStoryHeaderView.post(new SnsStoryHeaderView.2(localSnsStoryHeaderView));
    }
    AppMethodBeat.o(98725);
  }
  
  public void setAvatarOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(98722);
    if ((this.Ade != null) && (this.Ade.fRd != null)) {
      this.Ade.fRd.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(98722);
  }
  
  public void setBackClickListener(a parama)
  {
    this.Adf = parama;
  }
  
  public void setEnterObjectId(String paramString)
  {
    AppMethodBeat.i(98720);
    this.zsC = paramString;
    if ((this.Ade != null) && (this.Ade.Adu != null) && (!this.Adl)) {
      this.Ade.Adu.setEnterObjectId(paramString);
    }
    AppMethodBeat.o(98720);
  }
  
  public void setHeadBgListener(b paramb)
  {
    this.Adg = paramb;
  }
  
  public void setSessionId(String paramString)
  {
    AppMethodBeat.i(98719);
    this.sessionId = paramString;
    if ((this.Ade != null) && (this.Ade.Adu != null) && (!this.Adl)) {
      this.Ade.Adu.setSessionId(paramString);
    }
    AppMethodBeat.o(98719);
  }
  
  public void setStoryAction(SnsStoryHeaderView.a parama)
  {
    AppMethodBeat.i(98718);
    if ((this.Ade != null) && (this.Ade.Adu != null) && (!this.Adl)) {
      this.Ade.Adu.setStoryAction(parama);
    }
    AppMethodBeat.o(98718);
  }
  
  public void setType(int paramInt)
  {
    AppMethodBeat.i(98717);
    this.type = paramInt;
    if ((paramInt == 1) && (this.Ade.zOx != null)) {
      this.Ade.zOx.setVisibility(8);
    }
    if (this.Ade != null)
    {
      if ((this.Ade.Adt != null) && (this.Adl)) {
        this.Ade.Adt.setSnsType(paramInt);
      }
      if ((this.Ade.Adu != null) && (!this.Adl)) {
        this.Ade.Adu.setSnsType(paramInt);
      }
    }
    if (paramInt != 1)
    {
      if ((this.Ade.Adt != null) && (this.Ade.Adt.getParent() != null) && ((this.Ade.Adt.getParent() instanceof ViewGroup))) {
        ((ViewGroup)this.Ade.Adt.getParent()).removeView(this.Ade.Adt);
      }
      if ((this.Ade.Adu != null) && (this.Ade.Adu.getParent() != null) && ((this.Ade.Adu.getParent() instanceof ViewGroup))) {
        ((ViewGroup)this.Ade.Adu.getParent()).removeView(this.Ade.Adu);
      }
    }
    if (paramInt == 1)
    {
      this.Ade.Adw.setPadding(0, ar.dT(this.context) + ar.ej(this.context) - getResources().getDimensionPixelSize(2131166841), 0, aq.fromDPToPix(this.context, 10));
      AppMethodBeat.o(98717);
      return;
    }
    if (paramInt == 2) {
      this.Ade.Adw.setPadding(0, ar.dT(this.context) + ar.ej(this.context) + aq.fromDPToPix(getContext(), 90) + aq.fromDPToPix(getContext(), 48), 0, 0);
    }
    AppMethodBeat.o(98717);
  }
  
  public static abstract interface a
  {
    public abstract boolean An(long paramLong);
    
    public abstract boolean ebY();
  }
  
  public static abstract interface b {}
  
  final class c
  {
    ImageView Adp;
    ImageView Adq;
    LinearLayout Adr;
    LinearLayout Ads;
    AbsStoryHeaderTipView Adt;
    SnsStoryHeaderView Adu;
    RelativeLayout Adv;
    LinearLayout Adw;
    ImageView Adx;
    ImageView fRd;
    TextView nCw;
    TextView zOx;
    
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