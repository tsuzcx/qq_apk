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
import com.tencent.mm.plugin.scanner.f;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.ui.SnsAdProxyUI;
import com.tencent.mm.pluginsdk.d.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.x;
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
  private String jZP;
  Context mContext;
  int mScene;
  com.tencent.mm.ui.widget.a.e ngY;
  ScanCodeSheetItemLogic xMR;
  int xMS;
  int xMT;
  volatile String xMU;
  int xMV;
  private String xMW;
  private ae xMX;
  private String xMY;
  
  public g(Context paramContext, ae paramae, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(200033);
    this.mContext = paramContext;
    this.xMX = paramae;
    this.mScene = paramInt;
    this.xMV = 0;
    if (this.xMR == null)
    {
      this.ngY = new com.tencent.mm.ui.widget.a.e(this.mContext, 1, false);
      this.xMR = new ScanCodeSheetItemLogic(this.mContext);
      this.ngY.ISu = new n.c()
      {
        public final void onCreateMMMenu(l paramAnonymousl)
        {
          AppMethodBeat.i(176226);
          try
          {
            paramAnonymousl = g.this;
            paramAnonymousl = paramAnonymousl.xMR.a(new g.3(paramAnonymousl), paramAnonymousl.xMS, paramAnonymousl.xMU, 9);
            if ((paramAnonymousl instanceof ViewTitleWithAnimation)) {
              ((ViewTitleWithAnimation)paramAnonymousl).setTopPaddingVisibility(8);
            }
            g.this.ngY.setFooterView(paramAnonymousl);
            paramAnonymousl = new View(g.this.mContext);
            paramAnonymousl.setMinimumHeight(com.tencent.mm.cc.a.fromDPToPix(g.this.mContext, 2));
            g.this.ngY.J(paramAnonymousl, true);
            AppMethodBeat.o(176226);
            return;
          }
          catch (Exception paramAnonymousl)
          {
            ac.e("SnsAdQRHelper", "onCreateMMMenu exp=" + paramAnonymousl.toString());
            AppMethodBeat.o(176226);
          }
        }
      };
      this.ngY.Ihj = new com.tencent.mm.ui.widget.a.e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(176227);
          g.this.xMR.wVE = null;
          g.this.dGy();
          AppMethodBeat.o(176227);
        }
      };
    }
    try
    {
      this.xMY = bs.bG(x.n(paramBundle, "qrExtInfo"), "");
      AppMethodBeat.o(200033);
      return;
    }
    catch (Throwable paramContext)
    {
      ac.e("SnsAdQRHelper", "there is something wrong in parseExtraParams");
      AppMethodBeat.o(200033);
    }
  }
  
  public final void asJ(String paramString)
  {
    AppMethodBeat.i(176236);
    try
    {
      Object localObject = this.xMX;
      String str1 = ((ae)localObject).getSnsId();
      String str2 = bs.nullAsNil(((ae)localObject).dtx);
      String str3 = bs.nullAsNil(((ae)localObject).yeO);
      int i = ((ae)localObject).dbL;
      localObject = URLEncoder.encode(paramString, "UTF-8");
      h.wUl.f(17539, new Object[] { str1, str3, str2, Integer.valueOf(i), localObject });
      ac.d("SnsAdQRHelper", "reportKV17539 snsId=" + str1 + ", aid=" + str3 + ", uxInfo=" + str2 + ", kvData=" + paramString);
      AppMethodBeat.o(176236);
      return;
    }
    catch (Exception paramString)
    {
      ac.e("SnsAdQRHelper", "reportKV17539 exp:" + paramString.toString());
      AppMethodBeat.o(176236);
    }
  }
  
  public final void bE(String paramString, boolean paramBoolean)
  {
    int i = 2;
    AppMethodBeat.i(176235);
    if (this.mScene == 1) {}
    for (;;)
    {
      asJ(i(i, paramString, paramBoolean).toString());
      j.iU("17539", j(i, paramString, paramBoolean));
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
  
  public final void dGy()
  {
    this.xMU = "";
    this.xMS = -1;
    this.xMW = "";
    this.jZP = "";
    this.xMT = 0;
    this.xMV = 0;
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
        localJSONObject.put("qrUrl", this.jZP);
        localJSONObject.put("qrResultUrl", paramString);
        localJSONObject.put("qrExtInfo", this.xMY);
        if (this.xMV != 0) {
          localJSONObject.put("qrResultUrlType", this.xMV);
        }
      }
      catch (Exception paramString)
      {
        ac.e("SnsAdQRHelper", "buildKVData exp:" + paramString.toString());
        continue;
      }
      AppMethodBeat.o(176237);
      return localJSONObject;
      paramInt = 1;
    }
  }
  
  public final boolean iT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(179078);
    this.xMW = paramString1;
    this.jZP = paramString2;
    ac.i("SnsAdQRHelper", "onLongClick, filePath=" + this.xMW);
    if (TextUtils.isEmpty(this.xMW))
    {
      dGy();
      AppMethodBeat.o(179078);
      return false;
    }
    long l = System.currentTimeMillis();
    com.tencent.qbar.e.fCh().a(this.mContext, l, this.xMW, new com.tencent.qbar.e.b()
    {
      public final void a(long paramAnonymousLong, List<a.a> paramAnonymousList, List<WxQbarNative.QBarReportMsg> paramAnonymousList1)
      {
        AppMethodBeat.i(176232);
        if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
        {
          int k = d.d.aFG(((a.a)paramAnonymousList.get(0)).typeName);
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
          ac.i("SnsAdQRHelper", "QRCodeStr=" + paramAnonymousList + ", QRCodeType=" + k + ", QRCodeVer=" + j);
          paramAnonymousList1 = g.this;
          if (!TextUtils.isEmpty(paramAnonymousList)) {
            if (f.bG(k, paramAnonymousList))
            {
              paramAnonymousList1.xMV = 2;
              i = 1;
            }
          }
          while (i == 0)
          {
            ac.e("SnsAdQRHelper", "isValidQRCode=false");
            g.this.bE(bs.nullAsNil(paramAnonymousList), false);
            g.this.dGy();
            AppMethodBeat.o(176232);
            return;
            if (f.bH(k, paramAnonymousList))
            {
              paramAnonymousList1.xMV = 3;
              i = 1;
            }
            else if (f.bI(k, paramAnonymousList))
            {
              paramAnonymousList1.xMV = 4;
              i = 1;
            }
            else if (f.bJ(k, paramAnonymousList))
            {
              paramAnonymousList1.xMV = 5;
              i = 1;
            }
            else if (f.bK(k, paramAnonymousList))
            {
              paramAnonymousList1.xMV = 1;
              i = 1;
            }
            else
            {
              i = 0;
            }
          }
          g.this.xMS = k;
          g.this.xMU = paramAnonymousList;
          g.this.xMT = j;
          paramAnonymousList = g.this;
          paramAnonymousList1 = g.this.xMU;
          if (!TextUtils.isEmpty(g.this.xMU)) {}
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousList.bE(paramAnonymousList1, bool);
            AdLandingPagesProxy.getInstance().fetchQRCodeInfo(g.this.xMS, g.this.xMU, new AdLandingPagesProxy.e()
            {
              public final void bc(Object paramAnonymous2Object) {}
              
              public final void h(final int paramAnonymous2Int1, int paramAnonymous2Int2, final Object paramAnonymous2Object)
              {
                AppMethodBeat.i(176230);
                StringBuilder localStringBuilder = new StringBuilder("fetchQRCodeInfo, errType=").append(paramAnonymous2Int1).append(", data==null?");
                if (paramAnonymous2Object == null) {}
                for (boolean bool = true;; bool = false)
                {
                  ac.i("SnsAdQRHelper", bool);
                  if (TextUtils.isEmpty(g.this.xMU)) {
                    break;
                  }
                  ap.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(176229);
                      try
                      {
                        byte[] arrayOfByte = (byte[])paramAnonymous2Object;
                        g.this.xMR.q(paramAnonymous2Int1, arrayOfByte);
                        g.this.ngY.cED();
                        AppMethodBeat.o(176229);
                        return;
                      }
                      catch (Throwable localThrowable)
                      {
                        ac.e("SnsAdQRHelper", "there is something wrong in AdLandingPagesProxy call back");
                        AppMethodBeat.o(176229);
                      }
                    }
                  });
                  AppMethodBeat.o(176230);
                  return;
                }
                ac.e("SnsAdQRHelper", "the qr code string is empty in AdLandingPagesProxy call back");
                AppMethodBeat.o(176230);
              }
            });
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(176231);
                g.this.ngY.cED();
                AppMethodBeat.o(176231);
              }
            });
            AppMethodBeat.o(176232);
            return;
          }
        }
        ac.e("SnsAdQRHelper", "afterDecode, results is empty");
        g.this.bE("", false);
        g.this.dGy();
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
      ae localae = this.xMX;
      paramString = i(paramInt, paramString, paramBoolean);
      String str1 = bs.nullAsNil(localae.dtx);
      String str2 = localae.getSnsId();
      paramInt = localae.dbL;
      long l = bs.aLz(localae.jYR);
      localJSONObject.put("extInfo", paramString);
      localJSONObject.put("uxinfo", str1);
      localJSONObject.put("snsId", str2);
      localJSONObject.put("scene", paramInt);
      localJSONObject.put("canvasId", l);
      if (!TextUtils.isEmpty(localae.xOm)) {
        localJSONObject.put("adExtInfo", localae.xOm);
      }
      paramString = localJSONObject.toString();
      ac.d("SnsAdQRHelper", "buildCgiReportData ret=".concat(String.valueOf(paramString)));
      AppMethodBeat.o(176238);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ac.e("SnsAdQRHelper", "buildCgiReportData exp:" + paramString.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.g
 * JD-Core Version:    0.7.0.1
 */