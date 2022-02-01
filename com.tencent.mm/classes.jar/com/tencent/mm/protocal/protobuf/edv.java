package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class edv
  extends com.tencent.mm.bw.a
{
  public int MYT;
  public String xNG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118456);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.MYT);
      if (this.xNG != null) {
        paramVarArgs.e(2, this.xNG);
      }
      AppMethodBeat.o(118456);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.MYT) + 0;
      paramInt = i;
      if (this.xNG != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.xNG);
      }
      AppMethodBeat.o(118456);
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
      AppMethodBeat.o(118456);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      edv localedv = (edv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(118456);
        return -1;
      case 1: 
        localedv.MYT = locala.UbS.zi();
        AppMethodBeat.o(118456);
        return 0;
      }
      localedv.xNG = locala.UbS.readString();
      AppMethodBeat.o(118456);
      return 0;
    }
    AppMethodBeat.o(118456);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edv
 * JD-Core Version:    0.7.0.1
 */