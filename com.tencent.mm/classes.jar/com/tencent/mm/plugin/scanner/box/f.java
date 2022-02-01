package com.tencent.mm.plugin.scanner.box;

import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.oe;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxManager;", "", "()V", "KEY_REQ_KEY", "", "KEY_SCAN_SESSION", "KEY_TAB_SESSION", "TAG", "showBoxDialog", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialog;", "context", "Landroid/content/Context;", "data", "Landroid/os/Bundle;", "scanBoxDialogEventListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogEventListener;", "plugin-scan_release"})
public final class f
{
  public static final f vNa;
  
  static
  {
    AppMethodBeat.i(52133);
    vNa = new f();
    AppMethodBeat.o(52133);
  }
  
  public static final e a(Context paramContext, Bundle paramBundle, b paramb)
  {
    AppMethodBeat.i(52132);
    k.h(paramContext, "context");
    k.h(paramBundle, "data");
    oe localoe = new oe();
    HashMap localHashMap = new HashMap();
    String str1 = paramBundle.getString("req_key");
    String str2 = paramBundle.getString("tab_session");
    String str3 = paramBundle.getString("scan_session");
    Map localMap = (Map)localHashMap;
    if (str1 == null) {}
    for (paramBundle = "";; paramBundle = str1)
    {
      localMap.put("req_key", paramBundle);
      localMap = (Map)localHashMap;
      if (str2 == null) {}
      for (paramBundle = "";; paramBundle = str2)
      {
        localMap.put("tab_session", paramBundle);
        localMap = (Map)localHashMap;
        if (str3 == null) {}
        for (paramBundle = "";; paramBundle = str3)
        {
          localMap.put("scan_session", paramBundle);
          ad.i("MicroMsg.ScanBoxManager", "alvinluo showBoxDialog reqKey: %s, tabSession: %s, scanSession: %s", new Object[] { str1, str2, str3 });
          paramBundle = g.vNb;
          localoe.Url = com.tencent.mm.plugin.box.c.b.a(localHashMap, g.dlf());
          localoe.CLJ = UUID.randomUUID().toString();
          paramContext = new e(paramContext, localoe);
          paramContext.vMU = paramb;
          paramContext.show();
          paramBundle = paramContext.getWindow();
          if (paramBundle != null) {
            paramBundle.setLayout(-1, -1);
          }
          AppMethodBeat.o(52132);
          return paramContext;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.f
 * JD-Core Version:    0.7.0.1
 */