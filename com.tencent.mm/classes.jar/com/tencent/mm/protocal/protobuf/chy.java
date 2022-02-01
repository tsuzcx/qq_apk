package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class chy
  extends dyy
{
  public duq Tpb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6411);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(6411);
        throw paramVarArgs;
      }
      if (this.Tpb == null)
      {
        paramVarArgs = new b("Not all required fields were included: GroupList");
        AppMethodBeat.o(6411);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Tpb != null)
      {
        paramVarArgs.oE(2, this.Tpb.computeSize());
        this.Tpb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(6411);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label530;
      }
    }
    label530:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Tpb != null) {
        i = paramInt + g.a.a.a.oD(2, this.Tpb.computeSize());
      }
      AppMethodBeat.o(6411);
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
          AppMethodBeat.o(6411);
          throw paramVarArgs;
        }
        if (this.Tpb == null)
        {
          paramVarArgs = new b("Not all required fields were included: GroupList");
          AppMethodBeat.o(6411);
          throw paramVarArgs;
        }
        AppMethodBeat.o(6411);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        chy localchy = (chy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6411);
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
            localchy.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(6411);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new duq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((duq)localObject2).parseFrom((byte[])localObject1);
          }
          localchy.Tpb = ((duq)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(6411);
        return 0;
      }
      AppMethodBeat.o(6411);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chy
 * JD-Core Version:    0.7.0.1
 */