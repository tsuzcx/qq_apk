package com.tencent.mm.t.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.jh;
import g.a.a.b;
import java.util.LinkedList;

public final class h
  extends dyy
{
  public String jDM;
  public n jDO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(249339);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(249339);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.jDM != null) {
        paramVarArgs.f(2, this.jDM);
      }
      if (this.jDO != null)
      {
        paramVarArgs.oE(3, this.jDO.computeSize());
        this.jDO.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(249339);
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
      if (this.jDM != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.jDM);
      }
      i = paramInt;
      if (this.jDO != null) {
        i = paramInt + g.a.a.a.oD(3, this.jDO.computeSize());
      }
      AppMethodBeat.o(249339);
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
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(249339);
          throw paramVarArgs;
        }
        AppMethodBeat.o(249339);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        h localh = (h)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(249339);
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
            localh.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(249339);
          return 0;
        case 2: 
          localh.jDM = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(249339);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new n();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((n)localObject2).parseFrom((byte[])localObject1);
          }
          localh.jDO = ((n)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(249339);
        return 0;
      }
      AppMethodBeat.o(249339);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.t.a.h
 * JD-Core Version:    0.7.0.1
 */