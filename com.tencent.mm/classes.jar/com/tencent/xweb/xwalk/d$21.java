package com.tencent.xweb.xwalk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.c;
import com.tencent.xweb.xwalk.a.g;
import com.tencent.xweb.xwalk.a.h;
import com.tencent.xweb.xwalk.a.m;
import com.tencent.xweb.y;
import java.util.Iterator;
import java.util.List;

final class d$21
  implements CompoundButton.OnCheckedChangeListener
{
  d$21(d paramd) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AppMethodBeat.i(154174);
    paramCompoundButton = y.hsF().SzQ.getSharedPreferences("wcwebview", 4);
    if (paramCompoundButton != null)
    {
      paramCompoundButton = paramCompoundButton.edit();
      if (paramCompoundButton != null)
      {
        paramCompoundButton.putBoolean("fr_disable_cache", paramBoolean);
        paramCompoundButton.commit();
        if (paramBoolean)
        {
          paramCompoundButton = h.hvo().iterator();
          while (paramCompoundButton.hasNext())
          {
            Object localObject = (g)paramCompoundButton.next();
            if ((localObject instanceof m))
            {
              int i = ((g)localObject).hvk();
              if (i >= 0)
              {
                localObject = ((g)localObject).ate(i);
                if (!((String)localObject).isEmpty()) {
                  c.bsB((String)localObject);
                }
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(154174);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.21
 * JD-Core Version:    0.7.0.1
 */