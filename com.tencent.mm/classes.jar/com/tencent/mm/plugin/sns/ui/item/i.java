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
import com.tencent.mm.cf.g;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.b.i;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.plugin.sns.ui.bf;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.net.URLEncoder;
import org.json.JSONObject;

public final class i
  extends BaseTimeLineItem
{
  protected ao gqT;
  protected com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a yqa;
  private int yqb;
  protected SphereImageView.b ytH;
  protected b.i zcH;
  protected a zfh;
  protected boolean zfi;
  protected boolean zfj;
  protected String zfk;
  protected a.d zfl;
  boolean zfm;
  
  public i()
  {
    AppMethodBeat.i(100105);
    this.zfi = true;
    this.zfj = true;
    this.zfk = null;
    this.gqT = new ao(Looper.getMainLooper());
    this.yqb = 0;
    this.zfl = new a.d()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString1, Bitmap paramAnonymousBitmap, String paramAnonymousString2)
      {
        AppMethodBeat.i(100095);
        ac.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "ImageLoader onFinish, isSucc=" + paramAnonymousBoolean + ", errInfo=" + paramAnonymousString1);
        if (i.this.zfh == null)
        {
          ac.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onFinish, mViewHolder==null");
          AppMethodBeat.o(100095);
          return;
        }
        if (i.this.zcH != null) {}
        for (paramAnonymousString1 = i.this.zcH.yho; (paramAnonymousString2 != null) && (paramAnonymousString2.equals(paramAnonymousString1)); paramAnonymousString1 = "")
        {
          i.this.zfh.zft.g(paramAnonymousBitmap, paramAnonymousString2);
          AppMethodBeat.o(100095);
          return;
        }
        ac.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onFinish, url != nowUrl");
        AppMethodBeat.o(100095);
      }
      
      public final void onStart(String paramAnonymousString) {}
    };
    this.ytH = new SphereImageView.b()
    {
      public final void auI(final String paramAnonymousString)
      {
        AppMethodBeat.i(100099);
        if (i.this.zcH != null) {}
        for (Object localObject = i.this.zcH.yho; (paramAnonymousString != null) && (!paramAnonymousString.equals(localObject)); localObject = "")
        {
          ac.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onUpdateImage, url != CardInfo.sphereImageUrl, url=" + paramAnonymousString + ", info.url=" + (String)localObject);
          AppMethodBeat.o(100099);
          return;
        }
        localObject = i.this.zfh;
        if (localObject == null)
        {
          ac.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onUpdateImage, viewHolder==null");
          AppMethodBeat.o(100099);
          return;
        }
        ac.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onUpdateImage, isFirstUpdateImage=" + i.this.zfi + ", visiable=" + ((i.a)localObject).zfu.getVisibility());
        if (i.this.zfi)
        {
          if (((i.a)localObject).zfu.getVisibility() == 0)
          {
            AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
            localAlphaAnimation.setDuration(350L);
            localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
            {
              public final void onAnimationEnd(Animation paramAnonymous2Animation)
              {
                AppMethodBeat.i(100096);
                this.zfo.zfu.setVisibility(8);
                this.zfo.zfu.setImageDrawable(new ColorDrawable(this.zfo.zfu.getContext().getResources().getColor(2131099651)));
                AppMethodBeat.o(100096);
              }
              
              public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
              
              public final void onAnimationStart(Animation paramAnonymous2Animation) {}
            });
            ac.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "do maskImage anim");
            ((i.a)localObject).zfu.startAnimation(localAlphaAnimation);
          }
          if ((i.this.zcH == null) || (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.jq(i.this.zcH.yho, "scene_timeline"))) {
            break label328;
          }
          ac.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "disable touch before shot");
          ((i.a)localObject).zft.setTouchEnabled(false);
          ((i.a)localObject).zft.dLJ();
          ((i.a)localObject).zft.ysx.requestRender();
          i.this.gqT.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(100097);
              String str;
              if (i.this.zcH != null)
              {
                str = i.this.zcH.yho;
                if ((paramAnonymousString == null) || (!paramAnonymousString.equals(str))) {
                  break label158;
                }
                ac.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "do shot");
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.a(this.zfo.zft, str, "scene_timeline");
                i.this.zfi = false;
              }
              for (;;)
              {
                ac.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "enable touch and sensor after shot, isInLowPriority=" + i.this.zfm);
                if (!i.this.zfm) {
                  this.zfo.zft.setSensorEnabled(true);
                }
                this.zfo.zft.setTouchEnabled(true);
                AppMethodBeat.o(100097);
                return;
                str = "";
                break;
                label158:
                ac.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "before do shot, url != CardInfo.sphereImageUrl, url=" + paramAnonymousString + ", info.url=" + str);
              }
            }
          }, 800L);
        }
        for (;;)
        {
          if (((i.a)localObject).zfv.getVisibility() == 0)
          {
            ac.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "hide progressView");
            ((i.a)localObject).zfv.setVisibility(8);
          }
          AppMethodBeat.o(100099);
          return;
          label328:
          ac.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "don't need shot, enable sensor, isInLowPriority=" + i.this.zfm);
          if (!i.this.zfm) {
            ((i.a)localObject).zft.setSensorEnabled(true);
          }
          i.this.zfi = false;
        }
      }
      
      public final void dLa() {}
      
      public final void dLb() {}
      
      public final void dLc()
      {
        AppMethodBeat.i(100098);
        i.a(i.this);
        AppMethodBeat.o(100098);
      }
      
      public final void onDetachedFromWindow()
      {
        int i = 0;
        AppMethodBeat.i(100100);
        ac.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onDetachedFromWindow reset");
        i.this.zfi = true;
        i.this.zfj = true;
        i.this.zfk = null;
        i.this.gqT.removeCallbacksAndMessages(null);
        try
        {
          Object localObject = new JSONObject();
          ((JSONObject)localObject).put("panCount", i.b(i.this));
          ((JSONObject)localObject).put("type", 1);
          String str2 = URLEncoder.encode(((JSONObject)localObject).toString(), "UTF-8");
          p localp = i.this.xZJ.Pl(i.this.zfh.position);
          String str1 = localp.dMz();
          localObject = str1;
          if (str1 == null) {
            localObject = "";
          }
          com.tencent.mm.plugin.report.service.h.wUl.f(17539, new Object[] { localp.dLV().Id, localObject, localp.dFQ().dtx, Integer.valueOf(1), str2 });
          localObject = new StringBuilder("KVReport, id=17539, touchCount=").append(str2).append(", snsInfo.hash=");
          if (localp != null) {
            i = localp.hashCode();
          }
          ac.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", i);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ac.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "kvStat exp:" + localException.toString());
          }
        }
        i.c(i.this);
        AppMethodBeat.o(100100);
      }
    };
    this.zfm = false;
    AppMethodBeat.o(100105);
  }
  
  public final void a(SphereImageView paramSphereImageView, boolean paramBoolean)
  {
    AppMethodBeat.i(100108);
    ac.d("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "setIsInLowPriority, isInLowPriority=" + paramBoolean + ", hash=" + paramSphereImageView.hashCode());
    this.zfm = paramBoolean;
    if (paramBoolean)
    {
      paramSphereImageView.setSensorEnabled(false);
      AppMethodBeat.o(100108);
      return;
    }
    if (!this.zfi) {
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
        if (paramBaseViewHolder.fYC)
        {
          ac.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem, holder is busy");
          AppMethodBeat.o(100107);
          return;
        }
        final a locala = (a)paramBaseViewHolder;
        Object localObject1 = parambf.xHc;
        if ((localObject1 == null) || (((p)localObject1).dFR() == null)) {
          break label1479;
        }
        paramTimeLineObject = ((p)localObject1).dFR().ygo;
        this.zcH = paramTimeLineObject;
        if ((Build.VERSION.SDK_INT < 24) && (paramTimeLineObject != null) && ((this.zfk == null) || (!this.zfk.equals(paramTimeLineObject.yho))))
        {
          this.zfi = true;
          this.zfj = true;
          ac.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem, reset, sdk_int=" + Build.VERSION.SDK_INT);
        }
        parambf = new StringBuilder("fillItem, pos=").append(paramInt1).append(", hash=").append(locala.zft.hashCode()).append(", isFirst=").append(this.zfj).append(", snsInfo.hash=");
        if (localObject1 != null)
        {
          paramInt1 = localObject1.hashCode();
          ac.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", paramInt1);
          parambf = null;
          locala.rXY.setVisibility(8);
          locala.zbX.setVisibility(8);
          locala.zbY.setVisibility(8);
          locala.zbW.setVisibility(8);
          locala.zbZ.setVisibility(8);
          locala.zca.setVisibility(8);
          locala.zcb.setVisibility(8);
          if (paramTimeLineObject == null) {
            break label1468;
          }
          localObject2 = (WindowManager)this.mActivity.getSystemService("window");
          paramInt1 = Math.min(((WindowManager)localObject2).getDefaultDisplay().getWidth(), ((WindowManager)localObject2).getDefaultDisplay().getHeight()) - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 56) - this.mActivity.getResources().getDimensionPixelSize(2131165490) - this.mActivity.getResources().getDimensionPixelSize(2131165516);
          if (paramTimeLineObject.ygY == 0)
          {
            parambf = new ViewGroup.LayoutParams(-2, -2);
            parambf.width = paramInt1;
            parambf.height = ((int)(parambf.width * 0.75F));
            if (parambf != null)
            {
              localObject2 = locala.yGK.getLayoutParams();
              ((ViewGroup.LayoutParams)localObject2).width = parambf.width;
              ((ViewGroup.LayoutParams)localObject2).height = parambf.height;
              locala.yGK.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              ((RoundedCornerFrameLayout)locala.yGK).setRadius(com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 8));
              localObject2 = locala.zft.getLayoutParams();
              ((ViewGroup.LayoutParams)localObject2).width = parambf.width;
              ((ViewGroup.LayoutParams)localObject2).height = parambf.height;
              locala.zft.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              parambf = locala.zfu.getLayoutParams();
              parambf.width = ((ViewGroup.LayoutParams)localObject2).width;
              parambf.height = ((ViewGroup.LayoutParams)localObject2).height;
              locala.zfu.setLayoutParams(parambf);
            }
            if (paramTimeLineObject.yha != 0) {
              continue;
            }
            paramInt1 = Color.argb((int)(paramTimeLineObject.ygZ * 2.55F), 0, 0, 0);
            paramInt2 = Color.argb(0, 0, 0, 0);
            parambf = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { paramInt1, paramInt2 });
            parambf.setGradientType(0);
            locala.rXY.setBackground(parambf);
            if ((!bs.isNullOrNil(paramTimeLineObject.title)) || (!bs.isNullOrNil(paramTimeLineObject.description))) {
              locala.rXY.setVisibility(0);
            }
            if (!bs.isNullOrNil(paramTimeLineObject.title))
            {
              locala.zbX.setVisibility(0);
              parambf = locala.zbX;
              localObject2 = g.eXw();
              locala.zbX.getContext();
              parambf.setText(((g)localObject2).b(paramTimeLineObject.title, locala.zbX.getTextSize()));
            }
            if (!bs.isNullOrNil(paramTimeLineObject.description))
            {
              locala.zbY.setVisibility(0);
              parambf = locala.zbY;
              localObject2 = g.eXw();
              locala.zbY.getContext();
              parambf.setText(((g)localObject2).b(paramTimeLineObject.description, locala.zbY.getTextSize()));
            }
            if ((localObject1 != null) && (((p)localObject1).dFQ().dJC()))
            {
              paramInt1 = Color.argb((int)(paramTimeLineObject.ygZ * 2.55F), 0, 0, 0);
              paramInt2 = Color.argb(0, 0, 0, 0);
              parambf = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { paramInt1, paramInt2 });
              parambf.setGradientType(0);
              locala.zbW.setVisibility(0);
              locala.zbW.setBackground(parambf);
              locala.zcb.setVisibility(0);
            }
            if (this.zfj)
            {
              locala.zfu.setVisibility(0);
              parambf = paramTimeLineObject.yho;
              localObject1 = paramTimeLineObject.yhp;
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
                    locala.zfu.setImageBitmap(paramAnonymousBitmap);
                    AppMethodBeat.o(100104);
                    return;
                  }
                  ac.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "show progressView");
                  locala.zfv.setVisibility(0);
                  locala.zfv.fuE();
                  if (!TextUtils.isEmpty(this.hHY))
                  {
                    ac.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "no shot and thumb cache, start download thumb image");
                    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(this.hHY, 133, new f.a()
                    {
                      String zfr;
                      
                      public final void asD(String paramAnonymous2String)
                      {
                        AppMethodBeat.i(100103);
                        ac.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onDownloaded thumb, path=".concat(String.valueOf(paramAnonymous2String)));
                        if (i.this.zcH != null) {}
                        for (String str = i.this.zcH.yhp; (this.zfr != null) && (this.zfr.equals(str)); str = "")
                        {
                          if (i.4.this.zfo.zfu.getVisibility() != 0) {
                            break label149;
                          }
                          try
                          {
                            paramAnonymous2String = MMBitmapFactory.decodeFile(paramAnonymous2String);
                            i.4.this.zfo.zfu.setImageBitmap(paramAnonymous2String);
                            AppMethodBeat.o(100103);
                            return;
                          }
                          catch (Throwable paramAnonymous2String)
                          {
                            ac.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onDownloaded thumb exp:" + paramAnonymous2String.toString());
                            AppMethodBeat.o(100103);
                            return;
                          }
                        }
                        ac.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onDownloaded, url != nowUrl");
                        label149:
                        AppMethodBeat.o(100103);
                      }
                      
                      public final void dFC() {}
                      
                      public final void dFD()
                      {
                        AppMethodBeat.i(100102);
                        ac.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onDownloadError thumb");
                        AppMethodBeat.o(100102);
                      }
                    });
                    AppMethodBeat.o(100104);
                    return;
                  }
                  ac.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "thumbUrl is empty");
                  AppMethodBeat.o(100104);
                }
                
                public final void onStart(String paramAnonymousString) {}
              }).execute(new Void[0]);
            }
            locala.zft.setVisibility(0);
            locala.zft.setOnClickListener(parambe.xZe.zgZ);
            locala.zft.setTag(paramBaseViewHolder);
            if ((!this.zfi) && (!this.zfm))
            {
              ac.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem !first, enable sensor");
              locala.zft.setSensorEnabled(true);
            }
            if ((this.zfk == null) || (!this.zfk.equals(paramTimeLineObject.yho)))
            {
              ac.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem, loadImage, hash=" + locala.zft.hashCode());
              paramBaseViewHolder = locala.zft.getLayoutParams();
              this.yqa.k(paramTimeLineObject.yho, paramBaseViewHolder.width, paramBaseViewHolder.height, "scene_timeline");
              this.zfk = paramTimeLineObject.yho;
            }
            this.zfj = false;
            long l2 = System.currentTimeMillis();
            ac.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem total timeCost=" + (l2 - l1));
            AppMethodBeat.o(100107);
          }
        }
        else
        {
          paramInt1 = 0;
          continue;
        }
        if (paramTimeLineObject.ygY != 1) {
          continue;
        }
        parambf = new ViewGroup.LayoutParams(-2, -2);
        parambf.width = paramInt1;
        parambf.height = parambf.width;
        continue;
        if (paramTimeLineObject.yha != 1) {
          continue;
        }
        paramInt1 = Color.argb((int)(paramTimeLineObject.ygZ * 2.55F), 0, 0, 0);
        paramInt2 = Color.argb(0, 0, 0, 0);
        parambf = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { paramInt1, paramInt2 });
        parambf.setGradientType(0);
        locala.zbW.setBackground(parambf);
        if ((!bs.isNullOrNil(paramTimeLineObject.title)) || (!bs.isNullOrNil(paramTimeLineObject.description)))
        {
          locala.zbW.setVisibility(0);
          parambf = (RelativeLayout.LayoutParams)locala.zcb.getLayoutParams();
          parambf.topMargin = com.tencent.mm.cc.a.fromDPToPix(locala.yGK.getContext(), 4);
          locala.zcb.setLayoutParams(parambf);
        }
        if (!bs.isNullOrNil(paramTimeLineObject.title))
        {
          locala.zbZ.setVisibility(0);
          parambf = locala.zbZ;
          localObject2 = g.eXw();
          locala.zbZ.getContext();
          parambf.setText(((g)localObject2).b(paramTimeLineObject.title, locala.zbZ.getTextSize()));
        }
        if (bs.isNullOrNil(paramTimeLineObject.description)) {
          continue;
        }
        locala.zca.setVisibility(0);
        parambf = locala.zca;
        Object localObject2 = g.eXw();
        locala.zca.getContext();
        parambf.setText(((g)localObject2).b(paramTimeLineObject.description, locala.zca.getTextSize()));
        continue;
        ac.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "sphereCardInfo==null, invalid sphereCard");
      }
      catch (Throwable paramBaseViewHolder)
      {
        ac.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem exp=" + paramBaseViewHolder.toString());
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
        this.zfh = locala;
        ac.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "buildContent, holder=" + paramBaseViewHolder.hashCode());
        if (paramBaseViewHolder.zdm != null)
        {
          paramBaseViewHolder.zdm.setLayoutResource(2131495604);
          if (!paramBaseViewHolder.zdn)
          {
            locala.yGK = paramBaseViewHolder.zdm.inflate();
            paramBaseViewHolder.zdn = true;
          }
          locala.rXY = locala.sSS.findViewById(2131306008);
          locala.zbW = locala.sSS.findViewById(2131297449);
          locala.zbX = ((TextView)locala.sSS.findViewById(2131306010));
          locala.zbY = ((TextView)locala.sSS.findViewById(2131306009));
          locala.zbZ = ((TextView)locala.sSS.findViewById(2131297451));
          locala.zca = ((TextView)locala.sSS.findViewById(2131297450));
          locala.zft = ((SphereImageView)locala.sSS.findViewById(2131305148));
          locala.zcb = locala.sSS.findViewById(2131297455);
          locala.zfu = ((ImageView)locala.sSS.findViewById(2131302164));
          locala.zfv = ((MMPinProgressBtn)locala.sSS.findViewById(2131303515));
          locala.zfv.setMax(50);
          ac.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "buildContent, disable touch and sensor");
          locala.zft.setTouchEnabled(false);
          locala.zft.setSensorEnabled(false);
          locala.zft.ab(1.8F, -2.0F);
          locala.zft.setTouchSensitivity(0.45F);
          locala.zft.setEventListener(this.ytH);
          this.yqa = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a();
          this.yqa.a(this.zfl);
          if (this.zcH == null)
          {
            i = 0;
            this.gqT.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(100094);
                ac.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "enable touch, delay=" + i);
                locala.zft.setTouchEnabled(true);
                AppMethodBeat.o(100094);
              }
            }, i);
            ac.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "viewHash=" + locala.zft.hashCode() + ", touchDelay=" + i);
            AppMethodBeat.o(100106);
          }
        }
        else
        {
          if (paramBaseViewHolder.zdn) {
            continue;
          }
          locala.yGK = paramBaseViewHolder.sSS.findViewById(2131305147);
          paramBaseViewHolder.zdn = true;
          continue;
        }
        final int i = this.zcH.yhn;
      }
      catch (Throwable paramBaseViewHolder)
      {
        ac.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "buildContent exp=" + paramBaseViewHolder.toString());
        AppMethodBeat.o(100106);
        return;
      }
    }
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    public View rXY;
    public View yGK;
    public View zbW;
    public TextView zbX;
    public TextView zbY;
    public TextView zbZ;
    public TextView zca;
    public View zcb;
    public SphereImageView zft;
    public ImageView zfu;
    public MMPinProgressBtn zfv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.i
 * JD-Core Version:    0.7.0.1
 */