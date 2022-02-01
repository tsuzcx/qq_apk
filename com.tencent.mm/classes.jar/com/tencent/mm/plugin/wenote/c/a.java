package com.tencent.mm.plugin.wenote.c;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.plugin.multitask.b.c;
import com.tencent.mm.plugin.multitask.b.c.b;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.protocal.protobuf.dcy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wenote/multitask/NoteMultiTaskHelper;", "Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper;", "activity", "Lcom/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI;", "pageAdapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "(Lcom/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI;Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;)V", "getActivity", "()Lcom/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI;", "data", "", "isSupportMultiTaskFBMenu", "", "()Z", "isSupportSwipeToMultiTask", "title", "type", "", "beforeOnMenuEnterOrSwipebackToMultiTask", "", "onMenuFloatBallSelectCallback", "Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$OnMenuMultiTaskSelectCallback;", "fillMultiTaskInfo", "handleCurrentHistoryTaskInfoOnClose", "bitmap", "Landroid/graphics/Bitmap;", "ended", "isSupportSwipeToHome", "onClose", "way", "end", "onCreate", "multiTaskType", "multiTaskId", "onDataChanged", "jsonData", "onMenuMultiTaskSelected", "enterMultiTask", "Companion", "app_release"})
public final class a
  extends c
{
  private static final a.b QIF;
  public static final a.a QIG;
  private final NoteEditorUI QIE;
  public String data;
  public String title;
  public int type;
  
  static
  {
    AppMethodBeat.i(277882);
    QIG = new a.a((byte)0);
    QIF = new a.b();
    AppMethodBeat.o(277882);
  }
  
  public a(NoteEditorUI paramNoteEditorUI, com.tencent.mm.plugin.multitask.a.a parama)
  {
    super(parama);
    AppMethodBeat.i(277881);
    this.QIE = paramNoteEditorUI;
    this.data = "";
    this.title = "";
    Log.i("MicroMsg.NoteMultiTaskHelper", "create, NoteEditorUI:%s", new Object[] { Integer.valueOf(this.QIE.hashCode()) });
    AppMethodBeat.o(277881);
  }
  
  public final void I(int paramInt, String paramString)
  {
    AppMethodBeat.i(277876);
    super.I(paramInt, paramString);
    if (faT())
    {
      paramString = this.FGb;
      if (paramString != null)
      {
        paramString = paramString.getActivity();
        if (paramString != null)
        {
          paramString = paramString.getWindow();
          if (paramString != null)
          {
            paramString = paramString.getDecorView();
            if (paramString != null) {
              paramString.setBackgroundColor(0);
            }
          }
        }
      }
      paramString = this.FGb;
      if (paramString != null)
      {
        paramString = paramString.getActivity();
        if (paramString != null) {
          paramString.overridePendingTransition(R.a.fast_faded_in, 0);
        }
      }
      paramString = this.FGb;
      if (paramString == null) {
        break label116;
      }
    }
    label116:
    for (paramString = paramString.getActivity();; paramString = null)
    {
      b.a(paramString, null);
      AppMethodBeat.o(277876);
      return;
    }
  }
  
  public final void a(c.b paramb)
  {
    AppMethodBeat.i(277880);
    if (faT())
    {
      NoteEditorUI localNoteEditorUI = this.QIE;
      if (localNoteEditorUI != null) {
        localNoteEditorUI.hideVKB();
      }
    }
    super.a(paramb);
    AppMethodBeat.o(277880);
  }
  
  public final void bnW(String paramString)
  {
    AppMethodBeat.i(277874);
    p.k(paramString, "title");
    this.title = paramString;
    cbL();
    super.iW(true);
    AppMethodBeat.o(277874);
  }
  
  public final boolean cbG()
  {
    return true;
  }
  
  public final boolean cbH()
  {
    return true;
  }
  
  public final void cbL()
  {
    AppMethodBeat.i(277879);
    if (this.type == 0)
    {
      AppMethodBeat.o(277879);
      return;
    }
    try
    {
      dcy localdcy = new dcy();
      localdcy.fKG = this.type;
      localdcy.TKK = this.data;
      Object localObject = this.FHd;
      if (localObject != null)
      {
        localObject = ((MultiTaskInfo)localObject).fbc();
        if (localObject != null) {
          ((dar)localObject).title = this.title;
        }
      }
      localObject = this.FHd;
      if (localObject != null)
      {
        ((MultiTaskInfo)localObject).field_data = localdcy.toByteArray();
        AppMethodBeat.o(277879);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.NoteMultiTaskHelper", "onMenuMultiTaskSelected error, ex = " + localException.getMessage());
      AppMethodBeat.o(277879);
      return;
    }
    AppMethodBeat.o(277879);
  }
  
  public final void d(Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(277878);
    if (paramBoolean)
    {
      Log.i("MicroMsg.NoteMultiTaskHelper", "ended, remove historyTaskInfo");
      faW();
      AppMethodBeat.o(277878);
      return;
    }
    Log.i("MicroMsg.NoteMultiTaskHelper", "not ended update historyTaskInfo");
    ag(paramBitmap);
    AppMethodBeat.o(277878);
  }
  
  public final boolean dJN()
  {
    return true;
  }
  
  public final boolean m(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(277877);
    p.k(paramString, "title");
    NoteEditorUI localNoteEditorUI = this.QIE;
    if (localNoteEditorUI != null) {
      localNoteEditorUI.hideVKB();
    }
    this.title = paramString;
    cbL();
    paramBoolean = super.Q(paramInt, paramBoolean);
    AppMethodBeat.o(277877);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.c.a
 * JD-Core Version:    0.7.0.1
 */