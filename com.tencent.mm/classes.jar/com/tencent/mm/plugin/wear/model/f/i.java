package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.protobuf.drm;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public final class i
  extends c
{
  private ArrayList<Integer> AFa;
  private boolean Fy;
  
  public i()
  {
    this.Fy = true;
  }
  
  public i(ArrayList<Integer> paramArrayList)
  {
    this.AFa = paramArrayList;
    this.Fy = false;
  }
  
  public final String getName()
  {
    return "WearCancelNotificationTask";
  }
  
  protected final void send()
  {
    AppMethodBeat.i(30129);
    ad.i("MicroMsg.WearCancelNotificationTask", "Id List=%s", new Object[] { this.AFa });
    drm localdrm = new drm();
    if (this.AFa != null) {
      localdrm.EGA.addAll(this.AFa);
    }
    localdrm.EGB = this.Fy;
    try
    {
      a.egZ();
      r.a(20004, localdrm.toByteArray(), false);
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