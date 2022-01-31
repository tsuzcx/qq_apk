package com.tencent.mm.plugin.record.ui;

import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.n.d;
import java.io.File;

final class RecordMsgFileUI$11$2
  implements n.d
{
  RecordMsgFileUI$11$2(RecordMsgFileUI.11 param11) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    }
    if (RecordMsgFileUI.c(this.nuh.nue) == 8)
    {
      paramMenuItem = h.c(RecordMsgFileUI.a(this.nuh.nue), RecordMsgFileUI.b(this.nuh.nue));
      if (!e.bK(paramMenuItem))
      {
        y.e("MicroMsg.RecordMsgFileUI", "share file failed, file not exists");
        Toast.makeText(this.nuh.nue, this.nuh.nue.getString(R.l.favorite_share_file_not_exists), 1).show();
        return;
      }
      if (new File(paramMenuItem).length() > 10485760L)
      {
        y.e("MicroMsg.RecordMsgFileUI", "share file failed, file too large");
        Toast.makeText(this.nuh.nue, this.nuh.nue.getString(R.l.favorite_share_too_large), 1).show();
        return;
      }
    }
    RecordMsgFileUI.h(this.nuh.nue);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgFileUI.11.2
 * JD-Core Version:    0.7.0.1
 */