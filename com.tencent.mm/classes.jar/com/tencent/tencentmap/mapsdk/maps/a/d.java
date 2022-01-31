package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Set;

public class d
  extends c
{
  protected HashMap<String, byte[]> e;
  k f;
  private HashMap<String, Object> g;
  
  public d()
  {
    AppMethodBeat.i(98688);
    this.e = null;
    this.g = new HashMap();
    this.f = new k();
    AppMethodBeat.o(98688);
  }
  
  public <T> T a(String paramString, boolean paramBoolean, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(98691);
    if (this.e != null)
    {
      paramString = new RuntimeException("data is encoded by new version, please use getByClass(String name, T proxy)");
      AppMethodBeat.o(98691);
      throw paramString;
    }
    paramString = super.a(paramString, paramBoolean, paramClassLoader);
    AppMethodBeat.o(98691);
    return paramString;
  }
  
  public <T> void a(String paramString, T paramT)
  {
    AppMethodBeat.i(98689);
    if (this.e != null)
    {
      if (paramString == null)
      {
        paramString = new IllegalArgumentException("put key can not is null");
        AppMethodBeat.o(98689);
        throw paramString;
      }
      if (paramT == null)
      {
        paramString = new IllegalArgumentException("put value can not is null");
        AppMethodBeat.o(98689);
        throw paramString;
      }
      if ((paramT instanceof Set))
      {
        paramString = new IllegalArgumentException("can not support Set");
        AppMethodBeat.o(98689);
        throw paramString;
      }
      l locall = new l();
      locall.a(this.c);
      locall.a(paramT, 0);
      paramT = n.a(locall.a());
      this.e.put(paramString, paramT);
      AppMethodBeat.o(98689);
      return;
    }
    super.a(paramString, paramT);
    AppMethodBeat.o(98689);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(98693);
    try
    {
      super.a(paramArrayOfByte);
      AppMethodBeat.o(98693);
      return;
    }
    catch (Exception localException)
    {
      this.f.a(paramArrayOfByte);
      this.f.a(this.c);
      paramArrayOfByte = new HashMap(1);
      paramArrayOfByte.put("", new byte[0]);
      this.e = this.f.a(paramArrayOfByte, 0, false);
      AppMethodBeat.o(98693);
    }
  }
  
  public byte[] a()
  {
    AppMethodBeat.i(98692);
    if (this.e != null)
    {
      localObject = new l(0);
      ((l)localObject).a(this.c);
      ((l)localObject).a(this.e, 0);
      localObject = n.a(((l)localObject).a());
      AppMethodBeat.o(98692);
      return localObject;
    }
    Object localObject = super.a();
    AppMethodBeat.o(98692);
    return localObject;
  }
  
  public <T> T b(String paramString)
  {
    AppMethodBeat.i(98690);
    paramString = a(paramString, true, null);
    AppMethodBeat.o(98690);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.d
 * JD-Core Version:    0.7.0.1
 */