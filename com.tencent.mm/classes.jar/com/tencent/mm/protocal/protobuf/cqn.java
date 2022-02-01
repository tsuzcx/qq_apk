package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cqn
  extends com.tencent.mm.bx.a
{
  public LinkedList<anc> DnZ;
  public String dpw;
  
  public cqn()
  {
    AppMethodBeat.i(122534);
    this.DnZ = new LinkedList();
    AppMethodBeat.o(122534);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122535);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dpw != null) {
        paramVarArgs.d(1, this.dpw);
      }
      paramVarArgs.e(2, 8, this.DnZ);
      AppMethodBeat.o(122535);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dpw == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = f.a.a.b.b.a.e(1, this.dpw) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.DnZ);
      AppMethodBeat.o(122535);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DnZ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(122535);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cqn localcqn = (cqn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122535);
          return -1;
        case 1: 
          localcqn.dpw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(122535);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new anc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((anc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcqn.DnZ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122535);
        return 0;
      }
      AppMethodBeat.o(122535);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqn
 * JD-Core Version:    0.7.0.1
 */