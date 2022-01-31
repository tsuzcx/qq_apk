package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class as
  extends com.tencent.mm.bv.a
{
  public LinkedList<biy> ceF;
  public String wmB;
  public LinkedList<biz> wmC;
  
  public as()
  {
    AppMethodBeat.i(80004);
    this.wmC = new LinkedList();
    this.ceF = new LinkedList();
    AppMethodBeat.o(80004);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80005);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wmB != null) {
        paramVarArgs.e(1, this.wmB);
      }
      paramVarArgs.e(2, 8, this.wmC);
      paramVarArgs.e(3, 8, this.ceF);
      AppMethodBeat.o(80005);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wmB == null) {
        break label498;
      }
    }
    label498:
    for (paramInt = e.a.a.b.b.a.f(1, this.wmB) + 0;; paramInt = 0)
    {
      int i = e.a.a.a.c(2, 8, this.wmC);
      int j = e.a.a.a.c(3, 8, this.ceF);
      AppMethodBeat.o(80005);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wmC.clear();
        this.ceF.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(80005);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        as localas = (as)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80005);
          return -1;
        case 1: 
          localas.wmB = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80005);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new biz();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((biz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localas.wmC.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80005);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new biy();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((biy)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localas.ceF.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(80005);
        return 0;
      }
      AppMethodBeat.o(80005);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.as
 * JD-Core Version:    0.7.0.1
 */