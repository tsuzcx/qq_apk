package com.tencent.mm.sticker.loader;

import com.tencent.mm.loader.f.c;
import com.tencent.mm.loader.f.i;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sticker/loader/StickerTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "info", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "(Lcom/tencent/mm/sticker/loader/StickerLoadInfo;)V", "TAG", "", "callbackList", "Ljava/util/LinkedList;", "Lkotlin/Function1;", "", "", "getInfo", "()Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "addCallback", "callback", "cancel", "onResult", "success", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class g
  extends c
{
  private final String TAG;
  public final StickerLoadInfo acCU;
  final LinkedList<b<Boolean, ah>> acCV;
  
  public g(StickerLoadInfo paramStickerLoadInfo)
  {
    this.acCU = paramStickerLoadInfo;
    this.TAG = "MicroMsg.StickerTask";
    this.acCV = new LinkedList();
  }
  
  public void onResult(boolean paramBoolean)
  {
    Iterator localIterator = ((Iterable)this.acCV).iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).invoke(Boolean.valueOf(paramBoolean));
    }
    if (paramBoolean)
    {
      a(i.nrG);
      return;
    }
    a(i.nrH);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.g
 * JD-Core Version:    0.7.0.1
 */