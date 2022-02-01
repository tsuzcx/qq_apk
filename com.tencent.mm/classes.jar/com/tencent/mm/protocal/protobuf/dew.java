package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dew
  extends com.tencent.mm.bw.a
{
  public String FOp;
  public int wTD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133200);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.wTD);
      if (this.FOp != null) {
        paramVarArgs.d(2, this.FOp);
      }
      AppMethodBeat.o(133200);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.wTD) + 0;
      paramInt = i;
      if (this.FOp != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FOp);
      }
      AppMethodBeat.o(133200);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(133200);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dew localdew = (dew)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(133200);
        return -1;
      case 1: 
        localdew.wTD = locala.LVo.xF();
        AppMethodBeat.o(133200);
        return 0;
      }
      localdew.FOp = locala.LVo.readString();
      AppMethodBeat.o(133200);
      return 0;
    }
    AppMethodBeat.o(133200);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dew
 * JD-Core Version:    0.7.0.1
 */