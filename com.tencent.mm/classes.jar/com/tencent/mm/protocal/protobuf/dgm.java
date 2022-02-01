package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dgm
  extends com.tencent.mm.bw.a
{
  public String LPg;
  public int LPy;
  public int Ltc;
  public String MD5;
  public int MLe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155451);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.LPy);
      if (this.LPg != null) {
        paramVarArgs.e(2, this.LPg);
      }
      if (this.MD5 != null) {
        paramVarArgs.e(3, this.MD5);
      }
      paramVarArgs.aM(4, this.Ltc);
      paramVarArgs.aM(5, this.MLe);
      AppMethodBeat.o(155451);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.LPy) + 0;
      paramInt = i;
      if (this.LPg != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LPg);
      }
      i = paramInt;
      if (this.MD5 != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MD5);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.Ltc);
      int j = g.a.a.b.b.a.bu(5, this.MLe);
      AppMethodBeat.o(155451);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(155451);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dgm localdgm = (dgm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(155451);
        return -1;
      case 1: 
        localdgm.LPy = locala.UbS.zi();
        AppMethodBeat.o(155451);
        return 0;
      case 2: 
        localdgm.LPg = locala.UbS.readString();
        AppMethodBeat.o(155451);
        return 0;
      case 3: 
        localdgm.MD5 = locala.UbS.readString();
        AppMethodBeat.o(155451);
        return 0;
      case 4: 
        localdgm.Ltc = locala.UbS.zi();
        AppMethodBeat.o(155451);
        return 0;
      }
      localdgm.MLe = locala.UbS.zi();
      AppMethodBeat.o(155451);
      return 0;
    }
    AppMethodBeat.o(155451);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgm
 * JD-Core Version:    0.7.0.1
 */