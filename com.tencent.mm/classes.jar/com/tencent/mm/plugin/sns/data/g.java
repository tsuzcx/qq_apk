package com.tencent.mm.plugin.sns.data;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.ui.SnsAdProxyUI;
import com.tencent.mm.pluginsdk.d.d;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.bottomsheet.ViewTitleWithAnimation;
import com.tencent.qbar.WxQbarNative.QBarReportMsg;
import com.tencent.qbar.a.a;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONObject;

public final class g
{
  private String jzs;
  Context mContext;
  com.tencent.mm.ui.widget.a.e mET;
  int mScene;
  int wAA;
  volatile String wAB;
  int wAC;
  private String wAD;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad wAE;
  private String wAF;
  ScanCodeSheetItemLogic wAy;
  int wAz;
  
  public g(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad paramad, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(187248);
    this.mContext = paramContext;
    this.wAE = paramad;
    this.mScene = paramInt;
    this.wAC = 0;
    if (this.wAy == null)
    {
      this.mET = new com.tencent.mm.ui.widget.a.e(this.mContext, 1, false);
      this.wAy = new ScanCodeSheetItemLogic(this.mContext);
      this.mET.HrX = new n.c()
      {
        public final void onCreateMMMenu(l paramAnonymousl)
        {
          AppMethodBeat.i(176226);
          try
          {
            paramAnonymousl = g.this;
            paramAnonymousl = paramAnonymousl.wAy.a(new g.3(paramAnonymousl), paramAnonymousl.wAz, paramAnonymousl.wAB, 9);
            if ((paramAnonymousl instanceof ViewTitleWithAnimation)) {
              ((ViewTitleWithAnimation)paramAnonymousl).setTopPaddingVisibility(8);
            }
            g.this.mET.setFooterView(paramAnonymousl);
            paramAnonymousl = new View(g.this.mContext);
            paramAnonymousl.setMinimumHeight(com.tencent.mm.cd.a.fromDPToPix(g.this.mContext, 2));
            g.this.mET.J(paramAnonymousl, true);
            AppMethodBeat.o(176226);
            return;
          }
          catch (Exception paramAnonymousl)
          {
            com.tencent.mm.sdk.platformtools.ad.e("SnsAdQRHelper", "onCreateMMMenu exp=" + paramAnonymousl.toString());
            AppMethodBeat.o(176226);
          }
        }
      };
      this.mET.GHn = new com.tencent.mm.ui.widget.a.e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(176227);
          g.this.wAy.vLD = null;
          g.this.drZ();
          AppMethodBeat.o(176227);
        }
      };
    }
    try
    {
      this.wAF = bt.by(y.m(paramBundle, "qrExtInfo"), "");
      AppMethodBeat.o(187248);
      return;
    }
    catch (Throwable paramContext)
    {
      com.tencent.mm.sdk.platformtools.ad.e("SnsAdQRHelper", "there is something wrong in parseExtraParams");
      AppMethodBeat.o(187248);
    }
  }
  
  public final void anx(String paramString)
  {
    AppMethodBeat.i(176236);
    try
    {
      Object localObject = this.wAE;
      String str1 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)localObject).getSnsId();
      String str2 = bt.nullAsNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)localObject).dvK);
      String str3 = bt.nullAsNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)localObject).wSi);
      int i = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)localObject).dep;
      localObject = URLEncoder.encode(paramString, "UTF-8");
      h.vKh.f(17539, new Object[] { str1, str3, str2, Integer.valueOf(i), localObject });
      com.tencent.mm.sdk.platformtools.ad.d("SnsAdQRHelper", "reportKV17539 snsId=" + str1 + ", aid=" + str3 + ", uxInfo=" + str2 + ", kvData=" + paramString);
      AppMethodBeat.o(176236);
      return;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.sdk.platformtools.ad.e("SnsAdQRHelper", "reportKV17539 exp:" + paramString.toString());
      AppMethodBeat.o(176236);
    }
  }
  
  public final void bx(String paramString, boolean paramBoolean)
  {
    int i = 2;
    AppMethodBeat.i(176235);
    if (this.mScene == 1) {}
    for (;;)
    {
      anx(i(i, paramString, paramBoolean).toString());
      j.ix("17539", j(i, paramString, paramBoolean));
      AppMethodBeat.o(176235);
      return;
      if (this.mScene == 2) {
        i = 6;
      } else if (this.mScene == 3) {
        i = 8;
      } else {
        i = 0;
      }
    }
  }
  
  public final void drZ()
  {
    this.wAB = "";
    this.wAz = -1;
    this.wAD = "";
    this.jzs = "";
    this.wAA = 0;
    this.wAC = 0;
  }
  
  public final JSONObject i(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(176237);
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("type", paramInt);
        if (!paramBoolean) {
          continue;
        }
        paramInt = 0;
        localJSONObject.put("qrResult", paramInt);
        localJSONObject.put("qrUrl", this.jzs);
        localJSONObject.put("qrResultUrl", paramString);
        localJSONObject.put("qrExtInfo", this.wAF);
        if (this.wAC != 0) {
          localJSONObject.put("qrResultUrlType", this.wAC);
        }
      }
      catch (Exception paramString)
      {
        com.tencent.mm.sdk.platformtools.ad.e("SnsAdQRHelper", "buildKVData exp:" + paramString.toString());
        continue;
      }
      AppMethodBeat.o(176237);
      return localJSONObject;
      paramInt = 1;
    }
  }
  
  public final boolean iw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(179078);
    this.wAD = paramString1;
    this.jzs = paramString2;
    com.tencent.mm.sdk.platformtools.ad.i("SnsAdQRHelper", "onLongClick, filePath=" + this.wAD);
    if (TextUtils.isEmpty(this.wAD))
    {
      drZ();
      AppMethodBeat.o(179078);
      return false;
    }
    long l = System.currentTimeMillis();
    com.tencent.qbar.e.flQ().a(this.mContext, l, this.wAD, new com.tencent.qbar.e.b()
    {
      public final void a(long paramAnonymousLong, List<a.a> paramAnonymousList, List<WxQbarNative.QBarReportMsg> paramAnonymousList1)
      {
        AppMethodBeat.i(176232);
        if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
        {
          int k = d.d.aAo(((a.a)paramAnonymousList.get(0)).typeName);
          paramAnonymousList = ((a.a)paramAnonymousList.get(0)).data;
          int i = -1;
          int j = i;
          if (paramAnonymousList1 != null)
          {
            j = i;
            if (!paramAnonymousList1.isEmpty()) {
              j = ((WxQbarNative.QBarReportMsg)paramAnonymousList1.get(0)).qrcodeVersion;
            }
          }
          com.tencent.mm.sdk.platformtools.ad.i("SnsAdQRHelper", "QRCodeStr=" + paramAnonymousList + ", QRCodeType=" + k + ", QRCodeVer=" + j);
          paramAnonymousList1 = g.this;
          if (!TextUtils.isEmpty(paramAnonymousList)) {
            if (com.tencent.mm.plugin.scanner.e.bD(k, paramAnonymousList))
            {
              paramAnonymousList1.wAC = 2;
              i = 1;
            }
          }
          while (i == 0)
          {
            com.tencent.mm.sdk.platformtools.ad.e("SnsAdQRHelper", "isValidQRCode=false");
            g.this.bx(bt.nullAsNil(paramAnonymousList), false);
            g.this.drZ();
            AppMethodBeat.o(176232);
            return;
            if (com.tencent.mm.plugin.scanner.e.bE(k, paramAnonymousList))
            {
              paramAnonymousList1.wAC = 3;
              i = 1;
            }
            else if (com.tencent.mm.plugin.scanner.e.bF(k, paramAnonymousList))
            {
              paramAnonymousList1.wAC = 4;
              i = 1;
            }
            else if (com.tencent.mm.plugin.scanner.e.bG(k, paramAnonymousList))
            {
              paramAnonymousList1.wAC = 5;
              i = 1;
            }
            else if (com.tencent.mm.plugin.scanner.e.bH(k, paramAnonymousList))
            {
              paramAnonymousList1.wAC = 1;
              i = 1;
            }
            else
            {
              i = 0;
            }
          }
          g.this.wAz = k;
          g.this.wAB = paramAnonymousList;
          g.this.wAA = j;
          paramAnonymousList = g.this;
          paramAnonymousList1 = g.this.wAB;
          if (!TextUtils.isEmpty(g.this.wAB)) {}
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousList.bx(paramAnonymousList1, bool);
            AdLandingPagesProxy.getInstance().fetchQRCodeInfo(g.this.wAz, g.this.wAB, new AdLandingPagesProxy.e()
            {
              public final void bf(Object paramAnonymous2Object) {}
              
              public final void h(final int paramAnonymous2Int1, int paramAnonymous2Int2, final Object paramAnonymous2Object)
              {
                AppMethodBeat.i(176230);
                StringBuilder localStringBuilder = new StringBuilder("fetchQRCodeInfo, errType=").append(paramAnonymous2Int1).append(", data==null?");
                if (paramAnonymous2Object == null) {}
                for (boolean bool = true;; bool = false)
                {
                  com.tencent.mm.sdk.platformtools.ad.i("SnsAdQRHelper", bool);
                  if (TextUtils.isEmpty(g.this.wAB)) {
                    break;
                  }
                  aq.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(176229);
                      try
                      {
                        byte[] arrayOfByte = (byte[])paramAnonymous2Object;
                        g.this.wAy.q(paramAnonymous2Int1, arrayOfByte);
                        g.this.mET.csG();
                        AppMethodBeat.o(176229);
                        return;
                      }
                      catch (Throwable localThrowable)
                      {
                        com.tencent.mm.sdk.platformtools.ad.e("SnsAdQRHelper", "there is something wrong in AdLandingPagesProxy call back");
                        AppMethodBeat.o(176229);
                      }
                    }
                  });
                  AppMethodBeat.o(176230);
                  return;
                }
                com.tencent.mm.sdk.platformtools.ad.e("SnsAdQRHelper", "the qr code string is empty in AdLandingPagesProxy call back");
                AppMethodBeat.o(176230);
              }
            });
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(176231);
                g.this.mET.csG();
                AppMethodBeat.o(176231);
              }
            });
            AppMethodBeat.o(176232);
            return;
          }
        }
        com.tencent.mm.sdk.platformtools.ad.e("SnsAdQRHelper", "afterDecode, results is empty");
        g.this.bx("", false);
        g.this.drZ();
        AppMethodBeat.o(176232);
      }
    }, new int[] { 0 });
    AppMethodBeat.o(179078);
    return true;
  }
  
  public final String j(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(176238);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad localad = this.wAE;
      paramString = i(paramInt, paramString, paramBoolean);
      String str1 = bt.nullAsNil(localad.dvK);
      String str2 = localad.getSnsId();
      paramInt = localad.dep;
      long l = bt.aGi(localad.jyu);
      localJSONObject.put("extInfo", paramString);
      localJSONObject.put("uxinfo", str1);
      localJSONObject.put("snsId", str2);
      localJSONObject.put("scene", paramInt);
      localJSONObject.put("canvasId", l);
      if (!TextUtils.isEmpty(localad.wBR)) {
        localJSONObject.put("adExtInfo", localad.wBR);
      }
      paramString = localJSONObject.toString();
      com.tencent.mm.sdk.platformtools.ad.d("SnsAdQRHelper", "buildCgiReportData ret=".concat(String.valueOf(paramString)));
      AppMethodBeat.o(176238);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.e("SnsAdQRHelper", "buildCgiReportData exp:" + paramString.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.g
 * JD-Core Version:    0.7.0.1
 */