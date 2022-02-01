package com.tencent.mm.plugin.recordvideo.ui.editor.b;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameInfo;", "", "bitmap", "Landroid/graphics/Bitmap;", "frameDuration", "", "(Landroid/graphics/Bitmap;J)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getFrameDuration", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-recordvideo_release"})
public final class a
{
  public final Bitmap bitmap;
  public final long yfB;
  
  public a(Bitmap paramBitmap, long paramLong)
  {
    AppMethodBeat.i(207058);
    this.bitmap = paramBitmap;
    this.yfB = paramLong;
    AppMethodBeat.o(207058);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(207061);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!p.i(this.bitmap, paramObject.bitmap)) || (this.yfB != paramObject.yfB)) {}
      }
    }
    else
    {
      AppMethodBeat.o(207061);
      return true;
    }
    AppMethodBeat.o(207061);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(207060);
    Bitmap localBitmap = this.bitmap;
    if (localBitmap != null) {}
    for (int i = localBitmap.hashCode();; i = 0)
    {
      long l = this.yfB;
      int j = (int)(l ^ l >>> 32);
      AppMethodBeat.o(207060);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(207059);
    String str = "FrameInfo(bitmap=" + this.bitmap + ", frameDuration=" + this.yfB + ")";
    AppMethodBeat.o(207059);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.b.a
 * JD-Core Version:    0.7.0.1
 */