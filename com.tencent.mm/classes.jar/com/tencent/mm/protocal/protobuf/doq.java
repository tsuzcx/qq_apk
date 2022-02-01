package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class doq
  extends com.tencent.mm.bw.a
{
  public int FWn;
  public long FWo;
  public long FWp;
  public long qoj;
  public int yuZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169092);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FWn);
      paramVarArgs.aR(2, this.yuZ);
      paramVarArgs.aO(3, this.qoj);
      paramVarArgs.aO(4, this.FWo);
      paramVarArgs.aO(5, this.FWp);
      AppMethodBeat.o(169092);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.FWn);
      int i = f.a.a.b.b.a.bx(2, this.yuZ);
      int j = f.a.a.b.b.a.p(3, this.qoj);
      int k = f.a.a.b.b.a.p(4, this.FWo);
      int m = f.a.a.b.b.a.p(5, this.FWp);
      AppMethodBeat.o(169092);
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
      AppMethodBeat.o(169092);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      doq localdoq = (doq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169092);
        return -1;
      case 1: 
        localdoq.FWn = locala.LVo.xF();
        AppMethodBeat.o(169092);
        return 0;
      case 2: 
        localdoq.yuZ = locala.LVo.xF();
        AppMethodBeat.o(169092);
        return 0;
      case 3: 
        localdoq.qoj = locala.LVo.xG();
        AppMethodBeat.o(169092);
        return 0;
      case 4: 
        localdoq.FWo = locala.LVo.xG();
        AppMethodBeat.o(169092);
        return 0;
      }
      localdoq.FWp = locala.LVo.xG();
      AppMethodBeat.o(169092);
      return 0;
    }
    AppMethodBeat.o(169092);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.doq
 * JD-Core Version:    0.7.0.1
 */