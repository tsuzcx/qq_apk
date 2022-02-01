package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cjj
  extends com.tencent.mm.bx.a
{
  public String Hdo;
  public String Hdp;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91595);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.Hdo != null) {
        paramVarArgs.d(2, this.Hdo);
      }
      if (this.Hdp != null) {
        paramVarArgs.d(3, this.Hdp);
      }
      AppMethodBeat.o(91595);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hdo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Hdo);
      }
      i = paramInt;
      if (this.Hdp != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Hdp);
      }
      AppMethodBeat.o(91595);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91595);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cjj localcjj = (cjj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91595);
          return -1;
        case 1: 
          localcjj.title = locala.NPN.readString();
          AppMethodBeat.o(91595);
          return 0;
        case 2: 
          localcjj.Hdo = locala.NPN.readString();
          AppMethodBeat.o(91595);
          return 0;
        }
        localcjj.Hdp = locala.NPN.readString();
        AppMethodBeat.o(91595);
        return 0;
      }
      AppMethodBeat.o(91595);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjj
 * JD-Core Version:    0.7.0.1
 */