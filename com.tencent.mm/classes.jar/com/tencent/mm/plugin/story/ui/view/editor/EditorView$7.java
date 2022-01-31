package com.tencent.mm.plugin.story.ui.view.editor;

import a.l;
import a.l.m;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.ui.view.editor.item.EditorItemContainer;
import com.tencent.mm.plugin.story.ui.view.editor.item.g;
import com.tencent.mm.plugin.story.ui.view.editor.item.h;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/ui/view/editor/EditorView$15", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorInputView$AddTextCallback;", "onCancel", "", "textType", "", "onConfirm", "text", "", "color", "bgColor", "plugin-story_release"})
public final class EditorView$7
  implements EditorInputView.a
{
  public final void Cp(int paramInt)
  {
    AppMethodBeat.i(151230);
    Object localObject = EditorInputView.sPo;
    if (paramInt == EditorInputView.cFJ())
    {
      localObject = EditorView.j(this.sQi);
      if (localObject != null) {
        ((g)localObject).setVisibility(0);
      }
      EditorView.a(this.sQi, null);
    }
    for (;;)
    {
      this.sQi.a(false, null, 0, 0, paramInt);
      AppMethodBeat.o(151230);
      return;
      localObject = EditorInputView.sPo;
      if (paramInt == EditorInputView.cFK())
      {
        localObject = EditorView.c(this.sQi).getTipItemView();
        if (localObject != null) {
          ((h)localObject).setVisibility(0);
        }
      }
    }
  }
  
  public final void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(151229);
    Object localObject = EditorInputView.sPo;
    if (paramInt3 == EditorInputView.cFJ()) {
      if (EditorView.j(this.sQi) != null)
      {
        localObject = EditorView.j(this.sQi);
        if (localObject != null) {
          ((g)localObject).setVisibility(0);
        }
        localObject = EditorView.j(this.sQi);
        if (localObject != null) {
          ((g)localObject).setText(paramCharSequence, paramInt1, paramInt2);
        }
        if (bo.aa(paramCharSequence))
        {
          paramCharSequence = EditorView.c(this.sQi);
          localObject = EditorView.j(this.sQi);
          if (localObject != null) {
            paramCharSequence.lzD.removeView((View)localObject);
          }
        }
        EditorView.a(this.sQi, null);
      }
    }
    do
    {
      for (;;)
      {
        this.sQi.a(false, null, 0, 0, paramInt3);
        AppMethodBeat.o(151229);
        return;
        if (!bo.aa(paramCharSequence)) {
          EditorView.c(this.sQi).h(paramCharSequence, paramInt1, paramInt2);
        }
      }
      localObject = EditorInputView.sPo;
    } while (paramInt3 != EditorInputView.cFK());
    if (!bo.aa(paramCharSequence))
    {
      if (paramCharSequence != null)
      {
        localObject = m.trim(paramCharSequence);
        label191:
        if (!bo.aa((CharSequence)localObject)) {
          break label236;
        }
      }
    }
    else
    {
      EditorView.c(this.sQi).cFP();
      EditorView.s(this.sQi).setVisibility(0);
    }
    for (;;)
    {
      EditorView.t(this.sQi);
      break;
      localObject = null;
      break label191;
      label236:
      EditorView.a(this.sQi, paramCharSequence);
      EditorView.a(this.sQi, paramInt1);
      EditorView.b(this.sQi, paramInt2);
      EditorView.s(this.sQi).setVisibility(8);
      if (EditorView.c(this.sQi).cFQ())
      {
        localObject = EditorView.c(this.sQi).getTipItemView();
        if (localObject != null) {
          ((h)localObject).b(paramCharSequence, paramInt1, paramInt2, EditorView.c(this.sQi).getLocationItemHeight());
        }
      }
      else if (!bo.aa(paramCharSequence))
      {
        EditorView.c(this.sQi).i(paramCharSequence, paramInt1, paramInt2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.EditorView.7
 * JD-Core Version:    0.7.0.1
 */