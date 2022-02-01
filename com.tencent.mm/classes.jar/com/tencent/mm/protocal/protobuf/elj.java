package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class elj
  extends erp
{
  public enf abpT;
  public emy abpU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50098);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.abpT != null)
      {
        paramVarArgs.qD(2, this.abpT.computeSize());
        this.abpT.writeFields(paramVarArgs);
      }
      if (this.abpU != null)
      {
        paramVarArgs.qD(3, this.abpU.computeSize());
        this.abpU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(50098);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label548;
      }
    }
    label548:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abpT != null) {
        paramInt = i + i.a.a.a.qC(2, this.abpT.computeSize());
      }
      i = paramInt;
      if (this.abpU != null) {
        i = paramInt + i.a.a.a.qC(3, this.abpU.computeSize());
      }
      AppMethodBeat.o(50098);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(50098);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        elj localelj = (elj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(50098);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localelj.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(50098);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new enf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((enf)localObject2).parseFrom((byte[])localObject1);
            }
            localelj.abpT = ((enf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(50098);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new emy();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((emy)localObject2).parseFrom((byte[])localObject1);
          }
          localelj.abpU = ((emy)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(50098);
        return 0;
      }
      AppMethodBeat.o(50098);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.elj
 * JD-Core Version:    0.7.0.1
 */