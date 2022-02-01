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
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView.2;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView.a;
import com.tencent.mm.plugin.story.api.AbsStoryHeaderTipView;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.j;
import com.tencent.mm.plugin.story.api.l.c;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.bpj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.y;
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
  Context context;
  boolean diE;
  private Dialog dialog;
  String fki;
  private String sessionId;
  private int type;
  String userName;
  private String wQb;
  Animation xnW;
  c xyT;
  private a xyU;
  private b xyV;
  private boolean xyW;
  private Map<Integer, View> xyX;
  private String xyY;
  Bitmap xyZ;
  boolean xza;
  
  public SnsHeader(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(98715);
    this.xyW = false;
    this.diE = false;
    this.xyX = new HashMap();
    this.xyY = "";
    this.xyZ = null;
    this.xnW = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    this.xza = false;
    init(paramContext);
    AppMethodBeat.o(98715);
  }
  
  public SnsHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98716);
    this.xyW = false;
    this.diE = false;
    this.xyX = new HashMap();
    this.xyY = "";
    this.xyZ = null;
    this.xnW = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    this.xza = false;
    init(paramContext);
    AppMethodBeat.o(98716);
  }
  
  private void init(final Context paramContext)
  {
    AppMethodBeat.i(98721);
    this.context = paramContext;
    g.afC();
    this.xza = ((e)g.ad(e.class)).getStoryNewFeatureConfig().dGh();
    Object localObject = y.js(paramContext).inflate(2131495552, this, true);
    FrameLayout localFrameLayout = (FrameLayout)((View)localObject).findViewById(2131305057);
    this.xyT = new c();
    this.xyT.mzY = ((TextView)((View)localObject).findViewById(2131302867));
    this.xyT.fuj = ((ImageView)((View)localObject).findViewById(2131297008));
    this.xyT.xkt = ((TextView)((View)localObject).findViewById(2131304821));
    this.xyT.xzf = ((ImageView)((View)localObject).findViewById(2131304937));
    this.xyT.xzg = ((ImageView)((View)localObject).findViewById(2131304938));
    this.xyT.xzh = ((LinearLayout)((View)localObject).findViewById(2131304613));
    this.xyT.xzi = ((LinearLayout)((View)localObject).findViewById(2131304976));
    this.xyT.xzl = ((RelativeLayout)((View)localObject).findViewById(2131304981));
    this.xyT.xzm = ((LinearLayout)((View)localObject).findViewById(2131304982));
    this.xyT.xzn = ((ImageView)((View)localObject).findViewById(2131307247));
    this.xnW.setDuration(1000L);
    this.xnW.setRepeatCount(-1);
    localObject = new LinearInterpolator();
    this.xnW.setInterpolator((Interpolator)localObject);
    localObject = this.xyT;
    g.afC();
    ((c)localObject).xzj = ((e)g.ad(e.class)).getStoryUIFactory().gd(paramContext);
    this.xyT.xzk = new SnsStoryHeaderView(paramContext);
    if (this.xza)
    {
      localFrameLayout.addView(this.xyT.xzj);
      this.xyT.xzj.onCreateView();
    }
    for (;;)
    {
      this.xyT.xzf.setContentDescription(paramContext.getString(2131763783));
      this.xyT.xzf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(98712);
          ad.d("MicroMsg.SnsHeader", "change backGround");
          if ((SnsHeader.a(SnsHeader.this) != null) && (SnsHeader.a(SnsHeader.this).isShowing()))
          {
            AppMethodBeat.o(98712);
            return;
          }
          if (SnsHeader.b(SnsHeader.this) != null) {
            SnsHeader.b(SnsHeader.this).dBk();
          }
          if (SnsHeader.c(SnsHeader.this) == 1) {}
          final long l;
          for (paramAnonymousView = SnsHeader.d(SnsHeader.this);; paramAnonymousView = SnsHeader.e(SnsHeader.this))
          {
            paramAnonymousView = af.dty().apP(paramAnonymousView);
            l = paramAnonymousView.field_snsBgId;
            if ((SnsHeader.f(SnsHeader.this)) || (l != 0L)) {
              break;
            }
            AppMethodBeat.o(98712);
            return;
          }
          SnsHeader.a(SnsHeader.this, paramAnonymousView.dxN());
          String str;
          if ((SnsHeader.c(SnsHeader.this) == 1) || (SnsHeader.d(SnsHeader.this).trim().equals(SnsHeader.e(SnsHeader.this).trim())))
          {
            paramAnonymousView = new String[1];
            paramAnonymousView[0] = paramContext.getString(2131764047);
            SnsHeader.a(SnsHeader.this, false);
            if (!SnsHeader.g(SnsHeader.this)) {
              break label319;
            }
            str = paramContext.getString(2131763965);
            label225:
            if (!SnsHeader.g(SnsHeader.this)) {
              break label326;
            }
            paramContext.getString(2131755835);
          }
          for (;;)
          {
            SnsHeader.a(SnsHeader.this, h.a(SnsHeader.this.getContext(), str, paramAnonymousView, new h.c()
            {
              public final void kM(int paramAnonymous2Int)
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
            label319:
            str = "";
            break label225;
            label326:
            paramContext.getString(2131755691);
          }
        }
      });
      this.xyT.fuj.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          int i = 1;
          AppMethodBeat.i(98713);
          paramAnonymousView = af.dti().aHY(SnsHeader.e(SnsHeader.this));
          if ((paramAnonymousView != null) && ((b.ls(paramAnonymousView.field_type)) || (SnsHeader.f(SnsHeader.this))))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("Contact_User", SnsHeader.e(SnsHeader.this));
            if ((SnsHeader.e(SnsHeader.this) != null) && (SnsHeader.e(SnsHeader.this).length() > 0))
            {
              if (SnsHeader.c(SnsHeader.this) == 1) {
                i = 6;
              }
              paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", i);
              com.tencent.mm.plugin.sns.d.a.hYt.c(paramAnonymousView, paramContext);
            }
            AppMethodBeat.o(98713);
            return;
          }
          paramAnonymousView = ((Activity)paramContext).getIntent();
          paramAnonymousView.putExtra("Contact_User", SnsHeader.e(SnsHeader.this));
          com.tencent.mm.plugin.sns.d.a.hYt.c(paramAnonymousView, paramContext);
          AppMethodBeat.o(98713);
        }
      });
      AppMethodBeat.o(98721);
      return;
      localFrameLayout.addView(this.xyT.xzk);
      this.xyT.xzk.setSessionId(this.sessionId);
      this.xyT.xzk.setEnterObjectId(this.wQb);
    }
  }
  
  public final void dBi()
  {
    AppMethodBeat.i(98723);
    String str1 = this.userName;
    if (this.type == 1) {
      str1 = this.fki;
    }
    Object localObject1 = af.getAccSnsPath();
    ad.d("MicroMsg.SnsHeader", "MagicAsyncTask ".concat(String.valueOf(str1)));
    com.tencent.mm.plugin.sns.storage.n localn = af.dty().apP(str1);
    String str2 = localn.field_bgId;
    Object localObject3 = localn.field_older_bgId;
    ad.d("MicroMsg.SnsHeader", "showName " + str1 + " get bgId : " + str2 + "  olderBgId：　" + (String)localObject3);
    localObject3 = com.tencent.mm.plugin.sns.data.q.anC(str2);
    String str6 = str1 + "bg_";
    String str3 = str1 + "tbg_";
    String str4 = an.iF((String)localObject1, str1);
    i.aMF(str4);
    int i;
    String str5;
    if ((localn.field_local_flag & 0x1) > 0)
    {
      i = 1;
      if (i != 0)
      {
        ad.d("MicroMsg.SnsHeader", "bg is change");
        af.dty().apO(str1);
        if (i.eK(an.iF((String)localObject1, str1) + str6))
        {
          i.deleteFile(an.iF((String)localObject1, str1) + str3);
          i.aQ(an.iF((String)localObject1, str1), str6, str3);
        }
        localn.field_local_flag &= 0xFFFFFFFE;
        af.dty().c(localn);
      }
      if ((i.eK(an.iF(af.getAccSnsPath(), str2) + (String)localObject3)) && (!i.eK(an.iF((String)localObject1, str1) + str6)))
      {
        i.lC(an.iF((String)localObject1, str2) + (String)localObject3, an.iF((String)localObject1, str1) + str6);
        ad.d("MicroMsg.SnsHeader", "nwer id Name update");
      }
      str5 = localn.field_bgUrl;
      if (str2 == null) {
        break label780;
      }
      af.dtr();
      localObject1 = str4 + str6;
      this.context.hashCode();
      localObject3 = com.tencent.mm.plugin.sns.model.f.a((String)localObject1, str5, str2, true, bc.FzF);
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
          af.dtr();
          localObject1 = str4 + str3;
          this.context.hashCode();
          localObject3 = com.tencent.mm.plugin.sns.model.f.a((String)localObject1, str5, str2, false, bc.FzF);
        }
      }
      if (this.xyT.xzf != null)
      {
        this.xyT.xzf.setImageBitmap((Bitmap)localObject3);
        if (localObject3 == null) {
          break label691;
        }
        this.xyT.xzf.setBackgroundDrawable(null);
      }
      for (;;)
      {
        this.xyT.xzh.setVisibility(8);
        if ((localObject3 == null) && ((this.type == 1) || (this.fki.equals(str1)))) {
          this.xyT.xzh.setVisibility(0);
        }
        this.xyW = localn.dxN();
        AppMethodBeat.o(98723);
        return;
        i = 0;
        break;
        try
        {
          if ((this.xyZ == null) || (this.xyZ.isRecycled()))
          {
            ad.i("MicroMsg.SnsHeader", "decode bitmap by self");
            this.xyZ = com.tencent.mm.sdk.platformtools.f.decodeStream(this.context.getAssets().open("resource/friendactivity_mycover_bg.jpg"));
          }
          localObject1 = new BitmapDrawable(this.xyZ);
          this.xyT.xzf.setBackgroundDrawable((Drawable)localObject1);
        }
        catch (IOException localIOException)
        {
          ad.printErrStackTrace("MicroMsg.SnsHeader", localIOException, "", new Object[0]);
        }
      }
    }
  }
  
  public final boolean dBj()
  {
    AppMethodBeat.i(98724);
    if (this.xyT.xzi == null)
    {
      AppMethodBeat.o(98724);
      return false;
    }
    Object localObject = aj.dtQ();
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
        bool = ((bpj)new bpj().parseFrom(localp1.field_postBuf)).DNE;
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
        bool = ((bpj)new bpj().parseFrom(localp1.field_postBuf)).DNE;
        if (!bool) {
          break;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localObject = (String)localObject + ((p)localLinkedList.get(i)).dxX() + " ";
        }
      }
      i += 1;
    }
    label224:
    ad.i("MicroMsg.SnsHeader", "refreshError %s %s %s", new Object[] { Integer.valueOf(localLinkedList.size()), localObject, this.xyY });
    if (((String)localObject).equals(this.xyY))
    {
      if (localLinkedList.size() > 0)
      {
        AppMethodBeat.o(98724);
        return true;
      }
      AppMethodBeat.o(98724);
      return false;
    }
    this.xyY = ((String)localObject);
    this.xyT.xzi.removeAllViews();
    localObject = this.xyT.xzi;
    label358:
    int j;
    final int k;
    label442:
    TextView localTextView;
    if (localLinkedList.size() > 0)
    {
      i = 0;
      ((LinearLayout)localObject).setVisibility(i);
      Collections.sort(localLinkedList, new d());
      i = 0;
      if (i >= localLinkedList.size()) {
        break label612;
      }
      j = ((p)localLinkedList.get(i)).xiB;
      k = localLinkedList.size();
      if ((!this.xyX.containsKey(Integer.valueOf(j))) || (this.xyX.get(Integer.valueOf(j)) == null)) {
        break label541;
      }
      localObject = (View)this.xyX.get(Integer.valueOf(j));
      localObject = (LinearLayout)localObject;
      ((LinearLayout)localObject).getChildAt(0).setTag(((p)localLinkedList.get(i)).dxX());
      p localp2 = (p)localLinkedList.get(i);
      localTextView = (TextView)((LinearLayout)localObject).findViewById(2131305032);
      if (localp2.field_type != 15) {
        break label598;
      }
      localTextView.setText(2131763947);
    }
    for (;;)
    {
      this.xyT.xzi.addView((View)localObject);
      i += 1;
      break label358;
      i = 8;
      break;
      label541:
      localObject = (LinearLayout)y.js(this.context).inflate(2131494434, null);
      ((LinearLayout)localObject).getChildAt(0).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(98714);
          if ((paramAnonymousView.getTag() instanceof String))
          {
            Object localObject2 = (String)paramAnonymousView.getTag();
            ad.i("MicroMsg.SnsHeader", "sns Header localId ".concat(String.valueOf(localObject2)));
            paramAnonymousView = af.dtu().apK((String)localObject2);
            if ((SnsHeader.h(SnsHeader.this) != null) && (paramAnonymousView != null))
            {
              Object localObject1 = new Intent();
              ((Intent)localObject1).setClass(SnsHeader.h(SnsHeader.this), SnsCommentDetailUI.class);
              if ((paramAnonymousView == null) || (paramAnonymousView.field_userName == null) || (paramAnonymousView.field_userName.equals("")))
              {
                ad.i("MicroMsg.SnsHeader", "error cntinfo or username is null");
                AppMethodBeat.o(98714);
                return;
              }
              ((Intent)localObject1).putExtra("INTENT_TALKER", paramAnonymousView.field_userName);
              ((Intent)localObject1).putExtra("INTENT_SNS_LOCAL_ID", (String)localObject2);
              ((Intent)localObject1).putExtra("INTENT_FROMGALLERY", true);
              localObject2 = d.oE(726);
              ((d)localObject2).oH(k).oH(i).oH(paramAnonymousView.field_createTime);
              ((d)localObject2).aBj();
              localObject2 = SnsHeader.h(SnsHeader.this);
              localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
              com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/plugin/sns/ui/SnsHeader$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/sns/ui/SnsHeader$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              try
              {
                localObject1 = (bpj)new bpj().parseFrom(paramAnonymousView.field_postBuf);
                if ((((bpj)localObject1).DNw == 201) || (((bpj)localObject1).DNw == 210) || (((bpj)localObject1).DNw != 211))
                {
                  ((bpj)localObject1).DNE = true;
                  paramAnonymousView.field_postBuf = ((bpj)localObject1).toByteArray();
                  af.dtu().b(paramAnonymousView.xiB, paramAnonymousView);
                }
                AppMethodBeat.o(98714);
                return;
              }
              catch (Exception paramAnonymousView) {}
            }
          }
          AppMethodBeat.o(98714);
        }
      });
      this.xyX.put(Integer.valueOf(j), localObject);
      break label442;
      label598:
      localTextView.setTag(Integer.valueOf(2131763942));
    }
    label612:
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
    AppMethodBeat.i(187698);
    int j = 0;
    int i = j;
    if (this.xyT != null)
    {
      i = j;
      if (this.xyT.xzm != null) {
        i = this.xyT.xzm.getHeight() + ao.fromDPToPix(getContext(), 32);
      }
    }
    AppMethodBeat.o(187698);
    return i;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(98725);
    if ((this.xyT != null) && (this.xyT.xzj != null) && (this.xza)) {
      this.xyT.xzj.dFV();
    }
    if ((this.xyT != null) && (this.xyT.xzk != null) && (!this.xza))
    {
      SnsStoryHeaderView localSnsStoryHeaderView = this.xyT.xzk;
      ad.i("MicroMsg.SnsStoryHeaderView", "resume: ");
      localSnsStoryHeaderView.dkt = false;
      ((e)g.ad(e.class)).getContactFetcher().dGp();
      localSnsStoryHeaderView.post(new SnsStoryHeaderView.2(localSnsStoryHeaderView));
    }
    AppMethodBeat.o(98725);
  }
  
  public void setAvatarOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(98722);
    if ((this.xyT != null) && (this.xyT.fuj != null)) {
      this.xyT.fuj.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(98722);
  }
  
  public void setBackClickListener(a parama)
  {
    this.xyU = parama;
  }
  
  public void setEnterObjectId(String paramString)
  {
    AppMethodBeat.i(98720);
    this.wQb = paramString;
    if ((this.xyT != null) && (this.xyT.xzk != null) && (!this.xza)) {
      this.xyT.xzk.setEnterObjectId(paramString);
    }
    AppMethodBeat.o(98720);
  }
  
  public void setHeadBgListener(b paramb)
  {
    this.xyV = paramb;
  }
  
  public void setSessionId(String paramString)
  {
    AppMethodBeat.i(98719);
    this.sessionId = paramString;
    if ((this.xyT != null) && (this.xyT.xzk != null) && (!this.xza)) {
      this.xyT.xzk.setSessionId(paramString);
    }
    AppMethodBeat.o(98719);
  }
  
  public void setStoryAction(SnsStoryHeaderView.a parama)
  {
    AppMethodBeat.i(98718);
    if ((this.xyT != null) && (this.xyT.xzk != null) && (!this.xza)) {
      this.xyT.xzk.setStoryAction(parama);
    }
    AppMethodBeat.o(98718);
  }
  
  public void setType(int paramInt)
  {
    AppMethodBeat.i(98717);
    this.type = paramInt;
    if ((paramInt == 1) && (this.xyT.xkt != null)) {
      this.xyT.xkt.setVisibility(8);
    }
    if (this.xyT != null)
    {
      if ((this.xyT.xzj != null) && (this.xza)) {
        this.xyT.xzj.setSnsType(paramInt);
      }
      if ((this.xyT.xzk != null) && (!this.xza)) {
        this.xyT.xzk.setSnsType(paramInt);
      }
    }
    if (paramInt != 1)
    {
      if ((this.xyT.xzj != null) && (this.xyT.xzj.getParent() != null) && ((this.xyT.xzj.getParent() instanceof ViewGroup))) {
        ((ViewGroup)this.xyT.xzj.getParent()).removeView(this.xyT.xzj);
      }
      if ((this.xyT.xzk != null) && (this.xyT.xzk.getParent() != null) && ((this.xyT.xzk.getParent() instanceof ViewGroup))) {
        ((ViewGroup)this.xyT.xzk.getParent()).removeView(this.xyT.xzk);
      }
    }
    if (paramInt == 1)
    {
      this.xyT.xzm.setPadding(0, ap.dL(this.context) + ap.eb(this.context) - getResources().getDimensionPixelSize(2131166841), 0, ao.fromDPToPix(this.context, 10));
      AppMethodBeat.o(98717);
      return;
    }
    if (paramInt == 2) {
      this.xyT.xzm.setPadding(0, ap.dL(this.context) + ap.eb(this.context) + ao.fromDPToPix(getContext(), 90) + ao.fromDPToPix(getContext(), 48), 0, 0);
    }
    AppMethodBeat.o(98717);
  }
  
  public static abstract interface a
  {
    public abstract boolean dBk();
    
    public abstract boolean tm(long paramLong);
  }
  
  public static abstract interface b {}
  
  final class c
  {
    ImageView fuj;
    TextView mzY;
    TextView xkt;
    ImageView xzf;
    ImageView xzg;
    LinearLayout xzh;
    LinearLayout xzi;
    AbsStoryHeaderTipView xzj;
    SnsStoryHeaderView xzk;
    RelativeLayout xzl;
    LinearLayout xzm;
    ImageView xzn;
    
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