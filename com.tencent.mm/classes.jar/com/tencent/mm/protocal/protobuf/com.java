package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class com
  extends com.tencent.mm.bw.a
{
  public int GLu;
  public LinkedList<col> HAs;
  public int nID;
  
  public com()
  {
    AppMethodBeat.i(155449);
    this.HAs = new LinkedList();
    AppMethodBeat.o(155449);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155450);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GLu);
      paramVarArgs.aS(2, this.nID);
      paramVarArgs.e(3, 8, this.HAs);
      AppMethodBeat.o(155450);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.GLu);
      i = f.a.a.b.b.a.bz(2, this.nID);
      int j = f.a.a.a.c(3, 8, this.HAs);
      AppMethodBeat.o(155450);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HAs.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(155450);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      com localcom = (com)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(155450);
        return -1;
      case 1: 
        localcom.GLu = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(155450);
        return 0;
      case 2: 
        localcom.nID = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(155450);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new col();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((col)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcom.HAs.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(155450);
      return 0;
    }
    AppMethodBeat.o(155450);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.com
 * JD-Core Version:    0.7.0.1
 */