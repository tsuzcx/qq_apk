package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class hf
  extends com.tencent.mm.bw.a
{
  public hg DUu;
  public hd DUv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133148);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DUu == null)
      {
        paramVarArgs = new b("Not all required fields were included: RsaReqData");
        AppMethodBeat.o(133148);
        throw paramVarArgs;
      }
      if (this.DUv == null)
      {
        paramVarArgs = new b("Not all required fields were included: AesReqData");
        AppMethodBeat.o(133148);
        throw paramVarArgs;
      }
      if (this.DUu != null)
      {
        paramVarArgs.ln(1, this.DUu.computeSize());
        this.DUu.writeFields(paramVarArgs);
      }
      if (this.DUv != null)
      {
        paramVarArgs.ln(2, this.DUv.computeSize());
        this.DUv.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133148);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DUu == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = f.a.a.a.lm(1, this.DUu.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DUv != null) {
        i = paramInt + f.a.a.a.lm(2, this.DUv.computeSize());
      }
      AppMethodBeat.o(133148);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.DUu == null)
        {
          paramVarArgs = new b("Not all required fields were included: RsaReqData");
          AppMethodBeat.o(133148);
          throw paramVarArgs;
        }
        if (this.DUv == null)
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
        hf localhf = (hf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133148);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localhf.DUu = ((hg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133148);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new hd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((hd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhf.DUv = ((hd)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hf
 * JD-Core Version:    0.7.0.1
 */