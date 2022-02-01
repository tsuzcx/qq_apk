package com.tencent.mm.plugin.sns.data;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.k;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.ui.SnsAdProxyUI;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.bottomsheet.ViewTitleWithAnimation;
import com.tencent.qbar.WxQbarNative.QBarReportMsg;
import com.tencent.qbar.a.a;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONObject;

public final class j
{
  ScanCodeSheetItemLogic JQp;
  int JQq;
  int JQr;
  volatile String JQs;
  private int JQt;
  private String JQu;
  private ai JQv;
  private String JQw;
  private int JQx;
  Context mContext;
  private int mScene;
  private String oxn;
  com.tencent.mm.ui.widget.a.e rZT;
  
  public j(Context paramContext, ai paramai, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(228495);
    this.mContext = paramContext;
    this.JQv = paramai;
    this.mScene = paramInt;
    this.JQt = 0;
    if (this.JQp == null)
    {
      this.rZT = new com.tencent.mm.ui.widget.a.e(this.mContext, 1, false);
      this.JQp = new ScanCodeSheetItemLogic(this.mContext);
      this.rZT.pMG = true;
      this.rZT.ODT = new q.f()
      {
        public final void onCreateMMMenu(o paramAnonymouso)
        {
          AppMethodBeat.i(176226);
          try
          {
            paramAnonymouso = j.this;
            paramAnonymouso = paramAnonymouso.JQp.a(new j.3(paramAnonymouso), paramAnonymouso.JQq, paramAnonymouso.JQs, 9);
            if ((paramAnonymouso instanceof ViewTitleWithAnimation)) {
              ((ViewTitleWithAnimation)paramAnonymouso).setTopPaddingVisibility(8);
            }
            j.this.rZT.setFooterView(paramAnonymouso);
            paramAnonymouso = new View(j.this.mContext);
            paramAnonymouso.setMinimumHeight(com.tencent.mm.ci.a.fromDPToPix(j.this.mContext, 2));
            j.this.rZT.Z(paramAnonymouso, true);
            AppMethodBeat.o(176226);
            return;
          }
          catch (Exception paramAnonymouso)
          {
            Log.e("SnsAdQRHelper", "onCreateMMMenu exp=" + paramAnonymouso.toString());
            AppMethodBeat.o(176226);
          }
        }
      };
      this.rZT.XbB = new com.tencent.mm.ui.widget.a.e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(176227);
          j.this.JQp.onDismiss();
          j.this.fNl();
          AppMethodBeat.o(176227);
        }
      };
    }
    try
    {
      this.JQw = Util.nullAs(IntentUtil.getString(paramBundle, "qrExtInfo"), "");
      this.JQx = IntentUtil.getInt(paramBundle, "qrIsDirectJump", 0);
      AppMethodBeat.o(228495);
      return;
    }
    catch (Throwable paramContext)
    {
      Log.e("SnsAdQRHelper", "there is something wrong in parseExtraParams");
      AppMethodBeat.o(228495);
    }
  }
  
  private void aYQ(String paramString)
  {
    AppMethodBeat.i(176236);
    try
    {
      Object localObject = this.JQv;
      String str1 = ((ai)localObject).getSnsId();
      String str2 = Util.nullAsNil(((ai)localObject).uxInfo);
      String str3 = Util.nullAsNil(((ai)localObject).aid);
      int i = ((ai)localObject).source;
      localObject = URLEncoder.encode(paramString, "UTF-8");
      h.IzE.a(17539, new Object[] { str1, str3, str2, Integer.valueOf(i), localObject });
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
  
  private JSONObject h(int paramInt, String paramString, boolean paramBoolean)
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
        localJSONObject.put("qrUrl", this.oxn);
        localJSONObject.put("qrResultUrl", paramString);
        localJSONObject.put("qrExtInfo", this.JQw);
        localJSONObject.put("directJump", this.JQx);
        if (this.JQt != 0) {
          localJSONObject.put("qrResultUrlType", this.JQt);
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
  
  private String i(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(176238);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      ai localai = this.JQv;
      paramString = h(paramInt, paramString, paramBoolean);
      String str1 = Util.nullAsNil(localai.uxInfo);
      String str2 = localai.getSnsId();
      paramInt = localai.source;
      long l = Util.safeParseLong(localai.owd);
      localJSONObject.put("extInfo", paramString);
      localJSONObject.put("uxinfo", str1);
      localJSONObject.put("snsId", str2);
      localJSONObject.put("scene", paramInt);
      localJSONObject.put("canvasId", l);
      if (!TextUtils.isEmpty(localai.adExtInfo)) {
        localJSONObject.put("adExtInfo", localai.adExtInfo);
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
  
  public final void a(final s params)
  {
    AppMethodBeat.i(228540);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(269720);
        if ((params != null) && (params.isShowing())) {
          params.dismiss();
        }
        AppMethodBeat.o(269720);
      }
    });
    AppMethodBeat.o(228540);
  }
  
  public final boolean a(String paramString1, String paramString2, final s params)
  {
    AppMethodBeat.i(228504);
    this.JQu = paramString1;
    this.oxn = paramString2;
    Log.i("SnsAdQRHelper", "onLongClick, filePath=" + this.JQu);
    if (TextUtils.isEmpty(this.JQu))
    {
      a(params);
      fNl();
      AppMethodBeat.o(228504);
      return false;
    }
    long l = System.currentTimeMillis();
    com.tencent.qbar.e.inE().a(this.mContext, l, this.JQu, new com.tencent.qbar.e.b()
    {
      public final void a(long paramAnonymousLong, com.tencent.qbar.e.d paramAnonymousd)
      {
        AppMethodBeat.i(267200);
        Object localObject;
        if (paramAnonymousd != null)
        {
          localObject = paramAnonymousd.IMj;
          if (paramAnonymousd == null) {
            break label219;
          }
          paramAnonymousd = paramAnonymousd.ZmS;
        }
        label219:
        boolean bool;
        for (;;)
        {
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            int k = com.tencent.mm.pluginsdk.e.d.boV(((a.a)((List)localObject).get(0)).typeName);
            localObject = ((a.a)((List)localObject).get(0)).data;
            int j = -1;
            int i = j;
            if (paramAnonymousd != null)
            {
              i = j;
              if (!paramAnonymousd.isEmpty()) {
                i = ((WxQbarNative.QBarReportMsg)paramAnonymousd.get(0)).qrcodeVersion;
              }
            }
            Log.i("SnsAdQRHelper", "QRCodeStr=" + (String)localObject + ", QRCodeType=" + k + ", QRCodeVer=" + i);
            if (!j.this.cp(k, (String)localObject))
            {
              Log.e("SnsAdQRHelper", "isValidQRCode=false");
              j.this.cu(Util.nullAsNil((String)localObject), false);
              j.this.a(params);
              j.this.fNl();
              AppMethodBeat.o(267200);
              return;
              localObject = null;
              break;
              paramAnonymousd = null;
              continue;
            }
            j.this.JQq = k;
            j.this.JQs = ((String)localObject);
            j.this.JQr = i;
            paramAnonymousd = j.this;
            localObject = j.this.JQs;
            if (!TextUtils.isEmpty(j.this.JQs))
            {
              bool = true;
              paramAnonymousd.cu((String)localObject, bool);
              AdLandingPagesProxy.getInstance().fetchQRCodeInfo(j.this.JQq, j.this.JQs, new AdLandingPagesProxy.e()
              {
                public final void aH(Object paramAnonymous2Object) {}
                
                public final void i(final int paramAnonymous2Int1, int paramAnonymous2Int2, final Object paramAnonymous2Object)
                {
                  AppMethodBeat.i(207082);
                  StringBuilder localStringBuilder = new StringBuilder("fetchQRCodeInfo, errType=").append(paramAnonymous2Int1).append(", data==null?");
                  if (paramAnonymous2Object == null) {}
                  for (boolean bool = true;; bool = false)
                  {
                    Log.i("SnsAdQRHelper", bool);
                    if (TextUtils.isEmpty(j.this.JQs)) {
                      break;
                    }
                    MMHandlerThread.postToMainThread(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(267782);
                        try
                        {
                          byte[] arrayOfByte = (byte[])paramAnonymous2Object;
                          j.this.JQp.r(paramAnonymous2Int1, arrayOfByte);
                          j.this.rZT.eik();
                          AppMethodBeat.o(267782);
                          return;
                        }
                        catch (Throwable localThrowable)
                        {
                          Log.e("SnsAdQRHelper", "there is something wrong in AdLandingPagesProxy call back");
                          AppMethodBeat.o(267782);
                        }
                      }
                    });
                    AppMethodBeat.o(207082);
                    return;
                  }
                  Log.e("SnsAdQRHelper", "the qr code string is empty in AdLandingPagesProxy call back");
                  AppMethodBeat.o(207082);
                }
              });
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(254060);
                  j.this.rZT.eik();
                  AppMethodBeat.o(254060);
                }
              });
            }
          }
        }
        for (;;)
        {
          j.this.a(params);
          AppMethodBeat.o(267200);
          return;
          bool = false;
          break;
          Log.e("SnsAdQRHelper", "afterDecode, results is empty");
          j.this.cu("", false);
          j.this.fNl();
        }
      }
    });
    AppMethodBeat.o(228504);
    return true;
  }
  
  public final boolean b(String paramString1, String paramString2, final s params)
  {
    AppMethodBeat.i(228510);
    this.JQu = paramString1;
    this.oxn = paramString2;
    Log.i("SnsAdQRHelper", "onClickDirect, filePath=" + this.JQu);
    if (TextUtils.isEmpty(this.JQu))
    {
      a(params);
      fNl();
      AppMethodBeat.o(228510);
      return false;
    }
    long l = System.currentTimeMillis();
    com.tencent.qbar.e.inE().a(this.mContext, l, this.JQu, new com.tencent.qbar.e.b()
    {
      public final void a(long paramAnonymousLong, com.tencent.qbar.e.d paramAnonymousd)
      {
        boolean bool2 = true;
        AppMethodBeat.i(195370);
        Object localObject;
        if (paramAnonymousd != null)
        {
          localObject = paramAnonymousd.IMj;
          if (paramAnonymousd == null) {
            break label222;
          }
          paramAnonymousd = paramAnonymousd.ZmS;
        }
        label222:
        boolean bool1;
        for (;;)
        {
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            int k = com.tencent.mm.pluginsdk.e.d.boV(((a.a)((List)localObject).get(0)).typeName);
            localObject = ((a.a)((List)localObject).get(0)).data;
            int j = -1;
            int i = j;
            if (paramAnonymousd != null)
            {
              i = j;
              if (!paramAnonymousd.isEmpty()) {
                i = ((WxQbarNative.QBarReportMsg)paramAnonymousd.get(0)).qrcodeVersion;
              }
            }
            Log.i("SnsAdQRHelper", "QRCodeStr=" + (String)localObject + ", QRCodeType=" + k + ", QRCodeVer=" + i);
            if (!j.this.cp(k, (String)localObject))
            {
              Log.e("SnsAdQRHelper", "isValidQRCode=false");
              j.this.cu(Util.nullAsNil((String)localObject), false);
              j.this.a(params);
              j.this.fNl();
              AppMethodBeat.o(195370);
              return;
              localObject = null;
              break;
              paramAnonymousd = null;
              continue;
            }
            j.this.JQq = k;
            j.this.JQs = ((String)localObject);
            j.this.JQr = i;
            paramAnonymousd = j.this;
            localObject = j.this.JQs;
            if (!TextUtils.isEmpty(j.this.JQs))
            {
              bool1 = true;
              paramAnonymousd.cu((String)localObject, bool1);
              Log.i("SnsAdQRHelper", "onClickDirect createIntent");
              localObject = new Intent(j.this.mContext, SnsAdProxyUI.class);
              ((Intent)localObject).putExtra("action_type", 1);
              ((Intent)localObject).putExtra("qrcodeStr", j.this.JQs);
              ((Intent)localObject).putExtra("qrcodeType", j.this.JQq);
              ((Intent)localObject).putExtra("qrcodeVer", j.this.JQr);
              paramAnonymousd = j.this.mContext;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousd, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/sns/data/SnsAdQRHelper$6", "afterDecode", "(JLcom/tencent/qbar/WxFileDecodeQueue$ScanCodeForFileResult;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousd.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousd, "com/tencent/mm/plugin/sns/data/SnsAdQRHelper$6", "afterDecode", "(JLcom/tencent/qbar/WxFileDecodeQueue$ScanCodeForFileResult;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousd = j.this;
              localObject = j.this.JQs;
              if (TextUtils.isEmpty(j.this.JQs)) {
                break label512;
              }
              bool1 = bool2;
              label474:
              paramAnonymousd.cv((String)localObject, bool1);
            }
          }
        }
        for (;;)
        {
          j.this.a(params);
          j.this.fNl();
          AppMethodBeat.o(195370);
          return;
          bool1 = false;
          break;
          label512:
          bool1 = false;
          break label474;
          Log.e("SnsAdQRHelper", "afterDecode, results is empty");
          j.this.cu("", false);
        }
      }
    });
    AppMethodBeat.o(228510);
    return true;
  }
  
  public final boolean cp(int paramInt, String paramString)
  {
    AppMethodBeat.i(228518);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(228518);
      return false;
    }
    if (k.bY(paramInt, paramString))
    {
      this.JQt = 2;
      AppMethodBeat.o(228518);
      return true;
    }
    if (k.bZ(paramInt, paramString))
    {
      this.JQt = 3;
      AppMethodBeat.o(228518);
      return true;
    }
    if (k.ca(paramInt, paramString))
    {
      this.JQt = 4;
      AppMethodBeat.o(228518);
      return true;
    }
    if (k.cb(paramInt, paramString))
    {
      this.JQt = 5;
      AppMethodBeat.o(228518);
      return true;
    }
    if (k.cc(paramInt, paramString))
    {
      this.JQt = 1;
      AppMethodBeat.o(228518);
      return true;
    }
    if (k.cd(paramInt, paramString))
    {
      this.JQt = 6;
      AppMethodBeat.o(228518);
      return true;
    }
    AppMethodBeat.o(228518);
    return false;
  }
  
  public final void cu(String paramString, boolean paramBoolean)
  {
    int i = 2;
    AppMethodBeat.i(176235);
    if (this.mScene == 1) {}
    for (;;)
    {
      aYQ(h(i, paramString, paramBoolean).toString());
      m.ks("17539", i(i, paramString, paramBoolean));
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
  
  public final void cv(String paramString, boolean paramBoolean)
  {
    int i = 3;
    AppMethodBeat.i(228524);
    if (this.mScene == 1) {}
    for (;;)
    {
      aYQ(h(i, paramString, paramBoolean).toString());
      m.ks("17539", i(i, paramString, paramBoolean));
      AppMethodBeat.o(228524);
      return;
      if (this.mScene == 2) {
        i = 7;
      } else if (this.mScene == 3) {
        i = 9;
      } else {
        i = 0;
      }
    }
  }
  
  public final void fNl()
  {
    this.JQs = "";
    this.JQq = -1;
    this.JQu = "";
    this.oxn = "";
    this.JQr = 0;
    this.JQt = 0;
  }
  
  public final boolean kr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(179078);
    this.JQu = paramString1;
    this.oxn = paramString2;
    Log.i("SnsAdQRHelper", "onLongClick, filePath=" + this.JQu);
    if (TextUtils.isEmpty(this.JQu))
    {
      fNl();
      AppMethodBeat.o(179078);
      return false;
    }
    long l = System.currentTimeMillis();
    com.tencent.qbar.e.inE().a(this.mContext, l, this.JQu, new com.tencent.qbar.e.b()
    {
      public final void a(long paramAnonymousLong, com.tencent.qbar.e.d paramAnonymousd)
      {
        AppMethodBeat.i(226325);
        Object localObject;
        if (paramAnonymousd != null)
        {
          localObject = paramAnonymousd.IMj;
          if (paramAnonymousd == null) {
            break label208;
          }
          paramAnonymousd = paramAnonymousd.ZmS;
        }
        for (;;)
        {
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            int k = com.tencent.mm.pluginsdk.e.d.boV(((a.a)((List)localObject).get(0)).typeName);
            localObject = ((a.a)((List)localObject).get(0)).data;
            int j = -1;
            int i = j;
            if (paramAnonymousd != null)
            {
              i = j;
              if (!paramAnonymousd.isEmpty()) {
                i = ((WxQbarNative.QBarReportMsg)paramAnonymousd.get(0)).qrcodeVersion;
              }
            }
            Log.i("SnsAdQRHelper", "QRCodeStr=" + (String)localObject + ", QRCodeType=" + k + ", QRCodeVer=" + i);
            if (!j.this.cp(k, (String)localObject))
            {
              Log.e("SnsAdQRHelper", "isValidQRCode=false");
              j.this.cu(Util.nullAsNil((String)localObject), false);
              j.this.fNl();
              AppMethodBeat.o(226325);
              return;
              localObject = null;
              break;
              label208:
              paramAnonymousd = null;
              continue;
            }
            j.this.JQq = k;
            j.this.JQs = ((String)localObject);
            j.this.JQr = i;
            paramAnonymousd = j.this;
            localObject = j.this.JQs;
            if (!TextUtils.isEmpty(j.this.JQs)) {}
            for (boolean bool = true;; bool = false)
            {
              paramAnonymousd.cu((String)localObject, bool);
              AdLandingPagesProxy.getInstance().fetchQRCodeInfo(j.this.JQq, j.this.JQs, new AdLandingPagesProxy.e()
              {
                public final void aH(Object paramAnonymous2Object) {}
                
                public final void i(final int paramAnonymous2Int1, int paramAnonymous2Int2, final Object paramAnonymous2Object)
                {
                  AppMethodBeat.i(176230);
                  StringBuilder localStringBuilder = new StringBuilder("fetchQRCodeInfo, errType=").append(paramAnonymous2Int1).append(", data==null?");
                  if (paramAnonymous2Object == null) {}
                  for (boolean bool = true;; bool = false)
                  {
                    Log.i("SnsAdQRHelper", bool);
                    if (TextUtils.isEmpty(j.this.JQs)) {
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
                          j.this.JQp.r(paramAnonymous2Int1, arrayOfByte);
                          j.this.rZT.eik();
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
                  j.this.rZT.eik();
                  AppMethodBeat.o(176231);
                }
              });
              AppMethodBeat.o(226325);
              return;
            }
          }
        }
        Log.e("SnsAdQRHelper", "afterDecode, results is empty");
        j.this.cu("", false);
        j.this.fNl();
        AppMethodBeat.o(226325);
      }
    });
    AppMethodBeat.o(179078);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.j
 * JD-Core Version:    0.7.0.1
 */