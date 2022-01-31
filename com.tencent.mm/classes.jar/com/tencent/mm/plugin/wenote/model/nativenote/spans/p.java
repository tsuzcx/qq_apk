package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Spannable;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import java.util.ArrayList;
import java.util.Iterator;

public final class p
{
  final ArrayList<a> rKE = new ArrayList();
  
  public final void a(Object paramObject, n paramn)
  {
    this.rKE.add(new a(paramObject, paramn, false));
  }
  
  public final void a(ArrayList<Object> paramArrayList, n paramn)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Object localObject = paramArrayList.next();
      if ((localObject instanceof f)) {
        this.rKE.add(new a(localObject, paramn, true));
      }
    }
  }
  
  public final void c(Spannable paramSpannable)
  {
    Iterator localIterator = this.rKE.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      f localf = locala.rKF;
      int m = locala.rKG.aiH;
      int i;
      if (locala.rKH)
      {
        i = paramSpannable.getSpanStart(localf);
        if ((i >= 0) && (i < m)) {
          paramSpannable.setSpan(localf.cjc(), i, m, 34);
        }
        paramSpannable.removeSpan(localf);
      }
      else
      {
        n localn = locala.rKG;
        int k = locala.rKG.Eo;
        if ((localn.rKy) && (localn.isEmpty())) {
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
          if ((localn.rKy) && (localn.rKx)) {
            i = 18;
          } else if (localn.rKy) {
            i = 34;
          } else {
            i = 33;
          }
        }
      }
    }
  }
  
  private static final class a
  {
    final f rKF;
    final n rKG;
    final boolean rKH;
    
    a(Object paramObject, n paramn, boolean paramBoolean)
    {
      this.rKF = ((f)paramObject);
      this.rKG = paramn;
      this.rKH = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.p
 * JD-Core Version:    0.7.0.1
 */