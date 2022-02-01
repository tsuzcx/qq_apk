package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fuy
  extends com.tencent.mm.bx.a
{
  public fva abSO;
  public fux abSP;
  public fuz abSQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258900);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abSO != null)
      {
        paramVarArgs.qD(1, this.abSO.computeSize());
        this.abSO.writeFields(paramVarArgs);
      }
      if (this.abSP != null)
      {
        paramVarArgs.qD(2, this.abSP.computeSize());
        this.abSP.writeFields(paramVarArgs);
      }
      if (this.abSQ != null)
      {
        paramVarArgs.qD(3, this.abSQ.computeSize());
        this.abSQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258900);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abSO == null) {
        break label548;
      }
    }
    label548:
    for (int i = i.a.a.a.qC(1, this.abSO.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abSP != null) {
        paramInt = i + i.a.a.a.qC(2, this.abSP.computeSize());
      }
      i = paramInt;
      if (this.abSQ != null) {
        i = paramInt + i.a.a.a.qC(3, this.abSQ.computeSize());
      }
      AppMethodBeat.o(258900);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258900);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fuy localfuy = (fuy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258900);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fva();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fva)localObject2).parseFrom((byte[])localObject1);
            }
            localfuy.abSO = ((fva)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258900);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fux();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fux)localObject2).parseFrom((byte[])localObject1);
            }
            localfuy.abSP = ((fux)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258900);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fuz();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fuz)localObject2).parseFrom((byte[])localObject1);
          }
          localfuy.abSQ = ((fuz)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258900);
        return 0;
      }
      AppMethodBeat.o(258900);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fuy
 * JD-Core Version:    0.7.0.1
 */