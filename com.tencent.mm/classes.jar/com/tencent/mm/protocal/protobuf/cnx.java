package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cnx
  extends dyy
{
  public com.tencent.mm.cd.b RLO;
  public crw SJL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200300);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(200300);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.RLO != null) {
        paramVarArgs.c(2, this.RLO);
      }
      if (this.SJL != null)
      {
        paramVarArgs.oE(3, this.SJL.computeSize());
        this.SJL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(200300);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label530;
      }
    }
    label530:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RLO != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.RLO);
      }
      i = paramInt;
      if (this.SJL != null) {
        i = paramInt + g.a.a.a.oD(3, this.SJL.computeSize());
      }
      AppMethodBeat.o(200300);
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
          AppMethodBeat.o(200300);
          throw paramVarArgs;
        }
        AppMethodBeat.o(200300);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cnx localcnx = (cnx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(200300);
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
            localcnx.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(200300);
          return 0;
        case 2: 
          localcnx.RLO = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(200300);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new crw();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((crw)localObject2).parseFrom((byte[])localObject1);
          }
          localcnx.SJL = ((crw)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(200300);
        return 0;
      }
      AppMethodBeat.o(200300);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnx
 * JD-Core Version:    0.7.0.1
 */