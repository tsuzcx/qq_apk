package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eiq
  extends com.tencent.mm.bw.a
{
  public int Hkr;
  public int IlJ;
  public long IlQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50119);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Hkr);
      paramVarArgs.aZ(2, this.IlQ);
      paramVarArgs.aS(3, this.IlJ);
      AppMethodBeat.o(50119);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.Hkr);
      int i = f.a.a.b.b.a.p(2, this.IlQ);
      int j = f.a.a.b.b.a.bz(3, this.IlJ);
      AppMethodBeat.o(50119);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(50119);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eiq localeiq = (eiq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50119);
        return -1;
      case 1: 
        localeiq.Hkr = locala.OmT.zc();
        AppMethodBeat.o(50119);
        return 0;
      case 2: 
        localeiq.IlQ = locala.OmT.zd();
        AppMethodBeat.o(50119);
        return 0;
      }
      localeiq.IlJ = locala.OmT.zc();
      AppMethodBeat.o(50119);
      return 0;
    }
    AppMethodBeat.o(50119);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eiq
 * JD-Core Version:    0.7.0.1
 */