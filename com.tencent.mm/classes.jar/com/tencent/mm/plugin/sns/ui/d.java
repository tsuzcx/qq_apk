package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class d<T>
{
  List<Integer> KAA = new LinkedList();
  private MMHandler handler = null;
  
  public d()
  {
    this.KAA.clear();
  }
  
  public abstract List<T> ato();
  
  final void hG(final List<T> paramList)
  {
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97699);
        d.this.hH(paramList);
        d locald = d.this;
        boolean bool = this.KAE;
        aj.fwa().post(new d.3(locald, bool));
        AppMethodBeat.o(97699);
      }
    });
  }
  
  public abstract void hH(List<T> paramList);
  
  protected final void sk(final boolean paramBoolean)
  {
    int i;
    int j;
    if (paramBoolean)
    {
      i = 0;
      if (i != 1) {
        break label73;
      }
      Iterator localIterator = this.KAA.iterator();
      while (localIterator.hasNext()) {
        if (((Integer)localIterator.next()).intValue() == 1)
        {
          j = 1;
          label51:
          if (j == 0) {
            break label73;
          }
          Log.e("MicroMsg.AdapterLoader", "thread is loading ui should be not load any");
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
        Log.d("MicroMsg.AdapterLoader", "ui load");
      }
      while (this.KAA.size() <= 1)
      {
        this.KAA.add(Integer.valueOf(i));
        if (!paramBoolean) {
          break label164;
        }
        aj.fwa().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(97698);
            List localList = d.this.ato();
            d.this.hG(localList);
            AppMethodBeat.o(97698);
          }
        });
        return;
        Log.d("MicroMsg.AdapterLoader", "thread load" + this.KAA.size());
      }
    }
    label164:
    hG(ato());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d
 * JD-Core Version:    0.7.0.1
 */