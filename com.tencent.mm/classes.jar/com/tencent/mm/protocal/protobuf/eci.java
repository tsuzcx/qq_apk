package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eci
  extends dyy
{
  public ecg Uha;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152687);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152687);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Uha != null)
      {
        paramVarArgs.oE(2, this.Uha.computeSize());
        this.Uha.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.f(3, this.url);
      }
      AppMethodBeat.o(152687);
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
      if (this.Uha != null) {
        paramInt = i + g.a.a.a.oD(2, this.Uha.computeSize());
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.url);
      }
      AppMethodBeat.o(152687);
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
          AppMethodBeat.o(152687);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152687);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eci localeci = (eci)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152687);
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
            localeci.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152687);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ecg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ecg)localObject2).parseFrom((byte[])localObject1);
            }
            localeci.Uha = ((ecg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152687);
          return 0;
        }
        localeci.url = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(152687);
        return 0;
      }
      AppMethodBeat.o(152687);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eci
 * JD-Core Version:    0.7.0.1
 */