package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ccg
  extends com.tencent.mm.bw.a
{
  public String Label;
  public float Mii;
  public float Mij;
  public float Mik;
  public String Mil;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32326);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.E(1, this.Mii);
      paramVarArgs.E(2, this.Mij);
      paramVarArgs.E(3, this.Mik);
      if (this.Label != null) {
        paramVarArgs.e(4, this.Label);
      }
      if (this.Mil != null) {
        paramVarArgs.e(5, this.Mil);
      }
      AppMethodBeat.o(32326);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.fS(1) + 4 + 0 + (g.a.a.b.b.a.fS(2) + 4) + (g.a.a.b.b.a.fS(3) + 4);
      paramInt = i;
      if (this.Label != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Label);
      }
      i = paramInt;
      if (this.Mil != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Mil);
      }
      AppMethodBeat.o(32326);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(32326);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ccg localccg = (ccg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32326);
        return -1;
      case 1: 
        localccg.Mii = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(32326);
        return 0;
      case 2: 
        localccg.Mij = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(32326);
        return 0;
      case 3: 
        localccg.Mik = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(32326);
        return 0;
      case 4: 
        localccg.Label = locala.UbS.readString();
        AppMethodBeat.o(32326);
        return 0;
      }
      localccg.Mil = locala.UbS.readString();
      AppMethodBeat.o(32326);
      return 0;
    }
    AppMethodBeat.o(32326);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccg
 * JD-Core Version:    0.7.0.1
 */