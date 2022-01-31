package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class ReadMailUI$7
  implements View.OnClickListener
{
  ReadMailUI$7(ReadMailUI paramReadMailUI) {}
  
  public final void onClick(View paramView)
  {
    switch (ReadMailUI.w(this.njK))
    {
    default: 
      return;
    case 0: 
      ReadMailUI.a(this.njK, 2);
      if ((!bk.bl(ReadMailUI.x(this.njK))) && (!bk.bl(ReadMailUI.y(this.njK))))
      {
        ReadMailUI.z(this.njK);
        return;
      }
      ReadMailUI.A(this.njK);
      return;
    case 1: 
      ReadMailUI.a(this.njK, 1);
      int i = ((Integer)new ReadMailProxy(ReadMailUI.l(this.njK), null).REMOTE_CALL("removeDownloadQQMailAppTask", new Object[] { Long.valueOf(ReadMailUI.B(this.njK)) })).intValue();
      if (i == -1)
      {
        y.e("MicroMsg.ReadMailUI", "cancel_download_task:fail_apilevel_too_low downloadId = %d", new Object[] { Long.valueOf(ReadMailUI.B(this.njK)) });
        return;
      }
      if (i <= 0)
      {
        y.e("MicroMsg.ReadMailUI", "cancel_download_task:fail downloadId = %d", new Object[] { Long.valueOf(ReadMailUI.B(this.njK)) });
        return;
      }
      y.i("MicroMsg.ReadMailUI", "cancel_download_task:ok downloadId = %d", new Object[] { Long.valueOf(ReadMailUI.B(this.njK)) });
      ReadMailUI.C(this.njK).stopTimer();
      ReadMailUI.b(this.njK, 0);
      ReadMailUI.D(this.njK);
      ReadMailUI.p(this.njK);
      return;
    case 2: 
      ReadMailUI.a(this.njK, 3);
      ReadMailUI.E(this.njK);
      return;
    }
    ReadMailUI.a(this.njK, 4);
    ReadMailUI.F(this.njK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI.7
 * JD-Core Version:    0.7.0.1
 */