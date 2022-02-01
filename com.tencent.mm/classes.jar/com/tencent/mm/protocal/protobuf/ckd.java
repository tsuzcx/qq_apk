package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ckd
  extends com.tencent.mm.bw.a
{
  public String HwO;
  public String HwP;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91595);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.HwO != null) {
        paramVarArgs.d(2, this.HwO);
      }
      if (this.HwP != null) {
        paramVarArgs.d(3, this.HwP);
      }
      AppMethodBeat.o(91595);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HwO != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HwO);
      }
      i = paramInt;
      if (this.HwP != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HwP);
      }
      AppMethodBeat.o(91595);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91595);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ckd localckd = (ckd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91595);
          return -1;
        case 1: 
          localckd.title = locala.OmT.readString();
          AppMethodBeat.o(91595);
          return 0;
        case 2: 
          localckd.HwO = locala.OmT.readString();
          AppMethodBeat.o(91595);
          return 0;
        }
        localckd.HwP = locala.OmT.readString();
        AppMethodBeat.o(91595);
        return 0;
      }
      AppMethodBeat.o(91595);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckd
 * JD-Core Version:    0.7.0.1
 */