package com.tencent.tencentmap.mapsdk.a;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Set;

public final class dd
{
  private static HashMap<String, byte[]> e = null;
  private HashMap<String, byte[]> a = new HashMap();
  private da b = new da();
  private String c = "GBK";
  private de d = new de();
  
  public final void a()
  {
    this.d.b = 1;
  }
  
  public final void a(String paramString)
  {
    this.d.d = paramString;
  }
  
  public final <T> void a(String paramString, T paramT)
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
    Object localObject = new db();
    ((db)localObject).a(this.c);
    ((db)localObject).a(paramT, 0);
    paramT = ((db)localObject).a();
    localObject = new byte[paramT.position()];
    System.arraycopy(paramT.array(), 0, localObject, 0, localObject.length);
    this.a.put(paramString, localObject);
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length < 4) {
      throw new IllegalArgumentException("decode package must include size head");
    }
    try
    {
      paramArrayOfByte = new da(paramArrayOfByte, (byte)0);
      paramArrayOfByte.a(this.c);
      this.d.a(paramArrayOfByte);
      paramArrayOfByte = new da(this.d.e);
      paramArrayOfByte.a(this.c);
      if (e == null)
      {
        HashMap localHashMap = new HashMap();
        e = localHashMap;
        localHashMap.put("", new byte[0]);
      }
      this.a = paramArrayOfByte.a(e);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
  }
  
  public final <T> T b(String paramString, T paramT)
  {
    if (!this.a.containsKey(paramString)) {
      return null;
    }
    paramString = (byte[])this.a.get(paramString);
    try
    {
      this.b.a(paramString);
      this.b.a(this.c);
      paramString = this.b.a(paramT, 0, true);
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new Exception(paramString);
    }
  }
  
  public final void b(String paramString)
  {
    this.d.c = paramString;
  }
  
  public final byte[] b()
  {
    Object localObject2 = new db(0);
    ((db)localObject2).a(this.c);
    ((db)localObject2).a(this.a, 0);
    this.d.a = 3;
    Object localObject1 = this.d;
    localObject2 = ((db)localObject2).a();
    byte[] arrayOfByte = new byte[((ByteBuffer)localObject2).position()];
    System.arraycopy(((ByteBuffer)localObject2).array(), 0, arrayOfByte, 0, arrayOfByte.length);
    ((de)localObject1).e = arrayOfByte;
    localObject1 = new db(0);
    ((db)localObject1).a(this.c);
    this.d.a((db)localObject1);
    localObject2 = ((db)localObject1).a();
    localObject1 = new byte[((ByteBuffer)localObject2).position()];
    System.arraycopy(((ByteBuffer)localObject2).array(), 0, localObject1, 0, localObject1.length);
    int i = localObject1.length;
    localObject2 = ByteBuffer.allocate(i + 4);
    ((ByteBuffer)localObject2).putInt(i + 4).put((byte[])localObject1).flip();
    return ((ByteBuffer)localObject2).array();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.dd
 * JD-Core Version:    0.7.0.1
 */