package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.protobuf.ggh;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public final class i
  extends c
{
  private ArrayList<Integer> Wjy;
  private boolean bpA;
  
  public i()
  {
    this.bpA = true;
  }
  
  public i(ArrayList<Integer> paramArrayList)
  {
    this.Wjy = paramArrayList;
    this.bpA = false;
  }
  
  public final String getName()
  {
    return "WearCancelNotificationTask";
  }
  
  protected final void send()
  {
    AppMethodBeat.i(30129);
    Log.i("MicroMsg.WearCancelNotificationTask", "Id List=%s", new Object[] { this.Wjy });
    ggh localggh = new ggh();
    if (this.Wjy != null) {
      localggh.accW.addAll(this.Wjy);
    }
    localggh.accX = this.bpA;
    try
    {
      a.inM();
      r.a(20004, localggh.toByteArray(), false);
      AppMethodBeat.o(30129);
      return;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(30129);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.i
 * JD-Core Version:    0.7.0.1
 */