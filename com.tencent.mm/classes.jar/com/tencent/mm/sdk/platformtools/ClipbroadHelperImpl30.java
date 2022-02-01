package com.tencent.mm.sdk.platformtools;

import android.annotation.TargetApi;
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
  @TargetApi(11)
  public Intent getIntent(Context paramContext)
  {
    AppMethodBeat.i(215357);
    paramContext = ((ClipboardManager)MMApplicationContext.getContext().getSystemService("clipboard")).getPrimaryClip();
    if ((paramContext == null) || (paramContext.getItemCount() <= 0))
    {
      AppMethodBeat.o(215357);
      return null;
    }
    paramContext = paramContext.getItemAt(0);
    if (paramContext == null)
    {
      AppMethodBeat.o(215357);
      return null;
    }
    paramContext = paramContext.getIntent();
    AppMethodBeat.o(215357);
    return paramContext;
  }
  
  @TargetApi(11)
  public CharSequence getText(Context paramContext)
  {
    AppMethodBeat.i(215355);
    paramContext = ((ClipboardManager)MMApplicationContext.getContext().getSystemService("clipboard")).getPrimaryClip();
    if ((paramContext == null) || (paramContext.getItemCount() <= 0))
    {
      AppMethodBeat.o(215355);
      return null;
    }
    paramContext = paramContext.getItemAt(0);
    if (paramContext == null)
    {
      AppMethodBeat.o(215355);
      return null;
    }
    paramContext = paramContext.getText();
    AppMethodBeat.o(215355);
    return paramContext;
  }
  
  @TargetApi(11)
  public Uri getUri(Context paramContext)
  {
    AppMethodBeat.i(215359);
    paramContext = ((ClipboardManager)MMApplicationContext.getContext().getSystemService("clipboard")).getPrimaryClip();
    if ((paramContext == null) || (paramContext.getItemCount() <= 0))
    {
      AppMethodBeat.o(215359);
      return null;
    }
    paramContext = paramContext.getItemAt(0);
    if (paramContext == null)
    {
      AppMethodBeat.o(215359);
      return null;
    }
    paramContext = paramContext.getUri();
    AppMethodBeat.o(215359);
    return paramContext;
  }
  
  @TargetApi(11)
  public void setIntent(Context paramContext, CharSequence paramCharSequence, Intent paramIntent)
  {
    AppMethodBeat.i(215356);
    ((ClipboardManager)MMApplicationContext.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newIntent(paramCharSequence, paramIntent));
    AppMethodBeat.o(215356);
  }
  
  @TargetApi(11)
  public void setText(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(215354);
    ((ClipboardManager)MMApplicationContext.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(paramCharSequence1, paramCharSequence2));
    AppMethodBeat.o(215354);
  }
  
  @TargetApi(11)
  public void setUri(Context paramContext, CharSequence paramCharSequence, Uri paramUri)
  {
    AppMethodBeat.i(215358);
    ((ClipboardManager)MMApplicationContext.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newRawUri(paramCharSequence, paramUri));
    AppMethodBeat.o(215358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ClipbroadHelperImpl30
 * JD-Core Version:    0.7.0.1
 */