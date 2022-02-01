package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bb
  extends com.tencent.mm.bx.a
{
  public long FsE;
  public String FsF;
  public String FsG;
  public String FsH;
  public String FsI;
  public String FsJ;
  public String ePu;
  public String ePv;
  public double latitude;
  public double longitude;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91341);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ePu != null) {
        paramVarArgs.d(1, this.ePu);
      }
      if (this.ePv != null) {
        paramVarArgs.d(2, this.ePv);
      }
      paramVarArgs.e(3, this.latitude);
      paramVarArgs.e(4, this.longitude);
      paramVarArgs.aY(5, this.FsE);
      if (this.FsF != null) {
        paramVarArgs.d(6, this.FsF);
      }
      if (this.FsG != null) {
        paramVarArgs.d(7, this.FsG);
      }
      if (this.FsH != null) {
        paramVarArgs.d(8, this.FsH);
      }
      if (this.FsI != null) {
        paramVarArgs.d(9, this.FsI);
      }
      if (this.FsJ != null) {
        paramVarArgs.d(10, this.FsJ);
      }
      AppMethodBeat.o(91341);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ePu == null) {
        break label712;
      }
    }
    label712:
    for (paramInt = f.a.a.b.b.a.e(1, this.ePu) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ePv != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ePv);
      }
      i = i + f.a.a.b.b.a.alT(3) + f.a.a.b.b.a.alT(4) + f.a.a.b.b.a.p(5, this.FsE);
      paramInt = i;
      if (this.FsF != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FsF);
      }
      i = paramInt;
      if (this.FsG != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FsG);
      }
      paramInt = i;
      if (this.FsH != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FsH);
      }
      i = paramInt;
      if (this.FsI != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.FsI);
      }
      paramInt = i;
      if (this.FsJ != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FsJ);
      }
      AppMethodBeat.o(91341);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91341);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bb localbb = (bb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91341);
          return -1;
        case 1: 
          localbb.ePu = locala.NPN.readString();
          AppMethodBeat.o(91341);
          return 0;
        case 2: 
          localbb.ePv = locala.NPN.readString();
          AppMethodBeat.o(91341);
          return 0;
        case 3: 
          localbb.latitude = Double.longBitsToDouble(locala.NPN.grA());
          AppMethodBeat.o(91341);
          return 0;
        case 4: 
          localbb.longitude = Double.longBitsToDouble(locala.NPN.grA());
          AppMethodBeat.o(91341);
          return 0;
        case 5: 
          localbb.FsE = locala.NPN.zd();
          AppMethodBeat.o(91341);
          return 0;
        case 6: 
          localbb.FsF = locala.NPN.readString();
          AppMethodBeat.o(91341);
          return 0;
        case 7: 
          localbb.FsG = locala.NPN.readString();
          AppMethodBeat.o(91341);
          return 0;
        case 8: 
          localbb.FsH = locala.NPN.readString();
          AppMethodBeat.o(91341);
          return 0;
        case 9: 
          localbb.FsI = locala.NPN.readString();
          AppMethodBeat.o(91341);
          return 0;
        }
        localbb.FsJ = locala.NPN.readString();
        AppMethodBeat.o(91341);
        return 0;
      }
      AppMethodBeat.o(91341);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bb
 * JD-Core Version:    0.7.0.1
 */