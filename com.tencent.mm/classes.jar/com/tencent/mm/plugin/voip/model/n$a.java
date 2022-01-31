package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

public final class n$a
{
  public static int pRL = 1;
  public static int pRM = 2;
  public static int pRN = 3;
  public static int pRO = 4;
  public static int pRP = 5;
  public static int pRQ = 0;
  public static int pRR = 1;
  public int pRI;
  public long pRJ;
  public int pRK;
  public int status;
  
  public final boolean bQp()
  {
    return this.pRK == pRQ;
  }
  
  public final boolean bQq()
  {
    return this.status == pRP;
  }
  
  public final boolean parse(String paramString)
  {
    this.pRK = pRQ;
    try
    {
      paramString = bn.s(paramString, "voipinvitemsg");
      if (paramString != null)
      {
        if (paramString.get(".voipinvitemsg.roomid") != null) {
          this.pRI = bk.getInt((String)paramString.get(".voipinvitemsg.roomid"), 0);
        }
        if (paramString.get(".voipinvitemsg.key") != null) {
          this.pRJ = bk.getLong((String)paramString.get(".voipinvitemsg.key"), 0L);
        }
        if (paramString.get(".voipinvitemsg.status") != null) {
          this.status = bk.getInt((String)paramString.get(".voipinvitemsg.status"), 0);
        }
        if (paramString.get(".voipinvitemsg.invitetype") != null) {
          this.pRK = bk.getInt((String)paramString.get(".voipinvitemsg.invitetype"), 0);
        }
        return true;
      }
      return false;
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("MicroMsg.VoipExtension", paramString, "", new Object[0]);
      y.e("MicroMsg.VoipExtension", "parse voip message error: %s", new Object[] { paramString.getMessage() });
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.n.a
 * JD-Core Version:    0.7.0.1
 */