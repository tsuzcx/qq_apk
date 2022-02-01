package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class erj
  extends erp
{
  public String Ide;
  public dlc abvi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147774);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.abvi != null)
      {
        paramVarArgs.qD(2, this.abvi.computeSize());
        this.abvi.writeFields(paramVarArgs);
      }
      if (this.Ide != null) {
        paramVarArgs.g(3, this.Ide);
      }
      AppMethodBeat.o(147774);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label478;
      }
    }
    label478:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abvi != null) {
        paramInt = i + i.a.a.a.qC(2, this.abvi.computeSize());
      }
      i = paramInt;
      if (this.Ide != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Ide);
      }
      AppMethodBeat.o(147774);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(147774);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        erj localerj = (erj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147774);
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
            localerj.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(147774);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dlc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dlc)localObject2).parseFrom((byte[])localObject1);
            }
            localerj.abvi = ((dlc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(147774);
          return 0;
        }
        localerj.Ide = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(147774);
        return 0;
      }
      AppMethodBeat.o(147774);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.erj
 * JD-Core Version:    0.7.0.1
 */