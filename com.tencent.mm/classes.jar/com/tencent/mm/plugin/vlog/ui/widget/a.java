package com.tencent.mm.plugin.vlog.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.TextColorSelector;
import d.f;
import d.g;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker;", "", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;)V", "callback", "Lcom/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker$ColorPickerCallback;", "getCallback", "()Lcom/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker$ColorPickerCallback;", "setCallback", "(Lcom/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker$ColorPickerCallback;)V", "closeBtn", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getCloseBtn", "()Landroid/widget/ImageView;", "closeBtn$delegate", "Lkotlin/Lazy;", "colorList", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/TextColorSelector;", "getColorList", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/TextColorSelector;", "colorList$delegate", "getHolder", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "isInit", "", "panelRoot", "Landroid/view/View;", "getPanelRoot", "()Landroid/view/View;", "panelRoot$delegate", "undoBtn", "getUndoBtn", "undoBtn$delegate", "checkInit", "", "updateSelect", "ColorPickerCallback", "Companion", "plugin-vlog_release"})
public final class a
{
  public static final int[] Cmx;
  public static final a.b Cmy;
  private final f CdT;
  private final f Cmu;
  public final f Cmv;
  public a Cmw;
  public boolean cBE;
  public final f sOS;
  public final EditorPanelHolder tcK;
  
  static
  {
    AppMethodBeat.i(192367);
    Cmy = new a.b((byte)0);
    Cmx = new int[] { -1, -16777216, -707825, -17592, -16535286, -15172610, -7054596 };
    AppMethodBeat.o(192367);
  }
  
  public a(EditorPanelHolder paramEditorPanelHolder)
  {
    AppMethodBeat.i(192366);
    this.tcK = paramEditorPanelHolder;
    this.CdT = g.O((d.g.a.a)new h(this));
    this.Cmu = g.O((d.g.a.a)new g(this));
    this.Cmv = g.O((d.g.a.a)new i(this));
    this.sOS = g.O((d.g.a.a)new f(this));
    AppMethodBeat.o(192366);
  }
  
  public final View ewZ()
  {
    AppMethodBeat.i(192364);
    View localView = (View)this.CdT.getValue();
    AppMethodBeat.o(192364);
    return localView;
  }
  
  public final TextColorSelector exM()
  {
    AppMethodBeat.i(192365);
    TextColorSelector localTextColorSelector = (TextColorSelector)this.Cmu.getValue();
    AppMethodBeat.o(192365);
    return localTextColorSelector;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker$ColorPickerCallback;", "", "onClose", "", "onSelectColor", "index", "", "onUndo", "plugin-vlog_release"})
  public static abstract interface a
  {
    public abstract void NH();
    
    public abstract void Uk(int paramInt);
    
    public abstract void onClose();
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
  public static final class c
    extends q
    implements d.g.a.b<Integer, z>
  {
    public c(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class d
    implements View.OnClickListener
  {
    public d(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(192358);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = this.Cmz.Cmw;
      if (paramView != null) {
        paramView.NH();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(192358);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class e
    implements View.OnClickListener
  {
    public e(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(192359);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker$checkInit$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = this.Cmz.Cmw;
      if (paramView != null) {
        paramView.onClose();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker$checkInit$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(192359);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<ImageView>
  {
    f(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/TextColorSelector;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<TextColorSelector>
  {
    g(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<View>
  {
    h(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends q
    implements d.g.a.a<ImageView>
  {
    i(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */