package com.tencent.mm.sdk.platformtools;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;

class ClipbroadHelperImpl30
  implements ClipboardHelper.IClipboard
{
  public Intent getIntent(Context paramContext)
  {
    AppMethodBeat.i(243527);
    paramContext = ((ClipboardManager)MMApplicationContext.getContext().getSystemService("clipboard")).getPrimaryClip();
    if ((paramContext == null) || (paramContext.getItemCount() <= 0))
    {
      AppMethodBeat.o(243527);
      return null;
    }
    paramContext = paramContext.getItemAt(0);
    if (paramContext == null)
    {
      AppMethodBeat.o(243527);
      return null;
    }
    paramContext = paramContext.getIntent();
    AppMethodBeat.o(243527);
    return paramContext;
  }
  
  public CharSequence getText(Context paramContext)
  {
    AppMethodBeat.i(243519);
    paramContext = ((ClipboardManager)MMApplicationContext.getContext().getSystemService("clipboard")).getPrimaryClip();
    if ((paramContext == null) || (paramContext.getItemCount() <= 0))
    {
      AppMethodBeat.o(243519);
      return null;
    }
    paramContext = paramContext.getItemAt(0);
    if (paramContext == null)
    {
      AppMethodBeat.o(243519);
      return null;
    }
    paramContext = paramContext.getText();
    AppMethodBeat.o(243519);
    return paramContext;
  }
  
  public Uri getUri(Context paramContext)
  {
    AppMethodBeat.i(243539);
    paramContext = ((ClipboardManager)MMApplicationContext.getContext().getSystemService("clipboard")).getPrimaryClip();
    if ((paramContext == null) || (paramContext.getItemCount() <= 0))
    {
      AppMethodBeat.o(243539);
      return null;
    }
    paramContext = paramContext.getItemAt(0);
    if (paramContext == null)
    {
      AppMethodBeat.o(243539);
      return null;
    }
    paramContext = paramContext.getUri();
    AppMethodBeat.o(243539);
    return paramContext;
  }
  
  public void setIntent(Context paramContext, CharSequence paramCharSequence, Intent paramIntent)
  {
    AppMethodBeat.i(243522);
    ((ClipboardManager)MMApplicationContext.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newIntent(paramCharSequence, paramIntent));
    AppMethodBeat.o(243522);
  }
  
  public void setText(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(243513);
    setText(paramContext, paramCharSequence1, paramCharSequence2, null);
    AppMethodBeat.o(243513);
  }
  
  public void setText(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2, String paramString)
  {
    AppMethodBeat.i(243516);
    paramContext = (ClipboardManager)MMApplicationContext.getContext().getSystemService("clipboard");
    if (!Util.isNullOrNil(paramString))
    {
      paramContext.setPrimaryClip(ClipData.newHtmlText(paramCharSequence1, paramCharSequence2, paramString));
      AppMethodBeat.o(243516);
      return;
    }
    paramContext.setPrimaryClip(ClipData.newPlainText(paramCharSequence1, paramCharSequence2));
    AppMethodBeat.o(243516);
  }
  
  public void setUri(Context paramContext, CharSequence paramCharSequence, Uri paramUri)
  {
    AppMethodBeat.i(243533);
    ((ClipboardManager)MMApplicationContext.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newRawUri(paramCharSequence, paramUri));
    AppMethodBeat.o(243533);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ClipbroadHelperImpl30
 * JD-Core Version:    0.7.0.1
 */