package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eiu
  extends com.tencent.mm.bx.a
{
  public int HTq;
  public String HTr;
  public String tRU;
  public String uku;
  public String ukw;
  public String ukx;
  public int uky;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152730);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HTq);
      if (this.tRU != null) {
        paramVarArgs.d(2, this.tRU);
      }
      if (this.uku != null) {
        paramVarArgs.d(3, this.uku);
      }
      if (this.HTr != null) {
        paramVarArgs.d(4, this.HTr);
      }
      if (this.ukw != null) {
        paramVarArgs.d(5, this.ukw);
      }
      if (this.ukx != null) {
        paramVarArgs.d(6, this.ukx);
      }
      paramVarArgs.aS(7, this.uky);
      AppMethodBeat.o(152730);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.HTq) + 0;
      paramInt = i;
      if (this.tRU != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.tRU);
      }
      i = paramInt;
      if (this.uku != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uku);
      }
      paramInt = i;
      if (this.HTr != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HTr);
      }
      i = paramInt;
      if (this.ukw != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ukw);
      }
      paramInt = i;
      if (this.ukx != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.ukx);
      }
      i = f.a.a.b.b.a.bz(7, this.uky);
      AppMethodBeat.o(152730);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(152730);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eiu localeiu = (eiu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152730);
        return -1;
      case 1: 
        localeiu.HTq = locala.NPN.zc();
        AppMethodBeat.o(152730);
        return 0;
      case 2: 
        localeiu.tRU = locala.NPN.readString();
        AppMethodBeat.o(152730);
        return 0;
      case 3: 
        localeiu.uku = locala.NPN.readString();
        AppMethodBeat.o(152730);
        return 0;
      case 4: 
        localeiu.HTr = locala.NPN.readString();
        AppMethodBeat.o(152730);
        return 0;
      case 5: 
        localeiu.ukw = locala.NPN.readString();
        AppMethodBeat.o(152730);
        return 0;
      case 6: 
        localeiu.ukx = locala.NPN.readString();
        AppMethodBeat.o(152730);
        return 0;
      }
      localeiu.uky = locala.NPN.zc();
      AppMethodBeat.o(152730);
      return 0;
    }
    AppMethodBeat.o(152730);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eiu
 * JD-Core Version:    0.7.0.1
 */