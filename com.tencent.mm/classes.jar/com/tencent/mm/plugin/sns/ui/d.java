package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class d<T>
{
  private ah handler = null;
  List<Integer> oMn = new LinkedList();
  
  public d()
  {
    this.oMn.clear();
  }
  
  final void cE(List<T> paramList)
  {
    this.handler.post(new d.2(this, paramList));
  }
  
  public abstract void cF(List<T> paramList);
  
  protected final void gw(boolean paramBoolean)
  {
    int i;
    int j;
    if (paramBoolean)
    {
      i = 0;
      if (i != 1) {
        break label73;
      }
      Iterator localIterator = this.oMn.iterator();
      while (localIterator.hasNext()) {
        if (((Integer)localIterator.next()).intValue() == 1)
        {
          j = 1;
          label51:
          if (j == 0) {
            break label73;
          }
          y.e("MicroMsg.AdapterLoader", "thread is loading ui should be not load any");
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
        y.d("MicroMsg.AdapterLoader", "ui load");
      }
      while (this.oMn.size() <= 1)
      {
        this.oMn.add(Integer.valueOf(i));
        if (!paramBoolean) {
          break label164;
        }
        af.bDp().post(new d.1(this, paramBoolean));
        return;
        y.d("MicroMsg.AdapterLoader", "thread load" + this.oMn.size());
      }
    }
    label164:
    cE(xY());
  }
  
  public abstract List<T> xY();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d
 * JD-Core Version:    0.7.0.1
 */