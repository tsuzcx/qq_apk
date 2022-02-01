package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class anw
  extends com.tencent.mm.bx.a
{
  public anx Zvw;
  public anv Zvx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152539);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Zvw == null)
      {
        paramVarArgs = new b("Not all required fields were included: RsaReqData");
        AppMethodBeat.o(152539);
        throw paramVarArgs;
      }
      if (this.Zvx == null)
      {
        paramVarArgs = new b("Not all required fields were included: AesReqData");
        AppMethodBeat.o(152539);
        throw paramVarArgs;
      }
      if (this.Zvw != null)
      {
        paramVarArgs.qD(1, this.Zvw.computeSize());
        this.Zvw.writeFields(paramVarArgs);
      }
      if (this.Zvx != null)
      {
        paramVarArgs.qD(2, this.Zvx.computeSize());
        this.Zvx.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152539);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Zvw == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = i.a.a.a.qC(1, this.Zvw.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Zvx != null) {
        i = paramInt + i.a.a.a.qC(2, this.Zvx.computeSize());
      }
      AppMethodBeat.o(152539);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.Zvw == null)
        {
          paramVarArgs = new b("Not all required fields were included: RsaReqData");
          AppMethodBeat.o(152539);
          throw paramVarArgs;
        }
        if (this.Zvx == null)
        {
          paramVarArgs = new b("Not all required fields were included: AesReqData");
          AppMethodBeat.o(152539);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152539);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        anw localanw = (anw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152539);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new anx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((anx)localObject2).parseFrom((byte[])localObject1);
            }
            localanw.Zvw = ((anx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152539);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new anv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((anv)localObject2).parseFrom((byte[])localObject1);
          }
          localanw.Zvx = ((anv)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(152539);
        return 0;
      }
      AppMethodBeat.o(152539);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anw
 * JD-Core Version:    0.7.0.1
 */