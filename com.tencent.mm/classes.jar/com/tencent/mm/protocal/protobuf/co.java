package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class co
  extends com.tencent.mm.bv.a
{
  public String desc;
  public String gfM;
  public LinkedList<bia> wpb;
  
  public co()
  {
    AppMethodBeat.i(80007);
    this.wpb = new LinkedList();
    AppMethodBeat.o(80007);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80008);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.gfM != null) {
        paramVarArgs.e(1, this.gfM);
      }
      paramVarArgs.e(2, 8, this.wpb);
      if (this.desc != null) {
        paramVarArgs.e(3, this.desc);
      }
      AppMethodBeat.o(80008);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gfM == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = e.a.a.b.b.a.f(1, this.gfM) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.a.c(2, 8, this.wpb);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.desc);
      }
      AppMethodBeat.o(80008);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wpb.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(80008);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        co localco = (co)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80008);
          return -1;
        case 1: 
          localco.gfM = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80008);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bia();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bia)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localco.wpb.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80008);
          return 0;
        }
        localco.desc = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(80008);
        return 0;
      }
      AppMethodBeat.o(80008);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.co
 * JD-Core Version:    0.7.0.1
 */