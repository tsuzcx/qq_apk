package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class alx
  extends com.tencent.mm.bx.a
{
  public int GlC;
  public int GlD;
  public int GlE;
  public String country;
  public int ePk;
  public String ePu;
  public String ePv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168946);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.country != null) {
        paramVarArgs.d(1, this.country);
      }
      if (this.ePu != null) {
        paramVarArgs.d(2, this.ePu);
      }
      if (this.ePv != null) {
        paramVarArgs.d(3, this.ePv);
      }
      paramVarArgs.aS(4, this.ePk);
      paramVarArgs.aS(5, this.GlC);
      paramVarArgs.aS(6, this.GlD);
      paramVarArgs.aS(7, this.GlE);
      AppMethodBeat.o(168946);
      return 0;
    }
    if (paramInt == 1) {
      if (this.country == null) {
        break label522;
      }
    }
    label522:
    for (int i = f.a.a.b.b.a.e(1, this.country) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ePu != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ePu);
      }
      i = paramInt;
      if (this.ePv != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ePv);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.ePk);
      int j = f.a.a.b.b.a.bz(5, this.GlC);
      int k = f.a.a.b.b.a.bz(6, this.GlD);
      int m = f.a.a.b.b.a.bz(7, this.GlE);
      AppMethodBeat.o(168946);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(168946);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        alx localalx = (alx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(168946);
          return -1;
        case 1: 
          localalx.country = locala.NPN.readString();
          AppMethodBeat.o(168946);
          return 0;
        case 2: 
          localalx.ePu = locala.NPN.readString();
          AppMethodBeat.o(168946);
          return 0;
        case 3: 
          localalx.ePv = locala.NPN.readString();
          AppMethodBeat.o(168946);
          return 0;
        case 4: 
          localalx.ePk = locala.NPN.zc();
          AppMethodBeat.o(168946);
          return 0;
        case 5: 
          localalx.GlC = locala.NPN.zc();
          AppMethodBeat.o(168946);
          return 0;
        case 6: 
          localalx.GlD = locala.NPN.zc();
          AppMethodBeat.o(168946);
          return 0;
        }
        localalx.GlE = locala.NPN.zc();
        AppMethodBeat.o(168946);
        return 0;
      }
      AppMethodBeat.o(168946);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alx
 * JD-Core Version:    0.7.0.1
 */