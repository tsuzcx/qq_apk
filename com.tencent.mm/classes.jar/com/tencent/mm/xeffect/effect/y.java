package com.tencent.mm.xeffect.effect;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/xeffect/effect/StickerDecoder;", "Lcom/tencent/mm/xeffect/effect/IStickerDecoder;", "path", "", "(Ljava/lang/String;)V", "bytes", "", "([B)V", "bitmap", "Landroid/graphics/Bitmap;", "height", "", "width", "destroy", "", "duration", "", "getFrame", "seekTo", "time", "size", "Landroid/util/Size;", "renderlib_release"})
public final class y
  implements IStickerDecoder
{
  private final Bitmap bitmap;
  private final int height;
  private final int width;
  
  public y(String paramString)
  {
    AppMethodBeat.i(237102);
    paramString = BitmapFactory.decodeFile(paramString);
    p.g(paramString, "BitmapFactory.decodeFile(path)");
    this.bitmap = paramString;
    this.width = this.bitmap.getWidth();
    this.height = this.bitmap.getHeight();
    AppMethodBeat.o(237102);
  }
  
  public y(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(237103);
    paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
    p.g(paramArrayOfByte, "BitmapFactory.decodeByte…ray(bytes, 0, bytes.size)");
    this.bitmap = paramArrayOfByte;
    this.width = this.bitmap.getWidth();
    this.height = this.bitmap.getHeight();
    AppMethodBeat.o(237103);
  }
  
  public final void destroy() {}
  
  public final long duration()
  {
    return 1073741824L;
  }
  
  public final Bitmap getFrame()
  {
    return this.bitmap;
  }
  
  public final void seekTo(long paramLong) {}
  
  public final Size size()
  {
    AppMethodBeat.i(237101);
    Size localSize = new Size(this.width, this.height);
    AppMethodBeat.o(237101);
    return localSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.y
 * JD-Core Version:    0.7.0.1
 */