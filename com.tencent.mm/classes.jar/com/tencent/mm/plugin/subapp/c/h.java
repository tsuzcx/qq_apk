package com.tencent.mm.plugin.subapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.bi;
import java.io.File;

public final class h
{
  static boolean a(g paramg)
  {
    AppMethodBeat.i(25290);
    if (paramg == null)
    {
      AppMethodBeat.o(25290);
      return false;
    }
    if (paramg.bsY == -1)
    {
      AppMethodBeat.o(25290);
      return false;
    }
    boolean bool = d.cGT().a(paramg.field_filename, paramg);
    AppMethodBeat.o(25290);
    return bool;
  }
  
  private static boolean adR(String paramString)
  {
    AppMethodBeat.i(25287);
    if (paramString == null)
    {
      AppMethodBeat.o(25287);
      return false;
    }
    d.cGT().qD(paramString);
    vL(paramString);
    boolean bool = new File(bE(paramString, false)).delete();
    AppMethodBeat.o(25287);
    return bool;
  }
  
  public static c adS(String paramString)
  {
    AppMethodBeat.i(25291);
    paramString = d.cGT().adU(bE(paramString, false));
    AppMethodBeat.o(25291);
    return paramString;
  }
  
  public static String bE(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(25285);
    aw.aaz();
    paramString = j.b(com.tencent.mm.model.c.YN(), "recbiz_", paramString, ".rec", 2);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(25285);
      return null;
    }
    if (paramBoolean)
    {
      AppMethodBeat.o(25285);
      return paramString;
    }
    if (new File(paramString).exists())
    {
      AppMethodBeat.o(25285);
      return paramString;
    }
    AppMethodBeat.o(25285);
    return paramString;
  }
  
  static void vL(String paramString)
  {
    AppMethodBeat.i(25288);
    d.cGT().vL(bE(paramString, false));
    AppMethodBeat.o(25288);
  }
  
  public static boolean vP(String paramString)
  {
    AppMethodBeat.i(25286);
    if (paramString == null)
    {
      AppMethodBeat.o(25286);
      return false;
    }
    g localg = d.cGT().adV(paramString);
    if (localg == null)
    {
      ab.d("MicroMsg.VoiceRemindLogic", "cancel null record : ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(25286);
      return true;
    }
    ab.d("MicroMsg.VoiceRemindLogic", "cancel record : " + paramString + " LocalId:" + localg.field_msglocalid);
    if (localg.field_msglocalid != 0)
    {
      aw.aaz();
      com.tencent.mm.model.c.YC().kC(localg.field_msglocalid);
    }
    boolean bool = adR(paramString);
    AppMethodBeat.o(25286);
    return bool;
  }
  
  public static boolean vk(String paramString)
  {
    AppMethodBeat.i(25289);
    if (paramString == null)
    {
      AppMethodBeat.o(25289);
      return false;
    }
    g localg = d.cGT().adV(paramString);
    if (localg == null)
    {
      ab.e("MicroMsg.VoiceRemindLogic", "Set error failed file:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(25289);
      return false;
    }
    localg.field_status = 98;
    localg.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
    localg.bsY = 320;
    boolean bool = a(localg);
    ab.d("MicroMsg.VoiceRemindLogic", "setError file:" + paramString + " msgid:" + localg.field_msglocalid + " old stat:" + localg.field_status);
    if ((localg.field_msglocalid == 0) || (bo.isNullOrNil(localg.field_user)))
    {
      ab.e("MicroMsg.VoiceRemindLogic", "setError failed msg id:" + localg.field_msglocalid + " user:" + localg.field_user);
      AppMethodBeat.o(25289);
      return bool;
    }
    aw.aaz();
    paramString = com.tencent.mm.model.c.YC().kB(localg.field_msglocalid);
    paramString.setMsgId(localg.field_msglocalid);
    paramString.setStatus(5);
    paramString.kj(localg.field_user);
    paramString.setContent(f.d(localg.field_human, -1L, true));
    aw.aaz();
    com.tencent.mm.model.c.YC().a(paramString.field_msgId, paramString);
    AppMethodBeat.o(25289);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.h
 * JD-Core Version:    0.7.0.1
 */