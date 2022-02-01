package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fmz
  extends com.tencent.mm.cd.a
{
  public int TuP;
  public String appid;
  public int ufE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(186877);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.f(1, this.appid);
      }
      paramVarArgs.aY(2, this.ufE);
      paramVarArgs.aY(3, this.TuP);
      AppMethodBeat.o(186877);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = g.a.a.b.b.a.g(1, this.appid) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.ufE);
      int j = g.a.a.b.b.a.bM(3, this.TuP);
      AppMethodBeat.o(186877);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(186877);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fmz localfmz = (fmz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(186877);
          return -1;
        case 1: 
          localfmz.appid = locala.abFh.readString();
          AppMethodBeat.o(186877);
          return 0;
        case 2: 
          localfmz.ufE = locala.abFh.AK();
          AppMethodBeat.o(186877);
          return 0;
        }
        localfmz.TuP = locala.abFh.AK();
        AppMethodBeat.o(186877);
        return 0;
      }
      AppMethodBeat.o(186877);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fmz
 * JD-Core Version:    0.7.0.1
 */