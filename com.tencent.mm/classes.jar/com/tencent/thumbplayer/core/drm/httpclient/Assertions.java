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
    AppMethodBeat.i(220582);
    if (!paramBoolean)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException();
      AppMethodBeat.o(220582);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(220582);
  }
  
  public static void checkArgument(boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(220583);
    if (!paramBoolean)
    {
      paramObject = new IllegalArgumentException(String.valueOf(paramObject));
      AppMethodBeat.o(220583);
      throw paramObject;
    }
    AppMethodBeat.o(220583);
  }
  
  public static int checkIndex(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(220584);
    if ((paramInt1 < paramInt2) || (paramInt1 >= paramInt3))
    {
      IndexOutOfBoundsException localIndexOutOfBoundsException = new IndexOutOfBoundsException();
      AppMethodBeat.o(220584);
      throw localIndexOutOfBoundsException;
    }
    AppMethodBeat.o(220584);
    return paramInt1;
  }
  
  public static void checkMainThread()
  {
    AppMethodBeat.i(220591);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Not in applications main thread");
      AppMethodBeat.o(220591);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(220591);
  }
  
  public static String checkNotEmpty(String paramString)
  {
    AppMethodBeat.i(220589);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException();
      AppMethodBeat.o(220589);
      throw paramString;
    }
    AppMethodBeat.o(220589);
    return paramString;
  }
  
  public static String checkNotEmpty(String paramString, Object paramObject)
  {
    AppMethodBeat.i(220590);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException(String.valueOf(paramObject));
      AppMethodBeat.o(220590);
      throw paramString;
    }
    AppMethodBeat.o(220590);
    return paramString;
  }
  
  public static <T> T checkNotNull(T paramT)
  {
    AppMethodBeat.i(220587);
    if (paramT == null)
    {
      paramT = new NullPointerException();
      AppMethodBeat.o(220587);
      throw paramT;
    }
    AppMethodBeat.o(220587);
    return paramT;
  }
  
  public static <T> T checkNotNull(T paramT, Object paramObject)
  {
    AppMethodBeat.i(220588);
    if (paramT == null)
    {
      paramT = new NullPointerException(String.valueOf(paramObject));
      AppMethodBeat.o(220588);
      throw paramT;
    }
    AppMethodBeat.o(220588);
    return paramT;
  }
  
  public static void checkState(boolean paramBoolean)
  {
    AppMethodBeat.i(220585);
    if (!paramBoolean)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(220585);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(220585);
  }
  
  public static void checkState(boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(220586);
    if (!paramBoolean)
    {
      paramObject = new IllegalStateException(String.valueOf(paramObject));
      AppMethodBeat.o(220586);
      throw paramObject;
    }
    AppMethodBeat.o(220586);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.httpclient.Assertions
 * JD-Core Version:    0.7.0.1
 */