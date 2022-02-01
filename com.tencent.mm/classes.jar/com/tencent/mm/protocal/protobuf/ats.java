package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ats
  extends com.tencent.mm.bw.a
{
  public int index;
  public int kyd;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32211);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.index);
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      paramVarArgs.aS(3, this.kyd);
      AppMethodBeat.o(32211);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.index) + 0;
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.username);
      }
      i = f.a.a.b.b.a.bz(3, this.kyd);
      AppMethodBeat.o(32211);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(32211);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ats localats = (ats)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32211);
        return -1;
      case 1: 
        localats.index = locala.OmT.zc();
        AppMethodBeat.o(32211);
        return 0;
      case 2: 
        localats.username = locala.OmT.readString();
        AppMethodBeat.o(32211);
        return 0;
      }
      localats.kyd = locala.OmT.zc();
      AppMethodBeat.o(32211);
      return 0;
    }
    AppMethodBeat.o(32211);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ats
 * JD-Core Version:    0.7.0.1
 */