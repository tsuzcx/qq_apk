package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.shake.b.e;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.i.1;
import com.tencent.mm.sdk.platformtools.ai;

final class ShakeItemListUI$1$1
  implements DialogInterface.OnClickListener
{
  ShakeItemListUI$1$1(ShakeItemListUI.1 param1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (ShakeItemListUI.a(this.obF.obE))
    {
    }
    for (;;)
    {
      ShakeItemListUI.b(this.obF.obE).yc();
      ShakeItemListUI.c(this.obF.obE).setVisibility(8);
      paramDialogInterface = (TextView)this.obF.obE.findViewById(R.h.nearby_friend_not_found);
      paramDialogInterface.setText(ShakeItemListUI.xr(ShakeItemListUI.a(this.obF.obE)));
      paramDialogInterface.setVisibility(0);
      this.obF.obE.enableOptionMenu(false);
      return;
      m.bzU().xk(0);
      m.bzU().bzL();
      continue;
      m.bzU().xk(0);
      continue;
      au.DS().O(new i.1());
      m.bzU().xk(4);
      continue;
      m.bzU().xk(7);
      m.bzU().xk(6);
      m.bzU().xk(8);
      m.bzU().xk(9);
      m.bzU().xk(10);
      m.bzU().xk(12);
      continue;
      m.bzU().xk(11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeItemListUI.1.1
 * JD-Core Version:    0.7.0.1
 */