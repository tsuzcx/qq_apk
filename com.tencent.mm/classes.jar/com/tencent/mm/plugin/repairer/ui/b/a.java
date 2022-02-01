package com.tencent.mm.plugin.repairer.ui.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.repairer.ui.RepairerMainUI;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/floatball/RepairerFloatBallHelper;", "Lcom/tencent/mm/plugin/ball/service/PageFloatBallHelper;", "pageAdapter", "Lcom/tencent/mm/plugin/ball/adapter/IFloatBallPageAdapter;", "(Lcom/tencent/mm/plugin/ball/adapter/IFloatBallPageAdapter;)V", "isSupportFloatBallMenu", "", "Companion", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.ball.service.e
{
  public static final a Oyk;
  private static final com.tencent.mm.plugin.ball.c.e roL;
  
  static
  {
    AppMethodBeat.i(277995);
    Oyk = new a((byte)0);
    roL = (com.tencent.mm.plugin.ball.c.e)new b();
    AppMethodBeat.o(277995);
  }
  
  public a(com.tencent.mm.plugin.ball.a.f paramf)
  {
    super(paramf);
    AppMethodBeat.i(277982);
    AppMethodBeat.o(277982);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/floatball/RepairerFloatBallHelper$Companion;", "", "()V", "floatBallInfoEventListener", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallInfoEventListener;", "startListeningFloatBallInfoClicked", "", "stopListeningFloatBallInfoClicked", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/repairer/ui/floatball/RepairerFloatBallHelper$Companion$floatBallInfoEventListener$1", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallInfoEventListenerAdapter;", "onFloatBallInfoClicked", "", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "onFloatBallInfoExposed", "onFloatBallInfoRemoved", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends com.tencent.mm.plugin.ball.c.f
  {
    public final void b(BallInfo paramBallInfo)
    {
      AppMethodBeat.i(277997);
      paramBallInfo = MMApplicationContext.getContext();
      Object localObject = new Intent(paramBallInfo, RepairerMainUI.class);
      ((Intent)localObject).addFlags(268435456);
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramBallInfo, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/repairer/ui/floatball/RepairerFloatBallHelper$Companion$floatBallInfoEventListener$1", "onFloatBallInfoClicked", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramBallInfo.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramBallInfo, "com/tencent/mm/plugin/repairer/ui/floatball/RepairerFloatBallHelper$Companion$floatBallInfoEventListener$1", "onFloatBallInfoClicked", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(277997);
    }
    
    public final void c(BallInfo paramBallInfo) {}
    
    public final void d(BallInfo paramBallInfo) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.b.a
 * JD-Core Version:    0.7.0.1
 */