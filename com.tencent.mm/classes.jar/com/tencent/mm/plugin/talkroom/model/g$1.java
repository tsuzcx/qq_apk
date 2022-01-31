package com.tencent.mm.plugin.talkroom.model;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import com.tencent.mm.plugin.talkroom.component.a.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class g$1
  implements ServiceConnection
{
  g$1(g paramg) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    y.i("MicroMsg.TalkRoomServer", "onServiceConnected ");
    if (paramIBinder == null) {
      g.a(this.pBx).i("enterTalkRoom bindServie or protocalInit failed", 3, -1);
    }
    do
    {
      return;
      g.a(this.pBx, a.a.C(paramIBinder));
    } while (g.b(this.pBx) < 2);
    new ah(Looper.getMainLooper()).post(new g.1.1(this));
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    y.i("MicroMsg.TalkRoomServer", "onServiceDisconnected ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.g.1
 * JD-Core Version:    0.7.0.1
 */