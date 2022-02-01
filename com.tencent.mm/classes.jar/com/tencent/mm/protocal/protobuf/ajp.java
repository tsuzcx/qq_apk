package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ajp
  extends com.tencent.mm.bx.a
{
  public long DlB;
  public int DlC;
  public int cUL;
  public int liveStatus;
  public String xvn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(190569);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.DlB);
      paramVarArgs.aR(2, this.DlC);
      paramVarArgs.aR(3, this.liveStatus);
      if (this.xvn != null) {
        paramVarArgs.d(4, this.xvn);
      }
      paramVarArgs.aR(5, this.cUL);
      AppMethodBeat.o(190569);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.q(1, this.DlB) + 0 + f.a.a.b.b.a.bA(2, this.DlC) + f.a.a.b.b.a.bA(3, this.liveStatus);
      paramInt = i;
      if (this.xvn != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.xvn);
      }
      i = f.a.a.b.b.a.bA(5, this.cUL);
      AppMethodBeat.o(190569);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(190569);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ajp localajp = (ajp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(190569);
        return -1;
      case 1: 
        localajp.DlB = locala.KhF.xT();
        AppMethodBeat.o(190569);
        return 0;
      case 2: 
        localajp.DlC = locala.KhF.xS();
        AppMethodBeat.o(190569);
        return 0;
      case 3: 
        localajp.liveStatus = locala.KhF.xS();
        AppMethodBeat.o(190569);
        return 0;
      case 4: 
        localajp.xvn = locala.KhF.readString();
        AppMethodBeat.o(190569);
        return 0;
      }
      localajp.cUL = locala.KhF.xS();
      AppMethodBeat.o(190569);
      return 0;
    }
    AppMethodBeat.o(190569);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajp
 * JD-Core Version:    0.7.0.1
 */