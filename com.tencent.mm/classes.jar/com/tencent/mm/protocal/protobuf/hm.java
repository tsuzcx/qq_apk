package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class hm
  extends com.tencent.mm.bw.a
{
  public hn FSm;
  public hk FSn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133148);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FSm == null)
      {
        paramVarArgs = new b("Not all required fields were included: RsaReqData");
        AppMethodBeat.o(133148);
        throw paramVarArgs;
      }
      if (this.FSn == null)
      {
        paramVarArgs = new b("Not all required fields were included: AesReqData");
        AppMethodBeat.o(133148);
        throw paramVarArgs;
      }
      if (this.FSm != null)
      {
        paramVarArgs.lJ(1, this.FSm.computeSize());
        this.FSm.writeFields(paramVarArgs);
      }
      if (this.FSn != null)
      {
        paramVarArgs.lJ(2, this.FSn.computeSize());
        this.FSn.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133148);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FSm == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = f.a.a.a.lI(1, this.FSm.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FSn != null) {
        i = paramInt + f.a.a.a.lI(2, this.FSn.computeSize());
      }
      AppMethodBeat.o(133148);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.FSm == null)
        {
          paramVarArgs = new b("Not all required fields were included: RsaReqData");
          AppMethodBeat.o(133148);
          throw paramVarArgs;
        }
        if (this.FSn == null)
        {
          paramVarArgs = new b("Not all required fields were included: AesReqData");
          AppMethodBeat.o(133148);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133148);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        hm localhm = (hm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133148);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localhm.FSm = ((hn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133148);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new hk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((hk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhm.FSn = ((hk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133148);
        return 0;
      }
      AppMethodBeat.o(133148);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hm
 * JD-Core Version:    0.7.0.1
 */