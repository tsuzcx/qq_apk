package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ajt
  extends com.tencent.mm.bx.a
{
  public String DkS;
  public int DlH;
  public int DlI;
  public String KTW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184203);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DkS != null) {
        paramVarArgs.d(1, this.DkS);
      }
      paramVarArgs.aR(2, this.DlH);
      paramVarArgs.aR(3, this.DlI);
      if (this.KTW != null) {
        paramVarArgs.d(4, this.KTW);
      }
      AppMethodBeat.o(184203);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DkS == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = f.a.a.b.b.a.e(1, this.DkS) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.DlH) + f.a.a.b.b.a.bA(3, this.DlI);
      paramInt = i;
      if (this.KTW != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.KTW);
      }
      AppMethodBeat.o(184203);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(184203);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ajt localajt = (ajt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(184203);
          return -1;
        case 1: 
          localajt.DkS = locala.KhF.readString();
          AppMethodBeat.o(184203);
          return 0;
        case 2: 
          localajt.DlH = locala.KhF.xS();
          AppMethodBeat.o(184203);
          return 0;
        case 3: 
          localajt.DlI = locala.KhF.xS();
          AppMethodBeat.o(184203);
          return 0;
        }
        localajt.KTW = locala.KhF.readString();
        AppMethodBeat.o(184203);
        return 0;
      }
      AppMethodBeat.o(184203);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajt
 * JD-Core Version:    0.7.0.1
 */