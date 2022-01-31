package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class ag
{
  private static Handler a;
  
  static
  {
    AppMethodBeat.i(147216);
    a = ac.j();
    AppMethodBeat.o(147216);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2, boolean paramBoolean)
  {
    AppMethodBeat.i(147214);
    a.post(new ai(paramString1, paramInt1, paramInt2, paramString2, paramMap1, paramMap2, paramBoolean));
    AppMethodBeat.o(147214);
  }
  
  public static boolean a(String paramString1, int paramInt1, int paramInt2, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2, boolean paramBoolean, int paramInt3)
  {
    AppMethodBeat.i(147213);
    boolean bool = an.a.a(1);
    if (bool) {
      a.post(new ah(paramString1, paramInt1, paramInt2, paramString2, paramMap1, paramMap2, paramBoolean, 1));
    }
    AppMethodBeat.o(147213);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ag
 * JD-Core Version:    0.7.0.1
 */