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
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.bm;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.net.URLEncoder;
import org.json.JSONObject;

public final class p
  extends BaseTimeLineItem
{
  protected com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a KtF;
  private int KtG;
  protected SphereImageView.b KxA;
  protected ADXml.i Lke;
  protected String LnA;
  protected a.d LnB;
  boolean LnC;
  protected a Lnx;
  protected boolean Lny;
  protected boolean Lnz;
  protected MMHandler cyl;
  
  public p()
  {
    AppMethodBeat.i(100105);
    this.Lny = true;
    this.Lnz = true;
    this.LnA = null;
    this.cyl = new MMHandler(Looper.getMainLooper());
    this.KtG = 0;
    this.LnB = new a.d()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString1, Bitmap paramAnonymousBitmap, String paramAnonymousString2)
      {
        AppMethodBeat.i(100095);
        Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "ImageLoader onFinish, isSucc=" + paramAnonymousBoolean + ", errInfo=" + paramAnonymousString1);
        if (p.this.Lnx == null)
        {
          Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onFinish, mViewHolder==null");
          AppMethodBeat.o(100095);
          return;
        }
        if (p.this.Lke != null) {}
        for (paramAnonymousString1 = p.this.Lke.KjX; (paramAnonymousString2 != null) && (paramAnonymousString2.equals(paramAnonymousString1)); paramAnonymousString1 = "")
        {
          p.this.Lnx.LnJ.g(paramAnonymousBitmap, paramAnonymousString2);
          AppMethodBeat.o(100095);
          return;
        }
        Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onFinish, url != nowUrl");
        AppMethodBeat.o(100095);
      }
      
      public final void aRh(String paramAnonymousString) {}
    };
    this.KxA = new SphereImageView.b()
    {
      public final void baZ(final String paramAnonymousString)
      {
        AppMethodBeat.i(100099);
        if (p.this.Lke != null) {}
        for (Object localObject = p.this.Lke.KjX; (paramAnonymousString != null) && (!paramAnonymousString.equals(localObject)); localObject = "")
        {
          Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onUpdateImage, url != CardInfo.sphereImageUrl, url=" + paramAnonymousString + ", info.url=" + (String)localObject);
          AppMethodBeat.o(100099);
          return;
        }
        localObject = p.this.Lnx;
        if (localObject == null)
        {
          Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onUpdateImage, viewHolder==null");
          AppMethodBeat.o(100099);
          return;
        }
        Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onUpdateImage, isFirstUpdateImage=" + p.this.Lny + ", visiable=" + ((p.a)localObject).LnK.getVisibility());
        if (p.this.Lny)
        {
          if (((p.a)localObject).LnK.getVisibility() == 0)
          {
            AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
            localAlphaAnimation.setDuration(350L);
            localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
            {
              public final void onAnimationEnd(Animation paramAnonymous2Animation)
              {
                AppMethodBeat.i(100096);
                this.LnE.LnK.setVisibility(8);
                this.LnE.LnK.setImageDrawable(new ColorDrawable(this.LnE.LnK.getContext().getResources().getColor(i.c.BG_3)));
                AppMethodBeat.o(100096);
              }
              
              public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
              
              public final void onAnimationStart(Animation paramAnonymous2Animation) {}
            });
            Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "do maskImage anim");
            ((p.a)localObject).LnK.startAnimation(localAlphaAnimation);
          }
          if ((p.this.Lke == null) || (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.kS(p.this.Lke.KjX, "scene_timeline"))) {
            break label328;
          }
          Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "disable touch before shot");
          ((p.a)localObject).LnJ.setTouchEnabled(false);
          ((p.a)localObject).LnJ.fSo();
          ((p.a)localObject).LnJ.Kwm.requestRender();
          p.this.cyl.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(100097);
              String str;
              if (p.this.Lke != null)
              {
                str = p.this.Lke.KjX;
                if ((paramAnonymousString == null) || (!paramAnonymousString.equals(str))) {
                  break label158;
                }
                Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "do shot");
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.a(this.LnE.LnJ, str, "scene_timeline");
                p.this.Lny = false;
              }
              for (;;)
              {
                Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "enable touch and sensor after shot, isInLowPriority=" + p.this.LnC);
                if (!p.this.LnC) {
                  this.LnE.LnJ.setSensorEnabled(true);
                }
                this.LnE.LnJ.setTouchEnabled(true);
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
          if (((p.a)localObject).LnL.getVisibility() == 0)
          {
            Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "hide progressView");
            ((p.a)localObject).LnL.setVisibility(8);
          }
          AppMethodBeat.o(100099);
          return;
          label328:
          Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "don't need shot, enable sensor, isInLowPriority=" + p.this.LnC);
          if (!p.this.LnC) {
            ((p.a)localObject).LnJ.setSensorEnabled(true);
          }
          p.this.Lny = false;
        }
      }
      
      public final void fRD() {}
      
      public final void fRE() {}
      
      public final void fRF()
      {
        AppMethodBeat.i(100098);
        p.a(p.this);
        AppMethodBeat.o(100098);
      }
      
      public final void onDetachedFromWindow()
      {
        int i = 0;
        AppMethodBeat.i(100100);
        Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onDetachedFromWindow reset");
        p.this.Lny = true;
        p.this.Lnz = true;
        p.this.LnA = null;
        p.this.cyl.removeCallbacksAndMessages(null);
        try
        {
          Object localObject = new JSONObject();
          ((JSONObject)localObject).put("panCount", p.b(p.this));
          ((JSONObject)localObject).put("type", 1);
          String str2 = URLEncoder.encode(((JSONObject)localObject).toString(), "UTF-8");
          SnsInfo localSnsInfo = p.this.Kee.agM(p.this.Lnx.position);
          String str1 = localSnsInfo.getAid();
          localObject = str1;
          if (str1 == null) {
            localObject = "";
          }
          com.tencent.mm.plugin.report.service.h.IzE.a(17539, new Object[] { localSnsInfo.getTimeLine().Id, localObject, localSnsInfo.getAdInfo().uxInfo, Integer.valueOf(1), str2 });
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
        p.c(p.this);
        AppMethodBeat.o(100100);
      }
    };
    this.LnC = false;
    AppMethodBeat.o(100105);
  }
  
  public final void a(final ViewStub paramViewStub, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(266103);
    for (;;)
    {
      try
      {
        paramViewStub = (a)paramBaseViewHolder;
        this.Lnx = paramViewStub;
        Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "buildContent, holder=" + paramBaseViewHolder.hashCode());
        if (paramBaseViewHolder.LkR != null)
        {
          paramBaseViewHolder.LkR.setLayoutResource(i.g.sns_timeline_ad_sphere_card);
          if (!paramBaseViewHolder.LkS)
          {
            paramViewStub.xYJ = paramBaseViewHolder.LkR.inflate();
            paramBaseViewHolder.LkS = true;
          }
          paramViewStub.AZc = paramViewStub.convertView.findViewById(i.f.top_layer);
          paramViewStub.JKr = paramViewStub.convertView.findViewById(i.f.bottom_layer);
          paramViewStub.zOg = ((TextView)paramViewStub.convertView.findViewById(i.f.top_layer_title));
          paramViewStub.JKt = ((TextView)paramViewStub.convertView.findViewById(i.f.top_layer_desc));
          paramViewStub.JKu = ((TextView)paramViewStub.convertView.findViewById(i.f.bottom_layer_title));
          paramViewStub.JKv = ((TextView)paramViewStub.convertView.findViewById(i.f.bottom_layer_desc));
          paramViewStub.LnJ = ((SphereImageView)paramViewStub.convertView.findViewById(i.f.sphere_card_img));
          paramViewStub.JKw = paramViewStub.convertView.findViewById(i.f.bottom_mini_program);
          paramViewStub.LnK = ((ImageView)paramViewStub.convertView.findViewById(i.f.mask_img));
          paramViewStub.LnL = ((MMPinProgressBtn)paramViewStub.convertView.findViewById(i.f.progress));
          paramViewStub.LnL.setMax(50);
          Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "buildContent, disable touch and sensor");
          paramViewStub.LnJ.setTouchEnabled(false);
          paramViewStub.LnJ.setSensorEnabled(false);
          paramViewStub.LnJ.ap(1.8F, -2.0F);
          paramViewStub.LnJ.setTouchSensitivity(0.45F);
          paramViewStub.LnJ.setEventListener(this.KxA);
          paramViewStub.LnJ.setOnlyHorizontalScroll(true);
          this.KtF = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a();
          this.KtF.a(this.LnB);
          if (this.Lke == null)
          {
            i = 0;
            this.cyl.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(100094);
                Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "enable touch, delay=" + i);
                paramViewStub.LnJ.setTouchEnabled(true);
                AppMethodBeat.o(100094);
              }
            }, i);
            Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "viewHash=" + paramViewStub.LnJ.hashCode() + ", touchDelay=" + i);
            AppMethodBeat.o(266103);
          }
        }
        else
        {
          if (paramBaseViewHolder.LkS) {
            continue;
          }
          paramViewStub.xYJ = paramBaseViewHolder.convertView.findViewById(i.f.sphere_card_container);
          paramBaseViewHolder.LkS = true;
          continue;
        }
        final int i = this.Lke.KjW;
      }
      catch (Throwable paramViewStub)
      {
        Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "buildContent exp=" + paramViewStub.toString());
        AppMethodBeat.o(266103);
        return;
      }
    }
  }
  
  public final void a(SphereImageView paramSphereImageView, boolean paramBoolean)
  {
    AppMethodBeat.i(100108);
    Log.d("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "setIsInLowPriority, isInLowPriority=" + paramBoolean + ", hash=" + paramSphereImageView.hashCode());
    this.LnC = paramBoolean;
    if (paramBoolean)
    {
      paramSphereImageView.setSensorEnabled(false);
      AppMethodBeat.o(100108);
      return;
    }
    if (!this.Lny) {
      paramSphereImageView.setSensorEnabled(true);
    }
    AppMethodBeat.o(100108);
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, final bn parambn, final TimeLineObject paramTimeLineObject, int paramInt2, bm parambm)
  {
    AppMethodBeat.i(100107);
    for (;;)
    {
      try
      {
        long l1 = System.currentTimeMillis();
        if (paramBaseViewHolder.jTm)
        {
          Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem, holder is busy");
          AppMethodBeat.o(100107);
          return;
        }
        final a locala = (a)paramBaseViewHolder;
        SnsInfo localSnsInfo = parambn.Jws;
        if ((localSnsInfo == null) || (localSnsInfo.getAdXml() == null)) {
          break label1489;
        }
        locali = localSnsInfo.getAdXml().adSphereCardInfo;
        this.Lke = locali;
        if ((Build.VERSION.SDK_INT < 24) && (locali != null) && ((this.LnA == null) || (!this.LnA.equals(locali.KjX))))
        {
          this.Lny = true;
          this.Lnz = true;
          Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem, reset, sdk_int=" + Build.VERSION.SDK_INT);
        }
        StringBuilder localStringBuilder = new StringBuilder("ad fillItem, sphereCard, pos=").append(paramInt1).append(", snsId=");
        if (paramTimeLineObject == null)
        {
          parambn = "";
          parambn = localStringBuilder.append(parambn).append(", hash=").append(locala.LnJ.hashCode()).append(", isFirst=").append(this.Lnz).append(", snsInfo.hash=");
          if (localSnsInfo == null) {
            break label1495;
          }
          paramInt1 = localSnsInfo.hashCode();
          Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", paramInt1);
          parambn = null;
          locala.AZc.setVisibility(8);
          locala.zOg.setVisibility(8);
          locala.JKt.setVisibility(8);
          locala.JKr.setVisibility(8);
          locala.JKu.setVisibility(8);
          locala.JKv.setVisibility(8);
          locala.JKw.setVisibility(8);
          if (locali == null) {
            break label1478;
          }
          paramTimeLineObject = (WindowManager)this.mActivity.getSystemService("window");
          paramInt1 = Math.min(paramTimeLineObject.getDefaultDisplay().getWidth(), paramTimeLineObject.getDefaultDisplay().getHeight()) - com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 56) - this.mActivity.getResources().getDimensionPixelSize(i.d.LittlePadding) - this.mActivity.getResources().getDimensionPixelSize(i.d.NormalPadding);
          if (locali.KjH == 0)
          {
            parambn = new ViewGroup.LayoutParams(-2, -2);
            parambn.width = paramInt1;
            parambn.height = ((int)(parambn.width * 0.75F));
            if (parambn != null)
            {
              paramTimeLineObject = locala.xYJ.getLayoutParams();
              paramTimeLineObject.width = parambn.width;
              paramTimeLineObject.height = parambn.height;
              locala.xYJ.setLayoutParams(paramTimeLineObject);
              ((RoundedCornerFrameLayout)locala.xYJ).setRadius(com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 8));
              paramTimeLineObject = locala.LnJ.getLayoutParams();
              paramTimeLineObject.width = parambn.width;
              paramTimeLineObject.height = parambn.height;
              locala.LnJ.setLayoutParams(paramTimeLineObject);
              parambn = locala.LnK.getLayoutParams();
              parambn.width = paramTimeLineObject.width;
              parambn.height = paramTimeLineObject.height;
              locala.LnK.setLayoutParams(parambn);
            }
            if (locali.KjJ != 0) {
              continue;
            }
            paramInt1 = Color.argb((int)(locali.KjI * 2.55F), 0, 0, 0);
            paramInt2 = Color.argb(0, 0, 0, 0);
            parambn = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { paramInt1, paramInt2 });
            parambn.setGradientType(0);
            locala.AZc.setBackground(parambn);
            if ((!Util.isNullOrNil(locali.title)) || (!Util.isNullOrNil(locali.description))) {
              locala.AZc.setVisibility(0);
            }
            if (!Util.isNullOrNil(locali.title))
            {
              locala.zOg.setVisibility(0);
              locala.zOg.setText(com.tencent.mm.cl.h.htZ().a(locala.zOg.getContext(), locali.title, locala.zOg.getTextSize()));
            }
            if (!Util.isNullOrNil(locali.description))
            {
              locala.JKt.setVisibility(0);
              locala.JKt.setText(com.tencent.mm.cl.h.htZ().a(locala.JKt.getContext(), locali.description, locala.JKt.getTextSize()));
            }
            if ((localSnsInfo != null) && (localSnsInfo.getAdInfo().isWeapp()))
            {
              paramInt1 = Color.argb((int)(locali.KjI * 2.55F), 0, 0, 0);
              paramInt2 = Color.argb(0, 0, 0, 0);
              parambn = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { paramInt1, paramInt2 });
              parambn.setGradientType(0);
              locala.JKr.setVisibility(0);
              locala.JKr.setBackground(parambn);
              locala.JKw.setVisibility(0);
            }
            if (this.Lnz)
            {
              locala.LnK.setVisibility(0);
              parambn = locali.KjX;
              paramTimeLineObject = locali.KjY;
              new a.c(parambn, paramTimeLineObject, "scene_timeline", new a.d()
              {
                public final void a(boolean paramAnonymousBoolean, String paramAnonymousString1, Bitmap paramAnonymousBitmap, String paramAnonymousString2)
                {
                  AppMethodBeat.i(100104);
                  if ((paramAnonymousString2 == null) || (!paramAnonymousString2.equals(parambn)))
                  {
                    AppMethodBeat.o(100104);
                    return;
                  }
                  if (paramAnonymousBitmap != null)
                  {
                    locala.LnK.setImageBitmap(paramAnonymousBitmap);
                    AppMethodBeat.o(100104);
                    return;
                  }
                  Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "show progressView");
                  locala.LnL.setVisibility(0);
                  locala.LnL.hZF();
                  if (!TextUtils.isEmpty(paramTimeLineObject))
                  {
                    Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "no shot and thumb cache, start download thumb image");
                    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a("adId", paramTimeLineObject, new f.a()
                    {
                      String LnH;
                      
                      public final void aYs(String paramAnonymous2String)
                      {
                        AppMethodBeat.i(100103);
                        Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onDownloaded thumb, path=".concat(String.valueOf(paramAnonymous2String)));
                        if (p.this.Lke != null) {}
                        for (String str = p.this.Lke.KjY; (this.LnH != null) && (this.LnH.equals(str)); str = "")
                        {
                          if (p.4.this.LnE.LnK.getVisibility() != 0) {
                            break label149;
                          }
                          try
                          {
                            paramAnonymous2String = MMBitmapFactory.decodeFile(paramAnonymous2String);
                            p.4.this.LnE.LnK.setImageBitmap(paramAnonymous2String);
                            AppMethodBeat.o(100103);
                            return;
                          }
                          catch (Throwable paramAnonymous2String)
                          {
                            Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onDownloaded thumb exp:" + paramAnonymous2String.toString());
                            AppMethodBeat.o(100103);
                            return;
                          }
                        }
                        Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onDownloaded, url != nowUrl");
                        label149:
                        AppMethodBeat.o(100103);
                      }
                      
                      public final void fJU() {}
                      
                      public final void fJV()
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
                
                public final void aRh(String paramAnonymousString) {}
              }).execute(new Void[0]);
            }
            locala.LnJ.setVisibility(0);
            locala.LnJ.setOnClickListener(parambm.Kdz.LpB);
            locala.LnJ.setTag(paramBaseViewHolder);
            if ((!this.Lny) && (!this.LnC))
            {
              Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem !first, enable sensor");
              locala.LnJ.setSensorEnabled(true);
            }
            if ((this.LnA == null) || (!this.LnA.equals(locali.KjX)))
            {
              Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem, loadImage, hash=" + locala.LnJ.hashCode());
              paramBaseViewHolder = locala.LnJ.getLayoutParams();
              this.KtF.n(locali.KjX, paramBaseViewHolder.width, paramBaseViewHolder.height, "scene_timeline");
              this.LnA = locali.KjX;
            }
            this.Lnz = false;
            long l2 = System.currentTimeMillis();
            Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem total timeCost=" + (l2 - l1));
            AppMethodBeat.o(100107);
          }
        }
        else
        {
          parambn = paramTimeLineObject.Id;
          continue;
        }
        if (locali.KjH != 1) {
          continue;
        }
        parambn = new ViewGroup.LayoutParams(-2, -2);
        parambn.width = paramInt1;
        parambn.height = parambn.width;
        continue;
        if (locali.KjJ != 1) {
          continue;
        }
        paramInt1 = Color.argb((int)(locali.KjI * 2.55F), 0, 0, 0);
        paramInt2 = Color.argb(0, 0, 0, 0);
        parambn = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { paramInt1, paramInt2 });
        parambn.setGradientType(0);
        locala.JKr.setBackground(parambn);
        if ((!Util.isNullOrNil(locali.title)) || (!Util.isNullOrNil(locali.description)))
        {
          locala.JKr.setVisibility(0);
          parambn = (RelativeLayout.LayoutParams)locala.JKw.getLayoutParams();
          parambn.topMargin = com.tencent.mm.ci.a.fromDPToPix(locala.xYJ.getContext(), 4);
          locala.JKw.setLayoutParams(parambn);
        }
        if (!Util.isNullOrNil(locali.title))
        {
          locala.JKu.setVisibility(0);
          locala.JKu.setText(com.tencent.mm.cl.h.htZ().a(locala.JKu.getContext(), locali.title, locala.JKu.getTextSize()));
        }
        if (Util.isNullOrNil(locali.description)) {
          continue;
        }
        locala.JKv.setVisibility(0);
        locala.JKv.setText(com.tencent.mm.cl.h.htZ().a(locala.JKv.getContext(), locali.description, locala.JKv.getTextSize()));
        continue;
        Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "sphereCardInfo==null, invalid sphereCard");
      }
      catch (Throwable paramBaseViewHolder)
      {
        Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem exp=" + paramBaseViewHolder.toString());
        AppMethodBeat.o(100107);
        return;
      }
      label1478:
      continue;
      label1489:
      ADXml.i locali = null;
      continue;
      label1495:
      paramInt1 = 0;
    }
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    public View AZc;
    public View JKr;
    public TextView JKt;
    public TextView JKu;
    public TextView JKv;
    public View JKw;
    public SphereImageView LnJ;
    public ImageView LnK;
    public MMPinProgressBtn LnL;
    public View xYJ;
    public TextView zOg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.p
 * JD-Core Version:    0.7.0.1
 */