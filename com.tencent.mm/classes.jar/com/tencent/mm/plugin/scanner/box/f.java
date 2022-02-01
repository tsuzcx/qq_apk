package com.tencent.mm.plugin.scanner.box;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.pq;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxManager;", "", "()V", "KEY_ENTER_SESSION", "", "KEY_FIXED_WEBVIEW_HEIGHT", "KEY_REQ_KEY", "KEY_SCAN_SESSION", "KEY_TAB_SESSION", "TAG", "showBoxDialog", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialog;", "context", "Landroid/content/Context;", "data", "Landroid/os/Bundle;", "scanBoxDialogEventListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogEventListener;", "plugin-scan_release"})
public final class f
{
  public static final f ylc;
  
  static
  {
    AppMethodBeat.i(52133);
    ylc = new f();
    AppMethodBeat.o(52133);
  }
  
  public static final e a(Context paramContext, Bundle paramBundle, b paramb)
  {
    AppMethodBeat.i(52132);
    p.h(paramContext, "context");
    p.h(paramBundle, "data");
    pq localpq = new pq();
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
            ad.i("MicroMsg.ScanBoxManager", "alvinluo showBoxDialog reqKey: %s, enterSession: %s, tabSession: %s, scanSession: %s, fixWebViewHeight: %d", new Object[] { str1, str2, str3, str4, Integer.valueOf(i) });
            paramBundle = g.yle;
            localpq.Url = com.tencent.mm.plugin.box.c.b.a(localHashMap, g.dKF());
            localpq.FKL = UUID.randomUUID().toString();
            paramContext = new e(paramContext, localpq);
            if (i > 0)
            {
              paramContext.ykv = true;
              paramBundle = paramContext.ykY;
              if (paramBundle != null) {
                paramBundle.setIsFixWebViewHeight(true);
              }
              paramContext.ykw = i;
              paramBundle = paramContext.ykY;
              if (paramBundle != null) {
                paramBundle.setFixWebViewHeight(i);
              }
            }
            paramContext.ykX = ((b)new a(paramb));
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/scanner/box/ScanBoxManager$showBoxDialog$1", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogEventListener;", "onCancel", "", "dialog", "Landroid/content/DialogInterface;", "onDismiss", "exitType", "", "onShow", "plugin-scan_release"})
  public static final class a
    implements b
  {
    a(b paramb) {}
    
    public final void a(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(186247);
      b localb = this.yld;
      if (localb != null)
      {
        localb.a(paramDialogInterface, paramInt);
        AppMethodBeat.o(186247);
        return;
      }
      AppMethodBeat.o(186247);
    }
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(186248);
      b localb = this.yld;
      if (localb != null)
      {
        localb.onCancel(paramDialogInterface);
        AppMethodBeat.o(186248);
        return;
      }
      AppMethodBeat.o(186248);
    }
    
    public final void onShow(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(186246);
      b localb = this.yld;
      if (localb != null)
      {
        localb.onShow(paramDialogInterface);
        AppMethodBeat.o(186246);
        return;
      }
      AppMethodBeat.o(186246);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.f
 * JD-Core Version:    0.7.0.1
 */