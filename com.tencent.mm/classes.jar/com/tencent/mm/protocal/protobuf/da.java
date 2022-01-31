package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class da
  extends com.tencent.mm.bv.a
{
  public String title;
  public String wpv;
  public LinkedList<cgn> wpw;
  
  public da()
  {
    AppMethodBeat.i(28308);
    this.wpw = new LinkedList();
    AppMethodBeat.o(28308);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28309);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wpv != null) {
        paramVarArgs.e(1, this.wpv);
      }
      paramVarArgs.e(2, 8, this.wpw);
      if (this.title != null) {
        paramVarArgs.e(3, this.title);
      }
      AppMethodBeat.o(28309);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wpv == null) {
        break label427;
      }
    }
    label427:
    for (paramInt = e.a.a.b.b.a.f(1, this.wpv) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.a.c(2, 8, this.wpw);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.title);
      }
      AppMethodBeat.o(28309);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wpw.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28309);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        da localda = (da)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28309);
          return -1;
        case 1: 
          localda.wpv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28309);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgn();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cgn)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localda.wpw.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28309);
          return 0;
        }
        localda.title = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28309);
        return 0;
      }
      AppMethodBeat.o(28309);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.da
 * JD-Core Version:    0.7.0.1
 */