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
    AppMethodBeat.i(228263);
    if (!paramBoolean)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException();
      AppMethodBeat.o(228263);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(228263);
  }
  
  public static void checkArgument(boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(228268);
    if (!paramBoolean)
    {
      paramObject = new IllegalArgumentException(String.valueOf(paramObject));
      AppMethodBeat.o(228268);
      throw paramObject;
    }
    AppMethodBeat.o(228268);
  }
  
  public static int checkIndex(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(228273);
    if ((paramInt1 < paramInt2) || (paramInt1 >= paramInt3))
    {
      IndexOutOfBoundsException localIndexOutOfBoundsException = new IndexOutOfBoundsException();
      AppMethodBeat.o(228273);
      throw localIndexOutOfBoundsException;
    }
    AppMethodBeat.o(228273);
    return paramInt1;
  }
  
  public static void checkMainThread()
  {
    AppMethodBeat.i(228313);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Not in applications main thread");
      AppMethodBeat.o(228313);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(228313);
  }
  
  public static String checkNotEmpty(String paramString)
  {
    AppMethodBeat.i(228300);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException();
      AppMethodBeat.o(228300);
      throw paramString;
    }
    AppMethodBeat.o(228300);
    return paramString;
  }
  
  public static String checkNotEmpty(String paramString, Object paramObject)
  {
    AppMethodBeat.i(228307);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException(String.valueOf(paramObject));
      AppMethodBeat.o(228307);
      throw paramString;
    }
    AppMethodBeat.o(228307);
    return paramString;
  }
  
  public static <T> T checkNotNull(T paramT)
  {
    AppMethodBeat.i(228288);
    if (paramT == null)
    {
      paramT = new NullPointerException();
      AppMethodBeat.o(228288);
      throw paramT;
    }
    AppMethodBeat.o(228288);
    return paramT;
  }
  
  public static <T> T checkNotNull(T paramT, Object paramObject)
  {
    AppMethodBeat.i(228295);
    if (paramT == null)
    {
      paramT = new NullPointerException(String.valueOf(paramObject));
      AppMethodBeat.o(228295);
      throw paramT;
    }
    AppMethodBeat.o(228295);
    return paramT;
  }
  
  public static void checkState(boolean paramBoolean)
  {
    AppMethodBeat.i(228279);
    if (!paramBoolean)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(228279);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(228279);
  }
  
  public static void checkState(boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(228283);
    if (!paramBoolean)
    {
      paramObject = new IllegalStateException(String.valueOf(paramObject));
      AppMethodBeat.o(228283);
      throw paramObject;
    }
    AppMethodBeat.o(228283);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.httpclient.Assertions
 * JD-Core Version:    0.7.0.1
 */