package com.tencent.mm.plugin.recordvideo.plugin;

import a.f.b.j;
import a.l;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.story.h.a;
import com.tencent.mm.plugin.story.ui.view.editor.EditorInputView;
import com.tencent.mm.plugin.story.ui.view.editor.EditorInputView.a;
import com.tencent.mm.plugin.story.ui.view.editor.EditorInputView.b;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.am;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "addTextBtn", "Landroid/widget/ImageView;", "changeText", "", "inputPanel", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorInputView;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "editText", "", "text", "", "color", "", "bgColor", "initSafeArea", "name", "", "onBackPress", "onClick", "v", "Landroid/view/View;", "resetConfirmStyle", "bgStyleResId", "textColor", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "setVisibility", "visibility", "plugin-recordvideo_release"})
public final class b
  implements View.OnClickListener, q
{
  private ViewGroup eyt;
  d qbI;
  private final ImageView qbK;
  public final EditorInputView qbL;
  private boolean qbM;
  
  public b(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(150598);
    this.eyt = paramViewGroup;
    this.qbI = paramd;
    paramViewGroup = this.eyt.findViewById(2131828701);
    j.p(paramViewGroup, "parent.findViewById(R.id.editor_add_text)");
    this.qbK = ((ImageView)paramViewGroup);
    paramViewGroup = this.eyt.findViewById(2131823514);
    j.p(paramViewGroup, "parent.findViewById(R.id.change_text_root)");
    this.qbL = ((EditorInputView)paramViewGroup);
    this.qbK.setImageDrawable(aj.g(this.eyt.getContext(), 2131231477, -1));
    this.qbK.setOnClickListener((View.OnClickListener)this);
    this.qbL.setConfirmBtnColor(this.eyt.getResources().getColor(2131690701));
    this.qbL.setOnVisibleChangeCallback((a.f.a.b)new b.1(this));
    this.qbL.setCallback((EditorInputView.a)new b.2(this));
    paramViewGroup = am.hQ(this.eyt.getContext());
    int i = paramViewGroup.y;
    int j = paramViewGroup.x;
    float f1 = i / j;
    float f2 = i;
    paramViewGroup = a.sFV;
    f2 /= a.cEs();
    f2 = (j - f2) / 2.0F;
    paramViewGroup = a.sFV;
    if (f1 > a.cEr())
    {
      paramViewGroup = a.sFV;
      if (f1 >= a.cEs()) {}
    }
    else
    {
      this.qbL.bi(f2);
    }
    AppMethodBeat.o(150598);
  }
  
  public final boolean cgq()
  {
    AppMethodBeat.i(150597);
    if (this.qbL.getVisibility() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.qbL.setShow(false);
      AppMethodBeat.o(150597);
      return true;
    }
    AppMethodBeat.o(150597);
    return false;
  }
  
  public final void e(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150594);
    this.qbM = true;
    this.qbL.setShow(true);
    this.qbL.f(paramCharSequence, paramInt1, paramInt2);
    AppMethodBeat.o(150594);
  }
  
  public final String name()
  {
    return "plugin_text";
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(150595);
    this.qbL.setShow(true);
    paramView = this.qbL;
    CharSequence localCharSequence = (CharSequence)"";
    EditorInputView.b localb = EditorInputView.sPo;
    int i = EditorInputView.cFH();
    localb = EditorInputView.sPo;
    paramView.f(localCharSequence, i, EditorInputView.cFI());
    paramView = com.tencent.mm.plugin.recordvideo.c.b.qfu;
    com.tencent.mm.plugin.recordvideo.c.b.Ya("KEY_CLICK_TEXT_COUNT_INT");
    paramView = com.tencent.mm.plugin.recordvideo.c.b.qfu;
    com.tencent.mm.plugin.recordvideo.c.b.Cs(5);
    AppMethodBeat.o(150595);
  }
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(150596);
    this.qbK.setVisibility(paramInt);
    AppMethodBeat.o(150596);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.b
 * JD-Core Version:    0.7.0.1
 */