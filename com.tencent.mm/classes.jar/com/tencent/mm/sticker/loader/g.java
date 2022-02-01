package com.tencent.mm.sticker.loader;

import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.h;
import d.g.a.b;
import d.l;
import d.y;
import java.util.Iterator;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/sticker/loader/StickerTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "info", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "(Lcom/tencent/mm/sticker/loader/StickerLoadInfo;)V", "TAG", "", "callbackList", "Ljava/util/LinkedList;", "Lkotlin/Function1;", "", "", "getInfo", "()Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "addCallback", "callback", "cancel", "onResult", "success", "plugin-sticker_release"})
public abstract class g
  extends c
{
  public final StickerLoadInfo Fdv;
  final LinkedList<b<Boolean, y>> LAA;
  private final String TAG;
  
  public g(StickerLoadInfo paramStickerLoadInfo)
  {
    this.Fdv = paramStickerLoadInfo;
    this.TAG = "MicroMsg.StickerTask";
    this.LAA = new LinkedList();
  }
  
  public void df(boolean paramBoolean)
  {
    Iterator localIterator = ((Iterable)this.LAA).iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).aA(Boolean.valueOf(paramBoolean));
    }
    if (paramBoolean)
    {
      a(h.gla);
      return;
    }
    a(h.glb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.g
 * JD-Core Version:    0.7.0.1
 */