package com.tencent.mm.plugin.topstory.ui.widget;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class TopStoryCommentFloatDialog$3
  implements TextWatcher
{
  TopStoryCommentFloatDialog$3(TopStoryCommentFloatDialog paramTopStoryCommentFloatDialog) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(2245);
    TopStoryCommentFloatDialog.a(this.tmJ);
    TopStoryCommentFloatDialog.b(this.tmJ);
    AppMethodBeat.o(2245);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog.3
 * JD-Core Version:    0.7.0.1
 */