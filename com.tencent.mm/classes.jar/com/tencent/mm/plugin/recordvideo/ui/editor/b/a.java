package com.tencent.mm.plugin.recordvideo.ui.editor.b;

import android.graphics.Bitmap;
import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameInfo;", "", "bitmap", "Landroid/graphics/Bitmap;", "frameDuration", "", "(Landroid/graphics/Bitmap;J)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getFrameDuration", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public final Bitmap bitmap;
  public final long nyF;
  
  public a(Bitmap paramBitmap, long paramLong)
  {
    AppMethodBeat.i(279959);
    this.bitmap = paramBitmap;
    this.nyF = paramLong;
    AppMethodBeat.o(279959);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(279988);
    if (this == paramObject)
    {
      AppMethodBeat.o(279988);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(279988);
      return false;
    }
    paramObject = (a)paramObject;
    if (!s.p(this.bitmap, paramObject.bitmap))
    {
      AppMethodBeat.o(279988);
      return false;
    }
    if (this.nyF != paramObject.nyF)
    {
      AppMethodBeat.o(279988);
      return false;
    }
    AppMethodBeat.o(279988);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(279976);
    int i = this.bitmap.hashCode();
    int j = q.a..ExternalSyntheticBackport0.m(this.nyF);
    AppMethodBeat.o(279976);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(279969);
    String str = "FrameInfo(bitmap=" + this.bitmap + ", frameDuration=" + this.nyF + ')';
    AppMethodBeat.o(279969);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.b.a
 * JD-Core Version:    0.7.0.1
 */