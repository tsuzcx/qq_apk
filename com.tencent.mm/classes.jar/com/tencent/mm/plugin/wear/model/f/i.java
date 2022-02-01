package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.protobuf.dxd;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public final class i
  extends c
{
  private ArrayList<Integer> BXu;
  private boolean Gw;
  
  public i()
  {
    this.Gw = true;
  }
  
  public i(ArrayList<Integer> paramArrayList)
  {
    this.BXu = paramArrayList;
    this.Gw = false;
  }
  
  public final String getName()
  {
    return "WearCancelNotificationTask";
  }
  
  protected final void send()
  {
    AppMethodBeat.i(30129);
    ac.i("MicroMsg.WearCancelNotificationTask", "Id List=%s", new Object[] { this.BXu });
    dxd localdxd = new dxd();
    if (this.BXu != null) {
      localdxd.GdM.addAll(this.BXu);
    }
    localdxd.GdN = this.Gw;
    try
    {
      a.ewt();
      r.a(20004, localdxd.toByteArray(), false);
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