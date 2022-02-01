package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cqy
  extends esc
{
  public int aaxB;
  public int aaxC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258842);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(258842);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.aaxB);
      paramVarArgs.bS(3, this.aaxC);
      AppMethodBeat.o(258842);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label424;
      }
    }
    label424:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.aaxB);
      int j = i.a.a.b.b.a.cJ(3, this.aaxC);
      AppMethodBeat.o(258842);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(258842);
          throw paramVarArgs;
        }
        AppMethodBeat.o(258842);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cqy localcqy = (cqy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258842);
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
            localcqy.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(258842);
          return 0;
        case 2: 
          localcqy.aaxB = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258842);
          return 0;
        }
        localcqy.aaxC = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258842);
        return 0;
      }
      AppMethodBeat.o(258842);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqy
 * JD-Core Version:    0.7.0.1
 */