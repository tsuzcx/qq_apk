package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dqu
  extends com.tencent.mm.bw.a
{
  public int FXY;
  public String FYc;
  public int hNR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32501);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FXY);
      paramVarArgs.aR(2, this.hNR);
      if (this.FYc != null) {
        paramVarArgs.d(3, this.FYc);
      }
      AppMethodBeat.o(32501);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.FXY) + 0 + f.a.a.b.b.a.bx(2, this.hNR);
      paramInt = i;
      if (this.FYc != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FYc);
      }
      AppMethodBeat.o(32501);
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
      AppMethodBeat.o(32501);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dqu localdqu = (dqu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32501);
        return -1;
      case 1: 
        localdqu.FXY = locala.LVo.xF();
        AppMethodBeat.o(32501);
        return 0;
      case 2: 
        localdqu.hNR = locala.LVo.xF();
        AppMethodBeat.o(32501);
        return 0;
      }
      localdqu.FYc = locala.LVo.readString();
      AppMethodBeat.o(32501);
      return 0;
    }
    AppMethodBeat.o(32501);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqu
 * JD-Core Version:    0.7.0.1
 */