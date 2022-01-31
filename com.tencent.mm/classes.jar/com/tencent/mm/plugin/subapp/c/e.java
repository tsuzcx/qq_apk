package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.a.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

public final class e
{
  private static final f<Integer, e> dss = new f(100);
  public String bFE;
  public int dQv;
  public String dQw;
  public int pvG;
  public int pvH;
  public String pvI;
  public int pvJ;
  public int pvK;
  public int pvL;
  public int pvM;
  
  public static e PA(String paramString)
  {
    if (bk.bl(paramString)) {
      paramString = null;
    }
    int i;
    Object localObject;
    e locale;
    do
    {
      return paramString;
      i = paramString.indexOf('<');
      localObject = paramString;
      if (i > 0) {
        localObject = paramString.substring(i);
      }
      i = ((String)localObject).hashCode();
      locale = (e)dss.get(Integer.valueOf(i));
      paramString = locale;
    } while (locale != null);
    paramString = bn.s((String)localObject, "msg");
    if (paramString == null)
    {
      y.e("MicroMsg.VoiceRemindAppMsgExInfo", "parse msg failed");
      return null;
    }
    try
    {
      localObject = new e();
      ((e)localObject).dQv = bk.getInt((String)paramString.get(".msg.appmsg.appattach.totallen"), 0);
      ((e)localObject).bFE = ((String)paramString.get(".msg.appmsg.appattach.attachid"));
      ((e)localObject).dQw = ((String)paramString.get(".msg.appmsg.appattach.fileext"));
      ((e)localObject).pvG = bk.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindtime"), 0);
      ((e)localObject).pvH = bk.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindid"), 0);
      ((e)localObject).pvI = ((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindattachid"));
      ((e)localObject).pvJ = bk.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindattachtotallen"), 0);
      ((e)localObject).pvK = bk.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindformat"), 0);
      ((e)localObject).pvL = bk.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$originformat"), 0);
      ((e)localObject).pvM = bk.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$msgsvrid"), 0);
      dss.f(Integer.valueOf(i), localObject);
      return localObject;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.VoiceRemindAppMsgExInfo", "parse amessage xml failed");
      y.printErrStackTrace("MicroMsg.VoiceRemindAppMsgExInfo", paramString, "", new Object[0]);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.e
 * JD-Core Version:    0.7.0.1
 */