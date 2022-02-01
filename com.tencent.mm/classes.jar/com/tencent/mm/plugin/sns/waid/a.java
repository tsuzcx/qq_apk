package com.tencent.mm.plugin.sns.waid;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
  extends b
{
  public final h aqU(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(100584);
        if (TextUtils.isEmpty(paramString))
        {
          AppMethodBeat.o(100584);
          paramString = null;
          return paramString;
        }
        Iterator localIterator = this.xZq.iterator();
        if (localIterator.hasNext())
        {
          h localh = (h)localIterator.next();
          if (!paramString.equals(localh.dvP)) {
            continue;
          }
          AppMethodBeat.o(100584);
          paramString = localh;
          continue;
        }
        AppMethodBeat.o(100584);
      }
      finally {}
      paramString = null;
    }
  }
  
  public final String dEx()
  {
    return "app_waid_sp";
  }
  
  public final String dEy()
  {
    return "app_waid";
  }
  
  public final h dEz()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.waid.a
 * JD-Core Version:    0.7.0.1
 */