package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoAddonTextPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/widget/TextView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/TextView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/widget/TextView;", "setView", "(Landroid/widget/TextView;)V", "setText", "", "wording", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
  implements v
{
  private a GrC;
  private TextView NKC;
  
  public r(TextView paramTextView, a parama)
  {
    AppMethodBeat.i(75575);
    this.NKC = paramTextView;
    this.GrC = parama;
    AppMethodBeat.o(75575);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(280713);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(280713);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(280731);
    s.u(this, "this");
    AppMethodBeat.o(280731);
  }
  
  public final String name()
  {
    AppMethodBeat.i(280719);
    String str = v.a.b(this);
    AppMethodBeat.o(280719);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(280725);
    s.u(this, "this");
    AppMethodBeat.o(280725);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(280741);
    s.u(this, "this");
    AppMethodBeat.o(280741);
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(280748);
    s.u(this, "this");
    AppMethodBeat.o(280748);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(280757);
    s.u(this, "this");
    AppMethodBeat.o(280757);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(280764);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(280764);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(280775);
    s.u(this, "this");
    AppMethodBeat.o(280775);
  }
  
  public final void release()
  {
    AppMethodBeat.i(280785);
    s.u(this, "this");
    AppMethodBeat.o(280785);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(280796);
    s.u(this, "this");
    AppMethodBeat.o(280796);
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(75574);
    if (Util.isNullOrNil(paramString))
    {
      this.NKC.setVisibility(8);
      AppMethodBeat.o(75574);
      return;
    }
    this.NKC.setVisibility(0);
    this.NKC.setText((CharSequence)paramString);
    AppMethodBeat.o(75574);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(280806);
    s.u(this, "this");
    AppMethodBeat.o(280806);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.r
 * JD-Core Version:    0.7.0.1
 */