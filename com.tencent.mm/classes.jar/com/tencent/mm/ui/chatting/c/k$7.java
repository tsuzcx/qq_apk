package com.tencent.mm.ui.chatting.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.n;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.expt.roomexpt.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.d.a;

final class k$7
  implements Runnable
{
  k$7(k paramk, String paramString, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    boolean bool = false;
    AppMethodBeat.i(31350);
    int n;
    Object localObject1;
    Object localObject2;
    int m;
    int k;
    int j;
    int i;
    if (!bo.isNullOrNil(this.zFr))
    {
      n = n.nv(this.zFr);
      aw.aaz();
      localObject1 = c.YC().D(this.zFr, k.b(this.zFo), k.c(this.zFo));
      if ((localObject1 == null) || (!((Cursor)localObject1).moveToFirst())) {
        break label492;
      }
      localObject2 = new bi();
      m = 0;
      k = 0;
      do
      {
        ((bi)localObject2).convertFrom((Cursor)localObject1);
        if (((dd)localObject2).field_isSend != 1) {
          break;
        }
        j = k + 1;
        i = m;
        m = i;
        k = j;
      } while (((Cursor)localObject1).moveToNext());
    }
    for (;;)
    {
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
      ab.d("MicroMsg.ChattingUI.ChattingReportComponent", "dkchatmsg MuteRoomKvStat, muteRoomName:%s, stayTime:%d, memberNum:%d, newMsg:%d, sendMsgNum:%d, unreadMsgNum:%d, backToHistoryState:%d, isMute:%d  ,session:%s", new Object[] { this.zFr, Long.valueOf(k.c(this.zFo) - k.b(this.zFo)), Integer.valueOf(n), Integer.valueOf(k.a(this.zFo) + i), Integer.valueOf(j), Integer.valueOf(k.a(this.zFo)), Integer.valueOf(this.zFs), Integer.valueOf(this.zFt), this.zFo.caz.dJC() });
      com.tencent.mm.plugin.report.service.h.qsU.e(12077, new Object[] { this.zFr, Long.valueOf(k.c(this.zFo) - k.b(this.zFo)), Integer.valueOf(n), Integer.valueOf(i + k.a(this.zFo)), Integer.valueOf(j), Integer.valueOf(k.a(this.zFo)), Integer.valueOf(this.zFs), Integer.valueOf(this.zFt), this.zFo.caz.dJC(), Integer.valueOf(k.d(this.zFo)) });
      localObject1 = s.nE(this.zFr);
      localObject2 = (d)g.E(d.class);
      String str = this.zFr;
      long l1 = k.c(this.zFo);
      long l2 = k.b(this.zFo);
      i = k.a(this.zFo);
      if (this.zFt == 1) {
        bool = true;
      }
      ((d)localObject2).a(str, (String)localObject1, l1 - l2, i, j, bool);
      AppMethodBeat.o(31350);
      return;
      i = m + 1;
      j = k;
      break;
      label492:
      i = 0;
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.k.7
 * JD-Core Version:    0.7.0.1
 */