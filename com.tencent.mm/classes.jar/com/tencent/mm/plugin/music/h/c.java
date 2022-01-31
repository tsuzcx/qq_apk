package com.tencent.mm.plugin.music.h;

import android.text.TextUtils;
import com.tencent.mm.av.e;
import com.tencent.mm.plugin.music.e.a;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.sdk.platformtools.y;

public final class c
{
  public static boolean L(e parame)
  {
    if (parame == null) {}
    do
    {
      do
      {
        return false;
      } while (TextUtils.isEmpty(parame.protocol));
      y.d("MicroMsg.Music.MusicPlayerSupport", "protocol:%s", new Object[] { parame.protocol });
    } while (!"hls".equalsIgnoreCase(parame.protocol));
    return true;
  }
  
  public static boolean vb(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      a locala = k.bnl().myY;
      if ((locala == null) || (!locala.uJ(paramInt))) {
        break;
      }
    case 10: 
    case 11: 
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.h.c
 * JD-Core Version:    0.7.0.1
 */