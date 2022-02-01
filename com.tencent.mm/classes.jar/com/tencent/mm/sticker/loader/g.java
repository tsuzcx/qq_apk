package com.tencent.mm.sticker.loader;

import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.j;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sticker/loader/StickerTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "info", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "(Lcom/tencent/mm/sticker/loader/StickerLoadInfo;)V", "TAG", "", "callbackList", "Ljava/util/LinkedList;", "Lkotlin/Function1;", "", "", "getInfo", "()Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "addCallback", "callback", "cancel", "onResult", "success", "plugin-sticker_release"})
public abstract class g
  extends c
{
  private final String TAG;
  final LinkedList<b<Boolean, x>> VbD;
  public final StickerLoadInfo VbE;
  
  public g(StickerLoadInfo paramStickerLoadInfo)
  {
    this.VbE = paramStickerLoadInfo;
    this.TAG = "MicroMsg.StickerTask";
    this.VbD = new LinkedList();
  }
  
  public void ep(boolean paramBoolean)
  {
    Iterator localIterator = ((Iterable)this.VbD).iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).invoke(Boolean.valueOf(paramBoolean));
    }
    if (paramBoolean)
    {
      a(j.kQd);
      return;
    }
    a(j.kQe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.g
 * JD-Core Version:    0.7.0.1
 */