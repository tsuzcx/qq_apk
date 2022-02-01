package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fbm
  extends com.tencent.mm.bw.a
{
  public String BsJ;
  public int KXD;
  public String NxJ;
  public String dNI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82491);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dNI != null) {
        paramVarArgs.e(1, this.dNI);
      }
      paramVarArgs.aM(2, this.KXD);
      if (this.NxJ != null) {
        paramVarArgs.e(3, this.NxJ);
      }
      if (this.BsJ != null) {
        paramVarArgs.e(4, this.BsJ);
      }
      AppMethodBeat.o(82491);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dNI == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = g.a.a.b.b.a.f(1, this.dNI) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.KXD);
      paramInt = i;
      if (this.NxJ != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.NxJ);
      }
      i = paramInt;
      if (this.BsJ != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.BsJ);
      }
      AppMethodBeat.o(82491);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(82491);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fbm localfbm = (fbm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82491);
          return -1;
        case 1: 
          localfbm.dNI = locala.UbS.readString();
          AppMethodBeat.o(82491);
          return 0;
        case 2: 
          localfbm.KXD = locala.UbS.zi();
          AppMethodBeat.o(82491);
          return 0;
        case 3: 
          localfbm.NxJ = locala.UbS.readString();
          AppMethodBeat.o(82491);
          return 0;
        }
        localfbm.BsJ = locala.UbS.readString();
        AppMethodBeat.o(82491);
        return 0;
      }
      AppMethodBeat.o(82491);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbm
 * JD-Core Version:    0.7.0.1
 */