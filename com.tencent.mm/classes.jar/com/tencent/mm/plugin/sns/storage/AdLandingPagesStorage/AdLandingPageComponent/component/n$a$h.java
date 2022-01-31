package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.os.Message;
import android.widget.Button;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.ui.widget.SnsTextProgressBar;
import com.tencent.mm.sdk.platformtools.y;

final class n$a$h
  extends com.tencent.mm.sdk.d.b
{
  private boolean oGs;
  
  n$a$h(n.a parama) {}
  
  public final void enter()
  {
    super.enter();
    if (!AdLandingPagesProxy.getInstance().isApkExist(n.b(this.oGp.oGd).bOL))
    {
      this.oGp.b(this.oGp.oGh);
      return;
    }
    this.oGp.oGd.oFY.setVisibility(8);
    this.oGp.oGd.oFX.setVisibility(0);
    this.oGp.oGd.oFX.setText("安装应用");
    this.oGs = true;
  }
  
  public final boolean g(Message paramMessage)
  {
    y.i("LogStateTransitionState", "recv msg.what " + paramMessage.what);
    switch (paramMessage.what)
    {
    case 1: 
    default: 
      return false;
    case 0: 
      if (AdLandingPagesProxy.getInstance().installApp(this.oGp.oGd.context, n.b(this.oGp.oGd).bOL))
      {
        this.oGs = true;
        return true;
      }
      n.a.a(this.oGp, "安装失败");
      this.oGp.b(this.oGp.oGl);
      return true;
    case 2: 
      if (!AdLandingPagesProxy.getInstance().isApkExist(n.b(this.oGp.oGd).bOL)) {
        this.oGp.b(this.oGp.oGh);
      }
      return true;
    }
    if (this.oGs)
    {
      this.oGs = false;
      AdLandingPagesProxy.getInstance().reportDownloadInfo(5, n.b(this.oGp.oGd).bOL, n.b(this.oGp.oGd).Bo, n.b(this.oGp.oGd).bIW, n.b(this.oGp.oGd).downloadUrl);
    }
    this.oGp.b(this.oGp.oGk);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.a.h
 * JD-Core Version:    0.7.0.1
 */