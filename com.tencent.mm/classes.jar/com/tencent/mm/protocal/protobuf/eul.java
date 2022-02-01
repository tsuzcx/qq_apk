package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eul
  extends com.tencent.mm.bw.a
{
  public int NsB;
  public int NsC;
  public int NsD;
  public int NsE;
  public int NsF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115910);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.NsB);
      paramVarArgs.aM(2, this.NsC);
      paramVarArgs.aM(3, this.NsD);
      paramVarArgs.aM(4, this.NsE);
      paramVarArgs.aM(5, this.NsF);
      AppMethodBeat.o(115910);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.NsB);
      int i = g.a.a.b.b.a.bu(2, this.NsC);
      int j = g.a.a.b.b.a.bu(3, this.NsD);
      int k = g.a.a.b.b.a.bu(4, this.NsE);
      int m = g.a.a.b.b.a.bu(5, this.NsF);
      AppMethodBeat.o(115910);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(115910);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      eul localeul = (eul)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115910);
        return -1;
      case 1: 
        localeul.NsB = locala.UbS.zi();
        AppMethodBeat.o(115910);
        return 0;
      case 2: 
        localeul.NsC = locala.UbS.zi();
        AppMethodBeat.o(115910);
        return 0;
      case 3: 
        localeul.NsD = locala.UbS.zi();
        AppMethodBeat.o(115910);
        return 0;
      case 4: 
        localeul.NsE = locala.UbS.zi();
        AppMethodBeat.o(115910);
        return 0;
      }
      localeul.NsF = locala.UbS.zi();
      AppMethodBeat.o(115910);
      return 0;
    }
    AppMethodBeat.o(115910);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eul
 * JD-Core Version:    0.7.0.1
 */