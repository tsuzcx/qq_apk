package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.protobuf.edd;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public final class i
  extends c
{
  private ArrayList<Integer> DxN;
  private boolean Io;
  
  public i()
  {
    this.Io = true;
  }
  
  public i(ArrayList<Integer> paramArrayList)
  {
    this.DxN = paramArrayList;
    this.Io = false;
  }
  
  public final String getName()
  {
    return "WearCancelNotificationTask";
  }
  
  protected final void send()
  {
    AppMethodBeat.i(30129);
    ad.i("MicroMsg.WearCancelNotificationTask", "Id List=%s", new Object[] { this.DxN });
    edd localedd = new edd();
    if (this.DxN != null) {
      localedd.HOS.addAll(this.DxN);
    }
    localedd.HOT = this.Io;
    try
    {
      a.eKz();
      r.a(20004, localedd.toByteArray(), false);
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