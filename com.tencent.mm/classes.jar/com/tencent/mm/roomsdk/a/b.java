package com.tencent.mm.roomsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.roomsdk.a.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;

public final class b
{
  private static b HWe;
  private HashMap<String, a> HWd;
  
  static
  {
    AppMethodBeat.i(152758);
    HWe = new b();
    AppMethodBeat.o(152758);
  }
  
  public b()
  {
    AppMethodBeat.i(152755);
    this.HWd = new HashMap();
    AppMethodBeat.o(152755);
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(152757);
    int i = paramString.indexOf("@");
    if (i < 0) {}
    for (;;)
    {
      b localb = HWe;
      if (!localb.HWd.containsKey(paramString)) {
        localb.HWd.put(paramString, parama);
      }
      AppMethodBeat.o(152757);
      return;
      paramString = paramString.substring(i);
    }
  }
  
  public static a aPF(String paramString)
  {
    AppMethodBeat.i(152756);
    int i = paramString.indexOf("@");
    if (i < 0)
    {
      ad.e("MicroMsg.RoomServiceFactory", "get NotNullChatRoom %s", new Object[] { paramString });
      paramString = new com.tencent.mm.roomsdk.a.a.b();
      AppMethodBeat.o(152756);
      return paramString;
    }
    paramString = paramString.substring(i);
    b localb = HWe;
    if (localb.HWd.containsKey(paramString)) {}
    for (paramString = (a)localb.HWd.get(paramString); paramString == null; paramString = null)
    {
      paramString = new com.tencent.mm.roomsdk.a.a.b();
      AppMethodBeat.o(152756);
      return paramString;
    }
    AppMethodBeat.o(152756);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.b
 * JD-Core Version:    0.7.0.1
 */