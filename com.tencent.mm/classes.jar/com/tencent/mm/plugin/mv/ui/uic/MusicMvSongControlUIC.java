package com.tencent.mm.plugin.mv.ui.uic;

import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvSongControlUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "musicPlayerListener", "Lcom/tencent/mm/sdk/event/IListener;", "onPause", "", "onResume", "plugin-mv_release"})
public final class MusicMvSongControlUIC
  extends UIComponent
{
  private final IListener<?> lEl;
  
  public MusicMvSongControlUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(257373);
    this.lEl = ((IListener)new a());
    AppMethodBeat.o(257373);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(257372);
    this.lEl.dead();
    AppMethodBeat.o(257372);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(257371);
    this.lEl.alive();
    AppMethodBeat.o(257371);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/uic/MusicMvSongControlUIC$musicPlayerListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "callback", "", "event", "plugin-mv_release"})
  public static final class a
    extends IListener<mx>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.MusicMvSongControlUIC
 * JD-Core Version:    0.7.0.1
 */