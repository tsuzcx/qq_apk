package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ecn
  extends com.tencent.mm.bw.a
{
  public int FpT;
  public String GhW;
  public boolean Gib;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50127);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GhW != null) {
        paramVarArgs.d(1, this.GhW);
      }
      paramVarArgs.bl(2, this.Gib);
      paramVarArgs.aR(3, this.FpT);
      AppMethodBeat.o(50127);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GhW == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = f.a.a.b.b.a.e(1, this.GhW) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.fK(2);
      int j = f.a.a.b.b.a.bx(3, this.FpT);
      AppMethodBeat.o(50127);
      return paramInt + (i + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(50127);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ecn localecn = (ecn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50127);
          return -1;
        case 1: 
          localecn.GhW = locala.LVo.readString();
          AppMethodBeat.o(50127);
          return 0;
        case 2: 
          localecn.Gib = locala.LVo.fZX();
          AppMethodBeat.o(50127);
          return 0;
        }
        localecn.FpT = locala.LVo.xF();
        AppMethodBeat.o(50127);
        return 0;
      }
      AppMethodBeat.o(50127);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecn
 * JD-Core Version:    0.7.0.1
 */