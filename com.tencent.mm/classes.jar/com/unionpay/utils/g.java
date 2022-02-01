package com.unionpay.utils;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public final class g
{
  public static Drawable bIv(String paramString)
  {
    AppMethodBeat.i(207293);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(207293);
      return null;
    }
    try
    {
      paramString = new ByteArrayInputStream(a.a(paramString));
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(BitmapFactory.decodeStream(paramString));
      paramString.close();
      AppMethodBeat.o(207293);
      return localBitmapDrawable;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(207293);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.unionpay.utils.g
 * JD-Core Version:    0.7.0.1
 */