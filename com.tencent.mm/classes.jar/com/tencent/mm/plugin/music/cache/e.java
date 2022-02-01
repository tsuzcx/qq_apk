package com.tencent.mm.plugin.music.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.j;
import com.tencent.mm.plugin.music.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class e
{
  public static void B(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(137167);
    if (gmX())
    {
      ((c)com.tencent.mm.plugin.music.e.c.b.bU(c.class)).B(paramString, paramArrayOfByte);
      AppMethodBeat.o(137167);
      return;
    }
    Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    AppMethodBeat.o(137167);
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(137170);
    if (gmX())
    {
      ((c)com.tencent.mm.plugin.music.e.c.b.bU(c.class)).a(paramString, parama);
      AppMethodBeat.o(137170);
      return;
    }
    Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    AppMethodBeat.o(137170);
  }
  
  public static a aOC(String paramString)
  {
    AppMethodBeat.i(137169);
    if (gmX())
    {
      paramString = ((c)com.tencent.mm.plugin.music.e.c.b.bU(c.class)).aOC(paramString);
      AppMethodBeat.o(137169);
      return paramString;
    }
    Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    paramString = new a();
    AppMethodBeat.o(137169);
    return paramString;
  }
  
  public static j aOy(String paramString)
  {
    AppMethodBeat.i(137166);
    if (gmX())
    {
      paramString = ((c)com.tencent.mm.plugin.music.e.c.b.bU(c.class)).aOy(paramString);
      AppMethodBeat.o(137166);
      return paramString;
    }
    Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    AppMethodBeat.o(137166);
    return null;
  }
  
  public static String getAccPath()
  {
    AppMethodBeat.i(137165);
    if (gmX())
    {
      str = ((c)com.tencent.mm.plugin.music.e.c.b.bU(c.class)).getAccPath();
      if (!Util.isNullOrNil(str))
      {
        AppMethodBeat.o(137165);
        return str;
      }
    }
    Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    String str = com.tencent.mm.loader.i.b.bmz();
    AppMethodBeat.o(137165);
    return str;
  }
  
  public static void gm(String paramString, int paramInt)
  {
    AppMethodBeat.i(137168);
    if (gmX()) {
      ((c)com.tencent.mm.plugin.music.e.c.b.bU(c.class)).gm(paramString, paramInt);
    }
    AppMethodBeat.o(137168);
  }
  
  public static boolean gmX()
  {
    AppMethodBeat.i(137164);
    if (com.tencent.mm.plugin.music.e.c.b.bU(c.class) != null)
    {
      AppMethodBeat.o(137164);
      return true;
    }
    AppMethodBeat.o(137164);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.e
 * JD-Core Version:    0.7.0.1
 */