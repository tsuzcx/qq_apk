package com.tencent.mm.plugin.sns.data;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.f;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.ui.SnsAdProxyUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.bottomsheet.ViewTitleWithAnimation;
import com.tencent.qbar.WxQbarNative.QBarReportMsg;
import com.tencent.qbar.a.a;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONObject;

public final class g
{
  private String kul;
  Context mContext;
  int mScene;
  com.tencent.mm.ui.widget.a.e nHu;
  ScanCodeSheetItemLogic zcJ;
  int zcK;
  int zcL;
  volatile String zcM;
  int zcN;
  private String zcO;
  private ae zcP;
  private String zcQ;
  
  public g(Context paramContext, ae paramae, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(197750);
    this.mContext = paramContext;
    this.zcP = paramae;
    this.mScene = paramInt;
    this.zcN = 0;
    if (this.zcJ == null)
    {
      this.nHu = new com.tencent.mm.ui.widget.a.e(this.mContext, 1, false);
      this.zcJ = new ScanCodeSheetItemLogic(this.mContext);
      this.nHu.KJy = new n.d()
      {
        public final void onCreateMMMenu(l paramAnonymousl)
        {
          AppMethodBeat.i(176226);
          try
          {
            paramAnonymousl = g.this;
            paramAnonymousl = paramAnonymousl.zcJ.a(new g.3(paramAnonymousl), paramAnonymousl.zcK, paramAnonymousl.zcM, 9);
            if ((paramAnonymousl instanceof ViewTitleWithAnimation)) {
              ((ViewTitleWithAnimation)paramAnonymousl).setTopPaddingVisibility(8);
            }
            g.this.nHu.setFooterView(paramAnonymousl);
            paramAnonymousl = new View(g.this.mContext);
            paramAnonymousl.setMinimumHeight(com.tencent.mm.cc.a.fromDPToPix(g.this.mContext, 2));
            g.this.nHu.K(paramAnonymousl, true);
            AppMethodBeat.o(176226);
            return;
          }
          catch (Exception paramAnonymousl)
          {
            ad.e("SnsAdQRHelper", "onCreateMMMenu exp=" + paramAnonymousl.toString());
            AppMethodBeat.o(176226);
          }
        }
      };
      this.nHu.JXC = new com.tencent.mm.ui.widget.a.e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(176227);
          g.this.zcJ.onDismiss();
          g.this.dSL();
          AppMethodBeat.o(176227);
        }
      };
    }
    try
    {
      this.zcQ = bt.bI(y.m(paramBundle, "qrExtInfo"), "");
      AppMethodBeat.o(197750);
      return;
    }
    catch (Throwable paramContext)
    {
      ad.e("SnsAdQRHelper", "there is something wrong in parseExtraParams");
      AppMethodBeat.o(197750);
    }
  }
  
  public final void axL(String paramString)
  {
    AppMethodBeat.i(176236);
    try
    {
      Object localObject = this.zcP;
      String str1 = ((ae)localObject).getSnsId();
      String str2 = bt.nullAsNil(((ae)localObject).dFy);
      String str3 = bt.nullAsNil(((ae)localObject).zuP);
      int i = ((ae)localObject).dnh;
      localObject = URLEncoder.encode(paramString, "UTF-8");
      com.tencent.mm.plugin.report.service.g.yhR.f(17539, new Object[] { str1, str3, str2, Integer.valueOf(i), localObject });
      ad.d("SnsAdQRHelper", "reportKV17539 snsId=" + str1 + ", aid=" + str3 + ", uxInfo=" + str2 + ", kvData=" + paramString);
      AppMethodBeat.o(176236);
      return;
    }
    catch (Exception paramString)
    {
      ad.e("SnsAdQRHelper", "reportKV17539 exp:" + paramString.toString());
      AppMethodBeat.o(176236);
    }
  }
  
  public final void bL(String paramString, boolean paramBoolean)
  {
    int i = 2;
    AppMethodBeat.i(176235);
    if (this.mScene == 1) {}
    for (;;)
    {
      axL(i(i, paramString, paramBoolean).toString());
      j.jf("17539", j(i, paramString, paramBoolean));
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
  
  public final void dSL()
  {
    this.zcM = "";
    this.zcK = -1;
    this.zcO = "";
    this.kul = "";
    this.zcL = 0;
    this.zcN = 0;
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
        localJSONObject.put("qrUrl", this.kul);
        localJSONObject.put("qrResultUrl", paramString);
        localJSONObject.put("qrExtInfo", this.zcQ);
        if (this.zcN != 0) {
          localJSONObject.put("qrResultUrlType", this.zcN);
        }
      }
      catch (Exception paramString)
      {
        ad.e("SnsAdQRHelper", "buildKVData exp:" + paramString.toString());
        continue;
      }
      AppMethodBeat.o(176237);
      return localJSONObject;
      paramInt = 1;
    }
  }
  
  public final String j(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(176238);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      ae localae = this.zcP;
      paramString = i(paramInt, paramString, paramBoolean);
      String str1 = bt.nullAsNil(localae.dFy);
      String str2 = localae.getSnsId();
      paramInt = localae.dnh;
      long l = bt.aRf(localae.ktn);
      localJSONObject.put("extInfo", paramString);
      localJSONObject.put("uxinfo", str1);
      localJSONObject.put("snsId", str2);
      localJSONObject.put("scene", paramInt);
      localJSONObject.put("canvasId", l);
      if (!TextUtils.isEmpty(localae.zeg)) {
        localJSONObject.put("adExtInfo", localae.zeg);
      }
      paramString = localJSONObject.toString();
      ad.d("SnsAdQRHelper", "buildCgiReportData ret=".concat(String.valueOf(paramString)));
      AppMethodBeat.o(176238);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ad.e("SnsAdQRHelper", "buildCgiReportData exp:" + paramString.toString());
      }
    }
  }
  
  public final boolean je(String paramString1, String paramString2)
  {
    AppMethodBeat.i(179078);
    this.zcO = paramString1;
    this.kul = paramString2;
    ad.i("SnsAdQRHelper", "onLongClick, filePath=" + this.zcO);
    if (TextUtils.isEmpty(this.zcO))
    {
      dSL();
      AppMethodBeat.o(179078);
      return false;
    }
    long l = System.currentTimeMillis();
    com.tencent.qbar.e.fTw().a(this.mContext, l, this.zcO, new com.tencent.qbar.e.b()
    {
      public final void a(long paramAnonymousLong, com.tencent.qbar.e.d paramAnonymousd)
      {
        AppMethodBeat.i(197749);
        label24:
        int k;
        int i;
        int j;
        if (paramAnonymousd != null)
        {
          localObject = paramAnonymousd.yof;
          if (paramAnonymousd == null) {
            break label230;
          }
          paramAnonymousd = paramAnonymousd.LKK;
          if ((localObject == null) || (((List)localObject).size() <= 0)) {
            break label441;
          }
          k = com.tencent.mm.pluginsdk.e.d.aLg(((a.a)((List)localObject).get(0)).typeName);
          localObject = ((a.a)((List)localObject).get(0)).data;
          i = -1;
          j = i;
          if (paramAnonymousd != null)
          {
            j = i;
            if (!paramAnonymousd.isEmpty()) {
              j = ((WxQbarNative.QBarReportMsg)paramAnonymousd.get(0)).qrcodeVersion;
            }
          }
          ad.i("SnsAdQRHelper", "QRCodeStr=" + (String)localObject + ", QRCodeType=" + k + ", QRCodeVer=" + j);
          paramAnonymousd = g.this;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label319;
          }
          if (!f.bM(k, (String)localObject)) {
            break label235;
          }
          paramAnonymousd.zcN = 2;
          i = 1;
        }
        label319:
        for (;;)
        {
          if (i != 0) {
            break label325;
          }
          ad.e("SnsAdQRHelper", "isValidQRCode=false");
          g.this.bL(bt.nullAsNil((String)localObject), false);
          g.this.dSL();
          AppMethodBeat.o(197749);
          return;
          localObject = null;
          break;
          label230:
          paramAnonymousd = null;
          break label24;
          label235:
          if (f.bN(k, (String)localObject))
          {
            paramAnonymousd.zcN = 3;
            i = 1;
          }
          else if (f.bO(k, (String)localObject))
          {
            paramAnonymousd.zcN = 4;
            i = 1;
          }
          else if (f.bP(k, (String)localObject))
          {
            paramAnonymousd.zcN = 5;
            i = 1;
          }
          else if (f.bQ(k, (String)localObject))
          {
            paramAnonymousd.zcN = 1;
            i = 1;
          }
          else
          {
            i = 0;
          }
        }
        label325:
        g.this.zcK = k;
        g.this.zcM = ((String)localObject);
        g.this.zcL = j;
        paramAnonymousd = g.this;
        Object localObject = g.this.zcM;
        if (!TextUtils.isEmpty(g.this.zcM)) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousd.bL((String)localObject, bool);
          AdLandingPagesProxy.getInstance().fetchQRCodeInfo(g.this.zcK, g.this.zcM, new AdLandingPagesProxy.e()
          {
            public final void be(Object paramAnonymous2Object) {}
            
            public final void h(final int paramAnonymous2Int1, int paramAnonymous2Int2, final Object paramAnonymous2Object)
            {
              AppMethodBeat.i(176230);
              StringBuilder localStringBuilder = new StringBuilder("fetchQRCodeInfo, errType=").append(paramAnonymous2Int1).append(", data==null?");
              if (paramAnonymous2Object == null) {}
              for (boolean bool = true;; bool = false)
              {
                ad.i("SnsAdQRHelper", bool);
                if (TextUtils.isEmpty(g.this.zcM)) {
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
                      g.this.zcJ.q(paramAnonymous2Int1, arrayOfByte);
                      g.this.nHu.cMW();
                      AppMethodBeat.o(176229);
                      return;
                    }
                    catch (Throwable localThrowable)
                    {
                      ad.e("SnsAdQRHelper", "there is something wrong in AdLandingPagesProxy call back");
                      AppMethodBeat.o(176229);
                    }
                  }
                });
                AppMethodBeat.o(176230);
                return;
              }
              ad.e("SnsAdQRHelper", "the qr code string is empty in AdLandingPagesProxy call back");
              AppMethodBeat.o(176230);
            }
          });
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(176231);
              g.this.nHu.cMW();
              AppMethodBeat.o(176231);
            }
          });
          AppMethodBeat.o(197749);
          return;
        }
        label441:
        ad.e("SnsAdQRHelper", "afterDecode, results is empty");
        g.this.bL("", false);
        g.this.dSL();
        AppMethodBeat.o(197749);
      }
    }, new int[] { 0 });
    AppMethodBeat.o(179078);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.g
 * JD-Core Version:    0.7.0.1
 */