package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ekq
  extends com.tencent.mm.cd.a
{
  public SnsObject Ulb;
  public eaf Umx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125809);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Ulb == null)
      {
        paramVarArgs = new b("Not all required fields were included: SnsObject");
        AppMethodBeat.o(125809);
        throw paramVarArgs;
      }
      if (this.Ulb != null)
      {
        paramVarArgs.oE(1, this.Ulb.computeSize());
        this.Ulb.writeFields(paramVarArgs);
      }
      if (this.Umx != null)
      {
        paramVarArgs.oE(2, this.Umx.computeSize());
        this.Umx.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125809);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ulb == null) {
        break label470;
      }
    }
    label470:
    for (paramInt = g.a.a.a.oD(1, this.Ulb.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Umx != null) {
        i = paramInt + g.a.a.a.oD(2, this.Umx.computeSize());
      }
      AppMethodBeat.o(125809);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Ulb == null)
        {
          paramVarArgs = new b("Not all required fields were included: SnsObject");
          AppMethodBeat.o(125809);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125809);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ekq localekq = (ekq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125809);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new SnsObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((SnsObject)localObject2).parseFrom((byte[])localObject1);
            }
            localekq.Ulb = ((SnsObject)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125809);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eaf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eaf)localObject2).de((byte[])localObject1);
          }
          localekq.Umx = ((eaf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125809);
        return 0;
      }
      AppMethodBeat.o(125809);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ekq
 * JD-Core Version:    0.7.0.1
 */