package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bns
  extends com.tencent.mm.bx.a
{
  public iz GHP;
  public sb GHQ;
  public byu GHR;
  public dir GHS;
  public cxr GHT;
  public zw GHU;
  public akv GHV;
  public aud GHW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116471);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GHP != null)
      {
        paramVarArgs.lC(1, this.GHP.computeSize());
        this.GHP.writeFields(paramVarArgs);
      }
      if (this.GHQ != null)
      {
        paramVarArgs.lC(2, this.GHQ.computeSize());
        this.GHQ.writeFields(paramVarArgs);
      }
      if (this.GHR != null)
      {
        paramVarArgs.lC(3, this.GHR.computeSize());
        this.GHR.writeFields(paramVarArgs);
      }
      if (this.GHS != null)
      {
        paramVarArgs.lC(4, this.GHS.computeSize());
        this.GHS.writeFields(paramVarArgs);
      }
      if (this.GHT != null)
      {
        paramVarArgs.lC(6, this.GHT.computeSize());
        this.GHT.writeFields(paramVarArgs);
      }
      if (this.GHU != null)
      {
        paramVarArgs.lC(7, this.GHU.computeSize());
        this.GHU.writeFields(paramVarArgs);
      }
      if (this.GHV != null)
      {
        paramVarArgs.lC(8, this.GHV.computeSize());
        this.GHV.writeFields(paramVarArgs);
      }
      if (this.GHW != null)
      {
        paramVarArgs.lC(9, this.GHW.computeSize());
        this.GHW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(116471);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GHP == null) {
        break label1402;
      }
    }
    label1402:
    for (int i = f.a.a.a.lB(1, this.GHP.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GHQ != null) {
        paramInt = i + f.a.a.a.lB(2, this.GHQ.computeSize());
      }
      i = paramInt;
      if (this.GHR != null) {
        i = paramInt + f.a.a.a.lB(3, this.GHR.computeSize());
      }
      paramInt = i;
      if (this.GHS != null) {
        paramInt = i + f.a.a.a.lB(4, this.GHS.computeSize());
      }
      i = paramInt;
      if (this.GHT != null) {
        i = paramInt + f.a.a.a.lB(6, this.GHT.computeSize());
      }
      paramInt = i;
      if (this.GHU != null) {
        paramInt = i + f.a.a.a.lB(7, this.GHU.computeSize());
      }
      i = paramInt;
      if (this.GHV != null) {
        i = paramInt + f.a.a.a.lB(8, this.GHV.computeSize());
      }
      paramInt = i;
      if (this.GHW != null) {
        paramInt = i + f.a.a.a.lB(9, this.GHW.computeSize());
      }
      AppMethodBeat.o(116471);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(116471);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bns localbns = (bns)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(116471);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbns.GHP = ((iz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((sb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbns.GHQ = ((sb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new byu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((byu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbns.GHR = ((byu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dir();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dir)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbns.GHS = ((dir)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbns.GHT = ((cxr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new zw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((zw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbns.GHU = ((zw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new akv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((akv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbns.GHV = ((akv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aud();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aud)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbns.GHW = ((aud)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(116471);
        return 0;
      }
      AppMethodBeat.o(116471);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bns
 * JD-Core Version:    0.7.0.1
 */