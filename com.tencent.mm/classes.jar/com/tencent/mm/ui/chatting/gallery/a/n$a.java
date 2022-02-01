package com.tencent.mm.ui.chatting.gallery.a;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/chatting/gallery/scan/ScanCodeResult$CodePointInfo;", "", "()V", "codePoint", "Landroid/graphics/PointF;", "getCodePoint", "()Landroid/graphics/PointF;", "setCodePoint", "(Landroid/graphics/PointF;)V", "decodeImageHeight", "", "getDecodeImageHeight", "()I", "setDecodeImageHeight", "(I)V", "decodeImageWidth", "getDecodeImageWidth", "setDecodeImageWidth", "toString", "", "app_release"})
public final class n$a
{
  public PointF KqW;
  public int KqX;
  public int KqY;
  
  public final String toString()
  {
    AppMethodBeat.i(188354);
    String str = "codePoint: " + this.KqW + ", imageWidth: " + this.KqX + ", imageHeight: " + this.KqY;
    AppMethodBeat.o(188354);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a.n.a
 * JD-Core Version:    0.7.0.1
 */