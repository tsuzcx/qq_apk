package com.tencent.mm.plugin.wenote.multitask;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/wenote/multitask/NoteMultiTaskPageAdapter;", "Lcom/tencent/mm/plugin/multitask/adapter/MultiTaskPageAdapter;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "canConvertToTranslucent", "", "Companion", "app_release"})
public final class b
  extends com.tencent.mm.plugin.multitask.a.b
{
  public static final a JJp;
  private Activity activity;
  
  static
  {
    AppMethodBeat.i(230923);
    JJp = new a((byte)0);
    AppMethodBeat.o(230923);
  }
  
  public b(Activity paramActivity)
  {
    super(paramActivity);
    this.activity = paramActivity;
  }
  
  public final boolean bCI()
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/wenote/multitask/NoteMultiTaskPageAdapter$Companion;", "", "()V", "TAG", "", "app_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.multitask.b
 * JD-Core Version:    0.7.0.1
 */