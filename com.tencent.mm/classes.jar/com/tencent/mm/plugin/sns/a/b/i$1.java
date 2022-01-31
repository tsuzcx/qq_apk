package com.tencent.mm.plugin.sns.a.b;

import com.tencent.mm.bv.b;
import com.tencent.mm.protocal.c.asw;
import com.tencent.mm.protocal.c.btm;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class i$1
  implements Runnable
{
  i$1(i parami, int paramInt, Object[] paramArrayOfObject) {}
  
  public final void run()
  {
    asw localasw = new asw();
    localasw.tou = this.olM;
    localasw.toC = ((int)(System.currentTimeMillis() / 1000L));
    localasw.hPS = 1;
    String str = i.o(this.olN);
    localasw.tov = new b(str.getBytes());
    i.a(this.olO).sve.add(localasw);
    y.i("MicroMsg.SnsLogMgr", "snsadlog " + this.olM + " " + str);
    if (i.b(this.olO) == 0L) {
      i.a(this.olO, System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b.i.1
 * JD-Core Version:    0.7.0.1
 */