package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.activity.MMRecordUI;
import com.tencent.mm.plugin.recordvideo.d.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordClosePlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "scene", "", "getScene", "()I", "setScene", "(I)V", "getView", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setView", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "initConfig", "", "config", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "onClick", "v", "Landroid/view/View;", "setVisibility", "visibility", "Companion", "plugin-recordvideo_release"})
public class x
  implements View.OnClickListener, t
{
  public static final a vli;
  protected int scene;
  private WeImageView vkX;
  
  static
  {
    AppMethodBeat.i(75634);
    vli = new a((byte)0);
    AppMethodBeat.o(75634);
  }
  
  public x(WeImageView paramWeImageView, d paramd)
  {
    AppMethodBeat.i(204134);
    this.vkX = paramWeImageView;
    this.vkX.setOnClickListener((View.OnClickListener)this);
    this.vkX.setIconColor(-1);
    AppMethodBeat.o(204134);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(204133);
    k.h(paramRecordConfigProvider, "config");
    this.scene = paramRecordConfigProvider.scene;
    AppMethodBeat.o(204133);
  }
  
  public final void apt() {}
  
  public final boolean dia()
  {
    return false;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(75631);
    ad.i("MicroMsg.RecordClosePlugin", "RecordClosePlugin close");
    paramView = this.vkX.getContext();
    if (paramView == null)
    {
      paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.activity.MMRecordUI");
      AppMethodBeat.o(75631);
      throw paramView;
    }
    ((MMRecordUI)paramView).fXY();
    paramView = b.vpp;
    b.Kp(3);
    paramView = b.vpp;
    b.Ko(3);
    paramView = b.vpp;
    b.Kr(this.scene);
    AppMethodBeat.o(75631);
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75632);
    this.vkX.setVisibility(paramInt);
    AppMethodBeat.o(75632);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordClosePlugin$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.x
 * JD-Core Version:    0.7.0.1
 */