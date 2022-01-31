package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import com.tencent.mm.a.f;
import com.tencent.mm.sdk.platformtools.av;
import java.util.HashMap;
import java.util.LinkedList;

public final class g
{
  private av egH = new av(1, "chatting-image-gallery-preload-loader");
  protected f<String, Bitmap> kJt = new f(4, new g.1(this));
  public LinkedList<String> kJv = new LinkedList();
  private boolean kJx = false;
  private int lf = 0;
  protected HashMap<String, Long> vvA = new HashMap();
  
  public final void aXQ()
  {
    this.kJt.a(new g.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.g
 * JD-Core Version:    0.7.0.1
 */