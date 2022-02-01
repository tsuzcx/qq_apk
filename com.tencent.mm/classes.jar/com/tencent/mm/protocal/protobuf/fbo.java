package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fbo
  extends com.tencent.mm.bw.a
{
  public int KCD;
  public String Mmh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123681);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.KCD);
      if (this.Mmh != null) {
        paramVarArgs.e(2, this.Mmh);
      }
      AppMethodBeat.o(123681);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.KCD) + 0;
      paramInt = i;
      if (this.Mmh != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Mmh);
      }
      AppMethodBeat.o(123681);
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
      AppMethodBeat.o(123681);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fbo localfbo = (fbo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123681);
        return -1;
      case 1: 
        localfbo.KCD = locala.UbS.zi();
        AppMethodBeat.o(123681);
        return 0;
      }
      localfbo.Mmh = locala.UbS.readString();
      AppMethodBeat.o(123681);
      return 0;
    }
    AppMethodBeat.o(123681);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbo
 * JD-Core Version:    0.7.0.1
 */