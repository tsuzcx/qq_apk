package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

class TraeAudioManager$f$4
  implements Runnable
{
  TraeAudioManager$f$4(TraeAudioManager.f paramf, int paramInt) {}
  
  public void run()
  {
    AppMethodBeat.i(65759);
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
    localIntent.putExtra("PARAM_OPERATION", "NOTIFY_STREAMTYPE_UPDATE");
    localIntent.putExtra("EXTRA_DATA_STREAMTYPE", this.a);
    if (this.b.p._context != null) {
      this.b.p._context.sendBroadcast(localIntent);
    }
    AppMethodBeat.o(65759);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.f.4
 * JD-Core Version:    0.7.0.1
 */