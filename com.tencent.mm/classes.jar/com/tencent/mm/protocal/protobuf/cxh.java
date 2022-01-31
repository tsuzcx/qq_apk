package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cxh
  extends com.tencent.mm.bv.a
{
  public boolean xKI;
  public LinkedList<cxf> xfZ;
  public boolean yeP;
  
  public cxh()
  {
    AppMethodBeat.i(28742);
    this.xfZ = new LinkedList();
    AppMethodBeat.o(28742);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28743);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.xKI);
      paramVarArgs.e(2, 8, this.xfZ);
      paramVarArgs.aS(3, this.yeP);
      AppMethodBeat.o(28743);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.eW(1);
      i = e.a.a.a.c(2, 8, this.xfZ);
      int j = e.a.a.b.b.a.eW(3);
      AppMethodBeat.o(28743);
      return paramInt + 1 + 0 + i + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xfZ.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(28743);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      cxh localcxh = (cxh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(28743);
        return -1;
      case 1: 
        localcxh.xKI = ((e.a.a.a.a)localObject1).CLY.emu();
        AppMethodBeat.o(28743);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxf();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cxf)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcxh.xfZ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28743);
        return 0;
      }
      localcxh.yeP = ((e.a.a.a.a)localObject1).CLY.emu();
      AppMethodBeat.o(28743);
      return 0;
    }
    AppMethodBeat.o(28743);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxh
 * JD-Core Version:    0.7.0.1
 */