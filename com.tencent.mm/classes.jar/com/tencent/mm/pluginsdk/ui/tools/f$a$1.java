package com.tencent.mm.pluginsdk.ui.tools;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.LinkedList;

final class f$a$1
  extends ak
{
  f$a$1(f.a parama, Looper paramLooper, f paramf)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(79932);
    f.a locala = this.weX;
    paramMessage = paramMessage.obj;
    if ((paramMessage != null) && (locala.weV.size() < locala.weU)) {
      locala.weV.add(paramMessage);
    }
    AppMethodBeat.o(79932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.f.a.1
 * JD-Core Version:    0.7.0.1
 */