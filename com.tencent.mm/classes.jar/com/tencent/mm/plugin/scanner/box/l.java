package com.tencent.mm.plugin.scanner.box;

import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.protocal.protobuf.rx;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxManager;", "", "()V", "KEY_DETECT_SESSION", "", "KEY_ENABLE_CANCEL_OUTSIDE", "KEY_ENABLE_DIALOG_SCROLL", "KEY_ENABLE_FULL_SCREEN", "KEY_ENABLE_SCROLL_RIGHT_CLOSE", "KEY_ENTER_SESSION", "KEY_FIXED_DIALOG_HEIGHT", "KEY_FIXED_DIALOG_HEIGHT_RATE", "KEY_REQ_KEY", "KEY_SCAN_SESSION", "KEY_SCAN_SOURCE", "KEY_SCAN_TAB_MERGE", "KEY_SESSION_ID", "KEY_SHOW_AFTER_WEBVIEW_READY", "KEY_TAB_SESSION", "KEY_TEMPLATE_TYPE", "TAG", "createContext", "Lcom/tencent/mm/protocal/protobuf/BoxHomeContext;", "data", "Landroid/os/Bundle;", "createDialogView", "Lcom/tencent/mm/plugin/scanner/box/BaseBoxDialogView;", "context", "Landroid/content/Context;", "templateType", "", "doShowBoxDialog", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialog;", "listener", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialogViewListener;", "genBoxUrl", "params", "Ljava/util/HashMap;", "getTextScaleSize", "", "putCommonUrlParams", "", "showBoxDialog", "boxDialogOnShowListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogOnShowListener;", "ScanTabType", "TemplateType", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  public static final l ONH;
  
  static
  {
    AppMethodBeat.i(52133);
    ONH = new l();
    AppMethodBeat.o(52133);
  }
  
  public static final i a(Context paramContext, Bundle paramBundle, g paramg)
  {
    AppMethodBeat.i(313753);
    s.u(paramContext, "context");
    s.u(paramBundle, "data");
    Object localObject = paramBundle.getString("scan_session");
    HashMap localHashMap;
    Map localMap;
    label196:
    int i;
    label280:
    float f;
    boolean bool1;
    boolean bool2;
    boolean bool3;
    boolean bool4;
    boolean bool5;
    if (localObject == null)
    {
      localObject = String.valueOf(System.currentTimeMillis());
      s.s(localObject, "data.getString(KEY_SCAN_…ntTimeMillis().toString()");
      paramg = new k((String)localObject, paramg);
      Log.v("MicroMsg.ScanBoxDialogViewListenerImpl", "alvinluo onShowStart %s", new Object[] { paramg.hQR });
      paramg.ONv = System.currentTimeMillis();
      paramg.ONB = new k.a(paramg);
      j localj = (j)paramg;
      int j = paramBundle.getInt("template_type", 0);
      int k = paramBundle.getInt("template_type", 0);
      rx localrx = new rx();
      localHashMap = new HashMap();
      localMap = (Map)localHashMap;
      localObject = paramBundle.getString("req_key");
      paramg = (g)localObject;
      if (localObject == null) {
        paramg = "";
      }
      localMap.put("req_key", paramg);
      switch (k)
      {
      default: 
        Log.i("MicroMsg.ScanBoxManager", "alvinluo showBoxDialog templateType: %s, reqKey: %s, session_id: %s", new Object[] { Integer.valueOf(k), localHashMap.get("req_key"), localHashMap.get("session_id") });
        localrx.YWL = UUID.randomUUID().toString();
        s.u(localHashMap, "params");
        paramg = "";
        switch (k)
        {
        default: 
          localObject = new StringBuffer();
          ((StringBuffer)localObject).append("file://");
          ((StringBuffer)localObject).append(paramg);
          ((StringBuffer)localObject).append("?");
          ((StringBuffer)localObject).append(aj.toUrlParams((Map)localHashMap));
          localrx.Url = ((StringBuffer)localObject).toString();
          i = paramBundle.getInt("fixed_dialog_height", 0);
          f = paramBundle.getFloat("fixed_dialog_height_rate", -1.0F);
          bool1 = paramBundle.getBoolean("enable_dialog_scroll", true);
          bool2 = paramBundle.getBoolean("enable_cancel_outside", true);
          bool3 = paramBundle.getBoolean("show_after_webview_ready", false);
          bool4 = paramBundle.getBoolean("enable_full_screen", true);
          bool5 = paramBundle.getBoolean("enable_scroll_right_close", false);
          Log.i("MicroMsg.ScanBoxManager", "alvinluo showBoxDialog fixedDialogHeight: %d, fixedDialogHeightRate: %s, enableDialogScroll: %b", new Object[] { Integer.valueOf(i), Float.valueOf(f), Boolean.valueOf(bool1) });
          switch (j)
          {
          default: 
            Log.e("MicroMsg.ScanBoxManager", "alvinluo createDialogView templateType : %s not support", new Object[] { Integer.valueOf(j) });
            paramg = null;
            label478:
            paramContext = new i(paramContext, localrx, paramg, localj);
            if (i > 0)
            {
              paramContext.gPR();
              paramContext.pvp = i;
              paramg = paramContext.ONn;
              if (paramg != null) {
                paramg.setFixDialogHeight(i);
              }
            }
            break;
          }
          break;
        }
        break;
      }
    }
    for (;;)
    {
      paramContext.ONq = bool1;
      paramg = paramContext.ONn;
      if (paramg != null) {
        paramg.setEnableDialogScroll(bool1);
      }
      paramContext.ONr = bool2;
      paramg = paramContext.ONn;
      if (paramg != null) {
        paramg.setCanceledOnTouchOutside(bool2);
      }
      paramContext.GXO = bool3;
      paramContext.OMy = bool4;
      paramContext.pvC = bool5;
      paramg = paramContext.ONn;
      if (paramg != null) {
        paramg.setEnableScrollRightClose(bool5);
      }
      paramContext.show();
      s.u(paramBundle, "data");
      if (paramContext.ONl != null) {
        q.aQ(paramBundle);
      }
      paramBundle = paramContext.getWindow();
      if (paramBundle != null) {
        paramBundle.setLayout(-1, -1);
      }
      AppMethodBeat.o(313753);
      return paramContext;
      break;
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
      localMap = (Map)localHashMap;
      localObject = paramBundle.getString("scanTabMerge");
      paramg = (g)localObject;
      if (localObject == null) {
        paramg = "0";
      }
      localMap.put("scanTabMerge", paramg);
      paramg = paramBundle.getString("detect_session");
      if (paramg != null) {
        if (((CharSequence)paramg).length() <= 0) {
          break label903;
        }
      }
      label903:
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          ((Map)localHashMap).put("detect_session", paramg);
        }
        Log.d("MicroMsg.ScanBoxManager", "alvinluo showBoxDialog from scan goods, enterSession: %s, tabSession: %s, scanSession: %s, detectSession: %s", new Object[] { localHashMap.get("enter_session"), localHashMap.get("tab_session"), localHashMap.get("scan_session"), localHashMap.get("detect_session") });
        break;
      }
      ((Map)localHashMap).put("session_id", String.valueOf(paramBundle.getLong("session_id", 0L)));
      ((Map)localHashMap).put("scene", String.valueOf(paramBundle.getInt("scene", 0)));
      break label196;
      paramg = o.ONO;
      paramg = o.gPV();
      b(localHashMap, 4);
      break label280;
      paramg = o.ONO;
      paramg = o.gPW();
      b(localHashMap, 8);
      break label280;
      paramg = (BaseBoxDialogView)new ScanGoodsDialogView(paramContext);
      break label478;
      paramg = (BaseBoxDialogView)new ScanImageOCRDialogView(paramContext);
      break label478;
      if (f > 0.0F)
      {
        paramContext.gPR();
        paramContext.pvr = f;
        paramg = paramContext.ONn;
        if (paramg != null) {
          paramg.setFixDialogHeightRate(f);
        }
      }
    }
  }
  
  private static void b(HashMap<String, String> paramHashMap, int paramInt)
  {
    AppMethodBeat.i(313763);
    ((Map)paramHashMap).put("lang", LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
    ((Map)paramHashMap).put("platform", "android");
    ((Map)paramHashMap).put("version", String.valueOf(aj.asY(paramInt)));
    ((Map)paramHashMap).put("netType", aj.gtA());
    ((Map)paramHashMap).put("isClientLoading", "1");
    ((Map)paramHashMap).put("wechatVersion", BuildInfo.CLIENT_VERSION);
    ((Map)paramHashMap).put("fontRatio", String.valueOf(gPS()));
    AppMethodBeat.o(313763);
  }
  
  private static float gPS()
  {
    float f1 = 1.0F;
    int j = 1;
    AppMethodBeat.i(313768);
    float f2 = a.getScaleSize(MMApplicationContext.getContext());
    int i;
    if (f2 == 1.0F)
    {
      i = 1;
      if (i != 0) {
        break label175;
      }
      if (f2 != 0.8F) {
        break label140;
      }
      i = 1;
      label39:
      if (i != 0) {
        break label175;
      }
      if (f2 != 1.1F) {
        break label145;
      }
      i = 1;
      label53:
      if (i != 0) {
        break label175;
      }
      if (f2 != 1.12F) {
        break label150;
      }
      i = 1;
      label67:
      if (i != 0) {
        break label175;
      }
      if (f2 != 1.125F) {
        break label155;
      }
      i = 1;
      label81:
      if (i != 0) {
        break label175;
      }
      if (f2 != 1.4F) {
        break label160;
      }
      i = 1;
      label95:
      if (i != 0) {
        break label175;
      }
      if (f2 != 1.55F) {
        break label165;
      }
      i = 1;
      label109:
      if (i != 0) {
        break label175;
      }
      if (f2 != 1.65F) {
        break label170;
      }
      i = j;
      label123:
      if (i != 0) {
        break label175;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(313768);
      return f1;
      i = 0;
      break;
      label140:
      i = 0;
      break label39;
      label145:
      i = 0;
      break label53;
      label150:
      i = 0;
      break label67;
      label155:
      i = 0;
      break label81;
      label160:
      i = 0;
      break label95;
      label165:
      i = 0;
      break label109;
      label170:
      i = 0;
      break label123;
      label175:
      f1 = f2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.l
 * JD-Core Version:    0.7.0.1
 */