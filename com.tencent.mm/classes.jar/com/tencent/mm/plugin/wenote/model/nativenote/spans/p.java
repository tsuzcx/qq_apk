package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Spannable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import java.util.ArrayList;
import java.util.Iterator;

public final class p
{
  final ArrayList<a> pxq;
  
  public p()
  {
    AppMethodBeat.i(30655);
    this.pxq = new ArrayList();
    AppMethodBeat.o(30655);
  }
  
  private void a(Object paramObject, n paramn)
  {
    AppMethodBeat.i(30657);
    if ((paramObject instanceof f)) {
      this.pxq.add(new a(paramObject, paramn, true));
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
    this.pxq.add(new a(paramObject, paramn, false));
    AppMethodBeat.o(30658);
  }
  
  public final void c(Spannable paramSpannable)
  {
    AppMethodBeat.i(30659);
    Iterator localIterator = this.pxq.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      f localf = locala.EAN;
      int m = locala.EAO.avj;
      int i;
      if (locala.pxt)
      {
        i = paramSpannable.getSpanStart(localf);
        if ((i >= 0) && (i < m)) {
          paramSpannable.setSpan(localf.eXi(), i, m, 34);
        }
        paramSpannable.removeSpan(localf);
      }
      else
      {
        n localn = locala.EAO;
        int k = locala.EAO.OQ;
        if ((localn.pxp) && (localn.isEmpty())) {
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
          if ((localn.pxp) && (localn.pxo)) {
            i = 18;
          } else if (localn.pxp) {
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
    final f EAN;
    final n EAO;
    final boolean pxt;
    
    a(Object paramObject, n paramn, boolean paramBoolean)
    {
      AppMethodBeat.i(30654);
      this.EAN = ((f)paramObject);
      this.EAO = paramn;
      this.pxt = paramBoolean;
      AppMethodBeat.o(30654);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.p
 * JD-Core Version:    0.7.0.1
 */