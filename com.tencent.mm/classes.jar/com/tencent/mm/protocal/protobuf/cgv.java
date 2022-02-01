package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cgv
  extends com.tencent.mm.bw.a
{
  public int KWb;
  public int Mmd;
  public String Mme;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(146308);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Mmd);
      if (this.Mme != null) {
        paramVarArgs.e(2, this.Mme);
      }
      paramVarArgs.aM(3, this.KWb);
      AppMethodBeat.o(146308);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.Mmd) + 0;
      paramInt = i;
      if (this.Mme != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Mme);
      }
      i = g.a.a.b.b.a.bu(3, this.KWb);
      AppMethodBeat.o(146308);
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
      AppMethodBeat.o(146308);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cgv localcgv = (cgv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(146308);
        return -1;
      case 1: 
        localcgv.Mmd = locala.UbS.zi();
        AppMethodBeat.o(146308);
        return 0;
      case 2: 
        localcgv.Mme = locala.UbS.readString();
        AppMethodBeat.o(146308);
        return 0;
      }
      localcgv.KWb = locala.UbS.zi();
      AppMethodBeat.o(146308);
      return 0;
    }
    AppMethodBeat.o(146308);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgv
 * JD-Core Version:    0.7.0.1
 */