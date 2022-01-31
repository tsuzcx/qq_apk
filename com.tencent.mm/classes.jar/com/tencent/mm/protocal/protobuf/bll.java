package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bll
  extends com.tencent.mm.bv.a
{
  public String fGn;
  public String ppp;
  public String qkt;
  public int xAa;
  public String xAb;
  public int xAc;
  public String xAd;
  public int xAe;
  public String xAf;
  public long xAg;
  public LinkedList<blc> xAh;
  public String xlB;
  
  public bll()
  {
    AppMethodBeat.i(56898);
    this.xAh = new LinkedList();
    AppMethodBeat.o(56898);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56899);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xAa);
      if (this.xAb != null) {
        paramVarArgs.e(2, this.xAb);
      }
      if (this.xlB != null) {
        paramVarArgs.e(3, this.xlB);
      }
      paramVarArgs.aO(4, this.xAc);
      if (this.ppp != null) {
        paramVarArgs.e(5, this.ppp);
      }
      if (this.xAd != null) {
        paramVarArgs.e(6, this.xAd);
      }
      if (this.qkt != null) {
        paramVarArgs.e(7, this.qkt);
      }
      paramVarArgs.aO(8, this.xAe);
      if (this.fGn != null) {
        paramVarArgs.e(9, this.fGn);
      }
      if (this.xAf != null) {
        paramVarArgs.e(10, this.xAf);
      }
      paramVarArgs.am(11, this.xAg);
      paramVarArgs.e(12, 8, this.xAh);
      AppMethodBeat.o(56899);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.xAa) + 0;
      paramInt = i;
      if (this.xAb != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xAb);
      }
      i = paramInt;
      if (this.xlB != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xlB);
      }
      i += e.a.a.b.b.a.bl(4, this.xAc);
      paramInt = i;
      if (this.ppp != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.ppp);
      }
      i = paramInt;
      if (this.xAd != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.xAd);
      }
      paramInt = i;
      if (this.qkt != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.qkt);
      }
      i = paramInt + e.a.a.b.b.a.bl(8, this.xAe);
      paramInt = i;
      if (this.fGn != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.fGn);
      }
      i = paramInt;
      if (this.xAf != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.xAf);
      }
      paramInt = e.a.a.b.b.a.p(11, this.xAg);
      int j = e.a.a.a.c(12, 8, this.xAh);
      AppMethodBeat.o(56899);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xAh.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(56899);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      bll localbll = (bll)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(56899);
        return -1;
      case 1: 
        localbll.xAa = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56899);
        return 0;
      case 2: 
        localbll.xAb = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56899);
        return 0;
      case 3: 
        localbll.xlB = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56899);
        return 0;
      case 4: 
        localbll.xAc = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56899);
        return 0;
      case 5: 
        localbll.ppp = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56899);
        return 0;
      case 6: 
        localbll.xAd = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56899);
        return 0;
      case 7: 
        localbll.qkt = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56899);
        return 0;
      case 8: 
        localbll.xAe = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56899);
        return 0;
      case 9: 
        localbll.fGn = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56899);
        return 0;
      case 10: 
        localbll.xAf = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56899);
        return 0;
      case 11: 
        localbll.xAg = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(56899);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new blc();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((blc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localbll.xAh.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(56899);
      return 0;
    }
    AppMethodBeat.o(56899);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bll
 * JD-Core Version:    0.7.0.1
 */