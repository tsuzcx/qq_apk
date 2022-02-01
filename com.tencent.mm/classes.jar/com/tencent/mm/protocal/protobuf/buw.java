package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class buw
  extends com.tencent.mm.bx.a
{
  public long Fsa;
  public String GOI;
  public int GOU;
  public int GOV;
  public int GOW;
  public b GOX;
  public b GOY;
  public b GOZ;
  public String GPa;
  public long GPb;
  public long GPc;
  public String GPd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(211970);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GOU);
      if (this.GOI != null) {
        paramVarArgs.d(2, this.GOI);
      }
      paramVarArgs.aS(3, this.GOV);
      paramVarArgs.aS(4, this.GOW);
      if (this.GOX != null) {
        paramVarArgs.c(5, this.GOX);
      }
      if (this.GOY != null) {
        paramVarArgs.c(6, this.GOY);
      }
      if (this.GOZ != null) {
        paramVarArgs.c(7, this.GOZ);
      }
      if (this.GPa != null) {
        paramVarArgs.d(8, this.GPa);
      }
      paramVarArgs.aY(9, this.GPb);
      paramVarArgs.aY(10, this.GPc);
      paramVarArgs.aY(11, this.Fsa);
      if (this.GPd != null) {
        paramVarArgs.d(12, this.GPd);
      }
      AppMethodBeat.o(211970);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.GOU) + 0;
      paramInt = i;
      if (this.GOI != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GOI);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.GOV) + f.a.a.b.b.a.bz(4, this.GOW);
      paramInt = i;
      if (this.GOX != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.GOX);
      }
      i = paramInt;
      if (this.GOY != null) {
        i = paramInt + f.a.a.b.b.a.b(6, this.GOY);
      }
      paramInt = i;
      if (this.GOZ != null) {
        paramInt = i + f.a.a.b.b.a.b(7, this.GOZ);
      }
      i = paramInt;
      if (this.GPa != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.GPa);
      }
      i = i + f.a.a.b.b.a.p(9, this.GPb) + f.a.a.b.b.a.p(10, this.GPc) + f.a.a.b.b.a.p(11, this.Fsa);
      paramInt = i;
      if (this.GPd != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.GPd);
      }
      AppMethodBeat.o(211970);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(211970);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      buw localbuw = (buw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(211970);
        return -1;
      case 1: 
        localbuw.GOU = locala.NPN.zc();
        AppMethodBeat.o(211970);
        return 0;
      case 2: 
        localbuw.GOI = locala.NPN.readString();
        AppMethodBeat.o(211970);
        return 0;
      case 3: 
        localbuw.GOV = locala.NPN.zc();
        AppMethodBeat.o(211970);
        return 0;
      case 4: 
        localbuw.GOW = locala.NPN.zc();
        AppMethodBeat.o(211970);
        return 0;
      case 5: 
        localbuw.GOX = locala.NPN.gxI();
        AppMethodBeat.o(211970);
        return 0;
      case 6: 
        localbuw.GOY = locala.NPN.gxI();
        AppMethodBeat.o(211970);
        return 0;
      case 7: 
        localbuw.GOZ = locala.NPN.gxI();
        AppMethodBeat.o(211970);
        return 0;
      case 8: 
        localbuw.GPa = locala.NPN.readString();
        AppMethodBeat.o(211970);
        return 0;
      case 9: 
        localbuw.GPb = locala.NPN.zd();
        AppMethodBeat.o(211970);
        return 0;
      case 10: 
        localbuw.GPc = locala.NPN.zd();
        AppMethodBeat.o(211970);
        return 0;
      case 11: 
        localbuw.Fsa = locala.NPN.zd();
        AppMethodBeat.o(211970);
        return 0;
      }
      localbuw.GPd = locala.NPN.readString();
      AppMethodBeat.o(211970);
      return 0;
    }
    AppMethodBeat.o(211970);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buw
 * JD-Core Version:    0.7.0.1
 */