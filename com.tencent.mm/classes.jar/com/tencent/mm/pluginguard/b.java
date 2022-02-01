package com.tencent.mm.pluginguard;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.io;
import com.tencent.mm.kernel.api.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginguard/ActivityHookReporter;", "", "()V", "TAG", "", "iDKeyRecords", "", "", "isKernelInit", "", "kvRptStructs", "Lcom/tencent/mm/autogen/mmdata/rpt/InstrumentErrorRptStruct;", "idkey", "", "id", "", "key", "values", "init", "reportCache", "rptInstrumentError", "errType", "", "compat_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b XMX;
  private static final List<long[]> XMY;
  private static final List<io> XMZ;
  private static boolean XNa;
  
  static
  {
    AppMethodBeat.i(231886);
    XMX = new b();
    XMY = (List)new ArrayList();
    XMZ = (List)new ArrayList();
    AppMethodBeat.o(231886);
  }
  
  public static void avw(int paramInt)
  {
    AppMethodBeat.i(231868);
    if (XNa)
    {
      localObject = new io();
      ((io)localObject).ivK = paramInt;
      ((io)localObject).bMH();
      AppMethodBeat.o(231868);
      return;
    }
    Object localObject = XMZ;
    io localio = new io();
    localio.ivK = paramInt;
    s.s(localio, "InstrumentErrorRptStruct…   .setErrorType(errType)");
    ((List)localObject).add(localio);
    AppMethodBeat.o(231868);
  }
  
  public static void init()
  {
    AppMethodBeat.i(231874);
    h.baF().a((g)new a());
    AppMethodBeat.o(231874);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/pluginguard/ActivityHookReporter$init$1", "Lcom/tencent/mm/kernel/api/IKernelCallback;", "onExit", "", "killService", "", "onStartupDone", "compat_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements g
  {
    public final void aDv()
    {
      AppMethodBeat.i(231870);
      b localb = b.XMX;
      b.iGk();
      Log.i("MicroMsg.GuardReporter", "MMKernel onStartupDone");
      localb = b.XMX;
      b.iGl();
      AppMethodBeat.o(231870);
    }
    
    public final void dZ(boolean paramBoolean) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<long[], Boolean>
  {
    public static final b XNb;
    
    static
    {
      AppMethodBeat.i(231878);
      XNb = new b();
      AppMethodBeat.o(231878);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/autogen/mmdata/rpt/InstrumentErrorRptStruct;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<io, Boolean>
  {
    public static final c XNc;
    
    static
    {
      AppMethodBeat.i(231871);
      XNc = new c();
      AppMethodBeat.o(231871);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginguard.b
 * JD-Core Version:    0.7.0.1
 */