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
import com.tencent.mm.ce.g;
import com.tencent.mm.graphics.MMBitmapFactory;
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
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.net.URLEncoder;
import org.json.JSONObject;

public final class n
  extends BaseTimeLineItem
{
  protected ADXml.i EVR;
  protected a EZd;
  protected boolean EZe;
  protected boolean EZf;
  protected String EZg;
  protected a.d EZh;
  boolean EZi;
  protected com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a EgG;
  private int EgH;
  protected SphereImageView.b Ekr;
  protected MMHandler czp;
  
  public n()
  {
    AppMethodBeat.i(100105);
    this.EZe = true;
    this.EZf = true;
    this.EZg = null;
    this.czp = new MMHandler(Looper.getMainLooper());
    this.EgH = 0;
    this.EZh = new a.d()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString1, Bitmap paramAnonymousBitmap, String paramAnonymousString2)
      {
        AppMethodBeat.i(100095);
        Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "ImageLoader onFinish, isSucc=" + paramAnonymousBoolean + ", errInfo=" + paramAnonymousString1);
        if (n.this.EZd == null)
        {
          Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onFinish, mViewHolder==null");
          AppMethodBeat.o(100095);
          return;
        }
        if (n.this.EVR != null) {}
        for (paramAnonymousString1 = n.this.EVR.DWL; (paramAnonymousString2 != null) && (paramAnonymousString2.equals(paramAnonymousString1)); paramAnonymousString1 = "")
        {
          n.this.EZd.EZp.g(paramAnonymousBitmap, paramAnonymousString2);
          AppMethodBeat.o(100095);
          return;
        }
        Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onFinish, url != nowUrl");
        AppMethodBeat.o(100095);
      }
      
      public final void onStart(String paramAnonymousString) {}
    };
    this.Ekr = new SphereImageView.b()
    {
      public final void aQa(final String paramAnonymousString)
      {
        AppMethodBeat.i(100099);
        if (n.this.EVR != null) {}
        for (Object localObject = n.this.EVR.DWL; (paramAnonymousString != null) && (!paramAnonymousString.equals(localObject)); localObject = "")
        {
          Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onUpdateImage, url != CardInfo.sphereImageUrl, url=" + paramAnonymousString + ", info.url=" + (String)localObject);
          AppMethodBeat.o(100099);
          return;
        }
        localObject = n.this.EZd;
        if (localObject == null)
        {
          Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onUpdateImage, viewHolder==null");
          AppMethodBeat.o(100099);
          return;
        }
        Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onUpdateImage, isFirstUpdateImage=" + n.this.EZe + ", visiable=" + ((n.a)localObject).EZq.getVisibility());
        if (n.this.EZe)
        {
          if (((n.a)localObject).EZq.getVisibility() == 0)
          {
            AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
            localAlphaAnimation.setDuration(350L);
            localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
            {
              public final void onAnimationEnd(Animation paramAnonymous2Animation)
              {
                AppMethodBeat.i(100096);
                this.EZk.EZq.setVisibility(8);
                this.EZk.EZq.setImageDrawable(new ColorDrawable(this.EZk.EZq.getContext().getResources().getColor(2131099651)));
                AppMethodBeat.o(100096);
              }
              
              public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
              
              public final void onAnimationStart(Animation paramAnonymous2Animation) {}
            });
            Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "do maskImage anim");
            ((n.a)localObject).EZq.startAnimation(localAlphaAnimation);
          }
          if ((n.this.EVR == null) || (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.kx(n.this.EVR.DWL, "scene_timeline"))) {
            break label328;
          }
          Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "disable touch before shot");
          ((n.a)localObject).EZp.setTouchEnabled(false);
          ((n.a)localObject).EZp.feu();
          ((n.a)localObject).EZp.Ejd.requestRender();
          n.this.czp.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(100097);
              String str;
              if (n.this.EVR != null)
              {
                str = n.this.EVR.DWL;
                if ((paramAnonymousString == null) || (!paramAnonymousString.equals(str))) {
                  break label158;
                }
                Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "do shot");
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.a(this.EZk.EZp, str, "scene_timeline");
                n.this.EZe = false;
              }
              for (;;)
              {
                Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "enable touch and sensor after shot, isInLowPriority=" + n.this.EZi);
                if (!n.this.EZi) {
                  this.EZk.EZp.setSensorEnabled(true);
                }
                this.EZk.EZp.setTouchEnabled(true);
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
          if (((n.a)localObject).EZr.getVisibility() == 0)
          {
            Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "hide progressView");
            ((n.a)localObject).EZr.setVisibility(8);
          }
          AppMethodBeat.o(100099);
          return;
          label328:
          Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "don't need shot, enable sensor, isInLowPriority=" + n.this.EZi);
          if (!n.this.EZi) {
            ((n.a)localObject).EZp.setSensorEnabled(true);
          }
          n.this.EZe = false;
        }
      }
      
      public final void fdK() {}
      
      public final void fdL() {}
      
      public final void fdM()
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
        n.this.EZe = true;
        n.this.EZf = true;
        n.this.EZg = null;
        n.this.czp.removeCallbacksAndMessages(null);
        try
        {
          Object localObject = new JSONObject();
          ((JSONObject)localObject).put("panCount", n.b(n.this));
          ((JSONObject)localObject).put("type", 1);
          String str2 = URLEncoder.encode(((JSONObject)localObject).toString(), "UTF-8");
          SnsInfo localSnsInfo = n.this.DQX.Zv(n.this.EZd.position);
          String str1 = localSnsInfo.getAid();
          localObject = str1;
          if (str1 == null) {
            localObject = "";
          }
          com.tencent.mm.plugin.report.service.h.CyF.a(17539, new Object[] { localSnsInfo.getTimeLine().Id, localObject, localSnsInfo.getAdInfo().uxInfo, Integer.valueOf(1), str2 });
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
    this.EZi = false;
    AppMethodBeat.o(100105);
  }
  
  public final void a(SphereImageView paramSphereImageView, boolean paramBoolean)
  {
    AppMethodBeat.i(100108);
    Log.d("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "setIsInLowPriority, isInLowPriority=" + paramBoolean + ", hash=" + paramSphereImageView.hashCode());
    this.EZi = paramBoolean;
    if (paramBoolean)
    {
      paramSphereImageView.setSensorEnabled(false);
      AppMethodBeat.o(100108);
      return;
    }
    if (!this.EZe) {
      paramSphereImageView.setSensorEnabled(true);
    }
    AppMethodBeat.o(100108);
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, final bl parambl, final TimeLineObject paramTimeLineObject, int paramInt2, bk parambk)
  {
    AppMethodBeat.i(100107);
    for (;;)
    {
      try
      {
        long l1 = System.currentTimeMillis();
        if (paramBaseViewHolder.hho)
        {
          Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem, holder is busy");
          AppMethodBeat.o(100107);
          return;
        }
        final a locala = (a)paramBaseViewHolder;
        SnsInfo localSnsInfo = parambl.DqO;
        if ((localSnsInfo == null) || (localSnsInfo.getAdXml() == null)) {
          break label1476;
        }
        locali = localSnsInfo.getAdXml().adSphereCardInfo;
        this.EVR = locali;
        if ((Build.VERSION.SDK_INT < 24) && (locali != null) && ((this.EZg == null) || (!this.EZg.equals(locali.DWL))))
        {
          this.EZe = true;
          this.EZf = true;
          Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem, reset, sdk_int=" + Build.VERSION.SDK_INT);
        }
        StringBuilder localStringBuilder = new StringBuilder("ad fillItem, sphereCard, pos=").append(paramInt1).append(", snsId=");
        if (paramTimeLineObject == null)
        {
          parambl = "";
          parambl = localStringBuilder.append(parambl).append(", hash=").append(locala.EZp.hashCode()).append(", isFirst=").append(this.EZf).append(", snsInfo.hash=");
          if (localSnsInfo == null) {
            break label1482;
          }
          paramInt1 = localSnsInfo.hashCode();
          Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", paramInt1);
          parambl = null;
          locala.wnX.setVisibility(8);
          locala.uXS.setVisibility(8);
          locala.EVi.setVisibility(8);
          locala.EVh.setVisibility(8);
          locala.EVj.setVisibility(8);
          locala.EVk.setVisibility(8);
          locala.EVl.setVisibility(8);
          if (locali == null) {
            break label1465;
          }
          paramTimeLineObject = (WindowManager)this.mActivity.getSystemService("window");
          paramInt1 = Math.min(paramTimeLineObject.getDefaultDisplay().getWidth(), paramTimeLineObject.getDefaultDisplay().getHeight()) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 56) - this.mActivity.getResources().getDimensionPixelSize(2131165508) - this.mActivity.getResources().getDimensionPixelSize(2131165534);
          if (locali.DWw == 0)
          {
            parambl = new ViewGroup.LayoutParams(-2, -2);
            parambl.width = paramInt1;
            parambl.height = ((int)(parambl.width * 0.75F));
            if (parambl != null)
            {
              paramTimeLineObject = locala.ExX.getLayoutParams();
              paramTimeLineObject.width = parambl.width;
              paramTimeLineObject.height = parambl.height;
              locala.ExX.setLayoutParams(paramTimeLineObject);
              ((RoundedCornerFrameLayout)locala.ExX).setRadius(com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 8));
              paramTimeLineObject = locala.EZp.getLayoutParams();
              paramTimeLineObject.width = parambl.width;
              paramTimeLineObject.height = parambl.height;
              locala.EZp.setLayoutParams(paramTimeLineObject);
              parambl = locala.EZq.getLayoutParams();
              parambl.width = paramTimeLineObject.width;
              parambl.height = paramTimeLineObject.height;
              locala.EZq.setLayoutParams(parambl);
            }
            if (locali.DWy != 0) {
              continue;
            }
            paramInt1 = Color.argb((int)(locali.DWx * 2.55F), 0, 0, 0);
            paramInt2 = Color.argb(0, 0, 0, 0);
            parambl = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { paramInt1, paramInt2 });
            parambl.setGradientType(0);
            locala.wnX.setBackground(parambl);
            if ((!Util.isNullOrNil(locali.title)) || (!Util.isNullOrNil(locali.description))) {
              locala.wnX.setVisibility(0);
            }
            if (!Util.isNullOrNil(locali.title))
            {
              locala.uXS.setVisibility(0);
              locala.uXS.setText(g.gxZ().a(locala.uXS.getContext(), locali.title, locala.uXS.getTextSize()));
            }
            if (!Util.isNullOrNil(locali.description))
            {
              locala.EVi.setVisibility(0);
              locala.EVi.setText(g.gxZ().a(locala.EVi.getContext(), locali.description, locala.EVi.getTextSize()));
            }
            if ((localSnsInfo != null) && (localSnsInfo.getAdInfo().isWeapp()))
            {
              paramInt1 = Color.argb((int)(locali.DWx * 2.55F), 0, 0, 0);
              paramInt2 = Color.argb(0, 0, 0, 0);
              parambl = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { paramInt1, paramInt2 });
              parambl.setGradientType(0);
              locala.EVh.setVisibility(0);
              locala.EVh.setBackground(parambl);
              locala.EVl.setVisibility(0);
            }
            if (this.EZf)
            {
              locala.EZq.setVisibility(0);
              parambl = locali.DWL;
              paramTimeLineObject = locali.DWM;
              new a.c(parambl, paramTimeLineObject, "scene_timeline", new a.d()
              {
                public final void a(boolean paramAnonymousBoolean, String paramAnonymousString1, Bitmap paramAnonymousBitmap, String paramAnonymousString2)
                {
                  AppMethodBeat.i(100104);
                  if ((paramAnonymousString2 == null) || (!paramAnonymousString2.equals(parambl)))
                  {
                    AppMethodBeat.o(100104);
                    return;
                  }
                  if (paramAnonymousBitmap != null)
                  {
                    locala.EZq.setImageBitmap(paramAnonymousBitmap);
                    AppMethodBeat.o(100104);
                    return;
                  }
                  Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "show progressView");
                  locala.EZr.setVisibility(0);
                  locala.EZr.gYN();
                  if (!TextUtils.isEmpty(paramTimeLineObject))
                  {
                    Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "no shot and thumb cache, start download thumb image");
                    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(paramTimeLineObject, 133, new f.a()
                    {
                      String EZn;
                      
                      public final void aNH(String paramAnonymous2String)
                      {
                        AppMethodBeat.i(100103);
                        Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onDownloaded thumb, path=".concat(String.valueOf(paramAnonymous2String)));
                        if (n.this.EVR != null) {}
                        for (String str = n.this.EVR.DWM; (this.EZn != null) && (this.EZn.equals(str)); str = "")
                        {
                          if (n.4.this.EZk.EZq.getVisibility() != 0) {
                            break label149;
                          }
                          try
                          {
                            paramAnonymous2String = MMBitmapFactory.decodeFile(paramAnonymous2String);
                            n.4.this.EZk.EZq.setImageBitmap(paramAnonymous2String);
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
                      
                      public final void eWN() {}
                      
                      public final void eWO()
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
                
                public final void onStart(String paramAnonymousString) {}
              }).execute(new Void[0]);
            }
            locala.EZp.setVisibility(0);
            locala.EZp.setOnClickListener(parambk.DQs.Fbd);
            locala.EZp.setTag(paramBaseViewHolder);
            if ((!this.EZe) && (!this.EZi))
            {
              Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem !first, enable sensor");
              locala.EZp.setSensorEnabled(true);
            }
            if ((this.EZg == null) || (!this.EZg.equals(locali.DWL)))
            {
              Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem, loadImage, hash=" + locala.EZp.hashCode());
              paramBaseViewHolder = locala.EZp.getLayoutParams();
              this.EgG.l(locali.DWL, paramBaseViewHolder.width, paramBaseViewHolder.height, "scene_timeline");
              this.EZg = locali.DWL;
            }
            this.EZf = false;
            long l2 = System.currentTimeMillis();
            Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem total timeCost=" + (l2 - l1));
            AppMethodBeat.o(100107);
          }
        }
        else
        {
          parambl = paramTimeLineObject.Id;
          continue;
        }
        if (locali.DWw != 1) {
          continue;
        }
        parambl = new ViewGroup.LayoutParams(-2, -2);
        parambl.width = paramInt1;
        parambl.height = parambl.width;
        continue;
        if (locali.DWy != 1) {
          continue;
        }
        paramInt1 = Color.argb((int)(locali.DWx * 2.55F), 0, 0, 0);
        paramInt2 = Color.argb(0, 0, 0, 0);
        parambl = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { paramInt1, paramInt2 });
        parambl.setGradientType(0);
        locala.EVh.setBackground(parambl);
        if ((!Util.isNullOrNil(locali.title)) || (!Util.isNullOrNil(locali.description)))
        {
          locala.EVh.setVisibility(0);
          parambl = (RelativeLayout.LayoutParams)locala.EVl.getLayoutParams();
          parambl.topMargin = com.tencent.mm.cb.a.fromDPToPix(locala.ExX.getContext(), 4);
          locala.EVl.setLayoutParams(parambl);
        }
        if (!Util.isNullOrNil(locali.title))
        {
          locala.EVj.setVisibility(0);
          locala.EVj.setText(g.gxZ().a(locala.EVj.getContext(), locali.title, locala.EVj.getTextSize()));
        }
        if (Util.isNullOrNil(locali.description)) {
          continue;
        }
        locala.EVk.setVisibility(0);
        locala.EVk.setText(g.gxZ().a(locala.EVk.getContext(), locali.description, locala.EVk.getTextSize()));
        continue;
        Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "sphereCardInfo==null, invalid sphereCard");
      }
      catch (Throwable paramBaseViewHolder)
      {
        Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem exp=" + paramBaseViewHolder.toString());
        AppMethodBeat.o(100107);
        return;
      }
      label1465:
      continue;
      label1476:
      ADXml.i locali = null;
      continue;
      label1482:
      paramInt1 = 0;
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
        this.EZd = locala;
        Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "buildContent, holder=" + paramBaseViewHolder.hashCode());
        if (paramBaseViewHolder.EWD != null)
        {
          paramBaseViewHolder.EWD.setLayoutResource(2131496503);
          if (!paramBaseViewHolder.EWE)
          {
            locala.ExX = paramBaseViewHolder.EWD.inflate();
            paramBaseViewHolder.EWE = true;
          }
          locala.wnX = locala.convertView.findViewById(2131309318);
          locala.EVh = locala.convertView.findViewById(2131297679);
          locala.uXS = ((TextView)locala.convertView.findViewById(2131309320));
          locala.EVi = ((TextView)locala.convertView.findViewById(2131309319));
          locala.EVj = ((TextView)locala.convertView.findViewById(2131297681));
          locala.EVk = ((TextView)locala.convertView.findViewById(2131297680));
          locala.EZp = ((SphereImageView)locala.convertView.findViewById(2131308330));
          locala.EVl = locala.convertView.findViewById(2131297688);
          locala.EZq = ((ImageView)locala.convertView.findViewById(2131304506));
          locala.EZr = ((MMPinProgressBtn)locala.convertView.findViewById(2131306281));
          locala.EZr.setMax(50);
          Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "buildContent, disable touch and sensor");
          locala.EZp.setTouchEnabled(false);
          locala.EZp.setSensorEnabled(false);
          locala.EZp.an(1.8F, -2.0F);
          locala.EZp.setTouchSensitivity(0.45F);
          locala.EZp.setEventListener(this.Ekr);
          locala.EZp.setOnlyHorizontalScroll(true);
          this.EgG = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a();
          this.EgG.a(this.EZh);
          if (this.EVR == null)
          {
            i = 0;
            this.czp.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(100094);
                Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "enable touch, delay=" + i);
                locala.EZp.setTouchEnabled(true);
                AppMethodBeat.o(100094);
              }
            }, i);
            Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "viewHash=" + locala.EZp.hashCode() + ", touchDelay=" + i);
            AppMethodBeat.o(100106);
          }
        }
        else
        {
          if (paramBaseViewHolder.EWE) {
            continue;
          }
          locala.ExX = paramBaseViewHolder.convertView.findViewById(2131308329);
          paramBaseViewHolder.EWE = true;
          continue;
        }
        final int i = this.EVR.DWK;
      }
      catch (Throwable paramBaseViewHolder)
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
    public View EVh;
    public TextView EVi;
    public TextView EVj;
    public TextView EVk;
    public View EVl;
    public SphereImageView EZp;
    public ImageView EZq;
    public MMPinProgressBtn EZr;
    public View ExX;
    public TextView uXS;
    public View wnX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.n
 * JD-Core Version:    0.7.0.1
 */