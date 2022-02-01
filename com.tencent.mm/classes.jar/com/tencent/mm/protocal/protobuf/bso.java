package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bso
  extends dyy
{
  public String TcP;
  public xm TcQ;
  public int rVu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101815);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(101815);
        throw paramVarArgs;
      }
      if (this.TcQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: NewChatroomData");
        AppMethodBeat.o(101815);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.TcP != null) {
        paramVarArgs.f(2, this.TcP);
      }
      paramVarArgs.aY(3, this.rVu);
      if (this.TcQ != null)
      {
        paramVarArgs.oE(4, this.TcQ.computeSize());
        this.TcQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(101815);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label622;
      }
    }
    label622:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TcP != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.TcP);
      }
      i += g.a.a.b.b.a.bM(3, this.rVu);
      paramInt = i;
      if (this.TcQ != null) {
        paramInt = i + g.a.a.a.oD(4, this.TcQ.computeSize());
      }
      AppMethodBeat.o(101815);
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
          AppMethodBeat.o(101815);
          throw paramVarArgs;
        }
        if (this.TcQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: NewChatroomData");
          AppMethodBeat.o(101815);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101815);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bso localbso = (bso)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101815);
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
            localbso.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101815);
          return 0;
        case 2: 
          localbso.TcP = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(101815);
          return 0;
        case 3: 
          localbso.rVu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(101815);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new xm();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((xm)localObject2).parseFrom((byte[])localObject1);
          }
          localbso.TcQ = ((xm)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(101815);
        return 0;
      }
      AppMethodBeat.o(101815);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bso
 * JD-Core Version:    0.7.0.1
 */