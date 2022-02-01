package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class dwd
  extends com.tencent.mm.bx.a
{
  public int CHC;
  public String Cxw;
  public String EJQ;
  public float EJR;
  public float EJS;
  public int EJT;
  public String EJU;
  public b Eis;
  public String IconUrl;
  public String hnC;
  public String mAQ;
  public String mBV;
  public String sdZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117960);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EJQ != null) {
        paramVarArgs.d(1, this.EJQ);
      }
      if (this.mBV != null) {
        paramVarArgs.d(2, this.mBV);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(3, this.IconUrl);
      }
      if (this.mAQ != null) {
        paramVarArgs.d(4, this.mAQ);
      }
      paramVarArgs.aR(5, this.CHC);
      if (this.Cxw != null) {
        paramVarArgs.d(6, this.Cxw);
      }
      if (this.sdZ != null) {
        paramVarArgs.d(7, this.sdZ);
      }
      paramVarArgs.x(8, this.EJR);
      paramVarArgs.x(9, this.EJS);
      paramVarArgs.aR(10, this.EJT);
      if (this.hnC != null) {
        paramVarArgs.d(11, this.hnC);
      }
      if (this.EJU != null) {
        paramVarArgs.d(12, this.EJU);
      }
      if (this.Eis != null) {
        paramVarArgs.c(13, this.Eis);
      }
      AppMethodBeat.o(117960);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EJQ == null) {
        break label884;
      }
    }
    label884:
    for (int i = f.a.a.b.b.a.e(1, this.EJQ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mBV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.mBV);
      }
      i = paramInt;
      if (this.IconUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.IconUrl);
      }
      paramInt = i;
      if (this.mAQ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.mAQ);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.CHC);
      paramInt = i;
      if (this.Cxw != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Cxw);
      }
      i = paramInt;
      if (this.sdZ != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.sdZ);
      }
      i = i + (f.a.a.b.b.a.fY(8) + 4) + (f.a.a.b.b.a.fY(9) + 4) + f.a.a.b.b.a.bA(10, this.EJT);
      paramInt = i;
      if (this.hnC != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.hnC);
      }
      i = paramInt;
      if (this.EJU != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.EJU);
      }
      paramInt = i;
      if (this.Eis != null) {
        paramInt = i + f.a.a.b.b.a.b(13, this.Eis);
      }
      AppMethodBeat.o(117960);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(117960);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dwd localdwd = (dwd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117960);
          return -1;
        case 1: 
          localdwd.EJQ = locala.KhF.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 2: 
          localdwd.mBV = locala.KhF.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 3: 
          localdwd.IconUrl = locala.KhF.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 4: 
          localdwd.mAQ = locala.KhF.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 5: 
          localdwd.CHC = locala.KhF.xS();
          AppMethodBeat.o(117960);
          return 0;
        case 6: 
          localdwd.Cxw = locala.KhF.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 7: 
          localdwd.sdZ = locala.KhF.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 8: 
          localdwd.EJR = Float.intBitsToFloat(locala.KhF.fHx());
          AppMethodBeat.o(117960);
          return 0;
        case 9: 
          localdwd.EJS = Float.intBitsToFloat(locala.KhF.fHx());
          AppMethodBeat.o(117960);
          return 0;
        case 10: 
          localdwd.EJT = locala.KhF.xS();
          AppMethodBeat.o(117960);
          return 0;
        case 11: 
          localdwd.hnC = locala.KhF.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 12: 
          localdwd.EJU = locala.KhF.readString();
          AppMethodBeat.o(117960);
          return 0;
        }
        localdwd.Eis = locala.KhF.fMu();
        AppMethodBeat.o(117960);
        return 0;
      }
      AppMethodBeat.o(117960);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwd
 * JD-Core Version:    0.7.0.1
 */