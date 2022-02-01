package com.tencent.mm.plugin.qqmail.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.qqmail.c.j;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class m
{
  List<a> callbacks;
  int status;
  private long xbG;
  n xbH;
  private int xbI;
  private int xbJ;
  int xbK;
  
  m(String paramString)
  {
    AppMethodBeat.i(122698);
    this.xbI = 0;
    this.xbJ = 1;
    this.xbK = 2;
    this.status = this.xbI;
    this.xbH = new n(paramString);
    this.callbacks = new ArrayList();
    AppMethodBeat.o(122698);
  }
  
  public static l auX(String paramString)
  {
    AppMethodBeat.i(122706);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(122706);
      return null;
    }
    paramString = paramString.trim();
    int i = paramString.trim().lastIndexOf(" ");
    if (i == -1)
    {
      AppMethodBeat.o(122706);
      return null;
    }
    l locall = new l();
    locall.name = paramString.substring(0, i);
    locall.uZn = paramString.substring(i + 1);
    AppMethodBeat.o(122706);
    return locall;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(122702);
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext()) {
      if ((a)localIterator.next() == parama)
      {
        AppMethodBeat.o(122702);
        return;
      }
    }
    this.callbacks.add(parama);
    AppMethodBeat.o(122702);
  }
  
  public final List<l> auW(String paramString)
  {
    AppMethodBeat.i(122700);
    Object localObject2 = new ArrayList();
    Object localObject1 = this.xbH.aQn();
    if (localObject1 != null) {
      ((List)localObject2).addAll((Collection)localObject1);
    }
    if (this.status == this.xbI) {
      dCh();
    }
    Collections.sort((List)localObject2, new Comparator() {});
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(122700);
      return localObject2;
    }
    localObject1 = new ArrayList();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      l locall = (l)((Iterator)localObject2).next();
      if ((locall != null) && (((locall.name != null) && (locall.name.contains(paramString))) || ((locall.pinyin != null) && (locall.pinyin.contains(paramString))) || ((locall.uZn != null) && (locall.uZn.contains(paramString))))) {
        ((List)localObject1).add(locall);
      }
    }
    AppMethodBeat.o(122700);
    return localObject1;
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(122703);
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala == parama)
      {
        this.callbacks.remove(locala);
        AppMethodBeat.o(122703);
        return;
      }
    }
    AppMethodBeat.o(122703);
  }
  
  public final void dCh()
  {
    AppMethodBeat.i(122701);
    if (this.status == this.xbJ)
    {
      AppMethodBeat.o(122701);
      return;
    }
    if (bt.flT() - this.xbG <= 600000L)
    {
      Iterator localIterator = this.callbacks.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).onComplete();
      }
      AppMethodBeat.o(122701);
      return;
    }
    this.status = this.xbJ;
    this.xbG = bt.flT();
    h.a(aj.getPackageName(), new IPCVoid(), j.class, new d() {});
    AppMethodBeat.o(122701);
  }
  
  public final void eQ(List<l> paramList)
  {
    AppMethodBeat.i(122704);
    LinkedList localLinkedList = this.xbH.aQn();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      int i = localLinkedList.indexOf(new as((l)paramList.next()));
      if (i != -1)
      {
        as localas = (as)localLinkedList.get(i);
        localas.xbF += 1;
      }
    }
    this.xbH.r(localLinkedList);
    AppMethodBeat.o(122704);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(122699);
    this.callbacks.clear();
    AppMethodBeat.o(122699);
  }
  
  public static abstract class a
  {
    public abstract void onComplete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.m
 * JD-Core Version:    0.7.0.1
 */