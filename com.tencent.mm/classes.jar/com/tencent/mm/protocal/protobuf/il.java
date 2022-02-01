package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class il
  extends com.tencent.mm.bw.a
{
  public String DVW;
  public LinkedList<cnj> DWm;
  public cze DWn;
  
  public il()
  {
    AppMethodBeat.i(91357);
    this.DWm = new LinkedList();
    AppMethodBeat.o(91357);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91358);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DVW != null) {
        paramVarArgs.d(1, this.DVW);
      }
      paramVarArgs.e(2, 8, this.DWm);
      if (this.DWn != null)
      {
        paramVarArgs.ln(3, this.DWn.computeSize());
        this.DWn.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91358);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DVW == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = f.a.a.b.b.a.e(1, this.DVW) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.DWm);
      paramInt = i;
      if (this.DWn != null) {
        paramInt = i + f.a.a.a.lm(3, this.DWn.computeSize());
      }
      AppMethodBeat.o(91358);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DWm.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91358);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        il localil = (il)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91358);
          return -1;
        case 1: 
          localil.DVW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91358);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cnj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cnj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localil.DWm.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91358);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cze();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cze)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localil.DWn = ((cze)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91358);
        return 0;
      }
      AppMethodBeat.o(91358);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.il
 * JD-Core Version:    0.7.0.1
 */