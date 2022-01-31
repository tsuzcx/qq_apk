package com.tencent.mm.pluginsdk.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.Toast;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.m.b;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.pluginsdk.ui.c.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.io.File;
import java.util.ArrayList;

final class NewFileExplorerUI$a$4
  implements View.OnClickListener
{
  NewFileExplorerUI$a$4(NewFileExplorerUI.a parama) {}
  
  public final void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    File localFile = this.smW.slP[i];
    paramView = (CheckBox)paramView.findViewById(R.h.item_selector);
    if (NewFileExplorerUI.a.a(this.smW).contains(localFile))
    {
      NewFileExplorerUI.a.a(this.smW).remove(localFile);
      paramView.setChecked(false);
    }
    for (;;)
    {
      NewFileExplorerUI.h(this.smW.smS);
      return;
      if (NewFileExplorerUI.a.a(this.smW).size() >= 9)
      {
        com.tencent.mm.ui.base.s.makeText(this.smW.smS.mController.uMN, this.smW.smS.getString(R.l.file_selector_too_more, new Object[] { Integer.valueOf(9) }), 0).show();
        paramView.setChecked(false);
        return;
      }
      long l = Math.max(bk.getInt(g.AA().getValue("InputLimitFileSize"), 104857600), 104857600);
      if (localFile.length() >= l)
      {
        com.tencent.mm.ui.base.s.makeText(this.smW.smS.mController.uMN, this.smW.smS.getString(R.l.file_selector_too_big, new Object[] { bk.cm(l) }), 0).show();
        paramView.setChecked(false);
        return;
      }
      if (NewFileExplorerUI.a.aw(localFile.getName()))
      {
        a locala = a.WN(localFile.getPath());
        locala.mSize = b.Aj();
        if (locala.cnU() == 1)
        {
          h.h(this.smW.smS.mController.uMN, R.l.video_selector_too_big, R.l.app_tip);
          paramView.setChecked(false);
          return;
        }
      }
      paramView.setChecked(true);
      NewFileExplorerUI.a.a(this.smW).add(localFile);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI.a.4
 * JD-Core Version:    0.7.0.1
 */