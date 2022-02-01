package com.tencent.mm.plugin.music.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.i;
import com.tencent.mm.plugin.music.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class e
{
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(137170);
    if (dip())
    {
      ((c)com.tencent.mm.plugin.music.f.c.b.aQ(c.class)).a(paramString, parama);
      AppMethodBeat.o(137170);
      return;
    }
    ac.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    AppMethodBeat.o(137170);
  }
  
  public static i ani(String paramString)
  {
    AppMethodBeat.i(137166);
    if (dip())
    {
      paramString = ((c)com.tencent.mm.plugin.music.f.c.b.aQ(c.class)).ani(paramString);
      AppMethodBeat.o(137166);
      return paramString;
    }
    ac.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    AppMethodBeat.o(137166);
    return null;
  }
  
  public static a anm(String paramString)
  {
    AppMethodBeat.i(137169);
    if (dip())
    {
      paramString = ((c)com.tencent.mm.plugin.music.f.c.b.aQ(c.class)).anm(paramString);
      AppMethodBeat.o(137169);
      return paramString;
    }
    ac.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    paramString = new a();
    AppMethodBeat.o(137169);
    return paramString;
  }
  
  public static boolean dip()
  {
    AppMethodBeat.i(137164);
    if (com.tencent.mm.plugin.music.f.c.b.aQ(c.class) != null)
    {
      AppMethodBeat.o(137164);
      return true;
    }
    AppMethodBeat.o(137164);
    return false;
  }
  
  public static void ed(String paramString, int paramInt)
  {
    AppMethodBeat.i(137168);
    if (dip()) {
      ((c)com.tencent.mm.plugin.music.f.c.b.aQ(c.class)).ed(paramString, paramInt);
    }
    AppMethodBeat.o(137168);
  }
  
  public static String getAccPath()
  {
    AppMethodBeat.i(137165);
    if (dip())
    {
      str = ((c)com.tencent.mm.plugin.music.f.c.b.aQ(c.class)).getAccPath();
      if (!bs.isNullOrNil(str))
      {
        AppMethodBeat.o(137165);
        return str;
      }
    }
    ac.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    String str = com.tencent.mm.loader.j.b.aph();
    AppMethodBeat.o(137165);
    return str;
  }
  
  public static void s(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(137167);
    if (dip())
    {
      ((c)com.tencent.mm.plugin.music.f.c.b.aQ(c.class)).s(paramString, paramArrayOfByte);
      AppMethodBeat.o(137167);
      return;
    }
    ac.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    AppMethodBeat.o(137167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.e
 * JD-Core Version:    0.7.0.1
 */