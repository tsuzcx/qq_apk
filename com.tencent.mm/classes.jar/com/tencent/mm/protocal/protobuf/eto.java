package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eto
  extends dyl
{
  public eae Uvy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(216629);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Uvy == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppData");
        AppMethodBeat.o(216629);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Uvy != null)
      {
        paramVarArgs.oE(2, this.Uvy.computeSize());
        this.Uvy.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(216629);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label470;
      }
    }
    label470:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Uvy != null) {
        i = paramInt + g.a.a.a.oD(2, this.Uvy.computeSize());
      }
      AppMethodBeat.o(216629);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Uvy == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppData");
          AppMethodBeat.o(216629);
          throw paramVarArgs;
        }
        AppMethodBeat.o(216629);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eto localeto = (eto)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(216629);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localeto.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(216629);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eae();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eae)localObject2).dd((byte[])localObject1);
          }
          localeto.Uvy = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(216629);
        return 0;
      }
      AppMethodBeat.o(216629);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eto
 * JD-Core Version:    0.7.0.1
 */