package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class eaa
  extends com.tencent.mm.bw.a
{
  public int EdN;
  public int Een;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123692);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      paramVarArgs.aR(2, this.EdN);
      paramVarArgs.aR(3, this.Een);
      AppMethodBeat.o(123692);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = f.a.a.b.b.a.e(1, this.username) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.EdN);
      int j = f.a.a.b.b.a.bx(3, this.Een);
      AppMethodBeat.o(123692);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(123692);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        eaa localeaa = (eaa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123692);
          return -1;
        case 1: 
          localeaa.username = locala.LVo.readString();
          AppMethodBeat.o(123692);
          return 0;
        case 2: 
          localeaa.EdN = locala.LVo.xF();
          AppMethodBeat.o(123692);
          return 0;
        }
        localeaa.Een = locala.LVo.xF();
        AppMethodBeat.o(123692);
        return 0;
      }
      AppMethodBeat.o(123692);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eaa
 * JD-Core Version:    0.7.0.1
 */