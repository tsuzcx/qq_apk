package io.flutter.embedding.engine;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;

class FlutterJNI$1
  implements Runnable
{
  FlutterJNI$1(FlutterJNI paramFlutterJNI, Long paramLong) {}
  
  public void run()
  {
    AppMethodBeat.i(190042);
    Log.i("FlutterJNI", "nativeDestroy started");
    long l = System.currentTimeMillis();
    FlutterJNI.access$000(this.this$0, this.val$localNativeShellHolderId.longValue());
    Log.i("FlutterJNI", "nativeDestroy completed: ".concat(String.valueOf(System.currentTimeMillis() - l)));
    AppMethodBeat.o(190042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.engine.FlutterJNI.1
 * JD-Core Version:    0.7.0.1
 */