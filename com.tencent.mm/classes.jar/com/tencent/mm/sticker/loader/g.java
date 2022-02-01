package com.tencent.mm.sticker.loader;

import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.j;
import d.g.a.b;
import d.l;
import d.z;
import java.util.Iterator;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/sticker/loader/StickerTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "info", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "(Lcom/tencent/mm/sticker/loader/StickerLoadInfo;)V", "TAG", "", "callbackList", "Ljava/util/LinkedList;", "Lkotlin/Function1;", "", "", "getInfo", "()Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "addCallback", "callback", "cancel", "onResult", "success", "plugin-sticker_release"})
public abstract class g
  extends c
{
  final LinkedList<b<Boolean, z>> IHa;
  public final StickerLoadInfo IHb;
  private final String TAG;
  
  public g(StickerLoadInfo paramStickerLoadInfo)
  {
    this.IHb = paramStickerLoadInfo;
    this.TAG = "MicroMsg.StickerTask";
    this.IHa = new LinkedList();
  }
  
  public void dg(boolean paramBoolean)
  {
    Iterator localIterator = ((Iterable)this.IHa).iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).invoke(Boolean.valueOf(paramBoolean));
    }
    if (paramBoolean)
    {
      a(j.hiy);
      return;
    }
    a(j.hiz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.g
 * JD-Core Version:    0.7.0.1
 */