package com.tencent.mm.plugin.mv.ui.uic;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.np;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvSongControlUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "musicPlayerListener", "Lcom/tencent/mm/sdk/event/IListener;", "onPause", "", "onResume", "plugin-mv_release"})
public final class v
  extends UIComponent
{
  private final IListener<?> ozM;
  
  public v(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(228846);
    this.ozM = ((IListener)new a());
    AppMethodBeat.o(228846);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(228844);
    this.ozM.dead();
    AppMethodBeat.o(228844);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(228842);
    this.ozM.alive();
    AppMethodBeat.o(228842);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/uic/MusicMvSongControlUIC$musicPlayerListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "callback", "", "event", "plugin-mv_release"})
  public static final class a
    extends IListener<np>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.v
 * JD-Core Version:    0.7.0.1
 */