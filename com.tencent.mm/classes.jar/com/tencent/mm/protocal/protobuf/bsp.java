package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bsp
  extends com.tencent.mm.bx.a
{
  public dbp Cvo;
  public bsr DPM;
  public bsq DPN;
  public bsq DPO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91550);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Cvo != null)
      {
        paramVarArgs.kX(1, this.Cvo.computeSize());
        this.Cvo.writeFields(paramVarArgs);
      }
      if (this.DPM != null)
      {
        paramVarArgs.kX(2, this.DPM.computeSize());
        this.DPM.writeFields(paramVarArgs);
      }
      if (this.DPN != null)
      {
        paramVarArgs.kX(3, this.DPN.computeSize());
        this.DPN.writeFields(paramVarArgs);
      }
      if (this.DPO != null)
      {
        paramVarArgs.kX(4, this.DPO.computeSize());
        this.DPO.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91550);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Cvo == null) {
        break label774;
      }
    }
    label774:
    for (int i = f.a.a.a.kW(1, this.Cvo.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DPM != null) {
        paramInt = i + f.a.a.a.kW(2, this.DPM.computeSize());
      }
      i = paramInt;
      if (this.DPN != null) {
        i = paramInt + f.a.a.a.kW(3, this.DPN.computeSize());
      }
      paramInt = i;
      if (this.DPO != null) {
        paramInt = i + f.a.a.a.kW(4, this.DPO.computeSize());
      }
      AppMethodBeat.o(91550);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91550);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bsp localbsp = (bsp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91550);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbsp.Cvo = ((dbp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91550);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bsr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bsr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbsp.DPM = ((bsr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91550);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bsq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bsq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbsp.DPN = ((bsq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91550);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bsq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bsq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbsp.DPO = ((bsq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91550);
        return 0;
      }
      AppMethodBeat.o(91550);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsp
 * JD-Core Version:    0.7.0.1
 */