package com.tencent.mm.plugin.subapp.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.Map;

public final class e
{
  private static final f<Integer, e> fAs;
  public String cZa;
  public int hhF;
  public String hhG;
  public int zQn;
  public int zQo;
  public String zQp;
  public int zQq;
  public int zQr;
  public int zQs;
  public int zQt;
  
  static
  {
    AppMethodBeat.i(28961);
    fAs = new c(100);
    AppMethodBeat.o(28961);
  }
  
  public static e axs(String paramString)
  {
    AppMethodBeat.i(28960);
    if (bs.isNullOrNil(paramString))
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
    paramString = (e)fAs.get(Integer.valueOf(i));
    if (paramString != null)
    {
      AppMethodBeat.o(28960);
      return paramString;
    }
    paramString = bv.L((String)localObject, "msg");
    if (paramString == null)
    {
      ac.e("MicroMsg.VoiceRemindAppMsgExInfo", "parse msg failed");
      AppMethodBeat.o(28960);
      return null;
    }
    try
    {
      localObject = new e();
      ((e)localObject).hhF = bs.getInt((String)paramString.get(".msg.appmsg.appattach.totallen"), 0);
      ((e)localObject).cZa = ((String)paramString.get(".msg.appmsg.appattach.attachid"));
      ((e)localObject).hhG = ((String)paramString.get(".msg.appmsg.appattach.fileext"));
      ((e)localObject).zQn = bs.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindtime"), 0);
      ((e)localObject).zQo = bs.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindid"), 0);
      ((e)localObject).zQp = ((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindattachid"));
      ((e)localObject).zQq = bs.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindattachtotallen"), 0);
      ((e)localObject).zQr = bs.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindformat"), 0);
      ((e)localObject).zQs = bs.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$originformat"), 0);
      ((e)localObject).zQt = bs.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$msgsvrid"), 0);
      fAs.o(Integer.valueOf(i), localObject);
      AppMethodBeat.o(28960);
      return localObject;
    }
    catch (Exception paramString)
    {
      ac.e("MicroMsg.VoiceRemindAppMsgExInfo", "parse amessage xml failed");
      ac.printErrStackTrace("MicroMsg.VoiceRemindAppMsgExInfo", paramString, "", new Object[0]);
      AppMethodBeat.o(28960);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.d.e
 * JD-Core Version:    0.7.0.1
 */