package com.tencent.mm.plugin.subapp.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.storage.bl;
import com.tencent.mm.vfs.e;

public final class h
{
  public static boolean AC(String paramString)
  {
    AppMethodBeat.i(28965);
    if (paramString == null)
    {
      AppMethodBeat.o(28965);
      return false;
    }
    g localg = d.dMj().aso(paramString);
    if (localg == null)
    {
      ad.d("MicroMsg.VoiceRemindLogic", "cancel null record : ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(28965);
      return true;
    }
    ad.d("MicroMsg.VoiceRemindLogic", "cancel record : " + paramString + " LocalId:" + localg.field_msglocalid);
    if (localg.field_msglocalid != 0)
    {
      az.arV();
      com.tencent.mm.model.c.apO().rn(localg.field_msglocalid);
    }
    boolean bool = ask(paramString);
    AppMethodBeat.o(28965);
    return bool;
  }
  
  static void Ay(String paramString)
  {
    AppMethodBeat.i(28967);
    d.dMj().Ay(bP(paramString, false));
    AppMethodBeat.o(28967);
  }
  
  static boolean a(g paramg)
  {
    AppMethodBeat.i(28969);
    if (paramg == null)
    {
      AppMethodBeat.o(28969);
      return false;
    }
    if (paramg.dtM == -1)
    {
      AppMethodBeat.o(28969);
      return false;
    }
    boolean bool = d.dMj().a(paramg.field_filename, paramg);
    AppMethodBeat.o(28969);
    return bool;
  }
  
  private static boolean ask(String paramString)
  {
    AppMethodBeat.i(28966);
    if (paramString == null)
    {
      AppMethodBeat.o(28966);
      return false;
    }
    d.dMj().vv(paramString);
    Ay(paramString);
    boolean bool = new e(bP(paramString, false)).delete();
    AppMethodBeat.o(28966);
    return bool;
  }
  
  public static c asl(String paramString)
  {
    AppMethodBeat.i(28970);
    paramString = d.dMj().asn(bP(paramString, false));
    AppMethodBeat.o(28970);
    return paramString;
  }
  
  public static String bP(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(28964);
    az.arV();
    paramString = l.d(com.tencent.mm.model.c.apZ(), "recbiz_", paramString, ".rec", 2);
    if (bt.isNullOrNil(paramString))
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
  
  public static boolean zV(String paramString)
  {
    AppMethodBeat.i(28968);
    if (paramString == null)
    {
      AppMethodBeat.o(28968);
      return false;
    }
    g localg = d.dMj().aso(paramString);
    if (localg == null)
    {
      ad.e("MicroMsg.VoiceRemindLogic", "Set error failed file:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(28968);
      return false;
    }
    localg.field_status = 98;
    localg.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
    localg.dtM = 320;
    boolean bool = a(localg);
    ad.d("MicroMsg.VoiceRemindLogic", "setError file:" + paramString + " msgid:" + localg.field_msglocalid + " old stat:" + localg.field_status);
    if ((localg.field_msglocalid == 0) || (bt.isNullOrNil(localg.field_user)))
    {
      ad.e("MicroMsg.VoiceRemindLogic", "setError failed msg id:" + localg.field_msglocalid + " user:" + localg.field_user);
      AppMethodBeat.o(28968);
      return bool;
    }
    az.arV();
    paramString = com.tencent.mm.model.c.apO().rm(localg.field_msglocalid);
    paramString.setMsgId(localg.field_msglocalid);
    paramString.setStatus(5);
    paramString.nY(localg.field_user);
    paramString.setContent(f.b(localg.field_human, -1L, true));
    az.arV();
    com.tencent.mm.model.c.apO().a(paramString.field_msgId, paramString);
    AppMethodBeat.o(28968);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.d.h
 * JD-Core Version:    0.7.0.1
 */