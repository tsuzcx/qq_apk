package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class bx
  extends com.tencent.mm.bw.a
{
  public int FMT;
  public b FMU;
  public long udu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125702);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FMT);
      if (this.FMU != null) {
        paramVarArgs.c(2, this.FMU);
      }
      paramVarArgs.aZ(3, this.udu);
      AppMethodBeat.o(125702);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.FMT) + 0;
      paramInt = i;
      if (this.FMU != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.FMU);
      }
      i = f.a.a.b.b.a.p(3, this.udu);
      AppMethodBeat.o(125702);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(125702);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bx localbx = (bx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125702);
        return -1;
      case 1: 
        localbx.FMT = locala.OmT.zc();
        AppMethodBeat.o(125702);
        return 0;
      case 2: 
        localbx.FMU = locala.OmT.gCk();
        AppMethodBeat.o(125702);
        return 0;
      }
      localbx.udu = locala.OmT.zd();
      AppMethodBeat.o(125702);
      return 0;
    }
    AppMethodBeat.o(125702);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bx
 * JD-Core Version:    0.7.0.1
 */