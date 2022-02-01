package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dxq
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b DTb;
  public String FDc;
  public long GdW;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32559);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FDc == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32559);
        throw paramVarArgs;
      }
      if (this.DTb == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: VoiceData");
        AppMethodBeat.o(32559);
        throw paramVarArgs;
      }
      if (this.FDc != null) {
        paramVarArgs.d(1, this.FDc);
      }
      paramVarArgs.aO(2, this.GdW);
      if (this.DTb != null) {
        paramVarArgs.c(3, this.DTb);
      }
      paramVarArgs.aR(4, this.Scene);
      AppMethodBeat.o(32559);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FDc == null) {
        break label472;
      }
    }
    label472:
    for (paramInt = f.a.a.b.b.a.e(1, this.FDc) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.GdW);
      paramInt = i;
      if (this.DTb != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.DTb);
      }
      i = f.a.a.b.b.a.bx(4, this.Scene);
      AppMethodBeat.o(32559);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FDc == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: Talker");
          AppMethodBeat.o(32559);
          throw paramVarArgs;
        }
        if (this.DTb == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: VoiceData");
          AppMethodBeat.o(32559);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32559);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dxq localdxq = (dxq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32559);
          return -1;
        case 1: 
          localdxq.FDc = locala.LVo.readString();
          AppMethodBeat.o(32559);
          return 0;
        case 2: 
          localdxq.GdW = locala.LVo.xG();
          AppMethodBeat.o(32559);
          return 0;
        case 3: 
          localdxq.DTb = locala.LVo.gfk();
          AppMethodBeat.o(32559);
          return 0;
        }
        localdxq.Scene = locala.LVo.xF();
        AppMethodBeat.o(32559);
        return 0;
      }
      AppMethodBeat.o(32559);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxq
 * JD-Core Version:    0.7.0.1
 */