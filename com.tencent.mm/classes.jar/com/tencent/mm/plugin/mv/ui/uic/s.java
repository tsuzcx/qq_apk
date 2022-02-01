package com.tencent.mm.plugin.mv.ui.uic;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvSongControlUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "musicPlayerListener", "Lcom/tencent/mm/sdk/event/IListener;", "onPause", "", "onResume", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
  extends UIComponent
{
  private final IListener<?> rDF;
  
  public s(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(287712);
    this.rDF = ((IListener)new MusicMvSongControlUIC.musicPlayerListener.1(f.hfK));
    AppMethodBeat.o(287712);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(287742);
    this.rDF.dead();
    AppMethodBeat.o(287742);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(287725);
    this.rDF.alive();
    AppMethodBeat.o(287725);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.s
 * JD-Core Version:    0.7.0.1
 */