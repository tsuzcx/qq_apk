package com.tencent.mm.timelineedit;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.e;
import com.tencent.mm.videocomposition.i;

public class MediaInfoRetriever
{
  static int[] getImageInfo(String paramString)
  {
    AppMethodBeat.i(232035);
    new BitmapFactory.Options().inJustDecodeBounds = true;
    paramString = BitmapFactory.decodeFile(paramString);
    if (paramString != null)
    {
      int i = paramString.getWidth();
      int j = paramString.getHeight();
      AppMethodBeat.o(232035);
      return new int[] { i, j };
    }
    AppMethodBeat.o(232035);
    return new int[] { 0, 0 };
  }
  
  static int[] getVideoOrAudioInfo(String paramString)
  {
    AppMethodBeat.i(232033);
    paramString = e.agDJ.bEy(paramString);
    if (paramString != null)
    {
      int i = paramString.width;
      int j = paramString.height;
      int k = paramString.oTN;
      AppMethodBeat.o(232033);
      return new int[] { k, i, j };
    }
    AppMethodBeat.o(232033);
    return new int[] { 0, 0, 0 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.timelineedit.MediaInfoRetriever
 * JD-Core Version:    0.7.0.1
 */