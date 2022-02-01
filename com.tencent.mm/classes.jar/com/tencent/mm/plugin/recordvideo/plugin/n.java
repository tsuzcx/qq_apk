package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.b.b;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.doodle.PhotoDoodlePlugin;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoPencilPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "viewGroup", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "editPhotoDoodlePlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin;", "isSelected", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "view", "Landroid/widget/ImageView;", "getViewGroup", "()Landroid/view/ViewGroup;", "setViewGroup", "(Landroid/view/ViewGroup;)V", "checkDoodleStatus", "", "hideDooldeLayout", "hideMosaic", "hide", "onBackPress", "onClick", "v", "Landroid/view/View;", "reset", "setVisibility", "visibility", "", "plugin-recordvideo_release"})
public final class n
  implements View.OnClickListener, u
{
  private d APl;
  private ViewGroup Fwk;
  public final PhotoDoodlePlugin HNB;
  private boolean isSelected;
  private final ImageView wRg;
  
  public n(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(75562);
    this.Fwk = paramViewGroup;
    this.APl = paramd;
    paramViewGroup = this.Fwk.findViewById(b.e.doddle_layout);
    p.j(paramViewGroup, "viewGroup.findViewById(R.id.doddle_layout)");
    this.HNB = ((PhotoDoodlePlugin)paramViewGroup);
    this.HNB.setStatus(this.APl);
    paramViewGroup = this.Fwk.findViewById(b.e.editor_add_pencil);
    p.j(paramViewGroup, "viewGroup.findViewById(R.id.editor_add_pencil)");
    this.wRg = ((ImageView)paramViewGroup);
    this.wRg.setImageDrawable(au.o(this.wRg.getContext(), b.g.icons_filled_duddle, -1));
    this.wRg.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(75562);
  }
  
  public final void bbp() {}
  
  public final void eYp()
  {
    AppMethodBeat.i(75561);
    if (this.isSelected)
    {
      this.HNB.setVisibility(0);
      AppMethodBeat.o(75561);
      return;
    }
    this.HNB.setVisibility(4);
    AppMethodBeat.o(75561);
  }
  
  public final String name()
  {
    AppMethodBeat.i(218389);
    String str = getClass().getName();
    AppMethodBeat.o(218389);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75559);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/recordvideo/plugin/EditPhotoPencilPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    boolean bool;
    if (!this.isSelected)
    {
      bool = true;
      this.isSelected = bool;
      if (!this.isSelected) {
        break label143;
      }
      paramView = c.HUw;
      c.aVY("KEY_CLICK_DOODLE_COUNT_INT");
      paramView = c.HUw;
      c.acq(7);
      this.wRg.setImageDrawable(au.o(this.wRg.getContext(), b.g.icons_filled_duddle, this.wRg.getResources().getColor(b.b.wechat_green)));
      d.b.a(this.APl, d.c.HSs);
    }
    for (;;)
    {
      eYp();
      a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditPhotoPencilPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(75559);
      return;
      bool = false;
      break;
      label143:
      d.b.a(this.APl, d.c.HSw);
      this.wRg.setImageDrawable(au.o(this.wRg.getContext(), b.g.icons_filled_duddle, -1));
    }
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(218390);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    u.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(218390);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset()
  {
    AppMethodBeat.i(75560);
    this.isSelected = false;
    eYp();
    d.b.a(this.APl, d.c.HSw);
    this.wRg.setImageDrawable(au.o(this.wRg.getContext(), b.g.icons_filled_duddle, -1));
    AppMethodBeat.o(75560);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(218385);
    this.wRg.setVisibility(paramInt);
    AppMethodBeat.o(218385);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.n
 * JD-Core Version:    0.7.0.1
 */