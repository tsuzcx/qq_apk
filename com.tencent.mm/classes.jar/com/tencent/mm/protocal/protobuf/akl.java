package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class akl
  extends dyl
{
  public zl Svq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152538);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Svq == null)
      {
        paramVarArgs = new b("Not all required fields were included: CheckResUpdateReq");
        AppMethodBeat.o(152538);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Svq != null)
      {
        paramVarArgs.oE(2, this.Svq.computeSize());
        this.Svq.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152538);
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
      if (this.Svq != null) {
        i = paramInt + g.a.a.a.oD(2, this.Svq.computeSize());
      }
      AppMethodBeat.o(152538);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Svq == null)
        {
          paramVarArgs = new b("Not all required fields were included: CheckResUpdateReq");
          AppMethodBeat.o(152538);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152538);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        akl localakl = (akl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152538);
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
            localakl.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152538);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new zl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((zl)localObject2).parseFrom((byte[])localObject1);
          }
          localakl.Svq = ((zl)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(152538);
        return 0;
      }
      AppMethodBeat.o(152538);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akl
 * JD-Core Version:    0.7.0.1
 */