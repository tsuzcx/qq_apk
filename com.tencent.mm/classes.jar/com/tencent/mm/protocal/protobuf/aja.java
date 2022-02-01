package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aja
  extends com.tencent.mm.bw.a
{
  public long Brn;
  public int BsF;
  public int BsG;
  public int LsD;
  public String MD5;
  public int Ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(109447);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Ret);
      paramVarArgs.aM(2, this.BsG);
      paramVarArgs.aM(3, this.BsF);
      if (this.MD5 != null) {
        paramVarArgs.e(4, this.MD5);
      }
      paramVarArgs.aM(5, this.LsD);
      paramVarArgs.bb(6, this.Brn);
      AppMethodBeat.o(109447);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.Ret) + 0 + g.a.a.b.b.a.bu(2, this.BsG) + g.a.a.b.b.a.bu(3, this.BsF);
      paramInt = i;
      if (this.MD5 != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MD5);
      }
      i = g.a.a.b.b.a.bu(5, this.LsD);
      int j = g.a.a.b.b.a.r(6, this.Brn);
      AppMethodBeat.o(109447);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(109447);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      aja localaja = (aja)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(109447);
        return -1;
      case 1: 
        localaja.Ret = locala.UbS.zi();
        AppMethodBeat.o(109447);
        return 0;
      case 2: 
        localaja.BsG = locala.UbS.zi();
        AppMethodBeat.o(109447);
        return 0;
      case 3: 
        localaja.BsF = locala.UbS.zi();
        AppMethodBeat.o(109447);
        return 0;
      case 4: 
        localaja.MD5 = locala.UbS.readString();
        AppMethodBeat.o(109447);
        return 0;
      case 5: 
        localaja.LsD = locala.UbS.zi();
        AppMethodBeat.o(109447);
        return 0;
      }
      localaja.Brn = locala.UbS.zl();
      AppMethodBeat.o(109447);
      return 0;
    }
    AppMethodBeat.o(109447);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aja
 * JD-Core Version:    0.7.0.1
 */