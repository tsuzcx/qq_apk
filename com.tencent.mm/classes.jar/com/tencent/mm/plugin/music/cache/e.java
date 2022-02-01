package com.tencent.mm.plugin.music.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.j;
import com.tencent.mm.plugin.music.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class e
{
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(137170);
    if (fdV())
    {
      ((c)com.tencent.mm.plugin.music.f.c.b.bm(c.class)).a(paramString, parama);
      AppMethodBeat.o(137170);
      return;
    }
    Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    AppMethodBeat.o(137170);
  }
  
  public static j aRG(String paramString)
  {
    AppMethodBeat.i(137166);
    if (fdV())
    {
      paramString = ((c)com.tencent.mm.plugin.music.f.c.b.bm(c.class)).aRG(paramString);
      AppMethodBeat.o(137166);
      return paramString;
    }
    Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    AppMethodBeat.o(137166);
    return null;
  }
  
  public static a aRK(String paramString)
  {
    AppMethodBeat.i(137169);
    if (fdV())
    {
      paramString = ((c)com.tencent.mm.plugin.music.f.c.b.bm(c.class)).aRK(paramString);
      AppMethodBeat.o(137169);
      return paramString;
    }
    Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    paramString = new a();
    AppMethodBeat.o(137169);
    return paramString;
  }
  
  public static boolean fdV()
  {
    AppMethodBeat.i(137164);
    if (com.tencent.mm.plugin.music.f.c.b.bm(c.class) != null)
    {
      AppMethodBeat.o(137164);
      return true;
    }
    AppMethodBeat.o(137164);
    return false;
  }
  
  public static void ft(String paramString, int paramInt)
  {
    AppMethodBeat.i(137168);
    if (fdV()) {
      ((c)com.tencent.mm.plugin.music.f.c.b.bm(c.class)).ft(paramString, paramInt);
    }
    AppMethodBeat.o(137168);
  }
  
  public static String getAccPath()
  {
    AppMethodBeat.i(137165);
    if (fdV())
    {
      str = ((c)com.tencent.mm.plugin.music.f.c.b.bm(c.class)).getAccPath();
      if (!Util.isNullOrNil(str))
      {
        AppMethodBeat.o(137165);
        return str;
      }
    }
    Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    String str = com.tencent.mm.loader.j.b.aSL();
    AppMethodBeat.o(137165);
    return str;
  }
  
  public static void x(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(137167);
    if (fdV())
    {
      ((c)com.tencent.mm.plugin.music.f.c.b.bm(c.class)).x(paramString, paramArrayOfByte);
      AppMethodBeat.o(137167);
      return;
    }
    Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    AppMethodBeat.o(137167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.e
 * JD-Core Version:    0.7.0.1
 */