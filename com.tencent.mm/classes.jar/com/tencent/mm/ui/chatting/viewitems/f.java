package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

public final class f
{
  static Drawable aq(Bitmap paramBitmap)
  {
    AppMethodBeat.i(32889);
    Object localObject = paramBitmap.getNinePatchChunk();
    if (NinePatch.isNinePatchChunk((byte[])localObject))
    {
      localObject = new NinePatchDrawable(ah.getResources(), paramBitmap, (byte[])localObject, new Rect(), null);
      ((NinePatchDrawable)localObject).setBounds(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      AppMethodBeat.o(32889);
      return localObject;
    }
    paramBitmap = new BitmapDrawable(paramBitmap);
    AppMethodBeat.o(32889);
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.f
 * JD-Core Version:    0.7.0.1
 */