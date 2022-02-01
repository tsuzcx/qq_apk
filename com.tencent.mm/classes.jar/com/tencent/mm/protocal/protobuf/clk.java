package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class clk
  extends com.tencent.mm.bw.a
{
  public long dPq;
  public String dyI;
  public int state;
  public String xrF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91619);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.xrF != null) {
        paramVarArgs.d(1, this.xrF);
      }
      paramVarArgs.aZ(2, this.dPq);
      paramVarArgs.aS(3, this.state);
      if (this.dyI != null) {
        paramVarArgs.d(4, this.dyI);
      }
      AppMethodBeat.o(91619);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xrF == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = f.a.a.b.b.a.e(1, this.xrF) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.dPq) + f.a.a.b.b.a.bz(3, this.state);
      paramInt = i;
      if (this.dyI != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dyI);
      }
      AppMethodBeat.o(91619);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91619);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        clk localclk = (clk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91619);
          return -1;
        case 1: 
          localclk.xrF = locala.OmT.readString();
          AppMethodBeat.o(91619);
          return 0;
        case 2: 
          localclk.dPq = locala.OmT.zd();
          AppMethodBeat.o(91619);
          return 0;
        case 3: 
          localclk.state = locala.OmT.zc();
          AppMethodBeat.o(91619);
          return 0;
        }
        localclk.dyI = locala.OmT.readString();
        AppMethodBeat.o(91619);
        return 0;
      }
      AppMethodBeat.o(91619);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clk
 * JD-Core Version:    0.7.0.1
 */