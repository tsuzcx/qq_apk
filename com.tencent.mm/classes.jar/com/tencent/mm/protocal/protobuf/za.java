package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class za
  extends com.tencent.mm.bw.a
{
  public String EpD;
  public LinkedList<Integer> Etf;
  
  public za()
  {
    AppMethodBeat.i(32170);
    this.Etf = new LinkedList();
    AppMethodBeat.o(32170);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32171);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EpD != null) {
        paramVarArgs.d(1, this.EpD);
      }
      paramVarArgs.e(2, 2, this.Etf);
      AppMethodBeat.o(32171);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EpD == null) {
        break label285;
      }
    }
    label285:
    for (paramInt = f.a.a.b.b.a.e(1, this.EpD) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 2, this.Etf);
      AppMethodBeat.o(32171);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Etf.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32171);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        za localza = (za)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32171);
          return -1;
        case 1: 
          localza.EpD = locala.LVo.readString();
          AppMethodBeat.o(32171);
          return 0;
        }
        localza.Etf.add(Integer.valueOf(locala.LVo.xF()));
        AppMethodBeat.o(32171);
        return 0;
      }
      AppMethodBeat.o(32171);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.za
 * JD-Core Version:    0.7.0.1
 */