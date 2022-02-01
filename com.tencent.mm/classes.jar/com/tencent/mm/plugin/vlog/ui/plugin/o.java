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
import com.tencent.mm.ui.ao;
import d.f;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiEditPhotoPencilPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "layout", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "colorPicker", "Lcom/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker;", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "kotlin.jvm.PlatformType", "isSelected", "", "getLayout", "()Landroid/view/ViewGroup;", "pencilBtn", "Landroid/widget/ImageView;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "close", "", "onBackPress", "reset", "setVisibility", "visibility", "", "plugin-vlog_release"})
public final class o
  implements t
{
  private final ViewGroup Ceh;
  final com.tencent.mm.plugin.vlog.ui.widget.a Cfc;
  final ImageView Cfd;
  boolean isSelected;
  final d tbP;
  final EditorPanelHolder tcK;
  
  public o(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(191730);
    this.Ceh = paramViewGroup;
    this.tbP = paramd;
    this.tcK = ((EditorPanelHolder)this.Ceh.findViewById(2131308283));
    paramViewGroup = this.tcK;
    p.g(paramViewGroup, "holder");
    this.Cfc = new com.tencent.mm.plugin.vlog.ui.widget.a(paramViewGroup);
    this.Cfd = ((ImageView)this.Ceh.findViewById(2131299280));
    paramViewGroup = this.Cfd;
    paramd = this.Cfd;
    p.g(paramd, "pencilBtn");
    paramViewGroup.setImageDrawable(ao.k(paramd.getContext(), 2131690394, -1));
    this.Cfd.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191722);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/MultiEditPhotoPencilPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        paramAnonymousView = this.Cfe;
        boolean bool;
        if (!this.Cfe.isSelected)
        {
          bool = true;
          paramAnonymousView.isSelected = bool;
          if (!this.Cfe.isSelected) {
            break label459;
          }
          paramAnonymousView = c.xWV;
          c.axc("KEY_CLICK_DOODLE_COUNT_INT");
          paramAnonymousView = c.xWV;
          c.Os(7);
          paramAnonymousView = this.Cfe.Cfd;
          localObject1 = this.Cfe.Cfd;
          p.g(localObject1, "pencilBtn");
          localObject1 = ((ImageView)localObject1).getContext();
          Object localObject2 = this.Cfe.Cfd;
          p.g(localObject2, "pencilBtn");
          paramAnonymousView.setImageDrawable(ao.k((Context)localObject1, 2131690394, ((ImageView)localObject2).getResources().getColor(2131101171)));
          d.b.a(this.Cfe.tbP, d.c.xUX);
          paramAnonymousView = this.Cfe.Cfc;
          if (!paramAnonymousView.cBE)
          {
            paramAnonymousView.cBE = true;
            paramAnonymousView.tcK.setCloseTouchOutside(false);
            paramAnonymousView.tcK.setOutsideTouchable(true);
            localObject1 = paramAnonymousView.exM();
            localObject2 = paramAnonymousView.ewZ();
            p.g(localObject2, "panelRoot");
            ((TextColorSelector)localObject1).setRadiusNormalInner(com.tencent.mm.cb.a.fromDPToPix(((View)localObject2).getContext(), 10));
            localObject1 = paramAnonymousView.exM();
            localObject2 = paramAnonymousView.ewZ();
            p.g(localObject2, "panelRoot");
            ((TextColorSelector)localObject1).setRadiusNormalOuter(((View)localObject2).getResources().getDimension(2131165284));
            paramAnonymousView.exM().setRadiusSelectInner(paramAnonymousView.exM().getRadiusNormalOuter());
            localObject1 = paramAnonymousView.exM();
            localObject2 = paramAnonymousView.ewZ();
            p.g(localObject2, "panelRoot");
            ((TextColorSelector)localObject1).setRadiusSelectOuter(((View)localObject2).getResources().getDimension(2131165289));
            paramAnonymousView.exM().setColorList(com.tencent.mm.plugin.vlog.ui.widget.a.Cmx);
            paramAnonymousView.exM().setSelected(2);
            paramAnonymousView.exM().setColorSelectedCallback((d.g.a.b)new a.c(paramAnonymousView));
            ((ImageView)paramAnonymousView.Cmv.getValue()).setOnClickListener((View.OnClickListener)new a.d(paramAnonymousView));
            ((ImageView)paramAnonymousView.sOS.getValue()).setOnClickListener((View.OnClickListener)new a.e(paramAnonymousView));
          }
          this.Cfe.tcK.setShow(true);
          paramAnonymousView = this.Cfe.Cfc;
          localObject1 = paramAnonymousView.Cmw;
          if (localObject1 != null) {
            ((a.a)localObject1).Uk(paramAnonymousView.exM().getSelected());
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MultiEditPhotoPencilPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(191722);
          return;
          bool = false;
          break;
          label459:
          this.Cfe.close();
        }
      }
    });
    this.Cfc.Cmw = ((a.a)new a.a()
    {
      public final void NH()
      {
        AppMethodBeat.i(191724);
        d.b.a(this.Cfe.tbP, d.c.xVf);
        AppMethodBeat.o(191724);
      }
      
      public final void Uk(int paramAnonymousInt)
      {
        AppMethodBeat.i(191723);
        Bundle localBundle = new Bundle();
        localBundle.putInt("EDIT_PHOTO_DOODLE_PENCIL_INDEX_INT", paramAnonymousInt);
        this.Cfe.tbP.a(d.c.xVe, localBundle);
        AppMethodBeat.o(191723);
      }
      
      public final void onClose()
      {
        AppMethodBeat.i(191725);
        this.Cfe.isSelected = false;
        this.Cfe.close();
        AppMethodBeat.o(191725);
      }
    });
    AppMethodBeat.o(191730);
  }
  
  public final boolean aoQ()
  {
    AppMethodBeat.i(191728);
    if (this.tcK.bnS())
    {
      this.isSelected = false;
      close();
      AppMethodBeat.o(191728);
      return true;
    }
    AppMethodBeat.o(191728);
    return false;
  }
  
  public final void azm() {}
  
  final void close()
  {
    AppMethodBeat.i(191729);
    this.tcK.setShow(false);
    d.b.a(this.tbP, d.c.xVb);
    ImageView localImageView1 = this.Cfd;
    ImageView localImageView2 = this.Cfd;
    p.g(localImageView2, "pencilBtn");
    localImageView1.setImageDrawable(ao.k(localImageView2.getContext(), 2131690394, -1));
    this.tcK.setShow(false);
    AppMethodBeat.o(191729);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(191731);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(191731);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset()
  {
    AppMethodBeat.i(191727);
    this.isSelected = false;
    close();
    AppMethodBeat.o(191727);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(191726);
    ImageView localImageView = this.Cfd;
    p.g(localImageView, "pencilBtn");
    localImageView.setVisibility(paramInt);
    AppMethodBeat.o(191726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.o
 * JD-Core Version:    0.7.0.1
 */