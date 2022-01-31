package com.tencent.mm.plugin.welab.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.welab.d.b;
import com.tencent.mm.plugin.welab.ui.WelabMainUI;

public final class c
  implements com.tencent.mm.plugin.welab.a.a.c
{
  public final boolean chg()
  {
    b.chq();
    return (b.chs()) && (!chh());
  }
  
  public final boolean chh()
  {
    b.chq();
    if (!b.cht())
    {
      b.chq();
      if (b.chs()) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean chi()
  {
    return !chh();
  }
  
  public final void w(Context paramContext, Intent paramIntent)
  {
    paramIntent.setClass(paramContext, WelabMainUI.class);
    if ((chg()) || (chh())) {}
    for (int i = 1;; i = 0)
    {
      paramIntent.putExtra("para_from_with_red_point", i);
      paramContext.startActivity(paramIntent);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.a.c
 * JD-Core Version:    0.7.0.1
 */