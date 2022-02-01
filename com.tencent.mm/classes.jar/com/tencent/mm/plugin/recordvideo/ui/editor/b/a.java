package com.tencent.mm.plugin.recordvideo.ui.editor.b;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameInfo;", "", "bitmap", "Landroid/graphics/Bitmap;", "frameDuration", "", "(Landroid/graphics/Bitmap;J)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getFrameDuration", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-recordvideo_release"})
public final class a
{
  public final Bitmap bitmap;
  public final long xPI;
  
  public a(Bitmap paramBitmap, long paramLong)
  {
    AppMethodBeat.i(200800);
    this.bitmap = paramBitmap;
    this.xPI = paramLong;
    AppMethodBeat.o(200800);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(200803);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!p.i(this.bitmap, paramObject.bitmap)) || (this.xPI != paramObject.xPI)) {}
      }
    }
    else
    {
      AppMethodBeat.o(200803);
      return true;
    }
    AppMethodBeat.o(200803);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(200802);
    Bitmap localBitmap = this.bitmap;
    if (localBitmap != null) {}
    for (int i = localBitmap.hashCode();; i = 0)
    {
      long l = this.xPI;
      int j = (int)(l ^ l >>> 32);
      AppMethodBeat.o(200802);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(200801);
    String str = "FrameInfo(bitmap=" + this.bitmap + ", frameDuration=" + this.xPI + ")";
    AppMethodBeat.o(200801);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.b.a
 * JD-Core Version:    0.7.0.1
 */