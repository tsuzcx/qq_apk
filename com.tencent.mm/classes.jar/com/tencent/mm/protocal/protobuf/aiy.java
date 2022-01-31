package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aiy
  extends com.tencent.mm.bv.a
  implements ccv
{
  public int Ret;
  public int wLV;
  public int wLW;
  public int wLX;
  public LinkedList<cig> wLY;
  public LinkedList<cig> wLZ;
  public LinkedList<cig> wMa;
  public int wMb;
  public int wMc;
  public int wMd;
  public auw wMe;
  public int xaD;
  public int xaE;
  public int xaF;
  public LinkedList<cig> xaG;
  public LinkedList<cig> xaH;
  public LinkedList<cig> xaI;
  
  public aiy()
  {
    AppMethodBeat.i(72850);
    this.wLY = new LinkedList();
    this.wLZ = new LinkedList();
    this.wMa = new LinkedList();
    this.xaG = new LinkedList();
    this.xaH = new LinkedList();
    this.xaI = new LinkedList();
    AppMethodBeat.o(72850);
  }
  
  public final int getRet()
  {
    return this.Ret;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72851);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.Ret);
      paramVarArgs.aO(2, this.wLV);
      paramVarArgs.aO(3, this.wLW);
      paramVarArgs.aO(4, this.wLX);
      paramVarArgs.e(5, 8, this.wLY);
      paramVarArgs.e(6, 8, this.wLZ);
      paramVarArgs.e(7, 8, this.wMa);
      paramVarArgs.aO(8, this.wMb);
      paramVarArgs.aO(9, this.wMc);
      paramVarArgs.aO(10, this.wMd);
      paramVarArgs.aO(11, this.xaD);
      paramVarArgs.aO(12, this.xaE);
      paramVarArgs.aO(13, this.xaF);
      paramVarArgs.e(14, 8, this.xaG);
      paramVarArgs.e(15, 8, this.xaH);
      paramVarArgs.e(16, 8, this.xaI);
      if (this.wMe != null)
      {
        paramVarArgs.iQ(17, this.wMe.computeSize());
        this.wMe.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72851);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.Ret) + 0 + e.a.a.b.b.a.bl(2, this.wLV) + e.a.a.b.b.a.bl(3, this.wLW) + e.a.a.b.b.a.bl(4, this.wLX) + e.a.a.a.c(5, 8, this.wLY) + e.a.a.a.c(6, 8, this.wLZ) + e.a.a.a.c(7, 8, this.wMa) + e.a.a.b.b.a.bl(8, this.wMb) + e.a.a.b.b.a.bl(9, this.wMc) + e.a.a.b.b.a.bl(10, this.wMd) + e.a.a.b.b.a.bl(11, this.xaD) + e.a.a.b.b.a.bl(12, this.xaE) + e.a.a.b.b.a.bl(13, this.xaF) + e.a.a.a.c(14, 8, this.xaG) + e.a.a.a.c(15, 8, this.xaH) + e.a.a.a.c(16, 8, this.xaI);
      paramInt = i;
      if (this.wMe != null) {
        paramInt = i + e.a.a.a.iP(17, this.wMe.computeSize());
      }
      AppMethodBeat.o(72851);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wLY.clear();
      this.wLZ.clear();
      this.wMa.clear();
      this.xaG.clear();
      this.xaH.clear();
      this.xaI.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(72851);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      aiy localaiy = (aiy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(72851);
        return -1;
      case 1: 
        localaiy.Ret = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72851);
        return 0;
      case 2: 
        localaiy.wLV = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72851);
        return 0;
      case 3: 
        localaiy.wLW = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72851);
        return 0;
      case 4: 
        localaiy.wLX = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72851);
        return 0;
      case 5: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cig();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cig)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localaiy.wLY.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72851);
        return 0;
      case 6: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cig();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cig)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localaiy.wLZ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72851);
        return 0;
      case 7: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cig();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cig)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localaiy.wMa.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72851);
        return 0;
      case 8: 
        localaiy.wMb = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72851);
        return 0;
      case 9: 
        localaiy.wMc = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72851);
        return 0;
      case 10: 
        localaiy.wMd = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72851);
        return 0;
      case 11: 
        localaiy.xaD = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72851);
        return 0;
      case 12: 
        localaiy.xaE = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72851);
        return 0;
      case 13: 
        localaiy.xaF = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72851);
        return 0;
      case 14: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cig();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cig)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localaiy.xaG.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72851);
        return 0;
      case 15: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cig();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cig)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localaiy.xaH.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72851);
        return 0;
      case 16: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cig();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cig)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localaiy.xaI.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72851);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new auw();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((auw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localaiy.wMe = ((auw)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(72851);
      return 0;
    }
    AppMethodBeat.o(72851);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aiy
 * JD-Core Version:    0.7.0.1
 */