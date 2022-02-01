package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ahv
  extends com.tencent.mm.bw.a
{
  public int GxH;
  public int GxI;
  public int GxJ;
  public String GxK;
  public int GxL;
  public String GxM;
  public int GxN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196257);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GxH);
      paramVarArgs.aS(2, this.GxI);
      paramVarArgs.aS(3, this.GxJ);
      if (this.GxK != null) {
        paramVarArgs.d(4, this.GxK);
      }
      paramVarArgs.aS(5, this.GxL);
      if (this.GxM != null) {
        paramVarArgs.d(6, this.GxM);
      }
      paramVarArgs.aS(7, this.GxN);
      AppMethodBeat.o(196257);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.GxH) + 0 + f.a.a.b.b.a.bz(2, this.GxI) + f.a.a.b.b.a.bz(3, this.GxJ);
      paramInt = i;
      if (this.GxK != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GxK);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.GxL);
      paramInt = i;
      if (this.GxM != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GxM);
      }
      i = f.a.a.b.b.a.bz(7, this.GxN);
      AppMethodBeat.o(196257);
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
      AppMethodBeat.o(196257);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ahv localahv = (ahv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(196257);
        return -1;
      case 1: 
        localahv.GxH = locala.OmT.zc();
        AppMethodBeat.o(196257);
        return 0;
      case 2: 
        localahv.GxI = locala.OmT.zc();
        AppMethodBeat.o(196257);
        return 0;
      case 3: 
        localahv.GxJ = locala.OmT.zc();
        AppMethodBeat.o(196257);
        return 0;
      case 4: 
        localahv.GxK = locala.OmT.readString();
        AppMethodBeat.o(196257);
        return 0;
      case 5: 
        localahv.GxL = locala.OmT.zc();
        AppMethodBeat.o(196257);
        return 0;
      case 6: 
        localahv.GxM = locala.OmT.readString();
        AppMethodBeat.o(196257);
        return 0;
      }
      localahv.GxN = locala.OmT.zc();
      AppMethodBeat.o(196257);
      return 0;
    }
    AppMethodBeat.o(196257);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahv
 * JD-Core Version:    0.7.0.1
 */