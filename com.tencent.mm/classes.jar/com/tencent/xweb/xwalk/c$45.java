package com.tencent.xweb.xwalk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.q;

final class c$45
  implements CompoundButton.OnCheckedChangeListener
{
  c$45(c paramc) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AppMethodBeat.i(85170);
    paramCompoundButton = q.dYn();
    if (paramBoolean != paramCompoundButton.BDK)
    {
      paramCompoundButton.BDK = paramBoolean;
      paramCompoundButton.BDH.getSharedPreferences("wcwebview", 0).edit().putBoolean("bShowVersion", paramCompoundButton.BDK).commit();
    }
    if (paramBoolean)
    {
      this.BIO.dZZ();
      this.BIO.BIH.setVisibility(0);
      AppMethodBeat.o(85170);
      return;
    }
    if (this.BIO.BIH != null) {
      this.BIO.BIH.setVisibility(8);
    }
    AppMethodBeat.o(85170);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c.45
 * JD-Core Version:    0.7.0.1
 */