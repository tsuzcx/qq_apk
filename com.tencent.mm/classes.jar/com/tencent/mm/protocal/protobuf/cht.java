package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cht
  extends com.tencent.mm.bx.a
{
  public String Geb;
  public int Hbp;
  public int Hbq;
  public int Hbr;
  public long Hbs;
  public int Hbt;
  public int Hbu;
  public String ukw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104825);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Hbp);
      paramVarArgs.aS(2, this.Hbq);
      paramVarArgs.aS(3, this.Hbr);
      if (this.ukw != null) {
        paramVarArgs.d(4, this.ukw);
      }
      paramVarArgs.aY(5, this.Hbs);
      paramVarArgs.aS(6, this.Hbt);
      if (this.Geb != null) {
        paramVarArgs.d(7, this.Geb);
      }
      paramVarArgs.aS(8, this.Hbu);
      AppMethodBeat.o(104825);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Hbp) + 0 + f.a.a.b.b.a.bz(2, this.Hbq) + f.a.a.b.b.a.bz(3, this.Hbr);
      paramInt = i;
      if (this.ukw != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ukw);
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.Hbs) + f.a.a.b.b.a.bz(6, this.Hbt);
      paramInt = i;
      if (this.Geb != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Geb);
      }
      i = f.a.a.b.b.a.bz(8, this.Hbu);
      AppMethodBeat.o(104825);
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
      AppMethodBeat.o(104825);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cht localcht = (cht)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104825);
        return -1;
      case 1: 
        localcht.Hbp = locala.NPN.zc();
        AppMethodBeat.o(104825);
        return 0;
      case 2: 
        localcht.Hbq = locala.NPN.zc();
        AppMethodBeat.o(104825);
        return 0;
      case 3: 
        localcht.Hbr = locala.NPN.zc();
        AppMethodBeat.o(104825);
        return 0;
      case 4: 
        localcht.ukw = locala.NPN.readString();
        AppMethodBeat.o(104825);
        return 0;
      case 5: 
        localcht.Hbs = locala.NPN.zd();
        AppMethodBeat.o(104825);
        return 0;
      case 6: 
        localcht.Hbt = locala.NPN.zc();
        AppMethodBeat.o(104825);
        return 0;
      case 7: 
        localcht.Geb = locala.NPN.readString();
        AppMethodBeat.o(104825);
        return 0;
      }
      localcht.Hbu = locala.NPN.zc();
      AppMethodBeat.o(104825);
      return 0;
    }
    AppMethodBeat.o(104825);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cht
 * JD-Core Version:    0.7.0.1
 */