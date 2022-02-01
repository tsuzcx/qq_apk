package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fem
  extends com.tencent.mm.bw.a
{
  public int NzJ;
  public int NzK;
  public int NzL;
  public int NzM;
  public String NzN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153337);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.NzJ);
      paramVarArgs.aM(2, this.NzK);
      paramVarArgs.aM(3, this.NzL);
      paramVarArgs.aM(4, this.NzM);
      if (this.NzN != null) {
        paramVarArgs.e(5, this.NzN);
      }
      AppMethodBeat.o(153337);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.NzJ) + 0 + g.a.a.b.b.a.bu(2, this.NzK) + g.a.a.b.b.a.bu(3, this.NzL) + g.a.a.b.b.a.bu(4, this.NzM);
      paramInt = i;
      if (this.NzN != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.NzN);
      }
      AppMethodBeat.o(153337);
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
      AppMethodBeat.o(153337);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fem localfem = (fem)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153337);
        return -1;
      case 1: 
        localfem.NzJ = locala.UbS.zi();
        AppMethodBeat.o(153337);
        return 0;
      case 2: 
        localfem.NzK = locala.UbS.zi();
        AppMethodBeat.o(153337);
        return 0;
      case 3: 
        localfem.NzL = locala.UbS.zi();
        AppMethodBeat.o(153337);
        return 0;
      case 4: 
        localfem.NzM = locala.UbS.zi();
        AppMethodBeat.o(153337);
        return 0;
      }
      localfem.NzN = locala.UbS.readString();
      AppMethodBeat.o(153337);
      return 0;
    }
    AppMethodBeat.o(153337);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fem
 * JD-Core Version:    0.7.0.1
 */