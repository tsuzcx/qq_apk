package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class byw
  extends com.tencent.mm.bx.a
{
  public int CEt;
  public String DVD;
  public b DVE;
  public b DVF;
  public b DVG;
  public String DVH;
  public int mBi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91577);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DVD != null) {
        paramVarArgs.d(1, this.DVD);
      }
      paramVarArgs.aR(2, this.mBi);
      if (this.DVE != null) {
        paramVarArgs.c(3, this.DVE);
      }
      if (this.DVF != null) {
        paramVarArgs.c(4, this.DVF);
      }
      if (this.DVG != null) {
        paramVarArgs.c(5, this.DVG);
      }
      paramVarArgs.aR(6, this.CEt);
      if (this.DVH != null) {
        paramVarArgs.d(7, this.DVH);
      }
      AppMethodBeat.o(91577);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DVD == null) {
        break label546;
      }
    }
    label546:
    for (paramInt = f.a.a.b.b.a.e(1, this.DVD) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.mBi);
      paramInt = i;
      if (this.DVE != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.DVE);
      }
      i = paramInt;
      if (this.DVF != null) {
        i = paramInt + f.a.a.b.b.a.b(4, this.DVF);
      }
      paramInt = i;
      if (this.DVG != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.DVG);
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.CEt);
      paramInt = i;
      if (this.DVH != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DVH);
      }
      AppMethodBeat.o(91577);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91577);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        byw localbyw = (byw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91577);
          return -1;
        case 1: 
          localbyw.DVD = locala.KhF.readString();
          AppMethodBeat.o(91577);
          return 0;
        case 2: 
          localbyw.mBi = locala.KhF.xS();
          AppMethodBeat.o(91577);
          return 0;
        case 3: 
          localbyw.DVE = locala.KhF.fMu();
          AppMethodBeat.o(91577);
          return 0;
        case 4: 
          localbyw.DVF = locala.KhF.fMu();
          AppMethodBeat.o(91577);
          return 0;
        case 5: 
          localbyw.DVG = locala.KhF.fMu();
          AppMethodBeat.o(91577);
          return 0;
        case 6: 
          localbyw.CEt = locala.KhF.xS();
          AppMethodBeat.o(91577);
          return 0;
        }
        localbyw.DVH = locala.KhF.readString();
        AppMethodBeat.o(91577);
        return 0;
      }
      AppMethodBeat.o(91577);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byw
 * JD-Core Version:    0.7.0.1
 */