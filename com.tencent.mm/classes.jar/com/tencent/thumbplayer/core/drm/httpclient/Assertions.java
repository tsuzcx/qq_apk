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
    AppMethodBeat.i(193800);
    if (!paramBoolean)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException();
      AppMethodBeat.o(193800);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(193800);
  }
  
  public static void checkArgument(boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(193801);
    if (!paramBoolean)
    {
      paramObject = new IllegalArgumentException(String.valueOf(paramObject));
      AppMethodBeat.o(193801);
      throw paramObject;
    }
    AppMethodBeat.o(193801);
  }
  
  public static int checkIndex(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(193802);
    if ((paramInt1 < paramInt2) || (paramInt1 >= paramInt3))
    {
      IndexOutOfBoundsException localIndexOutOfBoundsException = new IndexOutOfBoundsException();
      AppMethodBeat.o(193802);
      throw localIndexOutOfBoundsException;
    }
    AppMethodBeat.o(193802);
    return paramInt1;
  }
  
  public static void checkMainThread()
  {
    AppMethodBeat.i(193809);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Not in applications main thread");
      AppMethodBeat.o(193809);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(193809);
  }
  
  public static String checkNotEmpty(String paramString)
  {
    AppMethodBeat.i(193807);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException();
      AppMethodBeat.o(193807);
      throw paramString;
    }
    AppMethodBeat.o(193807);
    return paramString;
  }
  
  public static String checkNotEmpty(String paramString, Object paramObject)
  {
    AppMethodBeat.i(193808);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException(String.valueOf(paramObject));
      AppMethodBeat.o(193808);
      throw paramString;
    }
    AppMethodBeat.o(193808);
    return paramString;
  }
  
  public static <T> T checkNotNull(T paramT)
  {
    AppMethodBeat.i(193805);
    if (paramT == null)
    {
      paramT = new NullPointerException();
      AppMethodBeat.o(193805);
      throw paramT;
    }
    AppMethodBeat.o(193805);
    return paramT;
  }
  
  public static <T> T checkNotNull(T paramT, Object paramObject)
  {
    AppMethodBeat.i(193806);
    if (paramT == null)
    {
      paramT = new NullPointerException(String.valueOf(paramObject));
      AppMethodBeat.o(193806);
      throw paramT;
    }
    AppMethodBeat.o(193806);
    return paramT;
  }
  
  public static void checkState(boolean paramBoolean)
  {
    AppMethodBeat.i(193803);
    if (!paramBoolean)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(193803);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(193803);
  }
  
  public static void checkState(boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(193804);
    if (!paramBoolean)
    {
      paramObject = new IllegalStateException(String.valueOf(paramObject));
      AppMethodBeat.o(193804);
      throw paramObject;
    }
    AppMethodBeat.o(193804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.httpclient.Assertions
 * JD-Core Version:    0.7.0.1
 */