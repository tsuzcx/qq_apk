package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class auy
  extends com.tencent.mm.bv.a
{
  public int count;
  public String czq;
  public long duration;
  public long startTime;
  public String xkf;
  public LinkedList<auz> xkg;
  public LinkedList<auz> xkh;
  
  public auy()
  {
    AppMethodBeat.i(152442);
    this.xkf = "";
    this.startTime = 0L;
    this.duration = 0L;
    this.czq = "";
    this.xkg = new LinkedList();
    this.count = 1;
    this.xkh = new LinkedList();
    AppMethodBeat.o(152442);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152443);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xkf != null) {
        paramVarArgs.e(1, this.xkf);
      }
      paramVarArgs.am(2, this.startTime);
      paramVarArgs.am(3, this.duration);
      if (this.czq != null) {
        paramVarArgs.e(4, this.czq);
      }
      paramVarArgs.e(5, 8, this.xkg);
      paramVarArgs.aO(6, this.count);
      paramVarArgs.e(7, 8, this.xkh);
      AppMethodBeat.o(152443);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xkf == null) {
        break label694;
      }
    }
    label694:
    for (paramInt = e.a.a.b.b.a.f(1, this.xkf) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.p(2, this.startTime) + e.a.a.b.b.a.p(3, this.duration);
      paramInt = i;
      if (this.czq != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.czq);
      }
      i = e.a.a.a.c(5, 8, this.xkg);
      int j = e.a.a.b.b.a.bl(6, this.count);
      int k = e.a.a.a.c(7, 8, this.xkh);
      AppMethodBeat.o(152443);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xkg.clear();
        this.xkh.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(152443);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        auy localauy = (auy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152443);
          return -1;
        case 1: 
          localauy.xkf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(152443);
          return 0;
        case 2: 
          localauy.startTime = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(152443);
          return 0;
        case 3: 
          localauy.duration = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(152443);
          return 0;
        case 4: 
          localauy.czq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(152443);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new auz();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((auz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localauy.xkg.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152443);
          return 0;
        case 6: 
          localauy.count = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(152443);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new auz();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((auz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localauy.xkh.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152443);
        return 0;
      }
      AppMethodBeat.o(152443);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auy
 * JD-Core Version:    0.7.0.1
 */