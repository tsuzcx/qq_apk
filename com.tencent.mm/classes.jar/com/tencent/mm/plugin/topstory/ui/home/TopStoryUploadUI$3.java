package com.tencent.mm.plugin.topstory.ui.home;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class TopStoryUploadUI$3
  implements TextWatcher
{
  TopStoryUploadUI$3(TopStoryUploadUI paramTopStoryUploadUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(1682);
    TopStoryUploadUI.b(this.thy);
    TopStoryUploadUI.c(this.thy);
    AppMethodBeat.o(1682);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStoryUploadUI.3
 * JD-Core Version:    0.7.0.1
 */