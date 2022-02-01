package com.tencent.mm.plugin.scanner.box;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/box/ScanShareReporter;", "", "()V", "TAG", "", "reportScanShareCancel", "", "data", "Landroid/os/Bundle;", "reportScanShareResult", "success", "", "isChatRoom", "ShareResult", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
{
  public static final s ONY;
  
  static
  {
    AppMethodBeat.i(313732);
    ONY = new s();
    AppMethodBeat.o(313732);
  }
  
  public static final void aR(Bundle paramBundle)
  {
    AppMethodBeat.i(313729);
    String str1;
    String str2;
    if (paramBundle == null)
    {
      str1 = "";
      if (paramBundle != null) {
        break label84;
      }
      str2 = "";
      label19:
      if (paramBundle != null) {
        break label104;
      }
      paramBundle = "";
    }
    for (;;)
    {
      h.OAn.b(21537, new Object[] { str2, paramBundle, Integer.valueOf(3), str1 });
      AppMethodBeat.o(313729);
      return;
      str1 = paramBundle.getString("enter_session");
      if (str1 == null)
      {
        str1 = "";
        break;
      }
      break;
      label84:
      str2 = paramBundle.getString("tab_session");
      if (str2 == null)
      {
        str2 = "";
        break label19;
      }
      break label19;
      label104:
      String str3 = paramBundle.getString("scan_session");
      paramBundle = str3;
      if (str3 == null) {
        paramBundle = "";
      }
    }
  }
  
  public static final void b(boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle)
  {
    AppMethodBeat.i(313723);
    String str1;
    String str2;
    if (paramBoolean1)
    {
      if (paramBundle != null) {
        break label78;
      }
      str1 = "";
      if (paramBundle != null) {
        break label101;
      }
      str2 = "";
      label25:
      if (paramBundle != null) {
        break label124;
      }
      paramBundle = "";
      label32:
      if (!paramBoolean2) {
        break label144;
      }
    }
    label144:
    for (int i = 1;; i = 2)
    {
      h.OAn.b(21537, new Object[] { str2, paramBundle, Integer.valueOf(i), str1 });
      AppMethodBeat.o(313723);
      return;
      label78:
      str1 = paramBundle.getString("enter_session");
      if (str1 == null)
      {
        str1 = "";
        break;
      }
      break;
      label101:
      str2 = paramBundle.getString("tab_session");
      if (str2 == null)
      {
        str2 = "";
        break label25;
      }
      break label25;
      label124:
      paramBundle = paramBundle.getString("scan_session");
      if (paramBundle == null)
      {
        paramBundle = "";
        break label32;
      }
      break label32;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.s
 * JD-Core Version:    0.7.0.1
 */