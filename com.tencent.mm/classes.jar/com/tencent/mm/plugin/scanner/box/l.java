package com.tencent.mm.plugin.scanner.box;

import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.qt;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxManager;", "", "()V", "KEY_ENABLE_CANCEL_OUTSIDE", "", "KEY_ENABLE_DIALOG_SCROLL", "KEY_ENABLE_FULL_SCREEN", "KEY_ENABLE_SCROLL_RIGHT_CLOSE", "KEY_ENTER_SESSION", "KEY_FIXED_DIALOG_HEIGHT", "KEY_FIXED_DIALOG_HEIGHT_RATE", "KEY_REQ_KEY", "KEY_SCAN_SESSION", "KEY_SCAN_SOURCE", "KEY_SESSION_ID", "KEY_SHOW_AFTER_WEBVIEW_READY", "KEY_TAB_SESSION", "KEY_TEMPLATE_TYPE", "TAG", "createContext", "Lcom/tencent/mm/protocal/protobuf/BoxHomeContext;", "data", "Landroid/os/Bundle;", "createDialogView", "Lcom/tencent/mm/plugin/scanner/box/BaseBoxDialogView;", "context", "Landroid/content/Context;", "templateType", "", "doShowBoxDialog", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialog;", "listener", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialogViewListener;", "genBoxUrl", "params", "Ljava/util/HashMap;", "getTextScaleSize", "", "putCommonUrlParams", "", "showBoxDialog", "boxDialogOnShowListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogOnShowListener;", "TemplateType", "plugin-scan_release"})
public final class l
{
  public static final l CDd;
  
  static
  {
    AppMethodBeat.i(52133);
    CDd = new l();
    AppMethodBeat.o(52133);
  }
  
  public static final i a(Context paramContext, Bundle paramBundle, g paramg)
  {
    AppMethodBeat.i(240285);
    p.h(paramContext, "context");
    p.h(paramBundle, "data");
    Object localObject = paramBundle.getString("scan_session");
    if (localObject == null) {
      localObject = String.valueOf(System.currentTimeMillis());
    }
    for (;;)
    {
      p.g(localObject, "data.getString(KEY_SCAN_…ntTimeMillis().toString()");
      paramg = new k((String)localObject, paramg);
      Log.v("MicroMsg.ScanBoxDialogViewListenerImpl", "alvinluo onShowStart %s", new Object[] { paramg.dRM });
      paramg.CCP = System.currentTimeMillis();
      paramg.CCV = new k.a(paramg);
      j localj = (j)paramg;
      int i = paramBundle.getInt("template_type", 0);
      int j = paramBundle.getInt("template_type", 0);
      qt localqt = new qt();
      HashMap localHashMap = new HashMap();
      Map localMap = (Map)localHashMap;
      localObject = paramBundle.getString("req_key");
      paramg = (g)localObject;
      if (localObject == null) {
        paramg = "";
      }
      localMap.put("req_key", paramg);
      label416:
      float f;
      boolean bool1;
      boolean bool2;
      boolean bool3;
      boolean bool4;
      boolean bool5;
      if (j == 1)
      {
        localMap = (Map)localHashMap;
        localObject = paramBundle.getString("enter_session");
        paramg = (g)localObject;
        if (localObject == null) {
          paramg = "";
        }
        localMap.put("enter_session", paramg);
        localMap = (Map)localHashMap;
        localObject = paramBundle.getString("tab_session");
        paramg = (g)localObject;
        if (localObject == null) {
          paramg = "";
        }
        localMap.put("tab_session", paramg);
        localMap = (Map)localHashMap;
        localObject = paramBundle.getString("scan_session");
        paramg = (g)localObject;
        if (localObject == null) {
          paramg = "";
        }
        localMap.put("scan_session", paramg);
        Log.d("MicroMsg.ScanBoxManager", "alvinluo showBoxDialog from scan goods, enterSession: %s, tabSession: %s, scanSession: %s", new Object[] { localHashMap.get("enter_session"), localHashMap.get("tab_session"), localHashMap.get("scan_session") });
        Log.i("MicroMsg.ScanBoxManager", "alvinluo showBoxDialog templateType: %s, reqKey: %s, session_id: %s", new Object[] { Integer.valueOf(j), localHashMap.get("req_key"), localHashMap.get("session_id") });
        localqt.KXB = UUID.randomUUID().toString();
        p.h(localHashMap, "params");
        paramg = "";
        switch (j)
        {
        default: 
          localObject = new StringBuffer();
          ((StringBuffer)localObject).append("file://");
          ((StringBuffer)localObject).append(paramg);
          ((StringBuffer)localObject).append("?");
          ((StringBuffer)localObject).append(ai.toUrlParams((Map)localHashMap));
          localqt.Url = ((StringBuffer)localObject).toString();
          j = paramBundle.getInt("fixed_dialog_height", 0);
          f = paramBundle.getFloat("fixed_dialog_height_rate", -1.0F);
          bool1 = paramBundle.getBoolean("enable_dialog_scroll", true);
          bool2 = paramBundle.getBoolean("enable_cancel_outside", true);
          bool3 = paramBundle.getBoolean("show_after_webview_ready", false);
          bool4 = paramBundle.getBoolean("enable_full_screen", true);
          bool5 = paramBundle.getBoolean("enable_scroll_right_close", false);
          Log.i("MicroMsg.ScanBoxManager", "alvinluo showBoxDialog fixedDialogHeight: %d, fixedDialogHeightRate: %s, enableDialogScroll: %b", new Object[] { Integer.valueOf(j), Float.valueOf(f), Boolean.valueOf(bool1) });
          if (i == 1)
          {
            paramg = (BaseBoxDialogView)new ScanGoodsDialogView(paramContext);
            label587:
            paramContext = new i(paramContext, localqt, paramg, localj);
            if (j <= 0) {
              break label887;
            }
            paramContext.ePo();
            paramContext.CBH = j;
            paramg = paramContext.CCE;
            if (paramg != null) {
              paramg.setFixDialogHeight(j);
            }
          }
          break;
        }
      }
      for (;;)
      {
        paramContext.CCH = bool1;
        paramg = paramContext.CCE;
        if (paramg != null) {
          paramg.setEnableDialogScroll(bool1);
        }
        paramContext.CCI = bool2;
        paramg = paramContext.CCE;
        if (paramg != null) {
          paramg.setCanceledOnTouchOutside(bool2);
        }
        paramContext.CCJ = bool3;
        paramContext.CAK = bool4;
        paramContext.CAL = bool5;
        paramg = paramContext.CCE;
        if (paramg != null) {
          paramg.setEnableScrollRightClose(bool5);
        }
        paramContext.show();
        p.h(paramBundle, "data");
        if (paramContext.CCC != null) {
          q.av(paramBundle);
        }
        paramBundle = paramContext.getWindow();
        if (paramBundle != null) {
          paramBundle.setLayout(-1, -1);
        }
        AppMethodBeat.o(240285);
        return paramContext;
        if (j != 2) {
          break;
        }
        ((Map)localHashMap).put("session_id", String.valueOf(paramBundle.getLong("session_id", 0L)));
        ((Map)localHashMap).put("scene", String.valueOf(paramBundle.getInt("scene", 0)));
        break;
        paramg = o.CDl;
        paramg = o.ePx();
        b(localHashMap, 4);
        break label416;
        paramg = o.CDl;
        paramg = o.ePy();
        b(localHashMap, 8);
        break label416;
        if (i == 2)
        {
          paramg = (BaseBoxDialogView)new ScanImageOCRDialogView(paramContext);
          break label587;
        }
        Log.e("MicroMsg.ScanBoxManager", "alvinluo createDialogView templateType : %s not support", new Object[] { Integer.valueOf(i) });
        paramg = null;
        break label587;
        label887:
        if (f > 0.0F)
        {
          paramContext.ePo();
          paramContext.CBJ = f;
          paramg = paramContext.CCE;
          if (paramg != null) {
            paramg.setFixDialogHeightRate(f);
          }
        }
      }
    }
  }
  
  private static void b(HashMap<String, String> paramHashMap, int paramInt)
  {
    AppMethodBeat.i(240286);
    ((Map)paramHashMap).put("lang", LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
    ((Map)paramHashMap).put("platform", "android");
    ((Map)paramHashMap).put("version", String.valueOf(ai.aft(paramInt)));
    ((Map)paramHashMap).put("netType", ai.ait());
    ((Map)paramHashMap).put("isClientLoading", "1");
    ((Map)paramHashMap).put("wechatVersion", BuildInfo.CLIENT_VERSION);
    ((Map)paramHashMap).put("fontRatio", String.valueOf(ePv()));
    AppMethodBeat.o(240286);
  }
  
  private static float ePv()
  {
    float f1 = 1.0F;
    AppMethodBeat.i(240287);
    float f2 = a.ez(MMApplicationContext.getContext());
    if ((f2 != 1.0F) && (f2 != 0.8F) && (f2 != 1.1F) && (f2 != 1.12F) && (f2 != 1.125F) && (f2 != 1.4F) && (f2 != 1.55F) && (f2 != 1.65F)) {}
    for (;;)
    {
      AppMethodBeat.o(240287);
      return f1;
      f1 = f2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.l
 * JD-Core Version:    0.7.0.1
 */