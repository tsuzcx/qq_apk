package com.tencent.mm.plugin.xlabeffect;

import android.content.res.Resources;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/xlabeffect/XLabEffectSettingView$setSeekBarItem$1", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onProgressChanged", "", "seekBar", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "onStartTrackingTouch", "onStopTrackingTouch", "plugin-xlabeffect_release"})
public final class XLabEffectSettingView$a
  implements SeekBar.OnSeekBarChangeListener
{
  XLabEffectSettingView$a(TextView paramTextView, int paramInt, b paramb) {}
  
  public final void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(184233);
    k.h(paramSeekBar, "seekBar");
    this.gFv.setText((CharSequence)this.Del.getResources().getString(this.wxJ, new Object[] { Integer.valueOf(paramInt) }));
    this.wxK.ay(Integer.valueOf(paramInt));
    AppMethodBeat.o(184233);
  }
  
  public final void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    AppMethodBeat.i(184234);
    k.h(paramSeekBar, "seekBar");
    AppMethodBeat.o(184234);
  }
  
  public final void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    AppMethodBeat.i(184235);
    k.h(paramSeekBar, "seekBar");
    AppMethodBeat.o(184235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.xlabeffect.XLabEffectSettingView.a
 * JD-Core Version:    0.7.0.1
 */