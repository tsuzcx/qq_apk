package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dfv
  extends com.tencent.mm.bw.a
{
  public cxn HMU;
  public cxn HMW;
  public int HMX;
  public int ucK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125764);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HMU != null)
      {
        paramVarArgs.lJ(1, this.HMU.computeSize());
        this.HMU.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ucK);
      if (this.HMW != null)
      {
        paramVarArgs.lJ(3, this.HMW.computeSize());
        this.HMW.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.HMX);
      AppMethodBeat.o(125764);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HMU == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = f.a.a.a.lI(1, this.HMU.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ucK);
      paramInt = i;
      if (this.HMW != null) {
        paramInt = i + f.a.a.a.lI(3, this.HMW.computeSize());
      }
      i = f.a.a.b.b.a.bz(4, this.HMX);
      AppMethodBeat.o(125764);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(125764);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dfv localdfv = (dfv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125764);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdfv.HMU = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125764);
          return 0;
        case 2: 
          localdfv.ucK = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125764);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdfv.HMW = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125764);
          return 0;
        }
        localdfv.HMX = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125764);
        return 0;
      }
      AppMethodBeat.o(125764);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfv
 * JD-Core Version:    0.7.0.1
 */