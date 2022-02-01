package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class st
  extends com.tencent.mm.bx.a
{
  public String FPM;
  public String FPN;
  public String FPO;
  public String FPP;
  public String FPQ;
  public LinkedList<ss> FPR;
  public int FPS;
  public String FPT;
  public String FPU;
  public String FPV;
  public int FPW;
  public String FPX;
  public int FPY;
  public String FPZ;
  public int FQa;
  public String FQb;
  public tg FQc;
  public String FQd;
  public String FrW;
  
  public st()
  {
    AppMethodBeat.i(113951);
    this.FPR = new LinkedList();
    AppMethodBeat.o(113951);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113952);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FrW != null) {
        paramVarArgs.d(1, this.FrW);
      }
      if (this.FPM != null) {
        paramVarArgs.d(2, this.FPM);
      }
      if (this.FPN != null) {
        paramVarArgs.d(3, this.FPN);
      }
      if (this.FPO != null) {
        paramVarArgs.d(4, this.FPO);
      }
      if (this.FPP != null) {
        paramVarArgs.d(5, this.FPP);
      }
      if (this.FPQ != null) {
        paramVarArgs.d(6, this.FPQ);
      }
      paramVarArgs.e(7, 8, this.FPR);
      paramVarArgs.aS(8, this.FPS);
      if (this.FPT != null) {
        paramVarArgs.d(9, this.FPT);
      }
      if (this.FPU != null) {
        paramVarArgs.d(10, this.FPU);
      }
      if (this.FPV != null) {
        paramVarArgs.d(11, this.FPV);
      }
      paramVarArgs.aS(12, this.FPW);
      if (this.FPX != null) {
        paramVarArgs.d(13, this.FPX);
      }
      paramVarArgs.aS(14, this.FPY);
      if (this.FPZ != null) {
        paramVarArgs.d(15, this.FPZ);
      }
      paramVarArgs.aS(16, this.FQa);
      if (this.FQb != null) {
        paramVarArgs.d(17, this.FQb);
      }
      if (this.FQc != null)
      {
        paramVarArgs.lC(18, this.FQc.computeSize());
        this.FQc.writeFields(paramVarArgs);
      }
      if (this.FQd != null) {
        paramVarArgs.d(19, this.FQd);
      }
      AppMethodBeat.o(113952);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FrW == null) {
        break label1434;
      }
    }
    label1434:
    for (int i = f.a.a.b.b.a.e(1, this.FrW) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FPM != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FPM);
      }
      i = paramInt;
      if (this.FPN != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FPN);
      }
      paramInt = i;
      if (this.FPO != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FPO);
      }
      i = paramInt;
      if (this.FPP != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FPP);
      }
      paramInt = i;
      if (this.FPQ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FPQ);
      }
      i = paramInt + f.a.a.a.c(7, 8, this.FPR) + f.a.a.b.b.a.bz(8, this.FPS);
      paramInt = i;
      if (this.FPT != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.FPT);
      }
      i = paramInt;
      if (this.FPU != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.FPU);
      }
      paramInt = i;
      if (this.FPV != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.FPV);
      }
      i = paramInt + f.a.a.b.b.a.bz(12, this.FPW);
      paramInt = i;
      if (this.FPX != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.FPX);
      }
      i = paramInt + f.a.a.b.b.a.bz(14, this.FPY);
      paramInt = i;
      if (this.FPZ != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.FPZ);
      }
      i = paramInt + f.a.a.b.b.a.bz(16, this.FQa);
      paramInt = i;
      if (this.FQb != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.FQb);
      }
      i = paramInt;
      if (this.FQc != null) {
        i = paramInt + f.a.a.a.lB(18, this.FQc.computeSize());
      }
      paramInt = i;
      if (this.FQd != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.FQd);
      }
      AppMethodBeat.o(113952);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FPR.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(113952);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        st localst = (st)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113952);
          return -1;
        case 1: 
          localst.FrW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 2: 
          localst.FPM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 3: 
          localst.FPN = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 4: 
          localst.FPO = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 5: 
          localst.FPP = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 6: 
          localst.FPQ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ss();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ss)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localst.FPR.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113952);
          return 0;
        case 8: 
          localst.FPS = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(113952);
          return 0;
        case 9: 
          localst.FPT = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 10: 
          localst.FPU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 11: 
          localst.FPV = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 12: 
          localst.FPW = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(113952);
          return 0;
        case 13: 
          localst.FPX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 14: 
          localst.FPY = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(113952);
          return 0;
        case 15: 
          localst.FPZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 16: 
          localst.FQa = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(113952);
          return 0;
        case 17: 
          localst.FQb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 18: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((tg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localst.FQc = ((tg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113952);
          return 0;
        }
        localst.FQd = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(113952);
        return 0;
      }
      AppMethodBeat.o(113952);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.st
 * JD-Core Version:    0.7.0.1
 */