package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cjc
  extends com.tencent.mm.bv.a
{
  public String woB;
  public String xTl;
  public dbi xTo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114991);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xTl == null)
      {
        paramVarArgs = new b("Not all required fields were included: WxaUserName");
        AppMethodBeat.o(114991);
        throw paramVarArgs;
      }
      if (this.xTl != null) {
        paramVarArgs.e(1, this.xTl);
      }
      if (this.xTo != null)
      {
        paramVarArgs.iQ(2, this.xTo.computeSize());
        this.xTo.writeFields(paramVarArgs);
      }
      if (this.woB != null) {
        paramVarArgs.e(3, this.woB);
      }
      AppMethodBeat.o(114991);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xTl == null) {
        break label478;
      }
    }
    label478:
    for (int i = e.a.a.b.b.a.f(1, this.xTl) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xTo != null) {
        paramInt = i + e.a.a.a.iP(2, this.xTo.computeSize());
      }
      i = paramInt;
      if (this.woB != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.woB);
      }
      AppMethodBeat.o(114991);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xTl == null)
        {
          paramVarArgs = new b("Not all required fields were included: WxaUserName");
          AppMethodBeat.o(114991);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114991);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cjc localcjc = (cjc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114991);
          return -1;
        case 1: 
          localcjc.xTl = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(114991);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbi();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dbi)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcjc.xTo = ((dbi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114991);
          return 0;
        }
        localcjc.woB = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(114991);
        return 0;
      }
      AppMethodBeat.o(114991);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjc
 * JD-Core Version:    0.7.0.1
 */