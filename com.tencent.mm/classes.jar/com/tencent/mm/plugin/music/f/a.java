package com.tencent.mm.plugin.music.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.km;
import com.tencent.mm.aw.c;
import com.tencent.mm.aw.f;

public final class a
{
  static km LOr;
  public static String LOs = "1.0";
  public static String LOt = "2.0";
  static String rate = "1.0";
  static String scene = LOs;
  
  private static String M(String[] paramArrayOfString)
  {
    AppMethodBeat.i(270849);
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < 5)
    {
      localStringBuffer.append(paramArrayOfString[i]);
      if (i != 4) {
        localStringBuffer.append("|");
      }
      i += 1;
    }
    paramArrayOfString = localStringBuffer.toString();
    AppMethodBeat.o(270849);
    return paramArrayOfString;
  }
  
  public static void X(f paramf)
  {
    AppMethodBeat.i(270832);
    if (paramf == null)
    {
      AppMethodBeat.o(270832);
      return;
    }
    km localkm = new km();
    LOr = localkm;
    localkm.ijk = localkm.F("SessionId", String.valueOf(System.currentTimeMillis()), true);
    localkm = LOr;
    localkm.iWV = localkm.F("DataUrl", paramf.oOB, true);
    localkm = LOr;
    localkm.iWT = localkm.F("Singer", paramf.oOy, true);
    localkm = LOr;
    localkm.iWS = localkm.F("SongName", paramf.oOx, true);
    localkm = LOr;
    localkm.iWU = localkm.F("WebUrl", paramf.oOD, true);
    localkm = LOr;
    localkm.ilL = localkm.F("Appid", paramf.oOI, true);
    AppMethodBeat.o(270832);
  }
  
  private static void cIX()
  {
    AppMethodBeat.i(270848);
    if (LOr == null)
    {
      AppMethodBeat.o(270848);
      return;
    }
    LOr.bMH();
    AppMethodBeat.o(270848);
  }
  
  public static void goE()
  {
    AppMethodBeat.i(270834);
    if (LOr == null)
    {
      AppMethodBeat.o(270834);
      return;
    }
    String str1 = String.valueOf(Long.valueOf(System.currentTimeMillis()));
    String str2 = scene;
    String str3 = rate;
    LOr.sS(M(new String[] { str1, str2, "preparing", str3, "0" }));
    cIX();
    AppMethodBeat.o(270834);
  }
  
  public static void goF()
  {
    AppMethodBeat.i(270837);
    if (LOr == null)
    {
      AppMethodBeat.o(270837);
      return;
    }
    String str1 = String.valueOf(Long.valueOf(System.currentTimeMillis()));
    String str2 = scene;
    String str3 = rate;
    LOr.sS(M(new String[] { str1, str2, "readyToPlay", str3, "0" }));
    cIX();
    AppMethodBeat.o(270837);
  }
  
  public static void goG()
  {
    AppMethodBeat.i(270840);
    if (LOr == null)
    {
      AppMethodBeat.o(270840);
      return;
    }
    LOr.iWW = com.tencent.mm.aw.a.bLo().cam;
    String str1 = String.valueOf(Long.valueOf(System.currentTimeMillis()));
    String str2 = scene;
    String str3 = rate;
    LOr.sS(M(new String[] { str1, str2, "playing", str3, "0" }));
    cIX();
    AppMethodBeat.o(270840);
  }
  
  public static void goH()
  {
    AppMethodBeat.i(270844);
    if (LOr == null)
    {
      AppMethodBeat.o(270844);
      return;
    }
    String str1 = String.valueOf(Long.valueOf(System.currentTimeMillis()));
    String str2 = scene;
    String str3 = rate;
    int i = com.tencent.mm.aw.a.bLo().mPosition;
    LOr.sS(M(new String[] { str1, str2, "buffering", str3, String.valueOf(i) }));
    cIX();
    AppMethodBeat.o(270844);
  }
  
  public static void goI()
  {
    AppMethodBeat.i(270845);
    if (LOr == null)
    {
      AppMethodBeat.o(270845);
      return;
    }
    String str1 = String.valueOf(Long.valueOf(System.currentTimeMillis()));
    String str2 = scene;
    String str3 = rate;
    int i = com.tencent.mm.aw.a.bLo().mPosition;
    LOr.sS(M(new String[] { str1, str2, "seeking", str3, String.valueOf(i) }));
    cIX();
    AppMethodBeat.o(270845);
  }
  
  public static void goJ()
  {
    AppMethodBeat.i(270847);
    if (LOr == null)
    {
      AppMethodBeat.o(270847);
      return;
    }
    String str1 = String.valueOf(Long.valueOf(System.currentTimeMillis()));
    String str2 = scene;
    String str3 = rate;
    int i = com.tencent.mm.aw.a.bLo().mPosition;
    LOr.sS(M(new String[] { str1, str2, "seekEnd", str3, String.valueOf(i) }));
    cIX();
    AppMethodBeat.o(270847);
  }
  
  public static void onPaused()
  {
    AppMethodBeat.i(270842);
    if (LOr == null)
    {
      AppMethodBeat.o(270842);
      return;
    }
    String str1 = String.valueOf(Long.valueOf(System.currentTimeMillis()));
    String str2 = scene;
    String str3 = rate;
    int i = com.tencent.mm.aw.a.bLo().mPosition;
    LOr.sS(M(new String[] { str1, str2, "paused", str3, String.valueOf(i) }));
    cIX();
    AppMethodBeat.o(270842);
  }
  
  public static void onStop()
  {
    AppMethodBeat.i(270843);
    if (LOr == null)
    {
      AppMethodBeat.o(270843);
      return;
    }
    String str1 = String.valueOf(Long.valueOf(System.currentTimeMillis()));
    String str2 = scene;
    String str3 = rate;
    int i = com.tencent.mm.aw.a.bLo().mPosition;
    LOr.sS(M(new String[] { str1, str2, "end/stop", str3, String.valueOf(i) }));
    cIX();
    AppMethodBeat.o(270843);
  }
  
  public static void setScene(String paramString)
  {
    scene = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.a
 * JD-Core Version:    0.7.0.1
 */