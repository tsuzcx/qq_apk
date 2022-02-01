package com.tencent.mm.timelineedit;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.e;
import com.tencent.mm.videocomposition.i;

@Keep
public class MediaInfoRetriever
{
  static int[] getImageInfo(String paramString)
  {
    AppMethodBeat.i(259916);
    new BitmapFactory.Options().inJustDecodeBounds = true;
    paramString = BitmapFactory.decodeFile(paramString);
    if (paramString != null)
    {
      int i = paramString.getWidth();
      int j = paramString.getHeight();
      AppMethodBeat.o(259916);
      return new int[] { i, j };
    }
    AppMethodBeat.o(259916);
    return new int[] { 0, 0 };
  }
  
  static int[] getVideoOrAudioInfo(String paramString)
  {
    AppMethodBeat.i(259915);
    paramString = e.YIc.bCf(paramString);
    if (paramString != null)
    {
      int i = paramString.width;
      int j = paramString.height;
      int k = paramString.maT;
      AppMethodBeat.o(259915);
      return new int[] { k, i, j };
    }
    AppMethodBeat.o(259915);
    return new int[] { 0, 0, 0 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.timelineedit.MediaInfoRetriever
 * JD-Core Version:    0.7.0.1
 */