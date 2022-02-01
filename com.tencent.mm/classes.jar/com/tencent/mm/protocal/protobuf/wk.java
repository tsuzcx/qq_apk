package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class wk
  extends com.tencent.mm.bx.a
{
  public String dlB;
  public long gLf;
  public int idx;
  public String path;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124473);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.gLf);
      paramVarArgs.aR(2, this.idx);
      if (this.dlB != null) {
        paramVarArgs.d(3, this.dlB);
      }
      if (this.path != null) {
        paramVarArgs.d(4, this.path);
      }
      AppMethodBeat.o(124473);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.q(1, this.gLf) + 0 + f.a.a.b.b.a.bA(2, this.idx);
      paramInt = i;
      if (this.dlB != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dlB);
      }
      i = paramInt;
      if (this.path != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.path);
      }
      AppMethodBeat.o(124473);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(124473);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      wk localwk = (wk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124473);
        return -1;
      case 1: 
        localwk.gLf = locala.KhF.xT();
        AppMethodBeat.o(124473);
        return 0;
      case 2: 
        localwk.idx = locala.KhF.xS();
        AppMethodBeat.o(124473);
        return 0;
      case 3: 
        localwk.dlB = locala.KhF.readString();
        AppMethodBeat.o(124473);
        return 0;
      }
      localwk.path = locala.KhF.readString();
      AppMethodBeat.o(124473);
      return 0;
    }
    AppMethodBeat.o(124473);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wk
 * JD-Core Version:    0.7.0.1
 */