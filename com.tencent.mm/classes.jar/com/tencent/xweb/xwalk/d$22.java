package com.tencent.xweb.xwalk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.y;

final class d$22
  implements CompoundButton.OnCheckedChangeListener
{
  d$22(d paramd) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AppMethodBeat.i(154175);
    paramCompoundButton = y.hsF().SzQ.getSharedPreferences("wcwebview", 4);
    if (paramCompoundButton != null)
    {
      paramCompoundButton = paramCompoundButton.edit();
      if (paramCompoundButton != null)
      {
        paramCompoundButton.putBoolean("fr_disable_crash_detect", paramBoolean);
        paramCompoundButton.commit();
      }
    }
    AppMethodBeat.o(154175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.22
 * JD-Core Version:    0.7.0.1
 */