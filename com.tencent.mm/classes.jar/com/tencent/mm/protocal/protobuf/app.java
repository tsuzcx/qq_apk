package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class app
  extends com.tencent.mm.bw.a
{
  public int GGI;
  public int GGJ;
  public String dEk;
  public String suu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184203);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dEk != null) {
        paramVarArgs.d(1, this.dEk);
      }
      paramVarArgs.aS(2, this.GGI);
      paramVarArgs.aS(3, this.GGJ);
      if (this.suu != null) {
        paramVarArgs.d(4, this.suu);
      }
      AppMethodBeat.o(184203);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dEk == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = f.a.a.b.b.a.e(1, this.dEk) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GGI) + f.a.a.b.b.a.bz(3, this.GGJ);
      paramInt = i;
      if (this.suu != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.suu);
      }
      AppMethodBeat.o(184203);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(184203);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        app localapp = (app)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(184203);
          return -1;
        case 1: 
          localapp.dEk = locala.OmT.readString();
          AppMethodBeat.o(184203);
          return 0;
        case 2: 
          localapp.GGI = locala.OmT.zc();
          AppMethodBeat.o(184203);
          return 0;
        case 3: 
          localapp.GGJ = locala.OmT.zc();
          AppMethodBeat.o(184203);
          return 0;
        }
        localapp.suu = locala.OmT.readString();
        AppMethodBeat.o(184203);
        return 0;
      }
      AppMethodBeat.o(184203);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.app
 * JD-Core Version:    0.7.0.1
 */