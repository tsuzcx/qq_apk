package com.tencent.tencentmap.mapsdk.maps.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class be
{
  public int a;
  public String b;
  public int c;
  public byte[] d;
  private Map<String, String> e;
  
  public be(int paramInt1, String paramString, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramString;
    this.c = 0;
  }
  
  public final String a(String paramString)
  {
    AppMethodBeat.i(147277);
    if ((this.e != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramString = (String)this.e.get(paramString.toLowerCase());
      if (!TextUtils.isEmpty(paramString))
      {
        AppMethodBeat.o(147277);
        return paramString;
      }
    }
    AppMethodBeat.o(147277);
    return "";
  }
  
  public final void a(Map<String, String> paramMap)
  {
    AppMethodBeat.i(147276);
    this.e = new HashMap();
    if (paramMap.size() > 0)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.e.put(str.toLowerCase(), paramMap.get(str));
      }
    }
    AppMethodBeat.o(147276);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(147278);
    StringBuilder localStringBuilder = new StringBuilder("errorCode:").append(this.a).append(",errorInfo:").append(this.b).append(",httpStatus:").append(this.c).append(",headers:").append(this.e).append(",body:");
    if (this.d != null) {}
    for (Object localObject = Integer.valueOf(this.d.length);; localObject = "null")
    {
      localObject = localObject;
      AppMethodBeat.o(147278);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.be
 * JD-Core Version:    0.7.0.1
 */