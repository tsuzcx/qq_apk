package com.tencent.mm.ui;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.z;

final class HomeUI$13
  implements Runnable
{
  HomeUI$13(HomeUI paramHomeUI) {}
  
  public final void run()
  {
    if (au.DK())
    {
      au.Hx();
      z localz = c.Dz();
      if (localz != null) {
        localz.mC(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.13
 * JD-Core Version:    0.7.0.1
 */