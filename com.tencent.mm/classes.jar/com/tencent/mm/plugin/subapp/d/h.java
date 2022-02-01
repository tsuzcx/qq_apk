package com.tencent.mm.plugin.subapp.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.o;

public final class h
{
  public static boolean QE(String paramString)
  {
    AppMethodBeat.i(28968);
    if (paramString == null)
    {
      AppMethodBeat.o(28968);
      return false;
    }
    g localg = d.fth().aSP(paramString);
    if (localg == null)
    {
      Log.e("MicroMsg.VoiceRemindLogic", "Set error failed file:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(28968);
      return false;
    }
    localg.field_status = 98;
    localg.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
    localg.cSx = 320;
    boolean bool = a(localg);
    Log.d("MicroMsg.VoiceRemindLogic", "setError file:" + paramString + " msgid:" + localg.field_msglocalid + " old stat:" + localg.field_status);
    if ((localg.field_msglocalid == 0) || (Util.isNullOrNil(localg.field_user)))
    {
      Log.e("MicroMsg.VoiceRemindLogic", "setError failed msg id:" + localg.field_msglocalid + " user:" + localg.field_user);
      AppMethodBeat.o(28968);
      return bool;
    }
    bg.aVF();
    paramString = com.tencent.mm.model.c.aSQ().Hb(localg.field_msglocalid);
    paramString.setMsgId(localg.field_msglocalid);
    paramString.setStatus(5);
    paramString.Cy(localg.field_user);
    paramString.setContent(f.b(localg.field_human, -1L, true));
    bg.aVF();
    com.tencent.mm.model.c.aSQ().a(paramString.field_msgId, paramString);
    AppMethodBeat.o(28968);
    return bool;
  }
  
  static void Rg(String paramString)
  {
    AppMethodBeat.i(28967);
    d.fth().Rg(cz(paramString, false));
    AppMethodBeat.o(28967);
  }
  
  public static boolean Rk(String paramString)
  {
    AppMethodBeat.i(28965);
    if (paramString == null)
    {
      AppMethodBeat.o(28965);
      return false;
    }
    g localg = d.fth().aSP(paramString);
    if (localg == null)
    {
      Log.d("MicroMsg.VoiceRemindLogic", "cancel null record : ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(28965);
      return true;
    }
    Log.d("MicroMsg.VoiceRemindLogic", "cancel record : " + paramString + " LocalId:" + localg.field_msglocalid);
    if (localg.field_msglocalid != 0)
    {
      bg.aVF();
      com.tencent.mm.model.c.aSQ().Hc(localg.field_msglocalid);
    }
    boolean bool = aSL(paramString);
    AppMethodBeat.o(28965);
    return bool;
  }
  
  static boolean a(g paramg)
  {
    AppMethodBeat.i(28969);
    if (paramg == null)
    {
      AppMethodBeat.o(28969);
      return false;
    }
    if (paramg.cSx == -1)
    {
      AppMethodBeat.o(28969);
      return false;
    }
    boolean bool = d.fth().a(paramg.field_filename, paramg);
    AppMethodBeat.o(28969);
    return bool;
  }
  
  private static boolean aSL(String paramString)
  {
    AppMethodBeat.i(28966);
    if (paramString == null)
    {
      AppMethodBeat.o(28966);
      return false;
    }
    d.fth().gC(paramString);
    Rg(paramString);
    boolean bool = new o(cz(paramString, false)).delete();
    AppMethodBeat.o(28966);
    return bool;
  }
  
  public static c aSM(String paramString)
  {
    AppMethodBeat.i(28970);
    paramString = d.fth().aSO(cz(paramString, false));
    AppMethodBeat.o(28970);
    return paramString;
  }
  
  public static String cz(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(28964);
    bg.aVF();
    paramString = FilePathGenerator.genPath(com.tencent.mm.model.c.aTb(), "recbiz_", paramString, ".rec", 2);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(28964);
      return null;
    }
    if (paramBoolean)
    {
      AppMethodBeat.o(28964);
      return paramString;
    }
    if (new o(paramString).exists())
    {
      AppMethodBeat.o(28964);
      return paramString;
    }
    AppMethodBeat.o(28964);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.d.h
 * JD-Core Version:    0.7.0.1
 */