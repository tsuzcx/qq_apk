package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class d<T>
{
  List<Integer> Rah = new LinkedList();
  private MMHandler handler = null;
  
  public d()
  {
    this.Rah.clear();
  }
  
  public abstract List<T> aNv();
  
  final void kH(final List<T> paramList)
  {
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97699);
        d.this.kI(paramList);
        d locald = d.this;
        boolean bool = this.Ral;
        al.gHI().post(new d.3(locald, bool));
        AppMethodBeat.o(97699);
      }
    });
  }
  
  public abstract void kI(List<T> paramList);
  
  protected final void wq(final boolean paramBoolean)
  {
    int i;
    int j;
    if (paramBoolean)
    {
      i = 0;
      if (i != 1) {
        break label73;
      }
      Iterator localIterator = this.Rah.iterator();
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
      while (this.Rah.size() <= 1)
      {
        this.Rah.add(Integer.valueOf(i));
        if (!paramBoolean) {
          break label164;
        }
        al.gHI().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(97698);
            List localList = d.this.aNv();
            d.this.kH(localList);
            AppMethodBeat.o(97698);
          }
        });
        return;
        Log.d("MicroMsg.AdapterLoader", "thread load" + this.Rah.size());
      }
    }
    label164:
    kH(aNv());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d
 * JD-Core Version:    0.7.0.1
 */