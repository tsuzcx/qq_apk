package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class buf
  extends com.tencent.mm.bw.a
{
  public int Fkn;
  public int Fko;
  public int Fkp;
  public int iqB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116472);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Fkn);
      paramVarArgs.aR(2, this.Fko);
      paramVarArgs.aR(3, this.Fkp);
      paramVarArgs.aR(4, this.iqB);
      AppMethodBeat.o(116472);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.Fkn);
      int i = f.a.a.b.b.a.bx(2, this.Fko);
      int j = f.a.a.b.b.a.bx(3, this.Fkp);
      int k = f.a.a.b.b.a.bx(4, this.iqB);
      AppMethodBeat.o(116472);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(116472);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      buf localbuf = (buf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(116472);
        return -1;
      case 1: 
        localbuf.Fkn = locala.LVo.xF();
        AppMethodBeat.o(116472);
        return 0;
      case 2: 
        localbuf.Fko = locala.LVo.xF();
        AppMethodBeat.o(116472);
        return 0;
      case 3: 
        localbuf.Fkp = locala.LVo.xF();
        AppMethodBeat.o(116472);
        return 0;
      }
      localbuf.iqB = locala.LVo.xF();
      AppMethodBeat.o(116472);
      return 0;
    }
    AppMethodBeat.o(116472);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buf
 * JD-Core Version:    0.7.0.1
 */