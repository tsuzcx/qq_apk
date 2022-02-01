package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoShadowPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/view/View;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/View;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "TAG", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
  implements v
{
  private a GrC;
  private final String TAG;
  private View view;
  
  public p(View paramView, a parama)
  {
    AppMethodBeat.i(75563);
    this.view = paramView;
    this.GrC = parama;
    this.TAG = "MicroMsg.EditPhotoShadowPlugin";
    Log.i(this.TAG, s.X("status bar : ", Integer.valueOf(bf.bk(this.view.getContext()))));
    paramView = new RelativeLayout.LayoutParams(-1, this.view.getLayoutParams().height + bf.bk(this.view.getContext()));
    paramView.addRule(12, -1);
    this.view.setLayoutParams((ViewGroup.LayoutParams)paramView);
    this.view.invalidate();
    AppMethodBeat.o(75563);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(280588);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(280588);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(280601);
    s.u(this, "this");
    AppMethodBeat.o(280601);
  }
  
  public final String name()
  {
    AppMethodBeat.i(280592);
    String str = v.a.b(this);
    AppMethodBeat.o(280592);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(280597);
    s.u(this, "this");
    AppMethodBeat.o(280597);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(280607);
    s.u(this, "this");
    AppMethodBeat.o(280607);
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(280614);
    s.u(this, "this");
    AppMethodBeat.o(280614);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(280618);
    s.u(this, "this");
    AppMethodBeat.o(280618);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(280625);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(280625);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(280633);
    s.u(this, "this");
    AppMethodBeat.o(280633);
  }
  
  public final void release()
  {
    AppMethodBeat.i(280642);
    s.u(this, "this");
    AppMethodBeat.o(280642);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(280650);
    s.u(this, "this");
    AppMethodBeat.o(280650);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(280659);
    s.u(this, "this");
    AppMethodBeat.o(280659);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.p
 * JD-Core Version:    0.7.0.1
 */