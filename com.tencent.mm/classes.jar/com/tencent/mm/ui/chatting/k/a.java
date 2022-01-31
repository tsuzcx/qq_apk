package com.tencent.mm.ui.chatting.k;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.o;
import com.tencent.mm.ui.chatting.e.d.b;
import java.util.List;

public final class a
  implements e<bi>
{
  private Cursor JM;
  private String drJ;
  private int dsr;
  private int mCount;
  private long voj;
  
  public a(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    this.drJ = paramString;
    this.voj = paramLong;
    this.dsr = paramInt2;
    this.mCount = paramInt1;
  }
  
  public final void a(d.b paramb)
  {
    long l = ((j)g.r(j.class)).Gb().Hp(this.drJ);
    y.d("MicroMsg.ChattingLoader.ChattingBizDataSource", "[ChattingBizDataSource] talker:%s bizChatId:%s,count:%s totalCount:%s createTime:%s", new Object[] { this.drJ, Long.valueOf(this.voj), Integer.valueOf(this.mCount), Integer.valueOf(this.dsr), Long.valueOf(l) });
    au.Hx();
    this.JM = com.tencent.mm.model.c.Fz().l(this.drJ, this.voj, this.mCount);
    paramb.cN();
  }
  
  public final int cDk()
  {
    return this.dsr;
  }
  
  public final void close()
  {
    this.JM.close();
  }
  
  public final void ei(List<bi> paramList)
  {
    this.JM.moveToFirst();
    while (!this.JM.isAfterLast())
    {
      bi localbi = new bi();
      localbi.d(this.JM);
      paramList.add(localbi);
      this.JM.moveToNext();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.a
 * JD-Core Version:    0.7.0.1
 */