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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.b.i;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.plugin.sns.ui.bi;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.net.URLEncoder;
import org.json.JSONObject;

public final class k
  extends BaseTimeLineItem
{
  protected b.i Aux;
  protected a Axf;
  protected boolean Axg;
  protected boolean Axh;
  protected String Axi;
  protected a.d Axj;
  boolean Axk;
  protected ap gKD;
  protected com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a zHi;
  private int zHj;
  protected SphereImageView.b zKU;
  
  public k()
  {
    AppMethodBeat.i(100105);
    this.Axg = true;
    this.Axh = true;
    this.Axi = null;
    this.gKD = new ap(Looper.getMainLooper());
    this.zHj = 0;
    this.Axj = new a.d()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString1, Bitmap paramAnonymousBitmap, String paramAnonymousString2)
      {
        AppMethodBeat.i(100095);
        ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "ImageLoader onFinish, isSucc=" + paramAnonymousBoolean + ", errInfo=" + paramAnonymousString1);
        if (k.this.Axf == null)
        {
          ad.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onFinish, mViewHolder==null");
          AppMethodBeat.o(100095);
          return;
        }
        if (k.this.Aux != null) {}
        for (paramAnonymousString1 = k.this.Aux.zxv; (paramAnonymousString2 != null) && (paramAnonymousString2.equals(paramAnonymousString1)); paramAnonymousString1 = "")
        {
          k.this.Axf.Axr.g(paramAnonymousBitmap, paramAnonymousString2);
          AppMethodBeat.o(100095);
          return;
        }
        ad.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onFinish, url != nowUrl");
        AppMethodBeat.o(100095);
      }
      
      public final void onStart(String paramAnonymousString) {}
    };
    this.zKU = new SphereImageView.b()
    {
      public final void azP(final String paramAnonymousString)
      {
        AppMethodBeat.i(100099);
        if (k.this.Aux != null) {}
        for (Object localObject = k.this.Aux.zxv; (paramAnonymousString != null) && (!paramAnonymousString.equals(localObject)); localObject = "")
        {
          ad.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onUpdateImage, url != CardInfo.sphereImageUrl, url=" + paramAnonymousString + ", info.url=" + (String)localObject);
          AppMethodBeat.o(100099);
          return;
        }
        localObject = k.this.Axf;
        if (localObject == null)
        {
          ad.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onUpdateImage, viewHolder==null");
          AppMethodBeat.o(100099);
          return;
        }
        ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onUpdateImage, isFirstUpdateImage=" + k.this.Axg + ", visiable=" + ((k.a)localObject).Axs.getVisibility());
        if (k.this.Axg)
        {
          if (((k.a)localObject).Axs.getVisibility() == 0)
          {
            AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
            localAlphaAnimation.setDuration(350L);
            localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
            {
              public final void onAnimationEnd(Animation paramAnonymous2Animation)
              {
                AppMethodBeat.i(100096);
                this.Axm.Axs.setVisibility(8);
                this.Axm.Axs.setImageDrawable(new ColorDrawable(this.Axm.Axs.getContext().getResources().getColor(2131099651)));
                AppMethodBeat.o(100096);
              }
              
              public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
              
              public final void onAnimationStart(Animation paramAnonymous2Animation) {}
            });
            ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "do maskImage anim");
            ((k.a)localObject).Axs.startAnimation(localAlphaAnimation);
          }
          if ((k.this.Aux == null) || (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.jD(k.this.Aux.zxv, "scene_timeline"))) {
            break label328;
          }
          ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "disable touch before shot");
          ((k.a)localObject).Axr.setTouchEnabled(false);
          ((k.a)localObject).Axr.dXZ();
          ((k.a)localObject).Axr.zJF.requestRender();
          k.this.gKD.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(100097);
              String str;
              if (k.this.Aux != null)
              {
                str = k.this.Aux.zxv;
                if ((paramAnonymousString == null) || (!paramAnonymousString.equals(str))) {
                  break label158;
                }
                ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "do shot");
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.a(this.Axm.Axr, str, "scene_timeline");
                k.this.Axg = false;
              }
              for (;;)
              {
                ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "enable touch and sensor after shot, isInLowPriority=" + k.this.Axk);
                if (!k.this.Axk) {
                  this.Axm.Axr.setSensorEnabled(true);
                }
                this.Axm.Axr.setTouchEnabled(true);
                AppMethodBeat.o(100097);
                return;
                str = "";
                break;
                label158:
                ad.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "before do shot, url != CardInfo.sphereImageUrl, url=" + paramAnonymousString + ", info.url=" + str);
              }
            }
          }, 800L);
        }
        for (;;)
        {
          if (((k.a)localObject).Axt.getVisibility() == 0)
          {
            ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "hide progressView");
            ((k.a)localObject).Axt.setVisibility(8);
          }
          AppMethodBeat.o(100099);
          return;
          label328:
          ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "don't need shot, enable sensor, isInLowPriority=" + k.this.Axk);
          if (!k.this.Axk) {
            ((k.a)localObject).Axr.setSensorEnabled(true);
          }
          k.this.Axg = false;
        }
      }
      
      public final void dXr() {}
      
      public final void dXs() {}
      
      public final void dXt()
      {
        AppMethodBeat.i(100098);
        k.a(k.this);
        AppMethodBeat.o(100098);
      }
      
      public final void onDetachedFromWindow()
      {
        int i = 0;
        AppMethodBeat.i(100100);
        ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onDetachedFromWindow reset");
        k.this.Axg = true;
        k.this.Axh = true;
        k.this.Axi = null;
        k.this.gKD.removeCallbacksAndMessages(null);
        try
        {
          Object localObject = new JSONObject();
          ((JSONObject)localObject).put("panCount", k.b(k.this));
          ((JSONObject)localObject).put("type", 1);
          String str2 = URLEncoder.encode(((JSONObject)localObject).toString(), "UTF-8");
          p localp = k.this.zpI.QT(k.this.Axf.position);
          String str1 = localp.dYP();
          localObject = str1;
          if (str1 == null) {
            localObject = "";
          }
          com.tencent.mm.plugin.report.service.g.yhR.f(17539, new Object[] { localp.dYl().Id, localObject, localp.dRK().dFy, Integer.valueOf(1), str2 });
          localObject = new StringBuilder("KVReport, id=17539, touchCount=").append(str2).append(", snsInfo.hash=");
          if (localp != null) {
            i = localp.hashCode();
          }
          ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", i);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "kvStat exp:" + localException.toString());
          }
        }
        k.c(k.this);
        AppMethodBeat.o(100100);
      }
    };
    this.Axk = false;
    AppMethodBeat.o(100105);
  }
  
  public final void a(SphereImageView paramSphereImageView, boolean paramBoolean)
  {
    AppMethodBeat.i(100108);
    ad.d("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "setIsInLowPriority, isInLowPriority=" + paramBoolean + ", hash=" + paramSphereImageView.hashCode());
    this.Axk = paramBoolean;
    if (paramBoolean)
    {
      paramSphereImageView.setSensorEnabled(false);
      AppMethodBeat.o(100108);
      return;
    }
    if (!this.Axg) {
      paramSphereImageView.setSensorEnabled(true);
    }
    AppMethodBeat.o(100108);
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, final bi parambi, TimeLineObject paramTimeLineObject, int paramInt2, bh parambh)
  {
    AppMethodBeat.i(100107);
    for (;;)
    {
      try
      {
        long l1 = System.currentTimeMillis();
        if (paramBaseViewHolder.grY)
        {
          ad.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem, holder is busy");
          AppMethodBeat.o(100107);
          return;
        }
        final a locala = (a)paramBaseViewHolder;
        Object localObject1 = parambi.yVM;
        if ((localObject1 == null) || (((p)localObject1).dRL() == null)) {
          break label1479;
        }
        paramTimeLineObject = ((p)localObject1).dRL().zwq;
        this.Aux = paramTimeLineObject;
        if ((Build.VERSION.SDK_INT < 24) && (paramTimeLineObject != null) && ((this.Axi == null) || (!this.Axi.equals(paramTimeLineObject.zxv))))
        {
          this.Axg = true;
          this.Axh = true;
          ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem, reset, sdk_int=" + Build.VERSION.SDK_INT);
        }
        parambi = new StringBuilder("fillItem, pos=").append(paramInt1).append(", hash=").append(locala.Axr.hashCode()).append(", isFirst=").append(this.Axh).append(", snsInfo.hash=");
        if (localObject1 != null)
        {
          paramInt1 = localObject1.hashCode();
          ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", paramInt1);
          parambi = null;
          locala.sUS.setVisibility(8);
          locala.AtO.setVisibility(8);
          locala.AtP.setVisibility(8);
          locala.AtN.setVisibility(8);
          locala.AtQ.setVisibility(8);
          locala.AtR.setVisibility(8);
          locala.AtS.setVisibility(8);
          if (paramTimeLineObject == null) {
            break label1468;
          }
          localObject2 = (WindowManager)this.mActivity.getSystemService("window");
          paramInt1 = Math.min(((WindowManager)localObject2).getDefaultDisplay().getWidth(), ((WindowManager)localObject2).getDefaultDisplay().getHeight()) - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 56) - this.mActivity.getResources().getDimensionPixelSize(2131165490) - this.mActivity.getResources().getDimensionPixelSize(2131165516);
          if (paramTimeLineObject.zxf == 0)
          {
            parambi = new ViewGroup.LayoutParams(-2, -2);
            parambi.width = paramInt1;
            parambi.height = ((int)(parambi.width * 0.75F));
            if (parambi != null)
            {
              localObject2 = locala.zYc.getLayoutParams();
              ((ViewGroup.LayoutParams)localObject2).width = parambi.width;
              ((ViewGroup.LayoutParams)localObject2).height = parambi.height;
              locala.zYc.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              ((RoundedCornerFrameLayout)locala.zYc).setRadius(com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 8));
              localObject2 = locala.Axr.getLayoutParams();
              ((ViewGroup.LayoutParams)localObject2).width = parambi.width;
              ((ViewGroup.LayoutParams)localObject2).height = parambi.height;
              locala.Axr.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              parambi = locala.Axs.getLayoutParams();
              parambi.width = ((ViewGroup.LayoutParams)localObject2).width;
              parambi.height = ((ViewGroup.LayoutParams)localObject2).height;
              locala.Axs.setLayoutParams(parambi);
            }
            if (paramTimeLineObject.zxh != 0) {
              continue;
            }
            paramInt1 = Color.argb((int)(paramTimeLineObject.zxg * 2.55F), 0, 0, 0);
            paramInt2 = Color.argb(0, 0, 0, 0);
            parambi = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { paramInt1, paramInt2 });
            parambi.setGradientType(0);
            locala.sUS.setBackground(parambi);
            if ((!bt.isNullOrNil(paramTimeLineObject.title)) || (!bt.isNullOrNil(paramTimeLineObject.description))) {
              locala.sUS.setVisibility(0);
            }
            if (!bt.isNullOrNil(paramTimeLineObject.title))
            {
              locala.AtO.setVisibility(0);
              parambi = locala.AtO;
              localObject2 = com.tencent.mm.cf.g.fng();
              locala.AtO.getContext();
              parambi.setText(((com.tencent.mm.cf.g)localObject2).b(paramTimeLineObject.title, locala.AtO.getTextSize()));
            }
            if (!bt.isNullOrNil(paramTimeLineObject.description))
            {
              locala.AtP.setVisibility(0);
              parambi = locala.AtP;
              localObject2 = com.tencent.mm.cf.g.fng();
              locala.AtP.getContext();
              parambi.setText(((com.tencent.mm.cf.g)localObject2).b(paramTimeLineObject.description, locala.AtP.getTextSize()));
            }
            if ((localObject1 != null) && (((p)localObject1).dRK().dVQ()))
            {
              paramInt1 = Color.argb((int)(paramTimeLineObject.zxg * 2.55F), 0, 0, 0);
              paramInt2 = Color.argb(0, 0, 0, 0);
              parambi = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { paramInt1, paramInt2 });
              parambi.setGradientType(0);
              locala.AtN.setVisibility(0);
              locala.AtN.setBackground(parambi);
              locala.AtS.setVisibility(0);
            }
            if (this.Axh)
            {
              locala.Axs.setVisibility(0);
              parambi = paramTimeLineObject.zxv;
              localObject1 = paramTimeLineObject.zxw;
              new a.c(parambi, (String)localObject1, "scene_timeline", new a.d()
              {
                public final void a(boolean paramAnonymousBoolean, String paramAnonymousString1, Bitmap paramAnonymousBitmap, String paramAnonymousString2)
                {
                  AppMethodBeat.i(100104);
                  if ((paramAnonymousString2 == null) || (!paramAnonymousString2.equals(parambi)))
                  {
                    AppMethodBeat.o(100104);
                    return;
                  }
                  if (paramAnonymousBitmap != null)
                  {
                    locala.Axs.setImageBitmap(paramAnonymousBitmap);
                    AppMethodBeat.o(100104);
                    return;
                  }
                  ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "show progressView");
                  locala.Axt.setVisibility(0);
                  locala.Axt.fLr();
                  if (!TextUtils.isEmpty(this.iaM))
                  {
                    ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "no shot and thumb cache, start download thumb image");
                    h.a(this.iaM, 133, new f.a()
                    {
                      String Axp;
                      
                      public final void axG(String paramAnonymous2String)
                      {
                        AppMethodBeat.i(100103);
                        ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onDownloaded thumb, path=".concat(String.valueOf(paramAnonymous2String)));
                        if (k.this.Aux != null) {}
                        for (String str = k.this.Aux.zxw; (this.Axp != null) && (this.Axp.equals(str)); str = "")
                        {
                          if (k.4.this.Axm.Axs.getVisibility() != 0) {
                            break label149;
                          }
                          try
                          {
                            paramAnonymous2String = MMBitmapFactory.decodeFile(paramAnonymous2String);
                            k.4.this.Axm.Axs.setImageBitmap(paramAnonymous2String);
                            AppMethodBeat.o(100103);
                            return;
                          }
                          catch (Throwable paramAnonymous2String)
                          {
                            ad.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onDownloaded thumb exp:" + paramAnonymous2String.toString());
                            AppMethodBeat.o(100103);
                            return;
                          }
                        }
                        ad.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onDownloaded, url != nowUrl");
                        label149:
                        AppMethodBeat.o(100103);
                      }
                      
                      public final void dRW() {}
                      
                      public final void dRX()
                      {
                        AppMethodBeat.i(100102);
                        ad.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onDownloadError thumb");
                        AppMethodBeat.o(100102);
                      }
                    });
                    AppMethodBeat.o(100104);
                    return;
                  }
                  ad.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "thumbUrl is empty");
                  AppMethodBeat.o(100104);
                }
                
                public final void onStart(String paramAnonymousString) {}
              }).execute(new Void[0]);
            }
            locala.Axr.setVisibility(0);
            locala.Axr.setOnClickListener(parambh.zpd.Azc);
            locala.Axr.setTag(paramBaseViewHolder);
            if ((!this.Axg) && (!this.Axk))
            {
              ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem !first, enable sensor");
              locala.Axr.setSensorEnabled(true);
            }
            if ((this.Axi == null) || (!this.Axi.equals(paramTimeLineObject.zxv)))
            {
              ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem, loadImage, hash=" + locala.Axr.hashCode());
              paramBaseViewHolder = locala.Axr.getLayoutParams();
              this.zHi.l(paramTimeLineObject.zxv, paramBaseViewHolder.width, paramBaseViewHolder.height, "scene_timeline");
              this.Axi = paramTimeLineObject.zxv;
            }
            this.Axh = false;
            long l2 = System.currentTimeMillis();
            ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem total timeCost=" + (l2 - l1));
            AppMethodBeat.o(100107);
          }
        }
        else
        {
          paramInt1 = 0;
          continue;
        }
        if (paramTimeLineObject.zxf != 1) {
          continue;
        }
        parambi = new ViewGroup.LayoutParams(-2, -2);
        parambi.width = paramInt1;
        parambi.height = parambi.width;
        continue;
        if (paramTimeLineObject.zxh != 1) {
          continue;
        }
        paramInt1 = Color.argb((int)(paramTimeLineObject.zxg * 2.55F), 0, 0, 0);
        paramInt2 = Color.argb(0, 0, 0, 0);
        parambi = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { paramInt1, paramInt2 });
        parambi.setGradientType(0);
        locala.AtN.setBackground(parambi);
        if ((!bt.isNullOrNil(paramTimeLineObject.title)) || (!bt.isNullOrNil(paramTimeLineObject.description)))
        {
          locala.AtN.setVisibility(0);
          parambi = (RelativeLayout.LayoutParams)locala.AtS.getLayoutParams();
          parambi.topMargin = com.tencent.mm.cc.a.fromDPToPix(locala.zYc.getContext(), 4);
          locala.AtS.setLayoutParams(parambi);
        }
        if (!bt.isNullOrNil(paramTimeLineObject.title))
        {
          locala.AtQ.setVisibility(0);
          parambi = locala.AtQ;
          localObject2 = com.tencent.mm.cf.g.fng();
          locala.AtQ.getContext();
          parambi.setText(((com.tencent.mm.cf.g)localObject2).b(paramTimeLineObject.title, locala.AtQ.getTextSize()));
        }
        if (bt.isNullOrNil(paramTimeLineObject.description)) {
          continue;
        }
        locala.AtR.setVisibility(0);
        parambi = locala.AtR;
        Object localObject2 = com.tencent.mm.cf.g.fng();
        locala.AtR.getContext();
        parambi.setText(((com.tencent.mm.cf.g)localObject2).b(paramTimeLineObject.description, locala.AtR.getTextSize()));
        continue;
        ad.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "sphereCardInfo==null, invalid sphereCard");
      }
      catch (Throwable paramBaseViewHolder)
      {
        ad.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem exp=" + paramBaseViewHolder.toString());
        AppMethodBeat.o(100107);
        return;
      }
      label1468:
      continue;
      label1479:
      paramTimeLineObject = null;
    }
  }
  
  public final void h(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100106);
    for (;;)
    {
      try
      {
        final a locala = (a)paramBaseViewHolder;
        this.Axf = locala;
        ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "buildContent, holder=" + paramBaseViewHolder.hashCode());
        if (paramBaseViewHolder.Avc != null)
        {
          paramBaseViewHolder.Avc.setLayoutResource(2131495604);
          if (!paramBaseViewHolder.Avd)
          {
            locala.zYc = paramBaseViewHolder.Avc.inflate();
            paramBaseViewHolder.Avd = true;
          }
          locala.sUS = locala.tPw.findViewById(2131306008);
          locala.AtN = locala.tPw.findViewById(2131297449);
          locala.AtO = ((TextView)locala.tPw.findViewById(2131306010));
          locala.AtP = ((TextView)locala.tPw.findViewById(2131306009));
          locala.AtQ = ((TextView)locala.tPw.findViewById(2131297451));
          locala.AtR = ((TextView)locala.tPw.findViewById(2131297450));
          locala.Axr = ((SphereImageView)locala.tPw.findViewById(2131305148));
          locala.AtS = locala.tPw.findViewById(2131297455);
          locala.Axs = ((ImageView)locala.tPw.findViewById(2131302164));
          locala.Axt = ((MMPinProgressBtn)locala.tPw.findViewById(2131303515));
          locala.Axt.setMax(50);
          ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "buildContent, disable touch and sensor");
          locala.Axr.setTouchEnabled(false);
          locala.Axr.setSensorEnabled(false);
          locala.Axr.ag(1.8F, -2.0F);
          locala.Axr.setTouchSensitivity(0.45F);
          locala.Axr.setEventListener(this.zKU);
          locala.Axr.setOnlyHorizontalScroll(true);
          this.zHi = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a();
          this.zHi.a(this.Axj);
          if (this.Aux == null)
          {
            i = 0;
            this.gKD.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(100094);
                ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "enable touch, delay=" + i);
                locala.Axr.setTouchEnabled(true);
                AppMethodBeat.o(100094);
              }
            }, i);
            ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "viewHash=" + locala.Axr.hashCode() + ", touchDelay=" + i);
            AppMethodBeat.o(100106);
          }
        }
        else
        {
          if (paramBaseViewHolder.Avd) {
            continue;
          }
          locala.zYc = paramBaseViewHolder.tPw.findViewById(2131305147);
          paramBaseViewHolder.Avd = true;
          continue;
        }
        final int i = this.Aux.zxu;
      }
      catch (Throwable paramBaseViewHolder)
      {
        ad.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "buildContent exp=" + paramBaseViewHolder.toString());
        AppMethodBeat.o(100106);
        return;
      }
    }
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    public View AtN;
    public TextView AtO;
    public TextView AtP;
    public TextView AtQ;
    public TextView AtR;
    public View AtS;
    public SphereImageView Axr;
    public ImageView Axs;
    public MMPinProgressBtn Axt;
    public View sUS;
    public View zYc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.k
 * JD-Core Version:    0.7.0.1
 */