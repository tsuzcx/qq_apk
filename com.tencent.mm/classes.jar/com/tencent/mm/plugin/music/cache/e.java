package com.tencent.mm.plugin.music.cache;

import com.tencent.mm.av.h;
import com.tencent.mm.plugin.music.c.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class e
{
  public static String FU()
  {
    if (bmM())
    {
      String str = ((c)com.tencent.mm.plugin.music.f.c.b.Q(c.class)).FU();
      if (!bk.bl(str)) {
        return str;
      }
    }
    y.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    return com.tencent.mm.loader.a.b.bkH;
  }
  
  public static h Jg(String paramString)
  {
    if (bmM()) {
      return ((c)com.tencent.mm.plugin.music.f.c.b.Q(c.class)).Jg(paramString);
    }
    y.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    return null;
  }
  
  public static a Jk(String paramString)
  {
    if (bmM()) {
      return ((c)com.tencent.mm.plugin.music.f.c.b.Q(c.class)).Jk(paramString);
    }
    y.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    return new a();
  }
  
  public static void a(String paramString, a parama)
  {
    if (bmM())
    {
      ((c)com.tencent.mm.plugin.music.f.c.b.Q(c.class)).a(paramString, parama);
      return;
    }
    y.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
  }
  
  public static boolean bmM()
  {
    return com.tencent.mm.plugin.music.f.c.b.Q(c.class) != null;
  }
  
  public static void q(String paramString, byte[] paramArrayOfByte)
  {
    if (bmM())
    {
      ((c)com.tencent.mm.plugin.music.f.c.b.Q(c.class)).q(paramString, paramArrayOfByte);
      return;
    }
    y.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.e
 * JD-Core Version:    0.7.0.1
 */