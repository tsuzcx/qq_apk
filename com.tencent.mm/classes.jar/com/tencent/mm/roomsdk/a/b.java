package com.tencent.mm.roomsdk.a;

import com.tencent.mm.roomsdk.a.a.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public final class b
{
  private static b ubp = new b();
  private HashMap<String, a> ubo = new HashMap();
  
  public static a YK(String paramString)
  {
    int i = paramString.indexOf("@");
    if (i < 0)
    {
      y.e("MicroMsg.RoomServiceFactory", "get NotNullChatRoom %s", new Object[] { paramString });
      localObject = new com.tencent.mm.roomsdk.a.a.b();
      return localObject;
    }
    paramString = paramString.substring(i);
    Object localObject = ubp;
    if (((b)localObject).ubo.containsKey(paramString)) {}
    for (paramString = (a)((b)localObject).ubo.get(paramString);; paramString = null)
    {
      localObject = paramString;
      if (paramString != null) {
        break;
      }
      return new com.tencent.mm.roomsdk.a.a.b();
    }
  }
  
  public static void a(String paramString, a parama)
  {
    int i = paramString.indexOf("@");
    if (i < 0) {}
    for (;;)
    {
      b localb = ubp;
      if (!localb.ubo.containsKey(paramString)) {
        localb.ubo.put(paramString, parama);
      }
      return;
      paramString = paramString.substring(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.b
 * JD-Core Version:    0.7.0.1
 */