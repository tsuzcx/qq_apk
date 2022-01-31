package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.os.Message;
import android.widget.Button;
import com.tencent.mm.plugin.sns.ui.widget.SnsTextProgressBar;
import com.tencent.mm.sdk.d.b;
import com.tencent.mm.sdk.platformtools.y;

final class n$a$f
  extends b
{
  n$a$f(n.a parama) {}
  
  public final void enter()
  {
    super.enter();
    this.oGp.oGd.oFY.setVisibility(8);
    this.oGp.oGd.oFX.setVisibility(0);
    this.oGp.oGd.oFX.setText("重新下载");
  }
  
  public final boolean g(Message paramMessage)
  {
    y.i("LogStateTransitionState", "recv msg.what " + paramMessage.what);
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    this.oGp.b(this.oGp.oGm);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.a.f
 * JD-Core Version:    0.7.0.1
 */