package com.tencent.mm.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.z;

final class MMAppMgr$5
  implements CompoundButton.OnCheckedChangeListener
{
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    au.Hx();
    paramCompoundButton = c.Dz();
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramCompoundButton.o(16385, Boolean.valueOf(paramBoolean));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.MMAppMgr.5
 * JD-Core Version:    0.7.0.1
 */