package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cyh
  extends com.tencent.mm.bw.a
{
  public cyi FRp;
  public String scope;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200333);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.scope != null) {
        paramVarArgs.d(1, this.scope);
      }
      if (this.FRp != null)
      {
        paramVarArgs.lJ(2, this.FRp.computeSize());
        this.FRp.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(200333);
      return 0;
    }
    if (paramInt == 1) {
      if (this.scope == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = f.a.a.b.b.a.e(1, this.scope) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FRp != null) {
        i = paramInt + f.a.a.a.lI(2, this.FRp.computeSize());
      }
      AppMethodBeat.o(200333);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(200333);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cyh localcyh = (cyh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(200333);
          return -1;
        case 1: 
          localcyh.scope = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(200333);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cyi();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cyi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcyh.FRp = ((cyi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(200333);
        return 0;
      }
      AppMethodBeat.o(200333);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyh
 * JD-Core Version:    0.7.0.1
 */