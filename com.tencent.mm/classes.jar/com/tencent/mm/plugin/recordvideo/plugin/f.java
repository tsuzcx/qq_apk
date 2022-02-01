package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.jf;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/view/View;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/View;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "onAttach", "", "onClick", "v", "onDetach", "resetStyle", "bgResId", "", "textColor", "text", "height", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "plugin-recordvideo_release"})
public final class f
  implements View.OnClickListener, t
{
  private final String TAG;
  public View view;
  d wgr;
  
  public f(View paramView, d paramd)
  {
    AppMethodBeat.i(75489);
    this.view = paramView;
    this.wgr = paramd;
    this.TAG = "MicroMsg.EditFinishPlugin";
    this.view.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(75489);
  }
  
  public final void a(Integer paramInteger1, Integer paramInteger2, String paramString, Integer paramInteger3)
  {
    AppMethodBeat.i(75488);
    Log.i(this.TAG, paramString + ' ' + paramInteger3);
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
  
  public final void aSs()
  {
    AppMethodBeat.i(237281);
    this.view.setVisibility(0);
    AppMethodBeat.o(237281);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75487);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i(this.TAG, "on click edit finish");
    paramView = c.BXI;
    c.VH(12);
    paramView = c.BXI;
    c.eKX().ry(System.currentTimeMillis());
    if (!CaptureDataManager.BOb.a(this.view.getContext(), (CaptureDataManager.a)new a(this))) {
      d.b.a(this.wgr, d.c.BVw);
    }
    a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(75487);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(237282);
    this.view.setVisibility(4);
    AppMethodBeat.o(237282);
  }
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(237283);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(237283);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onRequestFinish"})
  static final class a
    implements CaptureDataManager.a
  {
    a(f paramf) {}
    
    public final void eJL()
    {
      AppMethodBeat.i(75486);
      d.b.a(this.BQe.wgr, d.c.BVw);
      AppMethodBeat.o(75486);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.f
 * JD-Core Version:    0.7.0.1
 */