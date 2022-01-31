package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.jq;
import com.tencent.tencentmap.mapsdk.maps.a.ka;
import com.tencent.tencentmap.mapsdk.maps.a.nt;
import com.tencent.tencentmap.mapsdk.maps.a.p;
import com.tencent.tencentmap.mapsdk.maps.a.q;
import com.tencent.tencentmap.mapsdk.maps.a.t;
import com.tencent.tencentmap.mapsdk.maps.a.u;
import com.tencent.tencentmap.mapsdk.maps.a.v;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ds
  implements do
{
  private static final String[] a;
  private static q b;
  private static t c;
  
  static
  {
    AppMethodBeat.i(150156);
    a = new String[] { jq.a(), "https://vectorsdk.map.qq.com", "https://tafrtt.map.qq.com/rttserverex/", "diditaf.map.qq.com" };
    AppMethodBeat.o(150156);
  }
  
  public ds()
  {
    AppMethodBeat.i(101105);
    AppMethodBeat.o(101105);
  }
  
  private static String b(String paramString)
  {
    AppMethodBeat.i(150155);
    String str2 = "GBK";
    String str1 = str2;
    int j;
    int i;
    if (paramString != null)
    {
      paramString = paramString.split(";");
      j = paramString.length;
      i = 0;
    }
    for (;;)
    {
      str1 = str2;
      if (i < j)
      {
        str1 = paramString[i];
        if (!str1.contains("charset")) {
          break label79;
        }
        paramString = str1.split("=");
        str1 = str2;
        if (paramString.length > 1) {
          str1 = paramString[1].trim();
        }
      }
      AppMethodBeat.o(150155);
      return str1;
      label79:
      i += 1;
    }
  }
  
  public dq a(String paramString)
  {
    AppMethodBeat.i(150144);
    paramString = a(paramString, "QQ Map Mobile");
    AppMethodBeat.o(150144);
    return paramString;
  }
  
  public dq a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150145);
    paramString1 = a(paramString1, paramString2, 1);
    AppMethodBeat.o(150145);
    return paramString1;
  }
  
  public dq a(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(150146);
    paramString1 = a(paramString1, paramString2, paramInt, null);
    AppMethodBeat.o(150146);
    return paramString1;
  }
  
  public dq a(String paramString1, String paramString2, int paramInt, nt paramnt)
  {
    AppMethodBeat.i(150147);
    paramString1 = a(paramString1, paramString2, paramInt, null, paramnt);
    AppMethodBeat.o(150147);
    return paramString1;
  }
  
  public dq a(String paramString1, String paramString2, int paramInt, HashMap<String, String> paramHashMap, nt paramnt)
  {
    AppMethodBeat.i(150148);
    if (c == null)
    {
      paramString1 = new IOException("HttpClient Init Failed and is Null");
      AppMethodBeat.o(150148);
      throw paramString1;
    }
    paramString1 = c.a(paramString1, null);
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramString1.b(bool);
      paramString1.a(3000);
      paramString1.b(3000);
      paramString1.a(true);
      if (!StringUtil.isEmpty(paramString2)) {
        paramString1.a("User-Agent", paramString2);
      }
      if ((paramHashMap == null) || (paramHashMap.isEmpty())) {
        break;
      }
      paramString2 = paramHashMap.entrySet().iterator();
      while (paramString2.hasNext())
      {
        paramHashMap = (Map.Entry)paramString2.next();
        if (paramHashMap != null) {
          paramString1.a((String)paramHashMap.getKey(), (String)paramHashMap.getValue());
        }
      }
    }
    if (paramnt != null) {
      paramnt.a(paramString1);
    }
    paramString1 = c.a(paramString1);
    if (paramString1 != null)
    {
      paramInt = paramString1.c();
      int i = paramString1.a();
      if ((i == 0) && (paramInt == 200))
      {
        paramString2 = new dq();
        paramString2.a = paramString1.d();
        paramString2.b = b(paramString1.a("Content-Type"));
        AppMethodBeat.o(150148);
        return paramString2;
      }
      paramString1 = "errorCode" + i + ", statusCode:" + paramInt + ", detailErrorInfo:" + paramString1.b();
      if (i == -4)
      {
        paramString1 = new dt(paramString1);
        paramString1.a = i;
        paramString1.b = paramInt;
        AppMethodBeat.o(150148);
        throw paramString1;
      }
      paramString1 = new du(paramString1);
      paramString1.a = i;
      paramString1.b = paramInt;
      AppMethodBeat.o(150148);
      throw paramString1;
    }
    paramString1 = new IOException("response is null");
    AppMethodBeat.o(150148);
    throw paramString1;
  }
  
  public dq a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150150);
    paramString1 = a(paramString1, paramString2, paramArrayOfByte, 1);
    AppMethodBeat.o(150150);
    return paramString1;
  }
  
  public dq a(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(150151);
    paramString1 = a(paramString1, paramString2, paramArrayOfByte, paramInt, null);
    AppMethodBeat.o(150151);
    return paramString1;
  }
  
  public dq a(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt, nt paramnt)
  {
    AppMethodBeat.i(150152);
    paramString1 = a(paramString1, paramString2, paramArrayOfByte, paramInt, null, paramnt);
    AppMethodBeat.o(150152);
    return paramString1;
  }
  
  public dq a(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt, HashMap<String, String> paramHashMap, nt paramnt)
  {
    AppMethodBeat.i(150153);
    paramString1 = a(paramString1, paramString2, paramArrayOfByte, paramInt, paramHashMap, paramnt, 0);
    AppMethodBeat.o(150153);
    return paramString1;
  }
  
  public dq a(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, HashMap<String, String> paramHashMap, nt paramnt, int paramInt2)
  {
    boolean bool = false;
    AppMethodBeat.i(150154);
    if (c == null)
    {
      paramString1 = new IOException("HttpClient Init Failed and is Null");
      AppMethodBeat.o(150154);
      throw paramString1;
    }
    paramString1 = c.a(paramString1, paramArrayOfByte);
    paramString1.a(false);
    if (paramInt1 > 0) {
      bool = true;
    }
    paramString1.b(bool);
    if (!StringUtil.isEmpty(paramString2)) {
      paramString1.a("User-Agent", paramString2);
    }
    if ((paramHashMap != null) && (!paramHashMap.isEmpty()))
    {
      paramString2 = paramHashMap.entrySet().iterator();
      while (paramString2.hasNext())
      {
        paramArrayOfByte = (Map.Entry)paramString2.next();
        if (paramArrayOfByte != null) {
          paramString1.a((String)paramArrayOfByte.getKey(), (String)paramArrayOfByte.getValue());
        }
      }
    }
    if (paramnt != null) {
      paramnt.a(paramString1);
    }
    if (paramInt2 > 0)
    {
      paramString1.a(paramInt2);
      paramString1.b(paramInt2);
    }
    for (;;)
    {
      paramString1 = c.a(paramString1);
      if (paramString1 == null) {
        break label396;
      }
      paramInt1 = paramString1.c();
      paramInt2 = paramString1.a();
      if ((paramInt2 != 0) || (paramInt1 != 200)) {
        break;
      }
      paramString2 = new dq();
      paramString2.a = paramString1.d();
      paramString2.b = b(paramString1.a("Content-Type"));
      AppMethodBeat.o(150154);
      return paramString2;
      paramString1.a(3000);
      paramString1.b(3000);
    }
    paramString1 = "errorCode:" + paramInt2 + ", statusCode:" + paramInt1 + ", detailErrorInfo:" + paramString1.b();
    if (paramInt2 == -4)
    {
      paramString1 = new dt(paramString1);
      paramString1.a = paramInt2;
      paramString1.b = paramInt1;
      AppMethodBeat.o(150154);
      throw paramString1;
    }
    paramString1 = new du(paramString1);
    paramString1.a = paramInt2;
    paramString1.b = paramInt1;
    AppMethodBeat.o(150154);
    throw paramString1;
    label396:
    paramString1 = new IOException("response is null");
    AppMethodBeat.o(150154);
    throw paramString1;
  }
  
  public void a(Context paramContext)
  {
    AppMethodBeat.i(101106);
    try
    {
      paramContext = new q(paramContext, 3203, ka.a, "android_vector_sdk_4.2.3.3");
      b = paramContext;
      c = p.b(paramContext);
      AppMethodBeat.o(101106);
      return;
    }
    catch (Exception paramContext)
    {
      new StringBuilder("initNet error:").append(paramContext.toString());
      AppMethodBeat.o(101106);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ds
 * JD-Core Version:    0.7.0.1
 */