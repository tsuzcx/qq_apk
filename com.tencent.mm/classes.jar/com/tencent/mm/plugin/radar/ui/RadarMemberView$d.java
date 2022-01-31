package com.tencent.mm.plugin.radar.ui;

import a.d.b.g;
import android.os.Message;
import android.view.View;
import com.tencent.mm.sdk.platformtools.ah;

public final class RadarMemberView$d
  extends ah
{
  public final void handleMessage(Message paramMessage)
  {
    g.k(paramMessage, "msg");
    int i = paramMessage.what;
    RadarMemberView.a locala = RadarMemberView.nmg;
    if (i == RadarMemberView.buF())
    {
      paramMessage = this.nmh;
      this.nmh.getMember();
      RadarMemberView.a(paramMessage, this.nmh.getState());
    }
    do
    {
      do
      {
        return;
        i = paramMessage.what;
        paramMessage = RadarMemberView.nmg;
      } while (i != RadarMemberView.buG());
      this.nmh.setVisibility(4);
      RadarMemberView.j(this.nmh);
      paramMessage = RadarMemberView.k(this.nmh);
      if (paramMessage != null) {
        paramMessage.setVisibility(0);
      }
      paramMessage = RadarMemberView.a(this.nmh);
    } while (paramMessage == null);
    paramMessage.b(this.nmh.getMember(), this.nmh.getState());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarMemberView.d
 * JD-Core Version:    0.7.0.1
 */