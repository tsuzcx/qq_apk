package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.pb.common.b.a.a.a.ba;
import com.tencent.pb.talkroom.sdk.d;
import com.tencent.wecall.talkroom.model.TalkRoom;
import com.tencent.wecall.talkroom.model.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class w
{
  public static w Ftp;
  private TalkRoom Ftq;
  
  public final List<String> aQz(String paramString)
  {
    AppMethodBeat.i(205378);
    ArrayList localArrayList = new ArrayList();
    this.Ftq = c.iuI().bEf(paramString);
    if (this.Ftq != null)
    {
      paramString = this.Ftq.iuC().iterator();
      label176:
      label179:
      while (paramString.hasNext())
      {
        a.ba localba = (a.ba)paramString.next();
        int i = localba.tQm;
        if (i >= 0)
        {
          byte[] arrayOfByte = new byte[4];
          if (ad.eYb().Frw.setAppCmd(10, arrayOfByte, i) < 0)
          {
            Log.d("MicroMsg.Multitalk.VoipNetStatusChecker", "get netStatus failed memberId :%d", new Object[] { Integer.valueOf(i) });
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
            localArrayList.add(localba.fEC);
            break;
            i = Util.byteArrayToInt(arrayOfByte);
            Log.d("MicroMsg.Multitalk.VoipNetStatusChecker", "netStatus: %d", new Object[] { Integer.valueOf(i) });
            break label118;
          }
        }
      }
    }
    AppMethodBeat.o(205378);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.w
 * JD-Core Version:    0.7.0.1
 */