package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

class TraeAudioManager$2
  implements Runnable
{
  TraeAudioManager$2(TraeAudioManager paramTraeAudioManager, ArrayList paramArrayList, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    AppMethodBeat.i(65663);
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
    localIntent.putExtra("PARAM_OPERATION", "NOTIFY_DEVICELISTUPDATE");
    localIntent.putExtra("EXTRA_DATA_AVAILABLEDEVICE_LIST", (String[])this.a.toArray(new String[0]));
    localIntent.putExtra("EXTRA_DATA_CONNECTEDDEVICE", this.b);
    localIntent.putExtra("EXTRA_DATA_PREV_CONNECTEDDEVICE", this.c);
    localIntent.putExtra("EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME", this.d);
    if (this.e._context != null) {
      this.e._context.sendBroadcast(localIntent);
    }
    AppMethodBeat.o(65663);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.2
 * JD-Core Version:    0.7.0.1
 */