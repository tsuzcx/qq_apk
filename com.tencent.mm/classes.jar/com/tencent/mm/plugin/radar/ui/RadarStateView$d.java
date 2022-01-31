package com.tencent.mm.plugin.radar.ui;

import a.d.b.g;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;

public final class RadarStateView$d
  extends ah
{
  public final void handleMessage(Message paramMessage)
  {
    g.k(paramMessage, "msg");
    RadarStateView.a(this.nmP);
    this.nmP.buL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarStateView.d
 * JD-Core Version:    0.7.0.1
 */