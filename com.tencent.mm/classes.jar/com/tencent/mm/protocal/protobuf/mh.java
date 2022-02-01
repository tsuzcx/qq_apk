package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class mh
  extends esc
{
  public mi YND;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110890);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(110890);
        throw paramVarArgs;
      }
      if (this.YND == null)
      {
        paramVarArgs = new b("Not all required fields were included: vlogresp");
        AppMethodBeat.o(110890);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.YND != null)
      {
        paramVarArgs.qD(2, this.YND.computeSize());
        this.YND.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110890);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YND != null) {
        i = paramInt + i.a.a.a.qC(2, this.YND.computeSize());
      }
      AppMethodBeat.o(110890);
      return i;
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
          AppMethodBeat.o(110890);
          throw paramVarArgs;
        }
        if (this.YND == null)
        {
          paramVarArgs = new b("Not all required fields were included: vlogresp");
          AppMethodBeat.o(110890);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110890);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        mh localmh = (mh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110890);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localmh.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(110890);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new mi();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((mi)localObject2).parseFrom((byte[])localObject1);
          }
          localmh.YND = ((mi)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(110890);
        return 0;
      }
      AppMethodBeat.o(110890);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mh
 * JD-Core Version:    0.7.0.1
 */