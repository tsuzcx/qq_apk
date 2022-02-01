package com.tencent.xweb.xwalk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.y;

final class d$45
  implements CompoundButton.OnCheckedChangeListener
{
  d$45(d paramd) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AppMethodBeat.i(154208);
    paramCompoundButton = y.hsF();
    if (paramBoolean != paramCompoundButton.SzT)
    {
      paramCompoundButton.SzT = paramBoolean;
      paramCompoundButton.SzQ.getSharedPreferences("wcwebview", 0).edit().putBoolean("bShowVersion", paramCompoundButton.SzT).commit();
    }
    if (paramBoolean)
    {
      this.SGe.huO();
      this.SGe.SFT.setVisibility(0);
      AppMethodBeat.o(154208);
      return;
    }
    if (this.SGe.SFT != null) {
      this.SGe.SFT.setVisibility(8);
    }
    AppMethodBeat.o(154208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.45
 * JD-Core Version:    0.7.0.1
 */