package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bl
  extends com.tencent.mm.bx.a
{
  public fmp YCT;
  public fmp YCU;
  public etg YCV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91342);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YCT != null)
      {
        paramVarArgs.qD(1, this.YCT.computeSize());
        this.YCT.writeFields(paramVarArgs);
      }
      if (this.YCU != null)
      {
        paramVarArgs.qD(2, this.YCU.computeSize());
        this.YCU.writeFields(paramVarArgs);
      }
      if (this.YCV != null)
      {
        paramVarArgs.qD(3, this.YCV.computeSize());
        this.YCV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91342);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YCT == null) {
        break label548;
      }
    }
    label548:
    for (int i = i.a.a.a.qC(1, this.YCT.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YCU != null) {
        paramInt = i + i.a.a.a.qC(2, this.YCU.computeSize());
      }
      i = paramInt;
      if (this.YCV != null) {
        i = paramInt + i.a.a.a.qC(3, this.YCV.computeSize());
      }
      AppMethodBeat.o(91342);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91342);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bl localbl = (bl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91342);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fmp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fmp)localObject2).parseFrom((byte[])localObject1);
            }
            localbl.YCT = ((fmp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91342);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fmp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fmp)localObject2).parseFrom((byte[])localObject1);
            }
            localbl.YCU = ((fmp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91342);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new etg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((etg)localObject2).parseFrom((byte[])localObject1);
          }
          localbl.YCV = ((etg)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91342);
        return 0;
      }
      AppMethodBeat.o(91342);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bl
 * JD-Core Version:    0.7.0.1
 */