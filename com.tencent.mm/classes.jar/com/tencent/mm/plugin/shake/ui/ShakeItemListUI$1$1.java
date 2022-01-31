package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.shake.b.e;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.i.1;
import com.tencent.mm.sdk.platformtools.al;

final class ShakeItemListUI$1$1
  implements DialogInterface.OnClickListener
{
  ShakeItemListUI$1$1(ShakeItemListUI.1 param1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(24719);
    switch (ShakeItemListUI.a(this.qPM.qPL))
    {
    }
    for (;;)
    {
      ShakeItemListUI.b(this.qPM.qPL).Ku();
      ShakeItemListUI.c(this.qPM.qPL).setVisibility(8);
      paramDialogInterface = (TextView)this.qPM.qPL.findViewById(2131826489);
      paramDialogInterface.setText(ShakeItemListUI.Dr(ShakeItemListUI.a(this.qPM.qPL)));
      paramDialogInterface.setVisibility(0);
      this.qPM.qPL.enableOptionMenu(false);
      AppMethodBeat.o(24719);
      return;
      m.cln().Dj(0);
      m.cln().clc();
      continue;
      m.cln().Dj(0);
      continue;
      aw.RO().ac(new i.1());
      m.cln().Dj(4);
      continue;
      m.cln().Dj(7);
      m.cln().Dj(6);
      m.cln().Dj(8);
      m.cln().Dj(9);
      m.cln().Dj(10);
      m.cln().Dj(12);
      continue;
      m.cln().Dj(11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeItemListUI.1.1
 * JD-Core Version:    0.7.0.1
 */