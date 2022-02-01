package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class dyf
  extends com.tencent.mm.bx.a
{
  public int CaS;
  public ctc HKR;
  public aev HKS;
  public int HKT;
  public LinkedList<Integer> HKU;
  public int HKV;
  public LinkedList<Integer> HKW;
  public ctc HKX;
  
  public dyf()
  {
    AppMethodBeat.i(115897);
    this.HKU = new LinkedList();
    this.HKW = new LinkedList();
    AppMethodBeat.o(115897);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115898);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HKR != null)
      {
        paramVarArgs.lC(1, this.HKR.computeSize());
        this.HKR.writeFields(paramVarArgs);
      }
      if (this.HKS != null)
      {
        paramVarArgs.lC(2, this.HKS.computeSize());
        this.HKS.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.HKT);
      paramVarArgs.f(4, 2, this.HKU);
      paramVarArgs.aS(5, this.HKV);
      paramVarArgs.f(6, 2, this.HKW);
      paramVarArgs.aS(7, this.CaS);
      if (this.HKX != null)
      {
        paramVarArgs.lC(8, this.HKX.computeSize());
        this.HKX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115898);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HKR == null) {
        break label896;
      }
    }
    label896:
    for (paramInt = f.a.a.a.lB(1, this.HKR.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HKS != null) {
        i = paramInt + f.a.a.a.lB(2, this.HKS.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(3, this.HKT) + f.a.a.a.d(4, 2, this.HKU) + f.a.a.b.b.a.bz(5, this.HKV) + f.a.a.a.d(6, 2, this.HKW) + f.a.a.b.b.a.bz(7, this.CaS);
      paramInt = i;
      if (this.HKX != null) {
        paramInt = i + f.a.a.a.lB(8, this.HKX.computeSize());
      }
      AppMethodBeat.o(115898);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HKU.clear();
        this.HKW.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(115898);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dyf localdyf = (dyf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115898);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyf.HKR = ((ctc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115898);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aev();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aev)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyf.HKS = ((aev)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115898);
          return 0;
        case 3: 
          localdyf.HKT = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115898);
          return 0;
        case 4: 
          localdyf.HKU = new f.a.a.a.a(((f.a.a.a.a)localObject1).NPN.gxI().zr, unknownTagHandler).NPN.gxG();
          AppMethodBeat.o(115898);
          return 0;
        case 5: 
          localdyf.HKV = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115898);
          return 0;
        case 6: 
          localdyf.HKW = new f.a.a.a.a(((f.a.a.a.a)localObject1).NPN.gxI().zr, unknownTagHandler).NPN.gxG();
          AppMethodBeat.o(115898);
          return 0;
        case 7: 
          localdyf.CaS = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115898);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ctc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ctc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdyf.HKX = ((ctc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115898);
        return 0;
      }
      AppMethodBeat.o(115898);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyf
 * JD-Core Version:    0.7.0.1
 */