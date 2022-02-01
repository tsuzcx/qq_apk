package com.tencent.mm.plugin.sport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.d;
import com.tencent.mm.message.f;
import com.tencent.mm.message.k.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public class e
  extends f
{
  public String SaX;
  public String SaY;
  public String SaZ;
  public String Sba;
  public String Sbb;
  public String Sbc;
  public String Sbd;
  public String Sbe;
  private final String Sbf;
  private final String Sbg;
  private final String Sbh;
  private final String Sbi;
  private final String Sbj;
  Map<String, String> map;
  
  public e()
  {
    AppMethodBeat.i(263899);
    this.Sbf = "JoinRunOpen";
    this.Sbg = "JoinRunOpenExpireTime";
    this.Sbh = "JoinRunFinderUsername";
    this.Sbi = "JoinRunFinderEventId";
    this.Sbj = "JoinRunMsgWording";
    this.map = new HashMap(5);
    AppMethodBeat.o(263899);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2) {}
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(263905);
    this.SaX = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.sharetostatus.iconid"));
    this.SaY = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.sharetostatus.text"));
    this.SaZ = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.sharetostatus.expiretime"));
    int i = 0;
    for (;;)
    {
      Object localObject = new StringBuilder(".msg.appmsg.hardwareinfo.extinfolist.extinfo");
      StringBuilder localStringBuilder;
      if (i == 0)
      {
        paramb = "";
        localObject = (String)paramMap.get(paramb + ".key");
        localStringBuilder = new StringBuilder(".msg.appmsg.hardwareinfo.extinfolist.extinfo");
        if (i != 0) {
          break label313;
        }
      }
      label313:
      for (paramb = "";; paramb = Integer.valueOf(i))
      {
        paramb = (String)paramMap.get(paramb + ".value");
        if (!Util.isNullOrNil((String)localObject)) {
          break label321;
        }
        Log.i("MicroMsg.SportsAppMsgContent", "should break now : %d", new Object[] { Integer.valueOf(i) });
        this.Sba = ((String)this.map.get("JoinRunOpen"));
        this.Sbb = ((String)this.map.get("JoinRunOpenExpireTime"));
        this.Sbd = ((String)this.map.get("JoinRunFinderEventId"));
        this.Sbc = ((String)this.map.get("JoinRunFinderUsername"));
        this.Sbe = ((String)this.map.get("JoinRunMsgWording"));
        Log.i("MicroMsg.SportsAppMsgContent", "parseContent: winter olympic data: %s , %s ,%s , %s ,%s ", new Object[] { this.Sba, this.Sbb, this.Sbd, this.Sbc, this.Sbe });
        AppMethodBeat.o(263905);
        return;
        paramb = Integer.valueOf(i);
        break;
      }
      label321:
      Log.i("MicroMsg.SportsAppMsgContent", "parseContent: key:%s , value :%s", new Object[] { localObject, paramb });
      this.map.put(localObject, paramb);
      i += 1;
    }
  }
  
  public final f biW()
  {
    AppMethodBeat.i(263900);
    e locale = new e();
    locale.SaX = this.SaX;
    locale.SaY = this.SaY;
    locale.SaZ = this.SaZ;
    locale.Sba = ((String)this.map.get("JoinRunOpen"));
    locale.Sbb = ((String)this.map.get("JoinRunOpenExpireTime"));
    locale.Sbd = ((String)this.map.get("JoinRunFinderEventId"));
    locale.Sbc = ((String)this.map.get("JoinRunFinderUsername"));
    locale.Sbe = ((String)this.map.get("JoinRunMsgWording"));
    AppMethodBeat.o(263900);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.e
 * JD-Core Version:    0.7.0.1
 */