package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.protobuf.ezc;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public final class i
  extends c
{
  private boolean Iy;
  private ArrayList<Integer> IyI;
  
  public i()
  {
    this.Iy = true;
  }
  
  public i(ArrayList<Integer> paramArrayList)
  {
    this.IyI = paramArrayList;
    this.Iy = false;
  }
  
  public final String getName()
  {
    return "WearCancelNotificationTask";
  }
  
  protected final void send()
  {
    AppMethodBeat.i(30129);
    Log.i("MicroMsg.WearCancelNotificationTask", "Id List=%s", new Object[] { this.IyI });
    ezc localezc = new ezc();
    if (this.IyI != null) {
      localezc.NvD.addAll(this.IyI);
    }
    localezc.NvE = this.Iy;
    try
    {
      a.fVQ();
      r.a(20004, localezc.toByteArray(), false);
      AppMethodBeat.o(30129);
      return;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(30129);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.i
 * JD-Core Version:    0.7.0.1
 */