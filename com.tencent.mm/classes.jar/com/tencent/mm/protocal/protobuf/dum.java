package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dum
  extends com.tencent.mm.bx.a
{
  public int APo;
  public String CzY;
  public String DcD;
  public int DoL;
  public String EIO;
  public String EIP;
  public String EIQ;
  public int EIR;
  public int dzS;
  public String dzT;
  public String hnC;
  public String lrl;
  public int lrq;
  public int mBH;
  public int oXH;
  public int vJA;
  public int vJz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123693);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.mBH);
      if (this.hnC != null) {
        paramVarArgs.d(2, this.hnC);
      }
      if (this.EIO != null) {
        paramVarArgs.d(3, this.EIO);
      }
      paramVarArgs.aR(4, this.vJz);
      paramVarArgs.aR(5, this.oXH);
      paramVarArgs.aR(6, this.vJA);
      if (this.EIP != null) {
        paramVarArgs.d(7, this.EIP);
      }
      paramVarArgs.aR(8, this.DoL);
      if (this.CzY != null) {
        paramVarArgs.d(9, this.CzY);
      }
      if (this.EIQ != null) {
        paramVarArgs.d(10, this.EIQ);
      }
      paramVarArgs.aR(11, this.APo);
      paramVarArgs.aR(12, this.EIR);
      if (this.DcD != null) {
        paramVarArgs.d(13, this.DcD);
      }
      if (this.lrl != null) {
        paramVarArgs.d(14, this.lrl);
      }
      paramVarArgs.aR(15, this.dzS);
      if (this.dzT != null) {
        paramVarArgs.d(16, this.dzT);
      }
      paramVarArgs.aR(17, this.lrq);
      AppMethodBeat.o(123693);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.mBH) + 0;
      paramInt = i;
      if (this.hnC != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hnC);
      }
      i = paramInt;
      if (this.EIO != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EIO);
      }
      i = i + f.a.a.b.b.a.bA(4, this.vJz) + f.a.a.b.b.a.bA(5, this.oXH) + f.a.a.b.b.a.bA(6, this.vJA);
      paramInt = i;
      if (this.EIP != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.EIP);
      }
      i = paramInt + f.a.a.b.b.a.bA(8, this.DoL);
      paramInt = i;
      if (this.CzY != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.CzY);
      }
      i = paramInt;
      if (this.EIQ != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.EIQ);
      }
      i = i + f.a.a.b.b.a.bA(11, this.APo) + f.a.a.b.b.a.bA(12, this.EIR);
      paramInt = i;
      if (this.DcD != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.DcD);
      }
      i = paramInt;
      if (this.lrl != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.lrl);
      }
      i += f.a.a.b.b.a.bA(15, this.dzS);
      paramInt = i;
      if (this.dzT != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.dzT);
      }
      i = f.a.a.b.b.a.bA(17, this.lrq);
      AppMethodBeat.o(123693);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(123693);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dum localdum = (dum)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123693);
        return -1;
      case 1: 
        localdum.mBH = locala.KhF.xS();
        AppMethodBeat.o(123693);
        return 0;
      case 2: 
        localdum.hnC = locala.KhF.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 3: 
        localdum.EIO = locala.KhF.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 4: 
        localdum.vJz = locala.KhF.xS();
        AppMethodBeat.o(123693);
        return 0;
      case 5: 
        localdum.oXH = locala.KhF.xS();
        AppMethodBeat.o(123693);
        return 0;
      case 6: 
        localdum.vJA = locala.KhF.xS();
        AppMethodBeat.o(123693);
        return 0;
      case 7: 
        localdum.EIP = locala.KhF.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 8: 
        localdum.DoL = locala.KhF.xS();
        AppMethodBeat.o(123693);
        return 0;
      case 9: 
        localdum.CzY = locala.KhF.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 10: 
        localdum.EIQ = locala.KhF.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 11: 
        localdum.APo = locala.KhF.xS();
        AppMethodBeat.o(123693);
        return 0;
      case 12: 
        localdum.EIR = locala.KhF.xS();
        AppMethodBeat.o(123693);
        return 0;
      case 13: 
        localdum.DcD = locala.KhF.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 14: 
        localdum.lrl = locala.KhF.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 15: 
        localdum.dzS = locala.KhF.xS();
        AppMethodBeat.o(123693);
        return 0;
      case 16: 
        localdum.dzT = locala.KhF.readString();
        AppMethodBeat.o(123693);
        return 0;
      }
      localdum.lrq = locala.KhF.xS();
      AppMethodBeat.o(123693);
      return 0;
    }
    AppMethodBeat.o(123693);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dum
 * JD-Core Version:    0.7.0.1
 */