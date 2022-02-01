package com.tencent.mm.plugin.scanner.box;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ol;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxManager;", "", "()V", "KEY_ENTER_SESSION", "", "KEY_FIXED_WEBVIEW_HEIGHT", "KEY_REQ_KEY", "KEY_SCAN_SESSION", "KEY_TAB_SESSION", "TAG", "showBoxDialog", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialog;", "context", "Landroid/content/Context;", "data", "Landroid/os/Bundle;", "scanBoxDialogEventListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogEventListener;", "plugin-scan_release"})
public final class f
{
  public static final f wXr;
  
  static
  {
    AppMethodBeat.i(52133);
    wXr = new f();
    AppMethodBeat.o(52133);
  }
  
  public static final e a(Context paramContext, Bundle paramBundle, b paramb)
  {
    AppMethodBeat.i(52132);
    k.h(paramContext, "context");
    k.h(paramBundle, "data");
    ol localol = new ol();
    HashMap localHashMap = new HashMap();
    String str1 = paramBundle.getString("req_key");
    String str2 = paramBundle.getString("enter_session");
    String str3 = paramBundle.getString("tab_session");
    String str4 = paramBundle.getString("scan_session");
    int i = paramBundle.getInt("fixed_webview_height", 0);
    Map localMap = (Map)localHashMap;
    if (str1 == null) {}
    for (paramBundle = "";; paramBundle = str1)
    {
      localMap.put("req_key", paramBundle);
      localMap = (Map)localHashMap;
      if (str2 == null) {}
      for (paramBundle = "";; paramBundle = str2)
      {
        localMap.put("enter_session", paramBundle);
        localMap = (Map)localHashMap;
        if (str3 == null) {}
        for (paramBundle = "";; paramBundle = str3)
        {
          localMap.put("tab_session", paramBundle);
          localMap = (Map)localHashMap;
          if (str4 == null) {}
          for (paramBundle = "";; paramBundle = str4)
          {
            localMap.put("scan_session", paramBundle);
            ac.i("MicroMsg.ScanBoxManager", "alvinluo showBoxDialog reqKey: %s, enterSession: %s, tabSession: %s, scanSession: %s, fixWebViewHeight: %d", new Object[] { str1, str2, str3, str4, Integer.valueOf(i) });
            paramBundle = g.wXt;
            localol.Url = com.tencent.mm.plugin.box.c.b.a(localHashMap, g.dzh());
            localol.Eem = UUID.randomUUID().toString();
            paramContext = new e(paramContext, localol);
            if (i > 0)
            {
              paramContext.wWJ = true;
              paramBundle = paramContext.wXm;
              if (paramBundle != null) {
                paramBundle.setIsFixWebViewHeight(true);
              }
              paramContext.wWK = i;
              paramBundle = paramContext.wXm;
              if (paramBundle != null) {
                paramBundle.setFixWebViewHeight(i);
              }
            }
            paramContext.wXl = ((b)new a(paramb));
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/scanner/box/ScanBoxManager$showBoxDialog$1", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogEventListener;", "onCancel", "", "dialog", "Landroid/content/DialogInterface;", "onDismiss", "exitType", "", "onShow", "plugin-scan_release"})
  public static final class a
    implements b
  {
    a(b paramb) {}
    
    public final void a(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(199570);
      b localb = this.wXs;
      if (localb != null)
      {
        localb.a(paramDialogInterface, paramInt);
        AppMethodBeat.o(199570);
        return;
      }
      AppMethodBeat.o(199570);
    }
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(199571);
      b localb = this.wXs;
      if (localb != null)
      {
        localb.onCancel(paramDialogInterface);
        AppMethodBeat.o(199571);
        return;
      }
      AppMethodBeat.o(199571);
    }
    
    public final void onShow(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(199569);
      b localb = this.wXs;
      if (localb != null)
      {
        localb.onShow(paramDialogInterface);
        AppMethodBeat.o(199569);
        return;
      }
      AppMethodBeat.o(199569);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.f
 * JD-Core Version:    0.7.0.1
 */