package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dlp
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public String FFU;
  public String FFW;
  public String FFY;
  public String FFZ;
  public String FGa;
  public String FGh;
  public int FGi;
  public int FGj;
  public int FGk;
  public long FJM;
  public String FJP;
  public int FJQ;
  public int FuX;
  public String Title;
  public int hCZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124558);
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
      if (this.FFW != null) {
        paramVarArgs.d(6, this.FFW);
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
      if (this.FGh != null) {
        paramVarArgs.d(15, this.FGh);
      }
      paramVarArgs.aS(16, this.FGi);
      paramVarArgs.aS(17, this.FGj);
      paramVarArgs.aS(18, this.FGk);
      paramVarArgs.aS(19, this.CreateTime);
      paramVarArgs.aY(20, this.FJM);
      if (this.FJP != null) {
        paramVarArgs.d(21, this.FJP);
      }
      paramVarArgs.aS(22, this.FJQ);
      AppMethodBeat.o(124558);
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
      if (this.FFW != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FFW);
      }
      i = paramInt;
      if (this.FFY != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.FFY);
      }
      paramInt = i;
      if (this.FFZ != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.FFZ);
      }
      i = paramInt;
      if (this.FGa != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.FGa);
      }
      i += f.a.a.b.b.a.bz(11, this.hCZ);
      paramInt = i;
      if (this.FGh != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.FGh);
      }
      i = paramInt + f.a.a.b.b.a.bz(16, this.FGi) + f.a.a.b.b.a.bz(17, this.FGj) + f.a.a.b.b.a.bz(18, this.FGk) + f.a.a.b.b.a.bz(19, this.CreateTime) + f.a.a.b.b.a.p(20, this.FJM);
      paramInt = i;
      if (this.FJP != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.FJP);
      }
      i = f.a.a.b.b.a.bz(22, this.FJQ);
      AppMethodBeat.o(124558);
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
      AppMethodBeat.o(124558);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dlp localdlp = (dlp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 4: 
      case 5: 
      case 7: 
      case 12: 
      case 13: 
      case 14: 
      default: 
        AppMethodBeat.o(124558);
        return -1;
      case 1: 
        localdlp.FuX = locala.NPN.zc();
        AppMethodBeat.o(124558);
        return 0;
      case 2: 
        localdlp.Title = locala.NPN.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 3: 
        localdlp.FFU = locala.NPN.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 6: 
        localdlp.FFW = locala.NPN.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 8: 
        localdlp.FFY = locala.NPN.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 9: 
        localdlp.FFZ = locala.NPN.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 10: 
        localdlp.FGa = locala.NPN.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 11: 
        localdlp.hCZ = locala.NPN.zc();
        AppMethodBeat.o(124558);
        return 0;
      case 15: 
        localdlp.FGh = locala.NPN.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 16: 
        localdlp.FGi = locala.NPN.zc();
        AppMethodBeat.o(124558);
        return 0;
      case 17: 
        localdlp.FGj = locala.NPN.zc();
        AppMethodBeat.o(124558);
        return 0;
      case 18: 
        localdlp.FGk = locala.NPN.zc();
        AppMethodBeat.o(124558);
        return 0;
      case 19: 
        localdlp.CreateTime = locala.NPN.zc();
        AppMethodBeat.o(124558);
        return 0;
      case 20: 
        localdlp.FJM = locala.NPN.zd();
        AppMethodBeat.o(124558);
        return 0;
      case 21: 
        localdlp.FJP = locala.NPN.readString();
        AppMethodBeat.o(124558);
        return 0;
      }
      localdlp.FJQ = locala.NPN.zc();
      AppMethodBeat.o(124558);
      return 0;
    }
    AppMethodBeat.o(124558);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlp
 * JD-Core Version:    0.7.0.1
 */