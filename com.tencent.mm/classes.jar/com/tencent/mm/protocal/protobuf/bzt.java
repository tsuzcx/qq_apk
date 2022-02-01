package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bzt
  extends com.tencent.mm.bw.a
{
  public int Mfo;
  public int Mfp;
  public boolean Mfq;
  public boolean Mfr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50094);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Mfo);
      paramVarArgs.aM(2, this.Mfp);
      paramVarArgs.cc(3, this.Mfq);
      paramVarArgs.cc(4, this.Mfr);
      AppMethodBeat.o(50094);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.Mfo);
      int i = g.a.a.b.b.a.bu(2, this.Mfp);
      int j = g.a.a.b.b.a.fS(3);
      int k = g.a.a.b.b.a.fS(4);
      AppMethodBeat.o(50094);
      return paramInt + 0 + i + (j + 1) + (k + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(50094);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bzt localbzt = (bzt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50094);
        return -1;
      case 1: 
        localbzt.Mfo = locala.UbS.zi();
        AppMethodBeat.o(50094);
        return 0;
      case 2: 
        localbzt.Mfp = locala.UbS.zi();
        AppMethodBeat.o(50094);
        return 0;
      case 3: 
        localbzt.Mfq = locala.UbS.yZ();
        AppMethodBeat.o(50094);
        return 0;
      }
      localbzt.Mfr = locala.UbS.yZ();
      AppMethodBeat.o(50094);
      return 0;
    }
    AppMethodBeat.o(50094);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzt
 * JD-Core Version:    0.7.0.1
 */