package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class wb
  extends com.tencent.mm.bv.a
{
  public bfp wOJ;
  public LinkedList<yl> wOK;
  public LinkedList<cqy> wOL;
  public String wOM;
  
  public wb()
  {
    AppMethodBeat.i(48830);
    this.wOK = new LinkedList();
    this.wOL = new LinkedList();
    AppMethodBeat.o(48830);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48831);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wOJ != null)
      {
        paramVarArgs.iQ(1, this.wOJ.computeSize());
        this.wOJ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.wOK);
      paramVarArgs.e(3, 8, this.wOL);
      if (this.wOM != null) {
        paramVarArgs.e(4, this.wOM);
      }
      AppMethodBeat.o(48831);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wOJ == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = e.a.a.a.iP(1, this.wOJ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.a.c(2, 8, this.wOK) + e.a.a.a.c(3, 8, this.wOL);
      paramInt = i;
      if (this.wOM != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wOM);
      }
      AppMethodBeat.o(48831);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wOK.clear();
        this.wOL.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48831);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        wb localwb = (wb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48831);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bfp();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bfp)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localwb.wOJ = ((bfp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48831);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new yl();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((yl)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localwb.wOK.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48831);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cqy();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cqy)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localwb.wOL.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48831);
          return 0;
        }
        localwb.wOM = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48831);
        return 0;
      }
      AppMethodBeat.o(48831);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wb
 * JD-Core Version:    0.7.0.1
 */