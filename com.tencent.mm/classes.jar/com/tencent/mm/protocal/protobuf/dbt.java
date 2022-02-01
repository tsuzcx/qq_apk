package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dbt
  extends com.tencent.mm.bw.a
{
  public int FLb;
  public int FLc;
  public int iKe;
  public String iKf;
  public long iKg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43131);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.iKe);
      if (this.iKf != null) {
        paramVarArgs.d(2, this.iKf);
      }
      paramVarArgs.aO(3, this.iKg);
      paramVarArgs.aR(4, this.FLb);
      paramVarArgs.aR(5, this.FLc);
      AppMethodBeat.o(43131);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.iKe) + 0;
      paramInt = i;
      if (this.iKf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.iKf);
      }
      i = f.a.a.b.b.a.p(3, this.iKg);
      int j = f.a.a.b.b.a.bx(4, this.FLb);
      int k = f.a.a.b.b.a.bx(5, this.FLc);
      AppMethodBeat.o(43131);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(43131);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dbt localdbt = (dbt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43131);
        return -1;
      case 1: 
        localdbt.iKe = locala.LVo.xF();
        AppMethodBeat.o(43131);
        return 0;
      case 2: 
        localdbt.iKf = locala.LVo.readString();
        AppMethodBeat.o(43131);
        return 0;
      case 3: 
        localdbt.iKg = locala.LVo.xG();
        AppMethodBeat.o(43131);
        return 0;
      case 4: 
        localdbt.FLb = locala.LVo.xF();
        AppMethodBeat.o(43131);
        return 0;
      }
      localdbt.FLc = locala.LVo.xF();
      AppMethodBeat.o(43131);
      return 0;
    }
    AppMethodBeat.o(43131);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbt
 * JD-Core Version:    0.7.0.1
 */