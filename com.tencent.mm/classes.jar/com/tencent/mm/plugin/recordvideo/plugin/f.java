package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.support.v4.content.b;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.eq;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/view/View;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/View;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "onAttach", "", "onClick", "v", "onDetach", "resetStyle", "bgResId", "", "textColor", "text", "height", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "plugin-recordvideo_release"})
public final class f
  implements View.OnClickListener, t
{
  private final String TAG;
  d rTT;
  private View view;
  
  public f(View paramView, d paramd)
  {
    AppMethodBeat.i(75489);
    this.view = paramView;
    this.rTT = paramd;
    this.TAG = "MicroMsg.EditFinishPlugin";
    this.view.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(75489);
  }
  
  public final void a(Integer paramInteger1, Integer paramInteger2, String paramString, Integer paramInteger3)
  {
    AppMethodBeat.i(75488);
    ac.i(this.TAG, paramString + ' ' + paramInteger3);
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
      ((TextView)localView).setTextColor(b.n(((TextView)localView).getContext(), paramInteger2.intValue()));
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
  
  public final boolean alO()
  {
    return false;
  }
  
  public final void awk()
  {
    AppMethodBeat.i(199265);
    this.view.setVisibility(0);
    AppMethodBeat.o(199265);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75487);
    ac.i(this.TAG, "on click edit finish");
    paramView = c.wyg;
    c.Mn(12);
    paramView = c.wyg;
    c.dwr().iz(System.currentTimeMillis());
    if (!CaptureDataManager.wqi.a(this.view.getContext(), (CaptureDataManager.a)new a(this))) {
      d.b.a(this.rTT, d.c.wwN);
    }
    AppMethodBeat.o(75487);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(199266);
    this.view.setVisibility(4);
    AppMethodBeat.o(199266);
  }
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onRequestFinish"})
  static final class a
    implements CaptureDataManager.a
  {
    a(f paramf) {}
    
    public final void dvm()
    {
      AppMethodBeat.i(75486);
      d.b.a(this.wsm.rTT, d.c.wwN);
      AppMethodBeat.o(75486);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.f
 * JD-Core Version:    0.7.0.1
 */