package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dns
  extends com.tencent.mm.bw.a
{
  public int vTH;
  public int vTI;
  public int vTJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32486);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.vTH);
      paramVarArgs.aR(2, this.vTI);
      paramVarArgs.aR(3, this.vTJ);
      AppMethodBeat.o(32486);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.vTH);
      int i = f.a.a.b.b.a.bx(2, this.vTI);
      int j = f.a.a.b.b.a.bx(3, this.vTJ);
      AppMethodBeat.o(32486);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(32486);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dns localdns = (dns)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32486);
        return -1;
      case 1: 
        localdns.vTH = locala.LVo.xF();
        AppMethodBeat.o(32486);
        return 0;
      case 2: 
        localdns.vTI = locala.LVo.xF();
        AppMethodBeat.o(32486);
        return 0;
      }
      localdns.vTJ = locala.LVo.xF();
      AppMethodBeat.o(32486);
      return 0;
    }
    AppMethodBeat.o(32486);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dns
 * JD-Core Version:    0.7.0.1
 */