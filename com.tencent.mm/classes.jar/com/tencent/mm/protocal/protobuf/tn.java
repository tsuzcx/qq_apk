package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class tn
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
  
  public tn()
  {
    AppMethodBeat.i(72845);
    this.wLY = new LinkedList();
    this.wLZ = new LinkedList();
    this.wMa = new LinkedList();
    AppMethodBeat.o(72845);
  }
  
  public final int getRet()
  {
    return this.Ret;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72846);
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
      if (this.wMe != null)
      {
        paramVarArgs.iQ(11, this.wMe.computeSize());
        this.wMe.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72846);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.Ret) + 0 + e.a.a.b.b.a.bl(2, this.wLV) + e.a.a.b.b.a.bl(3, this.wLW) + e.a.a.b.b.a.bl(4, this.wLX) + e.a.a.a.c(5, 8, this.wLY) + e.a.a.a.c(6, 8, this.wLZ) + e.a.a.a.c(7, 8, this.wMa) + e.a.a.b.b.a.bl(8, this.wMb) + e.a.a.b.b.a.bl(9, this.wMc) + e.a.a.b.b.a.bl(10, this.wMd);
      paramInt = i;
      if (this.wMe != null) {
        paramInt = i + e.a.a.a.iP(11, this.wMe.computeSize());
      }
      AppMethodBeat.o(72846);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wLY.clear();
      this.wLZ.clear();
      this.wMa.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(72846);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      tn localtn = (tn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(72846);
        return -1;
      case 1: 
        localtn.Ret = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72846);
        return 0;
      case 2: 
        localtn.wLV = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72846);
        return 0;
      case 3: 
        localtn.wLW = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72846);
        return 0;
      case 4: 
        localtn.wLX = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72846);
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
          localtn.wLY.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72846);
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
          localtn.wLZ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72846);
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
          localtn.wMa.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72846);
        return 0;
      case 8: 
        localtn.wMb = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72846);
        return 0;
      case 9: 
        localtn.wMc = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72846);
        return 0;
      case 10: 
        localtn.wMd = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72846);
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
        localtn.wMe = ((auw)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(72846);
      return 0;
    }
    AppMethodBeat.o(72846);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tn
 * JD-Core Version:    0.7.0.1
 */