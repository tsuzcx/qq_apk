package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.protobuf.eeu;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public final class i
  extends c
{
  private ArrayList<Integer> DPs;
  private boolean Io;
  
  public i()
  {
    this.Io = true;
  }
  
  public i(ArrayList<Integer> paramArrayList)
  {
    this.DPs = paramArrayList;
    this.Io = false;
  }
  
  public final String getName()
  {
    return "WearCancelNotificationTask";
  }
  
  protected final void send()
  {
    AppMethodBeat.i(30129);
    ae.i("MicroMsg.WearCancelNotificationTask", "Id List=%s", new Object[] { this.DPs });
    eeu localeeu = new eeu();
    if (this.DPs != null) {
      localeeu.IiZ.addAll(this.DPs);
    }
    localeeu.Ija = this.Io;
    try
    {
      a.eOh();
      r.a(20004, localeeu.toByteArray(), false);
      AppMethodBeat.o(30129);
      return;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(30129);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.i
 * JD-Core Version:    0.7.0.1
 */