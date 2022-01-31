package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.platformtools.ab;

final class m$a$b
  extends com.tencent.mm.sdk.d.b
{
  m$a$b(m.a parama) {}
  
  public final void enter()
  {
    AppMethodBeat.i(37110);
    super.enter();
    AdLandingPagesProxy.getInstance().doAdChannelScene(m.b(this.rvU.rvI).Ca, m.b(this.rvU.rvI).channelId, this.rvU.rvI.rvH);
    ab.i("LogStateTransitionState", hashCode() + "[DoNetSceneState] appid %s, channelId %s", new Object[] { m.b(this.rvU.rvI).Ca, m.b(this.rvU.rvI).channelId });
    AppMethodBeat.o(37110);
  }
  
  public final boolean k(Message paramMessage)
  {
    AppMethodBeat.i(37109);
    ab.i("LogStateTransitionState", hashCode() + "[DoNetSceneState]recv msg.what " + paramMessage.what);
    if (AdLandingPagesProxy.getInstance().isApkExist(m.b(this.rvU.rvI).cwc))
    {
      this.rvU.b(this.rvU.rvO);
      AppMethodBeat.o(37109);
      return true;
    }
    switch (paramMessage.what)
    {
    case 7: 
    case 8: 
    case 9: 
    default: 
      AppMethodBeat.o(37109);
      return false;
    case 6: 
      this.rvU.b(this.rvU.rvM);
      AppMethodBeat.o(37109);
      return true;
    case 5: 
      m.a.a(this.rvU, this.rvU.rvI.context.getString(2131303749));
      this.rvU.b(this.rvU.rvQ);
      AppMethodBeat.o(37109);
      return true;
    }
    this.rvU.b(this.rvU.rvM);
    AppMethodBeat.o(37109);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m.a.b
 * JD-Core Version:    0.7.0.1
 */