package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class d<T>
{
  private ao handler = null;
  List<Integer> ywB = new LinkedList();
  
  public d()
  {
    this.ywB.clear();
  }
  
  public abstract List<T> WX();
  
  final void fI(final List<T> paramList)
  {
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97699);
        d.this.fJ(paramList);
        d locald = d.this;
        boolean bool = this.ywF;
        af.dvq().post(new d.3(locald, bool));
        AppMethodBeat.o(97699);
      }
    });
  }
  
  public abstract void fJ(List<T> paramList);
  
  protected final void mJ(final boolean paramBoolean)
  {
    int i;
    int j;
    if (paramBoolean)
    {
      i = 0;
      if (i != 1) {
        break label73;
      }
      Iterator localIterator = this.ywB.iterator();
      while (localIterator.hasNext()) {
        if (((Integer)localIterator.next()).intValue() == 1)
        {
          j = 1;
          label51:
          if (j == 0) {
            break label73;
          }
          ac.e("MicroMsg.AdapterLoader", "thread is loading ui should be not load any");
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
        ac.d("MicroMsg.AdapterLoader", "ui load");
      }
      while (this.ywB.size() <= 1)
      {
        this.ywB.add(Integer.valueOf(i));
        if (!paramBoolean) {
          break label164;
        }
        af.dvq().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(97698);
            List localList = d.this.WX();
            d.this.fI(localList);
            AppMethodBeat.o(97698);
          }
        });
        return;
        ac.d("MicroMsg.AdapterLoader", "thread load" + this.ywB.size());
      }
    }
    label164:
    fI(WX());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d
 * JD-Core Version:    0.7.0.1
 */