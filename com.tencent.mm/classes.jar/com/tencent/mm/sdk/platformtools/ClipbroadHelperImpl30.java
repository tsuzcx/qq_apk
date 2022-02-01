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
    AppMethodBeat.i(263146);
    paramContext = ((ClipboardManager)MMApplicationContext.getContext().getSystemService("clipboard")).getPrimaryClip();
    if ((paramContext == null) || (paramContext.getItemCount() <= 0))
    {
      AppMethodBeat.o(263146);
      return null;
    }
    paramContext = paramContext.getItemAt(0);
    if (paramContext == null)
    {
      AppMethodBeat.o(263146);
      return null;
    }
    paramContext = paramContext.getIntent();
    AppMethodBeat.o(263146);
    return paramContext;
  }
  
  @TargetApi(11)
  public CharSequence getText(Context paramContext)
  {
    AppMethodBeat.i(263144);
    paramContext = ((ClipboardManager)MMApplicationContext.getContext().getSystemService("clipboard")).getPrimaryClip();
    if ((paramContext == null) || (paramContext.getItemCount() <= 0))
    {
      AppMethodBeat.o(263144);
      return null;
    }
    paramContext = paramContext.getItemAt(0);
    if (paramContext == null)
    {
      AppMethodBeat.o(263144);
      return null;
    }
    paramContext = paramContext.getText();
    AppMethodBeat.o(263144);
    return paramContext;
  }
  
  @TargetApi(11)
  public Uri getUri(Context paramContext)
  {
    AppMethodBeat.i(263148);
    paramContext = ((ClipboardManager)MMApplicationContext.getContext().getSystemService("clipboard")).getPrimaryClip();
    if ((paramContext == null) || (paramContext.getItemCount() <= 0))
    {
      AppMethodBeat.o(263148);
      return null;
    }
    paramContext = paramContext.getItemAt(0);
    if (paramContext == null)
    {
      AppMethodBeat.o(263148);
      return null;
    }
    paramContext = paramContext.getUri();
    AppMethodBeat.o(263148);
    return paramContext;
  }
  
  @TargetApi(11)
  public void setIntent(Context paramContext, CharSequence paramCharSequence, Intent paramIntent)
  {
    AppMethodBeat.i(263145);
    ((ClipboardManager)MMApplicationContext.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newIntent(paramCharSequence, paramIntent));
    AppMethodBeat.o(263145);
  }
  
  @TargetApi(11)
  public void setText(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(263140);
    setText(paramContext, paramCharSequence1, paramCharSequence2, null);
    AppMethodBeat.o(263140);
  }
  
  @TargetApi(11)
  public void setText(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2, String paramString)
  {
    AppMethodBeat.i(263142);
    paramContext = (ClipboardManager)MMApplicationContext.getContext().getSystemService("clipboard");
    if (!Util.isNullOrNil(paramString))
    {
      paramContext.setPrimaryClip(ClipData.newHtmlText(paramCharSequence1, paramCharSequence2, paramString));
      AppMethodBeat.o(263142);
      return;
    }
    paramContext.setPrimaryClip(ClipData.newPlainText(paramCharSequence1, paramCharSequence2));
    AppMethodBeat.o(263142);
  }
  
  @TargetApi(11)
  public void setUri(Context paramContext, CharSequence paramCharSequence, Uri paramUri)
  {
    AppMethodBeat.i(263147);
    ((ClipboardManager)MMApplicationContext.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newRawUri(paramCharSequence, paramUri));
    AppMethodBeat.o(263147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ClipbroadHelperImpl30
 * JD-Core Version:    0.7.0.1
 */