package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class bk
  extends com.tencent.mm.bx.a
{
  public int CvW;
  public int CvX;
  public b CvY;
  public int CvZ;
  public int Cwa;
  public int uin;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125690);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.uin);
      paramVarArgs.aR(2, this.CvW);
      paramVarArgs.aR(3, this.CvX);
      if (this.CvY != null) {
        paramVarArgs.c(4, this.CvY);
      }
      paramVarArgs.aR(5, this.CvZ);
      paramVarArgs.aR(6, this.Cwa);
      AppMethodBeat.o(125690);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.uin) + 0 + f.a.a.b.b.a.bA(2, this.CvW) + f.a.a.b.b.a.bA(3, this.CvX);
      paramInt = i;
      if (this.CvY != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.CvY);
      }
      i = f.a.a.b.b.a.bA(5, this.CvZ);
      int j = f.a.a.b.b.a.bA(6, this.Cwa);
      AppMethodBeat.o(125690);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(125690);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bk localbk = (bk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125690);
        return -1;
      case 1: 
        localbk.uin = locala.KhF.xS();
        AppMethodBeat.o(125690);
        return 0;
      case 2: 
        localbk.CvW = locala.KhF.xS();
        AppMethodBeat.o(125690);
        return 0;
      case 3: 
        localbk.CvX = locala.KhF.xS();
        AppMethodBeat.o(125690);
        return 0;
      case 4: 
        localbk.CvY = locala.KhF.fMu();
        AppMethodBeat.o(125690);
        return 0;
      case 5: 
        localbk.CvZ = locala.KhF.xS();
        AppMethodBeat.o(125690);
        return 0;
      }
      localbk.Cwa = locala.KhF.xS();
      AppMethodBeat.o(125690);
      return 0;
    }
    AppMethodBeat.o(125690);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bk
 * JD-Core Version:    0.7.0.1
 */