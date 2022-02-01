package com.tencent.mm.plugin.xlabeffect;

import android.content.res.Resources;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/xlabeffect/XLabEffectSettingView$setSeekBarItem$1", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onProgressChanged", "", "seekBar", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "onStartTrackingTouch", "onStopTrackingTouch", "plugin-xlabeffect_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class XLabEffectSettingView$a
  implements SeekBar.OnSeekBarChangeListener
{
  XLabEffectSettingView$a(TextView paramTextView, XLabEffectSettingView paramXLabEffectSettingView, int paramInt, b<? super Integer, ah> paramb) {}
  
  public final void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(184233);
    s.u(paramSeekBar, "seekBar");
    this.EEk.setText((CharSequence)this.XMq.getResources().getString(this.NQI, new Object[] { Integer.valueOf(paramInt) }));
    this.NQJ.invoke(Integer.valueOf(paramInt));
    AppMethodBeat.o(184233);
  }
  
  public final void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    AppMethodBeat.i(184234);
    s.u(paramSeekBar, "seekBar");
    AppMethodBeat.o(184234);
  }
  
  public final void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    AppMethodBeat.i(184235);
    s.u(paramSeekBar, "seekBar");
    AppMethodBeat.o(184235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.xlabeffect.XLabEffectSettingView.a
 * JD-Core Version:    0.7.0.1
 */