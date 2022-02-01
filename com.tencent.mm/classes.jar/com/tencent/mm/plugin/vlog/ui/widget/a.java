package com.tencent.mm.plugin.vlog.ui.widget;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.TextColorSelector;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker;", "", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;)V", "callback", "Lcom/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker$ColorPickerCallback;", "getCallback", "()Lcom/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker$ColorPickerCallback;", "setCallback", "(Lcom/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker$ColorPickerCallback;)V", "closeBtn", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getCloseBtn", "()Landroid/widget/ImageView;", "closeBtn$delegate", "Lkotlin/Lazy;", "colorList", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/TextColorSelector;", "getColorList", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/TextColorSelector;", "colorList$delegate", "getHolder", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "isInit", "", "panelRoot", "Landroid/view/View;", "getPanelRoot", "()Landroid/view/View;", "panelRoot$delegate", "undoBtn", "getUndoBtn", "undoBtn$delegate", "checkInit", "", "updateSelect", "ColorPickerCallback", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.b Uso;
  private static final int[] Uss;
  private final j FSd;
  final EditorPanelHolder Gvm;
  private final j Uhs;
  private final j Usp;
  private final j Usq;
  public a Usr;
  private boolean isInit;
  
  static
  {
    AppMethodBeat.i(281842);
    Uso = new a.b((byte)0);
    Uss = new int[] { -1, -16777216, -707825, -17592, -16535286, -15172610, -7054596 };
    AppMethodBeat.o(281842);
  }
  
  public a(EditorPanelHolder paramEditorPanelHolder)
  {
    AppMethodBeat.i(281803);
    this.Gvm = paramEditorPanelHolder;
    this.Uhs = k.cm((kotlin.g.a.a)new f(this));
    this.Usp = k.cm((kotlin.g.a.a)new e(this));
    this.Usq = k.cm((kotlin.g.a.a)new g(this));
    this.FSd = k.cm((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(281803);
  }
  
  private static final void a(a parama, View paramView)
  {
    AppMethodBeat.i(281822);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama = parama.Usr;
    if (parama != null) {
      parama.aEz();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(281822);
  }
  
  private static final void b(a parama, View paramView)
  {
    AppMethodBeat.i(281830);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama = parama.Usr;
    if (parama != null) {
      parama.bfj();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(281830);
  }
  
  private final View hTb()
  {
    AppMethodBeat.i(281807);
    View localView = (View)this.Uhs.getValue();
    AppMethodBeat.o(281807);
    return localView;
  }
  
  public final void checkInit()
  {
    AppMethodBeat.i(281872);
    if (this.isInit)
    {
      AppMethodBeat.o(281872);
      return;
    }
    this.isInit = true;
    this.Gvm.setCloseTouchOutside(false);
    this.Gvm.setOutsideTouchable(true);
    hUJ().setRadiusNormalInner(com.tencent.mm.cd.a.fromDPToPix(hTb().getContext(), 10));
    hUJ().setRadiusNormalOuter(hTb().getResources().getDimension(com.tencent.mm.plugin.vlog.a.d.Edge_1_5_A));
    hUJ().setRadiusSelectInner(hUJ().getRadiusNormalOuter());
    hUJ().setRadiusSelectOuter(hTb().getResources().getDimension(com.tencent.mm.plugin.vlog.a.d.Edge_2A));
    hUJ().setColorList(Uss);
    hUJ().setSelected(2);
    hUJ().setColorSelectedCallback((kotlin.g.a.b)new c(this));
    ((ImageView)this.Usq.getValue()).setOnClickListener(new a..ExternalSyntheticLambda0(this));
    ((ImageView)this.FSd.getValue()).setOnClickListener(new a..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(281872);
  }
  
  public final TextColorSelector hUJ()
  {
    AppMethodBeat.i(281862);
    TextColorSelector localTextColorSelector = (TextColorSelector)this.Usp.getValue();
    AppMethodBeat.o(281862);
    return localTextColorSelector;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker$ColorPickerCallback;", "", "onClose", "", "onSelectColor", "index", "", "onUndo", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void aEz();
    
    public abstract void apC(int paramInt);
    
    public abstract void bfj();
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Integer, ah>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    d(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/TextColorSelector;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<TextColorSelector>
  {
    e(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<View>
  {
    f(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    g(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */