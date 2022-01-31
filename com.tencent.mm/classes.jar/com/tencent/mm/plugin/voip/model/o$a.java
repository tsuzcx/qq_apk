package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

public final class o$a
{
  public static int twS = 1;
  public static int twT = 2;
  public static int twU = 3;
  public static int twV = 4;
  public static int twW = 5;
  public static int twX = 0;
  public static int twY = 1;
  public int status;
  public int twP;
  public long twQ;
  public int twR;
  
  public final boolean cMy()
  {
    return this.twR == twX;
  }
  
  public final boolean cMz()
  {
    return this.status == twW;
  }
  
  public final boolean parse(String paramString)
  {
    AppMethodBeat.i(4455);
    this.twR = twX;
    try
    {
      paramString = br.F(paramString, "voipinvitemsg");
      if (paramString != null)
      {
        if (paramString.get(".voipinvitemsg.roomid") != null) {
          this.twP = bo.getInt((String)paramString.get(".voipinvitemsg.roomid"), 0);
        }
        if (paramString.get(".voipinvitemsg.key") != null) {
          this.twQ = bo.getLong((String)paramString.get(".voipinvitemsg.key"), 0L);
        }
        if (paramString.get(".voipinvitemsg.status") != null) {
          this.status = bo.getInt((String)paramString.get(".voipinvitemsg.status"), 0);
        }
        if (paramString.get(".voipinvitemsg.invitetype") != null) {
          this.twR = bo.getInt((String)paramString.get(".voipinvitemsg.invitetype"), 0);
        }
        AppMethodBeat.o(4455);
        return true;
      }
      AppMethodBeat.o(4455);
      return false;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.VoipExtension", paramString, "", new Object[0]);
      ab.e("MicroMsg.VoipExtension", "parse voip message error: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(4455);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.o.a
 * JD-Core Version:    0.7.0.1
 */