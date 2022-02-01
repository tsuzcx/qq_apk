package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class edf
  extends com.tencent.mm.bw.a
{
  public String username;
  public int version;
  public String ypt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(197213);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.ypt != null) {
        paramVarArgs.d(2, this.ypt);
      }
      paramVarArgs.aS(3, this.version);
      AppMethodBeat.o(197213);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ypt != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ypt);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.version);
      AppMethodBeat.o(197213);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(197213);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        edf localedf = (edf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(197213);
          return -1;
        case 1: 
          localedf.username = locala.OmT.readString();
          AppMethodBeat.o(197213);
          return 0;
        case 2: 
          localedf.ypt = locala.OmT.readString();
          AppMethodBeat.o(197213);
          return 0;
        }
        localedf.version = locala.OmT.zc();
        AppMethodBeat.o(197213);
        return 0;
      }
      AppMethodBeat.o(197213);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edf
 * JD-Core Version:    0.7.0.1
 */