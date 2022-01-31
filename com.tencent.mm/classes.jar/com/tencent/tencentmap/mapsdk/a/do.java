package com.tencent.tencentmap.mapsdk.a;

import java.util.HashMap;
import java.util.Set;

public class do
  extends cn
{
  protected HashMap<String, byte[]> e = null;
  nk f = new nk();
  private HashMap<String, Object> g = new HashMap();
  
  public <T> T a(String paramString, boolean paramBoolean, ClassLoader paramClassLoader)
  {
    if (this.e != null) {
      throw new RuntimeException("data is encoded by new version, please use getByClass(String name, T proxy)");
    }
    return super.a(paramString, paramBoolean, paramClassLoader);
  }
  
  public <T> void a(String paramString, T paramT)
  {
    if (this.e != null)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("put key can not is null");
      }
      if (paramT == null) {
        throw new IllegalArgumentException("put value can not is null");
      }
      if ((paramT instanceof Set)) {
        throw new IllegalArgumentException("can not support Set");
      }
      nl localnl = new nl();
      localnl.a(this.c);
      localnl.a(paramT, 0);
      paramT = nn.a(localnl.a());
      this.e.put(paramString, paramT);
      return;
    }
    super.a(paramString, paramT);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    try
    {
      super.a(paramArrayOfByte);
      return;
    }
    catch (Exception localException)
    {
      this.f.a(paramArrayOfByte);
      this.f.a(this.c);
      paramArrayOfByte = new HashMap(1);
      paramArrayOfByte.put("", new byte[0]);
      this.e = this.f.a(paramArrayOfByte, 0, false);
    }
  }
  
  public byte[] a()
  {
    if (this.e != null)
    {
      nl localnl = new nl(0);
      localnl.a(this.c);
      localnl.a(this.e, 0);
      return nn.a(localnl.a());
    }
    return super.a();
  }
  
  public <T> T b(String paramString)
  {
    return a(paramString, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.do
 * JD-Core Version:    0.7.0.1
 */