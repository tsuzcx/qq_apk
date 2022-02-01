package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.b.c;
import com.tencent.mm.plugin.recordvideo.f.c;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/view/View;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/View;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "onAttach", "", "onClick", "v", "onDetach", "resetStyle", "bgResId", "", "textColor", "text", "height", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements View.OnClickListener, v
{
  private com.tencent.mm.plugin.recordvideo.plugin.parent.a GrC;
  private final String TAG;
  public View view;
  
  public h(View paramView, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    AppMethodBeat.i(75489);
    this.view = paramView;
    this.GrC = parama;
    this.TAG = "MicroMsg.EditFinishPlugin";
    this.view.setOnClickListener((View.OnClickListener)this);
    paramView = this.view;
    if ((paramView instanceof Button)) {}
    for (paramView = (Button)paramView;; paramView = null)
    {
      if (paramView != null) {
        paramView.setTextSize(0, com.tencent.mm.cd.a.bs(this.view.getContext(), b.c.NormalTextSize) * com.tencent.mm.cd.a.jO(this.view.getContext()));
      }
      AppMethodBeat.o(75489);
      return;
    }
  }
  
  private static final void a(h paramh)
  {
    AppMethodBeat.i(280795);
    s.u(paramh, "this$0");
    a.b.a(paramh.GrC, a.c.NOQ);
    AppMethodBeat.o(280795);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(280854);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(280854);
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
      ((TextView)localView).setTextColor(androidx.core.content.a.w(((TextView)localView).getContext(), paramInteger2.intValue()));
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
  
  public final void bwk()
  {
    AppMethodBeat.i(280840);
    s.u((v)this, "this");
    this.view.setVisibility(0);
    AppMethodBeat.o(280840);
  }
  
  public final String name()
  {
    AppMethodBeat.i(280856);
    String str = v.a.b(this);
    AppMethodBeat.o(280856);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(280862);
    s.u(this, "this");
    AppMethodBeat.o(280862);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(280865);
    s.u(this, "this");
    AppMethodBeat.o(280865);
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75487);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.i(this.TAG, "on click edit finish");
    paramView = c.NRf;
    c.agG(12);
    paramView = c.NRf;
    c.gJf().jjw = System.currentTimeMillis();
    if (!CaptureDataManager.NHH.a(this.view.getContext(), new h..ExternalSyntheticLambda0(this))) {
      a.b.a(this.GrC, a.c.NOQ);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(75487);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(280847);
    s.u((v)this, "this");
    this.view.setVisibility(4);
    AppMethodBeat.o(280847);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(280870);
    s.u(this, "this");
    AppMethodBeat.o(280870);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(280873);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(280873);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(280876);
    s.u(this, "this");
    AppMethodBeat.o(280876);
  }
  
  public final void release()
  {
    AppMethodBeat.i(280880);
    s.u(this, "this");
    AppMethodBeat.o(280880);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(280886);
    s.u(this, "this");
    AppMethodBeat.o(280886);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(280892);
    s.u(this, "this");
    AppMethodBeat.o(280892);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.h
 * JD-Core Version:    0.7.0.1
 */