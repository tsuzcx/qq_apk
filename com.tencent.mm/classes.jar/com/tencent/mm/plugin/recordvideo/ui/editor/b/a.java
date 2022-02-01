package com.tencent.mm.plugin.recordvideo.ui.editor.b;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameInfo;", "", "bitmap", "Landroid/graphics/Bitmap;", "frameDuration", "", "(Landroid/graphics/Bitmap;J)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getFrameDuration", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-recordvideo_release"})
public final class a
{
  public final long CgA;
  public final Bitmap bitmap;
  
  public a(Bitmap paramBitmap, long paramLong)
  {
    AppMethodBeat.i(237899);
    this.bitmap = paramBitmap;
    this.CgA = paramLong;
    AppMethodBeat.o(237899);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(237902);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!p.j(this.bitmap, paramObject.bitmap)) || (this.CgA != paramObject.CgA)) {}
      }
    }
    else
    {
      AppMethodBeat.o(237902);
      return true;
    }
    AppMethodBeat.o(237902);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(237901);
    Bitmap localBitmap = this.bitmap;
    if (localBitmap != null) {}
    for (int i = localBitmap.hashCode();; i = 0)
    {
      long l = this.CgA;
      int j = (int)(l ^ l >>> 32);
      AppMethodBeat.o(237901);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(237900);
    String str = "FrameInfo(bitmap=" + this.bitmap + ", frameDuration=" + this.CgA + ")";
    AppMethodBeat.o(237900);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.b.a
 * JD-Core Version:    0.7.0.1
 */