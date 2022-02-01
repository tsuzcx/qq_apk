package com.tencent.mm.plugin.qqmail.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class m
{
  private long HlS;
  n HlT;
  private int HlU;
  private int HlV;
  int HlW;
  List<a> callbacks;
  int status;
  
  m(String paramString)
  {
    AppMethodBeat.i(122698);
    this.HlU = 0;
    this.HlV = 1;
    this.HlW = 2;
    this.status = this.HlU;
    this.HlT = new n(paramString);
    this.callbacks = new ArrayList();
    AppMethodBeat.o(122698);
  }
  
  public static l aVf(String paramString)
  {
    AppMethodBeat.i(122706);
    if (Util.isNullOrNil(paramString))
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
    locall.Ejj = paramString.substring(i + 1);
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
  
  public final List<l> aVe(String paramString)
  {
    AppMethodBeat.i(122700);
    Object localObject2 = new ArrayList();
    Object localObject1 = this.HlT.bvg();
    if (localObject1 != null) {
      ((List)localObject2).addAll((Collection)localObject1);
    }
    if (this.status == this.HlU) {
      fso();
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
      if ((locall != null) && (((locall.name != null) && (locall.name.contains(paramString))) || ((locall.pinyin != null) && (locall.pinyin.contains(paramString))) || ((locall.Ejj != null) && (locall.Ejj.contains(paramString))))) {
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
  
  protected final void finalize()
  {
    AppMethodBeat.i(122699);
    this.callbacks.clear();
    AppMethodBeat.o(122699);
  }
  
  public final void fso()
  {
    AppMethodBeat.i(122701);
    if (this.status == this.HlV)
    {
      AppMethodBeat.o(122701);
      return;
    }
    if (Util.nowMilliSecond() - this.HlS <= 600000L)
    {
      Iterator localIterator = this.callbacks.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).onComplete();
      }
      AppMethodBeat.o(122701);
      return;
    }
    this.status = this.HlV;
    this.HlS = Util.nowMilliSecond();
    com.tencent.mm.ipcinvoker.j.a(MMApplicationContext.getPackageName(), new IPCVoid(), com.tencent.mm.plugin.qqmail.c.j.class, new f() {});
    AppMethodBeat.o(122701);
  }
  
  public final void gy(List<l> paramList)
  {
    AppMethodBeat.i(122704);
    LinkedList localLinkedList = this.HlT.bvg();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      int i = localLinkedList.indexOf(new as((l)paramList.next()));
      if (i != -1)
      {
        as localas = (as)localLinkedList.get(i);
        localas.HlR += 1;
      }
    }
    this.HlT.r(localLinkedList);
    AppMethodBeat.o(122704);
  }
  
  public static abstract class a
  {
    public abstract void onComplete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.m
 * JD-Core Version:    0.7.0.1
 */