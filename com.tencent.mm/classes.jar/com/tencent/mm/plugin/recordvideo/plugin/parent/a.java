package com.tencent.mm.plugin.recordvideo.plugin.parent;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.v;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "", "register", "", "plugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "RecordStatus", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
{
  public static final a.a NNG = a.a.NNH;
  
  public abstract void a(a.c paramc, Bundle paramBundle);
  
  public abstract void a(v paramv);
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public static void a(a parama, v paramv)
    {
      AppMethodBeat.i(281047);
      s.u(parama, "this");
      s.u(paramv, "plugin");
      AppMethodBeat.o(281047);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.a
 * JD-Core Version:    0.7.0.1
 */