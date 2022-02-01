package com.tencent.mm.plugin.subapp.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class e
{
  private static final f<Integer, e> gAU;
  public int FJX;
  public int FJY;
  public String FJZ;
  public int FKa;
  public int FKb;
  public int FKc;
  public int FKd;
  public String dCK;
  public int iwI;
  public String iwJ;
  
  static
  {
    AppMethodBeat.i(28961);
    gAU = new c(100);
    AppMethodBeat.o(28961);
  }
  
  public static e aSK(String paramString)
  {
    AppMethodBeat.i(28960);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(28960);
      return null;
    }
    int i = paramString.indexOf('<');
    Object localObject = paramString;
    if (i > 0) {
      localObject = paramString.substring(i);
    }
    i = ((String)localObject).hashCode();
    paramString = (e)gAU.get(Integer.valueOf(i));
    if (paramString != null)
    {
      AppMethodBeat.o(28960);
      return paramString;
    }
    paramString = XmlParser.parseXml((String)localObject, "msg", null);
    if (paramString == null)
    {
      Log.e("MicroMsg.VoiceRemindAppMsgExInfo", "parse msg failed");
      AppMethodBeat.o(28960);
      return null;
    }
    try
    {
      localObject = new e();
      ((e)localObject).iwI = Util.getInt((String)paramString.get(".msg.appmsg.appattach.totallen"), 0);
      ((e)localObject).dCK = ((String)paramString.get(".msg.appmsg.appattach.attachid"));
      ((e)localObject).iwJ = ((String)paramString.get(".msg.appmsg.appattach.fileext"));
      ((e)localObject).FJX = Util.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindtime"), 0);
      ((e)localObject).FJY = Util.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindid"), 0);
      ((e)localObject).FJZ = ((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindattachid"));
      ((e)localObject).FKa = Util.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindattachtotallen"), 0);
      ((e)localObject).FKb = Util.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindformat"), 0);
      ((e)localObject).FKc = Util.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$originformat"), 0);
      ((e)localObject).FKd = Util.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$msgsvrid"), 0);
      gAU.x(Integer.valueOf(i), localObject);
      AppMethodBeat.o(28960);
      return localObject;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.VoiceRemindAppMsgExInfo", "parse amessage xml failed");
      Log.printErrStackTrace("MicroMsg.VoiceRemindAppMsgExInfo", paramString, "", new Object[0]);
      AppMethodBeat.o(28960);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.d.e
 * JD-Core Version:    0.7.0.1
 */