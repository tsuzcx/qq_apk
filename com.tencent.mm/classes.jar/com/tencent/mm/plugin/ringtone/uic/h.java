package com.tencent.mm.plugin.ringtone.uic;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ringtone.d.c;
import com.tencent.mm.plugin.ringtone.g.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/uic/RingtonePlayUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "mPreviewHelper", "Lcom/tencent/mm/plugin/ringtone/feed/RingtonePlayerFlow;", "getMPreviewHelper", "()Lcom/tencent/mm/plugin/ringtone/feed/RingtonePlayerFlow;", "setMPreviewHelper", "(Lcom/tencent/mm/plugin/ringtone/feed/RingtonePlayerFlow;)V", "onDestroy", "", "onFinished", "onPause", "onPauseRingtone", "onPlayRingtone", "item", "Lcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc;", "id", "", "play", "", "onResume", "release", "Companion", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends UIComponent
{
  public static final h.a OFp;
  c OFo;
  
  static
  {
    AppMethodBeat.i(273366);
    OFp = new h.a((byte)0);
    AppMethodBeat.o(273366);
  }
  
  public h(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(273345);
    this.OFo = new c(getLifecycleScope());
    AppMethodBeat.o(273345);
  }
  
  private void release()
  {
    AppMethodBeat.i(273356);
    Log.i("MicroMsg.RingtonePlayUIC", "release");
    this.OFo.gOx();
    this.OFo.release();
    AppMethodBeat.o(273356);
  }
  
  public final void b(d paramd, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(273374);
    s.u(paramd, "item");
    Log.i("MicroMsg.RingtonePlayUIC", "on play ringtone " + paramd.toJson() + ",and id is " + paramLong + " with action is play " + paramBoolean);
    this.OFo.a(paramd, paramLong, paramBoolean);
    AppMethodBeat.o(273374);
  }
  
  public final void gOV()
  {
    AppMethodBeat.i(273380);
    Log.i("MicroMsg.RingtonePlayUIC", "onPauseRingtone");
    this.OFo.gOx();
    AppMethodBeat.o(273380);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(273415);
    super.onDestroy();
    release();
    AppMethodBeat.o(273415);
  }
  
  public final void onFinished()
  {
    AppMethodBeat.i(273396);
    super.onFinished();
    release();
    AppMethodBeat.o(273396);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(273406);
    super.onPause();
    release();
    AppMethodBeat.o(273406);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(273384);
    super.onResume();
    this.OFo.gOy();
    AppMethodBeat.o(273384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.uic.h
 * JD-Core Version:    0.7.0.1
 */