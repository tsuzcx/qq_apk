package com.tencent.mm.plugin.vlog.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.TextColorSelector;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker;", "", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;)V", "callback", "Lcom/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker$ColorPickerCallback;", "getCallback", "()Lcom/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker$ColorPickerCallback;", "setCallback", "(Lcom/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker$ColorPickerCallback;)V", "closeBtn", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getCloseBtn", "()Landroid/widget/ImageView;", "closeBtn$delegate", "Lkotlin/Lazy;", "colorList", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/TextColorSelector;", "getColorList", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/TextColorSelector;", "colorList$delegate", "getHolder", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "isInit", "", "panelRoot", "Landroid/view/View;", "getPanelRoot", "()Landroid/view/View;", "panelRoot$delegate", "undoBtn", "getUndoBtn", "undoBtn$delegate", "checkInit", "", "updateSelect", "ColorPickerCallback", "Companion", "plugin-vlog_release"})
public final class a
{
  public static final int[] GQw;
  public static final a.b GQx;
  private final f GGj;
  private final f GQt;
  public final f GQu;
  public a GQv;
  public boolean isInit;
  public final f vLW;
  public final EditorPanelHolder wji;
  
  static
  {
    AppMethodBeat.i(192211);
    GQx = new a.b((byte)0);
    GQw = new int[] { -1, -16777216, -707825, -17592, -16535286, -15172610, -7054596 };
    AppMethodBeat.o(192211);
  }
  
  public a(EditorPanelHolder paramEditorPanelHolder)
  {
    AppMethodBeat.i(192210);
    this.wji = paramEditorPanelHolder;
    this.GGj = g.ah((kotlin.g.a.a)new h(this));
    this.GQt = g.ah((kotlin.g.a.a)new g(this));
    this.GQu = g.ah((kotlin.g.a.a)new i(this));
    this.vLW = g.ah((kotlin.g.a.a)new f(this));
    AppMethodBeat.o(192210);
  }
  
  public final View fDm()
  {
    AppMethodBeat.i(192208);
    View localView = (View)this.GGj.getValue();
    AppMethodBeat.o(192208);
    return localView;
  }
  
  public final TextColorSelector fEz()
  {
    AppMethodBeat.i(192209);
    TextColorSelector localTextColorSelector = (TextColorSelector)this.GQt.getValue();
    AppMethodBeat.o(192209);
    return localTextColorSelector;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker$ColorPickerCallback;", "", "onClose", "", "onSelectColor", "index", "", "onUndo", "plugin-vlog_release"})
  public static abstract interface a
  {
    public abstract void XT();
    
    public abstract void acC(int paramInt);
    
    public abstract void onClose();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  public static final class c
    extends q
    implements kotlin.g.a.b<Integer, x>
  {
    public c(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class d
    implements View.OnClickListener
  {
    public d(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(192202);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.GQy.GQv;
      if (paramView != null) {
        paramView.XT();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(192202);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class e
    implements View.OnClickListener
  {
    public e(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(192203);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker$checkInit$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.GQy.GQv;
      if (paramView != null) {
        paramView.onClose();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker$checkInit$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(192203);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    f(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/TextColorSelector;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<TextColorSelector>
  {
    g(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<View>
  {
    h(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    i(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */