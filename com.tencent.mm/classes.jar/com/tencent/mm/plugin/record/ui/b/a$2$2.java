package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.ui.base.n.d;

final class a$2$2
  implements n.d
{
  a$2$2(a.2 param2) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(24338);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(24338);
      return;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Ksnsupload_type", 0);
      paramMenuItem.putExtra("sns_kemdia_path", a.2.d(this.qaj));
      String str = v.oQ("fav_");
      v.aae().z(str, true).i("prePublishId", "fav_");
      paramMenuItem.putExtra("reportSessionId", str);
      d.b(a.2.c(this.qaj), "sns", ".ui.SnsUploadUI", paramMenuItem);
      AppMethodBeat.o(24338);
      return;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Retr_File_Name", a.2.d(this.qaj));
      paramMenuItem.putExtra("Retr_Compress_Type", 0);
      paramMenuItem.putExtra("Retr_Msg_Type", 0);
      d.f(a.2.c(this.qaj), ".ui.transmit.MsgRetransmitUI", paramMenuItem);
      AppMethodBeat.o(24338);
      return;
      if (!q.a(a.2.d(this.qaj), a.2.c(this.qaj), 2131298889)) {
        Toast.makeText(a.2.c(this.qaj), a.2.c(this.qaj).getString(2131299818), 1).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.a.2.2
 * JD-Core Version:    0.7.0.1
 */