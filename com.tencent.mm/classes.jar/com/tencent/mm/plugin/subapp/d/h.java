package com.tencent.mm.plugin.subapp.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.storage.bu;
import com.tencent.mm.vfs.e;

public final class h
{
  static void HS(String paramString)
  {
    AppMethodBeat.i(28967);
    d.emZ().HS(cd(paramString, false));
    AppMethodBeat.o(28967);
  }
  
  public static boolean HW(String paramString)
  {
    AppMethodBeat.i(28965);
    if (paramString == null)
    {
      AppMethodBeat.o(28965);
      return false;
    }
    g localg = d.emZ().aCB(paramString);
    if (localg == null)
    {
      ad.d("MicroMsg.VoiceRemindLogic", "cancel null record : ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(28965);
      return true;
    }
    ad.d("MicroMsg.VoiceRemindLogic", "cancel record : " + paramString + " LocalId:" + localg.field_msglocalid);
    if (localg.field_msglocalid != 0)
    {
      ba.aBQ();
      com.tencent.mm.model.c.azs().xZ(localg.field_msglocalid);
    }
    boolean bool = aCx(paramString);
    AppMethodBeat.o(28965);
    return bool;
  }
  
  public static boolean Hp(String paramString)
  {
    AppMethodBeat.i(28968);
    if (paramString == null)
    {
      AppMethodBeat.o(28968);
      return false;
    }
    g localg = d.emZ().aCB(paramString);
    if (localg == null)
    {
      ad.e("MicroMsg.VoiceRemindLogic", "Set error failed file:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(28968);
      return false;
    }
    localg.field_status = 98;
    localg.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
    localg.dDp = 320;
    boolean bool = a(localg);
    ad.d("MicroMsg.VoiceRemindLogic", "setError file:" + paramString + " msgid:" + localg.field_msglocalid + " old stat:" + localg.field_status);
    if ((localg.field_msglocalid == 0) || (bt.isNullOrNil(localg.field_user)))
    {
      ad.e("MicroMsg.VoiceRemindLogic", "setError failed msg id:" + localg.field_msglocalid + " user:" + localg.field_user);
      AppMethodBeat.o(28968);
      return bool;
    }
    ba.aBQ();
    paramString = com.tencent.mm.model.c.azs().xY(localg.field_msglocalid);
    paramString.setMsgId(localg.field_msglocalid);
    paramString.setStatus(5);
    paramString.tN(localg.field_user);
    paramString.setContent(f.b(localg.field_human, -1L, true));
    ba.aBQ();
    com.tencent.mm.model.c.azs().a(paramString.field_msgId, paramString);
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
    if (paramg.dDp == -1)
    {
      AppMethodBeat.o(28969);
      return false;
    }
    boolean bool = d.emZ().a(paramg.field_filename, paramg);
    AppMethodBeat.o(28969);
    return bool;
  }
  
  private static boolean aCx(String paramString)
  {
    AppMethodBeat.i(28966);
    if (paramString == null)
    {
      AppMethodBeat.o(28966);
      return false;
    }
    d.emZ().CA(paramString);
    HS(paramString);
    boolean bool = new e(cd(paramString, false)).delete();
    AppMethodBeat.o(28966);
    return bool;
  }
  
  public static c aCy(String paramString)
  {
    AppMethodBeat.i(28970);
    paramString = d.emZ().aCA(cd(paramString, false));
    AppMethodBeat.o(28970);
    return paramString;
  }
  
  public static String cd(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(28964);
    ba.aBQ();
    paramString = m.d(com.tencent.mm.model.c.azD(), "recbiz_", paramString, ".rec", 2);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.d.h
 * JD-Core Version:    0.7.0.1
 */