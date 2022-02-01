package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dxk
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b DTb;
  public long DUK;
  public int GdV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32552);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DTb == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: VoiceData");
        AppMethodBeat.o(32552);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.DUK);
      if (this.DTb != null) {
        paramVarArgs.c(2, this.DTb);
      }
      paramVarArgs.aR(3, this.GdV);
      AppMethodBeat.o(32552);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.DUK) + 0;
      paramInt = i;
      if (this.DTb != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.DTb);
      }
      i = f.a.a.b.b.a.bx(3, this.GdV);
      AppMethodBeat.o(32552);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.DTb == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: VoiceData");
        AppMethodBeat.o(32552);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32552);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dxk localdxk = (dxk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32552);
        return -1;
      case 1: 
        localdxk.DUK = locala.LVo.xG();
        AppMethodBeat.o(32552);
        return 0;
      case 2: 
        localdxk.DTb = locala.LVo.gfk();
        AppMethodBeat.o(32552);
        return 0;
      }
      localdxk.GdV = locala.LVo.xF();
      AppMethodBeat.o(32552);
      return 0;
    }
    AppMethodBeat.o(32552);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxk
 * JD-Core Version:    0.7.0.1
 */