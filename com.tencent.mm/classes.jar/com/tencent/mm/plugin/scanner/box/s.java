package com.tencent.mm.plugin.scanner.box;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/box/ScanShareReporter;", "", "()V", "TAG", "", "reportScanShareCancel", "", "data", "Landroid/os/Bundle;", "reportScanShareResult", "success", "", "isChatRoom", "ShareResult", "plugin-scan_release"})
public final class s
{
  public static final s IHZ;
  
  static
  {
    AppMethodBeat.i(217956);
    IHZ = new s();
    AppMethodBeat.o(217956);
  }
  
  public static final void as(Bundle paramBundle)
  {
    AppMethodBeat.i(217951);
    Object localObject2;
    Object localObject1;
    if (paramBundle != null)
    {
      localObject2 = paramBundle.getString("enter_session");
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    p.j(localObject1, "data?.getString(ScanBoxM….KEY_ENTER_SESSION) ?: \"\"");
    String str;
    if (paramBundle != null)
    {
      str = paramBundle.getString("tab_session");
      localObject2 = str;
      if (str != null) {}
    }
    else
    {
      localObject2 = "";
    }
    p.j(localObject2, "data?.getString(ScanBoxM…er.KEY_TAB_SESSION) ?: \"\"");
    if (paramBundle != null)
    {
      str = paramBundle.getString("scan_session");
      paramBundle = str;
      if (str != null) {}
    }
    else
    {
      paramBundle = "";
    }
    p.j(paramBundle, "data?.getString(ScanBoxM…r.KEY_SCAN_SESSION) ?: \"\"");
    h.IzE.a(21537, new Object[] { localObject2, paramBundle, Integer.valueOf(3), localObject1 });
    AppMethodBeat.o(217951);
  }
  
  public static final void b(boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle)
  {
    AppMethodBeat.i(217949);
    Object localObject2;
    Object localObject1;
    if (paramBoolean1)
    {
      if (paramBundle != null)
      {
        localObject2 = paramBundle.getString("enter_session");
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      p.j(localObject1, "data?.getString(ScanBoxM….KEY_ENTER_SESSION) ?: \"\"");
      String str;
      if (paramBundle != null)
      {
        str = paramBundle.getString("tab_session");
        localObject2 = str;
        if (str != null) {}
      }
      else
      {
        localObject2 = "";
      }
      p.j(localObject2, "data?.getString(ScanBoxM…er.KEY_TAB_SESSION) ?: \"\"");
      if (paramBundle != null)
      {
        str = paramBundle.getString("scan_session");
        paramBundle = str;
        if (str != null) {}
      }
      else
      {
        paramBundle = "";
      }
      p.j(paramBundle, "data?.getString(ScanBoxM…r.KEY_SCAN_SESSION) ?: \"\"");
      if (!paramBoolean2) {
        break label148;
      }
    }
    label148:
    for (int i = 1;; i = 2)
    {
      h.IzE.a(21537, new Object[] { localObject2, paramBundle, Integer.valueOf(i), localObject1 });
      AppMethodBeat.o(217949);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.s
 * JD-Core Version:    0.7.0.1
 */