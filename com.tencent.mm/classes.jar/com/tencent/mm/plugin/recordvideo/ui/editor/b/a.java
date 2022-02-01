package com.tencent.mm.plugin.recordvideo.ui.editor.b;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameInfo;", "", "bitmap", "Landroid/graphics/Bitmap;", "frameDuration", "", "(Landroid/graphics/Bitmap;J)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getFrameDuration", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-recordvideo_release"})
public final class a
{
  public final Bitmap bitmap;
  public final long kST;
  
  public a(Bitmap paramBitmap, long paramLong)
  {
    AppMethodBeat.i(229019);
    this.bitmap = paramBitmap;
    this.kST = paramLong;
    AppMethodBeat.o(229019);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(229026);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!p.h(this.bitmap, paramObject.bitmap)) || (this.kST != paramObject.kST)) {}
      }
    }
    else
    {
      AppMethodBeat.o(229026);
      return true;
    }
    AppMethodBeat.o(229026);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(229024);
    Bitmap localBitmap = this.bitmap;
    if (localBitmap != null) {}
    for (int i = localBitmap.hashCode();; i = 0)
    {
      long l = this.kST;
      int j = (int)(l ^ l >>> 32);
      AppMethodBeat.o(229024);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(229020);
    String str = "FrameInfo(bitmap=" + this.bitmap + ", frameDuration=" + this.kST + ")";
    AppMethodBeat.o(229020);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.b.a
 * JD-Core Version:    0.7.0.1
 */