package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class bkb
  extends com.tencent.mm.bx.a
{
  public int DIc;
  public b DId;
  public int DIe;
  public int DIf;
  public int Dcz;
  public int mAK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143982);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DIc);
      if (this.DId != null) {
        paramVarArgs.c(2, this.DId);
      }
      paramVarArgs.aR(3, this.DIe);
      paramVarArgs.aR(4, this.Dcz);
      paramVarArgs.aR(5, this.mAK);
      paramVarArgs.aR(6, this.DIf);
      AppMethodBeat.o(143982);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.DIc) + 0;
      paramInt = i;
      if (this.DId != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.DId);
      }
      i = f.a.a.b.b.a.bA(3, this.DIe);
      int j = f.a.a.b.b.a.bA(4, this.Dcz);
      int k = f.a.a.b.b.a.bA(5, this.mAK);
      int m = f.a.a.b.b.a.bA(6, this.DIf);
      AppMethodBeat.o(143982);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(143982);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bkb localbkb = (bkb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143982);
        return -1;
      case 1: 
        localbkb.DIc = locala.KhF.xS();
        AppMethodBeat.o(143982);
        return 0;
      case 2: 
        localbkb.DId = locala.KhF.fMu();
        AppMethodBeat.o(143982);
        return 0;
      case 3: 
        localbkb.DIe = locala.KhF.xS();
        AppMethodBeat.o(143982);
        return 0;
      case 4: 
        localbkb.Dcz = locala.KhF.xS();
        AppMethodBeat.o(143982);
        return 0;
      case 5: 
        localbkb.mAK = locala.KhF.xS();
        AppMethodBeat.o(143982);
        return 0;
      }
      localbkb.DIf = locala.KhF.xS();
      AppMethodBeat.o(143982);
      return 0;
    }
    AppMethodBeat.o(143982);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkb
 * JD-Core Version:    0.7.0.1
 */