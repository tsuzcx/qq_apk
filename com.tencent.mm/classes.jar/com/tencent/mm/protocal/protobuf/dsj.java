package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dsj
  extends com.tencent.mm.bw.a
{
  public int AOB;
  public String FPP;
  public int FZT;
  public int gap;
  public int port;
  public int timeout;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115896);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FPP != null) {
        paramVarArgs.d(1, this.FPP);
      }
      paramVarArgs.aR(2, this.port);
      paramVarArgs.aR(3, this.AOB);
      paramVarArgs.aR(4, this.gap);
      paramVarArgs.aR(5, this.timeout);
      paramVarArgs.aR(6, this.FZT);
      AppMethodBeat.o(115896);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FPP == null) {
        break label446;
      }
    }
    label446:
    for (paramInt = f.a.a.b.b.a.e(1, this.FPP) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.port);
      int j = f.a.a.b.b.a.bx(3, this.AOB);
      int k = f.a.a.b.b.a.bx(4, this.gap);
      int m = f.a.a.b.b.a.bx(5, this.timeout);
      int n = f.a.a.b.b.a.bx(6, this.FZT);
      AppMethodBeat.o(115896);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(115896);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dsj localdsj = (dsj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(115896);
          return -1;
        case 1: 
          localdsj.FPP = locala.LVo.readString();
          AppMethodBeat.o(115896);
          return 0;
        case 2: 
          localdsj.port = locala.LVo.xF();
          AppMethodBeat.o(115896);
          return 0;
        case 3: 
          localdsj.AOB = locala.LVo.xF();
          AppMethodBeat.o(115896);
          return 0;
        case 4: 
          localdsj.gap = locala.LVo.xF();
          AppMethodBeat.o(115896);
          return 0;
        case 5: 
          localdsj.timeout = locala.LVo.xF();
          AppMethodBeat.o(115896);
          return 0;
        }
        localdsj.FZT = locala.LVo.xF();
        AppMethodBeat.o(115896);
        return 0;
      }
      AppMethodBeat.o(115896);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsj
 * JD-Core Version:    0.7.0.1
 */