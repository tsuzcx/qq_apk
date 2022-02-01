package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class acp
  extends com.tencent.mm.bw.a
{
  public int jgj;
  public String jgk;
  public String jgl;
  public String jgm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117864);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.jgj);
      if (this.jgk != null) {
        paramVarArgs.d(2, this.jgk);
      }
      if (this.jgl != null) {
        paramVarArgs.d(3, this.jgl);
      }
      if (this.jgm != null) {
        paramVarArgs.d(4, this.jgm);
      }
      AppMethodBeat.o(117864);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.jgj) + 0;
      paramInt = i;
      if (this.jgk != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.jgk);
      }
      i = paramInt;
      if (this.jgl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.jgl);
      }
      paramInt = i;
      if (this.jgm != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.jgm);
      }
      AppMethodBeat.o(117864);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(117864);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      acp localacp = (acp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117864);
        return -1;
      case 1: 
        localacp.jgj = locala.OmT.zc();
        AppMethodBeat.o(117864);
        return 0;
      case 2: 
        localacp.jgk = locala.OmT.readString();
        AppMethodBeat.o(117864);
        return 0;
      case 3: 
        localacp.jgl = locala.OmT.readString();
        AppMethodBeat.o(117864);
        return 0;
      }
      localacp.jgm = locala.OmT.readString();
      AppMethodBeat.o(117864);
      return 0;
    }
    AppMethodBeat.o(117864);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acp
 * JD-Core Version:    0.7.0.1
 */