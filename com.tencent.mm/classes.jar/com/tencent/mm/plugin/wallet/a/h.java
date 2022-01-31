package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class h
  extends com.tencent.mm.bv.a
{
  public double tUc;
  public double tUd;
  public double tUe;
  public String tUf;
  public LinkedList<t> tUg;
  public i tUh;
  public int tUi;
  public String tUj;
  public String tUk;
  public double tUl;
  public double tUm;
  public int tUn;
  public String tUo;
  public String tUp;
  public a tUq;
  public LinkedList<g> tUr;
  public b tUs;
  
  public h()
  {
    AppMethodBeat.i(56649);
    this.tUg = new LinkedList();
    this.tUr = new LinkedList();
    AppMethodBeat.o(56649);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56650);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.f(1, this.tUc);
      paramVarArgs.f(2, this.tUd);
      paramVarArgs.f(3, this.tUe);
      if (this.tUf != null) {
        paramVarArgs.e(4, this.tUf);
      }
      paramVarArgs.e(5, 8, this.tUg);
      if (this.tUh != null)
      {
        paramVarArgs.iQ(6, this.tUh.computeSize());
        this.tUh.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(7, this.tUi);
      if (this.tUj != null) {
        paramVarArgs.e(8, this.tUj);
      }
      if (this.tUk != null) {
        paramVarArgs.e(9, this.tUk);
      }
      paramVarArgs.f(10, this.tUl);
      paramVarArgs.f(11, this.tUm);
      paramVarArgs.aO(12, this.tUn);
      if (this.tUo != null) {
        paramVarArgs.e(13, this.tUo);
      }
      if (this.tUp != null) {
        paramVarArgs.e(14, this.tUp);
      }
      if (this.tUq != null)
      {
        paramVarArgs.iQ(15, this.tUq.computeSize());
        this.tUq.writeFields(paramVarArgs);
      }
      paramVarArgs.e(16, 8, this.tUr);
      if (this.tUs != null)
      {
        paramVarArgs.iQ(17, this.tUs.computeSize());
        this.tUs.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(56650);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.eW(1) + 8 + 0 + (e.a.a.b.b.a.eW(2) + 8) + (e.a.a.b.b.a.eW(3) + 8);
      paramInt = i;
      if (this.tUf != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.tUf);
      }
      i = paramInt + e.a.a.a.c(5, 8, this.tUg);
      paramInt = i;
      if (this.tUh != null) {
        paramInt = i + e.a.a.a.iP(6, this.tUh.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(7, this.tUi);
      paramInt = i;
      if (this.tUj != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.tUj);
      }
      i = paramInt;
      if (this.tUk != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.tUk);
      }
      i = i + (e.a.a.b.b.a.eW(10) + 8) + (e.a.a.b.b.a.eW(11) + 8) + e.a.a.b.b.a.bl(12, this.tUn);
      paramInt = i;
      if (this.tUo != null) {
        paramInt = i + e.a.a.b.b.a.f(13, this.tUo);
      }
      i = paramInt;
      if (this.tUp != null) {
        i = paramInt + e.a.a.b.b.a.f(14, this.tUp);
      }
      paramInt = i;
      if (this.tUq != null) {
        paramInt = i + e.a.a.a.iP(15, this.tUq.computeSize());
      }
      i = paramInt + e.a.a.a.c(16, 8, this.tUr);
      paramInt = i;
      if (this.tUs != null) {
        paramInt = i + e.a.a.a.iP(17, this.tUs.computeSize());
      }
      AppMethodBeat.o(56650);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tUg.clear();
      this.tUr.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(56650);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      h localh = (h)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(56650);
        return -1;
      case 1: 
        localh.tUc = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
        AppMethodBeat.o(56650);
        return 0;
      case 2: 
        localh.tUd = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
        AppMethodBeat.o(56650);
        return 0;
      case 3: 
        localh.tUe = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
        AppMethodBeat.o(56650);
        return 0;
      case 4: 
        localh.tUf = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56650);
        return 0;
      case 5: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localh.tUg.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56650);
        return 0;
      case 6: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new i();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((i)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localh.tUh = ((i)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56650);
        return 0;
      case 7: 
        localh.tUi = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56650);
        return 0;
      case 8: 
        localh.tUj = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56650);
        return 0;
      case 9: 
        localh.tUk = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56650);
        return 0;
      case 10: 
        localh.tUl = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
        AppMethodBeat.o(56650);
        return 0;
      case 11: 
        localh.tUm = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
        AppMethodBeat.o(56650);
        return 0;
      case 12: 
        localh.tUn = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56650);
        return 0;
      case 13: 
        localh.tUo = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56650);
        return 0;
      case 14: 
        localh.tUp = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56650);
        return 0;
      case 15: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new a();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localh.tUq = ((a)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56650);
        return 0;
      case 16: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new g();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localh.tUr.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56650);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new b();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localh.tUs = ((b)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(56650);
      return 0;
    }
    AppMethodBeat.o(56650);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.h
 * JD-Core Version:    0.7.0.1
 */