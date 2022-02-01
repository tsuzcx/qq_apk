package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

class ClipbroadHelperImplBelow30
  implements ClipboardHelper.IClipboard
{
  public Intent getIntent(Context paramContext)
  {
    return null;
  }
  
  public CharSequence getText(Context paramContext)
  {
    AppMethodBeat.i(243480);
    paramContext = ((ClipboardManager)MMApplicationContext.getContext().getSystemService("clipboard")).getText();
    AppMethodBeat.o(243480);
    return paramContext;
  }
  
  public Uri getUri(Context paramContext)
  {
    return null;
  }
  
  public void setIntent(Context paramContext, CharSequence paramCharSequence, Intent paramIntent) {}
  
  public void setText(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(243472);
    ((ClipboardManager)MMApplicationContext.getContext().getSystemService("clipboard")).setText(paramCharSequence2);
    AppMethodBeat.o(243472);
  }
  
  public void setText(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2, String paramString)
  {
    AppMethodBeat.i(243478);
    setText(paramContext, paramCharSequence1, paramCharSequence2);
    AppMethodBeat.o(243478);
  }
  
  public void setUri(Context paramContext, CharSequence paramCharSequence, Uri paramUri) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ClipbroadHelperImplBelow30
 * JD-Core Version:    0.7.0.1
 */