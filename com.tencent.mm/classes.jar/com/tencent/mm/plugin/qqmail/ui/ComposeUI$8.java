package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.s;

final class ComposeUI$8
  implements View.OnClickListener
{
  ComposeUI$8(ComposeUI paramComposeUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.ngJ;
    String str1 = this.ngJ.getString(b.j.plugin_qqmail_composeui_attach_take_phote);
    String str2 = this.ngJ.getString(b.j.plugin_qqmail_composeui_attach_choose_album);
    String str3 = this.ngJ.getString(b.j.plugin_qqmail_composeui_attach_choose_file);
    h.c local1 = new h.c()
    {
      public final void gl(int paramAnonymousInt)
      {
        switch (paramAnonymousInt)
        {
        default: 
        case 0: 
          boolean bool;
          do
          {
            return;
            bool = a.a(ComposeUI.8.this.ngJ.mController.uMN, "android.permission.CAMERA", 16, "", "");
            y.i("MicroMsg.ComposeUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bk.csb(), ComposeUI.8.this.ngJ.mController.uMN });
          } while (!bool);
          ComposeUI.C(ComposeUI.8.this.ngJ);
          return;
        case 1: 
          l.a(ComposeUI.8.this.ngJ, 4, null);
          return;
        }
        Intent localIntent = new Intent(ComposeUI.8.this.ngJ, FileExplorerUI.class);
        ComposeUI.8.this.ngJ.startActivityForResult(localIntent, 5);
      }
    };
    h.a(paramView, null, new String[] { str1, str2, str3 }, null, local1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.8
 * JD-Core Version:    0.7.0.1
 */