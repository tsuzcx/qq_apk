package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class yi
  extends com.tencent.mm.bw.a
{
  public int Ebf;
  public int ErX;
  public int ndj;
  public int tit;
  public int vTO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124478);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.vTO);
      paramVarArgs.aR(2, this.tit);
      paramVarArgs.aR(3, this.ErX);
      paramVarArgs.aR(4, this.ndj);
      paramVarArgs.aR(5, this.Ebf);
      AppMethodBeat.o(124478);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.vTO);
      int i = f.a.a.b.b.a.bx(2, this.tit);
      int j = f.a.a.b.b.a.bx(3, this.ErX);
      int k = f.a.a.b.b.a.bx(4, this.ndj);
      int m = f.a.a.b.b.a.bx(5, this.Ebf);
      AppMethodBeat.o(124478);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(124478);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      yi localyi = (yi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124478);
        return -1;
      case 1: 
        localyi.vTO = locala.LVo.xF();
        AppMethodBeat.o(124478);
        return 0;
      case 2: 
        localyi.tit = locala.LVo.xF();
        AppMethodBeat.o(124478);
        return 0;
      case 3: 
        localyi.ErX = locala.LVo.xF();
        AppMethodBeat.o(124478);
        return 0;
      case 4: 
        localyi.ndj = locala.LVo.xF();
        AppMethodBeat.o(124478);
        return 0;
      }
      localyi.Ebf = locala.LVo.xF();
      AppMethodBeat.o(124478);
      return 0;
    }
    AppMethodBeat.o(124478);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yi
 * JD-Core Version:    0.7.0.1
 */