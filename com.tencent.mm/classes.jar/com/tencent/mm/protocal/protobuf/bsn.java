package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bsn
  extends com.tencent.mm.bx.a
{
  public int yhn;
  public String yhw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43100);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.yhn);
      if (this.yhw != null) {
        paramVarArgs.d(2, this.yhw);
      }
      AppMethodBeat.o(43100);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.yhn) + 0;
      paramInt = i;
      if (this.yhw != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.yhw);
      }
      AppMethodBeat.o(43100);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(43100);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bsn localbsn = (bsn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43100);
        return -1;
      case 1: 
        localbsn.yhn = locala.NPN.zc();
        AppMethodBeat.o(43100);
        return 0;
      }
      localbsn.yhw = locala.NPN.readString();
      AppMethodBeat.o(43100);
      return 0;
    }
    AppMethodBeat.o(43100);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsn
 * JD-Core Version:    0.7.0.1
 */