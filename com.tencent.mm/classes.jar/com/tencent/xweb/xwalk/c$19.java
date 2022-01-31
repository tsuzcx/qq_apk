package com.tencent.xweb.xwalk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.q;
import com.tencent.xweb.xwalk.a.e;

final class c$19
  implements CompoundButton.OnCheckedChangeListener
{
  c$19(c paramc) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AppMethodBeat.i(139554);
    q.dYn().BDH.getSharedPreferences("wcwebview", 4).edit().putBoolean("fr_disable_cache", paramBoolean).commit();
    if (paramBoolean)
    {
      paramCompoundButton = (com.tencent.xweb.xwalk.a.b)e.ayq("XFilesPPTReader");
      if (paramCompoundButton != null)
      {
        int i = paramCompoundButton.BKm;
        if (i >= 0)
        {
          paramCompoundButton = paramCompoundButton.TK(i);
          if (!paramCompoundButton.isEmpty()) {
            com.tencent.xweb.util.b.ayf(paramCompoundButton);
          }
        }
      }
    }
    AppMethodBeat.o(139554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c.19
 * JD-Core Version:    0.7.0.1
 */