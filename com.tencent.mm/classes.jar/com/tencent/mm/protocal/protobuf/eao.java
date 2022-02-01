package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eao
  extends com.tencent.mm.bw.a
{
  public String Username;
  public int nJb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115924);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Username != null) {
        paramVarArgs.d(1, this.Username);
      }
      paramVarArgs.aS(2, this.nJb);
      AppMethodBeat.o(115924);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = f.a.a.b.b.a.e(1, this.Username) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.nJb);
      AppMethodBeat.o(115924);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(115924);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        eao localeao = (eao)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(115924);
          return -1;
        case 1: 
          localeao.Username = locala.OmT.readString();
          AppMethodBeat.o(115924);
          return 0;
        }
        localeao.nJb = locala.OmT.zc();
        AppMethodBeat.o(115924);
        return 0;
      }
      AppMethodBeat.o(115924);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eao
 * JD-Core Version:    0.7.0.1
 */