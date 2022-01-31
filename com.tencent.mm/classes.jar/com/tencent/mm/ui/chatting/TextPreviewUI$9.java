package com.tencent.mm.ui.chatting;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.textview.a;

final class TextPreviewUI$9
  implements n.d
{
  TextPreviewUI$9(TextPreviewUI paramTextPreviewUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(31053);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(31053);
      return;
      ((ClipboardManager)ah.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(TextPreviewUI.c(this.zCJ), TextPreviewUI.c(this.zCJ)));
      if (TextPreviewUI.d(this.zCJ) != null)
      {
        TextPreviewUI.d(this.zCJ).dPQ();
        TextPreviewUI.d(this.zCJ).ANj = true;
        TextPreviewUI.d(this.zCJ).ANk = true;
        TextPreviewUI.d(this.zCJ).dPP();
      }
      Toast.makeText(this.zCJ.getContext(), 2131296896, 0).show();
      AppMethodBeat.o(31053);
      return;
      if (TextPreviewUI.d(this.zCJ) != null)
      {
        TextPreviewUI.d(this.zCJ).dPP();
        TextPreviewUI.d(this.zCJ).dPT();
        TextPreviewUI.d(this.zCJ).hZ(0, TextPreviewUI.a(this.zCJ).getText().length());
        TextPreviewUI.d(this.zCJ).ANj = false;
        TextPreviewUI.d(this.zCJ).ANk = false;
        TextPreviewUI.d(this.zCJ).dPS();
      }
      al.p(new TextPreviewUI.9.1(this), 100L);
      AppMethodBeat.o(31053);
      return;
      TextPreviewUI.e(this.zCJ.getContext(), TextPreviewUI.c(this.zCJ));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.TextPreviewUI.9
 * JD-Core Version:    0.7.0.1
 */