package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class elq
  extends esc
{
  public elt abqi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32397);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abqi == null)
      {
        paramVarArgs = new b("Not all required fields were included: rcptinfolist");
        AppMethodBeat.o(32397);
        throw paramVarArgs;
      }
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32397);
        throw paramVarArgs;
      }
      if (this.abqi != null)
      {
        paramVarArgs.qD(1, this.abqi.computeSize());
        this.abqi.writeFields(paramVarArgs);
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(2, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32397);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abqi == null) {
        break label526;
      }
    }
    label526:
    for (paramInt = i.a.a.a.qC(1, this.abqi.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.BaseResponse != null) {
        i = paramInt + i.a.a.a.qC(2, this.BaseResponse.computeSize());
      }
      AppMethodBeat.o(32397);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.abqi == null)
        {
          paramVarArgs = new b("Not all required fields were included: rcptinfolist");
          AppMethodBeat.o(32397);
          throw paramVarArgs;
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32397);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32397);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        elq localelq = (elq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32397);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new elt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((elt)localObject2).parseFrom((byte[])localObject1);
            }
            localelq.abqi = ((elt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32397);
          return 0;
        }
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
          localelq.BaseResponse = ((kd)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32397);
        return 0;
      }
      AppMethodBeat.o(32397);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.elq
 * JD-Core Version:    0.7.0.1
 */