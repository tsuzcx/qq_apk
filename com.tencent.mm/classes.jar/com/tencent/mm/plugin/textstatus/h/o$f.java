package com.tencent.mm.plugin.textstatus.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$StatusUpdateListener;", "Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$Listener;", "userName", "", "statusUpdate", "Lcom/tencent/mm/plugin/textstatus/api/IStatusUpdate;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/textstatus/api/IStatusUpdate;)V", "onChange", "", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o$f
  extends o.a
{
  public static final o.f.a Tnh;
  
  static
  {
    AppMethodBeat.i(290442);
    Tnh = new o.f.a((byte)0);
    AppMethodBeat.o(290442);
  }
  
  public o$f(String paramString, p paramp)
  {
    super(paramp, paramString);
    AppMethodBeat.i(290432);
    AppMethodBeat.o(290432);
  }
  
  public final void onChange()
  {
    AppMethodBeat.i(290449);
    Log.i("MicroMsg.TextStatus.StatusCardListener", s.X("StatusCardListener onChange ", this.key));
    Object localObject = hHA().get();
    if ((localObject instanceof p)) {}
    for (localObject = (p)localObject; localObject == null; localObject = null)
    {
      AppMethodBeat.o(290449);
      return;
    }
    ((p)localObject).Ds(this.key);
    AppMethodBeat.o(290449);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.o.f
 * JD-Core Version:    0.7.0.1
 */