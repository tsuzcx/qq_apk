package com.tencent.mm.plugin.story.ui.view.editor;

import a.f.b.j;
import a.l;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bm;
import com.tencent.mm.plugin.story.model.audio.c;
import com.tencent.mm.plugin.story.model.audio.c.a;
import com.tencent.mm.plugin.story.ui.a.e;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "textView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "keyEvent", "Landroid/view/KeyEvent;", "onEditorAction"})
final class EditorAudioSearchView$h
  implements TextView.OnEditorActionListener
{
  EditorAudioSearchView$h(EditorAudioSearchView paramEditorAudioSearchView) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(110481);
    if (3 == paramInt)
    {
      if (EditorAudioSearchView.h(this.sOb) != null)
      {
        String str = EditorAudioSearchView.h(this.sOb);
        j.p(paramTextView, "textView");
        paramKeyEvent = paramTextView.getText();
        if (paramKeyEvent == null) {
          break label341;
        }
        paramKeyEvent = paramKeyEvent.toString();
        if (!bo.isEqual(str, paramKeyEvent))
        {
          EditorAudioSearchView.f(this.sOb);
          paramKeyEvent = c.swQ;
          c.cBD().dI(2L);
          paramKeyEvent = c.swQ;
          c.a.cBE();
          paramKeyEvent = c.swQ;
          c.cBD().dL(this.sOb.getMRelatedRecId());
        }
      }
      paramKeyEvent = this.sOb;
      j.p(paramTextView, "textView");
      paramTextView = paramTextView.getText();
      if (paramTextView == null) {
        break label346;
      }
    }
    label341:
    label346:
    for (paramTextView = paramTextView.toString();; paramTextView = null)
    {
      EditorAudioSearchView.a(paramKeyEvent, paramTextView);
      if (!bo.isNullOrNil(EditorAudioSearchView.h(this.sOb)))
      {
        paramTextView = EditorAudioSearchView.c(this.sOb);
        if (paramTextView != null) {
          paramTextView.setSelection(null);
        }
        paramTextView = EditorAudioSearchView.c(this.sOb);
        if (paramTextView != null) {
          paramTextView.setSelection(null);
        }
        paramTextView = EditorAudioSearchView.i(this.sOb);
        if (paramTextView != null) {
          paramTextView.bJ(0);
        }
        paramTextView = EditorAudioSearchView.c(this.sOb);
        if (paramTextView != null) {
          paramTextView.dF((List)new LinkedList());
        }
        paramTextView = EditorAudioSearchView.j(this.sOb);
        if (paramTextView != null) {
          paramTextView.setEnabled(false);
        }
        EditorAudioSearchView.a(this.sOb, 0L);
        EditorAudioSearchView.e(this.sOb);
        EditorAudioSearchView.a(this.sOb, 0);
        paramTextView = EditorAudioSearchView.c(this.sOb);
        if (paramTextView != null) {
          paramTextView.sIj = EditorAudioSearchView.h(this.sOb);
        }
        EditorAudioSearchView.m(this.sOb);
        EditorAudioSearchView.n(this.sOb);
        EditorAudioSearchView.o(this.sOb);
        EditorAudioSearchView.b(this.sOb, false);
        paramTextView = this.sOb.getCallback();
        if (paramTextView != null) {
          paramTextView.cFE();
        }
      }
      AppMethodBeat.o(110481);
      return false;
      paramKeyEvent = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.EditorAudioSearchView.h
 * JD-Core Version:    0.7.0.1
 */