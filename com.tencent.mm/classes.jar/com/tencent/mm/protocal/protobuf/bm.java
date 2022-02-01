package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class bm
  extends com.tencent.mm.bx.a
{
  public b FtA;
  public int FtB;
  public int FtC;
  public String FtD;
  public String FtE;
  public String FtF;
  public String FtG;
  public String FtH;
  public String FtI;
  public int Fty;
  public int Ftz;
  public String imei;
  public int uin;
  public String yWM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125690);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.uin);
      paramVarArgs.aS(2, this.Fty);
      paramVarArgs.aS(3, this.Ftz);
      if (this.FtA != null) {
        paramVarArgs.c(4, this.FtA);
      }
      paramVarArgs.aS(5, this.FtB);
      paramVarArgs.aS(6, this.FtC);
      if (this.yWM != null) {
        paramVarArgs.d(7, this.yWM);
      }
      if (this.imei != null) {
        paramVarArgs.d(8, this.imei);
      }
      if (this.FtD != null) {
        paramVarArgs.d(9, this.FtD);
      }
      if (this.FtE != null) {
        paramVarArgs.d(10, this.FtE);
      }
      if (this.FtF != null) {
        paramVarArgs.d(11, this.FtF);
      }
      if (this.FtG != null) {
        paramVarArgs.d(12, this.FtG);
      }
      if (this.FtH != null) {
        paramVarArgs.d(13, this.FtH);
      }
      if (this.FtI != null) {
        paramVarArgs.d(14, this.FtI);
      }
      AppMethodBeat.o(125690);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.uin) + 0 + f.a.a.b.b.a.bz(2, this.Fty) + f.a.a.b.b.a.bz(3, this.Ftz);
      paramInt = i;
      if (this.FtA != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.FtA);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.FtB) + f.a.a.b.b.a.bz(6, this.FtC);
      paramInt = i;
      if (this.yWM != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.yWM);
      }
      i = paramInt;
      if (this.imei != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.imei);
      }
      paramInt = i;
      if (this.FtD != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.FtD);
      }
      i = paramInt;
      if (this.FtE != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.FtE);
      }
      paramInt = i;
      if (this.FtF != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.FtF);
      }
      i = paramInt;
      if (this.FtG != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.FtG);
      }
      paramInt = i;
      if (this.FtH != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.FtH);
      }
      i = paramInt;
      if (this.FtI != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.FtI);
      }
      AppMethodBeat.o(125690);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(125690);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bm localbm = (bm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125690);
        return -1;
      case 1: 
        localbm.uin = locala.NPN.zc();
        AppMethodBeat.o(125690);
        return 0;
      case 2: 
        localbm.Fty = locala.NPN.zc();
        AppMethodBeat.o(125690);
        return 0;
      case 3: 
        localbm.Ftz = locala.NPN.zc();
        AppMethodBeat.o(125690);
        return 0;
      case 4: 
        localbm.FtA = locala.NPN.gxI();
        AppMethodBeat.o(125690);
        return 0;
      case 5: 
        localbm.FtB = locala.NPN.zc();
        AppMethodBeat.o(125690);
        return 0;
      case 6: 
        localbm.FtC = locala.NPN.zc();
        AppMethodBeat.o(125690);
        return 0;
      case 7: 
        localbm.yWM = locala.NPN.readString();
        AppMethodBeat.o(125690);
        return 0;
      case 8: 
        localbm.imei = locala.NPN.readString();
        AppMethodBeat.o(125690);
        return 0;
      case 9: 
        localbm.FtD = locala.NPN.readString();
        AppMethodBeat.o(125690);
        return 0;
      case 10: 
        localbm.FtE = locala.NPN.readString();
        AppMethodBeat.o(125690);
        return 0;
      case 11: 
        localbm.FtF = locala.NPN.readString();
        AppMethodBeat.o(125690);
        return 0;
      case 12: 
        localbm.FtG = locala.NPN.readString();
        AppMethodBeat.o(125690);
        return 0;
      case 13: 
        localbm.FtH = locala.NPN.readString();
        AppMethodBeat.o(125690);
        return 0;
      }
      localbm.FtI = locala.NPN.readString();
      AppMethodBeat.o(125690);
      return 0;
    }
    AppMethodBeat.o(125690);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bm
 * JD-Core Version:    0.7.0.1
 */