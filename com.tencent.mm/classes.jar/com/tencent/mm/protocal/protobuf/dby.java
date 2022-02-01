package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dby
  extends com.tencent.mm.bw.a
{
  public int EuN;
  public int FLm;
  public int FLn;
  public int FdM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125840);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EuN);
      paramVarArgs.aR(2, this.FdM);
      paramVarArgs.aR(3, this.FLm);
      paramVarArgs.aR(4, this.FLn);
      AppMethodBeat.o(125840);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.EuN);
      int i = f.a.a.b.b.a.bx(2, this.FdM);
      int j = f.a.a.b.b.a.bx(3, this.FLm);
      int k = f.a.a.b.b.a.bx(4, this.FLn);
      AppMethodBeat.o(125840);
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
      AppMethodBeat.o(125840);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dby localdby = (dby)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125840);
        return -1;
      case 1: 
        localdby.EuN = locala.LVo.xF();
        AppMethodBeat.o(125840);
        return 0;
      case 2: 
        localdby.FdM = locala.LVo.xF();
        AppMethodBeat.o(125840);
        return 0;
      case 3: 
        localdby.FLm = locala.LVo.xF();
        AppMethodBeat.o(125840);
        return 0;
      }
      localdby.FLn = locala.LVo.xF();
      AppMethodBeat.o(125840);
      return 0;
    }
    AppMethodBeat.o(125840);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dby
 * JD-Core Version:    0.7.0.1
 */