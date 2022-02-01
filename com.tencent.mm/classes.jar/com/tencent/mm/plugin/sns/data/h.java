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
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af;
import com.tencent.mm.plugin.sns.ui.SnsAdProxyUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.bottomsheet.ViewTitleWithAnimation;
import com.tencent.qbar.WxQbarNative.QBarReportMsg;
import com.tencent.qbar.a.a;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONObject;

public final class h
{
  private String kxB;
  Context mContext;
  int mScene;
  com.tencent.mm.ui.widget.a.e nMW;
  int ztA;
  int ztB;
  volatile String ztC;
  int ztD;
  private String ztE;
  private af ztF;
  private String ztG;
  ScanCodeSheetItemLogic ztz;
  
  public h(Context paramContext, af paramaf, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(219233);
    this.mContext = paramContext;
    this.ztF = paramaf;
    this.mScene = paramInt;
    this.ztD = 0;
    if (this.ztz == null)
    {
      this.nMW = new com.tencent.mm.ui.widget.a.e(this.mContext, 1, false);
      this.ztz = new ScanCodeSheetItemLogic(this.mContext);
      this.nMW.lEf = true;
      this.nMW.LfS = new n.d()
      {
        public final void onCreateMMMenu(l paramAnonymousl)
        {
          AppMethodBeat.i(176226);
          try
          {
            paramAnonymousl = h.this;
            paramAnonymousl = paramAnonymousl.ztz.a(new h.3(paramAnonymousl), paramAnonymousl.ztA, paramAnonymousl.ztC, 9);
            if ((paramAnonymousl instanceof ViewTitleWithAnimation)) {
              ((ViewTitleWithAnimation)paramAnonymousl).setTopPaddingVisibility(8);
            }
            h.this.nMW.setFooterView(paramAnonymousl);
            paramAnonymousl = new View(h.this.mContext);
            paramAnonymousl.setMinimumHeight(com.tencent.mm.cb.a.fromDPToPix(h.this.mContext, 2));
            h.this.nMW.P(paramAnonymousl, true);
            AppMethodBeat.o(176226);
            return;
          }
          catch (Exception paramAnonymousl)
          {
            ae.e("SnsAdQRHelper", "onCreateMMMenu exp=" + paramAnonymousl.toString());
            AppMethodBeat.o(176226);
          }
        }
      };
      this.nMW.KtV = new com.tencent.mm.ui.widget.a.e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(176227);
          h.this.ztz.onDismiss();
          h.this.dWl();
          AppMethodBeat.o(176227);
        }
      };
    }
    try
    {
      this.ztG = bu.bI(z.m(paramBundle, "qrExtInfo"), "");
      AppMethodBeat.o(219233);
      return;
    }
    catch (Throwable paramContext)
    {
      ae.e("SnsAdQRHelper", "there is something wrong in parseExtraParams");
      AppMethodBeat.o(219233);
    }
  }
  
  public final void azc(String paramString)
  {
    AppMethodBeat.i(176236);
    try
    {
      Object localObject = this.ztF;
      String str1 = ((af)localObject).getSnsId();
      String str2 = bu.nullAsNil(((af)localObject).dGD);
      String str3 = bu.nullAsNil(((af)localObject).zMk);
      int i = ((af)localObject).doj;
      localObject = URLEncoder.encode(paramString, "UTF-8");
      com.tencent.mm.plugin.report.service.g.yxI.f(17539, new Object[] { str1, str3, str2, Integer.valueOf(i), localObject });
      ae.d("SnsAdQRHelper", "reportKV17539 snsId=" + str1 + ", aid=" + str3 + ", uxInfo=" + str2 + ", kvData=" + paramString);
      AppMethodBeat.o(176236);
      return;
    }
    catch (Exception paramString)
    {
      ae.e("SnsAdQRHelper", "reportKV17539 exp:" + paramString.toString());
      AppMethodBeat.o(176236);
    }
  }
  
  public final void bP(String paramString, boolean paramBoolean)
  {
    int i = 2;
    AppMethodBeat.i(176235);
    if (this.mScene == 1) {}
    for (;;)
    {
      azc(i(i, paramString, paramBoolean).toString());
      k.jm("17539", j(i, paramString, paramBoolean));
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
  
  public final void dWl()
  {
    this.ztC = "";
    this.ztA = -1;
    this.ztE = "";
    this.kxB = "";
    this.ztB = 0;
    this.ztD = 0;
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
        localJSONObject.put("qrUrl", this.kxB);
        localJSONObject.put("qrResultUrl", paramString);
        localJSONObject.put("qrExtInfo", this.ztG);
        if (this.ztD != 0) {
          localJSONObject.put("qrResultUrlType", this.ztD);
        }
      }
      catch (Exception paramString)
      {
        ae.e("SnsAdQRHelper", "buildKVData exp:" + paramString.toString());
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
      af localaf = this.ztF;
      paramString = i(paramInt, paramString, paramBoolean);
      String str1 = bu.nullAsNil(localaf.dGD);
      String str2 = localaf.getSnsId();
      paramInt = localaf.doj;
      long l = bu.aSC(localaf.kwD);
      localJSONObject.put("extInfo", paramString);
      localJSONObject.put("uxinfo", str1);
      localJSONObject.put("snsId", str2);
      localJSONObject.put("scene", paramInt);
      localJSONObject.put("canvasId", l);
      if (!TextUtils.isEmpty(localaf.zsJ)) {
        localJSONObject.put("adExtInfo", localaf.zsJ);
      }
      paramString = localJSONObject.toString();
      ae.d("SnsAdQRHelper", "buildCgiReportData ret=".concat(String.valueOf(paramString)));
      AppMethodBeat.o(176238);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ae.e("SnsAdQRHelper", "buildCgiReportData exp:" + paramString.toString());
      }
    }
  }
  
  public final boolean jl(String paramString1, String paramString2)
  {
    AppMethodBeat.i(179078);
    this.ztE = paramString1;
    this.kxB = paramString2;
    ae.i("SnsAdQRHelper", "onLongClick, filePath=" + this.ztE);
    if (TextUtils.isEmpty(this.ztE))
    {
      dWl();
      AppMethodBeat.o(179078);
      return false;
    }
    long l = System.currentTimeMillis();
    com.tencent.qbar.e.fXW().a(this.mContext, l, this.ztE, new com.tencent.qbar.e.b()
    {
      public final void a(long paramAnonymousLong, com.tencent.qbar.e.d paramAnonymousd)
      {
        AppMethodBeat.i(219232);
        label24:
        int k;
        int i;
        int j;
        if (paramAnonymousd != null)
        {
          localObject = paramAnonymousd.yEe;
          if (paramAnonymousd == null) {
            break label230;
          }
          paramAnonymousd = paramAnonymousd.MhJ;
          if ((localObject == null) || (((List)localObject).size() <= 0)) {
            break label441;
          }
          k = com.tencent.mm.pluginsdk.e.d.aMC(((a.a)((List)localObject).get(0)).typeName);
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
          ae.i("SnsAdQRHelper", "QRCodeStr=" + (String)localObject + ", QRCodeType=" + k + ", QRCodeVer=" + j);
          paramAnonymousd = h.this;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label319;
          }
          if (!com.tencent.mm.plugin.scanner.g.bM(k, (String)localObject)) {
            break label235;
          }
          paramAnonymousd.ztD = 2;
          i = 1;
        }
        label319:
        for (;;)
        {
          if (i != 0) {
            break label325;
          }
          ae.e("SnsAdQRHelper", "isValidQRCode=false");
          h.this.bP(bu.nullAsNil((String)localObject), false);
          h.this.dWl();
          AppMethodBeat.o(219232);
          return;
          localObject = null;
          break;
          label230:
          paramAnonymousd = null;
          break label24;
          label235:
          if (com.tencent.mm.plugin.scanner.g.bN(k, (String)localObject))
          {
            paramAnonymousd.ztD = 3;
            i = 1;
          }
          else if (com.tencent.mm.plugin.scanner.g.bO(k, (String)localObject))
          {
            paramAnonymousd.ztD = 4;
            i = 1;
          }
          else if (com.tencent.mm.plugin.scanner.g.bP(k, (String)localObject))
          {
            paramAnonymousd.ztD = 5;
            i = 1;
          }
          else if (com.tencent.mm.plugin.scanner.g.bQ(k, (String)localObject))
          {
            paramAnonymousd.ztD = 1;
            i = 1;
          }
          else
          {
            i = 0;
          }
        }
        label325:
        h.this.ztA = k;
        h.this.ztC = ((String)localObject);
        h.this.ztB = j;
        paramAnonymousd = h.this;
        Object localObject = h.this.ztC;
        if (!TextUtils.isEmpty(h.this.ztC)) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousd.bP((String)localObject, bool);
          AdLandingPagesProxy.getInstance().fetchQRCodeInfo(h.this.ztA, h.this.ztC, new AdLandingPagesProxy.e()
          {
            public final void be(Object paramAnonymous2Object) {}
            
            public final void h(final int paramAnonymous2Int1, int paramAnonymous2Int2, final Object paramAnonymous2Object)
            {
              AppMethodBeat.i(176230);
              StringBuilder localStringBuilder = new StringBuilder("fetchQRCodeInfo, errType=").append(paramAnonymous2Int1).append(", data==null?");
              if (paramAnonymous2Object == null) {}
              for (boolean bool = true;; bool = false)
              {
                ae.i("SnsAdQRHelper", bool);
                if (TextUtils.isEmpty(h.this.ztC)) {
                  break;
                }
                ar.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(176229);
                    try
                    {
                      byte[] arrayOfByte = (byte[])paramAnonymous2Object;
                      h.this.ztz.q(paramAnonymous2Int1, arrayOfByte);
                      h.this.nMW.cPF();
                      AppMethodBeat.o(176229);
                      return;
                    }
                    catch (Throwable localThrowable)
                    {
                      ae.e("SnsAdQRHelper", "there is something wrong in AdLandingPagesProxy call back");
                      AppMethodBeat.o(176229);
                    }
                  }
                });
                AppMethodBeat.o(176230);
                return;
              }
              ae.e("SnsAdQRHelper", "the qr code string is empty in AdLandingPagesProxy call back");
              AppMethodBeat.o(176230);
            }
          });
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(176231);
              h.this.nMW.cPF();
              AppMethodBeat.o(176231);
            }
          });
          AppMethodBeat.o(219232);
          return;
        }
        label441:
        ae.e("SnsAdQRHelper", "afterDecode, results is empty");
        h.this.bP("", false);
        h.this.dWl();
        AppMethodBeat.o(219232);
      }
    });
    AppMethodBeat.o(179078);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.h
 * JD-Core Version:    0.7.0.1
 */