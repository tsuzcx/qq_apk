package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dqa
  extends com.tencent.mm.bx.a
{
  public String DLH;
  public String DUZ;
  public String EFP;
  public String EFQ;
  public String EFR;
  public String EFS;
  public String EFT;
  public int Scene;
  public int iiE;
  public String upx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(121110);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EFP != null) {
        paramVarArgs.d(1, this.EFP);
      }
      if (this.EFQ != null) {
        paramVarArgs.d(2, this.EFQ);
      }
      if (this.DLH != null) {
        paramVarArgs.d(3, this.DLH);
      }
      if (this.DUZ != null) {
        paramVarArgs.d(4, this.DUZ);
      }
      paramVarArgs.aR(5, this.iiE);
      if (this.upx != null) {
        paramVarArgs.d(6, this.upx);
      }
      if (this.EFR != null) {
        paramVarArgs.d(7, this.EFR);
      }
      if (this.EFS != null) {
        paramVarArgs.d(8, this.EFS);
      }
      paramVarArgs.aR(9, this.Scene);
      if (this.EFT != null) {
        paramVarArgs.d(19, this.EFT);
      }
      AppMethodBeat.o(121110);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EFP == null) {
        break label770;
      }
    }
    label770:
    for (int i = f.a.a.b.b.a.e(1, this.EFP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EFQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EFQ);
      }
      i = paramInt;
      if (this.DLH != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DLH);
      }
      paramInt = i;
      if (this.DUZ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DUZ);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.iiE);
      paramInt = i;
      if (this.upx != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.upx);
      }
      i = paramInt;
      if (this.EFR != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.EFR);
      }
      paramInt = i;
      if (this.EFS != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.EFS);
      }
      i = paramInt + f.a.a.b.b.a.bA(9, this.Scene);
      paramInt = i;
      if (this.EFT != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.EFT);
      }
      AppMethodBeat.o(121110);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(121110);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dqa localdqa = (dqa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        default: 
          AppMethodBeat.o(121110);
          return -1;
        case 1: 
          localdqa.EFP = locala.KhF.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 2: 
          localdqa.EFQ = locala.KhF.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 3: 
          localdqa.DLH = locala.KhF.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 4: 
          localdqa.DUZ = locala.KhF.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 5: 
          localdqa.iiE = locala.KhF.xS();
          AppMethodBeat.o(121110);
          return 0;
        case 6: 
          localdqa.upx = locala.KhF.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 7: 
          localdqa.EFR = locala.KhF.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 8: 
          localdqa.EFS = locala.KhF.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 9: 
          localdqa.Scene = locala.KhF.xS();
          AppMethodBeat.o(121110);
          return 0;
        }
        localdqa.EFT = locala.KhF.readString();
        AppMethodBeat.o(121110);
        return 0;
      }
      AppMethodBeat.o(121110);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqa
 * JD-Core Version:    0.7.0.1
 */