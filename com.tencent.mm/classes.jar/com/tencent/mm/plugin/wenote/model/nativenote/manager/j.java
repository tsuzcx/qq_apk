package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.n;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class j
  implements Serializable
{
  private static final Pattern xAk;
  int xAl;
  public final ArrayList<n> xAm;
  
  static
  {
    AppMethodBeat.i(30523);
    xAk = Pattern.compile("\\r\\n|\\r|\\n");
    AppMethodBeat.o(30523);
  }
  
  public j(Spanned paramSpanned)
  {
    AppMethodBeat.i(30520);
    this.xAl = 0;
    this.xAm = new ArrayList();
    if (paramSpanned != null)
    {
      paramSpanned = paramSpanned.toString();
      this.xAl = 1;
      Matcher localMatcher = xAk.matcher(paramSpanned);
      int i = 0;
      int j;
      boolean bool1;
      if (localMatcher.find())
      {
        j = localMatcher.end();
        if (this.xAl == 1) {}
        for (bool1 = true;; bool1 = false)
        {
          n localn = new n(i, j, bool1, false);
          this.xAm.add(localn);
          i = localMatcher.end();
          this.xAl += 1;
          break;
        }
      }
      if (this.xAm.size() < this.xAl)
      {
        j = paramSpanned.length();
        bool1 = bool2;
        if (this.xAl == 1) {
          bool1 = true;
        }
        paramSpanned = new n(i, j, bool1, true);
        this.xAm.add(paramSpanned);
      }
    }
    AppMethodBeat.o(30520);
  }
  
  public final int di(int paramInt)
  {
    AppMethodBeat.i(30521);
    int i = 0;
    while ((i < this.xAl) && (paramInt >= ((n)this.xAm.get(i)).uH)) {
      i += 1;
    }
    paramInt = Math.min(Math.max(0, i), this.xAm.size() - 1);
    AppMethodBeat.o(30521);
    return paramInt;
  }
  
  public String toString()
  {
    AppMethodBeat.i(30522);
    StringBuilder localStringBuilder1 = new StringBuilder();
    Iterator localIterator = this.xAm.iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      localObject = (n)localIterator.next();
      StringBuilder localStringBuilder2 = localStringBuilder1.append(i).append(": ").append(((e)localObject).uG).append("-").append(((e)localObject).uH);
      if (((n)localObject).xBO) {}
      for (localObject = "";; localObject = ", ")
      {
        localStringBuilder2.append((String)localObject);
        i += 1;
        break;
      }
    }
    Object localObject = localStringBuilder1.toString();
    AppMethodBeat.o(30522);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.j
 * JD-Core Version:    0.7.0.1
 */