package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbb
  extends com.tencent.mm.bv.a
{
  public String yhh;
  public LinkedList<dba> yhi;
  
  public dbb()
  {
    AppMethodBeat.i(139628);
    this.yhi = new LinkedList();
    AppMethodBeat.o(139628);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(139629);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.yhh != null) {
        paramVarArgs.e(1, this.yhh);
      }
      paramVarArgs.e(2, 8, this.yhi);
      AppMethodBeat.o(139629);
      return 0;
    }
    if (paramInt == 1) {
      if (this.yhh == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = e.a.a.b.b.a.f(1, this.yhh) + 0;; paramInt = 0)
    {
      int i = e.a.a.a.c(2, 8, this.yhi);
      AppMethodBeat.o(139629);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.yhi.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(139629);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        dbb localdbb = (dbb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(139629);
          return -1;
        case 1: 
          localdbb.yhh = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(139629);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dba();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dba)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localdbb.yhi.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(139629);
        return 0;
      }
      AppMethodBeat.o(139629);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbb
 * JD-Core Version:    0.7.0.1
 */