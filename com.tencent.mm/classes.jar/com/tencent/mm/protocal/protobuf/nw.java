package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class nw
  extends com.tencent.mm.bw.a
{
  public String FYs;
  public int GaB;
  public int GaC;
  public long GaD;
  public String GaE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124433);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GaB);
      paramVarArgs.aS(2, this.GaC);
      paramVarArgs.aZ(3, this.GaD);
      if (this.GaE != null) {
        paramVarArgs.d(4, this.GaE);
      }
      if (this.FYs != null) {
        paramVarArgs.d(5, this.FYs);
      }
      AppMethodBeat.o(124433);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.GaB) + 0 + f.a.a.b.b.a.bz(2, this.GaC) + f.a.a.b.b.a.p(3, this.GaD);
      paramInt = i;
      if (this.GaE != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GaE);
      }
      i = paramInt;
      if (this.FYs != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FYs);
      }
      AppMethodBeat.o(124433);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(124433);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      nw localnw = (nw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124433);
        return -1;
      case 1: 
        localnw.GaB = locala.OmT.zc();
        AppMethodBeat.o(124433);
        return 0;
      case 2: 
        localnw.GaC = locala.OmT.zc();
        AppMethodBeat.o(124433);
        return 0;
      case 3: 
        localnw.GaD = locala.OmT.zd();
        AppMethodBeat.o(124433);
        return 0;
      case 4: 
        localnw.GaE = locala.OmT.readString();
        AppMethodBeat.o(124433);
        return 0;
      }
      localnw.FYs = locala.OmT.readString();
      AppMethodBeat.o(124433);
      return 0;
    }
    AppMethodBeat.o(124433);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nw
 * JD-Core Version:    0.7.0.1
 */