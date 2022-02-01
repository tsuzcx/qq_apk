package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aqh
  extends com.tencent.mm.bw.a
{
  public boolean EJk;
  public boolean EJl;
  public boolean EJm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116470);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bl(1, this.EJk);
      paramVarArgs.bl(2, this.EJl);
      paramVarArgs.bl(3, this.EJm);
      AppMethodBeat.o(116470);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.fK(1);
      int i = f.a.a.b.b.a.fK(2);
      int j = f.a.a.b.b.a.fK(3);
      AppMethodBeat.o(116470);
      return paramInt + 1 + 0 + (i + 1) + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(116470);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aqh localaqh = (aqh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(116470);
        return -1;
      case 1: 
        localaqh.EJk = locala.LVo.fZX();
        AppMethodBeat.o(116470);
        return 0;
      case 2: 
        localaqh.EJl = locala.LVo.fZX();
        AppMethodBeat.o(116470);
        return 0;
      }
      localaqh.EJm = locala.LVo.fZX();
      AppMethodBeat.o(116470);
      return 0;
    }
    AppMethodBeat.o(116470);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqh
 * JD-Core Version:    0.7.0.1
 */