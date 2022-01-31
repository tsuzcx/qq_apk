package com.tencent.mm.plugin.scanner.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.d;
import java.util.Map;

public final class k
{
  public static boolean cjG()
  {
    AppMethodBeat.i(81450);
    Object localObject = com.tencent.mm.model.c.c.abU().me("100027");
    if (!((com.tencent.mm.storage.c)localObject).isValid())
    {
      ab.e("MicroMsg.ScanHistoryUtil", "shouldShowHistoryList item.isValid is false");
      AppMethodBeat.o(81450);
      return false;
    }
    localObject = ((com.tencent.mm.storage.c)localObject).dvN();
    if (localObject == null)
    {
      ab.e("MicroMsg.ScanHistoryUtil", "shouldShowHistoryList args == null");
      AppMethodBeat.o(81450);
      return false;
    }
    if ((((Map)localObject).containsKey("showEntrance")) && ("1".equals(((Map)localObject).get("showEntrance"))))
    {
      AppMethodBeat.o(81450);
      return true;
    }
    ab.e("MicroMsg.ScanHistoryUtil", "not contain the showEntrance key or the value is not 1");
    AppMethodBeat.o(81450);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.k
 * JD-Core Version:    0.7.0.1
 */