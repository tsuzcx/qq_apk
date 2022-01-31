package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class adq
  extends com.tencent.mm.bv.a
{
  public String desc;
  public String title;
  public String wWD;
  public LinkedList<adr> wWE;
  
  public adq()
  {
    AppMethodBeat.i(56793);
    this.wWE = new LinkedList();
    AppMethodBeat.o(56793);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56794);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.wWD != null) {
        paramVarArgs.e(2, this.wWD);
      }
      paramVarArgs.e(3, 8, this.wWE);
      if (this.desc != null) {
        paramVarArgs.e(4, this.desc);
      }
      AppMethodBeat.o(56794);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label478;
      }
    }
    label478:
    for (paramInt = e.a.a.b.b.a.f(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wWD != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.wWD);
      }
      i += e.a.a.a.c(3, 8, this.wWE);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.desc);
      }
      AppMethodBeat.o(56794);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wWE.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56794);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        adq localadq = (adq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56794);
          return -1;
        case 1: 
          localadq.title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56794);
          return 0;
        case 2: 
          localadq.wWD = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56794);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new adr();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((adr)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localadq.wWE.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56794);
          return 0;
        }
        localadq.desc = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56794);
        return 0;
      }
      AppMethodBeat.o(56794);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adq
 * JD-Core Version:    0.7.0.1
 */