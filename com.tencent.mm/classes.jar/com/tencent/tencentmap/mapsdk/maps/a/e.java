package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.HashMap;

public class e
  extends d
{
  static HashMap<String, byte[]> h = null;
  static HashMap<String, HashMap<String, byte[]>> i = null;
  protected f g;
  private int j;
  private int k;
  
  public e()
  {
    AppMethodBeat.i(98751);
    this.g = new f();
    this.j = 0;
    this.k = 0;
    this.g.a = 2;
    AppMethodBeat.o(98751);
  }
  
  private void b()
  {
    AppMethodBeat.i(98754);
    k localk = new k(this.g.g);
    localk.a(this.c);
    if (h == null)
    {
      HashMap localHashMap = new HashMap();
      h = localHashMap;
      localHashMap.put("", new byte[0]);
    }
    this.e = localk.a(h, 0, false);
    AppMethodBeat.o(98754);
  }
  
  private void c()
  {
    AppMethodBeat.i(98755);
    k localk = new k(this.g.g);
    localk.a(this.c);
    if (i == null)
    {
      i = new HashMap();
      HashMap localHashMap = new HashMap();
      localHashMap.put("", new byte[0]);
      i.put("", localHashMap);
    }
    this.a = localk.a(i, 0, false);
    this.b = new HashMap();
    AppMethodBeat.o(98755);
  }
  
  public <T> void a(String paramString, T paramT)
  {
    AppMethodBeat.i(98752);
    if (paramString.startsWith("."))
    {
      paramString = new IllegalArgumentException("put name can not startwith . , now is ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(98752);
      throw paramString;
    }
    super.a(paramString, paramT);
    AppMethodBeat.o(98752);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(98756);
    if (paramArrayOfByte.length < 4)
    {
      paramArrayOfByte = new IllegalArgumentException("decode package must include size head");
      AppMethodBeat.o(98756);
      throw paramArrayOfByte;
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    byte[] arrayOfByte = new byte[4];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 4);
    localByteBuffer.put(arrayOfByte).flip();
    this.j = localByteBuffer.getInt();
    try
    {
      paramArrayOfByte = new k(paramArrayOfByte, 4);
      paramArrayOfByte.a(this.c);
      this.g.readFrom(paramArrayOfByte);
      if (this.g.a == 3)
      {
        b();
        AppMethodBeat.o(98756);
        return;
      }
      this.e = null;
      c();
      AppMethodBeat.o(98756);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte = new RuntimeException(paramArrayOfByte);
      AppMethodBeat.o(98756);
      throw paramArrayOfByte;
    }
  }
  
  public byte[] a()
  {
    AppMethodBeat.i(98753);
    if (this.g.a == 2)
    {
      if ((this.g.e == null) || (this.g.e.equals("")))
      {
        localObject = new IllegalArgumentException("servantName can not is null");
        AppMethodBeat.o(98753);
        throw ((Throwable)localObject);
      }
      if ((this.g.f == null) || (this.g.f.equals("")))
      {
        localObject = new IllegalArgumentException("funcName can not is null");
        AppMethodBeat.o(98753);
        throw ((Throwable)localObject);
      }
    }
    else
    {
      if (this.g.e == null) {
        this.g.e = "";
      }
      if (this.g.f == null) {
        this.g.f = "";
      }
    }
    Object localObject = new l(0);
    ((l)localObject).a(this.c);
    if ((this.g.a == 2) || (this.g.a == 1)) {
      ((l)localObject).a(this.a, 0);
    }
    for (;;)
    {
      this.g.g = n.a(((l)localObject).a());
      localObject = new l(0);
      ((l)localObject).a(this.c);
      this.g.writeTo((l)localObject);
      localObject = n.a(((l)localObject).a());
      int m = localObject.length;
      ByteBuffer localByteBuffer = ByteBuffer.allocate(m + 4);
      localByteBuffer.putInt(m + 4).put((byte[])localObject).flip();
      localObject = localByteBuffer.array();
      AppMethodBeat.o(98753);
      return localObject;
      ((l)localObject).a(this.e, 0);
    }
  }
  
  public void c(String paramString)
  {
    this.g.e = paramString;
  }
  
  public void d(String paramString)
  {
    this.g.f = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.e
 * JD-Core Version:    0.7.0.1
 */