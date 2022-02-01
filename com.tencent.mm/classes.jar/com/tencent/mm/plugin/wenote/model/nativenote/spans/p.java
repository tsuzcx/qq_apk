package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Spannable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import java.util.ArrayList;
import java.util.Iterator;

public final class p
{
  final ArrayList<a> pDU;
  
  public p()
  {
    AppMethodBeat.i(30655);
    this.pDU = new ArrayList();
    AppMethodBeat.o(30655);
  }
  
  private void a(Object paramObject, n paramn)
  {
    AppMethodBeat.i(30657);
    if ((paramObject instanceof f)) {
      this.pDU.add(new a(paramObject, paramn, true));
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
    this.pDU.add(new a(paramObject, paramn, false));
    AppMethodBeat.o(30658);
  }
  
  public final void c(Spannable paramSpannable)
  {
    AppMethodBeat.i(30659);
    Iterator localIterator = this.pDU.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      f localf = locala.ETj;
      int m = locala.ETk.avj;
      int i;
      if (locala.pDX)
      {
        i = paramSpannable.getSpanStart(localf);
        if ((i >= 0) && (i < m)) {
          paramSpannable.setSpan(localf.faU(), i, m, 34);
        }
        paramSpannable.removeSpan(localf);
      }
      else
      {
        n localn = locala.ETk;
        int k = locala.ETk.OQ;
        if ((localn.pDT) && (localn.isEmpty())) {
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
          if ((localn.pDT) && (localn.pDS)) {
            i = 18;
          } else if (localn.pDT) {
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
    final f ETj;
    final n ETk;
    final boolean pDX;
    
    a(Object paramObject, n paramn, boolean paramBoolean)
    {
      AppMethodBeat.i(30654);
      this.ETj = ((f)paramObject);
      this.ETk = paramn;
      this.pDX = paramBoolean;
      AppMethodBeat.o(30654);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.p
 * JD-Core Version:    0.7.0.1
 */