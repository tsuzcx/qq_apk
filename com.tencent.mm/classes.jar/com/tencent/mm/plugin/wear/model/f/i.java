package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.protobuf.fjt;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public final class i
  extends c
{
  private boolean Jx;
  private ArrayList<Integer> PsL;
  
  public i()
  {
    this.Jx = true;
  }
  
  public i(ArrayList<Integer> paramArrayList)
  {
    this.PsL = paramArrayList;
    this.Jx = false;
  }
  
  protected final void gOA()
  {
    AppMethodBeat.i(30129);
    Log.i("MicroMsg.WearCancelNotificationTask", "Id List=%s", new Object[] { this.PsL });
    fjt localfjt = new fjt();
    if (this.PsL != null) {
      localfjt.UIO.addAll(this.PsL);
    }
    localfjt.UIP = this.Jx;
    try
    {
      a.gOx();
      r.a(20004, localfjt.toByteArray(), false);
      AppMethodBeat.o(30129);
      return;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(30129);
    }
  }
  
  public final String getName()
  {
    return "WearCancelNotificationTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.i
 * JD-Core Version:    0.7.0.1
 */