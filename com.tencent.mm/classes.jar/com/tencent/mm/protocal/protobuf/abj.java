package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class abj
  extends com.tencent.mm.bw.a
{
  public String Gpn;
  public LinkedList<Integer> Gtd;
  
  public abj()
  {
    AppMethodBeat.i(32170);
    this.Gtd = new LinkedList();
    AppMethodBeat.o(32170);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32171);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gpn != null) {
        paramVarArgs.d(1, this.Gpn);
      }
      paramVarArgs.e(2, 2, this.Gtd);
      AppMethodBeat.o(32171);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gpn == null) {
        break label285;
      }
    }
    label285:
    for (paramInt = f.a.a.b.b.a.e(1, this.Gpn) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 2, this.Gtd);
      AppMethodBeat.o(32171);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gtd.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32171);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        abj localabj = (abj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32171);
          return -1;
        case 1: 
          localabj.Gpn = locala.OmT.readString();
          AppMethodBeat.o(32171);
          return 0;
        }
        localabj.Gtd.add(Integer.valueOf(locala.OmT.zc()));
        AppMethodBeat.o(32171);
        return 0;
      }
      AppMethodBeat.o(32171);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abj
 * JD-Core Version:    0.7.0.1
 */