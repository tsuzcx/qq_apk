package com.tencent.mm.sdk.a;

import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vending.b.b;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

final class c
  extends com.tencent.mm.vending.b.a<e>
{
  public final void a(com.tencent.mm.vending.i.a parama)
  {
    LinkedList localLinkedList = lD();
    parama = (d)parama.lK();
    if (parama == null) {
      f.c("MicroMsg.EventCenter", "event is null! fatal!");
    }
    do
    {
      return;
      if (parama.lc()) {
        Collections.sort(localLinkedList, new Comparator() {});
      }
      b[] arrayOfb = new b[localLinkedList.size()];
      localLinkedList.toArray(arrayOfb);
      int j = arrayOfb.length;
      int i = 0;
      while ((i < j) && ((!((e)arrayOfb[i].get()).b(parama)) || (!parama.lc()))) {
        i += 1;
      }
    } while (parama.WP == null);
    parama.WP.run();
  }
  
  public final void c(e parame)
  {
    b(new b(parame, this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.a.c
 * JD-Core Version:    0.7.0.1
 */