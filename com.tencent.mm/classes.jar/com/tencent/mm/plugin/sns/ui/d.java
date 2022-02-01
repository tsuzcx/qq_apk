package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class d<T>
{
  private ap handler = null;
  List<Integer> zNN = new LinkedList();
  
  public d()
  {
    this.zNN.clear();
  }
  
  public abstract List<T> Zq();
  
  final void fT(final List<T> paramList)
  {
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97699);
        d.this.fU(paramList);
        d locald = d.this;
        boolean bool = this.zNR;
        ag.dFL().post(new d.3(locald, bool));
        AppMethodBeat.o(97699);
      }
    });
  }
  
  public abstract void fU(List<T> paramList);
  
  protected final void nd(final boolean paramBoolean)
  {
    int i;
    int j;
    if (paramBoolean)
    {
      i = 0;
      if (i != 1) {
        break label73;
      }
      Iterator localIterator = this.zNN.iterator();
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
      while (this.zNN.size() <= 1)
      {
        this.zNN.add(Integer.valueOf(i));
        if (!paramBoolean) {
          break label164;
        }
        ag.dFL().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(97698);
            List localList = d.this.Zq();
            d.this.fT(localList);
            AppMethodBeat.o(97698);
          }
        });
        return;
        ad.d("MicroMsg.AdapterLoader", "thread load" + this.zNN.size());
      }
    }
    label164:
    fT(Zq());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d
 * JD-Core Version:    0.7.0.1
 */