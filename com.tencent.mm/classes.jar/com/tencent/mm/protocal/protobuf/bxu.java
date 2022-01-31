package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bxu
  extends com.tencent.mm.bv.a
{
  public int Scene;
  public String lGH;
  public String xHR;
  public azu xqU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124357);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xHR != null) {
        paramVarArgs.e(1, this.xHR);
      }
      paramVarArgs.aO(2, this.Scene);
      if (this.lGH != null) {
        paramVarArgs.e(3, this.lGH);
      }
      if (this.xqU != null)
      {
        paramVarArgs.iQ(4, this.xqU.computeSize());
        this.xqU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124357);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xHR == null) {
        break label474;
      }
    }
    label474:
    for (paramInt = e.a.a.b.b.a.f(1, this.xHR) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.Scene);
      paramInt = i;
      if (this.lGH != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.lGH);
      }
      i = paramInt;
      if (this.xqU != null) {
        i = paramInt + e.a.a.a.iP(4, this.xqU.computeSize());
      }
      AppMethodBeat.o(124357);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(124357);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bxu localbxu = (bxu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124357);
          return -1;
        case 1: 
          localbxu.xHR = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(124357);
          return 0;
        case 2: 
          localbxu.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(124357);
          return 0;
        case 3: 
          localbxu.lGH = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(124357);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new azu();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((azu)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbxu.xqU = ((azu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124357);
        return 0;
      }
      AppMethodBeat.o(124357);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxu
 * JD-Core Version:    0.7.0.1
 */