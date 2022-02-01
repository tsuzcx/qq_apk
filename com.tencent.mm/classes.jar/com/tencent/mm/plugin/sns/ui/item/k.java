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
import com.tencent.mm.plugin.sns.storage.b.j;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.plugin.sns.ui.bi;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.net.URLEncoder;
import org.json.JSONObject;

public final class k
  extends BaseTimeLineItem
{
  protected b.j ALN;
  protected boolean AOA;
  protected String AOB;
  protected a.d AOC;
  boolean AOD;
  protected a AOy;
  protected boolean AOz;
  protected SphereImageView.b Acb;
  protected aq gNm;
  protected com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a zYp;
  private int zYq;
  
  public k()
  {
    AppMethodBeat.i(100105);
    this.AOz = true;
    this.AOA = true;
    this.AOB = null;
    this.gNm = new aq(Looper.getMainLooper());
    this.zYq = 0;
    this.AOC = new a.d()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString1, Bitmap paramAnonymousBitmap, String paramAnonymousString2)
      {
        AppMethodBeat.i(100095);
        ae.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "ImageLoader onFinish, isSucc=" + paramAnonymousBoolean + ", errInfo=" + paramAnonymousString1);
        if (k.this.AOy == null)
        {
          ae.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onFinish, mViewHolder==null");
          AppMethodBeat.o(100095);
          return;
        }
        if (k.this.ALN != null) {}
        for (paramAnonymousString1 = k.this.ALN.zOU; (paramAnonymousString2 != null) && (paramAnonymousString2.equals(paramAnonymousString1)); paramAnonymousString1 = "")
        {
          k.this.AOy.AOK.g(paramAnonymousBitmap, paramAnonymousString2);
          AppMethodBeat.o(100095);
          return;
        }
        ae.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onFinish, url != nowUrl");
        AppMethodBeat.o(100095);
      }
      
      public final void onStart(String paramAnonymousString) {}
    };
    this.Acb = new SphereImageView.b()
    {
      public final void aBg(final String paramAnonymousString)
      {
        AppMethodBeat.i(100099);
        if (k.this.ALN != null) {}
        for (Object localObject = k.this.ALN.zOU; (paramAnonymousString != null) && (!paramAnonymousString.equals(localObject)); localObject = "")
        {
          ae.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onUpdateImage, url != CardInfo.sphereImageUrl, url=" + paramAnonymousString + ", info.url=" + (String)localObject);
          AppMethodBeat.o(100099);
          return;
        }
        localObject = k.this.AOy;
        if (localObject == null)
        {
          ae.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onUpdateImage, viewHolder==null");
          AppMethodBeat.o(100099);
          return;
        }
        ae.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onUpdateImage, isFirstUpdateImage=" + k.this.AOz + ", visiable=" + ((k.a)localObject).AOL.getVisibility());
        if (k.this.AOz)
        {
          if (((k.a)localObject).AOL.getVisibility() == 0)
          {
            AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
            localAlphaAnimation.setDuration(350L);
            localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
            {
              public final void onAnimationEnd(Animation paramAnonymous2Animation)
              {
                AppMethodBeat.i(100096);
                this.AOF.AOL.setVisibility(8);
                this.AOF.AOL.setImageDrawable(new ColorDrawable(this.AOF.AOL.getContext().getResources().getColor(2131099651)));
                AppMethodBeat.o(100096);
              }
              
              public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
              
              public final void onAnimationStart(Animation paramAnonymous2Animation) {}
            });
            ae.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "do maskImage anim");
            ((k.a)localObject).AOL.startAnimation(localAlphaAnimation);
          }
          if ((k.this.ALN == null) || (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.jJ(k.this.ALN.zOU, "scene_timeline"))) {
            break label328;
          }
          ae.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "disable touch before shot");
          ((k.a)localObject).AOK.setTouchEnabled(false);
          ((k.a)localObject).AOK.ebD();
          ((k.a)localObject).AOK.AaM.requestRender();
          k.this.gNm.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(100097);
              String str;
              if (k.this.ALN != null)
              {
                str = k.this.ALN.zOU;
                if ((paramAnonymousString == null) || (!paramAnonymousString.equals(str))) {
                  break label158;
                }
                ae.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "do shot");
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.a(this.AOF.AOK, str, "scene_timeline");
                k.this.AOz = false;
              }
              for (;;)
              {
                ae.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "enable touch and sensor after shot, isInLowPriority=" + k.this.AOD);
                if (!k.this.AOD) {
                  this.AOF.AOK.setSensorEnabled(true);
                }
                this.AOF.AOK.setTouchEnabled(true);
                AppMethodBeat.o(100097);
                return;
                str = "";
                break;
                label158:
                ae.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "before do shot, url != CardInfo.sphereImageUrl, url=" + paramAnonymousString + ", info.url=" + str);
              }
            }
          }, 800L);
        }
        for (;;)
        {
          if (((k.a)localObject).AOM.getVisibility() == 0)
          {
            ae.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "hide progressView");
            ((k.a)localObject).AOM.setVisibility(8);
          }
          AppMethodBeat.o(100099);
          return;
          label328:
          ae.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "don't need shot, enable sensor, isInLowPriority=" + k.this.AOD);
          if (!k.this.AOD) {
            ((k.a)localObject).AOK.setSensorEnabled(true);
          }
          k.this.AOz = false;
        }
      }
      
      public final void eaU() {}
      
      public final void eaV() {}
      
      public final void eaW()
      {
        AppMethodBeat.i(100098);
        k.a(k.this);
        AppMethodBeat.o(100098);
      }
      
      public final void onDetachedFromWindow()
      {
        int i = 0;
        AppMethodBeat.i(100100);
        ae.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onDetachedFromWindow reset");
        k.this.AOz = true;
        k.this.AOA = true;
        k.this.AOB = null;
        k.this.gNm.removeCallbacksAndMessages(null);
        try
        {
          Object localObject = new JSONObject();
          ((JSONObject)localObject).put("panCount", k.b(k.this));
          ((JSONObject)localObject).put("type", 1);
          String str2 = URLEncoder.encode(((JSONObject)localObject).toString(), "UTF-8");
          p localp = k.this.zGX.RA(k.this.AOy.position);
          String str1 = localp.ect();
          localObject = str1;
          if (str1 == null) {
            localObject = "";
          }
          com.tencent.mm.plugin.report.service.g.yxI.f(17539, new Object[] { localp.ebP().Id, localObject, localp.dVi().dGD, Integer.valueOf(1), str2 });
          localObject = new StringBuilder("KVReport, id=17539, touchCount=").append(str2).append(", snsInfo.hash=");
          if (localp != null) {
            i = localp.hashCode();
          }
          ae.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", i);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ae.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "kvStat exp:" + localException.toString());
          }
        }
        k.c(k.this);
        AppMethodBeat.o(100100);
      }
    };
    this.AOD = false;
    AppMethodBeat.o(100105);
  }
  
  public final void a(SphereImageView paramSphereImageView, boolean paramBoolean)
  {
    AppMethodBeat.i(100108);
    ae.d("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "setIsInLowPriority, isInLowPriority=" + paramBoolean + ", hash=" + paramSphereImageView.hashCode());
    this.AOD = paramBoolean;
    if (paramBoolean)
    {
      paramSphereImageView.setSensorEnabled(false);
      AppMethodBeat.o(100108);
      return;
    }
    if (!this.AOz) {
      paramSphereImageView.setSensorEnabled(true);
    }
    AppMethodBeat.o(100108);
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, final bi parambi, final TimeLineObject paramTimeLineObject, int paramInt2, bh parambh)
  {
    AppMethodBeat.i(100107);
    for (;;)
    {
      try
      {
        long l1 = System.currentTimeMillis();
        if (paramBaseViewHolder.guz)
        {
          ae.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem, holder is busy");
          AppMethodBeat.o(100107);
          return;
        }
        final a locala = (a)paramBaseViewHolder;
        p localp = parambi.zlW;
        if ((localp == null) || (localp.dVj() == null)) {
          break label1504;
        }
        localj = localp.dVj().zNL;
        this.ALN = localj;
        if ((Build.VERSION.SDK_INT < 24) && (localj != null) && ((this.AOB == null) || (!this.AOB.equals(localj.zOU))))
        {
          this.AOz = true;
          this.AOA = true;
          ae.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem, reset, sdk_int=" + Build.VERSION.SDK_INT);
        }
        StringBuilder localStringBuilder = new StringBuilder("ad fillItem, sphereCard, pos=").append(paramInt1).append(", snsId=");
        if (paramTimeLineObject == null)
        {
          parambi = "";
          parambi = localStringBuilder.append(parambi).append(", hash=").append(locala.AOK.hashCode()).append(", isFirst=").append(this.AOA).append(", snsInfo.hash=");
          if (localp == null) {
            break label1510;
          }
          paramInt1 = localp.hashCode();
          ae.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", paramInt1);
          parambi = null;
          locala.tgh.setVisibility(8);
          locala.ALd.setVisibility(8);
          locala.ALe.setVisibility(8);
          locala.ALc.setVisibility(8);
          locala.ALf.setVisibility(8);
          locala.ALg.setVisibility(8);
          locala.ALh.setVisibility(8);
          if (localj == null) {
            break label1493;
          }
          paramTimeLineObject = (WindowManager)this.mActivity.getSystemService("window");
          paramInt1 = Math.min(paramTimeLineObject.getDefaultDisplay().getWidth(), paramTimeLineObject.getDefaultDisplay().getHeight()) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 56) - this.mActivity.getResources().getDimensionPixelSize(2131165490) - this.mActivity.getResources().getDimensionPixelSize(2131165516);
          if (localj.zOE == 0)
          {
            parambi = new ViewGroup.LayoutParams(-2, -2);
            parambi.width = paramInt1;
            parambi.height = ((int)(parambi.width * 0.75F));
            if (parambi != null)
            {
              paramTimeLineObject = locala.Apn.getLayoutParams();
              paramTimeLineObject.width = parambi.width;
              paramTimeLineObject.height = parambi.height;
              locala.Apn.setLayoutParams(paramTimeLineObject);
              ((RoundedCornerFrameLayout)locala.Apn).setRadius(com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 8));
              paramTimeLineObject = locala.AOK.getLayoutParams();
              paramTimeLineObject.width = parambi.width;
              paramTimeLineObject.height = parambi.height;
              locala.AOK.setLayoutParams(paramTimeLineObject);
              parambi = locala.AOL.getLayoutParams();
              parambi.width = paramTimeLineObject.width;
              parambi.height = paramTimeLineObject.height;
              locala.AOL.setLayoutParams(parambi);
            }
            if (localj.zOG != 0) {
              continue;
            }
            paramInt1 = Color.argb((int)(localj.zOF * 2.55F), 0, 0, 0);
            paramInt2 = Color.argb(0, 0, 0, 0);
            parambi = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { paramInt1, paramInt2 });
            parambi.setGradientType(0);
            locala.tgh.setBackground(parambi);
            if ((!bu.isNullOrNil(localj.title)) || (!bu.isNullOrNil(localj.description))) {
              locala.tgh.setVisibility(0);
            }
            if (!bu.isNullOrNil(localj.title))
            {
              locala.ALd.setVisibility(0);
              parambi = locala.ALd;
              paramTimeLineObject = com.tencent.mm.ce.g.fqZ();
              locala.ALd.getContext();
              parambi.setText(paramTimeLineObject.b(localj.title, locala.ALd.getTextSize()));
            }
            if (!bu.isNullOrNil(localj.description))
            {
              locala.ALe.setVisibility(0);
              parambi = locala.ALe;
              paramTimeLineObject = com.tencent.mm.ce.g.fqZ();
              locala.ALe.getContext();
              parambi.setText(paramTimeLineObject.b(localj.description, locala.ALe.getTextSize()));
            }
            if ((localp != null) && (localp.dVi().dZr()))
            {
              paramInt1 = Color.argb((int)(localj.zOF * 2.55F), 0, 0, 0);
              paramInt2 = Color.argb(0, 0, 0, 0);
              parambi = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { paramInt1, paramInt2 });
              parambi.setGradientType(0);
              locala.ALc.setVisibility(0);
              locala.ALc.setBackground(parambi);
              locala.ALh.setVisibility(0);
            }
            if (this.AOA)
            {
              locala.AOL.setVisibility(0);
              parambi = localj.zOU;
              paramTimeLineObject = localj.zOV;
              new a.c(parambi, paramTimeLineObject, "scene_timeline", new a.d()
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
                    locala.AOL.setImageBitmap(paramAnonymousBitmap);
                    AppMethodBeat.o(100104);
                    return;
                  }
                  ae.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "show progressView");
                  locala.AOM.setVisibility(0);
                  locala.AOM.fPL();
                  if (!TextUtils.isEmpty(paramTimeLineObject))
                  {
                    ae.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "no shot and thumb cache, start download thumb image");
                    h.a(paramTimeLineObject, 133, new f.a()
                    {
                      String AOI;
                      
                      public final void ayY(String paramAnonymous2String)
                      {
                        AppMethodBeat.i(100103);
                        ae.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onDownloaded thumb, path=".concat(String.valueOf(paramAnonymous2String)));
                        if (k.this.ALN != null) {}
                        for (String str = k.this.ALN.zOV; (this.AOI != null) && (this.AOI.equals(str)); str = "")
                        {
                          if (k.4.this.AOF.AOL.getVisibility() != 0) {
                            break label149;
                          }
                          try
                          {
                            paramAnonymous2String = MMBitmapFactory.decodeFile(paramAnonymous2String);
                            k.4.this.AOF.AOL.setImageBitmap(paramAnonymous2String);
                            AppMethodBeat.o(100103);
                            return;
                          }
                          catch (Throwable paramAnonymous2String)
                          {
                            ae.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onDownloaded thumb exp:" + paramAnonymous2String.toString());
                            AppMethodBeat.o(100103);
                            return;
                          }
                        }
                        ae.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onDownloaded, url != nowUrl");
                        label149:
                        AppMethodBeat.o(100103);
                      }
                      
                      public final void dVu() {}
                      
                      public final void dVv()
                      {
                        AppMethodBeat.i(100102);
                        ae.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onDownloadError thumb");
                        AppMethodBeat.o(100102);
                      }
                    });
                    AppMethodBeat.o(100104);
                    return;
                  }
                  ae.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "thumbUrl is empty");
                  AppMethodBeat.o(100104);
                }
                
                public final void onStart(String paramAnonymousString) {}
              }).execute(new Void[0]);
            }
            locala.AOK.setVisibility(0);
            locala.AOK.setOnClickListener(parambh.zGs.AQy);
            locala.AOK.setTag(paramBaseViewHolder);
            if ((!this.AOz) && (!this.AOD))
            {
              ae.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem !first, enable sensor");
              locala.AOK.setSensorEnabled(true);
            }
            if ((this.AOB == null) || (!this.AOB.equals(localj.zOU)))
            {
              ae.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem, loadImage, hash=" + locala.AOK.hashCode());
              paramBaseViewHolder = locala.AOK.getLayoutParams();
              this.zYp.l(localj.zOU, paramBaseViewHolder.width, paramBaseViewHolder.height, "scene_timeline");
              this.AOB = localj.zOU;
            }
            this.AOA = false;
            long l2 = System.currentTimeMillis();
            ae.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem total timeCost=" + (l2 - l1));
            AppMethodBeat.o(100107);
          }
        }
        else
        {
          parambi = paramTimeLineObject.Id;
          continue;
        }
        if (localj.zOE != 1) {
          continue;
        }
        parambi = new ViewGroup.LayoutParams(-2, -2);
        parambi.width = paramInt1;
        parambi.height = parambi.width;
        continue;
        if (localj.zOG != 1) {
          continue;
        }
        paramInt1 = Color.argb((int)(localj.zOF * 2.55F), 0, 0, 0);
        paramInt2 = Color.argb(0, 0, 0, 0);
        parambi = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { paramInt1, paramInt2 });
        parambi.setGradientType(0);
        locala.ALc.setBackground(parambi);
        if ((!bu.isNullOrNil(localj.title)) || (!bu.isNullOrNil(localj.description)))
        {
          locala.ALc.setVisibility(0);
          parambi = (RelativeLayout.LayoutParams)locala.ALh.getLayoutParams();
          parambi.topMargin = com.tencent.mm.cb.a.fromDPToPix(locala.Apn.getContext(), 4);
          locala.ALh.setLayoutParams(parambi);
        }
        if (!bu.isNullOrNil(localj.title))
        {
          locala.ALf.setVisibility(0);
          parambi = locala.ALf;
          paramTimeLineObject = com.tencent.mm.ce.g.fqZ();
          locala.ALf.getContext();
          parambi.setText(paramTimeLineObject.b(localj.title, locala.ALf.getTextSize()));
        }
        if (bu.isNullOrNil(localj.description)) {
          continue;
        }
        locala.ALg.setVisibility(0);
        parambi = locala.ALg;
        paramTimeLineObject = com.tencent.mm.ce.g.fqZ();
        locala.ALg.getContext();
        parambi.setText(paramTimeLineObject.b(localj.description, locala.ALg.getTextSize()));
        continue;
        ae.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "sphereCardInfo==null, invalid sphereCard");
      }
      catch (Throwable paramBaseViewHolder)
      {
        ae.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem exp=" + paramBaseViewHolder.toString());
        AppMethodBeat.o(100107);
        return;
      }
      label1493:
      continue;
      label1504:
      b.j localj = null;
      continue;
      label1510:
      paramInt1 = 0;
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
        this.AOy = locala;
        ae.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "buildContent, holder=" + paramBaseViewHolder.hashCode());
        if (paramBaseViewHolder.AMs != null)
        {
          paramBaseViewHolder.AMs.setLayoutResource(2131495604);
          if (!paramBaseViewHolder.AMt)
          {
            locala.Apn = paramBaseViewHolder.AMs.inflate();
            paramBaseViewHolder.AMt = true;
          }
          locala.tgh = locala.uan.findViewById(2131306008);
          locala.ALc = locala.uan.findViewById(2131297449);
          locala.ALd = ((TextView)locala.uan.findViewById(2131306010));
          locala.ALe = ((TextView)locala.uan.findViewById(2131306009));
          locala.ALf = ((TextView)locala.uan.findViewById(2131297451));
          locala.ALg = ((TextView)locala.uan.findViewById(2131297450));
          locala.AOK = ((SphereImageView)locala.uan.findViewById(2131305148));
          locala.ALh = locala.uan.findViewById(2131297455);
          locala.AOL = ((ImageView)locala.uan.findViewById(2131302164));
          locala.AOM = ((MMPinProgressBtn)locala.uan.findViewById(2131303515));
          locala.AOM.setMax(50);
          ae.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "buildContent, disable touch and sensor");
          locala.AOK.setTouchEnabled(false);
          locala.AOK.setSensorEnabled(false);
          locala.AOK.ag(1.8F, -2.0F);
          locala.AOK.setTouchSensitivity(0.45F);
          locala.AOK.setEventListener(this.Acb);
          locala.AOK.setOnlyHorizontalScroll(true);
          this.zYp = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a();
          this.zYp.a(this.AOC);
          if (this.ALN == null)
          {
            i = 0;
            this.gNm.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(100094);
                ae.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "enable touch, delay=" + i);
                locala.AOK.setTouchEnabled(true);
                AppMethodBeat.o(100094);
              }
            }, i);
            ae.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "viewHash=" + locala.AOK.hashCode() + ", touchDelay=" + i);
            AppMethodBeat.o(100106);
          }
        }
        else
        {
          if (paramBaseViewHolder.AMt) {
            continue;
          }
          locala.Apn = paramBaseViewHolder.uan.findViewById(2131305147);
          paramBaseViewHolder.AMt = true;
          continue;
        }
        final int i = this.ALN.zOT;
      }
      catch (Throwable paramBaseViewHolder)
      {
        ae.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "buildContent exp=" + paramBaseViewHolder.toString());
        AppMethodBeat.o(100106);
        return;
      }
    }
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    public View ALc;
    public TextView ALd;
    public TextView ALe;
    public TextView ALf;
    public TextView ALg;
    public View ALh;
    public SphereImageView AOK;
    public ImageView AOL;
    public MMPinProgressBtn AOM;
    public View Apn;
    public View tgh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.k
 * JD-Core Version:    0.7.0.1
 */