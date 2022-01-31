package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class rc
  extends com.tencent.mm.bv.a
{
  public int eeF;
  public LinkedList<rd> wJm;
  public int wJn;
  public bwc wJo;
  
  public rc()
  {
    AppMethodBeat.i(60025);
    this.wJm = new LinkedList();
    AppMethodBeat.o(60025);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(60026);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.eeF);
      paramVarArgs.e(2, 8, this.wJm);
      paramVarArgs.aO(3, this.wJn);
      if (this.wJo != null)
      {
        paramVarArgs.iQ(4, this.wJo.computeSize());
        this.wJo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(60026);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.eeF) + 0 + e.a.a.a.c(2, 8, this.wJm) + e.a.a.b.b.a.bl(3, this.wJn);
      paramInt = i;
      if (this.wJo != null) {
        paramInt = i + e.a.a.a.iP(4, this.wJo.computeSize());
      }
      AppMethodBeat.o(60026);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wJm.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(60026);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      rc localrc = (rc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(60026);
        return -1;
      case 1: 
        localrc.eeF = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(60026);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rd();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((rd)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localrc.wJm.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(60026);
        return 0;
      case 3: 
        localrc.wJn = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(60026);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bwc();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localrc.wJo = ((bwc)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(60026);
      return 0;
    }
    AppMethodBeat.o(60026);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rc
 * JD-Core Version:    0.7.0.1
 */