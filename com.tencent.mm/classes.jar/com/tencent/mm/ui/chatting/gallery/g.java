package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.b.f.a;
import com.tencent.mm.b.f.b;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.sdk.platformtools.bd;
import java.util.HashMap;
import java.util.LinkedList;

public final class g
{
  protected HashMap<String, Long> IbP;
  private bd hyl;
  private int mScrollState;
  protected f<String, Bitmap> sRA;
  public LinkedList<String> sRC;
  private boolean sRE;
  
  public g()
  {
    AppMethodBeat.i(36076);
    this.sRA = new b(4, new f.b() {}, getClass());
    this.IbP = new HashMap();
    this.sRC = new LinkedList();
    this.hyl = new bd(1, "chatting-image-gallery-preload-loader");
    this.sRE = false;
    this.mScrollState = 0;
    AppMethodBeat.o(36076);
  }
  
  public final void cNO()
  {
    AppMethodBeat.i(36077);
    this.sRA.a(new f.a() {});
    AppMethodBeat.o(36077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.g
 * JD-Core Version:    0.7.0.1
 */