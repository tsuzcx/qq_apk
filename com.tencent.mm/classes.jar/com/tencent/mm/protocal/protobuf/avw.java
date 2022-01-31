package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class avw
  extends com.tencent.mm.bv.a
{
  public String eAx;
  public int major;
  public LinkedList<avy> xlk;
  
  public avw()
  {
    AppMethodBeat.i(10192);
    this.xlk = new LinkedList();
    AppMethodBeat.o(10192);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(10193);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.eAx != null) {
        paramVarArgs.e(1, this.eAx);
      }
      paramVarArgs.aO(2, this.major);
      paramVarArgs.e(3, 8, this.xlk);
      AppMethodBeat.o(10193);
      return 0;
    }
    if (paramInt == 1) {
      if (this.eAx == null) {
        break label411;
      }
    }
    label411:
    for (paramInt = e.a.a.b.b.a.f(1, this.eAx) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.major);
      int j = e.a.a.a.c(3, 8, this.xlk);
      AppMethodBeat.o(10193);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xlk.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(10193);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        avw localavw = (avw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(10193);
          return -1;
        case 1: 
          localavw.eAx = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10193);
          return 0;
        case 2: 
          localavw.major = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(10193);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avy();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((avy)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localavw.xlk.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(10193);
        return 0;
      }
      AppMethodBeat.o(10193);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avw
 * JD-Core Version:    0.7.0.1
 */