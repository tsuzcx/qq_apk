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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordClosePlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "scene", "", "getScene", "()I", "setScene", "(I)V", "getView", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setView", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "initConfig", "", "config", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "onClick", "v", "Landroid/view/View;", "setVisibility", "visibility", "Companion", "plugin-recordvideo_release"})
public class x
  implements View.OnClickListener, t
{
  public static final x.a xBK;
  private WeImageView sQK;
  protected int scene;
  
  static
  {
    AppMethodBeat.i(75634);
    xBK = new x.a((byte)0);
    AppMethodBeat.o(75634);
  }
  
  public x(WeImageView paramWeImageView, d paramd)
  {
    AppMethodBeat.i(200354);
    this.sQK = paramWeImageView;
    this.sQK.setOnClickListener((View.OnClickListener)this);
    this.sQK.setIconColor(-1);
    AppMethodBeat.o(200354);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(200353);
    p.h(paramRecordConfigProvider, "config");
    this.scene = paramRecordConfigProvider.scene;
    AppMethodBeat.o(200353);
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
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(75631);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/recordvideo/plugin/RecordClosePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    ad.i("MicroMsg.RecordClosePlugin", "RecordClosePlugin close");
    paramView = this.sQK.getContext();
    if (paramView == null)
    {
      paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.activity.MMRecordUI");
      AppMethodBeat.o(75631);
      throw paramView;
    }
    ((MMRecordUI)paramView).dEB();
    paramView = c.xHa;
    c.NN(3);
    paramView = c.xHa;
    c.NM(3);
    paramView = c.xHa;
    c.NP(this.scene);
    a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/RecordClosePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(75631);
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(200355);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(200355);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75632);
    this.sQK.setVisibility(paramInt);
    AppMethodBeat.o(75632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.x
 * JD-Core Version:    0.7.0.1
 */