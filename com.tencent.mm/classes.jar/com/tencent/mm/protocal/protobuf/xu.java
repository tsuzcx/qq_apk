package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class xu
  extends dyy
{
  public String RJv;
  public lk Skd;
  public ek Ske;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258832);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(258832);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.RJv != null) {
        paramVarArgs.f(2, this.RJv);
      }
      if (this.Skd != null)
      {
        paramVarArgs.oE(3, this.Skd.computeSize());
        this.Skd.writeFields(paramVarArgs);
      }
      if (this.Ske != null)
      {
        paramVarArgs.oE(4, this.Ske.computeSize());
        this.Ske.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258832);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label660;
      }
    }
    label660:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RJv != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RJv);
      }
      i = paramInt;
      if (this.Skd != null) {
        i = paramInt + g.a.a.a.oD(3, this.Skd.computeSize());
      }
      paramInt = i;
      if (this.Ske != null) {
        paramInt = i + g.a.a.a.oD(4, this.Ske.computeSize());
      }
      AppMethodBeat.o(258832);
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
          AppMethodBeat.o(258832);
          throw paramVarArgs;
        }
        AppMethodBeat.o(258832);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        xu localxu = (xu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258832);
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
            localxu.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258832);
          return 0;
        case 2: 
          localxu.RJv = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(258832);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new lk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((lk)localObject2).parseFrom((byte[])localObject1);
            }
            localxu.Skd = ((lk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258832);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ek();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ek)localObject2).parseFrom((byte[])localObject1);
          }
          localxu.Ske = ((ek)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258832);
        return 0;
      }
      AppMethodBeat.o(258832);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xu
 * JD-Core Version:    0.7.0.1
 */