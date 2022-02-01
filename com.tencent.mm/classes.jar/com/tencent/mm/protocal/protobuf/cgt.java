package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cgt
  extends com.tencent.mm.bw.a
{
  public String KZR;
  public boolean Mma;
  public int type;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91530);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.type);
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      if (this.KZR != null) {
        paramVarArgs.e(3, this.KZR);
      }
      paramVarArgs.cc(4, this.Mma);
      AppMethodBeat.o(91530);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.type) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.url);
      }
      i = paramInt;
      if (this.KZR != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KZR);
      }
      paramInt = g.a.a.b.b.a.fS(4);
      AppMethodBeat.o(91530);
      return i + (paramInt + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(91530);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cgt localcgt = (cgt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91530);
        return -1;
      case 1: 
        localcgt.type = locala.UbS.zi();
        AppMethodBeat.o(91530);
        return 0;
      case 2: 
        localcgt.url = locala.UbS.readString();
        AppMethodBeat.o(91530);
        return 0;
      case 3: 
        localcgt.KZR = locala.UbS.readString();
        AppMethodBeat.o(91530);
        return 0;
      }
      localcgt.Mma = locala.UbS.yZ();
      AppMethodBeat.o(91530);
      return 0;
    }
    AppMethodBeat.o(91530);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgt
 * JD-Core Version:    0.7.0.1
 */