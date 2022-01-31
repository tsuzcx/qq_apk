package com.tencent.mm.plugin.music.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.h;
import com.tencent.mm.plugin.music.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class e
{
  public static h Vd(String paramString)
  {
    AppMethodBeat.i(137416);
    if (bVi())
    {
      paramString = ((c)com.tencent.mm.plugin.music.f.c.b.am(c.class)).Vd(paramString);
      AppMethodBeat.o(137416);
      return paramString;
    }
    ab.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    AppMethodBeat.o(137416);
    return null;
  }
  
  public static a Vh(String paramString)
  {
    AppMethodBeat.i(137419);
    if (bVi())
    {
      paramString = ((c)com.tencent.mm.plugin.music.f.c.b.am(c.class)).Vh(paramString);
      AppMethodBeat.o(137419);
      return paramString;
    }
    ab.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    paramString = new a();
    AppMethodBeat.o(137419);
    return paramString;
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(137420);
    if (bVi())
    {
      ((c)com.tencent.mm.plugin.music.f.c.b.am(c.class)).a(paramString, parama);
      AppMethodBeat.o(137420);
      return;
    }
    ab.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    AppMethodBeat.o(137420);
  }
  
  public static boolean bVi()
  {
    AppMethodBeat.i(137414);
    if (com.tencent.mm.plugin.music.f.c.b.am(c.class) != null)
    {
      AppMethodBeat.o(137414);
      return true;
    }
    AppMethodBeat.o(137414);
    return false;
  }
  
  public static void cR(String paramString, int paramInt)
  {
    AppMethodBeat.i(137418);
    if (bVi()) {
      ((c)com.tencent.mm.plugin.music.f.c.b.am(c.class)).cR(paramString, paramInt);
    }
    AppMethodBeat.o(137418);
  }
  
  public static String getAccPath()
  {
    AppMethodBeat.i(137415);
    if (bVi())
    {
      str = ((c)com.tencent.mm.plugin.music.f.c.b.am(c.class)).getAccPath();
      if (!bo.isNullOrNil(str))
      {
        AppMethodBeat.o(137415);
        return str;
      }
    }
    ab.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    String str = com.tencent.mm.loader.j.b.eQz;
    AppMethodBeat.o(137415);
    return str;
  }
  
  public static void y(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(137417);
    if (bVi())
    {
      ((c)com.tencent.mm.plugin.music.f.c.b.am(c.class)).y(paramString, paramArrayOfByte);
      AppMethodBeat.o(137417);
      return;
    }
    ab.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    AppMethodBeat.o(137417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.e
 * JD-Core Version:    0.7.0.1
 */