package com.tencent.mm.plugin.music.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.i;
import com.tencent.mm.plugin.music.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class e
{
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(137170);
    if (cUJ())
    {
      ((c)com.tencent.mm.plugin.music.f.c.b.aP(c.class)).a(paramString, parama);
      AppMethodBeat.o(137170);
      return;
    }
    ad.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    AppMethodBeat.o(137170);
  }
  
  public static i ain(String paramString)
  {
    AppMethodBeat.i(137166);
    if (cUJ())
    {
      paramString = ((c)com.tencent.mm.plugin.music.f.c.b.aP(c.class)).ain(paramString);
      AppMethodBeat.o(137166);
      return paramString;
    }
    ad.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    AppMethodBeat.o(137166);
    return null;
  }
  
  public static a air(String paramString)
  {
    AppMethodBeat.i(137169);
    if (cUJ())
    {
      paramString = ((c)com.tencent.mm.plugin.music.f.c.b.aP(c.class)).air(paramString);
      AppMethodBeat.o(137169);
      return paramString;
    }
    ad.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    paramString = new a();
    AppMethodBeat.o(137169);
    return paramString;
  }
  
  public static boolean cUJ()
  {
    AppMethodBeat.i(137164);
    if (com.tencent.mm.plugin.music.f.c.b.aP(c.class) != null)
    {
      AppMethodBeat.o(137164);
      return true;
    }
    AppMethodBeat.o(137164);
    return false;
  }
  
  public static void dW(String paramString, int paramInt)
  {
    AppMethodBeat.i(137168);
    if (cUJ()) {
      ((c)com.tencent.mm.plugin.music.f.c.b.aP(c.class)).dW(paramString, paramInt);
    }
    AppMethodBeat.o(137168);
  }
  
  public static String getAccPath()
  {
    AppMethodBeat.i(137165);
    if (cUJ())
    {
      str = ((c)com.tencent.mm.plugin.music.f.c.b.aP(c.class)).getAccPath();
      if (!bt.isNullOrNil(str))
      {
        AppMethodBeat.o(137165);
        return str;
      }
    }
    ad.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    String str = com.tencent.mm.loader.j.b.aih();
    AppMethodBeat.o(137165);
    return str;
  }
  
  public static void s(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(137167);
    if (cUJ())
    {
      ((c)com.tencent.mm.plugin.music.f.c.b.aP(c.class)).s(paramString, paramArrayOfByte);
      AppMethodBeat.o(137167);
      return;
    }
    ad.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    AppMethodBeat.o(137167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.e
 * JD-Core Version:    0.7.0.1
 */