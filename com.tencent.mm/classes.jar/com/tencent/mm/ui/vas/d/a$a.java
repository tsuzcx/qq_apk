package com.tencent.mm.ui.vas.d;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/vas/report/IActivityPerformanceReporter$Companion;", "", "()V", "NullImpl", "Lcom/tencent/mm/ui/vas/report/IActivityPerformanceReporter;", "getNullImpl", "()Lcom/tencent/mm/ui/vas/report/IActivityPerformanceReporter;", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$a
{
  private static final a afRp;
  
  static
  {
    AppMethodBeat.i(250001);
    afRo = new a();
    afRp = (a)new a();
    AppMethodBeat.o(250001);
  }
  
  public static a jEu()
  {
    return afRp;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/vas/report/IActivityPerformanceReporter$Companion$NullImpl$1", "Lcom/tencent/mm/ui/vas/report/IActivityPerformanceReporter;", "stepOnAnimEnd", "", "intent", "Landroid/content/Intent;", "stepOnAnimStart", "timeStamp", "", "stepOnCreate", "stepStartActivity", "context", "Landroid/content/Context;", "isStartVAS", "", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements a
  {
    public final void a(Intent paramIntent, long paramLong) {}
    
    public final void a(Intent paramIntent, Context paramContext, boolean paramBoolean)
    {
      AppMethodBeat.i(250000);
      s.u(paramContext, "context");
      AppMethodBeat.o(250000);
    }
    
    public final void bs(Intent paramIntent) {}
    
    public final void bt(Intent paramIntent) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.vas.d.a.a
 * JD-Core Version:    0.7.0.1
 */