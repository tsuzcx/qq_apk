package com.tencent.mm.plugin.music.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.i;
import com.tencent.mm.plugin.music.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class e
{
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(137170);
    if (dvQ())
    {
      ((c)com.tencent.mm.plugin.music.f.c.b.aQ(c.class)).a(paramString, parama);
      AppMethodBeat.o(137170);
      return;
    }
    ae.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    AppMethodBeat.o(137170);
  }
  
  public static i atv(String paramString)
  {
    AppMethodBeat.i(137166);
    if (dvQ())
    {
      paramString = ((c)com.tencent.mm.plugin.music.f.c.b.aQ(c.class)).atv(paramString);
      AppMethodBeat.o(137166);
      return paramString;
    }
    ae.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    AppMethodBeat.o(137166);
    return null;
  }
  
  public static a atz(String paramString)
  {
    AppMethodBeat.i(137169);
    if (dvQ())
    {
      paramString = ((c)com.tencent.mm.plugin.music.f.c.b.aQ(c.class)).atz(paramString);
      AppMethodBeat.o(137169);
      return paramString;
    }
    ae.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    paramString = new a();
    AppMethodBeat.o(137169);
    return paramString;
  }
  
  public static boolean dvQ()
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
  
  public static void eD(String paramString, int paramInt)
  {
    AppMethodBeat.i(137168);
    if (dvQ()) {
      ((c)com.tencent.mm.plugin.music.f.c.b.aQ(c.class)).eD(paramString, paramInt);
    }
    AppMethodBeat.o(137168);
  }
  
  public static String getAccPath()
  {
    AppMethodBeat.i(137165);
    if (dvQ())
    {
      str = ((c)com.tencent.mm.plugin.music.f.c.b.aQ(c.class)).getAccPath();
      if (!bu.isNullOrNil(str))
      {
        AppMethodBeat.o(137165);
        return str;
      }
    }
    ae.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    String str = com.tencent.mm.loader.j.b.asj();
    AppMethodBeat.o(137165);
    return str;
  }
  
  public static void t(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(137167);
    if (dvQ())
    {
      ((c)com.tencent.mm.plugin.music.f.c.b.aQ(c.class)).t(paramString, paramArrayOfByte);
      AppMethodBeat.o(137167);
      return;
    }
    ae.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    AppMethodBeat.o(137167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.e
 * JD-Core Version:    0.7.0.1
 */