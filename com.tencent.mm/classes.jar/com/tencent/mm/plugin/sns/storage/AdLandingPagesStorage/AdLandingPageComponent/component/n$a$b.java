package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.os.Message;
import android.widget.Button;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.ui.widget.SnsTextProgressBar;
import com.tencent.mm.sdk.platformtools.y;

final class n$a$b
  extends com.tencent.mm.sdk.d.b
{
  n$a$b(n.a parama) {}
  
  public final void enter()
  {
    super.enter();
    AdLandingPagesProxy.getInstance().doAdChannelScene(n.b(this.oGp.oGd).Bo, n.b(this.oGp.oGd).channelId, this.oGp.oGd.oGc);
    AdLandingPagesProxy.getInstance().stopTask(n.b(this.oGp.oGd).bOL);
    this.oGp.oGd.oFX.setVisibility(8);
    this.oGp.oGd.oFY.setVisibility(0);
    this.oGp.oGd.oFY.setProgress(0);
    y.i("LogStateTransitionState", "appid %s, channelId %s", new Object[] { n.b(this.oGp.oGd).Bo, n.b(this.oGp.oGd).channelId });
  }
  
  public final boolean g(Message paramMessage)
  {
    y.i("LogStateTransitionState", "recv msg.what " + paramMessage.what);
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 6: 
      this.oGp.b(this.oGp.oGg);
      return true;
    case 5: 
      n.a.a(this.oGp, "下载失败");
      this.oGp.b(this.oGp.oGl);
      return true;
    case 10: 
      this.oGp.b(this.oGp.oGh);
      return true;
    }
    this.oGp.b(this.oGp.oGi);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.a.b
 * JD-Core Version:    0.7.0.1
 */