package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dod
  extends dyy
{
  public com.tencent.mm.cd.b SpV;
  public cma TVn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(274775);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(274775);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.SpV != null) {
        paramVarArgs.c(2, this.SpV);
      }
      if (this.TVn != null)
      {
        paramVarArgs.oE(100, this.TVn.computeSize());
        this.TVn.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(274775);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label538;
      }
    }
    label538:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SpV != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.SpV);
      }
      i = paramInt;
      if (this.TVn != null) {
        i = paramInt + g.a.a.a.oD(100, this.TVn.computeSize());
      }
      AppMethodBeat.o(274775);
      return i;
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
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(274775);
          throw paramVarArgs;
        }
        AppMethodBeat.o(274775);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dod localdod = (dod)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(274775);
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
            localdod.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(274775);
          return 0;
        case 2: 
          localdod.SpV = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(274775);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cma();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cma)localObject2).parseFrom((byte[])localObject1);
          }
          localdod.TVn = ((cma)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(274775);
        return 0;
      }
      AppMethodBeat.o(274775);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dod
 * JD-Core Version:    0.7.0.1
 */