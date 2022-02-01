package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cea
  extends dyy
{
  public String RHs;
  public eva TlG;
  public String fUL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260997);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(260997);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.fUL != null) {
        paramVarArgs.f(2, this.fUL);
      }
      if (this.RHs != null) {
        paramVarArgs.f(3, this.RHs);
      }
      if (this.TlG != null)
      {
        paramVarArgs.oE(4, this.TlG.computeSize());
        this.TlG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(260997);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label590;
      }
    }
    label590:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fUL != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.fUL);
      }
      i = paramInt;
      if (this.RHs != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RHs);
      }
      paramInt = i;
      if (this.TlG != null) {
        paramInt = i + g.a.a.a.oD(4, this.TlG.computeSize());
      }
      AppMethodBeat.o(260997);
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
          AppMethodBeat.o(260997);
          throw paramVarArgs;
        }
        AppMethodBeat.o(260997);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cea localcea = (cea)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260997);
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
            localcea.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260997);
          return 0;
        case 2: 
          localcea.fUL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(260997);
          return 0;
        case 3: 
          localcea.RHs = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(260997);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eva();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eva)localObject2).parseFrom((byte[])localObject1);
          }
          localcea.TlG = ((eva)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(260997);
        return 0;
      }
      AppMethodBeat.o(260997);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cea
 * JD-Core Version:    0.7.0.1
 */