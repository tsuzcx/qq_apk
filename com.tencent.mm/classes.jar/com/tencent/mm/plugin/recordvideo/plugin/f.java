package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.dc;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/view/View;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/View;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "onAttach", "", "onClick", "v", "onDetach", "resetStyle", "bgResId", "", "textColor", "text", "height", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "plugin-recordvideo_release"})
public final class f
  implements View.OnClickListener, t
{
  private final String TAG;
  private View view;
  d vjo;
  
  public f(View paramView, d paramd)
  {
    AppMethodBeat.i(75489);
    this.view = paramView;
    this.vjo = paramd;
    this.TAG = "MicroMsg.EditFinishPlugin";
    this.view.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(75489);
  }
  
  public final void a(Integer paramInteger1, Integer paramInteger2, String paramString, Integer paramInteger3)
  {
    AppMethodBeat.i(75488);
    ad.i(this.TAG, paramString + ' ' + paramInteger3);
    View localView = this.view;
    if ((paramInteger1 != null) && (paramInteger1.intValue() != 0)) {
      localView.setBackgroundResource(paramInteger1.intValue());
    }
    if (paramInteger3 != null)
    {
      i = ((Number)paramInteger3).intValue();
      if (i > 0) {
        this.view.getLayoutParams().height = i;
      }
    }
    if ((paramInteger2 != null) && (paramInteger2.intValue() != 0) && ((localView instanceof TextView))) {
      ((TextView)localView).setTextColor(android.support.v4.content.b.n(((TextView)localView).getContext(), paramInteger2.intValue()));
    }
    paramInteger1 = (CharSequence)paramString;
    if ((paramInteger1 == null) || (paramInteger1.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && ((localView instanceof TextView))) {
        ((TextView)localView).setText((CharSequence)paramString);
      }
      AppMethodBeat.o(75488);
      return;
    }
  }
  
  public final void apt()
  {
    AppMethodBeat.i(204077);
    this.view.setVisibility(0);
    AppMethodBeat.o(204077);
  }
  
  public final boolean dia()
  {
    return false;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75487);
    ad.i(this.TAG, "on click edit finish");
    paramView = com.tencent.mm.plugin.recordvideo.d.b.vpp;
    com.tencent.mm.plugin.recordvideo.d.b.Ko(12);
    paramView = com.tencent.mm.plugin.recordvideo.d.b.vpp;
    com.tencent.mm.plugin.recordvideo.d.b.diy().fm(System.currentTimeMillis());
    if (!CaptureDataManager.vhw.a(this.view.getContext(), (CaptureDataManager.a)new a(this))) {
      d.b.a(this.vjo, d.c.vog);
    }
    AppMethodBeat.o(75487);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(204078);
    this.view.setVisibility(4);
    AppMethodBeat.o(204078);
  }
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onRequestFinish"})
  static final class a
    implements CaptureDataManager.a
  {
    a(f paramf) {}
    
    public final void dhE()
    {
      AppMethodBeat.i(75486);
      d.b.a(this.vjB.vjo, d.c.vog);
      AppMethodBeat.o(75486);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.f
 * JD-Core Version:    0.7.0.1
 */