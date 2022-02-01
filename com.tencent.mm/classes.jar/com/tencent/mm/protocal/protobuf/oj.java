package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class oj
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public String FFU;
  public int FFV;
  public String FFW;
  public String FFX;
  public String FFY;
  public String FFZ;
  public String FGa;
  public String FGb;
  public int FGc;
  public int FGd;
  public String FGh;
  public int FGi;
  public int FGj;
  public int FGk;
  public long FJM;
  public LinkedList<String> FJN;
  public int FJO;
  public String FJP;
  public int FJQ;
  public int FJR;
  public String FJS;
  public int FuX;
  public String Title;
  public int hCZ;
  public String hDa;
  public String uhr;
  
  public oj()
  {
    AppMethodBeat.i(207236);
    this.FJN = new LinkedList();
    AppMethodBeat.o(207236);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207237);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FuX);
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.FFU != null) {
        paramVarArgs.d(3, this.FFU);
      }
      if (this.hDa != null) {
        paramVarArgs.d(4, this.hDa);
      }
      paramVarArgs.aS(5, this.FFV);
      if (this.FFW != null) {
        paramVarArgs.d(6, this.FFW);
      }
      if (this.FFX != null) {
        paramVarArgs.d(7, this.FFX);
      }
      if (this.FFY != null) {
        paramVarArgs.d(8, this.FFY);
      }
      if (this.FFZ != null) {
        paramVarArgs.d(9, this.FFZ);
      }
      if (this.FGa != null) {
        paramVarArgs.d(10, this.FGa);
      }
      paramVarArgs.aS(11, this.hCZ);
      if (this.FGb != null) {
        paramVarArgs.d(12, this.FGb);
      }
      paramVarArgs.aS(13, this.FGc);
      paramVarArgs.aS(14, this.FGd);
      if (this.FGh != null) {
        paramVarArgs.d(15, this.FGh);
      }
      paramVarArgs.aS(16, this.FGi);
      paramVarArgs.aS(17, this.FGj);
      paramVarArgs.aS(18, this.FGk);
      paramVarArgs.aS(19, this.CreateTime);
      paramVarArgs.aY(20, this.FJM);
      paramVarArgs.e(21, 1, this.FJN);
      paramVarArgs.aS(22, this.FJO);
      if (this.uhr != null) {
        paramVarArgs.d(23, this.uhr);
      }
      if (this.FJP != null) {
        paramVarArgs.d(24, this.FJP);
      }
      paramVarArgs.aS(25, this.FJQ);
      paramVarArgs.aS(26, this.FJR);
      if (this.FJS != null) {
        paramVarArgs.d(27, this.FJS);
      }
      AppMethodBeat.o(207237);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.FuX) + 0;
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.FFU != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FFU);
      }
      paramInt = i;
      if (this.hDa != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hDa);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.FFV);
      paramInt = i;
      if (this.FFW != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FFW);
      }
      i = paramInt;
      if (this.FFX != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FFX);
      }
      paramInt = i;
      if (this.FFY != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FFY);
      }
      i = paramInt;
      if (this.FFZ != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.FFZ);
      }
      paramInt = i;
      if (this.FGa != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FGa);
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.hCZ);
      paramInt = i;
      if (this.FGb != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.FGb);
      }
      i = paramInt + f.a.a.b.b.a.bz(13, this.FGc) + f.a.a.b.b.a.bz(14, this.FGd);
      paramInt = i;
      if (this.FGh != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.FGh);
      }
      i = paramInt + f.a.a.b.b.a.bz(16, this.FGi) + f.a.a.b.b.a.bz(17, this.FGj) + f.a.a.b.b.a.bz(18, this.FGk) + f.a.a.b.b.a.bz(19, this.CreateTime) + f.a.a.b.b.a.p(20, this.FJM) + f.a.a.a.c(21, 1, this.FJN) + f.a.a.b.b.a.bz(22, this.FJO);
      paramInt = i;
      if (this.uhr != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.uhr);
      }
      i = paramInt;
      if (this.FJP != null) {
        i = paramInt + f.a.a.b.b.a.e(24, this.FJP);
      }
      i = i + f.a.a.b.b.a.bz(25, this.FJQ) + f.a.a.b.b.a.bz(26, this.FJR);
      paramInt = i;
      if (this.FJS != null) {
        paramInt = i + f.a.a.b.b.a.e(27, this.FJS);
      }
      AppMethodBeat.o(207237);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FJN.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(207237);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      oj localoj = (oj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(207237);
        return -1;
      case 1: 
        localoj.FuX = locala.NPN.zc();
        AppMethodBeat.o(207237);
        return 0;
      case 2: 
        localoj.Title = locala.NPN.readString();
        AppMethodBeat.o(207237);
        return 0;
      case 3: 
        localoj.FFU = locala.NPN.readString();
        AppMethodBeat.o(207237);
        return 0;
      case 4: 
        localoj.hDa = locala.NPN.readString();
        AppMethodBeat.o(207237);
        return 0;
      case 5: 
        localoj.FFV = locala.NPN.zc();
        AppMethodBeat.o(207237);
        return 0;
      case 6: 
        localoj.FFW = locala.NPN.readString();
        AppMethodBeat.o(207237);
        return 0;
      case 7: 
        localoj.FFX = locala.NPN.readString();
        AppMethodBeat.o(207237);
        return 0;
      case 8: 
        localoj.FFY = locala.NPN.readString();
        AppMethodBeat.o(207237);
        return 0;
      case 9: 
        localoj.FFZ = locala.NPN.readString();
        AppMethodBeat.o(207237);
        return 0;
      case 10: 
        localoj.FGa = locala.NPN.readString();
        AppMethodBeat.o(207237);
        return 0;
      case 11: 
        localoj.hCZ = locala.NPN.zc();
        AppMethodBeat.o(207237);
        return 0;
      case 12: 
        localoj.FGb = locala.NPN.readString();
        AppMethodBeat.o(207237);
        return 0;
      case 13: 
        localoj.FGc = locala.NPN.zc();
        AppMethodBeat.o(207237);
        return 0;
      case 14: 
        localoj.FGd = locala.NPN.zc();
        AppMethodBeat.o(207237);
        return 0;
      case 15: 
        localoj.FGh = locala.NPN.readString();
        AppMethodBeat.o(207237);
        return 0;
      case 16: 
        localoj.FGi = locala.NPN.zc();
        AppMethodBeat.o(207237);
        return 0;
      case 17: 
        localoj.FGj = locala.NPN.zc();
        AppMethodBeat.o(207237);
        return 0;
      case 18: 
        localoj.FGk = locala.NPN.zc();
        AppMethodBeat.o(207237);
        return 0;
      case 19: 
        localoj.CreateTime = locala.NPN.zc();
        AppMethodBeat.o(207237);
        return 0;
      case 20: 
        localoj.FJM = locala.NPN.zd();
        AppMethodBeat.o(207237);
        return 0;
      case 21: 
        localoj.FJN.add(locala.NPN.readString());
        AppMethodBeat.o(207237);
        return 0;
      case 22: 
        localoj.FJO = locala.NPN.zc();
        AppMethodBeat.o(207237);
        return 0;
      case 23: 
        localoj.uhr = locala.NPN.readString();
        AppMethodBeat.o(207237);
        return 0;
      case 24: 
        localoj.FJP = locala.NPN.readString();
        AppMethodBeat.o(207237);
        return 0;
      case 25: 
        localoj.FJQ = locala.NPN.zc();
        AppMethodBeat.o(207237);
        return 0;
      case 26: 
        localoj.FJR = locala.NPN.zc();
        AppMethodBeat.o(207237);
        return 0;
      }
      localoj.FJS = locala.NPN.readString();
      AppMethodBeat.o(207237);
      return 0;
    }
    AppMethodBeat.o(207237);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oj
 * JD-Core Version:    0.7.0.1
 */