package com.tencent.mm.plugin.scanner.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class e
{
  public static boolean dQh()
  {
    AppMethodBeat.i(52058);
    Object localObject = com.tencent.mm.model.c.d.aDI().xi("100027");
    if (!((c)localObject).isValid())
    {
      ae.e("MicroMsg.ScanHistoryUtil", "shouldShowHistoryList item.isValid is false");
      AppMethodBeat.o(52058);
      return false;
    }
    localObject = ((c)localObject).fsy();
    if (localObject == null)
    {
      ae.e("MicroMsg.ScanHistoryUtil", "shouldShowHistoryList args == null");
      AppMethodBeat.o(52058);
      return false;
    }
    if ((((Map)localObject).containsKey("showEntrance")) && ("1".equals(((Map)localObject).get("showEntrance"))))
    {
      AppMethodBeat.o(52058);
      return true;
    }
    ae.e("MicroMsg.ScanHistoryUtil", "not contain the showEntrance key or the value is not 1");
    AppMethodBeat.o(52058);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.e
 * JD-Core Version:    0.7.0.1
 */