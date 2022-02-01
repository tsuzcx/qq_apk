package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.pb.common.b.a.a.a.ay;
import com.tencent.pb.talkroom.sdk.d;
import com.tencent.wecall.talkroom.model.TalkRoom;
import com.tencent.wecall.talkroom.model.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class u
{
  public static u wse;
  private TalkRoom wsf;
  
  public final List<String> asM(String paramString)
  {
    AppMethodBeat.i(190812);
    ArrayList localArrayList = new ArrayList();
    this.wsf = c.gdW().bbC(paramString);
    if (this.wsf != null)
    {
      paramString = this.wsf.gdQ().iterator();
      label176:
      label179:
      while (paramString.hasNext())
      {
        a.ay localay = (a.ay)paramString.next();
        int i = localay.pcE;
        if (i >= 0)
        {
          byte[] arrayOfByte = new byte[4];
          if (z.dtJ().wqE.setAppCmd(10, arrayOfByte, i) < 0)
          {
            ae.d("MicroMsg.Multitalk.VoipNetStatusChecker", "get netStatus failed memberId :%d", new Object[] { Integer.valueOf(i) });
            i = -1;
            label118:
            if ((i == -1) || (i > 3)) {
              break label176;
            }
          }
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label179;
            }
            localArrayList.add(localay.duC);
            break;
            i = bu.bF(arrayOfByte);
            ae.d("MicroMsg.Multitalk.VoipNetStatusChecker", "netStatus: %d", new Object[] { Integer.valueOf(i) });
            break label118;
          }
        }
      }
    }
    AppMethodBeat.o(190812);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.u
 * JD-Core Version:    0.7.0.1
 */