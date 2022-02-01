package com.tencent.mm.plugin.subapp.modelvoiceremind;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class e
{
  private static final f<Integer, e> lNS;
  public int SFk;
  public int SFl;
  public String SFm;
  public int SFn;
  public int SFo;
  public int SFp;
  public int SFq;
  public String hzM;
  public int nRd;
  public String nRe;
  
  static
  {
    AppMethodBeat.i(28961);
    lNS = new c(100);
    AppMethodBeat.o(28961);
  }
  
  public static e bcA(String paramString)
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
    paramString = (e)lNS.get(Integer.valueOf(i));
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
      ((e)localObject).nRd = Util.getInt((String)paramString.get(".msg.appmsg.appattach.totallen"), 0);
      ((e)localObject).hzM = ((String)paramString.get(".msg.appmsg.appattach.attachid"));
      ((e)localObject).nRe = ((String)paramString.get(".msg.appmsg.appattach.fileext"));
      ((e)localObject).SFk = Util.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindtime"), 0);
      ((e)localObject).SFl = Util.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindid"), 0);
      ((e)localObject).SFm = ((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindattachid"));
      ((e)localObject).SFn = Util.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindattachtotallen"), 0);
      ((e)localObject).SFo = Util.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindformat"), 0);
      ((e)localObject).SFp = Util.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$originformat"), 0);
      ((e)localObject).SFq = Util.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$msgsvrid"), 0);
      lNS.B(Integer.valueOf(i), localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.modelvoiceremind.e
 * JD-Core Version:    0.7.0.1
 */