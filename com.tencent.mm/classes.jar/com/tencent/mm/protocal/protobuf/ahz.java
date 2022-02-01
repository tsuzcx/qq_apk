package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ahz
  extends com.tencent.mm.bw.a
{
  public int GxH;
  public int GxI;
  public int GxJ;
  public String GxK;
  public int GxL;
  public String GxM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122488);
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
      AppMethodBeat.o(122488);
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
      AppMethodBeat.o(122488);
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
      AppMethodBeat.o(122488);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ahz localahz = (ahz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(122488);
        return -1;
      case 1: 
        localahz.GxH = locala.OmT.zc();
        AppMethodBeat.o(122488);
        return 0;
      case 2: 
        localahz.GxI = locala.OmT.zc();
        AppMethodBeat.o(122488);
        return 0;
      case 3: 
        localahz.GxJ = locala.OmT.zc();
        AppMethodBeat.o(122488);
        return 0;
      case 4: 
        localahz.GxK = locala.OmT.readString();
        AppMethodBeat.o(122488);
        return 0;
      case 5: 
        localahz.GxL = locala.OmT.zc();
        AppMethodBeat.o(122488);
        return 0;
      }
      localahz.GxM = locala.OmT.readString();
      AppMethodBeat.o(122488);
      return 0;
    }
    AppMethodBeat.o(122488);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahz
 * JD-Core Version:    0.7.0.1
 */