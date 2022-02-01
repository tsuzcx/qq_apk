package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Outline;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.ad.landingpage.helper.a.a;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.data.l;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.protocal.protobuf.cbd;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class ad
  extends m
{
  volatile String JQu = "";
  boolean Kme;
  boolean Kqb = true;
  j Kqk;
  ImageView fDJ;
  volatile String imageUrl = "";
  ProgressBar progressBar;
  
  public ad(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u paramu, ViewGroup paramViewGroup)
  {
    super(paramContext, paramu, paramViewGroup);
  }
  
  private static boolean fpB()
  {
    AppMethodBeat.i(270636);
    try
    {
      int i = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vvi, 0);
      Log.i("AdLandingPagePureImageComponet", "isNeedVerify=".concat(String.valueOf(i)));
      if (i > 0)
      {
        AppMethodBeat.o(270636);
        return true;
      }
      AppMethodBeat.o(270636);
      return false;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(270636);
    }
    return false;
  }
  
  final void bID(final String paramString)
  {
    AppMethodBeat.i(293261);
    com.tencent.e.h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(293204);
        try
        {
          Bitmap localBitmap = BitmapUtil.decodeFile(paramString);
          com.tencent.e.h.ZvG.bc(new ad.3.1(this, localBitmap));
          AppMethodBeat.o(293204);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("AdLandingPagePureImageComponet", "setImageAsync, exp=" + localThrowable.toString());
          AppMethodBeat.o(293204);
        }
      }
    });
    AppMethodBeat.o(293261);
  }
  
  public final boolean by(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96698);
    if (!super.by(paramJSONObject))
    {
      AppMethodBeat.o(96698);
      return false;
    }
    try
    {
      if (!this.Kqb)
      {
        String str = MD5Util.getMD5String(this.imageUrl);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("urlMd5", str);
        localJSONObject.put("needDownload", 1);
        paramJSONObject.put("imgUrlInfo", localJSONObject);
      }
      AppMethodBeat.o(96698);
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      Log.printErrStackTrace("AdLandingPagePureImageComponet", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96698);
    }
    return false;
  }
  
  protected final void fKe()
  {
    AppMethodBeat.i(96695);
    if ((this.contentView == null) || (this.fDJ == null) || (this.progressBar == null))
    {
      AppMethodBeat.o(96695);
      return;
    }
    if ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)this.KqB == null)
    {
      AppMethodBeat.o(96695);
      return;
    }
    int i = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)this.KqB).kYn;
    if (i == 0) {
      this.fDJ.setScaleType(ImageView.ScaleType.FIT_XY);
    }
    for (;;)
    {
      Log.i("AdLandingPagePureImageComponet", "cid=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)this.KqB).KmB + ", scaleType=" + i);
      this.imageUrl = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)this.KqB).Kmf;
      String str1 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)this.KqB).bgColor;
      float f2 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)this.KqB).height;
      final float f1 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)this.KqB).width;
      this.Kme = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)this.KqB).Kme;
      if ((f2 != 0.0F) && (f1 != 0.0F) && (!this.Kme))
      {
        i = this.pEj - (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)this.KqB).paddingLeft - (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)this.KqB).paddingRight;
        if (f1 < i)
        {
          label229:
          f2 = f1 * ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)this.KqB).height / ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)this.KqB).width;
          this.fDJ.setLayoutParams(new RelativeLayout.LayoutParams((int)f1, (int)f2));
          label271:
          if ((str1 == null) || (str1.length() <= 0)) {}
        }
      }
      try
      {
        this.fDJ.setBackgroundColor(Color.parseColor(str1));
        label296:
        if ((this.imageUrl == null) || (this.imageUrl.length() <= 0))
        {
          Log.i("AdLandingPagePureImageComponet", "Pure image component fillItem without imageurl.");
          AppMethodBeat.o(96695);
          return;
          if (i != 1) {
            continue;
          }
          this.fDJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
          continue;
          f1 = i;
          break label229;
          if ((this.Kme) && (f2 != 0.0F) && (f1 != 0.0F))
          {
            this.fDJ.setLayoutParams(new RelativeLayout.LayoutParams(this.pEj, this.pEk));
            break label271;
          }
          this.fDJ.setLayoutParams(new RelativeLayout.LayoutParams(this.pEj, this.pEk));
          break label271;
        }
        str1 = this.imageUrl;
        Object localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)this.KqB;
        str1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kU("adId", str1);
        if ((TextUtils.isEmpty(str1)) || (!com.tencent.mm.vfs.u.agG(str1)))
        {
          Log.i("AdLandingPagePureImageComponet", "verifyLocalCacheFileByMd5, local file not exists");
          a.a.yl(false);
        }
        for (;;)
        {
          str1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.mA("adId", this.imageUrl);
          if (!TextUtils.isEmpty(str1))
          {
            bID(str1);
            this.JQu = str1;
            this.Kqb = true;
            Log.i("AdLandingPagePureImageComponet", "loaded cached image with  " + this.imageUrl);
            if ((!((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)this.KqB).Kmg) || (!((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)this.KqB).Kmi)) {}
          }
          try
          {
            Log.i("AdLandingPagePureImageComponet", "request new qr image imgUrl");
            AdLandingPagesProxy.getInstance().doAdUpdateQrUrlScene("", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)this.KqB).Kmh, "", fRp().uxInfo, this.KqB.KmB, fRp().getSnsId(), new b(this));
            f1 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)this.KqB).bDI;
            if (f1 > 0.0F)
            {
              Log.i("AdLandingPagePureImageComponet", "fillItem, cornerRadius=" + f1 + ", cId=" + this.KqB.KmB + ", viewHash=" + this.fDJ.hashCode());
              this.fDJ.setClipToOutline(true);
              this.fDJ.setOutlineProvider(new ViewOutlineProvider()
              {
                public final void getOutline(View paramAnonymousView, Outline paramAnonymousOutline)
                {
                  AppMethodBeat.i(266273);
                  if (paramAnonymousView != null)
                  {
                    Log.d("AdLandingPagePureImageComponet", "getOutline, viewW=" + paramAnonymousView.getWidth() + ", vewH=" + paramAnonymousView.getHeight());
                    paramAnonymousOutline.setRoundRect(0, 0, paramAnonymousView.getWidth(), paramAnonymousView.getHeight(), f1);
                  }
                  AppMethodBeat.o(266273);
                }
              });
            }
            AppMethodBeat.o(96695);
            return;
            a.a.yl(true);
            if ((((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)localObject).Kmg) && (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)localObject).Kmi))
            {
              Log.i("AdLandingPagePureImageComponet", "verifyLocalCacheFileByMd5, bEnableQRScan and needUpdateQrUrl");
              continue;
            }
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)localObject).Kme)
            {
              Log.i("AdLandingPagePureImageComponet", "verifyLocalCacheFileByMd5, bFullScreen");
              continue;
            }
            localObject = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)localObject).md5;
            String str2 = Util.nullAsNil(fRp().aid);
            String str3 = Util.nullAsNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)this.KqB).KmB);
            if (TextUtils.isEmpty((CharSequence)localObject))
            {
              com.tencent.mm.plugin.report.service.h.IzE.el(1594, 3);
              l.a(l.JQR, str2, 0, 0, str3);
              Log.i("AdLandingPagePureImageComponet", "verifyLocalCacheFileByMd5, md5 is empty, aid=" + str2 + ", cid=" + str3);
              continue;
            }
            if (!fpB()) {
              continue;
            }
            long l = System.currentTimeMillis();
            String str4 = com.tencent.mm.vfs.u.buc(str1);
            Log.d("AdLandingPagePureImageComponet", "verifyLocalCacheFileByMd5, md5=" + (String)localObject + ", localMd5=" + str4 + ", Md5-TimeCost=" + (System.currentTimeMillis() - l));
            if (!((String)localObject).equals(str4))
            {
              boolean bool = com.tencent.mm.vfs.u.deleteFile(str1);
              Log.e("AdLandingPagePureImageComponet", "verifyLocalCacheFileByMd5, md5=" + (String)localObject + ", localMd5=" + str4 + ", delteRet=" + bool + ", aid=" + str2 + ", cid=" + str3);
              com.tencent.mm.plugin.report.service.h.IzE.el(1594, 2);
              l.a(l.JQR, str2, 0, 1, str3);
              continue;
            }
            com.tencent.mm.plugin.report.service.h.IzE.el(1594, 1);
            continue;
            this.Kqb = false;
            startLoading();
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a("adId", this.imageUrl, new f.a()
            {
              public final void aYs(String paramAnonymousString)
              {
                AppMethodBeat.i(96685);
                try
                {
                  if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)ad.this.KqB).Kmf.equals(ad.this.imageUrl))
                  {
                    ad.this.bID(paramAnonymousString);
                    ad.this.JQu = paramAnonymousString;
                  }
                  AppMethodBeat.o(96685);
                  return;
                }
                catch (Exception paramAnonymousString)
                {
                  Log.e("AdLandingPagePureImageComponet", "%s" + Util.stackTraceToString(paramAnonymousString));
                  AppMethodBeat.o(96685);
                }
              }
              
              public final void fJU()
              {
                AppMethodBeat.i(96683);
                ad.this.startLoading();
                AppMethodBeat.o(96683);
              }
              
              public final void fJV()
              {
                AppMethodBeat.i(96684);
                ad.this.progressBar.setVisibility(8);
                AppMethodBeat.o(96684);
              }
            });
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              Log.e("AdLandingPagePureImageComponet", localThrowable.toString());
            }
          }
        }
      }
      catch (Exception localException)
      {
        break label296;
      }
    }
  }
  
  protected final void fKi()
  {
    AppMethodBeat.i(96694);
    Object localObject = this.contentView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).setMargins((int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)this.KqB).paddingLeft, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)this.KqB).paddingTop, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)this.KqB).paddingRight, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)this.KqB).paddingBottom);
      this.contentView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(96694);
  }
  
  public final void fKp()
  {
    AppMethodBeat.i(96693);
    this.fDJ = ((ImageView)this.contentView.findViewById(i.f.sns_ad_native_landing_pages_items_pure_image_img));
    this.progressBar = ((ProgressBar)this.contentView.findViewById(i.f.progressbar));
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)this.KqB).Kmg)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("qrExtInfo", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)this.KqB).Kmh);
      this.Kqk = new j(this.context, fRp(), 1, localBundle);
      this.fDJ.setOnLongClickListener(new ad.4(this));
    }
    AppMethodBeat.o(96693);
  }
  
  protected final int getLayout()
  {
    return i.g.sns_ad_native_landing_pages_item_pure_image;
  }
  
  public final void startLoading()
  {
    AppMethodBeat.i(96696);
    this.progressBar.setVisibility(0);
    AppMethodBeat.o(96696);
  }
  
  public static final class a
    implements f.a
  {
    WeakReference<ad> KsP;
    
    a(ad paramad)
    {
      AppMethodBeat.i(224960);
      this.KsP = new WeakReference(paramad);
      AppMethodBeat.o(224960);
    }
    
    public final void aYs(String paramString)
    {
      AppMethodBeat.i(224966);
      ad localad = (ad)this.KsP.get();
      if (localad != null)
      {
        Log.i("AdLandingPagePureImageComponet", "download qr image completed, the path " + paramString + "; cId " + localad.KqB.KmB);
        localad.bID(paramString);
        localad.JQu = paramString;
        AppMethodBeat.o(224966);
        return;
      }
      Log.w("AdLandingPagePureImageComponet", "qrCodePureImageComp is null in weak ref");
      AppMethodBeat.o(224966);
    }
    
    public final void fJU() {}
    
    public final void fJV()
    {
      AppMethodBeat.i(224963);
      Log.e("AdLandingPagePureImageComponet", "there is something error happening when downloading qr image.");
      AppMethodBeat.o(224963);
    }
  }
  
  public static final class b
    implements AdLandingPagesProxy.e
  {
    private WeakReference<ad> KsP;
    
    b(ad paramad)
    {
      AppMethodBeat.i(219239);
      this.KsP = new WeakReference(paramad);
      AppMethodBeat.o(219239);
    }
    
    public final void aH(Object paramObject) {}
    
    public final void i(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(219243);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {}
      try
      {
        if ((paramObject instanceof byte[]))
        {
          cbd localcbd = new cbd();
          localcbd.parseFrom((byte[])paramObject);
          if (this.KsP != null)
          {
            paramObject = (ad)this.KsP.get();
            if ((paramObject != null) && (paramObject.KqB.KmB.equals(localcbd.Tjv)))
            {
              Log.i("AdLandingPagePureImageComponet", "request new qr image imgUrl completed");
              paramObject.imageUrl = localcbd.url;
              com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a("adId", paramObject.imageUrl, new ad.a(paramObject));
            }
          }
          AppMethodBeat.o(219243);
          return;
        }
        Log.e("AdLandingPagePureImageComponet", "request new qr image imgUrl failed");
        AppMethodBeat.o(219243);
        return;
      }
      catch (Throwable paramObject)
      {
        Log.e("AdLandingPagePureImageComponet", paramObject.toString());
        AppMethodBeat.o(219243);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad
 * JD-Core Version:    0.7.0.1
 */