package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class duj
  extends com.tencent.mm.bx.a
{
  public int CLK;
  public int CLl;
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
      paramVarArgs.aR(2, this.CLl);
      paramVarArgs.aR(3, this.CLK);
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
      int i = f.a.a.b.b.a.bA(2, this.CLl);
      int j = f.a.a.b.b.a.bA(3, this.CLK);
      AppMethodBeat.o(123692);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(123692);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        duj localduj = (duj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123692);
          return -1;
        case 1: 
          localduj.username = locala.KhF.readString();
          AppMethodBeat.o(123692);
          return 0;
        case 2: 
          localduj.CLl = locala.KhF.xS();
          AppMethodBeat.o(123692);
          return 0;
        }
        localduj.CLK = locala.KhF.xS();
        AppMethodBeat.o(123692);
        return 0;
      }
      AppMethodBeat.o(123692);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duj
 * JD-Core Version:    0.7.0.1
 */