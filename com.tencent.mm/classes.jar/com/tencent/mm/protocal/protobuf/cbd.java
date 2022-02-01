package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class cbd
  extends com.tencent.mm.bw.a
{
  public b MgA;
  public long eht;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116328);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.eht);
      if (this.MgA != null) {
        paramVarArgs.c(2, this.MgA);
      }
      AppMethodBeat.o(116328);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.eht) + 0;
      paramInt = i;
      if (this.MgA != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.MgA);
      }
      AppMethodBeat.o(116328);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(116328);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cbd localcbd = (cbd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(116328);
        return -1;
      case 1: 
        localcbd.eht = locala.UbS.zl();
        AppMethodBeat.o(116328);
        return 0;
      }
      localcbd.MgA = locala.UbS.hPo();
      AppMethodBeat.o(116328);
      return 0;
    }
    AppMethodBeat.o(116328);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbd
 * JD-Core Version:    0.7.0.1
 */