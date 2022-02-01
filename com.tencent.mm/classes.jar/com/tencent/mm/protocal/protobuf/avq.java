package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class avq
  extends com.tencent.mm.bw.a
{
  public long FVE;
  public String FVF;
  public LinkedList<dxb> GMI;
  
  public avq()
  {
    AppMethodBeat.i(110898);
    this.GMI = new LinkedList();
    AppMethodBeat.o(110898);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110899);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.FVE);
      paramVarArgs.e(2, 8, this.GMI);
      if (this.FVF != null) {
        paramVarArgs.d(3, this.FVF);
      }
      AppMethodBeat.o(110899);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.FVE) + 0 + f.a.a.a.c(2, 8, this.GMI);
      paramInt = i;
      if (this.FVF != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FVF);
      }
      AppMethodBeat.o(110899);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GMI.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(110899);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      avq localavq = (avq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110899);
        return -1;
      case 1: 
        localavq.FVE = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(110899);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dxb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dxb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localavq.GMI.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110899);
        return 0;
      }
      localavq.FVF = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(110899);
      return 0;
    }
    AppMethodBeat.o(110899);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avq
 * JD-Core Version:    0.7.0.1
 */