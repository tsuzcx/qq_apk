package com.tencent.mm.ui.chatting;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.textview.a;
import com.tencent.mm.ui.widget.textview.a.b;

final class TextPreviewUI$9
  implements n.d
{
  TextPreviewUI$9(TextPreviewUI paramTextPreviewUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    case 0: 
      ((ClipboardManager)this.vnn.mController.uMN.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(TextPreviewUI.b(this.vnn), TextPreviewUI.b(this.vnn)));
      if (TextPreviewUI.c(this.vnn) != null)
      {
        TextPreviewUI.c(this.vnn).cKJ();
        TextPreviewUI.c(this.vnn).cKI();
      }
      Toast.makeText(this.vnn.mController.uMN, this.vnn.mController.uMN.getString(R.l.app_copy_ok), 0).show();
      return;
    case 1: 
      if (TextPreviewUI.c(this.vnn) != null)
      {
        TextPreviewUI.c(this.vnn).cKI();
        paramMenuItem = TextPreviewUI.c(this.vnn);
        paramMenuItem.cbz = true;
        if (paramMenuItem.wsk != null) {
          paramMenuItem.wsk.wsB.dismiss();
        }
        if (paramMenuItem.wsl != null) {
          paramMenuItem.wsl.wsB.dismiss();
        }
        TextPreviewUI.c(this.vnn).fP(0, TextPreviewUI.a(this.vnn).getText().length());
        TextPreviewUI.c(this.vnn).cbz = false;
        paramMenuItem = TextPreviewUI.c(this.vnn);
        paramMenuItem.a(paramMenuItem.wsk);
        paramMenuItem.a(paramMenuItem.wsl);
      }
      ai.l(new TextPreviewUI.9.1(this), 100L);
      return;
    }
    TextPreviewUI.c(this.vnn.mController.uMN, TextPreviewUI.b(this.vnn));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.TextPreviewUI.9
 * JD-Core Version:    0.7.0.1
 */