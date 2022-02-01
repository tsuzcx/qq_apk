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
  private static final f<Integer, e> fTI;
  public int BhO;
  public int BhP;
  public String BhQ;
  public int BhR;
  public int BhS;
  public int BhT;
  public int BhU;
  public String dks;
  public int hzO;
  public String hzP;
  
  static
  {
    AppMethodBeat.i(28961);
    fTI = new c(100);
    AppMethodBeat.o(28961);
  }
  
  public static e aCw(String paramString)
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
    paramString = (e)fTI.get(Integer.valueOf(i));
    if (paramString != null)
    {
      AppMethodBeat.o(28960);
      return paramString;
    }
    paramString = bw.M((String)localObject, "msg");
    if (paramString == null)
    {
      ad.e("MicroMsg.VoiceRemindAppMsgExInfo", "parse msg failed");
      AppMethodBeat.o(28960);
      return null;
    }
    try
    {
      localObject = new e();
      ((e)localObject).hzO = bt.getInt((String)paramString.get(".msg.appmsg.appattach.totallen"), 0);
      ((e)localObject).dks = ((String)paramString.get(".msg.appmsg.appattach.attachid"));
      ((e)localObject).hzP = ((String)paramString.get(".msg.appmsg.appattach.fileext"));
      ((e)localObject).BhO = bt.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindtime"), 0);
      ((e)localObject).BhP = bt.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindid"), 0);
      ((e)localObject).BhQ = ((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindattachid"));
      ((e)localObject).BhR = bt.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindattachtotallen"), 0);
      ((e)localObject).BhS = bt.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindformat"), 0);
      ((e)localObject).BhT = bt.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$originformat"), 0);
      ((e)localObject).BhU = bt.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$msgsvrid"), 0);
      fTI.q(Integer.valueOf(i), localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.d.e
 * JD-Core Version:    0.7.0.1
 */