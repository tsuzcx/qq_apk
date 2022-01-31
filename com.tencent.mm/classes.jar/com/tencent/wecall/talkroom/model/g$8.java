package com.tencent.wecall.talkroom.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class g$8
  implements Runnable
{
  g$8(g paramg, String paramString, boolean paramBoolean) {}
  
  public final void run()
  {
    synchronized (this.xfh.dhm)
    {
      ArrayList localArrayList = new ArrayList(this.xfh.dhm);
      ??? = localArrayList.iterator();
      if (((Iterator)???).hasNext()) {
        ((g.a)((Iterator)???).next()).bT(this.iFN, this.xfi);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.g.8
 * JD-Core Version:    0.7.0.1
 */