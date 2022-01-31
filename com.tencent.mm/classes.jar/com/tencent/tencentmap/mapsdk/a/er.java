package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;
import java.util.Map;

public final class er
{
  private static Handler a = ;
  
  public static void a(String paramString1, int paramInt1, int paramInt2, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2, boolean paramBoolean)
  {
    a.post(new et(paramString1, paramInt1, paramInt2, paramString2, paramMap1, paramMap2, paramBoolean));
  }
  
  public static boolean a(String paramString1, int paramInt1, int paramInt2, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2, boolean paramBoolean, int paramInt3)
  {
    boolean bool = ey.a.a(1);
    if (bool) {
      a.post(new es(paramString1, paramInt1, paramInt2, paramString2, paramMap1, paramMap2, paramBoolean, 1));
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.er
 * JD-Core Version:    0.7.0.1
 */