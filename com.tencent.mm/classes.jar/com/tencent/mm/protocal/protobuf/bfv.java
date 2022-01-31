package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bfv
  extends com.tencent.mm.bv.a
{
  public LinkedList<cjw> wFB;
  public cjw wmY;
  public String wug;
  public String xuM;
  
  public bfv()
  {
    AppMethodBeat.i(48901);
    this.wFB = new LinkedList();
    AppMethodBeat.o(48901);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48902);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wmY != null)
      {
        paramVarArgs.iQ(1, this.wmY.computeSize());
        this.wmY.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.wFB);
      if (this.wug != null) {
        paramVarArgs.e(3, this.wug);
      }
      if (this.xuM != null) {
        paramVarArgs.e(4, this.xuM);
      }
      AppMethodBeat.o(48902);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wmY == null) {
        break label570;
      }
    }
    label570:
    for (paramInt = e.a.a.a.iP(1, this.wmY.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.a.c(2, 8, this.wFB);
      paramInt = i;
      if (this.wug != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.wug);
      }
      i = paramInt;
      if (this.xuM != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.xuM);
      }
      AppMethodBeat.o(48902);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wFB.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48902);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bfv localbfv = (bfv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48902);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cjw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cjw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbfv.wmY = ((cjw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48902);
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
            localbfv.wFB.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48902);
          return 0;
        case 3: 
          localbfv.wug = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48902);
          return 0;
        }
        localbfv.xuM = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48902);
        return 0;
      }
      AppMethodBeat.o(48902);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfv
 * JD-Core Version:    0.7.0.1
 */