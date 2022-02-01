package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cfr
  extends com.tencent.mm.bw.a
{
  public long dBN;
  public String dlQ;
  public int state;
  public String xpb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91619);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.xpb != null) {
        paramVarArgs.d(1, this.xpb);
      }
      paramVarArgs.aO(2, this.dBN);
      paramVarArgs.aR(3, this.state);
      if (this.dlQ != null) {
        paramVarArgs.d(4, this.dlQ);
      }
      AppMethodBeat.o(91619);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xpb == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = f.a.a.b.b.a.e(1, this.xpb) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.dBN) + f.a.a.b.b.a.bx(3, this.state);
      paramInt = i;
      if (this.dlQ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dlQ);
      }
      AppMethodBeat.o(91619);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91619);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cfr localcfr = (cfr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91619);
          return -1;
        case 1: 
          localcfr.xpb = locala.LVo.readString();
          AppMethodBeat.o(91619);
          return 0;
        case 2: 
          localcfr.dBN = locala.LVo.xG();
          AppMethodBeat.o(91619);
          return 0;
        case 3: 
          localcfr.state = locala.LVo.xF();
          AppMethodBeat.o(91619);
          return 0;
        }
        localcfr.dlQ = locala.LVo.readString();
        AppMethodBeat.o(91619);
        return 0;
      }
      AppMethodBeat.o(91619);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfr
 * JD-Core Version:    0.7.0.1
 */