package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.n;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class j
  implements Serializable
{
  private static final Pattern vzv;
  int vzw;
  public final ArrayList<n> vzx;
  
  static
  {
    AppMethodBeat.i(26830);
    vzv = Pattern.compile("\\r\\n|\\r|\\n");
    AppMethodBeat.o(26830);
  }
  
  public j(Spanned paramSpanned)
  {
    AppMethodBeat.i(26827);
    this.vzw = 0;
    this.vzx = new ArrayList();
    if (paramSpanned != null)
    {
      paramSpanned = paramSpanned.toString();
      this.vzw = 1;
      Matcher localMatcher = vzv.matcher(paramSpanned);
      int i = 0;
      int j;
      boolean bool1;
      if (localMatcher.find())
      {
        j = localMatcher.end();
        if (this.vzw == 1) {}
        for (bool1 = true;; bool1 = false)
        {
          n localn = new n(i, j, bool1, false);
          this.vzx.add(localn);
          i = localMatcher.end();
          this.vzw += 1;
          break;
        }
      }
      if (this.vzx.size() < this.vzw)
      {
        j = paramSpanned.length();
        bool1 = bool2;
        if (this.vzw == 1) {
          bool1 = true;
        }
        paramSpanned = new n(i, j, bool1, true);
        this.vzx.add(paramSpanned);
      }
    }
    AppMethodBeat.o(26827);
  }
  
  public final int getLineForOffset(int paramInt)
  {
    AppMethodBeat.i(26828);
    int i = 0;
    while ((i < this.vzw) && (paramInt >= ((n)this.vzx.get(i)).Fe)) {
      i += 1;
    }
    paramInt = Math.min(Math.max(0, i), this.vzx.size() - 1);
    AppMethodBeat.o(26828);
    return paramInt;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(26829);
    StringBuilder localStringBuilder1 = new StringBuilder();
    Iterator localIterator = this.vzx.iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      localObject = (n)localIterator.next();
      StringBuilder localStringBuilder2 = localStringBuilder1.append(i).append(": ").append(((e)localObject).akX).append("-").append(((e)localObject).Fe);
      if (((n)localObject).vBc) {}
      for (localObject = "";; localObject = ", ")
      {
        localStringBuilder2.append((String)localObject);
        i += 1;
        break;
      }
    }
    Object localObject = localStringBuilder1.toString();
    AppMethodBeat.o(26829);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.j
 * JD-Core Version:    0.7.0.1
 */