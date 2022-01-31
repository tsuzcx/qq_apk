package com.tencent.xweb.xwalk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.xweb.k;

final class a$36
  implements CompoundButton.OnCheckedChangeListener
{
  a$36(a parama) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = k.cSk();
    if (paramBoolean != paramCompoundButton.xgN)
    {
      paramCompoundButton.xgN = paramBoolean;
      paramCompoundButton.xgK.getSharedPreferences("wcwebview", 0).edit().putBoolean("bShowVersion", paramCompoundButton.xgN).commit();
    }
    if (paramBoolean)
    {
      this.xlg.cTz();
      this.xlg.xla.setVisibility(0);
    }
    while (this.xlg.xla == null) {
      return;
    }
    this.xlg.xla.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.36
 * JD-Core Version:    0.7.0.1
 */