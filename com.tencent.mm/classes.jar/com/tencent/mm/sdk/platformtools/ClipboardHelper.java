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
  private static final String TAG = "MicroMsg.ClipboardHelper";
  private static int lastCopyTxtHash;
  
  public static Intent getIntent(Context paramContext)
  {
    AppMethodBeat.i(243828);
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramContext = new ClipbroadHelperImpl30().getIntent(paramContext);
      AppMethodBeat.o(243828);
      return paramContext;
    }
    paramContext = new ClipbroadHelperImplBelow30().getIntent(paramContext);
    AppMethodBeat.o(243828);
    return paramContext;
  }
  
  public static CharSequence getText()
  {
    AppMethodBeat.i(243814);
    CharSequence localCharSequence = getText(MMApplicationContext.getContext());
    AppMethodBeat.o(243814);
    return localCharSequence;
  }
  
  public static CharSequence getText(Context paramContext)
  {
    AppMethodBeat.i(243819);
    if (Build.VERSION.SDK_INT >= 11) {}
    for (paramContext = new ClipbroadHelperImpl30().getText(paramContext); paramContext == null; paramContext = new ClipbroadHelperImplBelow30().getText(paramContext))
    {
      Log.i("ClipboardHelper", "getText null");
      AppMethodBeat.o(243819);
      return "";
    }
    AppMethodBeat.o(243819);
    return paramContext;
  }
  
  public static Uri getUri(Context paramContext)
  {
    AppMethodBeat.i(243837);
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramContext = new ClipbroadHelperImpl30().getUri(paramContext);
      AppMethodBeat.o(243837);
      return paramContext;
    }
    paramContext = new ClipbroadHelperImplBelow30().getUri(paramContext);
    AppMethodBeat.o(243837);
    return paramContext;
  }
  
  public static boolean isCopyFromWX(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(243809);
    if ((Util.isNullOrNil(paramCharSequence)) || (lastCopyTxtHash == 0))
    {
      AppMethodBeat.o(243809);
      return false;
    }
    if (paramCharSequence.toString().hashCode() == lastCopyTxtHash)
    {
      AppMethodBeat.o(243809);
      return true;
    }
    AppMethodBeat.o(243809);
    return false;
  }
  
  public static void setIntent(Context paramContext, CharSequence paramCharSequence, Intent paramIntent)
  {
    AppMethodBeat.i(243824);
    if (Build.VERSION.SDK_INT >= 11)
    {
      new ClipbroadHelperImpl30().setIntent(paramContext, paramCharSequence, paramIntent);
      AppMethodBeat.o(243824);
      return;
    }
    new ClipbroadHelperImplBelow30().setIntent(paramContext, paramCharSequence, paramIntent);
    AppMethodBeat.o(243824);
  }
  
  public static void setText(Context paramContext, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(243799);
    setText(paramContext, null, paramCharSequence);
    AppMethodBeat.o(243799);
  }
  
  public static void setText(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(243804);
    setText(paramContext, paramCharSequence1, paramCharSequence2, null);
    AppMethodBeat.o(243804);
  }
  
  public static void setText(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2, String paramString)
  {
    AppMethodBeat.i(243806);
    if (Build.VERSION.SDK_INT >= 11) {
      new ClipbroadHelperImpl30().setText(paramContext, paramCharSequence1, paramCharSequence2, paramString);
    }
    for (;;)
    {
      if (paramCharSequence2 != null) {
        lastCopyTxtHash = paramCharSequence2.toString().hashCode();
      }
      AppMethodBeat.o(243806);
      return;
      new ClipbroadHelperImplBelow30().setText(paramContext, paramCharSequence1, paramCharSequence2);
    }
  }
  
  public static void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(243785);
    setText(MMApplicationContext.getContext(), null, paramCharSequence);
    AppMethodBeat.o(243785);
  }
  
  public static boolean setTextSwallowException(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(243791);
    try
    {
      setText(MMApplicationContext.getContext(), null, paramCharSequence);
      AppMethodBeat.o(243791);
      return true;
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.ClipboardHelper", paramCharSequence, "", new Object[0]);
      AppMethodBeat.o(243791);
    }
    return false;
  }
  
  public static void setUri(Context paramContext, CharSequence paramCharSequence, Uri paramUri)
  {
    AppMethodBeat.i(243833);
    if (Build.VERSION.SDK_INT >= 11)
    {
      new ClipbroadHelperImpl30().setUri(paramContext, paramCharSequence, paramUri);
      AppMethodBeat.o(243833);
      return;
    }
    new ClipbroadHelperImplBelow30().setUri(paramContext, paramCharSequence, paramUri);
    AppMethodBeat.o(243833);
  }
  
  static abstract interface IClipboard
  {
    public abstract Intent getIntent(Context paramContext);
    
    public abstract CharSequence getText(Context paramContext);
    
    public abstract Uri getUri(Context paramContext);
    
    public abstract void setIntent(Context paramContext, CharSequence paramCharSequence, Intent paramIntent);
    
    public abstract void setText(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2);
    
    public abstract void setText(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2, String paramString);
    
    public abstract void setUri(Context paramContext, CharSequence paramCharSequence, Uri paramUri);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ClipboardHelper
 * JD-Core Version:    0.7.0.1
 */