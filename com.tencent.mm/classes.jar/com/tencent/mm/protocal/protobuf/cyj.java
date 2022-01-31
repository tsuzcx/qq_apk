package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cyj
  extends com.tencent.mm.bv.a
{
  public int Scene;
  public String lGH;
  public long wBW;
  public String wuH;
  public int xqT;
  public azu xqU;
  public LinkedList<String> yfv;
  public LinkedList<up> yfw;
  
  public cyj()
  {
    AppMethodBeat.i(124383);
    this.yfv = new LinkedList();
    this.yfw = new LinkedList();
    AppMethodBeat.o(124383);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124384);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.yfv);
      paramVarArgs.aO(2, this.xqT);
      if (this.lGH != null) {
        paramVarArgs.e(3, this.lGH);
      }
      paramVarArgs.aO(4, this.Scene);
      paramVarArgs.am(5, this.wBW);
      if (this.wuH != null) {
        paramVarArgs.e(6, this.wuH);
      }
      if (this.xqU != null)
      {
        paramVarArgs.iQ(7, this.xqU.computeSize());
        this.xqU.writeFields(paramVarArgs);
      }
      paramVarArgs.e(8, 8, this.yfw);
      AppMethodBeat.o(124384);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.a.c(1, 1, this.yfv) + 0 + e.a.a.b.b.a.bl(2, this.xqT);
      paramInt = i;
      if (this.lGH != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.lGH);
      }
      i = paramInt + e.a.a.b.b.a.bl(4, this.Scene) + e.a.a.b.b.a.p(5, this.wBW);
      paramInt = i;
      if (this.wuH != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wuH);
      }
      i = paramInt;
      if (this.xqU != null) {
        i = paramInt + e.a.a.a.iP(7, this.xqU.computeSize());
      }
      paramInt = e.a.a.a.c(8, 8, this.yfw);
      AppMethodBeat.o(124384);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.yfv.clear();
      this.yfw.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(124384);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      cyj localcyj = (cyj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(124384);
        return -1;
      case 1: 
        localcyj.yfv.add(((e.a.a.a.a)localObject1).CLY.readString());
        AppMethodBeat.o(124384);
        return 0;
      case 2: 
        localcyj.xqT = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(124384);
        return 0;
      case 3: 
        localcyj.lGH = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(124384);
        return 0;
      case 4: 
        localcyj.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(124384);
        return 0;
      case 5: 
        localcyj.wBW = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(124384);
        return 0;
      case 6: 
        localcyj.wuH = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(124384);
        return 0;
      case 7: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new azu();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((azu)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcyj.xqU = ((azu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124384);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new up();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((up)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localcyj.yfw.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(124384);
      return 0;
    }
    AppMethodBeat.o(124384);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyj
 * JD-Core Version:    0.7.0.1
 */