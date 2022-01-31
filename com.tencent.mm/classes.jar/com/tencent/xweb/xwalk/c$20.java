package com.tencent.xweb.xwalk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.q;

final class c$20
  implements CompoundButton.OnCheckedChangeListener
{
  c$20(c paramc) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AppMethodBeat.i(139555);
    q.dYn().BDH.getSharedPreferences("wcwebview", 4).edit().putBoolean("fr_disable_crash_detect", paramBoolean).commit();
    AppMethodBeat.o(139555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c.20
 * JD-Core Version:    0.7.0.1
 */