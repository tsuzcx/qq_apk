package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Spannable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import java.util.ArrayList;
import java.util.Iterator;

public final class p
{
  final ArrayList<a> vBi;
  
  public p()
  {
    AppMethodBeat.i(26961);
    this.vBi = new ArrayList();
    AppMethodBeat.o(26961);
  }
  
  private void a(Object paramObject, n paramn)
  {
    AppMethodBeat.i(26963);
    if ((paramObject instanceof f)) {
      this.vBi.add(new a(paramObject, paramn, true));
    }
    AppMethodBeat.o(26963);
  }
  
  public final void a(ArrayList<Object> paramArrayList, n paramn)
  {
    AppMethodBeat.i(26962);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      a(paramArrayList.next(), paramn);
    }
    AppMethodBeat.o(26962);
  }
  
  public final void b(Object paramObject, n paramn)
  {
    AppMethodBeat.i(26964);
    this.vBi.add(new a(paramObject, paramn, false));
    AppMethodBeat.o(26964);
  }
  
  public final void c(Spannable paramSpannable)
  {
    AppMethodBeat.i(26965);
    Iterator localIterator = this.vBi.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      f localf = locala.vBj;
      int m = locala.vBk.akX;
      int i;
      if (locala.vBl)
      {
        i = paramSpannable.getSpanStart(localf);
        if ((i >= 0) && (i < m)) {
          paramSpannable.setSpan(localf.djD(), i, m, 34);
        }
        paramSpannable.removeSpan(localf);
      }
      else
      {
        n localn = locala.vBk;
        int k = locala.vBk.Fe;
        if ((localn.vBc) && (localn.isEmpty())) {
          i = 34;
        }
        for (;;)
        {
          int j = k;
          if (k > paramSpannable.length()) {
            j = paramSpannable.length();
          }
          paramSpannable.setSpan(localf, m, j, i);
          break;
          if ((localn.vBc) && (localn.vBb)) {
            i = 18;
          } else if (localn.vBc) {
            i = 34;
          } else {
            i = 33;
          }
        }
      }
    }
    AppMethodBeat.o(26965);
  }
  
  static final class a
  {
    final f vBj;
    final n vBk;
    final boolean vBl;
    
    a(Object paramObject, n paramn, boolean paramBoolean)
    {
      AppMethodBeat.i(26960);
      this.vBj = ((f)paramObject);
      this.vBk = paramn;
      this.vBl = paramBoolean;
      AppMethodBeat.o(26960);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.p
 * JD-Core Version:    0.7.0.1
 */