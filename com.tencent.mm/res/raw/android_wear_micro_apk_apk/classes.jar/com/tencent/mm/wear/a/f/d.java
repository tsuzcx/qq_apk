package com.tencent.mm.wear.a.f;

import com.tencent.mm.wear.app.b.h;
import java.io.File;

public final class d
{
  public static boolean T(String paramString)
  {
    paramString = "lib" + paramString + ".so";
    return new File(h.mg(), paramString).exists();
  }
  
  public static void U(String paramString)
  {
    Object localObject = "lib" + paramString + ".so";
    localObject = new File(h.mg(), (String)localObject);
    com.tencent.mm.wear.a.c.d.c("MicroMsg.SoUtil", "loadSo %s", new Object[] { paramString });
    System.load(((File)localObject).getAbsolutePath());
  }
  
  public static void V(String paramString)
  {
    paramString = "lib" + paramString + ".so";
    new File(h.mg(), paramString).delete();
  }
  
  public static boolean d(String paramString, byte[] paramArrayOfByte)
  {
    paramString = "lib" + paramString + ".so";
    return c.a(new File(h.mg(), paramString), paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.a.f.d
 * JD-Core Version:    0.7.0.1
 */