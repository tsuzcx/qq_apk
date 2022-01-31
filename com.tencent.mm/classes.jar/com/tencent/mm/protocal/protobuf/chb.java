package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class chb
  extends com.tencent.mm.bv.a
{
  public String Title;
  public LinkedList<chl> wOa;
  
  public chb()
  {
    AppMethodBeat.i(56507);
    this.wOa = new LinkedList();
    AppMethodBeat.o(56507);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56508);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      paramVarArgs.e(2, 8, this.wOa);
      AppMethodBeat.o(56508);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = e.a.a.b.b.a.f(1, this.Title) + 0;; paramInt = 0)
    {
      int i = e.a.a.a.c(2, 8, this.wOa);
      AppMethodBeat.o(56508);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wOa.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56508);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        chb localchb = (chb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56508);
          return -1;
        case 1: 
          localchb.Title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56508);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new chl();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((chl)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localchb.wOa.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56508);
        return 0;
      }
      AppMethodBeat.o(56508);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chb
 * JD-Core Version:    0.7.0.1
 */