package com.tencent.mm.plugin.repairer.ui.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.repairer.ui.RepairerMainUI;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/repairer/ui/floatball/RepairerFloatBallHelper;", "Lcom/tencent/mm/plugin/ball/service/PageFloatBallHelper;", "pageAdapter", "Lcom/tencent/mm/plugin/ball/adapter/IFloatBallPageAdapter;", "(Lcom/tencent/mm/plugin/ball/adapter/IFloatBallPageAdapter;)V", "isSupportFloatBallMenu", "", "Companion", "ui-repairer_release"})
public final class a
  extends com.tencent.mm.plugin.ball.service.e
{
  public static final a Iyd;
  private static final com.tencent.mm.plugin.ball.c.e old;
  
  static
  {
    AppMethodBeat.i(227260);
    Iyd = new a((byte)0);
    old = (com.tencent.mm.plugin.ball.c.e)new b();
    AppMethodBeat.o(227260);
  }
  
  public a(com.tencent.mm.plugin.ball.a.f paramf)
  {
    super(paramf);
    AppMethodBeat.i(227259);
    AppMethodBeat.o(227259);
  }
  
  public final boolean aOh()
  {
    return true;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/repairer/ui/floatball/RepairerFloatBallHelper$Companion;", "", "()V", "floatBallInfoEventListener", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallInfoEventListener;", "startListeningFloatBallInfoClicked", "", "stopListeningFloatBallInfoClicked", "ui-repairer_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/repairer/ui/floatball/RepairerFloatBallHelper$Companion$floatBallInfoEventListener$1", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallInfoEventListenerAdapter;", "onFloatBallInfoClicked", "", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "onFloatBallInfoExposed", "onFloatBallInfoRemoved", "ui-repairer_release"})
  public static final class b
    extends com.tencent.mm.plugin.ball.c.f
  {
    public final void b(BallInfo paramBallInfo)
    {
      AppMethodBeat.i(226705);
      paramBallInfo = MMApplicationContext.getContext();
      Object localObject = new Intent(paramBallInfo, RepairerMainUI.class);
      ((Intent)localObject).addFlags(268435456);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramBallInfo, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/repairer/ui/floatball/RepairerFloatBallHelper$Companion$floatBallInfoEventListener$1", "onFloatBallInfoClicked", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramBallInfo.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramBallInfo, "com/tencent/mm/plugin/repairer/ui/floatball/RepairerFloatBallHelper$Companion$floatBallInfoEventListener$1", "onFloatBallInfoClicked", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(226705);
    }
    
    public final void c(BallInfo paramBallInfo) {}
    
    public final void d(BallInfo paramBallInfo) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.a.a
 * JD-Core Version:    0.7.0.1
 */