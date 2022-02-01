package com.tencent.mm.plugin.qqmail.model;

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

public final class l
{
  private long NjG;
  m NjH;
  private int NjI;
  private int NjJ;
  int NjK;
  List<a> bPE;
  int status;
  
  l(String paramString)
  {
    AppMethodBeat.i(122698);
    this.NjI = 0;
    this.NjJ = 1;
    this.NjK = 2;
    this.status = this.NjI;
    this.NjH = new m(paramString);
    this.bPE = new ArrayList();
    AppMethodBeat.o(122698);
  }
  
  public static k aSn(String paramString)
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
    k localk = new k();
    localk.name = paramString.substring(0, i);
    localk.KbS = paramString.substring(i + 1);
    AppMethodBeat.o(122706);
    return localk;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(122702);
    Iterator localIterator = this.bPE.iterator();
    while (localIterator.hasNext()) {
      if ((a)localIterator.next() == parama)
      {
        AppMethodBeat.o(122702);
        return;
      }
    }
    this.bPE.add(parama);
    AppMethodBeat.o(122702);
  }
  
  public final List<k> aSm(String paramString)
  {
    AppMethodBeat.i(122700);
    Object localObject2 = new ArrayList();
    Object localObject1 = this.NjH.bTt();
    if (localObject1 != null) {
      ((List)localObject2).addAll((Collection)localObject1);
    }
    if (this.status == this.NjI) {
      gDW();
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
      k localk = (k)((Iterator)localObject2).next();
      if ((localk != null) && (((localk.name != null) && (localk.name.contains(paramString))) || ((localk.pinyin != null) && (localk.pinyin.contains(paramString))) || ((localk.KbS != null) && (localk.KbS.contains(paramString))))) {
        ((List)localObject1).add(localk);
      }
    }
    AppMethodBeat.o(122700);
    return localObject1;
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(122703);
    Iterator localIterator = this.bPE.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala == parama)
      {
        this.bPE.remove(locala);
        AppMethodBeat.o(122703);
        return;
      }
    }
    AppMethodBeat.o(122703);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(122699);
    this.bPE.clear();
    AppMethodBeat.o(122699);
  }
  
  public final void gDW()
  {
    AppMethodBeat.i(122701);
    if (this.status == this.NjJ)
    {
      AppMethodBeat.o(122701);
      return;
    }
    if (Util.nowMilliSecond() - this.NjG <= 600000L)
    {
      Iterator localIterator = this.bPE.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).onComplete();
      }
      AppMethodBeat.o(122701);
      return;
    }
    this.status = this.NjJ;
    this.NjG = Util.nowMilliSecond();
    com.tencent.mm.ipcinvoker.j.a(MMApplicationContext.getPackageName(), new IPCVoid(), com.tencent.mm.plugin.qqmail.c.j.class, new f() {});
    AppMethodBeat.o(122701);
  }
  
  public final void jy(List<k> paramList)
  {
    AppMethodBeat.i(122704);
    LinkedList localLinkedList = this.NjH.bTt();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      int i = localLinkedList.indexOf(new ar((k)paramList.next()));
      if (i != -1)
      {
        ar localar = (ar)localLinkedList.get(i);
        localar.NjF += 1;
      }
    }
    this.NjH.s(localLinkedList);
    AppMethodBeat.o(122704);
  }
  
  public static abstract class a
  {
    public abstract void onComplete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.model.l
 * JD-Core Version:    0.7.0.1
 */