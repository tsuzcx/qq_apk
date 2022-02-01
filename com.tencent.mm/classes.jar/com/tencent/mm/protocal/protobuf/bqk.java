package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bqk
  extends com.tencent.mm.bx.a
{
  public int DOH;
  public int DOI;
  public String mAQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(186488);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mAQ != null) {
        paramVarArgs.d(1, this.mAQ);
      }
      paramVarArgs.aR(2, this.DOH);
      paramVarArgs.aR(3, this.DOI);
      AppMethodBeat.o(186488);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mAQ == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = f.a.a.b.b.a.e(1, this.mAQ) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.DOH);
      int j = f.a.a.b.b.a.bA(3, this.DOI);
      AppMethodBeat.o(186488);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(186488);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bqk localbqk = (bqk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(186488);
          return -1;
        case 1: 
          localbqk.mAQ = locala.KhF.readString();
          AppMethodBeat.o(186488);
          return 0;
        case 2: 
          localbqk.DOH = locala.KhF.xS();
          AppMethodBeat.o(186488);
          return 0;
        }
        localbqk.DOI = locala.KhF.xS();
        AppMethodBeat.o(186488);
        return 0;
      }
      AppMethodBeat.o(186488);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqk
 * JD-Core Version:    0.7.0.1
 */