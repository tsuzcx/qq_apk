package com.tencent.mm.plugin.setting.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.h;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public final class l
{
  public final ai dKQ;
  Object mLock = new Object();
  public Runnable mRunnable;
  public boolean nQP;
  public boolean nQQ;
  public boolean nQR;
  final CountDownLatch nQS;
  HashSet<String> nQT = new HashSet();
  HashSet<String> nQU = new HashSet();
  HashSet<String> nQV = new HashSet();
  HashSet<String> nQW = new HashSet();
  public l.a nQX;
  public UnfamiliarContactDetailUI.h nQY;
  public long nQZ;
  
  public l(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, UnfamiliarContactDetailUI.h paramh)
  {
    this.nQP = paramBoolean1;
    this.nQQ = paramBoolean2;
    this.nQR = paramBoolean3;
    int i;
    int j;
    if (this.nQQ)
    {
      i = 1;
      if (!this.nQP) {
        break label202;
      }
      j = 1;
      label94:
      if (!this.nQR) {
        break label208;
      }
    }
    label202:
    label208:
    for (int k = 1;; k = 0)
    {
      i = k + (j + i);
      y.i("MicroMsg.UnfamiliarContactEngine", "[UnfamiliarContactEngine] count:%s [%s:%s:%s]", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.nQQ), Boolean.valueOf(this.nQP), Boolean.valueOf(this.nQR) });
      this.nQS = new CountDownLatch(i);
      this.dKQ = new ai("UnfamiliarContactEngine");
      this.nQY = paramh;
      return;
      i = 0;
      break;
      j = 0;
      break label94;
    }
  }
  
  final void g(LinkedList<String> paramLinkedList, int paramInt)
  {
    long l = System.currentTimeMillis();
    if (paramInt + 10 < paramLinkedList.size()) {}
    for (int i = paramInt + 10;; i = paramLinkedList.size())
    {
      List localList = paramLinkedList.subList(paramInt, i);
      i locali = new i();
      locali.kwX = 8;
      locali.bVk = bk.c(localList, ",");
      locali.kxf = new l.4(this, i, localList, paramLinkedList, l);
      locali.handler = this.dKQ.crf();
      ((n)g.t(n.class)).search(2, locali);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.l
 * JD-Core Version:    0.7.0.1
 */