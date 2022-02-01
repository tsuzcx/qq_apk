package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.content.Intent;
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
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.TextColorSelector;
import com.tencent.mm.plugin.vlog.ui.widget.a.a;
import com.tencent.mm.plugin.vlog.ui.widget.a.c;
import com.tencent.mm.plugin.vlog.ui.widget.a.d;
import com.tencent.mm.plugin.vlog.ui.widget.a.e;
import com.tencent.mm.ui.ar;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiEditPhotoPencilPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseIconPlugin;", "layout", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "colorPicker", "Lcom/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker;", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "kotlin.jvm.PlatformType", "iconColor", "", "isSelected", "", "getLayout", "()Landroid/view/ViewGroup;", "pencilBtn", "Landroid/widget/ImageView;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "close", "", "onBackPress", "reset", "resetIconColor", "setVisibility", "visibility", "plugin-vlog_release"})
public final class r
  implements t
{
  final com.tencent.mm.plugin.vlog.ui.widget.a GHI;
  final ImageView GHJ;
  boolean isSelected;
  private int uzt;
  private final ViewGroup wgq;
  final d wgr;
  final EditorPanelHolder wji;
  
  public r(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(191356);
    this.wgq = paramViewGroup;
    this.wgr = paramd;
    this.wji = ((EditorPanelHolder)this.wgq.findViewById(2131299885));
    paramViewGroup = this.wji;
    p.g(paramViewGroup, "holder");
    this.GHI = new com.tencent.mm.plugin.vlog.ui.widget.a(paramViewGroup);
    this.GHJ = ((ImageView)this.wgq.findViewById(2131299868));
    this.uzt = -1;
    paramViewGroup = this.GHJ;
    paramd = this.GHJ;
    p.g(paramd, "pencilBtn");
    paramViewGroup.setImageDrawable(ar.m(paramd.getContext(), 2131690543, -1));
    this.GHJ.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191347);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/MultiEditPhotoPencilPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        paramAnonymousView = this.GHK;
        boolean bool;
        if (!this.GHK.isSelected)
        {
          bool = true;
          paramAnonymousView.isSelected = bool;
          if (!this.GHK.isSelected) {
            break label459;
          }
          paramAnonymousView = c.BXI;
          c.aLu("KEY_CLICK_DOODLE_COUNT_INT");
          paramAnonymousView = c.BXI;
          c.VH(7);
          paramAnonymousView = this.GHK.GHJ;
          localObject1 = this.GHK.GHJ;
          p.g(localObject1, "pencilBtn");
          localObject1 = ((ImageView)localObject1).getContext();
          Object localObject2 = this.GHK.GHJ;
          p.g(localObject2, "pencilBtn");
          paramAnonymousView.setImageDrawable(ar.m((Context)localObject1, 2131690543, ((ImageView)localObject2).getResources().getColor(2131101414)));
          d.b.a(this.GHK.wgr, d.c.BVE);
          paramAnonymousView = this.GHK.GHI;
          if (!paramAnonymousView.isInit)
          {
            paramAnonymousView.isInit = true;
            paramAnonymousView.wji.setCloseTouchOutside(false);
            paramAnonymousView.wji.setOutsideTouchable(true);
            localObject1 = paramAnonymousView.fEz();
            localObject2 = paramAnonymousView.fDm();
            p.g(localObject2, "panelRoot");
            ((TextColorSelector)localObject1).setRadiusNormalInner(com.tencent.mm.cb.a.fromDPToPix(((View)localObject2).getContext(), 10));
            localObject1 = paramAnonymousView.fEz();
            localObject2 = paramAnonymousView.fDm();
            p.g(localObject2, "panelRoot");
            ((TextColorSelector)localObject1).setRadiusNormalOuter(((View)localObject2).getResources().getDimension(2131165289));
            paramAnonymousView.fEz().setRadiusSelectInner(paramAnonymousView.fEz().getRadiusNormalOuter());
            localObject1 = paramAnonymousView.fEz();
            localObject2 = paramAnonymousView.fDm();
            p.g(localObject2, "panelRoot");
            ((TextColorSelector)localObject1).setRadiusSelectOuter(((View)localObject2).getResources().getDimension(2131165296));
            paramAnonymousView.fEz().setColorList(com.tencent.mm.plugin.vlog.ui.widget.a.GQw);
            paramAnonymousView.fEz().setSelected(2);
            paramAnonymousView.fEz().setColorSelectedCallback((kotlin.g.a.b)new a.c(paramAnonymousView));
            ((ImageView)paramAnonymousView.GQu.getValue()).setOnClickListener((View.OnClickListener)new a.d(paramAnonymousView));
            ((ImageView)paramAnonymousView.vLW.getValue()).setOnClickListener((View.OnClickListener)new a.e(paramAnonymousView));
          }
          this.GHK.wji.setShow(true);
          paramAnonymousView = this.GHK.GHI;
          localObject1 = paramAnonymousView.GQv;
          if (localObject1 != null) {
            ((a.a)localObject1).acC(paramAnonymousView.fEz().getSelected());
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MultiEditPhotoPencilPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(191347);
          return;
          bool = false;
          break;
          label459:
          this.GHK.close();
        }
      }
    });
    this.GHI.GQv = ((a.a)new a.a()
    {
      public final void XT()
      {
        AppMethodBeat.i(191349);
        d.b.a(this.GHK.wgr, d.c.BVM);
        AppMethodBeat.o(191349);
      }
      
      public final void acC(int paramAnonymousInt)
      {
        AppMethodBeat.i(191348);
        Bundle localBundle = new Bundle();
        localBundle.putInt("EDIT_PHOTO_DOODLE_PENCIL_INDEX_INT", paramAnonymousInt);
        this.GHK.wgr.a(d.c.BVL, localBundle);
        AppMethodBeat.o(191348);
      }
      
      public final void onClose()
      {
        AppMethodBeat.i(191350);
        this.GHK.isSelected = false;
        this.GHK.close();
        AppMethodBeat.o(191350);
      }
    });
    AppMethodBeat.o(191356);
  }
  
  public final void VC(int paramInt)
  {
    AppMethodBeat.i(191355);
    this.uzt = paramInt;
    ImageView localImageView1 = this.GHJ;
    ImageView localImageView2 = this.GHJ;
    p.g(localImageView2, "pencilBtn");
    localImageView1.setImageDrawable(ar.m(localImageView2.getContext(), 2131690543, paramInt));
    AppMethodBeat.o(191355);
  }
  
  public final void aSs() {}
  
  final void close()
  {
    AppMethodBeat.i(191354);
    this.wji.setShow(false);
    d.b.a(this.wgr, d.c.BVI);
    ImageView localImageView1 = this.GHJ;
    ImageView localImageView2 = this.GHJ;
    p.g(localImageView2, "pencilBtn");
    localImageView1.setImageDrawable(ar.m(localImageView2.getContext(), 2131690543, this.uzt));
    this.wji.setShow(false);
    AppMethodBeat.o(191354);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(191353);
    if (this.wji.bJw())
    {
      this.isSelected = false;
      close();
      AppMethodBeat.o(191353);
      return true;
    }
    AppMethodBeat.o(191353);
    return false;
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(191357);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(191357);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset()
  {
    AppMethodBeat.i(191352);
    this.isSelected = false;
    close();
    AppMethodBeat.o(191352);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(191351);
    ImageView localImageView = this.GHJ;
    p.g(localImageView, "pencilBtn");
    localImageView.setVisibility(paramInt);
    AppMethodBeat.o(191351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.r
 * JD-Core Version:    0.7.0.1
 */