package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import android.widget.Button;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.ui.widget.SnsTextProgressBar;
import com.tencent.mm.sdk.platformtools.y;

final class n$a$g
  extends com.tencent.mm.sdk.d.b
{
  n$a$g(n.a parama) {}
  
  public final void enter()
  {
    super.enter();
    if (this.oGp.oGd.oGa == null)
    {
      this.oGp.oGd.oGa = new n.b(this.oGp.oGd, (byte)0);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
      localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
      localIntentFilter.addDataScheme("package");
      this.oGp.oGd.context.registerReceiver(this.oGp.oGd.oGa, localIntentFilter);
    }
    if (AdLandingPagesProxy.getInstance().isPkgInstalled(n.b(this.oGp.oGd).Bo))
    {
      this.oGp.b(this.oGp.oGk);
      return;
    }
    if (AdLandingPagesProxy.getInstance().isApkExist(n.b(this.oGp.oGd).bOL))
    {
      this.oGp.b(this.oGp.oGj);
      return;
    }
    if (AdLandingPagesProxy.getInstance().isDownloading(n.b(this.oGp.oGd).bOL))
    {
      this.oGp.b(this.oGp.oGg);
      return;
    }
    if (AdLandingPagesProxy.getInstance().isPaused(n.b(this.oGp.oGd).bOL))
    {
      this.oGp.b(this.oGp.oGi);
      return;
    }
    this.oGp.oGd.oFY.setVisibility(8);
    this.oGp.oGd.oFX.setVisibility(0);
    this.oGp.oGd.oFX.setText(n.b(this.oGp.oGd).title);
  }
  
  public final boolean g(Message paramMessage)
  {
    y.i("LogStateTransitionState", "recv msg.what " + paramMessage.what);
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 0: 
      this.oGp.b(this.oGp.oGm);
      return true;
    case 3: 
      this.oGp.b(this.oGp.oGk);
      return true;
    }
    this.oGp.b(this.oGp.oGh);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.a.g
 * JD-Core Version:    0.7.0.1
 */