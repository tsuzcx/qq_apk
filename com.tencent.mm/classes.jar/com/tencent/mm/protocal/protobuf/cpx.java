package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cpx
  extends com.tencent.mm.bv.a
{
  public int state;
  public int xYD;
  public String xmo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(10249);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xmo != null) {
        paramVarArgs.e(1, this.xmo);
      }
      paramVarArgs.aO(2, this.state);
      paramVarArgs.aO(3, this.xYD);
      AppMethodBeat.o(10249);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xmo == null) {
        break label315;
      }
    }
    label315:
    for (paramInt = e.a.a.b.b.a.f(1, this.xmo) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.state);
      int j = e.a.a.b.b.a.bl(3, this.xYD);
      AppMethodBeat.o(10249);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(10249);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cpx localcpx = (cpx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(10249);
          return -1;
        case 1: 
          localcpx.xmo = locala.CLY.readString();
          AppMethodBeat.o(10249);
          return 0;
        case 2: 
          localcpx.state = locala.CLY.sl();
          AppMethodBeat.o(10249);
          return 0;
        }
        localcpx.xYD = locala.CLY.sl();
        AppMethodBeat.o(10249);
        return 0;
      }
      AppMethodBeat.o(10249);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpx
 * JD-Core Version:    0.7.0.1
 */