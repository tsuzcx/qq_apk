package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.activity.MMRecordUI;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordClosePlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "scene", "", "getScene", "()I", "setScene", "(I)V", "getView", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setView", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "initConfig", "", "config", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "onClick", "v", "Landroid/view/View;", "setVisibility", "visibility", "Companion", "plugin-recordvideo_release"})
public class y
  implements View.OnClickListener, t
{
  public static final y.a wtO;
  private WeImageView rTZ;
  protected int scene;
  
  static
  {
    AppMethodBeat.i(75634);
    wtO = new y.a((byte)0);
    AppMethodBeat.o(75634);
  }
  
  public y(WeImageView paramWeImageView, d paramd)
  {
    AppMethodBeat.i(199320);
    this.rTZ = paramWeImageView;
    this.rTZ.setOnClickListener((View.OnClickListener)this);
    this.rTZ.setIconColor(-1);
    AppMethodBeat.o(199320);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(199319);
    k.h(paramRecordConfigProvider, "config");
    this.scene = paramRecordConfigProvider.scene;
    AppMethodBeat.o(199319);
  }
  
  public final boolean alO()
  {
    return false;
  }
  
  public final void awk() {}
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(75631);
    ac.i("MicroMsg.RecordClosePlugin", "RecordClosePlugin close");
    paramView = this.rTZ.getContext();
    if (paramView == null)
    {
      paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.activity.MMRecordUI");
      AppMethodBeat.o(75631);
      throw paramView;
    }
    ((MMRecordUI)paramView).due();
    paramView = c.wyg;
    c.Mo(3);
    paramView = c.wyg;
    c.Mn(3);
    paramView = c.wyg;
    c.Mq(this.scene);
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
    this.rTZ.setVisibility(paramInt);
    AppMethodBeat.o(75632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.y
 * JD-Core Version:    0.7.0.1
 */