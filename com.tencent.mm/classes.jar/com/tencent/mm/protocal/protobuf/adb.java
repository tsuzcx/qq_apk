package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class adb
  extends com.tencent.mm.bx.a
{
  public int CCC;
  public LinkedList<dhd> DdI;
  public int DdJ;
  public boolean DdK;
  public int Scene;
  
  public adb()
  {
    AppMethodBeat.i(104763);
    this.DdI = new LinkedList();
    this.DdK = false;
    this.CCC = 0;
    AppMethodBeat.o(104763);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104764);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.DdI);
      paramVarArgs.aR(2, this.DdJ);
      paramVarArgs.bg(3, this.DdK);
      paramVarArgs.aR(4, this.CCC);
      paramVarArgs.aR(5, this.Scene);
      AppMethodBeat.o(104764);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 8, this.DdI);
      i = f.a.a.b.b.a.bA(2, this.DdJ);
      int j = f.a.a.b.b.a.fY(3);
      int k = f.a.a.b.b.a.bA(4, this.CCC);
      int m = f.a.a.b.b.a.bA(5, this.Scene);
      AppMethodBeat.o(104764);
      return paramInt + 0 + i + (j + 1) + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.DdI.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(104764);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      adb localadb = (adb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(104764);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dhd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dhd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localadb.DdI.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(104764);
        return 0;
      case 2: 
        localadb.DdJ = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(104764);
        return 0;
      case 3: 
        localadb.DdK = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(104764);
        return 0;
      case 4: 
        localadb.CCC = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(104764);
        return 0;
      }
      localadb.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(104764);
      return 0;
    }
    AppMethodBeat.o(104764);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adb
 * JD-Core Version:    0.7.0.1
 */