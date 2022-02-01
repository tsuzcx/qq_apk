package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cmf
  extends com.tencent.mm.bw.a
{
  public cmg MrA;
  public cme MrB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133177);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MrA == null)
      {
        paramVarArgs = new b("Not all required fields were included: RsaReqData");
        AppMethodBeat.o(133177);
        throw paramVarArgs;
      }
      if (this.MrB == null)
      {
        paramVarArgs = new b("Not all required fields were included: AesReqData");
        AppMethodBeat.o(133177);
        throw paramVarArgs;
      }
      if (this.MrA != null)
      {
        paramVarArgs.ni(1, this.MrA.computeSize());
        this.MrA.writeFields(paramVarArgs);
      }
      if (this.MrB != null)
      {
        paramVarArgs.ni(2, this.MrB.computeSize());
        this.MrB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133177);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MrA == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = g.a.a.a.nh(1, this.MrA.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MrB != null) {
        i = paramInt + g.a.a.a.nh(2, this.MrB.computeSize());
      }
      AppMethodBeat.o(133177);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.MrA == null)
        {
          paramVarArgs = new b("Not all required fields were included: RsaReqData");
          AppMethodBeat.o(133177);
          throw paramVarArgs;
        }
        if (this.MrB == null)
        {
          paramVarArgs = new b("Not all required fields were included: AesReqData");
          AppMethodBeat.o(133177);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133177);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cmf localcmf = (cmf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133177);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcmf.MrA = ((cmg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133177);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cme();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cme)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcmf.MrB = ((cme)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133177);
        return 0;
      }
      AppMethodBeat.o(133177);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmf
 * JD-Core Version:    0.7.0.1
 */