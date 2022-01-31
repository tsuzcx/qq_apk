package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gc
  extends com.tencent.mm.bv.a
{
  public String desc;
  public String title;
  public LinkedList<gb> wsl;
  
  public gc()
  {
    AppMethodBeat.i(96200);
    this.wsl = new LinkedList();
    AppMethodBeat.o(96200);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96201);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(2, this.desc);
      }
      paramVarArgs.e(3, 8, this.wsl);
      AppMethodBeat.o(96201);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = e.a.a.b.b.a.f(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.desc != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.desc);
      }
      paramInt = e.a.a.a.c(3, 8, this.wsl);
      AppMethodBeat.o(96201);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wsl.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(96201);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        gc localgc = (gc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(96201);
          return -1;
        case 1: 
          localgc.title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96201);
          return 0;
        case 2: 
          localgc.desc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96201);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new gb();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((gb)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localgc.wsl.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(96201);
        return 0;
      }
      AppMethodBeat.o(96201);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gc
 * JD-Core Version:    0.7.0.1
 */