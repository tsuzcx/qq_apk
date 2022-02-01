package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cqe
  extends com.tencent.mm.bw.a
{
  public String MvG;
  public dbl Mvx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32352);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MvG == null)
      {
        paramVarArgs = new b("Not all required fields were included: ContactUsername");
        AppMethodBeat.o(32352);
        throw paramVarArgs;
      }
      if (this.Mvx == null)
      {
        paramVarArgs = new b("Not all required fields were included: PhoneNumListInfo");
        AppMethodBeat.o(32352);
        throw paramVarArgs;
      }
      if (this.MvG != null) {
        paramVarArgs.e(1, this.MvG);
      }
      if (this.Mvx != null)
      {
        paramVarArgs.ni(2, this.Mvx.computeSize());
        this.Mvx.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32352);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MvG == null) {
        break label478;
      }
    }
    label478:
    for (paramInt = g.a.a.b.b.a.f(1, this.MvG) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Mvx != null) {
        i = paramInt + g.a.a.a.nh(2, this.Mvx.computeSize());
      }
      AppMethodBeat.o(32352);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.MvG == null)
        {
          paramVarArgs = new b("Not all required fields were included: ContactUsername");
          AppMethodBeat.o(32352);
          throw paramVarArgs;
        }
        if (this.Mvx == null)
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cqe localcqe = (cqe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32352);
          return -1;
        case 1: 
          localcqe.MvG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32352);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dbl();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dbl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcqe.Mvx = ((dbl)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqe
 * JD-Core Version:    0.7.0.1
 */