package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class px
  extends com.tencent.mm.bx.a
{
  public int COC;
  public LinkedList<Integer> COD;
  
  public px()
  {
    AppMethodBeat.i(133164);
    this.COD = new LinkedList();
    AppMethodBeat.o(133164);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133165);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.COC);
      paramVarArgs.f(2, 2, this.COD);
      AppMethodBeat.o(133165);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.COC);
      int i = f.a.a.a.d(2, 2, this.COD);
      AppMethodBeat.o(133165);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.COD.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(133165);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      px localpx = (px)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(133165);
        return -1;
      case 1: 
        localpx.COC = locala.KhF.xS();
        AppMethodBeat.o(133165);
        return 0;
      }
      localpx.COD = new f.a.a.a.a(locala.KhF.fMu().wA, unknownTagHandler).KhF.fMs();
      AppMethodBeat.o(133165);
      return 0;
    }
    AppMethodBeat.o(133165);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.px
 * JD-Core Version:    0.7.0.1
 */