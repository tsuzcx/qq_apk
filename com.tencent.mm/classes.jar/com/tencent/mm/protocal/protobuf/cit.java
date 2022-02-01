package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class cit
  extends com.tencent.mm.bx.a
{
  public int DYI;
  public b DbF;
  public String Eeg;
  public int mBH;
  public int oXH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(138185);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Eeg != null) {
        paramVarArgs.d(1, this.Eeg);
      }
      paramVarArgs.aR(2, this.mBH);
      paramVarArgs.aR(3, this.oXH);
      paramVarArgs.aR(4, this.DYI);
      if (this.DbF != null) {
        paramVarArgs.c(5, this.DbF);
      }
      AppMethodBeat.o(138185);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Eeg == null) {
        break label402;
      }
    }
    label402:
    for (paramInt = f.a.a.b.b.a.e(1, this.Eeg) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.mBH) + f.a.a.b.b.a.bA(3, this.oXH) + f.a.a.b.b.a.bA(4, this.DYI);
      paramInt = i;
      if (this.DbF != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.DbF);
      }
      AppMethodBeat.o(138185);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(138185);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cit localcit = (cit)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(138185);
          return -1;
        case 1: 
          localcit.Eeg = locala.KhF.readString();
          AppMethodBeat.o(138185);
          return 0;
        case 2: 
          localcit.mBH = locala.KhF.xS();
          AppMethodBeat.o(138185);
          return 0;
        case 3: 
          localcit.oXH = locala.KhF.xS();
          AppMethodBeat.o(138185);
          return 0;
        case 4: 
          localcit.DYI = locala.KhF.xS();
          AppMethodBeat.o(138185);
          return 0;
        }
        localcit.DbF = locala.KhF.fMu();
        AppMethodBeat.o(138185);
        return 0;
      }
      AppMethodBeat.o(138185);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cit
 * JD-Core Version:    0.7.0.1
 */