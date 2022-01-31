package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public final class g
{
  private static HashMap<String, g> vne;
  public long startTime;
  public String url;
  public long vmX;
  public long vmY;
  public long vmZ;
  public long vna;
  public long vnb;
  public long vnc;
  public long vnd;
  
  static
  {
    AppMethodBeat.i(8719);
    vne = new HashMap();
    AppMethodBeat.o(8719);
  }
  
  private static Bundle a(int paramInt, String paramString, long paramLong)
  {
    AppMethodBeat.i(8718);
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", paramInt);
    localBundle.putString("url", paramString);
    localBundle.putLong("time", paramLong);
    AppMethodBeat.o(8718);
    return localBundle;
  }
  
  public static void aO(String paramString, long paramLong)
  {
    AppMethodBeat.i(8710);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(8710);
      return;
    }
    if (ah.dsW())
    {
      aiO(paramString).startTime = paramLong;
      AppMethodBeat.o(8710);
      return;
    }
    f.a("com.tencent.mm:tools", a(1, paramString, paramLong), g.a.class, null);
    AppMethodBeat.o(8710);
  }
  
  public static void aP(String paramString, long paramLong)
  {
    AppMethodBeat.i(8711);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(8711);
      return;
    }
    if (ah.dsW())
    {
      aiO(paramString).vmX = paramLong;
      AppMethodBeat.o(8711);
      return;
    }
    f.a("com.tencent.mm:tools", a(2, paramString, paramLong), g.a.class, null);
    AppMethodBeat.o(8711);
  }
  
  public static void aQ(String paramString, long paramLong)
  {
    AppMethodBeat.i(8712);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(8712);
      return;
    }
    if (ah.dsW())
    {
      aiO(paramString).vmY = paramLong;
      AppMethodBeat.o(8712);
      return;
    }
    f.a("com.tencent.mm:tools", a(3, paramString, paramLong), g.a.class, null);
    AppMethodBeat.o(8712);
  }
  
  public static void aR(String paramString, long paramLong)
  {
    AppMethodBeat.i(8713);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(8713);
      return;
    }
    if (ah.dsW())
    {
      aiO(paramString).vmZ = paramLong;
      AppMethodBeat.o(8713);
      return;
    }
    f.a("com.tencent.mm:tools", a(4, paramString, paramLong), g.a.class, null);
    AppMethodBeat.o(8713);
  }
  
  public static void aS(String paramString, long paramLong)
  {
    AppMethodBeat.i(8714);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(8714);
      return;
    }
    if (ah.dsW())
    {
      aiO(paramString).vna = paramLong;
      AppMethodBeat.o(8714);
      return;
    }
    f.a("com.tencent.mm:tools", a(5, paramString, paramLong), g.a.class, null);
    AppMethodBeat.o(8714);
  }
  
  public static void aT(String paramString, long paramLong)
  {
    AppMethodBeat.i(8715);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(8715);
      return;
    }
    if (ah.dsW())
    {
      aiO(paramString).vnb = paramLong;
      AppMethodBeat.o(8715);
      return;
    }
    f.a("com.tencent.mm:tools", a(6, paramString, paramLong), g.a.class, null);
    AppMethodBeat.o(8715);
  }
  
  public static void aU(String paramString, long paramLong)
  {
    AppMethodBeat.i(8716);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(8716);
      return;
    }
    if (ah.dsW())
    {
      aiO(paramString).vnc = paramLong;
      AppMethodBeat.o(8716);
      return;
    }
    f.a("com.tencent.mm:tools", a(7, paramString, paramLong), g.a.class, null);
    AppMethodBeat.o(8716);
  }
  
  public static void aV(String paramString, long paramLong)
  {
    AppMethodBeat.i(8717);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(8717);
      return;
    }
    if (ah.dsW())
    {
      aiO(paramString).vnd = paramLong;
      AppMethodBeat.o(8717);
      return;
    }
    f.a("com.tencent.mm:tools", a(8, paramString, paramLong), g.a.class, null);
    AppMethodBeat.o(8717);
  }
  
  public static g aiN(String paramString)
  {
    AppMethodBeat.i(8707);
    if (vne.containsKey(paramString)) {
      vne.remove(paramString);
    }
    g localg = new g();
    localg.url = paramString;
    vne.put(paramString, localg);
    AppMethodBeat.o(8707);
    return localg;
  }
  
  public static g aiO(String paramString)
  {
    AppMethodBeat.i(8708);
    if (vne.containsKey(paramString))
    {
      paramString = (g)vne.get(paramString);
      AppMethodBeat.o(8708);
      return paramString;
    }
    g localg = new g();
    localg.url = paramString;
    vne.put(paramString, localg);
    AppMethodBeat.o(8708);
    return localg;
  }
  
  public static g aiP(String paramString)
  {
    AppMethodBeat.i(8709);
    paramString = (g)vne.remove(paramString);
    AppMethodBeat.o(8709);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.g
 * JD-Core Version:    0.7.0.1
 */