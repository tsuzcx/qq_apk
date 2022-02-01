package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.activity.MMRecordUI;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordClosePlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "scene", "", "getScene", "()I", "setScene", "(I)V", "getView", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setView", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "initConfig", "", "config", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "onClick", "v", "Landroid/view/View;", "setVisibility", "visibility", "Companion", "plugin-recordvideo_release"})
public class x
  implements View.OnClickListener, t
{
  public static final x.a BRJ;
  protected int scene;
  private WeImageView wgX;
  
  static
  {
    AppMethodBeat.i(75634);
    BRJ = new x.a((byte)0);
    AppMethodBeat.o(75634);
  }
  
  public x(WeImageView paramWeImageView, d paramd)
  {
    AppMethodBeat.i(237344);
    this.wgX = paramWeImageView;
    this.wgX.setOnClickListener((View.OnClickListener)this);
    this.wgX.setIconColor(-1);
    AppMethodBeat.o(237344);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(237343);
    p.h(paramRecordConfigProvider, "config");
    this.scene = paramRecordConfigProvider.scene;
    AppMethodBeat.o(237343);
  }
  
  public final void aSs() {}
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(75631);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/recordvideo/plugin/RecordClosePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.RecordClosePlugin", "RecordClosePlugin close");
    paramView = this.wgX.getContext();
    if (paramView == null)
    {
      paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.activity.MMRecordUI");
      AppMethodBeat.o(75631);
      throw paramView;
    }
    ((MMRecordUI)paramView).eIF();
    paramView = c.BXI;
    c.VI(3);
    paramView = c.BXI;
    c.VH(3);
    paramView = c.BXI;
    c.VK(this.scene);
    a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/RecordClosePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(75631);
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(237345);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(237345);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75632);
    this.wgX.setVisibility(paramInt);
    AppMethodBeat.o(75632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.x
 * JD-Core Version:    0.7.0.1
 */