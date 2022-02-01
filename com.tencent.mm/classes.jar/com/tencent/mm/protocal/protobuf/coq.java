package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class coq
  extends com.tencent.mm.bw.a
{
  public abu HAw;
  public bzx HAy;
  public String dyI;
  public String oGf;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(197202);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dyI != null) {
        paramVarArgs.d(1, this.dyI);
      }
      paramVarArgs.aS(2, this.type);
      if (this.oGf != null) {
        paramVarArgs.d(3, this.oGf);
      }
      if (this.HAy != null)
      {
        paramVarArgs.lJ(4, this.HAy.computeSize());
        this.HAy.writeFields(paramVarArgs);
      }
      if (this.HAw != null)
      {
        paramVarArgs.lJ(5, this.HAw.computeSize());
        this.HAw.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(197202);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dyI == null) {
        break label630;
      }
    }
    label630:
    for (paramInt = f.a.a.b.b.a.e(1, this.dyI) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.type);
      paramInt = i;
      if (this.oGf != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oGf);
      }
      i = paramInt;
      if (this.HAy != null) {
        i = paramInt + f.a.a.a.lI(4, this.HAy.computeSize());
      }
      paramInt = i;
      if (this.HAw != null) {
        paramInt = i + f.a.a.a.lI(5, this.HAw.computeSize());
      }
      AppMethodBeat.o(197202);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(197202);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        coq localcoq = (coq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(197202);
          return -1;
        case 1: 
          localcoq.dyI = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(197202);
          return 0;
        case 2: 
          localcoq.type = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(197202);
          return 0;
        case 3: 
          localcoq.oGf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(197202);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bzx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bzx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcoq.HAy = ((bzx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(197202);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new abu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((abu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcoq.HAw = ((abu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(197202);
        return 0;
      }
      AppMethodBeat.o(197202);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.coq
 * JD-Core Version:    0.7.0.1
 */