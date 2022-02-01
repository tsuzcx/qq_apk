package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bng
  extends com.tencent.mm.bx.a
{
  public int GHi;
  public com.tencent.mm.bx.b GHj;
  public com.tencent.mm.bx.b GHk;
  public com.tencent.mm.bx.b GHl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115844);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GHj == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: SPSBuf");
        AppMethodBeat.o(115844);
        throw paramVarArgs;
      }
      if (this.GHk == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: PPSBuf");
        AppMethodBeat.o(115844);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.GHi);
      if (this.GHj != null) {
        paramVarArgs.c(2, this.GHj);
      }
      if (this.GHk != null) {
        paramVarArgs.c(3, this.GHk);
      }
      if (this.GHl != null) {
        paramVarArgs.c(4, this.GHl);
      }
      AppMethodBeat.o(115844);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.GHi) + 0;
      paramInt = i;
      if (this.GHj != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.GHj);
      }
      i = paramInt;
      if (this.GHk != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.GHk);
      }
      paramInt = i;
      if (this.GHl != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.GHl);
      }
      AppMethodBeat.o(115844);
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
      if (this.GHj == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: SPSBuf");
        AppMethodBeat.o(115844);
        throw paramVarArgs;
      }
      if (this.GHk == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: PPSBuf");
        AppMethodBeat.o(115844);
        throw paramVarArgs;
      }
      AppMethodBeat.o(115844);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bng localbng = (bng)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115844);
        return -1;
      case 1: 
        localbng.GHi = locala.NPN.zc();
        AppMethodBeat.o(115844);
        return 0;
      case 2: 
        localbng.GHj = locala.NPN.gxI();
        AppMethodBeat.o(115844);
        return 0;
      case 3: 
        localbng.GHk = locala.NPN.gxI();
        AppMethodBeat.o(115844);
        return 0;
      }
      localbng.GHl = locala.NPN.gxI();
      AppMethodBeat.o(115844);
      return 0;
    }
    AppMethodBeat.o(115844);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bng
 * JD-Core Version:    0.7.0.1
 */