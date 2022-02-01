package com.tencent.mm.plugin.subapp.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.Map;

public final class e
{
  private static final f<Integer, e> fwL;
  public String dbA;
  public int gHe;
  public String gHf;
  public int yCZ;
  public int yDa;
  public String yDb;
  public int yDc;
  public int yDd;
  public int yDe;
  public int yDf;
  
  static
  {
    AppMethodBeat.i(28961);
    fwL = new c(100);
    AppMethodBeat.o(28961);
  }
  
  public static e asj(String paramString)
  {
    AppMethodBeat.i(28960);
    if (bt.isNullOrNil(paramString))
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
    paramString = (e)fwL.get(Integer.valueOf(i));
    if (paramString != null)
    {
      AppMethodBeat.o(28960);
      return paramString;
    }
    paramString = bw.K((String)localObject, "msg");
    if (paramString == null)
    {
      ad.e("MicroMsg.VoiceRemindAppMsgExInfo", "parse msg failed");
      AppMethodBeat.o(28960);
      return null;
    }
    try
    {
      localObject = new e();
      ((e)localObject).gHe = bt.getInt((String)paramString.get(".msg.appmsg.appattach.totallen"), 0);
      ((e)localObject).dbA = ((String)paramString.get(".msg.appmsg.appattach.attachid"));
      ((e)localObject).gHf = ((String)paramString.get(".msg.appmsg.appattach.fileext"));
      ((e)localObject).yCZ = bt.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindtime"), 0);
      ((e)localObject).yDa = bt.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindid"), 0);
      ((e)localObject).yDb = ((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindattachid"));
      ((e)localObject).yDc = bt.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindattachtotallen"), 0);
      ((e)localObject).yDd = bt.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindformat"), 0);
      ((e)localObject).yDe = bt.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$originformat"), 0);
      ((e)localObject).yDf = bt.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$msgsvrid"), 0);
      fwL.o(Integer.valueOf(i), localObject);
      AppMethodBeat.o(28960);
      return localObject;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.VoiceRemindAppMsgExInfo", "parse amessage xml failed");
      ad.printErrStackTrace("MicroMsg.VoiceRemindAppMsgExInfo", paramString, "", new Object[0]);
      AppMethodBeat.o(28960);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.d.e
 * JD-Core Version:    0.7.0.1
 */