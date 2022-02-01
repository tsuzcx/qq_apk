package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ckq
  extends com.tencent.mm.bx.a
{
  public long dOa;
  public String dxD;
  public int state;
  public String xbO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91619);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.xbO != null) {
        paramVarArgs.d(1, this.xbO);
      }
      paramVarArgs.aY(2, this.dOa);
      paramVarArgs.aS(3, this.state);
      if (this.dxD != null) {
        paramVarArgs.d(4, this.dxD);
      }
      AppMethodBeat.o(91619);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xbO == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = f.a.a.b.b.a.e(1, this.xbO) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.dOa) + f.a.a.b.b.a.bz(3, this.state);
      paramInt = i;
      if (this.dxD != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dxD);
      }
      AppMethodBeat.o(91619);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91619);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ckq localckq = (ckq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91619);
          return -1;
        case 1: 
          localckq.xbO = locala.NPN.readString();
          AppMethodBeat.o(91619);
          return 0;
        case 2: 
          localckq.dOa = locala.NPN.zd();
          AppMethodBeat.o(91619);
          return 0;
        case 3: 
          localckq.state = locala.NPN.zc();
          AppMethodBeat.o(91619);
          return 0;
        }
        localckq.dxD = locala.NPN.readString();
        AppMethodBeat.o(91619);
        return 0;
      }
      AppMethodBeat.o(91619);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckq
 * JD-Core Version:    0.7.0.1
 */