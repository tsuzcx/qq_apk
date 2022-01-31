package com.tencent.mm.pluginsdk.ui.tools;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.LinkedList;

final class g$a$1
  extends ah
{
  g$a$1(g.a parama, Looper paramLooper, g paramg)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    g.a locala = this.smv;
    paramMessage = paramMessage.obj;
    if ((paramMessage != null) && (locala.smt.size() < locala.sms)) {
      locala.smt.add(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.g.a.1
 * JD-Core Version:    0.7.0.1
 */