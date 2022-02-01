package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eij
  extends com.tencent.mm.bw.a
{
  public int FNw;
  public int Hkr;
  public int IlJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123703);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Hkr);
      paramVarArgs.aS(2, this.FNw);
      paramVarArgs.aS(3, this.IlJ);
      AppMethodBeat.o(123703);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.Hkr);
      int i = f.a.a.b.b.a.bz(2, this.FNw);
      int j = f.a.a.b.b.a.bz(3, this.IlJ);
      AppMethodBeat.o(123703);
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
      AppMethodBeat.o(123703);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eij localeij = (eij)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123703);
        return -1;
      case 1: 
        localeij.Hkr = locala.OmT.zc();
        AppMethodBeat.o(123703);
        return 0;
      case 2: 
        localeij.FNw = locala.OmT.zc();
        AppMethodBeat.o(123703);
        return 0;
      }
      localeij.IlJ = locala.OmT.zc();
      AppMethodBeat.o(123703);
      return 0;
    }
    AppMethodBeat.o(123703);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eij
 * JD-Core Version:    0.7.0.1
 */