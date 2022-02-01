package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class atj
  extends com.tencent.mm.bx.a
{
  public String Grt;
  public String Gru;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169383);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Grt != null) {
        paramVarArgs.d(1, this.Grt);
      }
      if (this.Gru != null) {
        paramVarArgs.d(2, this.Gru);
      }
      AppMethodBeat.o(169383);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Grt == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.Grt) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Gru != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Gru);
      }
      AppMethodBeat.o(169383);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(169383);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        atj localatj = (atj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(169383);
          return -1;
        case 1: 
          localatj.Grt = locala.NPN.readString();
          AppMethodBeat.o(169383);
          return 0;
        }
        localatj.Gru = locala.NPN.readString();
        AppMethodBeat.o(169383);
        return 0;
      }
      AppMethodBeat.o(169383);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atj
 * JD-Core Version:    0.7.0.1
 */