package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class vq
  extends com.tencent.mm.bx.a
{
  public int FUT;
  public String FUU;
  public int FUV;
  public String FUW;
  public int FUX;
  public String FUY;
  public String FUZ;
  public String FVa;
  public String FVb;
  public int FVc;
  public String FVd;
  public String FtI;
  public int pkj;
  public String pkk;
  public String pkq;
  public String pkr;
  public String pld;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125715);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FUT);
      if (this.pld != null) {
        paramVarArgs.d(2, this.pld);
      }
      if (this.FUU != null) {
        paramVarArgs.d(3, this.FUU);
      }
      if (this.pkq != null) {
        paramVarArgs.d(4, this.pkq);
      }
      paramVarArgs.aS(5, this.FUV);
      if (this.FUW != null) {
        paramVarArgs.d(6, this.FUW);
      }
      paramVarArgs.aS(7, this.FUX);
      if (this.pkr != null) {
        paramVarArgs.d(8, this.pkr);
      }
      if (this.FtI != null) {
        paramVarArgs.d(9, this.FtI);
      }
      paramVarArgs.aS(10, this.pkj);
      if (this.pkk != null) {
        paramVarArgs.d(11, this.pkk);
      }
      if (this.FUY != null) {
        paramVarArgs.d(12, this.FUY);
      }
      if (this.FUZ != null) {
        paramVarArgs.d(13, this.FUZ);
      }
      if (this.FVa != null) {
        paramVarArgs.d(14, this.FVa);
      }
      if (this.FVb != null) {
        paramVarArgs.d(15, this.FVb);
      }
      paramVarArgs.aS(16, this.FVc);
      if (this.FVd != null) {
        paramVarArgs.d(17, this.FVd);
      }
      AppMethodBeat.o(125715);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.FUT) + 0;
      paramInt = i;
      if (this.pld != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.pld);
      }
      i = paramInt;
      if (this.FUU != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FUU);
      }
      paramInt = i;
      if (this.pkq != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.pkq);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.FUV);
      paramInt = i;
      if (this.FUW != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FUW);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.FUX);
      paramInt = i;
      if (this.pkr != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.pkr);
      }
      i = paramInt;
      if (this.FtI != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.FtI);
      }
      i += f.a.a.b.b.a.bz(10, this.pkj);
      paramInt = i;
      if (this.pkk != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.pkk);
      }
      i = paramInt;
      if (this.FUY != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.FUY);
      }
      paramInt = i;
      if (this.FUZ != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.FUZ);
      }
      i = paramInt;
      if (this.FVa != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.FVa);
      }
      paramInt = i;
      if (this.FVb != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.FVb);
      }
      i = paramInt + f.a.a.b.b.a.bz(16, this.FVc);
      paramInt = i;
      if (this.FVd != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.FVd);
      }
      AppMethodBeat.o(125715);
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
      AppMethodBeat.o(125715);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      vq localvq = (vq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125715);
        return -1;
      case 1: 
        localvq.FUT = locala.NPN.zc();
        AppMethodBeat.o(125715);
        return 0;
      case 2: 
        localvq.pld = locala.NPN.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 3: 
        localvq.FUU = locala.NPN.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 4: 
        localvq.pkq = locala.NPN.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 5: 
        localvq.FUV = locala.NPN.zc();
        AppMethodBeat.o(125715);
        return 0;
      case 6: 
        localvq.FUW = locala.NPN.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 7: 
        localvq.FUX = locala.NPN.zc();
        AppMethodBeat.o(125715);
        return 0;
      case 8: 
        localvq.pkr = locala.NPN.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 9: 
        localvq.FtI = locala.NPN.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 10: 
        localvq.pkj = locala.NPN.zc();
        AppMethodBeat.o(125715);
        return 0;
      case 11: 
        localvq.pkk = locala.NPN.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 12: 
        localvq.FUY = locala.NPN.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 13: 
        localvq.FUZ = locala.NPN.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 14: 
        localvq.FVa = locala.NPN.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 15: 
        localvq.FVb = locala.NPN.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 16: 
        localvq.FVc = locala.NPN.zc();
        AppMethodBeat.o(125715);
        return 0;
      }
      localvq.FVd = locala.NPN.readString();
      AppMethodBeat.o(125715);
      return 0;
    }
    AppMethodBeat.o(125715);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vq
 * JD-Core Version:    0.7.0.1
 */