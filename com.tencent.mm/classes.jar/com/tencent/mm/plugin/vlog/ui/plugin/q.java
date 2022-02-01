package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.TextColorSelector;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.a.h;
import com.tencent.mm.plugin.vlog.ui.widget.a.a;
import com.tencent.mm.plugin.vlog.ui.widget.a.e;
import com.tencent.mm.ui.au;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiEditPhotoPencilPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseIconPlugin;", "layout", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "colorPicker", "Lcom/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker;", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "kotlin.jvm.PlatformType", "iconColor", "", "isSelected", "", "getLayout", "()Landroid/view/ViewGroup;", "pencilBtn", "Landroid/widget/ImageView;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "close", "", "onBackPress", "reset", "resetIconColor", "setVisibility", "visibility", "plugin-vlog_release"})
public final class q
  extends com.tencent.mm.plugin.recordvideo.plugin.a
{
  private final ViewGroup APk;
  final d APl;
  final EditorPanelHolder ATq;
  final com.tencent.mm.plugin.vlog.ui.widget.a Nvw;
  final ImageView Nvx;
  private int iconColor;
  boolean isSelected;
  
  public q(ViewGroup paramViewGroup, d paramd)
  {
    super(paramd, (byte)0);
    AppMethodBeat.i(235673);
    this.APk = paramViewGroup;
    this.APl = paramd;
    this.ATq = ((EditorPanelHolder)this.APk.findViewById(a.f.editor_image_pencil_panel));
    paramViewGroup = this.ATq;
    p.j(paramViewGroup, "holder");
    this.Nvw = new com.tencent.mm.plugin.vlog.ui.widget.a(paramViewGroup);
    this.Nvx = ((ImageView)this.APk.findViewById(a.f.editor_add_pencil));
    this.iconColor = -1;
    paramViewGroup = this.Nvx;
    paramd = this.Nvx;
    p.j(paramd, "pencilBtn");
    paramViewGroup.setImageDrawable(au.o(paramd.getContext(), a.h.icons_filled_duddle, -1));
    this.Nvx.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(235843);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/MultiEditPhotoPencilPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        paramAnonymousView = this.Nvy;
        boolean bool;
        if (!this.Nvy.isSelected)
        {
          bool = true;
          paramAnonymousView.isSelected = bool;
          if (!this.Nvy.isSelected) {
            break label482;
          }
          paramAnonymousView = c.HUw;
          c.aVY("KEY_CLICK_DOODLE_COUNT_INT");
          paramAnonymousView = c.HUw;
          c.acq(7);
          paramAnonymousView = this.Nvy.Nvx;
          localObject1 = this.Nvy.Nvx;
          p.j(localObject1, "pencilBtn");
          localObject1 = ((ImageView)localObject1).getContext();
          int i = a.h.icons_filled_duddle;
          Object localObject2 = this.Nvy.Nvx;
          p.j(localObject2, "pencilBtn");
          paramAnonymousView.setImageDrawable(au.o((Context)localObject1, i, ((ImageView)localObject2).getResources().getColor(com.tencent.mm.plugin.vlog.a.c.wechat_green)));
          d.b.a(this.Nvy.APl, d.c.HSs);
          paramAnonymousView = this.Nvy.Nvw;
          if (!paramAnonymousView.isInit)
          {
            paramAnonymousView.isInit = true;
            paramAnonymousView.ATq.setCloseTouchOutside(false);
            paramAnonymousView.ATq.setOutsideTouchable(true);
            localObject1 = paramAnonymousView.gwM();
            localObject2 = paramAnonymousView.gvl();
            p.j(localObject2, "panelRoot");
            ((TextColorSelector)localObject1).setRadiusNormalInner(com.tencent.mm.ci.a.fromDPToPix(((View)localObject2).getContext(), 10));
            localObject1 = paramAnonymousView.gwM();
            localObject2 = paramAnonymousView.gvl();
            p.j(localObject2, "panelRoot");
            ((TextColorSelector)localObject1).setRadiusNormalOuter(((View)localObject2).getResources().getDimension(com.tencent.mm.plugin.vlog.a.d.Edge_1_5_A));
            paramAnonymousView.gwM().setRadiusSelectInner(paramAnonymousView.gwM().getRadiusNormalOuter());
            localObject1 = paramAnonymousView.gwM();
            localObject2 = paramAnonymousView.gvl();
            p.j(localObject2, "panelRoot");
            ((TextColorSelector)localObject1).setRadiusSelectOuter(((View)localObject2).getResources().getDimension(com.tencent.mm.plugin.vlog.a.d.Edge_2A));
            paramAnonymousView.gwM().setColorList(com.tencent.mm.plugin.vlog.ui.widget.a.NGm);
            paramAnonymousView.gwM().setSelected(2);
            paramAnonymousView.gwM().setColorSelectedCallback((kotlin.g.a.b)new com.tencent.mm.plugin.vlog.ui.widget.a.c(paramAnonymousView));
            ((ImageView)paramAnonymousView.NGk.getValue()).setOnClickListener((View.OnClickListener)new com.tencent.mm.plugin.vlog.ui.widget.a.d(paramAnonymousView));
            ((ImageView)paramAnonymousView.AsJ.getValue()).setOnClickListener((View.OnClickListener)new a.e(paramAnonymousView));
          }
          this.Nvy.ATq.setShow(true);
          paramAnonymousView = this.Nvy.Nvw;
          localObject1 = paramAnonymousView.NGl;
          if (localObject1 != null) {
            ((a.a)localObject1).akj(paramAnonymousView.gwM().getSelected());
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MultiEditPhotoPencilPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(235843);
          return;
          bool = false;
          break;
          label482:
          this.Nvy.close();
        }
      }
    });
    this.Nvw.NGl = ((a.a)new a.a()
    {
      public final void acz()
      {
        AppMethodBeat.i(228737);
        d.b.a(this.Nvy.APl, d.c.HSA);
        AppMethodBeat.o(228737);
      }
      
      public final void akj(int paramAnonymousInt)
      {
        AppMethodBeat.i(228735);
        Bundle localBundle = new Bundle();
        localBundle.putInt("EDIT_PHOTO_DOODLE_PENCIL_INDEX_INT", paramAnonymousInt);
        this.Nvy.APl.a(d.c.HSz, localBundle);
        AppMethodBeat.o(228735);
      }
      
      public final void onClose()
      {
        AppMethodBeat.i(228740);
        this.Nvy.isSelected = false;
        this.Nvy.close();
        AppMethodBeat.o(228740);
      }
    });
    AppMethodBeat.o(235673);
  }
  
  public final void acl(int paramInt)
  {
    AppMethodBeat.i(235670);
    this.iconColor = paramInt;
    ImageView localImageView1 = this.Nvx;
    ImageView localImageView2 = this.Nvx;
    p.j(localImageView2, "pencilBtn");
    localImageView1.setImageDrawable(au.o(localImageView2.getContext(), a.h.icons_filled_duddle, paramInt));
    AppMethodBeat.o(235670);
  }
  
  final void close()
  {
    AppMethodBeat.i(235668);
    this.ATq.setShow(false);
    d.b.a(this.APl, d.c.HSw);
    ImageView localImageView1 = this.Nvx;
    ImageView localImageView2 = this.Nvx;
    p.j(localImageView2, "pencilBtn");
    localImageView1.setImageDrawable(au.o(localImageView2.getContext(), a.h.icons_filled_duddle, this.iconColor));
    this.ATq.setShow(false);
    AppMethodBeat.o(235668);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(235665);
    if (this.ATq.bVd())
    {
      this.isSelected = false;
      close();
      AppMethodBeat.o(235665);
      return true;
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(235665);
    return bool;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(235662);
    this.isSelected = false;
    close();
    AppMethodBeat.o(235662);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(235660);
    super.setVisibility(paramInt);
    ImageView localImageView = this.Nvx;
    p.j(localImageView, "pencilBtn");
    localImageView.setVisibility(paramInt);
    AppMethodBeat.o(235660);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.q
 * JD-Core Version:    0.7.0.1
 */