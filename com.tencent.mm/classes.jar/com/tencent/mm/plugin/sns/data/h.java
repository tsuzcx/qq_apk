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
import com.tencent.mm.plugin.scanner.g;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.ui.SnsAdProxyUI;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.widget.bottomsheet.ViewTitleWithAnimation;
import com.tencent.qbar.WxQbarNative.QBarReportMsg;
import com.tencent.qbar.a.a;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONObject;

public final class h
{
  ScanCodeSheetItemLogic DDK;
  int DDL;
  int DDM;
  volatile String DDN;
  int DDO;
  private String DDP;
  private ah DDQ;
  private String DDR;
  private String lBO;
  Context mContext;
  int mScene;
  com.tencent.mm.ui.widget.a.e oXS;
  
  public h(Context paramContext, ah paramah, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(202581);
    this.mContext = paramContext;
    this.DDQ = paramah;
    this.mScene = paramInt;
    this.DDO = 0;
    if (this.DDK == null)
    {
      this.oXS = new com.tencent.mm.ui.widget.a.e(this.mContext, 1, false);
      this.DDK = new ScanCodeSheetItemLogic(this.mContext);
      this.oXS.mLO = true;
      this.oXS.HLX = new o.f()
      {
        public final void onCreateMMMenu(m paramAnonymousm)
        {
          AppMethodBeat.i(176226);
          try
          {
            paramAnonymousm = h.this;
            paramAnonymousm = paramAnonymousm.DDK.a(new h.3(paramAnonymousm), paramAnonymousm.DDL, paramAnonymousm.DDN, 9);
            if ((paramAnonymousm instanceof ViewTitleWithAnimation)) {
              ((ViewTitleWithAnimation)paramAnonymousm).setTopPaddingVisibility(8);
            }
            h.this.oXS.setFooterView(paramAnonymousm);
            paramAnonymousm = new View(h.this.mContext);
            paramAnonymousm.setMinimumHeight(com.tencent.mm.cb.a.fromDPToPix(h.this.mContext, 2));
            h.this.oXS.V(paramAnonymousm, true);
            AppMethodBeat.o(176226);
            return;
          }
          catch (Exception paramAnonymousm)
          {
            Log.e("SnsAdQRHelper", "onCreateMMMenu exp=" + paramAnonymousm.toString());
            AppMethodBeat.o(176226);
          }
        }
      };
      this.oXS.PGl = new com.tencent.mm.ui.widget.a.e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(176227);
          h.this.DDK.onDismiss();
          h.this.eZt();
          AppMethodBeat.o(176227);
        }
      };
    }
    try
    {
      this.DDR = Util.nullAs(IntentUtil.getString(paramBundle, "qrExtInfo"), "");
      AppMethodBeat.o(202581);
      return;
    }
    catch (Throwable paramContext)
    {
      Log.e("SnsAdQRHelper", "there is something wrong in parseExtraParams");
      AppMethodBeat.o(202581);
    }
  }
  
  public final void aNY(String paramString)
  {
    AppMethodBeat.i(176236);
    try
    {
      Object localObject = this.DDQ;
      String str1 = ((ah)localObject).getSnsId();
      String str2 = Util.nullAsNil(((ah)localObject).uxInfo);
      String str3 = Util.nullAsNil(((ah)localObject).aid);
      int i = ((ah)localObject).source;
      localObject = URLEncoder.encode(paramString, "UTF-8");
      com.tencent.mm.plugin.report.service.h.CyF.a(17539, new Object[] { str1, str3, str2, Integer.valueOf(i), localObject });
      Log.d("SnsAdQRHelper", "reportKV17539 snsId=" + str1 + ", aid=" + str3 + ", uxInfo=" + str2 + ", kvData=" + paramString);
      AppMethodBeat.o(176236);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("SnsAdQRHelper", "reportKV17539 exp:" + paramString.toString());
      AppMethodBeat.o(176236);
    }
  }
  
  public final void ch(String paramString, boolean paramBoolean)
  {
    int i = 2;
    AppMethodBeat.i(176235);
    if (this.mScene == 1) {}
    for (;;)
    {
      aNY(g(i, paramString, paramBoolean).toString());
      k.jY("17539", h(i, paramString, paramBoolean));
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
  
  public final void eZt()
  {
    this.DDN = "";
    this.DDL = -1;
    this.DDP = "";
    this.lBO = "";
    this.DDM = 0;
    this.DDO = 0;
  }
  
  public final JSONObject g(int paramInt, String paramString, boolean paramBoolean)
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
        localJSONObject.put("qrUrl", this.lBO);
        localJSONObject.put("qrResultUrl", paramString);
        localJSONObject.put("qrExtInfo", this.DDR);
        if (this.DDO != 0) {
          localJSONObject.put("qrResultUrlType", this.DDO);
        }
      }
      catch (Exception paramString)
      {
        Log.e("SnsAdQRHelper", "buildKVData exp:" + paramString.toString());
        continue;
      }
      AppMethodBeat.o(176237);
      return localJSONObject;
      paramInt = 1;
    }
  }
  
  public final String h(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(176238);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      ah localah = this.DDQ;
      paramString = g(paramInt, paramString, paramBoolean);
      String str1 = Util.nullAsNil(localah.uxInfo);
      String str2 = localah.getSnsId();
      paramInt = localah.source;
      long l = Util.safeParseLong(localah.lAN);
      localJSONObject.put("extInfo", paramString);
      localJSONObject.put("uxinfo", str1);
      localJSONObject.put("snsId", str2);
      localJSONObject.put("scene", paramInt);
      localJSONObject.put("canvasId", l);
      if (!TextUtils.isEmpty(localah.adExtInfo)) {
        localJSONObject.put("adExtInfo", localah.adExtInfo);
      }
      paramString = localJSONObject.toString();
      Log.d("SnsAdQRHelper", "buildCgiReportData ret=".concat(String.valueOf(paramString)));
      AppMethodBeat.o(176238);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("SnsAdQRHelper", "buildCgiReportData exp:" + paramString.toString());
      }
    }
  }
  
  public final boolean jX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(179078);
    this.DDP = paramString1;
    this.lBO = paramString2;
    Log.i("SnsAdQRHelper", "onLongClick, filePath=" + this.DDP);
    if (TextUtils.isEmpty(this.DDP))
    {
      eZt();
      AppMethodBeat.o(179078);
      return false;
    }
    long l = System.currentTimeMillis();
    com.tencent.qbar.e.hki().a(this.mContext, l, this.DDP, new com.tencent.qbar.e.b()
    {
      public final void a(long paramAnonymousLong, com.tencent.qbar.e.d paramAnonymousd)
      {
        AppMethodBeat.i(202580);
        label24:
        int k;
        int i;
        int j;
        if (paramAnonymousd != null)
        {
          localObject = paramAnonymousd.CGY;
          if (paramAnonymousd == null) {
            break label230;
          }
          paramAnonymousd = paramAnonymousd.RKk;
          if ((localObject == null) || (((List)localObject).size() <= 0)) {
            break label463;
          }
          k = com.tencent.mm.pluginsdk.e.d.bcV(((a.a)((List)localObject).get(0)).typeName);
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
          Log.i("SnsAdQRHelper", "QRCodeStr=" + (String)localObject + ", QRCodeType=" + k + ", QRCodeVer=" + j);
          paramAnonymousd = h.this;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label341;
          }
          if (!g.ca(k, (String)localObject)) {
            break label235;
          }
          paramAnonymousd.DDO = 2;
          i = 1;
        }
        label341:
        for (;;)
        {
          if (i != 0) {
            break label347;
          }
          Log.e("SnsAdQRHelper", "isValidQRCode=false");
          h.this.ch(Util.nullAsNil((String)localObject), false);
          h.this.eZt();
          AppMethodBeat.o(202580);
          return;
          localObject = null;
          break;
          label230:
          paramAnonymousd = null;
          break label24;
          label235:
          if (g.cb(k, (String)localObject))
          {
            paramAnonymousd.DDO = 3;
            i = 1;
          }
          else if (g.cc(k, (String)localObject))
          {
            paramAnonymousd.DDO = 4;
            i = 1;
          }
          else if (g.cd(k, (String)localObject))
          {
            paramAnonymousd.DDO = 5;
            i = 1;
          }
          else if (g.ce(k, (String)localObject))
          {
            paramAnonymousd.DDO = 1;
            i = 1;
          }
          else if (g.cf(k, (String)localObject))
          {
            paramAnonymousd.DDO = 6;
            i = 1;
          }
          else
          {
            i = 0;
          }
        }
        label347:
        h.this.DDL = k;
        h.this.DDN = ((String)localObject);
        h.this.DDM = j;
        paramAnonymousd = h.this;
        Object localObject = h.this.DDN;
        if (!TextUtils.isEmpty(h.this.DDN)) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousd.ch((String)localObject, bool);
          AdLandingPagesProxy.getInstance().fetchQRCodeInfo(h.this.DDL, h.this.DDN, new AdLandingPagesProxy.e()
          {
            public final void bn(Object paramAnonymous2Object) {}
            
            public final void h(final int paramAnonymous2Int1, int paramAnonymous2Int2, final Object paramAnonymous2Object)
            {
              AppMethodBeat.i(176230);
              StringBuilder localStringBuilder = new StringBuilder("fetchQRCodeInfo, errType=").append(paramAnonymous2Int1).append(", data==null?");
              if (paramAnonymous2Object == null) {}
              for (boolean bool = true;; bool = false)
              {
                Log.i("SnsAdQRHelper", bool);
                if (TextUtils.isEmpty(h.this.DDN)) {
                  break;
                }
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(176229);
                    try
                    {
                      byte[] arrayOfByte = (byte[])paramAnonymous2Object;
                      h.this.DDK.q(paramAnonymous2Int1, arrayOfByte);
                      h.this.oXS.dGm();
                      AppMethodBeat.o(176229);
                      return;
                    }
                    catch (Throwable localThrowable)
                    {
                      Log.e("SnsAdQRHelper", "there is something wrong in AdLandingPagesProxy call back");
                      AppMethodBeat.o(176229);
                    }
                  }
                });
                AppMethodBeat.o(176230);
                return;
              }
              Log.e("SnsAdQRHelper", "the qr code string is empty in AdLandingPagesProxy call back");
              AppMethodBeat.o(176230);
            }
          });
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(176231);
              h.this.oXS.dGm();
              AppMethodBeat.o(176231);
            }
          });
          AppMethodBeat.o(202580);
          return;
        }
        label463:
        Log.e("SnsAdQRHelper", "afterDecode, results is empty");
        h.this.ch("", false);
        h.this.eZt();
        AppMethodBeat.o(202580);
      }
    });
    AppMethodBeat.o(179078);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.h
 * JD-Core Version:    0.7.0.1
 */