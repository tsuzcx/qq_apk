package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class sa
  extends com.tencent.mm.bw.a
{
  public int GgT;
  public LinkedList<Integer> GgU;
  
  public sa()
  {
    AppMethodBeat.i(133164);
    this.GgU = new LinkedList();
    AppMethodBeat.o(133164);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133165);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GgT);
      paramVarArgs.f(2, 2, this.GgU);
      AppMethodBeat.o(133165);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.GgT);
      int i = f.a.a.a.d(2, 2, this.GgU);
      AppMethodBeat.o(133165);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GgU.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(133165);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      sa localsa = (sa)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(133165);
        return -1;
      case 1: 
        localsa.GgT = locala.OmT.zc();
        AppMethodBeat.o(133165);
        return 0;
      }
      localsa.GgU = new f.a.a.a.a(locala.OmT.gCk().zr, unknownTagHandler).OmT.gCi();
      AppMethodBeat.o(133165);
      return 0;
    }
    AppMethodBeat.o(133165);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sa
 * JD-Core Version:    0.7.0.1
 */