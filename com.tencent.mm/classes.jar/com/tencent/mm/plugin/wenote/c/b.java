package com.tencent.mm.plugin.wenote.c;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wenote/multitask/NoteMultiTaskPageAdapter;", "Lcom/tencent/mm/plugin/multitask/adapter/MultiTaskPageAdapter;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "canConvertToTranslucent", "", "Companion", "app_release"})
public final class b
  extends com.tencent.mm.plugin.multitask.a.b
{
  public static final a QIH;
  private Activity activity;
  
  static
  {
    AppMethodBeat.i(246708);
    QIH = new a((byte)0);
    AppMethodBeat.o(246708);
  }
  
  public b(Activity paramActivity)
  {
    super(paramActivity);
    this.activity = paramActivity;
  }
  
  public final boolean bOd()
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wenote/multitask/NoteMultiTaskPageAdapter$Companion;", "", "()V", "TAG", "", "app_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.c.b
 * JD-Core Version:    0.7.0.1
 */