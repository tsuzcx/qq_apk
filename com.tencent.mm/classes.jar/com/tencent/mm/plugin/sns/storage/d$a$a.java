package com.tencent.mm.plugin.sns.storage;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
final class d$a$a
  implements MMHandler.Callback
{
  public static final a Kzr;
  
  static
  {
    AppMethodBeat.i(241915);
    Kzr = new a();
    AppMethodBeat.o(241915);
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.d.a.a
 * JD-Core Version:    0.7.0.1
 */