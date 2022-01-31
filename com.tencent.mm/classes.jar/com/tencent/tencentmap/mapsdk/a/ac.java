package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.ka;
import java.util.ArrayList;
import java.util.List;

public final class ac
{
  public static ab a()
  {
    AppMethodBeat.i(147083);
    Object localObject = new am();
    ((am)localObject).o = am.a;
    localObject = new ab((am)localObject);
    AppMethodBeat.o(147083);
    return localObject;
  }
  
  public static ab a(float paramFloat)
  {
    AppMethodBeat.i(147086);
    Object localObject = new am();
    ((am)localObject).o = am.d;
    ((am)localObject).r = paramFloat;
    localObject = new ab((am)localObject);
    AppMethodBeat.o(147086);
    return localObject;
  }
  
  public static ab a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(147085);
    Object localObject = new am();
    ((am)localObject).o = am.c;
    ((am)localObject).p = paramFloat1;
    ((am)localObject).q = paramFloat2;
    localObject = new ab((am)localObject);
    AppMethodBeat.o(147085);
    return localObject;
  }
  
  public static ab a(float paramFloat, Point paramPoint)
  {
    AppMethodBeat.i(147088);
    am localam = new am();
    localam.o = am.f;
    localam.t = paramFloat;
    localam.u = paramPoint;
    paramPoint = new ab(localam);
    AppMethodBeat.o(147088);
    return paramPoint;
  }
  
  public static ab a(cn paramcn)
  {
    AppMethodBeat.i(147089);
    am localam = new am();
    localam.o = am.g;
    localam.v = paramcn;
    paramcn = new ab(localam);
    AppMethodBeat.o(147089);
    return paramcn;
  }
  
  public static ab a(cz paramcz)
  {
    AppMethodBeat.i(147090);
    am localam = new am();
    localam.o = am.h;
    localam.w = paramcz;
    paramcz = new ab(localam);
    AppMethodBeat.o(147090);
    return paramcz;
  }
  
  public static ab a(cz paramcz, float paramFloat)
  {
    AppMethodBeat.i(147091);
    am localam = new am();
    localam.o = am.i;
    localam.x = paramcz;
    localam.y = paramFloat;
    paramcz = new ab(localam);
    AppMethodBeat.o(147091);
    return paramcz;
  }
  
  public static ab a(da paramda, int paramInt)
  {
    AppMethodBeat.i(147092);
    am localam = new am();
    localam.o = am.j;
    localam.z = paramda;
    localam.A = paramInt;
    paramda = new ab(localam);
    AppMethodBeat.o(147092);
    return paramda;
  }
  
  public static ab a(da paramda, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(147093);
    am localam = new am();
    localam.o = am.l;
    localam.B = paramda;
    localam.F = paramInt1;
    localam.G = paramInt2;
    localam.H = paramInt3;
    localam.I = paramInt4;
    paramda = new ab(localam);
    AppMethodBeat.o(147093);
    return paramda;
  }
  
  public static ab a(da paramda, cz paramcz, int paramInt)
  {
    AppMethodBeat.i(147094);
    if (paramda == null)
    {
      AppMethodBeat.o(147094);
      return null;
    }
    cz localcz1 = paramda.b;
    cz localcz2 = ka.a(paramcz, localcz1);
    paramda = paramda.a;
    paramcz = ka.a(paramcz, paramda);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localcz1);
    localArrayList.add(localcz2);
    localArrayList.add(paramda);
    localArrayList.add(paramcz);
    paramda = a(new da.a().a(localArrayList).a(), paramInt);
    AppMethodBeat.o(147094);
    return paramda;
  }
  
  public static ab b()
  {
    AppMethodBeat.i(147084);
    Object localObject = new am();
    ((am)localObject).o = am.b;
    localObject = new ab((am)localObject);
    AppMethodBeat.o(147084);
    return localObject;
  }
  
  public static ab b(float paramFloat)
  {
    AppMethodBeat.i(147087);
    Object localObject = new am();
    ((am)localObject).o = am.e;
    ((am)localObject).s = paramFloat;
    localObject = new ab((am)localObject);
    AppMethodBeat.o(147087);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ac
 * JD-Core Version:    0.7.0.1
 */