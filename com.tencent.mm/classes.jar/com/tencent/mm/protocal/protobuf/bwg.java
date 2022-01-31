package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bwg
  extends com.tencent.mm.bv.a
{
  public LinkedList<baw> xJI;
  public boolean xJJ;
  public boolean xJK;
  public boolean xJL;
  public boolean xJM;
  public boolean xJN;
  
  public bwg()
  {
    AppMethodBeat.i(73753);
    this.xJI = new LinkedList();
    AppMethodBeat.o(73753);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(73754);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.xJI);
      paramVarArgs.aS(2, this.xJJ);
      paramVarArgs.aS(3, this.xJK);
      paramVarArgs.aS(4, this.xJL);
      paramVarArgs.aS(5, this.xJM);
      paramVarArgs.aS(6, this.xJN);
      AppMethodBeat.o(73754);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = e.a.a.a.c(1, 8, this.xJI);
      i = e.a.a.b.b.a.eW(2);
      int j = e.a.a.b.b.a.eW(3);
      int k = e.a.a.b.b.a.eW(4);
      int m = e.a.a.b.b.a.eW(5);
      int n = e.a.a.b.b.a.eW(6);
      AppMethodBeat.o(73754);
      return paramInt + 0 + (i + 1) + (j + 1) + (k + 1) + (m + 1) + (n + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xJI.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(73754);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      bwg localbwg = (bwg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(73754);
        return -1;
      case 1: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new baw();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((baw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbwg.xJI.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(73754);
        return 0;
      case 2: 
        localbwg.xJJ = ((e.a.a.a.a)localObject1).CLY.emu();
        AppMethodBeat.o(73754);
        return 0;
      case 3: 
        localbwg.xJK = ((e.a.a.a.a)localObject1).CLY.emu();
        AppMethodBeat.o(73754);
        return 0;
      case 4: 
        localbwg.xJL = ((e.a.a.a.a)localObject1).CLY.emu();
        AppMethodBeat.o(73754);
        return 0;
      case 5: 
        localbwg.xJM = ((e.a.a.a.a)localObject1).CLY.emu();
        AppMethodBeat.o(73754);
        return 0;
      }
      localbwg.xJN = ((e.a.a.a.a)localObject1).CLY.emu();
      AppMethodBeat.o(73754);
      return 0;
    }
    AppMethodBeat.o(73754);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwg
 * JD-Core Version:    0.7.0.1
 */