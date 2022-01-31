package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Typeface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.ka;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class di
{
  private final List<cz> a;
  private float b;
  private int c;
  private int d;
  private int e;
  private boolean f;
  private boolean g;
  private String h;
  private int i;
  private Typeface j;
  private int k;
  private int l;
  private int m;
  private int n;
  
  public di()
  {
    AppMethodBeat.i(150101);
    this.h = "";
    this.i = -16777216;
    this.j = Typeface.DEFAULT;
    this.k = 2147483647;
    this.l = 1;
    this.m = -1;
    this.n = dg.c;
    this.b = 1.0F;
    this.c = -16777216;
    this.d = ka.l;
    this.e = 0;
    this.f = true;
    this.g = false;
    this.a = new ArrayList();
    AppMethodBeat.o(150101);
  }
  
  public di a(float paramFloat)
  {
    if (paramFloat < 0.0F)
    {
      this.b = 1.0F;
      return this;
    }
    this.b = paramFloat;
    return this;
  }
  
  public di a(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public di a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }
  
  public List<cz> a()
  {
    return this.a;
  }
  
  public void a(Iterable<cz> paramIterable)
  {
    AppMethodBeat.i(150102);
    if (this.a == null)
    {
      AppMethodBeat.o(150102);
      return;
    }
    this.a.clear();
    if (paramIterable == null)
    {
      AppMethodBeat.o(150102);
      return;
    }
    b(paramIterable);
    AppMethodBeat.o(150102);
  }
  
  public float b()
  {
    return this.b;
  }
  
  public di b(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public di b(Iterable<cz> paramIterable)
  {
    AppMethodBeat.i(150103);
    if (paramIterable != null)
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        cz localcz = (cz)paramIterable.next();
        this.a.add(localcz);
      }
    }
    AppMethodBeat.o(150103);
    return this;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public di c(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public di d(int paramInt)
  {
    if ((paramInt < dg.a) || (paramInt > dg.c)) {
      return this;
    }
    this.n = paramInt;
    return this;
  }
  
  public float e()
  {
    return this.e;
  }
  
  public boolean f()
  {
    return this.f;
  }
  
  public String g()
  {
    return this.h;
  }
  
  public int h()
  {
    return this.n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.di
 * JD-Core Version:    0.7.0.1
 */