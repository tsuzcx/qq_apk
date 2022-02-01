package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class ekx
  extends com.tencent.mm.bw.a
{
  public int Nkj;
  public int Nkk;
  public String Nkl;
  public b Nkm;
  public int Nkn;
  public int Nko;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82481);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Nkj);
      paramVarArgs.aM(2, this.Nkk);
      if (this.Nkl != null) {
        paramVarArgs.e(3, this.Nkl);
      }
      if (this.Nkm != null) {
        paramVarArgs.c(4, this.Nkm);
      }
      paramVarArgs.aM(5, this.Nkn);
      paramVarArgs.aM(6, this.Nko);
      AppMethodBeat.o(82481);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.Nkj) + 0 + g.a.a.b.b.a.bu(2, this.Nkk);
      paramInt = i;
      if (this.Nkl != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.Nkl);
      }
      i = paramInt;
      if (this.Nkm != null) {
        i = paramInt + g.a.a.b.b.a.b(4, this.Nkm);
      }
      paramInt = g.a.a.b.b.a.bu(5, this.Nkn);
      int j = g.a.a.b.b.a.bu(6, this.Nko);
      AppMethodBeat.o(82481);
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
      AppMethodBeat.o(82481);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ekx localekx = (ekx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(82481);
        return -1;
      case 1: 
        localekx.Nkj = locala.UbS.zi();
        AppMethodBeat.o(82481);
        return 0;
      case 2: 
        localekx.Nkk = locala.UbS.zi();
        AppMethodBeat.o(82481);
        return 0;
      case 3: 
        localekx.Nkl = locala.UbS.readString();
        AppMethodBeat.o(82481);
        return 0;
      case 4: 
        localekx.Nkm = locala.UbS.hPo();
        AppMethodBeat.o(82481);
        return 0;
      case 5: 
        localekx.Nkn = locala.UbS.zi();
        AppMethodBeat.o(82481);
        return 0;
      }
      localekx.Nko = locala.UbS.zi();
      AppMethodBeat.o(82481);
      return 0;
    }
    AppMethodBeat.o(82481);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ekx
 * JD-Core Version:    0.7.0.1
 */