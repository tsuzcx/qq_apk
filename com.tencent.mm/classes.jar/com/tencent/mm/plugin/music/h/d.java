package com.tencent.mm.plugin.music.h;

import com.tencent.mm.av.e;
import com.tencent.mm.plugin.music.cache.h;
import java.io.File;

public final class d
{
  public static boolean JJ(String paramString)
  {
    return (h.Ju(paramString)) && (h.Jr(paramString) > 0L);
  }
  
  public static boolean d(e parame, boolean paramBoolean)
  {
    parame = new File(b.aN(b.K(parame), paramBoolean));
    return (parame.exists()) && (parame.length() > 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.h.d
 * JD-Core Version:    0.7.0.1
 */