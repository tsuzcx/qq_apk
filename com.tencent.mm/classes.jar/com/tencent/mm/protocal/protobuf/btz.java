package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class btz
  extends dyy
{
  public ajt Tea;
  public ake Teb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104790);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104790);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Tea != null)
      {
        paramVarArgs.oE(2, this.Tea.computeSize());
        this.Tea.writeFields(paramVarArgs);
      }
      if (this.Teb != null)
      {
        paramVarArgs.oE(3, this.Teb.computeSize());
        this.Teb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(104790);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label600;
      }
    }
    label600:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Tea != null) {
        paramInt = i + g.a.a.a.oD(2, this.Tea.computeSize());
      }
      i = paramInt;
      if (this.Teb != null) {
        i = paramInt + g.a.a.a.oD(3, this.Teb.computeSize());
      }
      AppMethodBeat.o(104790);
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
          AppMethodBeat.o(104790);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104790);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        btz localbtz = (btz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104790);
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
            localbtz.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104790);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ajt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ajt)localObject2).parseFrom((byte[])localObject1);
            }
            localbtz.Tea = ((ajt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104790);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ake();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ake)localObject2).parseFrom((byte[])localObject1);
          }
          localbtz.Teb = ((ake)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(104790);
        return 0;
      }
      AppMethodBeat.o(104790);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btz
 * JD-Core Version:    0.7.0.1
 */