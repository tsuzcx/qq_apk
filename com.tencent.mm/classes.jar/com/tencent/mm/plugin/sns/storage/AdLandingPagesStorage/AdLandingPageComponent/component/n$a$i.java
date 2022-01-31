package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.os.Message;
import android.widget.Button;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.ui.widget.SnsTextProgressBar;
import com.tencent.mm.sdk.platformtools.y;

final class n$a$i
  extends com.tencent.mm.sdk.d.b
{
  n$a$i(n.a parama) {}
  
  public final void enter()
  {
    super.enter();
    if (AdLandingPagesProxy.getInstance().isPkgInstalled(n.b(this.oGp.oGd).Bo))
    {
      this.oGp.oGd.oFY.setVisibility(8);
      this.oGp.oGd.oFX.setVisibility(0);
      this.oGp.oGd.oFX.setText("打开应用");
      return;
    }
    this.oGp.b(this.oGp.oGj);
  }
  
  public final boolean g(Message paramMessage)
  {
    boolean bool = true;
    y.i("LogStateTransitionState", "recv msg.what " + paramMessage.what);
    switch (paramMessage.what)
    {
    default: 
      bool = false;
    case 0: 
      do
      {
        return bool;
      } while (this.oGp.oGd.bFv());
      n.a.a(this.oGp, "打开失败");
      this.oGp.b(this.oGp.oGk);
      return true;
    }
    this.oGp.b(this.oGp.oGh);
    AdLandingPagesProxy.getInstance().deleteDeferredDeepLink(n.b(this.oGp.oGd).Bo);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.a.i
 * JD-Core Version:    0.7.0.1
 */