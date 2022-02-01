package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class bv
  extends com.tencent.mm.bx.a
{
  public int CwP;
  public b CwQ;
  public long rOh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125702);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.CwP);
      if (this.CwQ != null) {
        paramVarArgs.c(2, this.CwQ);
      }
      paramVarArgs.aG(3, this.rOh);
      AppMethodBeat.o(125702);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.CwP) + 0;
      paramInt = i;
      if (this.CwQ != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.CwQ);
      }
      i = f.a.a.b.b.a.q(3, this.rOh);
      AppMethodBeat.o(125702);
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
      AppMethodBeat.o(125702);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bv localbv = (bv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125702);
        return -1;
      case 1: 
        localbv.CwP = locala.KhF.xS();
        AppMethodBeat.o(125702);
        return 0;
      case 2: 
        localbv.CwQ = locala.KhF.fMu();
        AppMethodBeat.o(125702);
        return 0;
      }
      localbv.rOh = locala.KhF.xT();
      AppMethodBeat.o(125702);
      return 0;
    }
    AppMethodBeat.o(125702);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bv
 * JD-Core Version:    0.7.0.1
 */