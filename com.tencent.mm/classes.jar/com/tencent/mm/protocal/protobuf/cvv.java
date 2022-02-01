package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cvv
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> DTl;
  public LinkedList<String> FGx;
  
  public cvv()
  {
    AppMethodBeat.i(91685);
    this.DTl = new LinkedList();
    this.FGx = new LinkedList();
    AppMethodBeat.o(91685);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91686);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.DTl);
      paramVarArgs.e(2, 1, this.FGx);
      AppMethodBeat.o(91686);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 1, this.DTl);
      int i = f.a.a.a.c(2, 1, this.FGx);
      AppMethodBeat.o(91686);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.DTl.clear();
      this.FGx.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(91686);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cvv localcvv = (cvv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91686);
        return -1;
      case 1: 
        localcvv.DTl.add(locala.LVo.readString());
        AppMethodBeat.o(91686);
        return 0;
      }
      localcvv.FGx.add(locala.LVo.readString());
      AppMethodBeat.o(91686);
      return 0;
    }
    AppMethodBeat.o(91686);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvv
 * JD-Core Version:    0.7.0.1
 */