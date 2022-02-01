package com.tencent.mm.plugin.music.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.j;
import com.tencent.mm.plugin.music.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class e
{
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(137170);
    if (etK())
    {
      ((c)com.tencent.mm.plugin.music.f.c.b.aS(c.class)).a(paramString, parama);
      AppMethodBeat.o(137170);
      return;
    }
    Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    AppMethodBeat.o(137170);
  }
  
  public static j aHs(String paramString)
  {
    AppMethodBeat.i(137166);
    if (etK())
    {
      paramString = ((c)com.tencent.mm.plugin.music.f.c.b.aS(c.class)).aHs(paramString);
      AppMethodBeat.o(137166);
      return paramString;
    }
    Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    AppMethodBeat.o(137166);
    return null;
  }
  
  public static a aHw(String paramString)
  {
    AppMethodBeat.i(137169);
    if (etK())
    {
      paramString = ((c)com.tencent.mm.plugin.music.f.c.b.aS(c.class)).aHw(paramString);
      AppMethodBeat.o(137169);
      return paramString;
    }
    Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    paramString = new a();
    AppMethodBeat.o(137169);
    return paramString;
  }
  
  public static void eS(String paramString, int paramInt)
  {
    AppMethodBeat.i(137168);
    if (etK()) {
      ((c)com.tencent.mm.plugin.music.f.c.b.aS(c.class)).eS(paramString, paramInt);
    }
    AppMethodBeat.o(137168);
  }
  
  public static boolean etK()
  {
    AppMethodBeat.i(137164);
    if (com.tencent.mm.plugin.music.f.c.b.aS(c.class) != null)
    {
      AppMethodBeat.o(137164);
      return true;
    }
    AppMethodBeat.o(137164);
    return false;
  }
  
  public static String getAccPath()
  {
    AppMethodBeat.i(137165);
    if (etK())
    {
      str = ((c)com.tencent.mm.plugin.music.f.c.b.aS(c.class)).getAccPath();
      if (!Util.isNullOrNil(str))
      {
        AppMethodBeat.o(137165);
        return str;
      }
    }
    Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    String str = com.tencent.mm.loader.j.b.aKJ();
    AppMethodBeat.o(137165);
    return str;
  }
  
  public static void t(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(137167);
    if (etK())
    {
      ((c)com.tencent.mm.plugin.music.f.c.b.aS(c.class)).t(paramString, paramArrayOfByte);
      AppMethodBeat.o(137167);
      return;
    }
    Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    AppMethodBeat.o(137167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.e
 * JD-Core Version:    0.7.0.1
 */