package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.text.Spanned;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.n;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class j
  implements Serializable
{
  private static final Pattern rIP = Pattern.compile("\\r\\n|\\r|\\n");
  int rIQ = 0;
  public final ArrayList<n> rIR = new ArrayList();
  
  public j(Spanned paramSpanned)
  {
    if (paramSpanned != null)
    {
      paramSpanned = paramSpanned.toString();
      this.rIQ = 1;
      Matcher localMatcher = rIP.matcher(paramSpanned);
      int i = 0;
      int j;
      boolean bool1;
      if (localMatcher.find())
      {
        j = localMatcher.end();
        if (this.rIQ == 1) {}
        for (bool1 = true;; bool1 = false)
        {
          n localn = new n(i, j, bool1, false);
          this.rIR.add(localn);
          i = localMatcher.end();
          this.rIQ += 1;
          break;
        }
      }
      if (this.rIR.size() < this.rIQ)
      {
        j = paramSpanned.length();
        bool1 = bool2;
        if (this.rIQ == 1) {
          bool1 = true;
        }
        paramSpanned = new n(i, j, bool1, true);
        this.rIR.add(paramSpanned);
      }
    }
  }
  
  public final int getLineForOffset(int paramInt)
  {
    int i = 0;
    while ((i < this.rIQ) && (paramInt >= ((n)this.rIR.get(i)).Eo)) {
      i += 1;
    }
    return Math.min(Math.max(0, i), this.rIR.size() - 1);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    Iterator localIterator = this.rIR.iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      Object localObject = (n)localIterator.next();
      StringBuilder localStringBuilder2 = localStringBuilder1.append(i).append(": ").append(((e)localObject).aiH).append("-").append(((e)localObject).Eo);
      if (((n)localObject).rKy) {}
      for (localObject = "";; localObject = ", ")
      {
        localStringBuilder2.append((String)localObject);
        i += 1;
        break;
      }
    }
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.j
 * JD-Core Version:    0.7.0.1
 */