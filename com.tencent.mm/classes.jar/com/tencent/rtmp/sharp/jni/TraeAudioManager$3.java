package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

class TraeAudioManager$3
  implements Runnable
{
  TraeAudioManager$3(TraeAudioManager paramTraeAudioManager, boolean paramBoolean) {}
  
  public void run()
  {
    AppMethodBeat.i(65673);
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
    localIntent.putExtra("PARAM_OPERATION", "NOTIFY_DEVICECHANGABLE_UPDATE");
    localIntent.putExtra("NOTIFY_DEVICECHANGABLE_UPDATE_DATE", this.a);
    if (this.b._context != null) {
      this.b._context.sendBroadcast(localIntent);
    }
    AppMethodBeat.o(65673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.3
 * JD-Core Version:    0.7.0.1
 */