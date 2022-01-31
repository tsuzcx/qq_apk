package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cah
  extends com.tencent.mm.bv.a
{
  public LinkedList<bkh> xLP;
  public String xkf;
  
  public cah()
  {
    AppMethodBeat.i(152468);
    this.xLP = new LinkedList();
    AppMethodBeat.o(152468);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152469);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xkf != null) {
        paramVarArgs.e(1, this.xkf);
      }
      paramVarArgs.e(2, 8, this.xLP);
      AppMethodBeat.o(152469);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xkf == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = e.a.a.b.b.a.f(1, this.xkf) + 0;; paramInt = 0)
    {
      int i = e.a.a.a.c(2, 8, this.xLP);
      AppMethodBeat.o(152469);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xLP.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(152469);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cah localcah = (cah)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152469);
          return -1;
        case 1: 
          localcah.xkf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(152469);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bkh();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bkh)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcah.xLP.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152469);
        return 0;
      }
      AppMethodBeat.o(152469);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cah
 * JD-Core Version:    0.7.0.1
 */