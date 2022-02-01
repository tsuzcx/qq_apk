package com.tencent.thumbplayer.core.drm.httpclient;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Assertions
{
  private static final boolean ASSERTIONS_ENABLED = true;
  
  public static <T> T castNonNull(T paramT)
  {
    return paramT;
  }
  
  public static void checkArgument(boolean paramBoolean)
  {
    AppMethodBeat.i(197521);
    if (!paramBoolean)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException();
      AppMethodBeat.o(197521);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(197521);
  }
  
  public static void checkArgument(boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(197522);
    if (!paramBoolean)
    {
      paramObject = new IllegalArgumentException(String.valueOf(paramObject));
      AppMethodBeat.o(197522);
      throw paramObject;
    }
    AppMethodBeat.o(197522);
  }
  
  public static int checkIndex(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(197523);
    if ((paramInt1 < paramInt2) || (paramInt1 >= paramInt3))
    {
      IndexOutOfBoundsException localIndexOutOfBoundsException = new IndexOutOfBoundsException();
      AppMethodBeat.o(197523);
      throw localIndexOutOfBoundsException;
    }
    AppMethodBeat.o(197523);
    return paramInt1;
  }
  
  public static void checkMainThread()
  {
    AppMethodBeat.i(197530);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Not in applications main thread");
      AppMethodBeat.o(197530);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(197530);
  }
  
  public static String checkNotEmpty(String paramString)
  {
    AppMethodBeat.i(197528);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException();
      AppMethodBeat.o(197528);
      throw paramString;
    }
    AppMethodBeat.o(197528);
    return paramString;
  }
  
  public static String checkNotEmpty(String paramString, Object paramObject)
  {
    AppMethodBeat.i(197529);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException(String.valueOf(paramObject));
      AppMethodBeat.o(197529);
      throw paramString;
    }
    AppMethodBeat.o(197529);
    return paramString;
  }
  
  public static <T> T checkNotNull(T paramT)
  {
    AppMethodBeat.i(197526);
    if (paramT == null)
    {
      paramT = new NullPointerException();
      AppMethodBeat.o(197526);
      throw paramT;
    }
    AppMethodBeat.o(197526);
    return paramT;
  }
  
  public static <T> T checkNotNull(T paramT, Object paramObject)
  {
    AppMethodBeat.i(197527);
    if (paramT == null)
    {
      paramT = new NullPointerException(String.valueOf(paramObject));
      AppMethodBeat.o(197527);
      throw paramT;
    }
    AppMethodBeat.o(197527);
    return paramT;
  }
  
  public static void checkState(boolean paramBoolean)
  {
    AppMethodBeat.i(197524);
    if (!paramBoolean)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(197524);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(197524);
  }
  
  public static void checkState(boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(197525);
    if (!paramBoolean)
    {
      paramObject = new IllegalStateException(String.valueOf(paramObject));
      AppMethodBeat.o(197525);
      throw paramObject;
    }
    AppMethodBeat.o(197525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.httpclient.Assertions
 * JD-Core Version:    0.7.0.1
 */