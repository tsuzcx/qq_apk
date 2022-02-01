package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cmj
  extends com.tencent.mm.bw.a
{
  public dba FzF;
  public crm FzG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125759);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FzF == null)
      {
        paramVarArgs = new b("Not all required fields were included: SnsRecommendObject");
        AppMethodBeat.o(125759);
        throw paramVarArgs;
      }
      if (this.FzF != null)
      {
        paramVarArgs.ln(1, this.FzF.computeSize());
        this.FzF.writeFields(paramVarArgs);
      }
      if (this.FzG != null)
      {
        paramVarArgs.ln(2, this.FzG.computeSize());
        this.FzG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125759);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FzF == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = f.a.a.a.lm(1, this.FzF.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FzG != null) {
        i = paramInt + f.a.a.a.lm(2, this.FzG.computeSize());
      }
      AppMethodBeat.o(125759);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FzF == null)
        {
          paramVarArgs = new b("Not all required fields were included: SnsRecommendObject");
          AppMethodBeat.o(125759);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125759);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cmj localcmj = (cmj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125759);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dba();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dba)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcmj.FzF = ((dba)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125759);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcmj.FzG = ((crm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125759);
        return 0;
      }
      AppMethodBeat.o(125759);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmj
 * JD-Core Version:    0.7.0.1
 */