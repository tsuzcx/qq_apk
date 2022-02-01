package com.tencent.mm.plugin.subapp.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.storage.bo;
import com.tencent.mm.vfs.e;

public final class h
{
  static void ED(String paramString)
  {
    AppMethodBeat.i(28967);
    d.eaJ().ED(bW(paramString, false));
    AppMethodBeat.o(28967);
  }
  
  public static boolean EH(String paramString)
  {
    AppMethodBeat.i(28965);
    if (paramString == null)
    {
      AppMethodBeat.o(28965);
      return false;
    }
    g localg = d.eaJ().axx(paramString);
    if (localg == null)
    {
      ac.d("MicroMsg.VoiceRemindLogic", "cancel null record : ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(28965);
      return true;
    }
    ac.d("MicroMsg.VoiceRemindLogic", "cancel record : " + paramString + " LocalId:" + localg.field_msglocalid);
    if (localg.field_msglocalid != 0)
    {
      az.ayM();
      com.tencent.mm.model.c.awD().vQ(localg.field_msglocalid);
    }
    boolean bool = axt(paramString);
    AppMethodBeat.o(28965);
    return bool;
  }
  
  public static boolean Ea(String paramString)
  {
    AppMethodBeat.i(28968);
    if (paramString == null)
    {
      AppMethodBeat.o(28968);
      return false;
    }
    g localg = d.eaJ().axx(paramString);
    if (localg == null)
    {
      ac.e("MicroMsg.VoiceRemindLogic", "Set error failed file:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(28968);
      return false;
    }
    localg.field_status = 98;
    localg.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
    localg.drx = 320;
    boolean bool = a(localg);
    ac.d("MicroMsg.VoiceRemindLogic", "setError file:" + paramString + " msgid:" + localg.field_msglocalid + " old stat:" + localg.field_status);
    if ((localg.field_msglocalid == 0) || (bs.isNullOrNil(localg.field_user)))
    {
      ac.e("MicroMsg.VoiceRemindLogic", "setError failed msg id:" + localg.field_msglocalid + " user:" + localg.field_user);
      AppMethodBeat.o(28968);
      return bool;
    }
    az.ayM();
    paramString = com.tencent.mm.model.c.awD().vP(localg.field_msglocalid);
    paramString.setMsgId(localg.field_msglocalid);
    paramString.setStatus(5);
    paramString.re(localg.field_user);
    paramString.setContent(f.b(localg.field_human, -1L, true));
    az.ayM();
    com.tencent.mm.model.c.awD().a(paramString.field_msgId, paramString);
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
    if (paramg.drx == -1)
    {
      AppMethodBeat.o(28969);
      return false;
    }
    boolean bool = d.eaJ().a(paramg.field_filename, paramg);
    AppMethodBeat.o(28969);
    return bool;
  }
  
  private static boolean axt(String paramString)
  {
    AppMethodBeat.i(28966);
    if (paramString == null)
    {
      AppMethodBeat.o(28966);
      return false;
    }
    d.eaJ().zB(paramString);
    ED(paramString);
    boolean bool = new e(bW(paramString, false)).delete();
    AppMethodBeat.o(28966);
    return bool;
  }
  
  public static c axu(String paramString)
  {
    AppMethodBeat.i(28970);
    paramString = d.eaJ().axw(bW(paramString, false));
    AppMethodBeat.o(28970);
    return paramString;
  }
  
  public static String bW(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(28964);
    az.ayM();
    paramString = l.d(com.tencent.mm.model.c.awO(), "recbiz_", paramString, ".rec", 2);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(28964);
      return null;
    }
    if (paramBoolean)
    {
      AppMethodBeat.o(28964);
      return paramString;
    }
    if (new e(paramString).exists())
    {
      AppMethodBeat.o(28964);
      return paramString;
    }
    AppMethodBeat.o(28964);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.d.h
 * JD-Core Version:    0.7.0.1
 */