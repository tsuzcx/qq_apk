package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.protobuf.cxi;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public final class i
  extends c
{
  private ArrayList<Integer> uHV;
  private boolean zd;
  
  public i()
  {
    this.zd = true;
  }
  
  public i(ArrayList<Integer> paramArrayList)
  {
    this.uHV = paramArrayList;
    this.zd = false;
  }
  
  public final String getName()
  {
    return "WearCancelNotificationTask";
  }
  
  protected final void send()
  {
    AppMethodBeat.i(26447);
    ab.i("MicroMsg.WearCancelNotificationTask", "Id List=%s", new Object[] { this.uHV });
    cxi localcxi = new cxi();
    if (this.uHV != null) {
      localcxi.yeQ.addAll(this.uHV);
    }
    localcxi.yeR = this.zd;
    try
    {
      a.cYy();
      r.a(20004, localcxi.toByteArray(), false);
      AppMethodBeat.o(26447);
      return;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(26447);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.i
 * JD-Core Version:    0.7.0.1
 */