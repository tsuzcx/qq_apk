package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.b.f.a;
import com.tencent.mm.b.f.b;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import java.util.HashMap;
import java.util.LinkedList;

public final class m
{
  protected f<String, Bitmap> HOH;
  public LinkedList<String> HOJ;
  private boolean HOL;
  protected HashMap<String, Long> aeCr;
  private int mScrollState;
  private QueueWorkerThread owH;
  
  public m()
  {
    AppMethodBeat.i(36076);
    this.HOH = new b(4, new f.b() {}, getClass());
    this.aeCr = new HashMap();
    this.HOJ = new LinkedList();
    this.owH = new QueueWorkerThread(1, "chatting-image-gallery-preload-loader");
    this.HOL = false;
    this.mScrollState = 0;
    AppMethodBeat.o(36076);
  }
  
  public final void fBF()
  {
    AppMethodBeat.i(36077);
    this.HOH.a(new f.a() {});
    AppMethodBeat.o(36077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.m
 * JD-Core Version:    0.7.0.1
 */