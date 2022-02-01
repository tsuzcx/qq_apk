package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class crk
  extends com.tencent.mm.bw.a
{
  public LinkedList<crl> HCH;
  public int count;
  public int phB;
  
  public crk()
  {
    AppMethodBeat.i(32400);
    this.HCH = new LinkedList();
    AppMethodBeat.o(32400);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32401);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.count);
      paramVarArgs.e(2, 8, this.HCH);
      paramVarArgs.aS(3, this.phB);
      AppMethodBeat.o(32401);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.count);
      i = f.a.a.a.c(2, 8, this.HCH);
      int j = f.a.a.b.b.a.bz(3, this.phB);
      AppMethodBeat.o(32401);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HCH.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(32401);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      crk localcrk = (crk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32401);
        return -1;
      case 1: 
        localcrk.count = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32401);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((crl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcrk.HCH.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32401);
        return 0;
      }
      localcrk.phB = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(32401);
      return 0;
    }
    AppMethodBeat.o(32401);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crk
 * JD-Core Version:    0.7.0.1
 */