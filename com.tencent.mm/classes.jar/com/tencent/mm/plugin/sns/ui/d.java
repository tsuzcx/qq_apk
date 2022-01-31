package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class d<T>
{
  private ak handler = null;
  List<Integer> rDY = new LinkedList();
  
  public d()
  {
    this.rDY.clear();
  }
  
  public abstract List<T> Kq();
  
  final void dk(List<T> paramList)
  {
    this.handler.post(new d.2(this, paramList));
  }
  
  public abstract void dl(List<T> paramList);
  
  protected final void ie(boolean paramBoolean)
  {
    int i;
    int j;
    if (paramBoolean)
    {
      i = 0;
      if (i != 1) {
        break label73;
      }
      Iterator localIterator = this.rDY.iterator();
      while (localIterator.hasNext()) {
        if (((Integer)localIterator.next()).intValue() == 1)
        {
          j = 1;
          label51:
          if (j == 0) {
            break label73;
          }
          ab.e("MicroMsg.AdapterLoader", "thread is loading ui should be not load any");
        }
      }
    }
    for (;;)
    {
      return;
      i = 1;
      break;
      j = 0;
      break label51;
      label73:
      if (!paramBoolean) {
        ab.d("MicroMsg.AdapterLoader", "ui load");
      }
      while (this.rDY.size() <= 1)
      {
        this.rDY.add(Integer.valueOf(i));
        if (!paramBoolean) {
          break label164;
        }
        ag.coO().post(new d.1(this, paramBoolean));
        return;
        ab.d("MicroMsg.AdapterLoader", "thread load" + this.rDY.size());
      }
    }
    label164:
    dk(Kq());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d
 * JD-Core Version:    0.7.0.1
 */