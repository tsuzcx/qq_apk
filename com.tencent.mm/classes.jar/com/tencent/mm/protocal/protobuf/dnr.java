package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dnr
  extends com.tencent.mm.bx.a
{
  public int FxO;
  public String GRx;
  public String GqZ;
  public String HBI;
  public String HBJ;
  public String HbR;
  public String HbT;
  public String HmJ;
  public int Scene;
  public String Title;
  public String hDa;
  public String orq;
  public int tRT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117934);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HbT != null) {
        paramVarArgs.d(1, this.HbT);
      }
      if (this.HbR != null) {
        paramVarArgs.d(2, this.HbR);
      }
      if (this.hDa != null) {
        paramVarArgs.d(3, this.hDa);
      }
      if (this.HBI != null) {
        paramVarArgs.d(4, this.HBI);
      }
      if (this.HBJ != null) {
        paramVarArgs.d(5, this.HBJ);
      }
      if (this.GqZ != null) {
        paramVarArgs.d(6, this.GqZ);
      }
      if (this.Title != null) {
        paramVarArgs.d(7, this.Title);
      }
      if (this.GRx != null) {
        paramVarArgs.d(8, this.GRx);
      }
      paramVarArgs.aS(9, this.Scene);
      paramVarArgs.aS(10, this.FxO);
      if (this.HmJ != null) {
        paramVarArgs.d(11, this.HmJ);
      }
      if (this.orq != null) {
        paramVarArgs.d(12, this.orq);
      }
      paramVarArgs.aS(13, this.tRT);
      AppMethodBeat.o(117934);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HbT == null) {
        break label902;
      }
    }
    label902:
    for (int i = f.a.a.b.b.a.e(1, this.HbT) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HbR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HbR);
      }
      i = paramInt;
      if (this.hDa != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hDa);
      }
      paramInt = i;
      if (this.HBI != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HBI);
      }
      i = paramInt;
      if (this.HBJ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HBJ);
      }
      paramInt = i;
      if (this.GqZ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GqZ);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Title);
      }
      paramInt = i;
      if (this.GRx != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GRx);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.Scene) + f.a.a.b.b.a.bz(10, this.FxO);
      paramInt = i;
      if (this.HmJ != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.HmJ);
      }
      i = paramInt;
      if (this.orq != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.orq);
      }
      paramInt = f.a.a.b.b.a.bz(13, this.tRT);
      AppMethodBeat.o(117934);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(117934);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dnr localdnr = (dnr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117934);
          return -1;
        case 1: 
          localdnr.HbT = locala.NPN.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 2: 
          localdnr.HbR = locala.NPN.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 3: 
          localdnr.hDa = locala.NPN.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 4: 
          localdnr.HBI = locala.NPN.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 5: 
          localdnr.HBJ = locala.NPN.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 6: 
          localdnr.GqZ = locala.NPN.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 7: 
          localdnr.Title = locala.NPN.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 8: 
          localdnr.GRx = locala.NPN.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 9: 
          localdnr.Scene = locala.NPN.zc();
          AppMethodBeat.o(117934);
          return 0;
        case 10: 
          localdnr.FxO = locala.NPN.zc();
          AppMethodBeat.o(117934);
          return 0;
        case 11: 
          localdnr.HmJ = locala.NPN.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 12: 
          localdnr.orq = locala.NPN.readString();
          AppMethodBeat.o(117934);
          return 0;
        }
        localdnr.tRT = locala.NPN.zc();
        AppMethodBeat.o(117934);
        return 0;
      }
      AppMethodBeat.o(117934);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnr
 * JD-Core Version:    0.7.0.1
 */