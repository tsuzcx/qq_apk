package com.tencent.mm.plugin.scanner.util;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.d;
import java.util.Map;

public final class i
{
  public static boolean byw()
  {
    Object localObject = com.tencent.mm.model.c.c.IX().fJ("100027");
    if (!((com.tencent.mm.storage.c)localObject).isValid())
    {
      y.e("MicroMsg.ScanHistoryUtil", "shouldShowHistoryList item.isValid is false");
      return false;
    }
    localObject = ((com.tencent.mm.storage.c)localObject).ctr();
    if (localObject == null)
    {
      y.e("MicroMsg.ScanHistoryUtil", "shouldShowHistoryList args == null");
      return false;
    }
    if ((((Map)localObject).containsKey("showEntrance")) && ("1".equals(((Map)localObject).get("showEntrance")))) {
      return true;
    }
    y.e("MicroMsg.ScanHistoryUtil", "not contain the showEntrance key or the value is not 1");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.i
 * JD-Core Version:    0.7.0.1
 */