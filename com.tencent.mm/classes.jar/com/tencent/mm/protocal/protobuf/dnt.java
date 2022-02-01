package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dnt
  extends com.tencent.mm.bx.a
{
  public int FxO;
  public String GRx;
  public String HBK;
  public String HbR;
  public String HbT;
  public String HmJ;
  public int Scene;
  public int gsV;
  public String hDa;
  public String orq;
  public int tRT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117936);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HbR != null) {
        paramVarArgs.d(1, this.HbR);
      }
      if (this.HBK != null) {
        paramVarArgs.d(2, this.HBK);
      }
      paramVarArgs.aS(3, this.gsV);
      if (this.HbT != null) {
        paramVarArgs.d(4, this.HbT);
      }
      if (this.hDa != null) {
        paramVarArgs.d(5, this.hDa);
      }
      paramVarArgs.aS(6, this.Scene);
      if (this.GRx != null) {
        paramVarArgs.d(7, this.GRx);
      }
      paramVarArgs.aS(8, this.FxO);
      if (this.orq != null) {
        paramVarArgs.d(9, this.orq);
      }
      if (this.HmJ != null) {
        paramVarArgs.d(10, this.HmJ);
      }
      paramVarArgs.aS(11, this.tRT);
      AppMethodBeat.o(117936);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HbR == null) {
        break label762;
      }
    }
    label762:
    for (paramInt = f.a.a.b.b.a.e(1, this.HbR) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HBK != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HBK);
      }
      i += f.a.a.b.b.a.bz(3, this.gsV);
      paramInt = i;
      if (this.HbT != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HbT);
      }
      i = paramInt;
      if (this.hDa != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.hDa);
      }
      i += f.a.a.b.b.a.bz(6, this.Scene);
      paramInt = i;
      if (this.GRx != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GRx);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.FxO);
      paramInt = i;
      if (this.orq != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.orq);
      }
      i = paramInt;
      if (this.HmJ != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.HmJ);
      }
      paramInt = f.a.a.b.b.a.bz(11, this.tRT);
      AppMethodBeat.o(117936);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(117936);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dnt localdnt = (dnt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117936);
          return -1;
        case 1: 
          localdnt.HbR = locala.NPN.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 2: 
          localdnt.HBK = locala.NPN.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 3: 
          localdnt.gsV = locala.NPN.zc();
          AppMethodBeat.o(117936);
          return 0;
        case 4: 
          localdnt.HbT = locala.NPN.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 5: 
          localdnt.hDa = locala.NPN.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 6: 
          localdnt.Scene = locala.NPN.zc();
          AppMethodBeat.o(117936);
          return 0;
        case 7: 
          localdnt.GRx = locala.NPN.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 8: 
          localdnt.FxO = locala.NPN.zc();
          AppMethodBeat.o(117936);
          return 0;
        case 9: 
          localdnt.orq = locala.NPN.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 10: 
          localdnt.HmJ = locala.NPN.readString();
          AppMethodBeat.o(117936);
          return 0;
        }
        localdnt.tRT = locala.NPN.zc();
        AppMethodBeat.o(117936);
        return 0;
      }
      AppMethodBeat.o(117936);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnt
 * JD-Core Version:    0.7.0.1
 */