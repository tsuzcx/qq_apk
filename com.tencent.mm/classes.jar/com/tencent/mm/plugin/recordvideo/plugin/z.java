package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.activity.MMRecordUI;
import com.tencent.mm.plugin.recordvideo.f.c;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordClosePlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "scene", "", "getScene", "()I", "setScene", "(I)V", "getView", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setView", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "initConfig", "", "config", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "onClick", "v", "Landroid/view/View;", "setVisibility", "visibility", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public class z
  implements View.OnClickListener, v
{
  public static final z.a NLk;
  private WeImageView NKT;
  private int scene;
  
  static
  {
    AppMethodBeat.i(75634);
    NLk = new z.a((byte)0);
    AppMethodBeat.o(75634);
  }
  
  public z(WeImageView paramWeImageView, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    AppMethodBeat.i(280578);
    this.NKT = paramWeImageView;
    this.NKT.setOnClickListener((View.OnClickListener)this);
    this.NKT.setIconColor(-1);
    AppMethodBeat.o(280578);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(280609);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(280609);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(280629);
    s.u(this, "this");
    AppMethodBeat.o(280629);
  }
  
  public final void e(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(280602);
    s.u(paramRecordConfigProvider, "config");
    this.scene = paramRecordConfigProvider.scene;
    AppMethodBeat.o(280602);
  }
  
  protected final int getScene()
  {
    return this.scene;
  }
  
  public final String name()
  {
    AppMethodBeat.i(280615);
    String str = v.a.b(this);
    AppMethodBeat.o(280615);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(280621);
    s.u(this, "this");
    AppMethodBeat.o(280621);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(280637);
    s.u(this, "this");
    AppMethodBeat.o(280637);
    return false;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(75631);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/plugin/RecordClosePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.i("MicroMsg.RecordClosePlugin", "RecordClosePlugin close");
    paramView = this.NKT.getContext();
    if (paramView == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.activity.MMRecordUI");
      AppMethodBeat.o(75631);
      throw paramView;
    }
    ((MMRecordUI)paramView).gGB();
    paramView = c.NRf;
    c.agH(3);
    paramView = c.NRf;
    c.agG(3);
    paramView = c.NRf;
    c.agJ(this.scene);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/RecordClosePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(75631);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(280646);
    s.u(this, "this");
    AppMethodBeat.o(280646);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(280652);
    s.u(this, "this");
    AppMethodBeat.o(280652);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(280662);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(280662);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(280670);
    s.u(this, "this");
    AppMethodBeat.o(280670);
  }
  
  public final void release()
  {
    AppMethodBeat.i(280680);
    s.u(this, "this");
    AppMethodBeat.o(280680);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(280688);
    s.u(this, "this");
    AppMethodBeat.o(280688);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75632);
    this.NKT.setVisibility(paramInt);
    AppMethodBeat.o(75632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.z
 * JD-Core Version:    0.7.0.1
 */