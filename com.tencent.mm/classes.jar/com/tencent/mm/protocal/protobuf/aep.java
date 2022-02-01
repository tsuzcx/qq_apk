package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class aep
  extends dyy
{
  public boolean RLw;
  public String RLx;
  public crq Src;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(201319);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(201319);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Src != null)
      {
        paramVarArgs.oE(2, this.Src.computeSize());
        this.Src.writeFields(paramVarArgs);
      }
      paramVarArgs.co(3, this.RLw);
      if (this.RLx != null) {
        paramVarArgs.f(4, this.RLx);
      }
      AppMethodBeat.o(201319);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label570;
      }
    }
    label570:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Src != null) {
        i = paramInt + g.a.a.a.oD(2, this.Src.computeSize());
      }
      i += g.a.a.b.b.a.gL(3) + 1;
      paramInt = i;
      if (this.RLx != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RLx);
      }
      AppMethodBeat.o(201319);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(201319);
          throw paramVarArgs;
        }
        AppMethodBeat.o(201319);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aep localaep = (aep)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(201319);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localaep.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(201319);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new crq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((crq)localObject2).parseFrom((byte[])localObject1);
            }
            localaep.Src = ((crq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(201319);
          return 0;
        case 3: 
          localaep.RLw = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(201319);
          return 0;
        }
        localaep.RLx = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(201319);
        return 0;
      }
      AppMethodBeat.o(201319);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aep
 * JD-Core Version:    0.7.0.1
 */