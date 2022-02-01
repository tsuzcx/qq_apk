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

public final class g
{
  protected HashMap<String, Long> Pyp;
  private QueueWorkerThread iOL;
  private int mScrollState;
  protected f<String, Bitmap> xqj;
  public LinkedList<String> xql;
  private boolean xqn;
  
  public g()
  {
    AppMethodBeat.i(36076);
    this.xqj = new b(4, new f.b() {}, getClass());
    this.Pyp = new HashMap();
    this.xql = new LinkedList();
    this.iOL = new QueueWorkerThread(1, "chatting-image-gallery-preload-loader");
    this.xqn = false;
    this.mScrollState = 0;
    AppMethodBeat.o(36076);
  }
  
  public final void dSj()
  {
    AppMethodBeat.i(36077);
    this.xqj.a(new f.a() {});
    AppMethodBeat.o(36077);
  }
  
  public static final class a
  {
    public static g Pyr;
    
    static
    {
      AppMethodBeat.i(36075);
      Pyr = new g();
      AppMethodBeat.o(36075);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.g
 * JD-Core Version:    0.7.0.1
 */