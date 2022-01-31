package com.tencent.mm.plugin.sns.ui;

import android.util.Base64;
import android.widget.TextView;
import com.tencent.mm.as.o;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.sns.a.b.h;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class SnsSightPlayerUI$9
  implements f.a
{
  SnsSightPlayerUI$9(SnsSightPlayerUI paramSnsSightPlayerUI) {}
  
  public final int cv(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void cw(int paramInt1, int paramInt2) {}
  
  public final void kA()
  {
    y.d("MicroMsg.SnsSightPlayerUI", com.tencent.mm.compatible.util.g.zH() + " onPrepared");
    SnsSightPlayerUI.a(this.pdk, true);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    y.e("MicroMsg.SnsSightPlayerUI", "on play video error, what %d extra %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    SnsSightPlayerUI.g(this.pdk).stop();
    if (SnsSightPlayerUI.h(this.pdk)) {
      return;
    }
    SnsSightPlayerUI.i(this.pdk);
    b.t(Base64.encodeToString((d.bAW() + "[SnsSightPlayerUI] on play video error, what " + paramInt1 + " extra " + paramInt2 + ", path=" + bk.aM(SnsSightPlayerUI.e(this.pdk), "")).getBytes(), 2), "FullScreenPlaySight");
    String str = SnsSightPlayerUI.e(this.pdk);
    ai.d(new SnsSightPlayerUI.9.1(this, o.OJ().a(str, com.tencent.mm.cb.a.getDensity(this.pdk.mController.uMN), this.pdk.mController.uMN, -1), str));
  }
  
  public final void ug()
  {
    y.d("MicroMsg.SnsSightPlayerUI", "on completion");
    if (!SnsSightPlayerUI.j(this.pdk)) {
      SnsSightPlayerUI.k(this.pdk).post(new SnsSightPlayerUI.9.2(this));
    }
    SnsSightPlayerUI.g(this.pdk).setLoop(true);
    com.tencent.mm.plugin.sns.a.b.a.a locala = SnsSightPlayerUI.l(this.pdk).olx;
    locala.omu += 1;
    SnsSightPlayerUI.a(this.pdk, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.9
 * JD-Core Version:    0.7.0.1
 */