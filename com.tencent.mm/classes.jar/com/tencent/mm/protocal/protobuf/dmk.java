package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dmk
  extends com.tencent.mm.bw.a
{
  public String GnM;
  public int Gtv;
  public int HAn;
  public String nIJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32460);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nIJ != null) {
        paramVarArgs.d(1, this.nIJ);
      }
      if (this.GnM != null) {
        paramVarArgs.d(2, this.GnM);
      }
      paramVarArgs.aS(3, this.HAn);
      paramVarArgs.aS(4, this.Gtv);
      AppMethodBeat.o(32460);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nIJ == null) {
        break label376;
      }
    }
    label376:
    for (paramInt = f.a.a.b.b.a.e(1, this.nIJ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GnM != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GnM);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.HAn);
      int j = f.a.a.b.b.a.bz(4, this.Gtv);
      AppMethodBeat.o(32460);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32460);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dmk localdmk = (dmk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32460);
          return -1;
        case 1: 
          localdmk.nIJ = locala.OmT.readString();
          AppMethodBeat.o(32460);
          return 0;
        case 2: 
          localdmk.GnM = locala.OmT.readString();
          AppMethodBeat.o(32460);
          return 0;
        case 3: 
          localdmk.HAn = locala.OmT.zc();
          AppMethodBeat.o(32460);
          return 0;
        }
        localdmk.Gtv = locala.OmT.zc();
        AppMethodBeat.o(32460);
        return 0;
      }
      AppMethodBeat.o(32460);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmk
 * JD-Core Version:    0.7.0.1
 */