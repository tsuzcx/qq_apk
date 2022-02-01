package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class bkf
  extends com.tencent.mm.bx.a
{
  public int DIc;
  public b DId;
  public int DIj;
  public int DIk;
  public int mAK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116337);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DIc);
      if (this.DId != null) {
        paramVarArgs.c(2, this.DId);
      }
      paramVarArgs.aR(3, this.DIj);
      paramVarArgs.aR(4, this.mAK);
      paramVarArgs.aR(5, this.DIk);
      AppMethodBeat.o(116337);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.DIc) + 0;
      paramInt = i;
      if (this.DId != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.DId);
      }
      i = f.a.a.b.b.a.bA(3, this.DIj);
      int j = f.a.a.b.b.a.bA(4, this.mAK);
      int k = f.a.a.b.b.a.bA(5, this.DIk);
      AppMethodBeat.o(116337);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(116337);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bkf localbkf = (bkf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(116337);
        return -1;
      case 1: 
        localbkf.DIc = locala.KhF.xS();
        AppMethodBeat.o(116337);
        return 0;
      case 2: 
        localbkf.DId = locala.KhF.fMu();
        AppMethodBeat.o(116337);
        return 0;
      case 3: 
        localbkf.DIj = locala.KhF.xS();
        AppMethodBeat.o(116337);
        return 0;
      case 4: 
        localbkf.mAK = locala.KhF.xS();
        AppMethodBeat.o(116337);
        return 0;
      }
      localbkf.DIk = locala.KhF.xS();
      AppMethodBeat.o(116337);
      return 0;
    }
    AppMethodBeat.o(116337);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkf
 * JD-Core Version:    0.7.0.1
 */