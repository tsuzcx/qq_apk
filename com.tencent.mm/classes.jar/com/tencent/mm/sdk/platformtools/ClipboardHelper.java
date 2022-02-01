package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ClipboardHelper
{
  public static final int ANDROID_API_LEVEL_11 = 11;
  public static final int ANDROID_API_LEVEL_8 = 8;
  private static int lastCopyTxtHash;
  
  public static Intent getIntent(Context paramContext)
  {
    AppMethodBeat.i(215351);
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramContext = new ClipbroadHelperImpl30().getIntent(paramContext);
      AppMethodBeat.o(215351);
      return paramContext;
    }
    paramContext = new ClipbroadHelperImplBelow30().getIntent(paramContext);
    AppMethodBeat.o(215351);
    return paramContext;
  }
  
  public static CharSequence getText()
  {
    AppMethodBeat.i(215348);
    CharSequence localCharSequence = getText(MMApplicationContext.getContext());
    AppMethodBeat.o(215348);
    return localCharSequence;
  }
  
  public static CharSequence getText(Context paramContext)
  {
    AppMethodBeat.i(215349);
    if (Build.VERSION.SDK_INT >= 11) {}
    for (paramContext = new ClipbroadHelperImpl30().getText(paramContext); paramContext == null; paramContext = new ClipbroadHelperImplBelow30().getText(paramContext))
    {
      Log.i("ClipboardHelper", "getText null");
      AppMethodBeat.o(215349);
      return "";
    }
    AppMethodBeat.o(215349);
    return paramContext;
  }
  
  public static Uri getUri(Context paramContext)
  {
    AppMethodBeat.i(215353);
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramContext = new ClipbroadHelperImpl30().getUri(paramContext);
      AppMethodBeat.o(215353);
      return paramContext;
    }
    paramContext = new ClipbroadHelperImplBelow30().getUri(paramContext);
    AppMethodBeat.o(215353);
    return paramContext;
  }
  
  public static boolean isCopyFromWX(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(215347);
    if ((Util.isNullOrNil(paramCharSequence)) || (lastCopyTxtHash == 0))
    {
      AppMethodBeat.o(215347);
      return false;
    }
    if (paramCharSequence.toString().hashCode() == lastCopyTxtHash)
    {
      AppMethodBeat.o(215347);
      return true;
    }
    AppMethodBeat.o(215347);
    return false;
  }
  
  public static void setIntent(Context paramContext, CharSequence paramCharSequence, Intent paramIntent)
  {
    AppMethodBeat.i(215350);
    if (Build.VERSION.SDK_INT >= 11)
    {
      new ClipbroadHelperImpl30().setIntent(paramContext, paramCharSequence, paramIntent);
      AppMethodBeat.o(215350);
      return;
    }
    new ClipbroadHelperImplBelow30().setIntent(paramContext, paramCharSequence, paramIntent);
    AppMethodBeat.o(215350);
  }
  
  public static void setText(Context paramContext, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(215345);
    setText(paramContext, null, paramCharSequence);
    AppMethodBeat.o(215345);
  }
  
  public static void setText(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(215346);
    if (Build.VERSION.SDK_INT >= 11) {
      new ClipbroadHelperImpl30().setText(paramContext, paramCharSequence1, paramCharSequence2);
    }
    for (;;)
    {
      if (paramCharSequence2 != null) {
        lastCopyTxtHash = paramCharSequence2.toString().hashCode();
      }
      AppMethodBeat.o(215346);
      return;
      new ClipbroadHelperImplBelow30().setText(paramContext, paramCharSequence1, paramCharSequence2);
    }
  }
  
  public static void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(215344);
    setText(MMApplicationContext.getContext(), null, paramCharSequence);
    AppMethodBeat.o(215344);
  }
  
  public static void setUri(Context paramContext, CharSequence paramCharSequence, Uri paramUri)
  {
    AppMethodBeat.i(215352);
    if (Build.VERSION.SDK_INT >= 11)
    {
      new ClipbroadHelperImpl30().setUri(paramContext, paramCharSequence, paramUri);
      AppMethodBeat.o(215352);
      return;
    }
    new ClipbroadHelperImplBelow30().setUri(paramContext, paramCharSequence, paramUri);
    AppMethodBeat.o(215352);
  }
  
  static abstract interface IClipboard
  {
    public abstract Intent getIntent(Context paramContext);
    
    public abstract CharSequence getText(Context paramContext);
    
    public abstract Uri getUri(Context paramContext);
    
    public abstract void setIntent(Context paramContext, CharSequence paramCharSequence, Intent paramIntent);
    
    public abstract void setText(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2);
    
    public abstract void setUri(Context paramContext, CharSequence paramCharSequence, Uri paramUri);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ClipboardHelper
 * JD-Core Version:    0.7.0.1
 */