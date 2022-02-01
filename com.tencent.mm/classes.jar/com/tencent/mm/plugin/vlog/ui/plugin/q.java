package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.f.c;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.TextColorSelector;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.a.h;
import com.tencent.mm.plugin.vlog.ui.widget.a.a;
import com.tencent.mm.ui.bb;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiEditPhotoPencilPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseIconPlugin;", "layout", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "colorPicker", "Lcom/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker;", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "kotlin.jvm.PlatformType", "iconColor", "", "isSelected", "", "getLayout", "()Landroid/view/ViewGroup;", "pencilBtn", "Landroid/widget/ImageView;", "close", "", "onBackPress", "reset", "resetIconColor", "setVisibility", "visibility", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  extends com.tencent.mm.plugin.recordvideo.plugin.a
{
  private final ViewGroup GrB;
  private final EditorPanelHolder Gvm;
  private final com.tencent.mm.plugin.vlog.ui.widget.a UiK;
  private final ImageView UiL;
  private int iconColor;
  boolean isSelected;
  
  public q(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    super(parama);
    AppMethodBeat.i(282448);
    this.GrB = paramViewGroup;
    this.Gvm = ((EditorPanelHolder)this.GrB.findViewById(a.f.editor_image_pencil_panel));
    paramViewGroup = this.Gvm;
    s.s(paramViewGroup, "holder");
    this.UiK = new com.tencent.mm.plugin.vlog.ui.widget.a(paramViewGroup);
    this.UiL = ((ImageView)this.GrB.findViewById(a.f.editor_add_pencil));
    this.iconColor = -1;
    this.UiL.setImageDrawable(bb.m(this.UiL.getContext(), a.h.icons_filled_duddle, -1));
    this.UiL.setOnClickListener(new q..ExternalSyntheticLambda0(this, parama));
    this.UiK.Usr = ((a.a)new a.a()
    {
      public final void aEz()
      {
        AppMethodBeat.i(282833);
        a.b.a(this.NJL, com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NPg);
        AppMethodBeat.o(282833);
      }
      
      public final void apC(int paramAnonymousInt)
      {
        AppMethodBeat.i(282826);
        Bundle localBundle = new Bundle();
        localBundle.putInt("EDIT_PHOTO_DOODLE_PENCIL_INDEX_INT", paramAnonymousInt);
        this.NJL.a(com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NPf, localBundle);
        AppMethodBeat.o(282826);
      }
      
      public final void bfj()
      {
        AppMethodBeat.i(282839);
        jdField_this.isSelected = false;
        jdField_this.close();
        AppMethodBeat.o(282839);
      }
    });
    AppMethodBeat.o(282448);
  }
  
  private static final void a(q paramq, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama, View paramView)
  {
    AppMethodBeat.i(282460);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramq);
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/MultiEditPhotoPencilPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramq, "this$0");
    s.u(parama, "$status");
    boolean bool;
    if (!paramq.isSelected)
    {
      bool = true;
      paramq.isSelected = bool;
      if (!paramq.isSelected) {
        break label221;
      }
      paramView = c.NRf;
      c.aTg("KEY_CLICK_DOODLE_COUNT_INT");
      paramView = c.NRf;
      c.agG(7);
      paramq.UiL.setImageDrawable(bb.m(paramq.UiL.getContext(), a.h.icons_filled_duddle, paramq.UiL.getResources().getColor(com.tencent.mm.plugin.vlog.a.c.wechat_green)));
      a.b.a(parama, com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NOY);
      paramq.UiK.checkInit();
      paramq.Gvm.setShow(true);
      paramq = paramq.UiK;
      parama = paramq.Usr;
      if (parama != null) {
        parama.apC(paramq.hUJ().getSelected());
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/plugin/MultiEditPhotoPencilPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(282460);
      return;
      bool = false;
      break;
      label221:
      paramq.close();
    }
  }
  
  public final void agy(int paramInt)
  {
    AppMethodBeat.i(282514);
    this.iconColor = paramInt;
    this.UiL.setImageDrawable(bb.m(this.UiL.getContext(), a.h.icons_filled_duddle, paramInt));
    AppMethodBeat.o(282514);
  }
  
  final void close()
  {
    AppMethodBeat.i(282503);
    this.Gvm.setShow(false);
    a.b.a(this.GrC, com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NPc);
    this.UiL.setImageDrawable(bb.m(this.UiL.getContext(), a.h.icons_filled_duddle, this.iconColor));
    this.Gvm.setShow(false);
    AppMethodBeat.o(282503);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(282492);
    if (this.Gvm.cvt())
    {
      this.isSelected = false;
      close();
      AppMethodBeat.o(282492);
      return true;
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(282492);
    return bool;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(282484);
    this.isSelected = false;
    close();
    AppMethodBeat.o(282484);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(282474);
    super.setVisibility(paramInt);
    this.UiL.setVisibility(paramInt);
    AppMethodBeat.o(282474);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.q
 * JD-Core Version:    0.7.0.1
 */