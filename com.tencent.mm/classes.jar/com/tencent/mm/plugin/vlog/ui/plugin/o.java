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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiEditPhotoPencilPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "layout", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "colorPicker", "Lcom/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker;", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "kotlin.jvm.PlatformType", "isSelected", "", "getLayout", "()Landroid/view/ViewGroup;", "pencilBtn", "Landroid/widget/ImageView;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "close", "", "onBackPress", "reset", "setVisibility", "visibility", "", "plugin-vlog_release"})
public final class o
  implements t
{
  private final ViewGroup BMI;
  final com.tencent.mm.plugin.vlog.ui.widget.a BND;
  final ImageView BNE;
  boolean isSelected;
  final d sQE;
  final EditorPanelHolder sRz;
  
  public o(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(196271);
    this.BMI = paramViewGroup;
    this.sQE = paramd;
    this.sRz = ((EditorPanelHolder)this.BMI.findViewById(2131308283));
    paramViewGroup = this.sRz;
    p.g(paramViewGroup, "holder");
    this.BND = new com.tencent.mm.plugin.vlog.ui.widget.a(paramViewGroup);
    this.BNE = ((ImageView)this.BMI.findViewById(2131299280));
    paramViewGroup = this.BNE;
    paramd = this.BNE;
    p.g(paramd, "pencilBtn");
    paramViewGroup.setImageDrawable(ao.k(paramd.getContext(), 2131690394, -1));
    this.BNE.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196263);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/MultiEditPhotoPencilPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        paramAnonymousView = this.BNF;
        boolean bool;
        if (!this.BNF.isSelected)
        {
          bool = true;
          paramAnonymousView.isSelected = bool;
          if (!this.BNF.isSelected) {
            break label459;
          }
          paramAnonymousView = c.xHa;
          c.avN("KEY_CLICK_DOODLE_COUNT_INT");
          paramAnonymousView = c.xHa;
          c.NM(7);
          paramAnonymousView = this.BNF.BNE;
          localObject1 = this.BNF.BNE;
          p.g(localObject1, "pencilBtn");
          localObject1 = ((ImageView)localObject1).getContext();
          Object localObject2 = this.BNF.BNE;
          p.g(localObject2, "pencilBtn");
          paramAnonymousView.setImageDrawable(ao.k((Context)localObject1, 2131690394, ((ImageView)localObject2).getResources().getColor(2131101171)));
          d.b.a(this.BNF.sQE, d.c.xFc);
          paramAnonymousView = this.BNF.BND;
          if (!paramAnonymousView.cAX)
          {
            paramAnonymousView.cAX = true;
            paramAnonymousView.sRz.setCloseTouchOutside(false);
            paramAnonymousView.sRz.setOutsideTouchable(true);
            localObject1 = paramAnonymousView.eug();
            localObject2 = paramAnonymousView.ets();
            p.g(localObject2, "panelRoot");
            ((TextColorSelector)localObject1).setRadiusNormalInner(com.tencent.mm.cc.a.fromDPToPix(((View)localObject2).getContext(), 10));
            localObject1 = paramAnonymousView.eug();
            localObject2 = paramAnonymousView.ets();
            p.g(localObject2, "panelRoot");
            ((TextColorSelector)localObject1).setRadiusNormalOuter(((View)localObject2).getResources().getDimension(2131165284));
            paramAnonymousView.eug().setRadiusSelectInner(paramAnonymousView.eug().getRadiusNormalOuter());
            localObject1 = paramAnonymousView.eug();
            localObject2 = paramAnonymousView.ets();
            p.g(localObject2, "panelRoot");
            ((TextColorSelector)localObject1).setRadiusSelectOuter(((View)localObject2).getResources().getDimension(2131165289));
            paramAnonymousView.eug().setColorList(com.tencent.mm.plugin.vlog.ui.widget.a.BUW);
            paramAnonymousView.eug().setSelected(2);
            paramAnonymousView.eug().setColorSelectedCallback((d.g.a.b)new a.c(paramAnonymousView));
            ((ImageView)paramAnonymousView.BUU.getValue()).setOnClickListener((View.OnClickListener)new a.d(paramAnonymousView));
            ((ImageView)paramAnonymousView.sDT.getValue()).setOnClickListener((View.OnClickListener)new a.e(paramAnonymousView));
          }
          this.BNF.sRz.setShow(true);
          paramAnonymousView = this.BNF.BND;
          localObject1 = paramAnonymousView.BUV;
          if (localObject1 != null) {
            ((a.a)localObject1).TD(paramAnonymousView.eug().getSelected());
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MultiEditPhotoPencilPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(196263);
          return;
          bool = false;
          break;
          label459:
          this.BNF.close();
        }
      }
    });
    this.BND.BUV = ((a.a)new a.a()
    {
      public final void NJ()
      {
        AppMethodBeat.i(196265);
        d.b.a(this.BNF.sQE, d.c.xFk);
        AppMethodBeat.o(196265);
      }
      
      public final void TD(int paramAnonymousInt)
      {
        AppMethodBeat.i(196264);
        Bundle localBundle = new Bundle();
        localBundle.putInt("EDIT_PHOTO_DOODLE_PENCIL_INDEX_INT", paramAnonymousInt);
        this.BNF.sQE.a(d.c.xFj, localBundle);
        AppMethodBeat.o(196264);
      }
      
      public final void onClose()
      {
        AppMethodBeat.i(196266);
        this.BNF.isSelected = false;
        this.BNF.close();
        AppMethodBeat.o(196266);
      }
    });
    AppMethodBeat.o(196271);
  }
  
  public final boolean aoB()
  {
    AppMethodBeat.i(196269);
    if (this.sRz.bni())
    {
      this.isSelected = false;
      close();
      AppMethodBeat.o(196269);
      return true;
    }
    AppMethodBeat.o(196269);
    return false;
  }
  
  public final void ayX() {}
  
  final void close()
  {
    AppMethodBeat.i(196270);
    this.sRz.setShow(false);
    d.b.a(this.sQE, d.c.xFg);
    ImageView localImageView1 = this.BNE;
    ImageView localImageView2 = this.BNE;
    p.g(localImageView2, "pencilBtn");
    localImageView1.setImageDrawable(ao.k(localImageView2.getContext(), 2131690394, -1));
    this.sRz.setShow(false);
    AppMethodBeat.o(196270);
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
    AppMethodBeat.i(196272);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(196272);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset()
  {
    AppMethodBeat.i(196268);
    this.isSelected = false;
    close();
    AppMethodBeat.o(196268);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(196267);
    ImageView localImageView = this.BNE;
    p.g(localImageView, "pencilBtn");
    localImageView.setVisibility(paramInt);
    AppMethodBeat.o(196267);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.o
 * JD-Core Version:    0.7.0.1
 */