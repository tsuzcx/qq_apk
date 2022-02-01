package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class abs
  extends esc
{
  public boolean Zkl;
  public boolean Zkm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258284);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.di(2, this.Zkl);
      paramVarArgs.di(3, this.Zkm);
      AppMethodBeat.o(258284);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label372;
      }
    }
    label372:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.ko(2);
      int j = i.a.a.b.b.a.ko(3);
      AppMethodBeat.o(258284);
      return paramInt + (i + 1) + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258284);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        abs localabs = (abs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258284);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kd localkd = new kd();
            if ((localObject != null) && (localObject.length > 0)) {
              localkd.parseFrom((byte[])localObject);
            }
            localabs.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(258284);
          return 0;
        case 2: 
          localabs.Zkl = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(258284);
          return 0;
        }
        localabs.Zkm = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(258284);
        return 0;
      }
      AppMethodBeat.o(258284);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abs
 * JD-Core Version:    0.7.0.1
 */