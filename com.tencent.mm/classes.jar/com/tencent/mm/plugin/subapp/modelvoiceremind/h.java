package com.tencent.mm.plugin.subapp.modelvoiceremind;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.u;

public final class h
{
  static void QI(String paramString)
  {
    AppMethodBeat.i(28967);
    d.hAZ().QI(dt(paramString, false));
    AppMethodBeat.o(28967);
  }
  
  public static boolean QM(String paramString)
  {
    AppMethodBeat.i(28965);
    if (paramString == null)
    {
      AppMethodBeat.o(28965);
      return false;
    }
    g localg = d.hAZ().bcF(paramString);
    if (localg == null)
    {
      Log.d("MicroMsg.VoiceRemindLogic", "cancel null record : ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(28965);
      return true;
    }
    Log.d("MicroMsg.VoiceRemindLogic", "cancel record : " + paramString + " LocalId:" + localg.field_msglocalid);
    if (localg.field_msglocalid != 0)
    {
      bh.bCz();
      com.tencent.mm.model.c.bzD().sm(localg.field_msglocalid);
    }
    boolean bool = bcB(paramString);
    AppMethodBeat.o(28965);
    return bool;
  }
  
  public static boolean Qf(String paramString)
  {
    AppMethodBeat.i(28968);
    if (paramString == null)
    {
      AppMethodBeat.o(28968);
      return false;
    }
    g localg = d.hAZ().bcF(paramString);
    if (localg == null)
    {
      Log.e("MicroMsg.VoiceRemindLogic", "Set error failed file:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(28968);
      return false;
    }
    localg.field_status = 98;
    localg.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
    localg.eQp = 320;
    boolean bool = a(localg);
    Log.d("MicroMsg.VoiceRemindLogic", "setError file:" + paramString + " msgid:" + localg.field_msglocalid + " old stat:" + localg.field_status);
    if ((localg.field_msglocalid == 0) || (Util.isNullOrNil(localg.field_user)))
    {
      Log.e("MicroMsg.VoiceRemindLogic", "setError failed msg id:" + localg.field_msglocalid + " user:" + localg.field_user);
      AppMethodBeat.o(28968);
      return bool;
    }
    bh.bCz();
    cc localcc = com.tencent.mm.model.c.bzD().sl(localg.field_msglocalid);
    paramString = localcc;
    if (localcc == null)
    {
      Log.e("MicroMsg.VoiceRemindLogic", "setError error, cannot get the msgInfo, create a default one");
      paramString = new cc();
    }
    paramString.setMsgId(localg.field_msglocalid);
    paramString.setStatus(5);
    paramString.BS(localg.field_user);
    paramString.setContent(f.a(localg.field_human, -1L, true));
    bh.bCz();
    com.tencent.mm.model.c.bzD().a(paramString.field_msgId, paramString);
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
    if (paramg.eQp == -1)
    {
      AppMethodBeat.o(28969);
      return false;
    }
    boolean bool = d.hAZ().a(paramg.field_filename, paramg);
    AppMethodBeat.o(28969);
    return bool;
  }
  
  private static boolean bcB(String paramString)
  {
    AppMethodBeat.i(28966);
    if (paramString == null)
    {
      AppMethodBeat.o(28966);
      return false;
    }
    if (!d.hAZ().iP(paramString))
    {
      AppMethodBeat.o(28966);
      return false;
    }
    QI(paramString);
    boolean bool = new u(dt(paramString, false)).diJ();
    AppMethodBeat.o(28966);
    return bool;
  }
  
  public static c bcC(String paramString)
  {
    AppMethodBeat.i(28970);
    paramString = d.hAZ().bcE(dt(paramString, false));
    AppMethodBeat.o(28970);
    return paramString;
  }
  
  public static String dt(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(28964);
    bh.bCz();
    paramString = FilePathGenerator.genPath(com.tencent.mm.model.c.bzO(), "recbiz_", paramString, ".rec", 2);
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
    if (new u(paramString).jKS())
    {
      AppMethodBeat.o(28964);
      return paramString;
    }
    AppMethodBeat.o(28964);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.modelvoiceremind.h
 * JD-Core Version:    0.7.0.1
 */