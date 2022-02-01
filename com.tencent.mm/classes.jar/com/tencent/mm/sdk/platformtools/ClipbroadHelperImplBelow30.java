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
    AppMethodBeat.i(263134);
    paramContext = ((ClipboardManager)MMApplicationContext.getContext().getSystemService("clipboard")).getText();
    AppMethodBeat.o(263134);
    return paramContext;
  }
  
  public Uri getUri(Context paramContext)
  {
    return null;
  }
  
  public void setIntent(Context paramContext, CharSequence paramCharSequence, Intent paramIntent) {}
  
  public void setText(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(263132);
    ((ClipboardManager)MMApplicationContext.getContext().getSystemService("clipboard")).setText(paramCharSequence2);
    AppMethodBeat.o(263132);
  }
  
  public void setText(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2, String paramString)
  {
    AppMethodBeat.i(263133);
    setText(paramContext, paramCharSequence1, paramCharSequence2);
    AppMethodBeat.o(263133);
  }
  
  public void setUri(Context paramContext, CharSequence paramCharSequence, Uri paramUri) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ClipbroadHelperImplBelow30
 * JD-Core Version:    0.7.0.1
 */