package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Spannable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import java.util.ArrayList;
import java.util.Iterator;

public final class p
{
  final ArrayList<a> xBP;
  
  public p()
  {
    AppMethodBeat.i(30655);
    this.xBP = new ArrayList();
    AppMethodBeat.o(30655);
  }
  
  private void a(Object paramObject, n paramn)
  {
    AppMethodBeat.i(30657);
    if ((paramObject instanceof f)) {
      this.xBP.add(new a(paramObject, paramn, true));
    }
    AppMethodBeat.o(30657);
  }
  
  public final void a(ArrayList<Object> paramArrayList, n paramn)
  {
    AppMethodBeat.i(30656);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      a(paramArrayList.next(), paramn);
    }
    AppMethodBeat.o(30656);
  }
  
  public final void b(Object paramObject, n paramn)
  {
    AppMethodBeat.i(30658);
    this.xBP.add(new a(paramObject, paramn, false));
    AppMethodBeat.o(30658);
  }
  
  public final void c(Spannable paramSpannable)
  {
    AppMethodBeat.i(30659);
    Iterator localIterator = this.xBP.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      f localf = locala.XBO;
      int m = locala.XBP.uG;
      int i;
      if (locala.xBS)
      {
        i = paramSpannable.getSpanStart(localf);
        if ((i >= 0) && (i < m)) {
          paramSpannable.setSpan(localf.iEu(), i, m, 34);
        }
        paramSpannable.removeSpan(localf);
      }
      else
      {
        n localn = locala.XBP;
        int k = locala.XBP.uH;
        if ((localn.xBO) && (localn.isEmpty())) {
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
          if ((localn.xBO) && (localn.xBN)) {
            i = 18;
          } else if (localn.xBO) {
            i = 34;
          } else {
            i = 33;
          }
        }
      }
    }
    AppMethodBeat.o(30659);
  }
  
  static final class a
  {
    final f XBO;
    final n XBP;
    final boolean xBS;
    
    a(Object paramObject, n paramn, boolean paramBoolean)
    {
      AppMethodBeat.i(30654);
      this.XBO = ((f)paramObject);
      this.XBP = paramn;
      this.xBS = paramBoolean;
      AppMethodBeat.o(30654);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.p
 * JD-Core Version:    0.7.0.1
 */