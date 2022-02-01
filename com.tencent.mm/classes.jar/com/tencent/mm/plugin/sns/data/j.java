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
import com.tencent.mm.pluginsdk.e.e;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.a.f.b;
import com.tencent.mm.ui.widget.bottomsheet.ViewTitleWithAnimation;
import com.tencent.qbar.WxQbarNative.QBarReportMsg;
import com.tencent.qbar.a.a;
import com.tencent.qbar.e;
import com.tencent.qbar.e.b;
import com.tencent.qbar.e.d;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONObject;

public final class j
{
  ScanCodeSheetItemLogic QmW;
  int QmX;
  int QmY;
  volatile String QmZ;
  private int Qna;
  private String Qnb;
  private ai Qnc;
  private String Qnd;
  private int Qne;
  Bundle Qnf;
  Context mContext;
  private int mScene;
  private String rAM;
  f vlk;
  
  public j(Context paramContext, ai paramai, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(306392);
    this.mContext = paramContext;
    this.Qnc = paramai;
    this.mScene = paramInt;
    this.Qna = 0;
    if (this.QmW == null)
    {
      this.vlk = new f(this.mContext, 1, false);
      this.QmW = new ScanCodeSheetItemLogic(this.mContext);
      this.vlk.sRz = true;
      this.vlk.Vtg = new u.g()
      {
        public final void onCreateMMMenu(s paramAnonymouss)
        {
          AppMethodBeat.i(176226);
          try
          {
            paramAnonymouss = j.this;
            paramAnonymouss = paramAnonymouss.QmW.a(new j.3(paramAnonymouss), paramAnonymouss.QmX, paramAnonymouss.QmZ, 9);
            if ((paramAnonymouss instanceof ViewTitleWithAnimation)) {
              ((ViewTitleWithAnimation)paramAnonymouss).setTopPaddingVisibility(8);
            }
            j.this.vlk.setFooterView(paramAnonymouss);
            paramAnonymouss = new View(j.this.mContext);
            paramAnonymouss.setMinimumHeight(com.tencent.mm.cd.a.fromDPToPix(j.this.mContext, 2));
            j.this.vlk.af(paramAnonymouss, true);
            AppMethodBeat.o(176226);
            return;
          }
          catch (Exception paramAnonymouss)
          {
            Log.e("SnsAdQRHelper", "onCreateMMMenu exp=" + paramAnonymouss.toString());
            AppMethodBeat.o(176226);
          }
        }
      };
      this.vlk.aeLi = new f.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(176227);
          j.this.QmW.onDismiss();
          j.this.heM();
          AppMethodBeat.o(176227);
        }
      };
    }
    this.Qnf = paramBundle;
    try
    {
      this.Qnd = Util.nullAs(IntentUtil.getString(paramBundle, "qrExtInfo"), "");
      this.Qne = IntentUtil.getInt(paramBundle, "qrIsDirectJump", 0);
      AppMethodBeat.o(306392);
      return;
    }
    finally
    {
      Log.e("SnsAdQRHelper", "there is something wrong in parseExtraParams");
      AppMethodBeat.o(306392);
    }
  }
  
  private void aXc(String paramString)
  {
    AppMethodBeat.i(176236);
    try
    {
      Object localObject = this.Qnc;
      String str1 = ((ai)localObject).getSnsId();
      String str2 = Util.nullAsNil(((ai)localObject).uxInfo);
      String str3 = Util.nullAsNil(((ai)localObject).aid);
      int i = ((ai)localObject).source;
      localObject = URLEncoder.encode(paramString, "UTF-8");
      h.OAn.b(17539, new Object[] { str1, str3, str2, Integer.valueOf(i), localObject });
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
        localJSONObject.put("qrUrl", this.rAM);
        localJSONObject.put("qrResultUrl", paramString);
        localJSONObject.put("qrExtInfo", this.Qnd);
        localJSONObject.put("directJump", this.Qne);
        if (this.Qna != 0) {
          localJSONObject.put("qrResultUrlType", this.Qna);
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
      ai localai = this.Qnc;
      paramString = h(paramInt, paramString, paramBoolean);
      String str1 = Util.nullAsNil(localai.uxInfo);
      String str2 = localai.getSnsId();
      paramInt = localai.source;
      long l = Util.safeParseLong(localai.rzx);
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
  
  public final boolean a(String paramString1, final String paramString2, final a parama)
  {
    AppMethodBeat.i(306423);
    this.Qnb = paramString1;
    this.rAM = paramString2;
    Log.i("SnsAdQRHelper", "onLongClick, filePath=" + this.Qnb);
    if (TextUtils.isEmpty(this.Qnb))
    {
      if (parama != null) {
        parama.a(paramString2, false, "imgPath is empty", this.Qnf);
      }
      heM();
      AppMethodBeat.o(306423);
      return false;
    }
    long l = System.currentTimeMillis();
    e.jWN().a(this.mContext, l, this.Qnb, new e.b()
    {
      public final void a(long paramAnonymousLong, e.d paramAnonymousd)
      {
        AppMethodBeat.i(306421);
        Object localObject;
        if (paramAnonymousd != null)
        {
          localObject = paramAnonymousd.OTq;
          if (paramAnonymousd == null) {
            break label238;
          }
          paramAnonymousd = paramAnonymousd.ahrp;
        }
        for (;;)
        {
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            int k = e.e.boP(((a.a)((List)localObject).get(0)).typeName);
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
            if (!j.this.da(k, (String)localObject))
            {
              Log.e("SnsAdQRHelper", "isValidQRCode=false");
              j.this.cU(Util.nullAsNil((String)localObject), false);
              if (parama != null) {
                parama.a(paramString2, false, "inValid QRCode", j.this.Qnf);
              }
              j.this.heM();
              AppMethodBeat.o(306421);
              return;
              localObject = null;
              break;
              label238:
              paramAnonymousd = null;
              continue;
            }
            j.this.QmX = k;
            j.this.QmZ = ((String)localObject);
            j.this.QmY = i;
            paramAnonymousd = j.this;
            localObject = j.this.QmZ;
            if (!TextUtils.isEmpty(j.this.QmZ)) {}
            for (boolean bool = true;; bool = false)
            {
              paramAnonymousd.cU((String)localObject, bool);
              AdLandingPagesProxy.getInstance().fetchQRCodeInfo(j.this.QmX, j.this.QmZ, new AdLandingPagesProxy.e()
              {
                public final void h(final int paramAnonymous2Int1, int paramAnonymous2Int2, final Object paramAnonymous2Object)
                {
                  AppMethodBeat.i(176230);
                  StringBuilder localStringBuilder = new StringBuilder("fetchQRCodeInfo, errType=").append(paramAnonymous2Int1).append(", data==null?");
                  if (paramAnonymous2Object == null) {}
                  for (boolean bool = true;; bool = false)
                  {
                    Log.i("SnsAdQRHelper", bool);
                    if (TextUtils.isEmpty(j.this.QmZ)) {
                      break label172;
                    }
                    MMHandlerThread.postToMainThread(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(176229);
                        try
                        {
                          byte[] arrayOfByte = (byte[])paramAnonymous2Object;
                          j.this.QmW.s(paramAnonymous2Int1, arrayOfByte);
                          j.this.vlk.dDn();
                          AppMethodBeat.o(176229);
                          return;
                        }
                        finally
                        {
                          Log.e("SnsAdQRHelper", "there is something wrong in AdLandingPagesProxy call back");
                          AppMethodBeat.o(176229);
                        }
                      }
                    });
                    if ((j.4.this.Qnh == null) || (paramAnonymous2Int1 != 0)) {
                      break;
                    }
                    j.4.this.Qnh.a(j.4.this.PUd, true, "", j.this.Qnf);
                    AppMethodBeat.o(176230);
                    return;
                  }
                  j.4.this.Qnh.a(j.4.this.PUd, false, " errType!=MM_OK", j.this.Qnf);
                  AppMethodBeat.o(176230);
                  return;
                  label172:
                  Log.e("SnsAdQRHelper", "the qr code string is empty in AdLandingPagesProxy call back");
                  if (j.4.this.Qnh != null) {
                    j.4.this.Qnh.a(j.4.this.PUd, false, "fetchQRCodeInfo empty", j.this.Qnf);
                  }
                  AppMethodBeat.o(176230);
                }
                
                public final void onCallback(Object paramAnonymous2Object) {}
              });
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(176231);
                  j.this.vlk.dDn();
                  AppMethodBeat.o(176231);
                }
              });
              AppMethodBeat.o(306421);
              return;
            }
          }
        }
        Log.e("SnsAdQRHelper", "afterDecode, results is empty");
        j.this.cU("", false);
        if (parama != null) {
          parama.a(paramString2, false, "QR result is empty", j.this.Qnf);
        }
        j.this.heM();
        AppMethodBeat.o(306421);
      }
    });
    AppMethodBeat.o(306423);
    return true;
  }
  
  public final boolean b(String paramString1, final String paramString2, final a parama)
  {
    AppMethodBeat.i(306434);
    this.Qnb = paramString1;
    this.rAM = paramString2;
    Log.i("SnsAdQRHelper", "onClickDirect, filePath=" + this.Qnb);
    if (TextUtils.isEmpty(this.Qnb))
    {
      if (parama != null) {
        parama.a(paramString2, false, "imgPath is empty", this.Qnf);
      }
      heM();
      AppMethodBeat.o(306434);
      return false;
    }
    long l = System.currentTimeMillis();
    e.jWN().a(this.mContext, l, this.Qnb, new e.b()
    {
      public final void a(long paramAnonymousLong, e.d paramAnonymousd)
      {
        boolean bool2 = false;
        AppMethodBeat.i(306429);
        Object localObject;
        if (paramAnonymousd != null)
        {
          localObject = paramAnonymousd.OTq;
          if (paramAnonymousd == null) {
            break label241;
          }
          paramAnonymousd = paramAnonymousd.ahrp;
        }
        label241:
        boolean bool1;
        for (;;)
        {
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            int k = e.e.boP(((a.a)((List)localObject).get(0)).typeName);
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
            if (!j.this.da(k, (String)localObject))
            {
              Log.e("SnsAdQRHelper", "isValidQRCode=false");
              j.this.cU(Util.nullAsNil((String)localObject), false);
              if (parama != null) {
                parama.a(paramString2, false, "inValid QRCode", j.this.Qnf);
              }
              j.this.heM();
              AppMethodBeat.o(306429);
              return;
              localObject = null;
              break;
              paramAnonymousd = null;
              continue;
            }
            j.this.QmX = k;
            j.this.QmZ = ((String)localObject);
            j.this.QmY = i;
            paramAnonymousd = j.this;
            localObject = j.this.QmZ;
            if (!TextUtils.isEmpty(j.this.QmZ))
            {
              bool1 = true;
              paramAnonymousd.cU((String)localObject, bool1);
              Log.i("SnsAdQRHelper", "onClickDirect createIntent");
              localObject = new Intent(j.this.mContext, SnsAdProxyUI.class);
              ((Intent)localObject).putExtra("action_type", 1);
              ((Intent)localObject).putExtra("qrcodeStr", j.this.QmZ);
              ((Intent)localObject).putExtra("qrcodeType", j.this.QmX);
              ((Intent)localObject).putExtra("qrcodeVer", j.this.QmY);
              paramAnonymousd = j.this.mContext;
              localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousd, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/sns/data/SnsAdQRHelper$5", "afterDecode", "(JLcom/tencent/qbar/WxFileDecodeQueue$ScanCodeForFileResult;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousd.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousd, "com/tencent/mm/plugin/sns/data/SnsAdQRHelper$5", "afterDecode", "(JLcom/tencent/qbar/WxFileDecodeQueue$ScanCodeForFileResult;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousd = j.this;
              localObject = j.this.QmZ;
              bool1 = bool2;
              if (!TextUtils.isEmpty(j.this.QmZ)) {
                bool1 = true;
              }
              paramAnonymousd.cV((String)localObject, bool1);
              if (parama != null) {
                parama.a(paramString2, true, "", j.this.Qnf);
              }
            }
          }
        }
        for (;;)
        {
          j.this.heM();
          AppMethodBeat.o(306429);
          return;
          bool1 = false;
          break;
          Log.e("SnsAdQRHelper", "afterDecode, results is empty");
          j.this.cU("", false);
          if (parama != null) {
            parama.a(paramString2, false, "QR result is empty", j.this.Qnf);
          }
        }
      }
    });
    AppMethodBeat.o(306434);
    return true;
  }
  
  public final void cU(String paramString, boolean paramBoolean)
  {
    int i = 2;
    AppMethodBeat.i(176235);
    if (this.mScene == 1) {}
    for (;;)
    {
      aXc(h(i, paramString, paramBoolean).toString());
      m.lU("17539", i(i, paramString, paramBoolean));
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
  
  public final void cV(String paramString, boolean paramBoolean)
  {
    int i = 3;
    AppMethodBeat.i(306463);
    if (this.mScene == 1) {}
    for (;;)
    {
      aXc(h(i, paramString, paramBoolean).toString());
      m.lU("17539", i(i, paramString, paramBoolean));
      AppMethodBeat.o(306463);
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
  
  public final boolean da(int paramInt, String paramString)
  {
    AppMethodBeat.i(306445);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(306445);
      return false;
    }
    if (k.cK(paramInt, paramString))
    {
      this.Qna = 2;
      AppMethodBeat.o(306445);
      return true;
    }
    if (k.cL(paramInt, paramString))
    {
      this.Qna = 3;
      AppMethodBeat.o(306445);
      return true;
    }
    if (k.cM(paramInt, paramString))
    {
      this.Qna = 4;
      AppMethodBeat.o(306445);
      return true;
    }
    if (k.cN(paramInt, paramString))
    {
      this.Qna = 5;
      AppMethodBeat.o(306445);
      return true;
    }
    if (k.cO(paramInt, paramString))
    {
      this.Qna = 1;
      AppMethodBeat.o(306445);
      return true;
    }
    if (k.cP(paramInt, paramString))
    {
      this.Qna = 6;
      AppMethodBeat.o(306445);
      return true;
    }
    AppMethodBeat.o(306445);
    return false;
  }
  
  public final void heM()
  {
    this.QmZ = "";
    this.QmX = -1;
    this.Qnb = "";
    this.rAM = "";
    this.QmY = 0;
    this.Qna = 0;
    this.Qnf = null;
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString1, boolean paramBoolean, String paramString2, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.j
 * JD-Core Version:    0.7.0.1
 */