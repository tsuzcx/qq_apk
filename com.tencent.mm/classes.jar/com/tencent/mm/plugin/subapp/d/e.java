package com.tencent.mm.plugin.subapp.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import java.util.Map;

public final class e
{
  private static final f<Integer, e> fVO;
  public int Bzm;
  public int Bzn;
  public String Bzo;
  public int Bzp;
  public int Bzq;
  public int Bzr;
  public int Bzs;
  public String dlu;
  public int hCC;
  public String hCD;
  
  static
  {
    AppMethodBeat.i(28961);
    fVO = new c(100);
    AppMethodBeat.o(28961);
  }
  
  public static e aDP(String paramString)
  {
    AppMethodBeat.i(28960);
    if (bu.isNullOrNil(paramString))
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
    paramString = (e)fVO.get(Integer.valueOf(i));
    if (paramString != null)
    {
      AppMethodBeat.o(28960);
      return paramString;
    }
    paramString = bx.M((String)localObject, "msg");
    if (paramString == null)
    {
      ae.e("MicroMsg.VoiceRemindAppMsgExInfo", "parse msg failed");
      AppMethodBeat.o(28960);
      return null;
    }
    try
    {
      localObject = new e();
      ((e)localObject).hCC = bu.getInt((String)paramString.get(".msg.appmsg.appattach.totallen"), 0);
      ((e)localObject).dlu = ((String)paramString.get(".msg.appmsg.appattach.attachid"));
      ((e)localObject).hCD = ((String)paramString.get(".msg.appmsg.appattach.fileext"));
      ((e)localObject).Bzm = bu.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindtime"), 0);
      ((e)localObject).Bzn = bu.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindid"), 0);
      ((e)localObject).Bzo = ((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindattachid"));
      ((e)localObject).Bzp = bu.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindattachtotallen"), 0);
      ((e)localObject).Bzq = bu.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindformat"), 0);
      ((e)localObject).Bzr = bu.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$originformat"), 0);
      ((e)localObject).Bzs = bu.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$msgsvrid"), 0);
      fVO.q(Integer.valueOf(i), localObject);
      AppMethodBeat.o(28960);
      return localObject;
    }
    catch (Exception paramString)
    {
      ae.e("MicroMsg.VoiceRemindAppMsgExInfo", "parse amessage xml failed");
      ae.printErrStackTrace("MicroMsg.VoiceRemindAppMsgExInfo", paramString, "", new Object[0]);
      AppMethodBeat.o(28960);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.d.e
 * JD-Core Version:    0.7.0.1
 */