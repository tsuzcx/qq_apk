package com.tencent.mm.plugin.sns.waid;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class e
  extends b
{
  public final h aqU(String paramString)
  {
    return null;
  }
  
  public final String dEx()
  {
    return "pub_waid_sp";
  }
  
  public final String dEy()
  {
    return "pub_waid";
  }
  
  public final h dEz()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(100585);
        if (!this.xZq.isEmpty())
        {
          int j = this.xZq.size() - 1;
          int i = j;
          if (i >= 0)
          {
            localh = (h)this.xZq.get(i);
            if (!localh.isExpired())
            {
              AppMethodBeat.o(100585);
              return localh;
            }
            i -= 1;
            continue;
          }
          h localh = (h)this.xZq.get(j);
          AppMethodBeat.o(100585);
          continue;
        }
        Object localObject2 = null;
      }
      finally {}
      AppMethodBeat.o(100585);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.waid.e
 * JD-Core Version:    0.7.0.1
 */