package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bvy
  extends com.tencent.mm.bv.a
{
  public cjw wNE;
  public String wug;
  public bkd xJu;
  public float xJv;
  public long xJw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48960);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wug != null) {
        paramVarArgs.e(1, this.wug);
      }
      if (this.wNE != null)
      {
        paramVarArgs.iQ(2, this.wNE.computeSize());
        this.wNE.writeFields(paramVarArgs);
      }
      if (this.xJu != null)
      {
        paramVarArgs.iQ(3, this.xJu.computeSize());
        this.xJu.writeFields(paramVarArgs);
      }
      paramVarArgs.q(4, this.xJv);
      paramVarArgs.am(5, this.xJw);
      AppMethodBeat.o(48960);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wug == null) {
        break label617;
      }
    }
    label617:
    for (int i = e.a.a.b.b.a.f(1, this.wug) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wNE != null) {
        paramInt = i + e.a.a.a.iP(2, this.wNE.computeSize());
      }
      i = paramInt;
      if (this.xJu != null) {
        i = paramInt + e.a.a.a.iP(3, this.xJu.computeSize());
      }
      paramInt = e.a.a.b.b.a.eW(4);
      int j = e.a.a.b.b.a.p(5, this.xJw);
      AppMethodBeat.o(48960);
      return i + (paramInt + 4) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48960);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bvy localbvy = (bvy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48960);
          return -1;
        case 1: 
          localbvy.wug = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48960);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cjw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cjw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbvy.wNE = ((cjw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48960);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bkd();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bkd)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbvy.xJu = ((bkd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48960);
          return 0;
        case 4: 
          localbvy.xJv = Float.intBitsToFloat(((e.a.a.a.a)localObject1).CLY.emx());
          AppMethodBeat.o(48960);
          return 0;
        }
        localbvy.xJw = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(48960);
        return 0;
      }
      AppMethodBeat.o(48960);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvy
 * JD-Core Version:    0.7.0.1
 */