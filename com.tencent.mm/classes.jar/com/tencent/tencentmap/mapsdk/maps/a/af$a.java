package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class af$a
{
  Integer a;
  String b;
  String c;
  String d;
  private String e;
  private List<ad> f;
  private List<ad> g;
  private List<ad> h;
  private List<ad> i;
  
  public af$a(String paramString)
  {
    this.e = paramString;
  }
  
  public final List<ad> a()
  {
    AppMethodBeat.i(147202);
    ArrayList localArrayList = new ArrayList();
    List localList = this.f;
    if ((localList != null) && (localList.size() > 0)) {
      localArrayList.addAll(localList);
    }
    localList = this.g;
    if ((localList != null) && (localList.size() > 0)) {
      localArrayList.addAll(localList);
    }
    localList = this.h;
    if ((localList != null) && (localList.size() > 0)) {
      localArrayList.addAll(localList);
    }
    localList = this.i;
    if ((localList != null) && (localList.size() > 0)) {
      localArrayList.addAll(localList);
    }
    AppMethodBeat.o(147202);
    return localArrayList;
  }
  
  public final void a(ad paramad)
  {
    AppMethodBeat.i(147203);
    if (paramad == null)
    {
      AppMethodBeat.o(147203);
      return;
    }
    if (paramad.b() == 1)
    {
      if (this.f == null) {
        this.f = new ArrayList();
      }
      this.f.add(paramad);
      AppMethodBeat.o(147203);
      return;
    }
    if (paramad.b() == 2)
    {
      if (this.g == null) {
        this.g = new ArrayList();
      }
      this.g.add(paramad);
      AppMethodBeat.o(147203);
      return;
    }
    if (paramad.b() == 3)
    {
      if (this.h == null) {
        this.h = new ArrayList();
      }
      this.h.add(paramad);
      AppMethodBeat.o(147203);
      return;
    }
    if (paramad.b() == 4)
    {
      if (this.i == null) {
        this.i = new ArrayList();
      }
      this.i.add(paramad);
      AppMethodBeat.o(147203);
      return;
    }
    if (this.f == null) {
      this.f = new ArrayList();
    }
    this.f.add(paramad);
    AppMethodBeat.o(147203);
  }
  
  public final void b(ad paramad)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(147204);
        if (paramad == null)
        {
          AppMethodBeat.o(147204);
          return;
        }
        if (paramad.b() == 1)
        {
          if ((this.f == null) || (this.f.isEmpty()) || (!paramad.a((ad)this.f.get(0)))) {
            break label148;
          }
          this.f.remove(0);
          AppMethodBeat.o(147204);
          continue;
        }
        if (paramad.b() != 2) {
          break label148;
        }
      }
      finally {}
      if ((this.g != null) && (!this.g.isEmpty()) && (paramad.a((ad)this.g.get(0)))) {
        this.g.remove(0);
      }
      label148:
      AppMethodBeat.o(147204);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(147205);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Appid：" + this.a + " domain：" + this.b + "\r\n");
    ((StringBuilder)localObject).append("apn：" + this.e + " ckIP：" + this.c + "\r\n");
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      ad localad = (ad)localIterator.next();
      ((StringBuilder)localObject).append("accessIP：" + localad.toString() + "\r\n");
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(147205);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.af.a
 * JD-Core Version:    0.7.0.1
 */