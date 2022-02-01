package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class brb
  extends com.tencent.mm.bx.a
{
  public cal DOD;
  public String DOL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32352);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DOL == null)
      {
        paramVarArgs = new b("Not all required fields were included: ContactUsername");
        AppMethodBeat.o(32352);
        throw paramVarArgs;
      }
      if (this.DOD == null)
      {
        paramVarArgs = new b("Not all required fields were included: PhoneNumListInfo");
        AppMethodBeat.o(32352);
        throw paramVarArgs;
      }
      if (this.DOL != null) {
        paramVarArgs.d(1, this.DOL);
      }
      if (this.DOD != null)
      {
        paramVarArgs.kX(2, this.DOD.computeSize());
        this.DOD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32352);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DOL == null) {
        break label478;
      }
    }
    label478:
    for (paramInt = f.a.a.b.b.a.e(1, this.DOL) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DOD != null) {
        i = paramInt + f.a.a.a.kW(2, this.DOD.computeSize());
      }
      AppMethodBeat.o(32352);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.DOL == null)
        {
          paramVarArgs = new b("Not all required fields were included: ContactUsername");
          AppMethodBeat.o(32352);
          throw paramVarArgs;
        }
        if (this.DOD == null)
        {
          paramVarArgs = new b("Not all required fields were included: PhoneNumListInfo");
          AppMethodBeat.o(32352);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32352);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        brb localbrb = (brb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32352);
          return -1;
        case 1: 
          localbrb.DOL = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32352);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cal();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cal)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbrb.DOD = ((cal)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32352);
        return 0;
      }
      AppMethodBeat.o(32352);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brb
 * JD-Core Version:    0.7.0.1
 */