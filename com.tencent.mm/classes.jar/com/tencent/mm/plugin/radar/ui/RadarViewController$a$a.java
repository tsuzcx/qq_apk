package com.tencent.mm.plugin.radar.ui;

import a.d.b.g;
import a.k;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import com.tencent.mm.sdk.platformtools.ah;

public final class RadarViewController$a$a
  extends ah
{
  public final void handleMessage(Message paramMessage)
  {
    g.k(paramMessage, "msg");
    if ((paramMessage.obj instanceof View))
    {
      paramMessage = paramMessage.obj;
      if (paramMessage == null) {
        throw new k("null cannot be cast to non-null type android.view.View");
      }
      View localView = (View)paramMessage;
      localView.setVisibility(0);
      localView.clearAnimation();
      if (!this.nnQ.nnN)
      {
        Object localObject = localView.getTag(RadarViewController.b(this.nnQ.nnP));
        paramMessage = (Message)localObject;
        if (!(localObject instanceof Animation)) {
          paramMessage = null;
        }
        localObject = (Animation)paramMessage;
        paramMessage = (Message)localObject;
        if (localObject == null) {
          paramMessage = this.nnQ.getInAnimation();
        }
        localView.startAnimation(paramMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarViewController.a.a
 * JD-Core Version:    0.7.0.1
 */