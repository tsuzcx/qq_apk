package com.tencent.mm.plugin.recordvideo.plugin.parent;

import android.content.res.Resources;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/recordvideo/plugin/parent/VendorEffectSettingView$setSeekBarItem$1", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onProgressChanged", "", "seekBar", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "onStartTrackingTouch", "onStopTrackingTouch", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class VendorEffectSettingView$a
  implements SeekBar.OnSeekBarChangeListener
{
  VendorEffectSettingView$a(TextView paramTextView, VendorEffectSettingView paramVendorEffectSettingView, int paramInt, b<? super Integer, ah> paramb) {}
  
  public final void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(75820);
    s.u(paramSeekBar, "seekBar");
    this.EEk.setText((CharSequence)this.NQH.getResources().getString(this.NQI, new Object[] { Integer.valueOf(paramInt) }));
    this.NQJ.invoke(Integer.valueOf(paramInt));
    AppMethodBeat.o(75820);
  }
  
  public final void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    AppMethodBeat.i(75821);
    s.u(paramSeekBar, "seekBar");
    AppMethodBeat.o(75821);
  }
  
  public final void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    AppMethodBeat.i(75822);
    s.u(paramSeekBar, "seekBar");
    AppMethodBeat.o(75822);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.VendorEffectSettingView.a
 * JD-Core Version:    0.7.0.1
 */