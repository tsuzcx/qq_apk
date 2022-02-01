package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.bo;
import com.tencent.mm.plugin.sns.ui.listener.c;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.smiley.u;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.net.URLEncoder;
import org.json.JSONObject;

public final class n
  extends BaseTimeLineItem
{
  protected com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a QSf;
  private int QSg;
  protected SphereImageView.b QWi;
  protected ADXml.i RJS;
  protected a RNa;
  protected boolean RNb;
  protected boolean RNc;
  protected String RNd;
  protected a.d RNe;
  boolean RNf;
  protected MMHandler eqE;
  
  public n()
  {
    AppMethodBeat.i(100105);
    this.RNb = true;
    this.RNc = true;
    this.RNd = null;
    this.eqE = new MMHandler(Looper.getMainLooper());
    this.QSg = 0;
    this.RNe = new a.d()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString1, Bitmap paramAnonymousBitmap, String paramAnonymousString2)
      {
        AppMethodBeat.i(100095);
        Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "ImageLoader onFinish, isSucc=" + paramAnonymousBoolean + ", errInfo=" + paramAnonymousString1);
        if (n.this.RNa == null)
        {
          Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onFinish, mViewHolder==null");
          AppMethodBeat.o(100095);
          return;
        }
        if (n.this.RJS != null) {}
        for (paramAnonymousString1 = n.this.RJS.QHV; (paramAnonymousString2 != null) && (paramAnonymousString2.equals(paramAnonymousString1)); paramAnonymousString1 = "")
        {
          n.this.RNa.RNm.k(paramAnonymousBitmap, paramAnonymousString2);
          AppMethodBeat.o(100095);
          return;
        }
        Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onFinish, url != nowUrl");
        AppMethodBeat.o(100095);
      }
      
      public final void aNZ(String paramAnonymousString) {}
    };
    this.QWi = new SphereImageView.b()
    {
      public final void aZA(final String paramAnonymousString)
      {
        AppMethodBeat.i(100099);
        if (n.this.RJS != null) {}
        for (Object localObject = n.this.RJS.QHV; (paramAnonymousString != null) && (!paramAnonymousString.equals(localObject)); localObject = "")
        {
          Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onUpdateImage, url != CardInfo.sphereImageUrl, url=" + paramAnonymousString + ", info.url=" + (String)localObject);
          AppMethodBeat.o(100099);
          return;
        }
        localObject = n.this.RNa;
        if (localObject == null)
        {
          Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onUpdateImage, viewHolder==null");
          AppMethodBeat.o(100099);
          return;
        }
        Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onUpdateImage, isFirstUpdateImage=" + n.this.RNb + ", visiable=" + ((n.a)localObject).RNn.getVisibility());
        if (n.this.RNb)
        {
          if (((n.a)localObject).RNn.getVisibility() == 0)
          {
            AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
            localAlphaAnimation.setDuration(350L);
            localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
            {
              public final void onAnimationEnd(Animation paramAnonymous2Animation)
              {
                AppMethodBeat.i(100096);
                this.RNh.RNn.setVisibility(8);
                this.RNh.RNn.setImageDrawable(new ColorDrawable(this.RNh.RNn.getContext().getResources().getColor(b.c.BG_3)));
                AppMethodBeat.o(100096);
              }
              
              public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
              
              public final void onAnimationStart(Animation paramAnonymous2Animation) {}
            });
            Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "do maskImage anim");
            ((n.a)localObject).RNn.startAnimation(localAlphaAnimation);
          }
          if ((n.this.RJS == null) || (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.mz(n.this.RJS.QHV, "scene_timeline"))) {
            break label328;
          }
          Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "disable touch before shot");
          ((n.a)localObject).RNm.setTouchEnabled(false);
          ((n.a)localObject).RNm.hkt();
          ((n.a)localObject).RNm.QUV.requestRender();
          n.this.eqE.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(100097);
              String str;
              if (n.this.RJS != null)
              {
                str = n.this.RJS.QHV;
                if ((paramAnonymousString == null) || (!paramAnonymousString.equals(str))) {
                  break label158;
                }
                Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "do shot");
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.a(this.RNh.RNm, str, "scene_timeline");
                n.this.RNb = false;
              }
              for (;;)
              {
                Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "enable touch and sensor after shot, isInLowPriority=" + n.this.RNf);
                if (!n.this.RNf) {
                  this.RNh.RNm.setSensorEnabled(true);
                }
                this.RNh.RNm.setTouchEnabled(true);
                AppMethodBeat.o(100097);
                return;
                str = "";
                break;
                label158:
                Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "before do shot, url != CardInfo.sphereImageUrl, url=" + paramAnonymousString + ", info.url=" + str);
              }
            }
          }, 800L);
        }
        for (;;)
        {
          if (((n.a)localObject).RNo.getVisibility() == 0)
          {
            Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "hide progressView");
            ((n.a)localObject).RNo.setVisibility(8);
          }
          AppMethodBeat.o(100099);
          return;
          label328:
          Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "don't need shot, enable sensor, isInLowPriority=" + n.this.RNf);
          if (!n.this.RNf) {
            ((n.a)localObject).RNm.setSensorEnabled(true);
          }
          n.this.RNb = false;
        }
      }
      
      public final void hjD() {}
      
      public final void hjE() {}
      
      public final void hjF()
      {
        AppMethodBeat.i(100098);
        n.a(n.this);
        AppMethodBeat.o(100098);
      }
      
      public final void onDetachedFromWindow()
      {
        int i = 0;
        AppMethodBeat.i(100100);
        Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onDetachedFromWindow reset");
        n.this.RNb = true;
        n.this.RNc = true;
        n.this.RNd = null;
        n.this.eqE.removeCallbacksAndMessages(null);
        try
        {
          Object localObject = new JSONObject();
          ((JSONObject)localObject).put("panCount", n.b(n.this));
          ((JSONObject)localObject).put("type", 1);
          String str2 = URLEncoder.encode(((JSONObject)localObject).toString(), "UTF-8");
          SnsInfo localSnsInfo = n.this.QBJ.alF(n.this.RNa.position);
          String str1 = localSnsInfo.getAid();
          localObject = str1;
          if (str1 == null) {
            localObject = "";
          }
          h.OAn.b(17539, new Object[] { localSnsInfo.getTimeLine().Id, localObject, localSnsInfo.getAdInfo().uxInfo, Integer.valueOf(1), str2 });
          localObject = new StringBuilder("KVReport, id=17539, touchCount=").append(str2).append(", snsInfo.hash=");
          if (localSnsInfo != null) {
            i = localSnsInfo.hashCode();
          }
          Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", i);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "kvStat exp:" + localException.toString());
          }
        }
        n.c(n.this);
        AppMethodBeat.o(100100);
      }
    };
    this.RNf = false;
    AppMethodBeat.o(100105);
  }
  
  public final void a(SphereImageView paramSphereImageView, boolean paramBoolean)
  {
    AppMethodBeat.i(100108);
    Log.d("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "setIsInLowPriority, isInLowPriority=" + paramBoolean + ", hash=" + paramSphereImageView.hashCode());
    this.RNf = paramBoolean;
    if (paramBoolean)
    {
      paramSphereImageView.setSensorEnabled(false);
      AppMethodBeat.o(100108);
      return;
    }
    if (!this.RNb) {
      paramSphereImageView.setSensorEnabled(true);
    }
    AppMethodBeat.o(100108);
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bo parambo, final TimeLineObject paramTimeLineObject, int paramInt2, bn parambn)
  {
    AppMethodBeat.i(100107);
    try
    {
      l1 = System.currentTimeMillis();
      if (paramBaseViewHolder.mtE)
      {
        Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem, holder is busy");
        AppMethodBeat.o(100107);
        return;
      }
      locala = (a)paramBaseViewHolder;
      localObject1 = parambo.PJQ;
      if ((localObject1 == null) || (((SnsInfo)localObject1).getAdXml() == null)) {
        break label1512;
      }
      locali = ((SnsInfo)localObject1).getAdXml().adSphereCardInfo;
    }
    finally
    {
      for (;;)
      {
        long l1;
        final a locala;
        Object localObject1;
        Object localObject2;
        Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem exp=" + paramBaseViewHolder.toString());
        continue;
        Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "sphereCardInfo==null, invalid sphereCard");
        continue;
        ADXml.i locali = null;
        continue;
        paramInt1 = 0;
      }
    }
    this.RJS = locali;
    if ((Build.VERSION.SDK_INT < 24) && (locali != null) && ((this.RNd == null) || (!this.RNd.equals(locali.QHV))))
    {
      this.RNb = true;
      this.RNc = true;
      Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem, reset, sdk_int=" + Build.VERSION.SDK_INT);
    }
    localObject2 = new StringBuilder("ad fillItem, sphereCard, pos=").append(paramInt1).append(", snsId=");
    if (paramTimeLineObject == null)
    {
      paramTimeLineObject = "";
      paramTimeLineObject = ((StringBuilder)localObject2).append(paramTimeLineObject).append(", hash=").append(locala.RNm.hashCode()).append(", isFirst=").append(this.RNc).append(", snsInfo.hash=");
      if (localObject1 == null) {
        break label1518;
      }
      paramInt1 = localObject1.hashCode();
      Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", paramInt1);
      paramTimeLineObject = null;
      locala.GBf.setVisibility(8);
      locala.Qca.setVisibility(8);
      locala.Qcb.setVisibility(8);
      locala.QbY.setVisibility(8);
      locala.Qcc.setVisibility(8);
      locala.Qcd.setVisibility(8);
      locala.Qce.setVisibility(8);
      if (locali == null) {
        break label1501;
      }
      localObject2 = (WindowManager)this.mActivity.getSystemService("window");
      paramInt1 = Math.min(((WindowManager)localObject2).getDefaultDisplay().getWidth(), ((WindowManager)localObject2).getDefaultDisplay().getHeight()) - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 56) - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 14) - this.mActivity.getResources().getDimensionPixelSize(b.d.NormalPadding);
      if (locali.QHE != 0) {
        break label1171;
      }
      paramTimeLineObject = new ViewGroup.LayoutParams(-2, -2);
      paramTimeLineObject.width = paramInt1;
      paramTimeLineObject.height = ((int)(paramTimeLineObject.width * 0.75F));
      label428:
      if (paramTimeLineObject != null)
      {
        localObject2 = locala.Cxb.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = paramTimeLineObject.width;
        ((ViewGroup.LayoutParams)localObject2).height = paramTimeLineObject.height;
        locala.Cxb.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((RoundedCornerFrameLayout)locala.Cxb).setRadius(com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 8));
        localObject2 = locala.RNm.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = paramTimeLineObject.width;
        ((ViewGroup.LayoutParams)localObject2).height = paramTimeLineObject.height;
        locala.RNm.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        paramTimeLineObject = locala.RNn.getLayoutParams();
        paramTimeLineObject.width = ((ViewGroup.LayoutParams)localObject2).width;
        paramTimeLineObject.height = ((ViewGroup.LayoutParams)localObject2).height;
        locala.RNn.setLayoutParams(paramTimeLineObject);
      }
      if (locali.QHG != 0) {
        break label1212;
      }
      paramInt1 = Color.argb((int)(locali.QHF * 2.55F), 0, 0, 0);
      paramInt2 = Color.argb(0, 0, 0, 0);
      paramTimeLineObject = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { paramInt1, paramInt2 });
      paramTimeLineObject.setGradientType(0);
      locala.GBf.setBackground(paramTimeLineObject);
      if ((!Util.isNullOrNil(locali.title)) || (!Util.isNullOrNil(locali.description))) {
        locala.GBf.setVisibility(0);
      }
      if (!Util.isNullOrNil(locali.title))
      {
        locala.Qca.setVisibility(0);
        locala.Qca.setText(u.iVt().a(locala.Qca.getContext(), locali.title, locala.Qca.getTextSize()));
      }
      if (!Util.isNullOrNil(locali.description))
      {
        locala.Qcb.setVisibility(0);
        locala.Qcb.setText(u.iVt().a(locala.Qcb.getContext(), locali.description, locala.Qcb.getTextSize()));
      }
    }
    for (;;)
    {
      if ((localObject1 != null) && (((SnsInfo)localObject1).getAdInfo().isWeapp()))
      {
        paramInt1 = Color.argb((int)(locali.QHF * 2.55F), 0, 0, 0);
        paramInt2 = Color.argb(0, 0, 0, 0);
        paramTimeLineObject = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { paramInt1, paramInt2 });
        paramTimeLineObject.setGradientType(0);
        locala.QbY.setVisibility(0);
        locala.QbY.setBackground(paramTimeLineObject);
        locala.Qce.setVisibility(0);
      }
      if (this.RNc)
      {
        locala.RNn.setVisibility(0);
        paramTimeLineObject = locali.QHV;
        localObject1 = locali.QHW;
        new a.c(paramTimeLineObject, (String)localObject1, "scene_timeline", new a.d()
        {
          public final void a(boolean paramAnonymousBoolean, String paramAnonymousString1, Bitmap paramAnonymousBitmap, String paramAnonymousString2)
          {
            AppMethodBeat.i(100104);
            if ((paramAnonymousString2 == null) || (!paramAnonymousString2.equals(paramTimeLineObject)))
            {
              AppMethodBeat.o(100104);
              return;
            }
            if (paramAnonymousBitmap != null)
            {
              locala.RNn.setImageBitmap(paramAnonymousBitmap);
              AppMethodBeat.o(100104);
              return;
            }
            Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "show progressView");
            locala.RNo.setVisibility(0);
            locala.RNo.jEN();
            if (!TextUtils.isEmpty(this.oHF))
            {
              Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "no shot and thumb cache, start download thumb image");
              k.b("adId", this.oHF, new g.a()
              {
                String RNk;
                
                /* Error */
                public final void aWn(String paramAnonymous2String)
                {
                  // Byte code:
                  //   0: ldc 41
                  //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
                  //   5: ldc 43
                  //   7: ldc 45
                  //   9: aload_1
                  //   10: invokestatic 51	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
                  //   13: invokevirtual 55	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
                  //   16: invokestatic 60	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
                  //   19: aload_0
                  //   20: getfield 19	com/tencent/mm/plugin/sns/ui/item/n$4$1:RNl	Lcom/tencent/mm/plugin/sns/ui/item/n$4;
                  //   23: getfield 64	com/tencent/mm/plugin/sns/ui/item/n$4:RNi	Lcom/tencent/mm/plugin/sns/ui/item/n;
                  //   26: getfield 70	com/tencent/mm/plugin/sns/ui/item/n:RJS	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
                  //   29: ifnull +76 -> 105
                  //   32: aload_0
                  //   33: getfield 19	com/tencent/mm/plugin/sns/ui/item/n$4$1:RNl	Lcom/tencent/mm/plugin/sns/ui/item/n$4;
                  //   36: getfield 64	com/tencent/mm/plugin/sns/ui/item/n$4:RNi	Lcom/tencent/mm/plugin/sns/ui/item/n;
                  //   39: getfield 70	com/tencent/mm/plugin/sns/ui/item/n:RJS	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
                  //   42: getfield 75	com/tencent/mm/plugin/sns/storage/ADXml$i:QHW	Ljava/lang/String;
                  //   45: astore_2
                  //   46: aload_0
                  //   47: getfield 34	com/tencent/mm/plugin/sns/ui/item/n$4$1:RNk	Ljava/lang/String;
                  //   50: ifnull +92 -> 142
                  //   53: aload_0
                  //   54: getfield 34	com/tencent/mm/plugin/sns/ui/item/n$4$1:RNk	Ljava/lang/String;
                  //   57: aload_2
                  //   58: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
                  //   61: ifeq +81 -> 142
                  //   64: aload_0
                  //   65: getfield 19	com/tencent/mm/plugin/sns/ui/item/n$4$1:RNl	Lcom/tencent/mm/plugin/sns/ui/item/n$4;
                  //   68: getfield 83	com/tencent/mm/plugin/sns/ui/item/n$4:RNh	Lcom/tencent/mm/plugin/sns/ui/item/n$a;
                  //   71: getfield 89	com/tencent/mm/plugin/sns/ui/item/n$a:RNn	Landroid/widget/ImageView;
                  //   74: invokevirtual 95	android/widget/ImageView:getVisibility	()I
                  //   77: ifne +72 -> 149
                  //   80: aload_1
                  //   81: invokestatic 101	com/tencent/mm/graphics/MMBitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
                  //   84: astore_1
                  //   85: aload_0
                  //   86: getfield 19	com/tencent/mm/plugin/sns/ui/item/n$4$1:RNl	Lcom/tencent/mm/plugin/sns/ui/item/n$4;
                  //   89: getfield 83	com/tencent/mm/plugin/sns/ui/item/n$4:RNh	Lcom/tencent/mm/plugin/sns/ui/item/n$a;
                  //   92: getfield 89	com/tencent/mm/plugin/sns/ui/item/n$a:RNn	Landroid/widget/ImageView;
                  //   95: aload_1
                  //   96: invokevirtual 105	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
                  //   99: ldc 41
                  //   101: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
                  //   104: return
                  //   105: ldc 107
                  //   107: astore_2
                  //   108: goto -62 -> 46
                  //   111: astore_1
                  //   112: ldc 43
                  //   114: new 109	java/lang/StringBuilder
                  //   117: dup
                  //   118: ldc 111
                  //   120: invokespecial 113	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
                  //   123: aload_1
                  //   124: invokevirtual 119	java/lang/Throwable:toString	()Ljava/lang/String;
                  //   127: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
                  //   130: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
                  //   133: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
                  //   136: ldc 41
                  //   138: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
                  //   141: return
                  //   142: ldc 43
                  //   144: ldc 129
                  //   146: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
                  //   149: ldc 41
                  //   151: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
                  //   154: return
                  // Local variable table:
                  //   start	length	slot	name	signature
                  //   0	155	0	this	1
                  //   0	155	1	paramAnonymous2String	String
                  //   45	63	2	str	String
                  // Exception table:
                  //   from	to	target	type
                  //   80	99	111	finally
                }
                
                public final void gZM() {}
                
                public final void gZN()
                {
                  AppMethodBeat.i(100102);
                  Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onDownloadError thumb");
                  AppMethodBeat.o(100102);
                }
              });
              AppMethodBeat.o(100104);
              return;
            }
            Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "thumbUrl is empty");
            AppMethodBeat.o(100104);
          }
          
          public final void aNZ(String paramAnonymousString) {}
        }).execute(new Void[0]);
      }
      locala.RNm.setVisibility(0);
      locala.RNm.setOnClickListener(parambn.QBf.RQG);
      locala.RNm.setTag(paramBaseViewHolder);
      if ((!this.RNb) && (!this.RNf))
      {
        Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem !first, enable sensor");
        locala.RNm.setSensorEnabled(true);
      }
      if ((this.RNd == null) || (!this.RNd.equals(locali.QHV)))
      {
        Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem, loadImage, hash=" + locala.RNm.hashCode());
        paramBaseViewHolder = locala.RNm.getLayoutParams();
        this.QSf.n(locali.QHV, paramBaseViewHolder.width, paramBaseViewHolder.height, "scene_timeline");
        this.RNd = locali.QHV;
      }
      this.RNc = false;
      long l2 = System.currentTimeMillis();
      Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem total timeCost=" + (l2 - l1));
      a(parambo, 3);
      AppMethodBeat.o(100107);
      return;
      paramTimeLineObject = paramTimeLineObject.Id;
      break;
      label1171:
      if (locali.QHE != 1) {
        break label428;
      }
      paramTimeLineObject = new ViewGroup.LayoutParams(-2, -2);
      paramTimeLineObject.width = paramInt1;
      paramTimeLineObject.height = paramTimeLineObject.width;
      break label428;
      label1212:
      if (locali.QHG == 1)
      {
        paramInt1 = Color.argb((int)(locali.QHF * 2.55F), 0, 0, 0);
        paramInt2 = Color.argb(0, 0, 0, 0);
        paramTimeLineObject = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { paramInt1, paramInt2 });
        paramTimeLineObject.setGradientType(0);
        locala.QbY.setBackground(paramTimeLineObject);
        if ((!Util.isNullOrNil(locali.title)) || (!Util.isNullOrNil(locali.description)))
        {
          locala.QbY.setVisibility(0);
          paramTimeLineObject = (RelativeLayout.LayoutParams)locala.Qce.getLayoutParams();
          paramTimeLineObject.topMargin = com.tencent.mm.cd.a.fromDPToPix(locala.Cxb.getContext(), 4);
          locala.Qce.setLayoutParams(paramTimeLineObject);
        }
        if (!Util.isNullOrNil(locali.title))
        {
          locala.Qcc.setVisibility(0);
          locala.Qcc.setText(u.iVt().a(locala.Qcc.getContext(), locali.title, locala.Qcc.getTextSize()));
        }
        if (!Util.isNullOrNil(locali.description))
        {
          locala.Qcd.setVisibility(0);
          locala.Qcd.setText(u.iVt().a(locala.Qcd.getContext(), locali.description, locala.Qcd.getTextSize()));
        }
      }
    }
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100106);
    for (;;)
    {
      try
      {
        final a locala = (a)paramBaseViewHolder;
        this.RNa = locala;
        Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "buildContent, holder=" + paramBaseViewHolder.hashCode());
        if (paramBaseViewHolder.RKG != null)
        {
          paramBaseViewHolder.RKG.setLayoutResource(b.g.sns_timeline_ad_sphere_card);
          if (!paramBaseViewHolder.RKH)
          {
            locala.Cxb = paramBaseViewHolder.RKG.inflate();
            paramBaseViewHolder.RKH = true;
          }
          locala.GBf = locala.convertView.findViewById(b.f.top_layer);
          locala.QbY = locala.convertView.findViewById(b.f.bottom_layer);
          locala.Qca = ((TextView)locala.convertView.findViewById(b.f.top_layer_title));
          locala.Qcb = ((TextView)locala.convertView.findViewById(b.f.top_layer_desc));
          locala.Qcc = ((TextView)locala.convertView.findViewById(b.f.bottom_layer_title));
          locala.Qcd = ((TextView)locala.convertView.findViewById(b.f.bottom_layer_desc));
          locala.RNm = ((SphereImageView)locala.convertView.findViewById(b.f.sphere_card_img));
          locala.Qce = locala.convertView.findViewById(b.f.bottom_mini_program);
          locala.RNn = ((ImageView)locala.convertView.findViewById(b.f.mask_img));
          locala.RNo = ((MMPinProgressBtn)locala.convertView.findViewById(b.f.progress));
          locala.RNo.setMax(50);
          float f1 = m.akn(b.d.sns_ad_fullcard_title_font_size);
          float f2 = m.akn(b.d.sns_ad_fullcard_desc_font_size);
          locala.Qca.setTextSize(0, f1);
          locala.Qcb.setTextSize(0, f2);
          locala.Qcc.setTextSize(0, f1);
          locala.Qcd.setTextSize(0, f2);
          Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "buildContent, disable touch and sensor");
          locala.RNm.setTouchEnabled(false);
          locala.RNm.setSensorEnabled(false);
          locala.RNm.aV(1.8F, -2.0F);
          locala.RNm.setTouchSensitivity(0.45F);
          locala.RNm.setEventListener(this.QWi);
          locala.RNm.setOnlyHorizontalScroll(true);
          this.QSf = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a();
          this.QSf.a(this.RNe);
          if (this.RJS == null)
          {
            i = 0;
            this.eqE.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(100094);
                Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "enable touch, delay=" + i);
                locala.RNm.setTouchEnabled(true);
                AppMethodBeat.o(100094);
              }
            }, i);
            Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "viewHash=" + locala.RNm.hashCode() + ", touchDelay=" + i);
            AppMethodBeat.o(100106);
          }
        }
        else
        {
          if (paramBaseViewHolder.RKH) {
            continue;
          }
          locala.Cxb = paramBaseViewHolder.convertView.findViewById(b.f.sphere_card_container);
          paramBaseViewHolder.RKH = true;
          continue;
        }
        final int i = this.RJS.QHU;
      }
      finally
      {
        Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "buildContent exp=" + paramBaseViewHolder.toString());
        AppMethodBeat.o(100106);
        return;
      }
    }
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    public View Cxb;
    public View GBf;
    public View QbY;
    public TextView Qca;
    public TextView Qcb;
    public TextView Qcc;
    public TextView Qcd;
    public View Qce;
    public SphereImageView RNm;
    public ImageView RNn;
    public MMPinProgressBtn RNo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.n
 * JD-Core Version:    0.7.0.1
 */