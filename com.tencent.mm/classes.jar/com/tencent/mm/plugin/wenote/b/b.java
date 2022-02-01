package com.tencent.mm.plugin.wenote.b;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wenote/multitask/NoteMultiTaskPageAdapter;", "Lcom/tencent/mm/plugin/multitask/adapter/MultiTaskPageAdapter;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "canConvertToTranslucent", "", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.multitask.a.b
{
  public static final b.a XCg;
  private Activity activity;
  
  static
  {
    AppMethodBeat.i(275080);
    XCg = new b.a((byte)0);
    AppMethodBeat.o(275080);
  }
  
  public b(Activity paramActivity)
  {
    super(paramActivity);
    this.activity = paramActivity;
  }
  
  public final boolean cor()
  {
    return true;
  }
  
  public final Activity getActivity()
  {
    return this.activity;
  }
  
  public final void setActivity(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.b.b
 * JD-Core Version:    0.7.0.1
 */