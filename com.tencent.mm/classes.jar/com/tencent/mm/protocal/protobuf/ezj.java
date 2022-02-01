package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ezj
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b KKz;
  public long KMm;
  public int NvM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32552);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KKz == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: VoiceData");
        AppMethodBeat.o(32552);
        throw paramVarArgs;
      }
      paramVarArgs.bb(1, this.KMm);
      if (this.KKz != null) {
        paramVarArgs.c(2, this.KKz);
      }
      paramVarArgs.aM(3, this.NvM);
      AppMethodBeat.o(32552);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.KMm) + 0;
      paramInt = i;
      if (this.KKz != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.KKz);
      }
      i = g.a.a.b.b.a.bu(3, this.NvM);
      AppMethodBeat.o(32552);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.KKz == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: VoiceData");
        AppMethodBeat.o(32552);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32552);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ezj localezj = (ezj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32552);
        return -1;
      case 1: 
        localezj.KMm = locala.UbS.zl();
        AppMethodBeat.o(32552);
        return 0;
      case 2: 
        localezj.KKz = locala.UbS.hPo();
        AppMethodBeat.o(32552);
        return 0;
      }
      localezj.NvM = locala.UbS.zi();
      AppMethodBeat.o(32552);
      return 0;
    }
    AppMethodBeat.o(32552);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezj
 * JD-Core Version:    0.7.0.1
 */