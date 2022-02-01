package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class d<T>
{
  private ap handler = null;
  List<Integer> xjI = new LinkedList();
  
  public d()
  {
    this.xjI.clear();
  }
  
  public abstract List<T> VZ();
  
  final void fA(final List<T> paramList)
  {
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97699);
        d.this.fB(paramList);
        d locald = d.this;
        boolean bool = this.xjM;
        af.dhI().post(new d.3(locald, bool));
        AppMethodBeat.o(97699);
      }
    });
  }
  
  public abstract void fB(List<T> paramList);
  
  protected final void lQ(final boolean paramBoolean)
  {
    int i;
    int j;
    if (paramBoolean)
    {
      i = 0;
      if (i != 1) {
        break label73;
      }
      Iterator localIterator = this.xjI.iterator();
      while (localIterator.hasNext()) {
        if (((Integer)localIterator.next()).intValue() == 1)
        {
          j = 1;
          label51:
          if (j == 0) {
            break label73;
          }
          ad.e("MicroMsg.AdapterLoader", "thread is loading ui should be not load any");
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
        ad.d("MicroMsg.AdapterLoader", "ui load");
      }
      while (this.xjI.size() <= 1)
      {
        this.xjI.add(Integer.valueOf(i));
        if (!paramBoolean) {
          break label164;
        }
        af.dhI().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(97698);
            List localList = d.this.VZ();
            d.this.fA(localList);
            AppMethodBeat.o(97698);
          }
        });
        return;
        ad.d("MicroMsg.AdapterLoader", "thread load" + this.xjI.size());
      }
    }
    label164:
    fA(VZ());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d
 * JD-Core Version:    0.7.0.1
 */