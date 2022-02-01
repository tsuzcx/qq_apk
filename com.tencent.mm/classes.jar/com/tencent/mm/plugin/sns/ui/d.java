package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class d<T>
{
  List<Integer> AeU = new LinkedList();
  private aq handler = null;
  
  public d()
  {
    this.AeU.clear();
  }
  
  public abstract List<T> Zz();
  
  final void gc(final List<T> paramList)
  {
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97699);
        d.this.gd(paramList);
        d locald = d.this;
        boolean bool = this.AeY;
        ah.dJc().post(new d.3(locald, bool));
        AppMethodBeat.o(97699);
      }
    });
  }
  
  public abstract void gd(List<T> paramList);
  
  protected final void nh(final boolean paramBoolean)
  {
    int i;
    int j;
    if (paramBoolean)
    {
      i = 0;
      if (i != 1) {
        break label73;
      }
      Iterator localIterator = this.AeU.iterator();
      while (localIterator.hasNext()) {
        if (((Integer)localIterator.next()).intValue() == 1)
        {
          j = 1;
          label51:
          if (j == 0) {
            break label73;
          }
          ae.e("MicroMsg.AdapterLoader", "thread is loading ui should be not load any");
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
        ae.d("MicroMsg.AdapterLoader", "ui load");
      }
      while (this.AeU.size() <= 1)
      {
        this.AeU.add(Integer.valueOf(i));
        if (!paramBoolean) {
          break label164;
        }
        ah.dJc().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(97698);
            List localList = d.this.Zz();
            d.this.gc(localList);
            AppMethodBeat.o(97698);
          }
        });
        return;
        ae.d("MicroMsg.AdapterLoader", "thread load" + this.AeU.size());
      }
    }
    label164:
    gc(Zz());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d
 * JD-Core Version:    0.7.0.1
 */