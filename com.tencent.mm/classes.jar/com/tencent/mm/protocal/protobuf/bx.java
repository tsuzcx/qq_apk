package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class bx
  extends com.tencent.mm.bw.a
{
  public int DPl;
  public b DPm;
  public long sVY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125702);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DPl);
      if (this.DPm != null) {
        paramVarArgs.c(2, this.DPm);
      }
      paramVarArgs.aO(3, this.sVY);
      AppMethodBeat.o(125702);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.DPl) + 0;
      paramInt = i;
      if (this.DPm != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.DPm);
      }
      i = f.a.a.b.b.a.p(3, this.sVY);
      AppMethodBeat.o(125702);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(125702);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bx localbx = (bx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125702);
        return -1;
      case 1: 
        localbx.DPl = locala.LVo.xF();
        AppMethodBeat.o(125702);
        return 0;
      case 2: 
        localbx.DPm = locala.LVo.gfk();
        AppMethodBeat.o(125702);
        return 0;
      }
      localbx.sVY = locala.LVo.xG();
      AppMethodBeat.o(125702);
      return 0;
    }
    AppMethodBeat.o(125702);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bx
 * JD-Core Version:    0.7.0.1
 */