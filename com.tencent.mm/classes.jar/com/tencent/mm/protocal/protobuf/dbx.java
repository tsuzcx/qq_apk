package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dbx
  extends com.tencent.mm.bw.a
{
  public int FLj;
  public int FLk;
  public long FLl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125839);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FLj);
      paramVarArgs.aR(2, this.FLk);
      paramVarArgs.aO(3, this.FLl);
      AppMethodBeat.o(125839);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.FLj);
      int i = f.a.a.b.b.a.bx(2, this.FLk);
      int j = f.a.a.b.b.a.p(3, this.FLl);
      AppMethodBeat.o(125839);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(125839);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dbx localdbx = (dbx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125839);
        return -1;
      case 1: 
        localdbx.FLj = locala.LVo.xF();
        AppMethodBeat.o(125839);
        return 0;
      case 2: 
        localdbx.FLk = locala.LVo.xF();
        AppMethodBeat.o(125839);
        return 0;
      }
      localdbx.FLl = locala.LVo.xG();
      AppMethodBeat.o(125839);
      return 0;
    }
    AppMethodBeat.o(125839);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbx
 * JD-Core Version:    0.7.0.1
 */