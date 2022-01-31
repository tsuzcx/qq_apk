package com.tencent.mm.plugin.talkroom.model;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.talkroom.component.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class g$1
  implements ServiceConnection
{
  g$1(g paramg) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    AppMethodBeat.i(25801);
    ab.i("MicroMsg.TalkRoomServer", "onServiceConnected ");
    if (paramIBinder == null)
    {
      g.a(this.tdh).t("enterTalkRoom bindServie or protocalInit failed", 3, -1);
      AppMethodBeat.o(25801);
      return;
    }
    g.a(this.tdh, a.a.B(paramIBinder));
    if (g.b(this.tdh) >= 2) {
      new ak(Looper.getMainLooper()).post(new g.1.1(this));
    }
    AppMethodBeat.o(25801);
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    AppMethodBeat.i(25802);
    ab.i("MicroMsg.TalkRoomServer", "onServiceDisconnected ");
    AppMethodBeat.o(25802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.g.1
 * JD-Core Version:    0.7.0.1
 */