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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker;", "", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;)V", "callback", "Lcom/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker$ColorPickerCallback;", "getCallback", "()Lcom/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker$ColorPickerCallback;", "setCallback", "(Lcom/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker$ColorPickerCallback;)V", "closeBtn", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getCloseBtn", "()Landroid/widget/ImageView;", "closeBtn$delegate", "Lkotlin/Lazy;", "colorList", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/TextColorSelector;", "getColorList", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/TextColorSelector;", "colorList$delegate", "getHolder", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "isInit", "", "panelRoot", "Landroid/view/View;", "getPanelRoot", "()Landroid/view/View;", "panelRoot$delegate", "undoBtn", "getUndoBtn", "undoBtn$delegate", "checkInit", "", "updateSelect", "ColorPickerCallback", "Companion", "plugin-vlog_release"})
public final class a
{
  public static final int[] BUW;
  public static final a.b BUX;
  private final f BMu;
  private final f BUT;
  public final f BUU;
  public a BUV;
  public boolean cAX;
  public final f sDT;
  public final EditorPanelHolder sRz;
  
  static
  {
    AppMethodBeat.i(196904);
    BUX = new a.b((byte)0);
    BUW = new int[] { -1, -16777216, -707825, -17592, -16535286, -15172610, -7054596 };
    AppMethodBeat.o(196904);
  }
  
  public a(EditorPanelHolder paramEditorPanelHolder)
  {
    AppMethodBeat.i(196903);
    this.sRz = paramEditorPanelHolder;
    this.BMu = g.O((d.g.a.a)new h(this));
    this.BUT = g.O((d.g.a.a)new g(this));
    this.BUU = g.O((d.g.a.a)new i(this));
    this.sDT = g.O((d.g.a.a)new f(this));
    AppMethodBeat.o(196903);
  }
  
  public final View ets()
  {
    AppMethodBeat.i(196901);
    View localView = (View)this.BMu.getValue();
    AppMethodBeat.o(196901);
    return localView;
  }
  
  public final TextColorSelector eug()
  {
    AppMethodBeat.i(196902);
    TextColorSelector localTextColorSelector = (TextColorSelector)this.BUT.getValue();
    AppMethodBeat.o(196902);
    return localTextColorSelector;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker$ColorPickerCallback;", "", "onClose", "", "onSelectColor", "index", "", "onUndo", "plugin-vlog_release"})
  public static abstract interface a
  {
    public abstract void NJ();
    
    public abstract void TD(int paramInt);
    
    public abstract void onClose();
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  public static final class c
    extends q
    implements d.g.a.b<Integer, z>
  {
    public c(a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class d
    implements View.OnClickListener
  {
    public d(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(196895);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = this.BUY.BUV;
      if (paramView != null) {
        paramView.NJ();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(196895);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class e
    implements View.OnClickListener
  {
    public e(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(196896);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker$checkInit$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = this.BUY.BUV;
      if (paramView != null) {
        paramView.onClose();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker$checkInit$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(196896);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<ImageView>
  {
    f(a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/TextColorSelector;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<TextColorSelector>
  {
    g(a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<View>
  {
    h(a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */