package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cbv
  extends com.tencent.mm.bw.a
{
  public String LWD;
  public String LjD;
  public long LpD;
  public int MhI;
  public long MhJ;
  public long MhK;
  public String icon;
  public int nHh;
  public String pTn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72504);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LjD != null) {
        paramVarArgs.e(1, this.LjD);
      }
      paramVarArgs.bb(2, this.LpD);
      paramVarArgs.aM(3, this.MhI);
      paramVarArgs.bb(4, this.MhJ);
      paramVarArgs.bb(5, this.MhK);
      if (this.LWD != null) {
        paramVarArgs.e(6, this.LWD);
      }
      if (this.pTn != null) {
        paramVarArgs.e(7, this.pTn);
      }
      paramVarArgs.aM(8, this.nHh);
      if (this.icon != null) {
        paramVarArgs.e(9, this.icon);
      }
      AppMethodBeat.o(72504);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LjD == null) {
        break label618;
      }
    }
    label618:
    for (paramInt = g.a.a.b.b.a.f(1, this.LjD) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.LpD) + g.a.a.b.b.a.bu(3, this.MhI) + g.a.a.b.b.a.r(4, this.MhJ) + g.a.a.b.b.a.r(5, this.MhK);
      paramInt = i;
      if (this.LWD != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LWD);
      }
      i = paramInt;
      if (this.pTn != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.pTn);
      }
      i += g.a.a.b.b.a.bu(8, this.nHh);
      paramInt = i;
      if (this.icon != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.icon);
      }
      AppMethodBeat.o(72504);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72504);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cbv localcbv = (cbv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72504);
          return -1;
        case 1: 
          localcbv.LjD = locala.UbS.readString();
          AppMethodBeat.o(72504);
          return 0;
        case 2: 
          localcbv.LpD = locala.UbS.zl();
          AppMethodBeat.o(72504);
          return 0;
        case 3: 
          localcbv.MhI = locala.UbS.zi();
          AppMethodBeat.o(72504);
          return 0;
        case 4: 
          localcbv.MhJ = locala.UbS.zl();
          AppMethodBeat.o(72504);
          return 0;
        case 5: 
          localcbv.MhK = locala.UbS.zl();
          AppMethodBeat.o(72504);
          return 0;
        case 6: 
          localcbv.LWD = locala.UbS.readString();
          AppMethodBeat.o(72504);
          return 0;
        case 7: 
          localcbv.pTn = locala.UbS.readString();
          AppMethodBeat.o(72504);
          return 0;
        case 8: 
          localcbv.nHh = locala.UbS.zi();
          AppMethodBeat.o(72504);
          return 0;
        }
        localcbv.icon = locala.UbS.readString();
        AppMethodBeat.o(72504);
        return 0;
      }
      AppMethodBeat.o(72504);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbv
 * JD-Core Version:    0.7.0.1
 */