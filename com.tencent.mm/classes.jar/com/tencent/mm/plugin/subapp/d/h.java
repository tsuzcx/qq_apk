package com.tencent.mm.plugin.subapp.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.storage.bv;

public final class h
{
  public static boolean HR(String paramString)
  {
    AppMethodBeat.i(28968);
    if (paramString == null)
    {
      AppMethodBeat.o(28968);
      return false;
    }
    g localg = d.eqI().aDU(paramString);
    if (localg == null)
    {
      ae.e("MicroMsg.VoiceRemindLogic", "Set error failed file:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(28968);
      return false;
    }
    localg.field_status = 98;
    localg.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
    localg.dEu = 320;
    boolean bool = a(localg);
    ae.d("MicroMsg.VoiceRemindLogic", "setError file:" + paramString + " msgid:" + localg.field_msglocalid + " old stat:" + localg.field_status);
    if ((localg.field_msglocalid == 0) || (bu.isNullOrNil(localg.field_user)))
    {
      ae.e("MicroMsg.VoiceRemindLogic", "setError failed msg id:" + localg.field_msglocalid + " user:" + localg.field_user);
      AppMethodBeat.o(28968);
      return bool;
    }
    bc.aCg();
    paramString = com.tencent.mm.model.c.azI().ys(localg.field_msglocalid);
    paramString.setMsgId(localg.field_msglocalid);
    paramString.setStatus(5);
    paramString.ui(localg.field_user);
    paramString.setContent(f.b(localg.field_human, -1L, true));
    bc.aCg();
    com.tencent.mm.model.c.azI().a(paramString.field_msgId, paramString);
    AppMethodBeat.o(28968);
    return bool;
  }
  
  static void Iu(String paramString)
  {
    AppMethodBeat.i(28967);
    d.eqI().Iu(ch(paramString, false));
    AppMethodBeat.o(28967);
  }
  
  public static boolean Iy(String paramString)
  {
    AppMethodBeat.i(28965);
    if (paramString == null)
    {
      AppMethodBeat.o(28965);
      return false;
    }
    g localg = d.eqI().aDU(paramString);
    if (localg == null)
    {
      ae.d("MicroMsg.VoiceRemindLogic", "cancel null record : ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(28965);
      return true;
    }
    ae.d("MicroMsg.VoiceRemindLogic", "cancel record : " + paramString + " LocalId:" + localg.field_msglocalid);
    if (localg.field_msglocalid != 0)
    {
      bc.aCg();
      com.tencent.mm.model.c.azI().yt(localg.field_msglocalid);
    }
    boolean bool = aDQ(paramString);
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
    if (paramg.dEu == -1)
    {
      AppMethodBeat.o(28969);
      return false;
    }
    boolean bool = d.eqI().a(paramg.field_filename, paramg);
    AppMethodBeat.o(28969);
    return bool;
  }
  
  private static boolean aDQ(String paramString)
  {
    AppMethodBeat.i(28966);
    if (paramString == null)
    {
      AppMethodBeat.o(28966);
      return false;
    }
    d.eqI().Dc(paramString);
    Iu(paramString);
    boolean bool = new com.tencent.mm.vfs.k(ch(paramString, false)).delete();
    AppMethodBeat.o(28966);
    return bool;
  }
  
  public static c aDR(String paramString)
  {
    AppMethodBeat.i(28970);
    paramString = d.eqI().aDT(ch(paramString, false));
    AppMethodBeat.o(28970);
    return paramString;
  }
  
  public static String ch(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(28964);
    bc.aCg();
    paramString = n.d(com.tencent.mm.model.c.azT(), "recbiz_", paramString, ".rec", 2);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(28964);
      return null;
    }
    if (paramBoolean)
    {
      AppMethodBeat.o(28964);
      return paramString;
    }
    if (new com.tencent.mm.vfs.k(paramString).exists())
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