package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class kn
  extends com.tencent.mm.bw.a
{
  public long DXC = 0L;
  public long DXD = 0L;
  public long DXE = 0L;
  public long DXF = 0L;
  public int DXG;
  public int djq;
  public int yiF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110886);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.DXC);
      paramVarArgs.aO(2, this.DXD);
      paramVarArgs.aO(3, this.DXE);
      paramVarArgs.aO(4, this.DXF);
      paramVarArgs.aR(5, this.yiF);
      paramVarArgs.aR(6, this.djq);
      paramVarArgs.aR(7, this.DXG);
      AppMethodBeat.o(110886);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.DXC);
      int i = f.a.a.b.b.a.p(2, this.DXD);
      int j = f.a.a.b.b.a.p(3, this.DXE);
      int k = f.a.a.b.b.a.p(4, this.DXF);
      int m = f.a.a.b.b.a.bx(5, this.yiF);
      int n = f.a.a.b.b.a.bx(6, this.djq);
      int i1 = f.a.a.b.b.a.bx(7, this.DXG);
      AppMethodBeat.o(110886);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(110886);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      kn localkn = (kn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(110886);
        return -1;
      case 1: 
        localkn.DXC = locala.LVo.xG();
        AppMethodBeat.o(110886);
        return 0;
      case 2: 
        localkn.DXD = locala.LVo.xG();
        AppMethodBeat.o(110886);
        return 0;
      case 3: 
        localkn.DXE = locala.LVo.xG();
        AppMethodBeat.o(110886);
        return 0;
      case 4: 
        localkn.DXF = locala.LVo.xG();
        AppMethodBeat.o(110886);
        return 0;
      case 5: 
        localkn.yiF = locala.LVo.xF();
        AppMethodBeat.o(110886);
        return 0;
      case 6: 
        localkn.djq = locala.LVo.xF();
        AppMethodBeat.o(110886);
        return 0;
      }
      localkn.DXG = locala.LVo.xF();
      AppMethodBeat.o(110886);
      return 0;
    }
    AppMethodBeat.o(110886);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.kn
 * JD-Core Version:    0.7.0.1
 */