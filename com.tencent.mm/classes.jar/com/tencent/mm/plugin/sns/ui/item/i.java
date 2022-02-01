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
import com.tencent.mm.cg.g;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.b.h;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.plugin.sns.ui.bf;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.net.URLEncoder;
import org.json.JSONObject;

public final class i
  extends BaseTimeLineItem
{
  protected ap oFl;
  protected b.h xPR;
  protected a xSm;
  protected boolean xSn;
  protected boolean xSo;
  protected String xSp;
  protected a.d xSq;
  boolean xSr;
  protected com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a xdl;
  private int xdm;
  protected SphereImageView.b xgT;
  
  public i()
  {
    AppMethodBeat.i(100105);
    this.xSn = true;
    this.xSo = true;
    this.xSp = null;
    this.oFl = new ap(Looper.getMainLooper());
    this.xdm = 0;
    this.xSq = new a.d()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString1, Bitmap paramAnonymousBitmap, String paramAnonymousString2)
      {
        AppMethodBeat.i(100095);
        ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "ImageLoader onFinish, isSucc=" + paramAnonymousBoolean + ", errInfo=" + paramAnonymousString1);
        if (i.this.xSm == null)
        {
          ad.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onFinish, mViewHolder==null");
          AppMethodBeat.o(100095);
          return;
        }
        if (i.this.xPR != null) {}
        for (paramAnonymousString1 = i.this.xPR.wUA; (paramAnonymousString2 != null) && (paramAnonymousString2.equals(paramAnonymousString1)); paramAnonymousString1 = "")
        {
          i.this.xSm.xSy.g(paramAnonymousBitmap, paramAnonymousString2);
          AppMethodBeat.o(100095);
          return;
        }
        ad.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onFinish, url != nowUrl");
        AppMethodBeat.o(100095);
      }
      
      public final void onStart(String paramAnonymousString) {}
    };
    this.xgT = new SphereImageView.b()
    {
      public final void apy(final String paramAnonymousString)
      {
        AppMethodBeat.i(100099);
        if (i.this.xPR != null) {}
        for (Object localObject = i.this.xPR.wUA; (paramAnonymousString != null) && (!paramAnonymousString.equals(localObject)); localObject = "")
        {
          ad.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onUpdateImage, url != CardInfo.sphereImageUrl, url=" + paramAnonymousString + ", info.url=" + (String)localObject);
          AppMethodBeat.o(100099);
          return;
        }
        localObject = i.this.xSm;
        if (localObject == null)
        {
          ad.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onUpdateImage, viewHolder==null");
          AppMethodBeat.o(100099);
          return;
        }
        ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onUpdateImage, isFirstUpdateImage=" + i.this.xSn + ", visiable=" + ((i.a)localObject).xSz.getVisibility());
        if (i.this.xSn)
        {
          if (((i.a)localObject).xSz.getVisibility() == 0)
          {
            AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
            localAlphaAnimation.setDuration(350L);
            localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
            {
              public final void onAnimationEnd(Animation paramAnonymous2Animation)
              {
                AppMethodBeat.i(100096);
                this.xSt.xSz.setVisibility(8);
                this.xSt.xSz.setImageDrawable(new ColorDrawable(this.xSt.xSz.getContext().getResources().getColor(2131099651)));
                AppMethodBeat.o(100096);
              }
              
              public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
              
              public final void onAnimationStart(Animation paramAnonymous2Animation) {}
            });
            ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "do maskImage anim");
            ((i.a)localObject).xSz.startAnimation(localAlphaAnimation);
          }
          if ((i.this.xPR == null) || (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.iS(i.this.xPR.wUA, "scene_timeline"))) {
            break label328;
          }
          ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "disable touch before shot");
          ((i.a)localObject).xSy.setTouchEnabled(false);
          ((i.a)localObject).xSy.dxk();
          ((i.a)localObject).xSy.xfJ.requestRender();
          i.this.oFl.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(100097);
              String str;
              if (i.this.xPR != null)
              {
                str = i.this.xPR.wUA;
                if ((paramAnonymousString == null) || (!paramAnonymousString.equals(str))) {
                  break label158;
                }
                ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "do shot");
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.a(this.xSt.xSy, str, "scene_timeline");
                i.this.xSn = false;
              }
              for (;;)
              {
                ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "enable touch and sensor after shot, isInLowPriority=" + i.this.xSr);
                if (!i.this.xSr) {
                  this.xSt.xSy.setSensorEnabled(true);
                }
                this.xSt.xSy.setTouchEnabled(true);
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
          if (((i.a)localObject).xSA.getVisibility() == 0)
          {
            ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "hide progressView");
            ((i.a)localObject).xSA.setVisibility(8);
          }
          AppMethodBeat.o(100099);
          return;
          label328:
          ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "don't need shot, enable sensor, isInLowPriority=" + i.this.xSr);
          if (!i.this.xSr) {
            ((i.a)localObject).xSy.setSensorEnabled(true);
          }
          i.this.xSn = false;
        }
      }
      
      public final void dwB() {}
      
      public final void dwC() {}
      
      public final void dwD()
      {
        AppMethodBeat.i(100098);
        i.a(i.this);
        AppMethodBeat.o(100098);
      }
      
      public final void onDetachedFromWindow()
      {
        int i = 0;
        AppMethodBeat.i(100100);
        ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onDetachedFromWindow reset");
        i.this.xSn = true;
        i.this.xSo = true;
        i.this.xSp = null;
        i.this.oFl.removeCallbacksAndMessages(null);
        try
        {
          Object localObject = new JSONObject();
          ((JSONObject)localObject).put("panCount", i.b(i.this));
          ((JSONObject)localObject).put("type", 1);
          String str2 = URLEncoder.encode(((JSONObject)localObject).toString(), "UTF-8");
          p localp = i.this.wNd.Ni(i.this.xSm.position);
          String str1 = localp.dyc();
          localObject = str1;
          if (str1 == null) {
            localObject = "";
          }
          com.tencent.mm.plugin.report.service.h.vKh.f(17539, new Object[] { localp.dxy().Id, localObject, localp.dxu().dvK, Integer.valueOf(1), str2 });
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
        i.c(i.this);
        AppMethodBeat.o(100100);
      }
    };
    this.xSr = false;
    AppMethodBeat.o(100105);
  }
  
  public final void a(SphereImageView paramSphereImageView, boolean paramBoolean)
  {
    AppMethodBeat.i(100108);
    ad.d("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "setIsInLowPriority, isInLowPriority=" + paramBoolean + ", hash=" + paramSphereImageView.hashCode());
    this.xSr = paramBoolean;
    if (paramBoolean)
    {
      paramSphereImageView.setSensorEnabled(false);
      AppMethodBeat.o(100108);
      return;
    }
    if (!this.xSn) {
      paramSphereImageView.setSensorEnabled(true);
    }
    AppMethodBeat.o(100108);
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, final bf parambf, TimeLineObject paramTimeLineObject, int paramInt2, be parambe)
  {
    AppMethodBeat.i(100107);
    for (;;)
    {
      try
      {
        long l1 = System.currentTimeMillis();
        if (paramBaseViewHolder.fUH)
        {
          ad.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem, holder is busy");
          AppMethodBeat.o(100107);
          return;
        }
        final a locala = (a)paramBaseViewHolder;
        Object localObject1 = parambf.wvM;
        if ((localObject1 == null) || (((p)localObject1).dxs() == null)) {
          break label1479;
        }
        paramTimeLineObject = ((p)localObject1).dxs().wTE;
        this.xPR = paramTimeLineObject;
        if ((Build.VERSION.SDK_INT < 24) && (paramTimeLineObject != null) && ((this.xSp == null) || (!this.xSp.equals(paramTimeLineObject.wUA))))
        {
          this.xSn = true;
          this.xSo = true;
          ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem, reset, sdk_int=" + Build.VERSION.SDK_INT);
        }
        parambf = new StringBuilder("fillItem, pos=").append(paramInt1).append(", hash=").append(locala.xSy.hashCode()).append(", isFirst=").append(this.xSo).append(", snsInfo.hash=");
        if (localObject1 != null)
        {
          paramInt1 = localObject1.hashCode();
          ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", paramInt1);
          parambf = null;
          locala.qXs.setVisibility(8);
          locala.xPh.setVisibility(8);
          locala.xPi.setVisibility(8);
          locala.xPg.setVisibility(8);
          locala.xPj.setVisibility(8);
          locala.xPk.setVisibility(8);
          locala.xPl.setVisibility(8);
          if (paramTimeLineObject == null) {
            break label1468;
          }
          localObject2 = (WindowManager)this.mActivity.getSystemService("window");
          paramInt1 = Math.min(((WindowManager)localObject2).getDefaultDisplay().getWidth(), ((WindowManager)localObject2).getDefaultDisplay().getHeight()) - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 56) - this.mActivity.getResources().getDimensionPixelSize(2131165490) - this.mActivity.getResources().getDimensionPixelSize(2131165516);
          if (paramTimeLineObject.wUk == 0)
          {
            parambf = new ViewGroup.LayoutParams(-2, -2);
            parambf.width = paramInt1;
            parambf.height = ((int)(parambf.width * 0.75F));
            if (parambf != null)
            {
              localObject2 = locala.xtU.getLayoutParams();
              ((ViewGroup.LayoutParams)localObject2).width = parambf.width;
              ((ViewGroup.LayoutParams)localObject2).height = parambf.height;
              locala.xtU.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              ((RoundedCornerFrameLayout)locala.xtU).setRadius(com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 8));
              localObject2 = locala.xSy.getLayoutParams();
              ((ViewGroup.LayoutParams)localObject2).width = parambf.width;
              ((ViewGroup.LayoutParams)localObject2).height = parambf.height;
              locala.xSy.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              parambf = locala.xSz.getLayoutParams();
              parambf.width = ((ViewGroup.LayoutParams)localObject2).width;
              parambf.height = ((ViewGroup.LayoutParams)localObject2).height;
              locala.xSz.setLayoutParams(parambf);
            }
            if (paramTimeLineObject.wUm != 0) {
              continue;
            }
            paramInt1 = Color.argb((int)(paramTimeLineObject.wUl * 2.55F), 0, 0, 0);
            paramInt2 = Color.argb(0, 0, 0, 0);
            parambf = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { paramInt1, paramInt2 });
            parambf.setGradientType(0);
            locala.qXs.setBackground(parambf);
            if ((!bt.isNullOrNil(paramTimeLineObject.title)) || (!bt.isNullOrNil(paramTimeLineObject.description))) {
              locala.qXs.setVisibility(0);
            }
            if (!bt.isNullOrNil(paramTimeLineObject.title))
            {
              locala.xPh.setVisibility(0);
              parambf = locala.xPh;
              localObject2 = g.eIa();
              locala.xPh.getContext();
              parambf.setText(((g)localObject2).b(paramTimeLineObject.title, locala.xPh.getTextSize()));
            }
            if (!bt.isNullOrNil(paramTimeLineObject.description))
            {
              locala.xPi.setVisibility(0);
              parambf = locala.xPi;
              localObject2 = g.eIa();
              locala.xPi.getContext();
              parambf.setText(((g)localObject2).b(paramTimeLineObject.description, locala.xPi.getTextSize()));
            }
            if ((localObject1 != null) && (((p)localObject1).dxu().dvd()))
            {
              paramInt1 = Color.argb((int)(paramTimeLineObject.wUl * 2.55F), 0, 0, 0);
              paramInt2 = Color.argb(0, 0, 0, 0);
              parambf = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { paramInt1, paramInt2 });
              parambf.setGradientType(0);
              locala.xPg.setVisibility(0);
              locala.xPg.setBackground(parambf);
              locala.xPl.setVisibility(0);
            }
            if (this.xSo)
            {
              locala.xSz.setVisibility(0);
              parambf = paramTimeLineObject.wUA;
              localObject1 = paramTimeLineObject.wUB;
              new a.c(parambf, (String)localObject1, "scene_timeline", new a.d()
              {
                public final void a(boolean paramAnonymousBoolean, String paramAnonymousString1, Bitmap paramAnonymousBitmap, String paramAnonymousString2)
                {
                  AppMethodBeat.i(100104);
                  if ((paramAnonymousString2 == null) || (!paramAnonymousString2.equals(parambf)))
                  {
                    AppMethodBeat.o(100104);
                    return;
                  }
                  if (paramAnonymousBitmap != null)
                  {
                    locala.xSz.setImageBitmap(paramAnonymousBitmap);
                    AppMethodBeat.o(100104);
                    return;
                  }
                  ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "show progressView");
                  locala.xSA.setVisibility(0);
                  locala.xSA.feJ();
                  if (!TextUtils.isEmpty(this.hhv))
                  {
                    ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "no shot and thumb cache, start download thumb image");
                    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(this.hhv, 133, new f.a()
                    {
                      String xSw;
                      
                      public final void apm(String paramAnonymous2String)
                      {
                        AppMethodBeat.i(100103);
                        ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onDownloaded thumb, path=".concat(String.valueOf(paramAnonymous2String)));
                        if (i.this.xPR != null) {}
                        for (String str = i.this.xPR.wUB; (this.xSw != null) && (this.xSw.equals(str)); str = "")
                        {
                          if (i.4.this.xSt.xSz.getVisibility() != 0) {
                            break label149;
                          }
                          try
                          {
                            paramAnonymous2String = MMBitmapFactory.decodeFile(paramAnonymous2String);
                            i.4.this.xSt.xSz.setImageBitmap(paramAnonymous2String);
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
                      
                      public final void dsA()
                      {
                        AppMethodBeat.i(100102);
                        ad.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onDownloadError thumb");
                        AppMethodBeat.o(100102);
                      }
                      
                      public final void duP() {}
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
            locala.xSy.setVisibility(0);
            locala.xSy.setOnClickListener(parambe.wMy.xUd);
            locala.xSy.setTag(paramBaseViewHolder);
            if ((!this.xSn) && (!this.xSr))
            {
              ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem !first, enable sensor");
              locala.xSy.setSensorEnabled(true);
            }
            if ((this.xSp == null) || (!this.xSp.equals(paramTimeLineObject.wUA)))
            {
              ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem, loadImage, hash=" + locala.xSy.hashCode());
              paramBaseViewHolder = locala.xSy.getLayoutParams();
              this.xdl.j(paramTimeLineObject.wUA, paramBaseViewHolder.width, paramBaseViewHolder.height, "scene_timeline");
              this.xSp = paramTimeLineObject.wUA;
            }
            this.xSo = false;
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
        if (paramTimeLineObject.wUk != 1) {
          continue;
        }
        parambf = new ViewGroup.LayoutParams(-2, -2);
        parambf.width = paramInt1;
        parambf.height = parambf.width;
        continue;
        if (paramTimeLineObject.wUm != 1) {
          continue;
        }
        paramInt1 = Color.argb((int)(paramTimeLineObject.wUl * 2.55F), 0, 0, 0);
        paramInt2 = Color.argb(0, 0, 0, 0);
        parambf = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { paramInt1, paramInt2 });
        parambf.setGradientType(0);
        locala.xPg.setBackground(parambf);
        if ((!bt.isNullOrNil(paramTimeLineObject.title)) || (!bt.isNullOrNil(paramTimeLineObject.description)))
        {
          locala.xPg.setVisibility(0);
          parambf = (RelativeLayout.LayoutParams)locala.xPl.getLayoutParams();
          parambf.topMargin = com.tencent.mm.cd.a.fromDPToPix(locala.xtU.getContext(), 4);
          locala.xPl.setLayoutParams(parambf);
        }
        if (!bt.isNullOrNil(paramTimeLineObject.title))
        {
          locala.xPj.setVisibility(0);
          parambf = locala.xPj;
          localObject2 = g.eIa();
          locala.xPj.getContext();
          parambf.setText(((g)localObject2).b(paramTimeLineObject.title, locala.xPj.getTextSize()));
        }
        if (bt.isNullOrNil(paramTimeLineObject.description)) {
          continue;
        }
        locala.xPk.setVisibility(0);
        parambf = locala.xPk;
        Object localObject2 = g.eIa();
        locala.xPk.getContext();
        parambf.setText(((g)localObject2).b(paramTimeLineObject.description, locala.xPk.getTextSize()));
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
  
  public final void e(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100106);
    for (;;)
    {
      try
      {
        final a locala = (a)paramBaseViewHolder;
        this.xSm = locala;
        ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "buildContent, holder=" + paramBaseViewHolder.hashCode());
        if (paramBaseViewHolder.xQw != null)
        {
          paramBaseViewHolder.xQw.setLayoutResource(2131495604);
          if (!paramBaseViewHolder.xQx)
          {
            locala.xtU = paramBaseViewHolder.xQw.inflate();
            paramBaseViewHolder.xQx = true;
          }
          locala.qXs = locala.rLd.findViewById(2131306008);
          locala.xPg = locala.rLd.findViewById(2131297449);
          locala.xPh = ((TextView)locala.rLd.findViewById(2131306010));
          locala.xPi = ((TextView)locala.rLd.findViewById(2131306009));
          locala.xPj = ((TextView)locala.rLd.findViewById(2131297451));
          locala.xPk = ((TextView)locala.rLd.findViewById(2131297450));
          locala.xSy = ((SphereImageView)locala.rLd.findViewById(2131305148));
          locala.xPl = locala.rLd.findViewById(2131297455);
          locala.xSz = ((ImageView)locala.rLd.findViewById(2131302164));
          locala.xSA = ((MMPinProgressBtn)locala.rLd.findViewById(2131303515));
          locala.xSA.setMax(50);
          ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "buildContent, disable touch and sensor");
          locala.xSy.setTouchEnabled(false);
          locala.xSy.setSensorEnabled(false);
          locala.xSy.X(1.8F, -2.0F);
          locala.xSy.setTouchSensitivity(0.45F);
          locala.xSy.setEventListener(this.xgT);
          this.xdl = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a();
          this.xdl.a(this.xSq);
          if (this.xPR == null)
          {
            i = 0;
            this.oFl.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(100094);
                ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "enable touch, delay=" + i);
                locala.xSy.setTouchEnabled(true);
                AppMethodBeat.o(100094);
              }
            }, i);
            ad.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "viewHash=" + locala.xSy.hashCode() + ", touchDelay=" + i);
            AppMethodBeat.o(100106);
          }
        }
        else
        {
          if (paramBaseViewHolder.xQx) {
            continue;
          }
          locala.xtU = paramBaseViewHolder.rLd.findViewById(2131305147);
          paramBaseViewHolder.xQx = true;
          continue;
        }
        final int i = this.xPR.wUz;
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
    public View qXs;
    public View xPg;
    public TextView xPh;
    public TextView xPi;
    public TextView xPj;
    public TextView xPk;
    public View xPl;
    public MMPinProgressBtn xSA;
    public SphereImageView xSy;
    public ImageView xSz;
    public View xtU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.i
 * JD-Core Version:    0.7.0.1
 */