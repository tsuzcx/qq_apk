package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class btf
  extends com.tencent.mm.bw.a
{
  public btg Fim;
  public bte Fin;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133177);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fim == null)
      {
        paramVarArgs = new b("Not all required fields were included: RsaReqData");
        AppMethodBeat.o(133177);
        throw paramVarArgs;
      }
      if (this.Fin == null)
      {
        paramVarArgs = new b("Not all required fields were included: AesReqData");
        AppMethodBeat.o(133177);
        throw paramVarArgs;
      }
      if (this.Fim != null)
      {
        paramVarArgs.ln(1, this.Fim.computeSize());
        this.Fim.writeFields(paramVarArgs);
      }
      if (this.Fin != null)
      {
        paramVarArgs.ln(2, this.Fin.computeSize());
        this.Fin.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133177);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Fim == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = f.a.a.a.lm(1, this.Fim.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Fin != null) {
        i = paramInt + f.a.a.a.lm(2, this.Fin.computeSize());
      }
      AppMethodBeat.o(133177);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.Fim == null)
        {
          paramVarArgs = new b("Not all required fields were included: RsaReqData");
          AppMethodBeat.o(133177);
          throw paramVarArgs;
        }
        if (this.Fin == null)
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        btf localbtf = (btf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133177);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new btg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((btg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtf.Fim = ((btg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133177);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bte();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bte)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbtf.Fin = ((bte)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btf
 * JD-Core Version:    0.7.0.1
 */