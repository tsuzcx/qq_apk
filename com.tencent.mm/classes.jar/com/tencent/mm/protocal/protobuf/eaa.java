package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eaa
  extends com.tencent.mm.bw.a
{
  public int CsN;
  public int CsO;
  public String dyO;
  public int nMX;
  public String userName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115904);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.nMX);
      paramVarArgs.aS(2, this.CsO);
      paramVarArgs.aS(3, this.CsN);
      if (this.userName != null) {
        paramVarArgs.d(4, this.userName);
      }
      if (this.dyO != null) {
        paramVarArgs.d(5, this.dyO);
      }
      AppMethodBeat.o(115904);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.nMX) + 0 + f.a.a.b.b.a.bz(2, this.CsO) + f.a.a.b.b.a.bz(3, this.CsN);
      paramInt = i;
      if (this.userName != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.userName);
      }
      i = paramInt;
      if (this.dyO != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.dyO);
      }
      AppMethodBeat.o(115904);
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
      AppMethodBeat.o(115904);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eaa localeaa = (eaa)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115904);
        return -1;
      case 1: 
        localeaa.nMX = locala.OmT.zc();
        AppMethodBeat.o(115904);
        return 0;
      case 2: 
        localeaa.CsO = locala.OmT.zc();
        AppMethodBeat.o(115904);
        return 0;
      case 3: 
        localeaa.CsN = locala.OmT.zc();
        AppMethodBeat.o(115904);
        return 0;
      case 4: 
        localeaa.userName = locala.OmT.readString();
        AppMethodBeat.o(115904);
        return 0;
      }
      localeaa.dyO = locala.OmT.readString();
      AppMethodBeat.o(115904);
      return 0;
    }
    AppMethodBeat.o(115904);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eaa
 * JD-Core Version:    0.7.0.1
 */