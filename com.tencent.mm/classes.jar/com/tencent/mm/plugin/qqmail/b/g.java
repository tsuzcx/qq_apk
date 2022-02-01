package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends com.tencent.mm.bw.a
{
  public int FileSize;
  public int ndj;
  public int vTO;
  public String vTP;
  public long vTQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122660);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.vTO);
      if (this.vTP != null) {
        paramVarArgs.d(2, this.vTP);
      }
      paramVarArgs.aR(3, this.ndj);
      paramVarArgs.aR(4, this.FileSize);
      paramVarArgs.aO(5, this.vTQ);
      AppMethodBeat.o(122660);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.vTO) + 0;
      paramInt = i;
      if (this.vTP != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.vTP);
      }
      i = f.a.a.b.b.a.bx(3, this.ndj);
      int j = f.a.a.b.b.a.bx(4, this.FileSize);
      int k = f.a.a.b.b.a.p(5, this.vTQ);
      AppMethodBeat.o(122660);
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
      AppMethodBeat.o(122660);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      g localg = (g)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(122660);
        return -1;
      case 1: 
        localg.vTO = locala.LVo.xF();
        AppMethodBeat.o(122660);
        return 0;
      case 2: 
        localg.vTP = locala.LVo.readString();
        AppMethodBeat.o(122660);
        return 0;
      case 3: 
        localg.ndj = locala.LVo.xF();
        AppMethodBeat.o(122660);
        return 0;
      case 4: 
        localg.FileSize = locala.LVo.xF();
        AppMethodBeat.o(122660);
        return 0;
      }
      localg.vTQ = locala.LVo.xG();
      AppMethodBeat.o(122660);
      return 0;
    }
    AppMethodBeat.o(122660);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.g
 * JD-Core Version:    0.7.0.1
 */