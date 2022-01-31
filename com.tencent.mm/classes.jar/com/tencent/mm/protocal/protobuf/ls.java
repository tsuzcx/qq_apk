package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ls
  extends com.tencent.mm.bv.a
{
  public String wAh;
  public int wAi;
  public String wAj;
  public int wAk;
  public LinkedList<kb> wAl;
  
  public ls()
  {
    AppMethodBeat.i(80029);
    this.wAl = new LinkedList();
    AppMethodBeat.o(80029);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80030);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wAh != null) {
        paramVarArgs.e(1, this.wAh);
      }
      paramVarArgs.aO(2, this.wAi);
      if (this.wAj != null) {
        paramVarArgs.e(3, this.wAj);
      }
      paramVarArgs.aO(4, this.wAk);
      paramVarArgs.e(5, 8, this.wAl);
      AppMethodBeat.o(80030);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wAh == null) {
        break label506;
      }
    }
    label506:
    for (paramInt = e.a.a.b.b.a.f(1, this.wAh) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wAi);
      paramInt = i;
      if (this.wAj != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.wAj);
      }
      i = e.a.a.b.b.a.bl(4, this.wAk);
      int j = e.a.a.a.c(5, 8, this.wAl);
      AppMethodBeat.o(80030);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wAl.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(80030);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ls localls = (ls)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80030);
          return -1;
        case 1: 
          localls.wAh = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80030);
          return 0;
        case 2: 
          localls.wAi = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80030);
          return 0;
        case 3: 
          localls.wAj = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80030);
          return 0;
        case 4: 
          localls.wAk = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80030);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new kb();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((kb)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localls.wAl.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(80030);
        return 0;
      }
      AppMethodBeat.o(80030);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ls
 * JD-Core Version:    0.7.0.1
 */