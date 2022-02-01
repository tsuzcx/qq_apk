package com.tencent.mm.sticker.loader;

import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.h;
import d.g.a.b;
import d.l;
import d.y;
import java.util.Iterator;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/sticker/loader/StickerTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "info", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "(Lcom/tencent/mm/sticker/loader/StickerLoadInfo;)V", "TAG", "", "callbackList", "Ljava/util/LinkedList;", "Lkotlin/Function1;", "", "", "getInfo", "()Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "addCallback", "callback", "cancel", "onResult", "success", "plugin-sticker_release"})
public abstract class g
  extends c
{
  final LinkedList<b<Boolean, y>> GAV;
  public final StickerLoadInfo GAW;
  private final String TAG;
  
  public g(StickerLoadInfo paramStickerLoadInfo)
  {
    this.GAW = paramStickerLoadInfo;
    this.TAG = "MicroMsg.StickerTask";
    this.GAV = new LinkedList();
  }
  
  public void de(boolean paramBoolean)
  {
    Iterator localIterator = ((Iterable)this.GAV).iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).ay(Boolean.valueOf(paramBoolean));
    }
    if (paramBoolean)
    {
      a(h.gLN);
      return;
    }
    a(h.gLO);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.g
 * JD-Core Version:    0.7.0.1
 */