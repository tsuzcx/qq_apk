package com.tencent.mm.plugin.subapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

public final class e
{
  private static final f<Integer, e> eka;
  public String cmN;
  public int fgw;
  public String fgx;
  public int sXm;
  public int sXn;
  public String sXo;
  public int sXp;
  public int sXq;
  public int sXr;
  public int sXs;
  
  static
  {
    AppMethodBeat.i(25282);
    eka = new c(100);
    AppMethodBeat.o(25282);
  }
  
  public static e adQ(String paramString)
  {
    AppMethodBeat.i(25281);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(25281);
      return null;
    }
    int i = paramString.indexOf('<');
    Object localObject = paramString;
    if (i > 0) {
      localObject = paramString.substring(i);
    }
    i = ((String)localObject).hashCode();
    paramString = (e)eka.get(Integer.valueOf(i));
    if (paramString != null)
    {
      AppMethodBeat.o(25281);
      return paramString;
    }
    paramString = br.F((String)localObject, "msg");
    if (paramString == null)
    {
      ab.e("MicroMsg.VoiceRemindAppMsgExInfo", "parse msg failed");
      AppMethodBeat.o(25281);
      return null;
    }
    try
    {
      localObject = new e();
      ((e)localObject).fgw = bo.getInt((String)paramString.get(".msg.appmsg.appattach.totallen"), 0);
      ((e)localObject).cmN = ((String)paramString.get(".msg.appmsg.appattach.attachid"));
      ((e)localObject).fgx = ((String)paramString.get(".msg.appmsg.appattach.fileext"));
      ((e)localObject).sXm = bo.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindtime"), 0);
      ((e)localObject).sXn = bo.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindid"), 0);
      ((e)localObject).sXo = ((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindattachid"));
      ((e)localObject).sXp = bo.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindattachtotallen"), 0);
      ((e)localObject).sXq = bo.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindformat"), 0);
      ((e)localObject).sXr = bo.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$originformat"), 0);
      ((e)localObject).sXs = bo.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$msgsvrid"), 0);
      eka.f(Integer.valueOf(i), localObject);
      AppMethodBeat.o(25281);
      return localObject;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.VoiceRemindAppMsgExInfo", "parse amessage xml failed");
      ab.printErrStackTrace("MicroMsg.VoiceRemindAppMsgExInfo", paramString, "", new Object[0]);
      AppMethodBeat.o(25281);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.e
 * JD-Core Version:    0.7.0.1
 */