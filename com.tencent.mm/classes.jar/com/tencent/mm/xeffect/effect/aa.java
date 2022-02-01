package com.tencent.mm.xeffect.effect;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/xeffect/effect/StickerDecoder;", "Lcom/tencent/mm/xeffect/effect/IStickerDecoder;", "path", "", "(Ljava/lang/String;)V", "bytes", "", "([B)V", "bitmap", "Landroid/graphics/Bitmap;", "height", "", "width", "destroy", "", "duration", "", "getFrame", "seekTo", "time", "size", "Landroid/util/Size;", "renderlib_release"}, k=1, mv={1, 1, 15})
public final class aa
  implements IStickerDecoder
{
  private final Bitmap bitmap;
  private final int height;
  private final int width;
  
  public aa(String paramString)
  {
    AppMethodBeat.i(234588);
    paramString = BitmapFactory.decodeFile(paramString);
    s.r(paramString, "BitmapFactory.decodeFile(path)");
    this.bitmap = paramString;
    this.width = this.bitmap.getWidth();
    this.height = this.bitmap.getHeight();
    AppMethodBeat.o(234588);
  }
  
  public aa(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(234592);
    paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
    s.r(paramArrayOfByte, "BitmapFactory.decodeByte…ray(bytes, 0, bytes.size)");
    this.bitmap = paramArrayOfByte;
    this.width = this.bitmap.getWidth();
    this.height = this.bitmap.getHeight();
    AppMethodBeat.o(234592);
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
    AppMethodBeat.i(234596);
    Size localSize = new Size(this.width, this.height);
    AppMethodBeat.o(234596);
    return localSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.aa
 * JD-Core Version:    0.7.0.1
 */