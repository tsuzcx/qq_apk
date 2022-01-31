package com.tencent.mm.plugin.scanner.ui;

import android.os.Message;
import android.widget.TextView;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.ah;

final class q$2
  extends ah
{
  q$2(q paramq) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if (q.f(this.nMN) != null)
    {
      this.nMN.nLB.ix(true);
      q.f(this.nMN).setText(R.l.scan_street_view_not_found_tips);
      q.f(this.nMN).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.q.2
 * JD-Core Version:    0.7.0.1
 */