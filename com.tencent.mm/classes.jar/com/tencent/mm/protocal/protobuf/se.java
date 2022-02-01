package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class se
  extends com.tencent.mm.bw.a
{
  public int Ghp;
  public int Ghq;
  public String Ghr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91386);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Ghp);
      paramVarArgs.aS(2, this.Ghq);
      if (this.Ghr != null) {
        paramVarArgs.d(3, this.Ghr);
      }
      AppMethodBeat.o(91386);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Ghp) + 0 + f.a.a.b.b.a.bz(2, this.Ghq);
      paramInt = i;
      if (this.Ghr != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Ghr);
      }
      AppMethodBeat.o(91386);
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
      AppMethodBeat.o(91386);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      se localse = (se)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91386);
        return -1;
      case 1: 
        localse.Ghp = locala.OmT.zc();
        AppMethodBeat.o(91386);
        return 0;
      case 2: 
        localse.Ghq = locala.OmT.zc();
        AppMethodBeat.o(91386);
        return 0;
      }
      localse.Ghr = locala.OmT.readString();
      AppMethodBeat.o(91386);
      return 0;
    }
    AppMethodBeat.o(91386);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.se
 * JD-Core Version:    0.7.0.1
 */