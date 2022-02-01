package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class btp
  extends com.tencent.mm.bx.a
{
  public String CJL;
  public String CNZ;
  public String CSp;
  public String DRa;
  public int DRb;
  public String DRc;
  public int DRd;
  public int duration;
  public String gGC;
  public String gKF;
  public int height;
  public String title;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176147);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DRa != null) {
        paramVarArgs.d(1, this.DRa);
      }
      paramVarArgs.aR(2, this.duration);
      if (this.CJL != null) {
        paramVarArgs.d(3, this.CJL);
      }
      if (this.CSp != null) {
        paramVarArgs.d(4, this.CSp);
      }
      if (this.title != null) {
        paramVarArgs.d(5, this.title);
      }
      if (this.gKF != null) {
        paramVarArgs.d(6, this.gKF);
      }
      paramVarArgs.aR(7, this.DRb);
      paramVarArgs.aR(8, this.width);
      paramVarArgs.aR(9, this.height);
      if (this.CNZ != null) {
        paramVarArgs.d(10, this.CNZ);
      }
      if (this.gGC != null) {
        paramVarArgs.d(11, this.gGC);
      }
      if (this.DRc != null) {
        paramVarArgs.d(12, this.DRc);
      }
      paramVarArgs.aR(13, this.DRd);
      AppMethodBeat.o(176147);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DRa == null) {
        break label866;
      }
    }
    label866:
    for (paramInt = f.a.a.b.b.a.e(1, this.DRa) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.duration);
      paramInt = i;
      if (this.CJL != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.CJL);
      }
      i = paramInt;
      if (this.CSp != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.CSp);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.title);
      }
      i = paramInt;
      if (this.gKF != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.gKF);
      }
      i = i + f.a.a.b.b.a.bA(7, this.DRb) + f.a.a.b.b.a.bA(8, this.width) + f.a.a.b.b.a.bA(9, this.height);
      paramInt = i;
      if (this.CNZ != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.CNZ);
      }
      i = paramInt;
      if (this.gGC != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.gGC);
      }
      paramInt = i;
      if (this.DRc != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.DRc);
      }
      i = f.a.a.b.b.a.bA(13, this.DRd);
      AppMethodBeat.o(176147);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(176147);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        btp localbtp = (btp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(176147);
          return -1;
        case 1: 
          localbtp.DRa = locala.KhF.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 2: 
          localbtp.duration = locala.KhF.xS();
          AppMethodBeat.o(176147);
          return 0;
        case 3: 
          localbtp.CJL = locala.KhF.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 4: 
          localbtp.CSp = locala.KhF.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 5: 
          localbtp.title = locala.KhF.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 6: 
          localbtp.gKF = locala.KhF.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 7: 
          localbtp.DRb = locala.KhF.xS();
          AppMethodBeat.o(176147);
          return 0;
        case 8: 
          localbtp.width = locala.KhF.xS();
          AppMethodBeat.o(176147);
          return 0;
        case 9: 
          localbtp.height = locala.KhF.xS();
          AppMethodBeat.o(176147);
          return 0;
        case 10: 
          localbtp.CNZ = locala.KhF.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 11: 
          localbtp.gGC = locala.KhF.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 12: 
          localbtp.DRc = locala.KhF.readString();
          AppMethodBeat.o(176147);
          return 0;
        }
        localbtp.DRd = locala.KhF.xS();
        AppMethodBeat.o(176147);
        return 0;
      }
      AppMethodBeat.o(176147);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btp
 * JD-Core Version:    0.7.0.1
 */