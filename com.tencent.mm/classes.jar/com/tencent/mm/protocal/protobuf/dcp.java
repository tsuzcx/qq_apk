package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dcp
  extends com.tencent.mm.bx.a
{
  public int CzZ;
  public String DLH;
  public String DUZ;
  public String DVb;
  public String Dni;
  public String Efu;
  public String Eub;
  public String Euc;
  public int Scene;
  public String Title;
  public String gKr;
  public String nlK;
  public int rNz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117934);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DVb != null) {
        paramVarArgs.d(1, this.DVb);
      }
      if (this.DUZ != null) {
        paramVarArgs.d(2, this.DUZ);
      }
      if (this.gKr != null) {
        paramVarArgs.d(3, this.gKr);
      }
      if (this.Eub != null) {
        paramVarArgs.d(4, this.Eub);
      }
      if (this.Euc != null) {
        paramVarArgs.d(5, this.Euc);
      }
      if (this.Dni != null) {
        paramVarArgs.d(6, this.Dni);
      }
      if (this.Title != null) {
        paramVarArgs.d(7, this.Title);
      }
      if (this.DLH != null) {
        paramVarArgs.d(8, this.DLH);
      }
      paramVarArgs.aR(9, this.Scene);
      paramVarArgs.aR(10, this.CzZ);
      if (this.Efu != null) {
        paramVarArgs.d(11, this.Efu);
      }
      if (this.nlK != null) {
        paramVarArgs.d(12, this.nlK);
      }
      paramVarArgs.aR(13, this.rNz);
      AppMethodBeat.o(117934);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DVb == null) {
        break label902;
      }
    }
    label902:
    for (int i = f.a.a.b.b.a.e(1, this.DVb) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DUZ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DUZ);
      }
      i = paramInt;
      if (this.gKr != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.gKr);
      }
      paramInt = i;
      if (this.Eub != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Eub);
      }
      i = paramInt;
      if (this.Euc != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Euc);
      }
      paramInt = i;
      if (this.Dni != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Dni);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Title);
      }
      paramInt = i;
      if (this.DLH != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DLH);
      }
      i = paramInt + f.a.a.b.b.a.bA(9, this.Scene) + f.a.a.b.b.a.bA(10, this.CzZ);
      paramInt = i;
      if (this.Efu != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Efu);
      }
      i = paramInt;
      if (this.nlK != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.nlK);
      }
      paramInt = f.a.a.b.b.a.bA(13, this.rNz);
      AppMethodBeat.o(117934);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(117934);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dcp localdcp = (dcp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117934);
          return -1;
        case 1: 
          localdcp.DVb = locala.KhF.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 2: 
          localdcp.DUZ = locala.KhF.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 3: 
          localdcp.gKr = locala.KhF.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 4: 
          localdcp.Eub = locala.KhF.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 5: 
          localdcp.Euc = locala.KhF.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 6: 
          localdcp.Dni = locala.KhF.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 7: 
          localdcp.Title = locala.KhF.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 8: 
          localdcp.DLH = locala.KhF.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 9: 
          localdcp.Scene = locala.KhF.xS();
          AppMethodBeat.o(117934);
          return 0;
        case 10: 
          localdcp.CzZ = locala.KhF.xS();
          AppMethodBeat.o(117934);
          return 0;
        case 11: 
          localdcp.Efu = locala.KhF.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 12: 
          localdcp.nlK = locala.KhF.readString();
          AppMethodBeat.o(117934);
          return 0;
        }
        localdcp.rNz = locala.KhF.xS();
        AppMethodBeat.o(117934);
        return 0;
      }
      AppMethodBeat.o(117934);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcp
 * JD-Core Version:    0.7.0.1
 */