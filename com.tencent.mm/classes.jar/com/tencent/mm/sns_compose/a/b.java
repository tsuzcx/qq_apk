package com.tencent.mm.sns_compose.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sns_compose/api/IPluginSnsWithTa;", "Lcom/tencent/mm/kernel/plugin/IAlias;", "startWithTaUI", "", "context", "Landroid/content/Context;", "platformOp", "Lcom/tencent/mm/sns_compose/api/IWithTaComposeOp;", "hasRedDot", "", "source", "", "Companion", "sns-compose.api_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface b
  extends a
{
  public static final a acze = a.aczf;
  
  public abstract void startWithTaUI(Context paramContext, c paramc, boolean paramBoolean, int paramInt);
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sns_compose/api/IPluginSnsWithTa$Companion;", "", "()V", "CLASS", "", "sns-compose.api_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static
    {
      AppMethodBeat.i(235499);
      aczf = new a();
      AppMethodBeat.o(235499);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sns_compose.a.b
 * JD-Core Version:    0.7.0.1
 */