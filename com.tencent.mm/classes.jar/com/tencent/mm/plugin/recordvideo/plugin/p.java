package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoAddonTextPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/widget/TextView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/TextView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/widget/TextView;", "setView", "(Landroid/widget/TextView;)V", "setText", "", "wording", "", "plugin-recordvideo_release"})
public final class p
  implements t
{
  private d sQE;
  private TextView xBa;
  
  public p(TextView paramTextView, d paramd)
  {
    AppMethodBeat.i(75575);
    this.xBa = paramTextView;
    this.sQE = paramd;
    AppMethodBeat.o(75575);
  }
  
  public final boolean aoB()
  {
    return false;
  }
  
  public final void ayX() {}
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(200320);
    d.g.b.p.h(paramArrayOfString, "permissions");
    d.g.b.p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(200320);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(75574);
    if (bt.isNullOrNil(paramString))
    {
      this.xBa.setVisibility(8);
      AppMethodBeat.o(75574);
      return;
    }
    this.xBa.setVisibility(0);
    this.xBa.setText((CharSequence)paramString);
    AppMethodBeat.o(75574);
  }
  
  public final void setVisibility(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.p
 * JD-Core Version:    0.7.0.1
 */