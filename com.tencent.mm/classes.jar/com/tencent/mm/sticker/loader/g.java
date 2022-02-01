package com.tencent.mm.sticker.loader;

import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.j;
import d.g.a.b;
import d.l;
import d.z;
import java.util.Iterator;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/sticker/loader/StickerTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "info", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "(Lcom/tencent/mm/sticker/loader/StickerLoadInfo;)V", "TAG", "", "callbackList", "Ljava/util/LinkedList;", "Lkotlin/Function1;", "", "", "getInfo", "()Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "addCallback", "callback", "cancel", "onResult", "success", "plugin-sticker_release"})
public abstract class g
  extends c
{
  final LinkedList<b<Boolean, z>> ImP;
  public final StickerLoadInfo ImQ;
  private final String TAG;
  
  public g(StickerLoadInfo paramStickerLoadInfo)
  {
    this.ImQ = paramStickerLoadInfo;
    this.TAG = "MicroMsg.StickerTask";
    this.ImP = new LinkedList();
  }
  
  public void dg(boolean paramBoolean)
  {
    Iterator localIterator = ((Iterable)this.ImP).iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).invoke(Boolean.valueOf(paramBoolean));
    }
    if (paramBoolean)
    {
      a(j.hfK);
      return;
    }
    a(j.hfL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.g
 * JD-Core Version:    0.7.0.1
 */