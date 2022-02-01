package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ccw
  extends com.tencent.mm.bx.a
{
  public int GXa;
  public String dxD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169088);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GXa);
      if (this.dxD != null) {
        paramVarArgs.d(2, this.dxD);
      }
      AppMethodBeat.o(169088);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.GXa) + 0;
      paramInt = i;
      if (this.dxD != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dxD);
      }
      AppMethodBeat.o(169088);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(169088);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ccw localccw = (ccw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169088);
        return -1;
      case 1: 
        localccw.GXa = locala.NPN.zc();
        AppMethodBeat.o(169088);
        return 0;
      }
      localccw.dxD = locala.NPN.readString();
      AppMethodBeat.o(169088);
      return 0;
    }
    AppMethodBeat.o(169088);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccw
 * JD-Core Version:    0.7.0.1
 */