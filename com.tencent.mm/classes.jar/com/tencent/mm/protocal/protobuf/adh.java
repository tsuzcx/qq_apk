package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class adh
  extends com.tencent.mm.bw.a
{
  public cxn GuF;
  public int GuI;
  public long xrk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43091);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GuF == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(43091);
        throw paramVarArgs;
      }
      if (this.GuF != null)
      {
        paramVarArgs.lJ(1, this.GuF.computeSize());
        this.GuF.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GuI);
      paramVarArgs.aZ(3, this.xrk);
      AppMethodBeat.o(43091);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GuF == null) {
        break label450;
      }
    }
    label450:
    for (paramInt = f.a.a.a.lI(1, this.GuF.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.GuI);
      int j = f.a.a.b.b.a.p(3, this.xrk);
      AppMethodBeat.o(43091);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.GuF == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(43091);
          throw paramVarArgs;
        }
        AppMethodBeat.o(43091);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        adh localadh = (adh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(43091);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localadh.GuF = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43091);
          return 0;
        case 2: 
          localadh.GuI = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(43091);
          return 0;
        }
        localadh.xrk = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(43091);
        return 0;
      }
      AppMethodBeat.o(43091);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adh
 * JD-Core Version:    0.7.0.1
 */