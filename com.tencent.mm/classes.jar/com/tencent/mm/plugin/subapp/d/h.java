package com.tencent.mm.plugin.subapp.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.q;

public final class h
{
  static void YD(String paramString)
  {
    AppMethodBeat.i(28967);
    d.ghG().YD(cN(paramString, false));
    AppMethodBeat.o(28967);
  }
  
  public static boolean YH(String paramString)
  {
    AppMethodBeat.i(28965);
    if (paramString == null)
    {
      AppMethodBeat.o(28965);
      return false;
    }
    g localg = d.ghG().bdT(paramString);
    if (localg == null)
    {
      Log.d("MicroMsg.VoiceRemindLogic", "cancel null record : ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(28965);
      return true;
    }
    Log.d("MicroMsg.VoiceRemindLogic", "cancel record : " + paramString + " LocalId:" + localg.field_msglocalid);
    if (localg.field_msglocalid != 0)
    {
      bh.beI();
      com.tencent.mm.model.c.bbO().Or(localg.field_msglocalid);
    }
    boolean bool = bdP(paramString);
    AppMethodBeat.o(28965);
    return bool;
  }
  
  public static boolean Yb(String paramString)
  {
    AppMethodBeat.i(28968);
    if (paramString == null)
    {
      AppMethodBeat.o(28968);
      return false;
    }
    g localg = d.ghG().bdT(paramString);
    if (localg == null)
    {
      Log.e("MicroMsg.VoiceRemindLogic", "Set error failed file:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(28968);
      return false;
    }
    localg.field_status = 98;
    localg.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
    localg.cUP = 320;
    boolean bool = a(localg);
    Log.d("MicroMsg.VoiceRemindLogic", "setError file:" + paramString + " msgid:" + localg.field_msglocalid + " old stat:" + localg.field_status);
    if ((localg.field_msglocalid == 0) || (Util.isNullOrNil(localg.field_user)))
    {
      Log.e("MicroMsg.VoiceRemindLogic", "setError failed msg id:" + localg.field_msglocalid + " user:" + localg.field_user);
      AppMethodBeat.o(28968);
      return bool;
    }
    bh.beI();
    paramString = com.tencent.mm.model.c.bbO().Oq(localg.field_msglocalid);
    paramString.setMsgId(localg.field_msglocalid);
    paramString.setStatus(5);
    paramString.Jm(localg.field_user);
    paramString.setContent(f.a(localg.field_human, -1L, true));
    bh.beI();
    com.tencent.mm.model.c.bbO().a(paramString.field_msgId, paramString);
    AppMethodBeat.o(28968);
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
    if (paramg.cUP == -1)
    {
      AppMethodBeat.o(28969);
      return false;
    }
    boolean bool = d.ghG().a(paramg.field_filename, paramg);
    AppMethodBeat.o(28969);
    return bool;
  }
  
  private static boolean bdP(String paramString)
  {
    AppMethodBeat.i(28966);
    if (paramString == null)
    {
      AppMethodBeat.o(28966);
      return false;
    }
    d.ghG().ho(paramString);
    YD(paramString);
    boolean bool = new q(cN(paramString, false)).cFq();
    AppMethodBeat.o(28966);
    return bool;
  }
  
  public static c bdQ(String paramString)
  {
    AppMethodBeat.i(28970);
    paramString = d.ghG().bdS(cN(paramString, false));
    AppMethodBeat.o(28970);
    return paramString;
  }
  
  public static String cN(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(28964);
    bh.beI();
    paramString = FilePathGenerator.genPath(com.tencent.mm.model.c.bbZ(), "recbiz_", paramString, ".rec", 2);
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
    if (new q(paramString).ifE())
    {
      AppMethodBeat.o(28964);
      return paramString;
    }
    AppMethodBeat.o(28964);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.d.h
 * JD-Core Version:    0.7.0.1
 */