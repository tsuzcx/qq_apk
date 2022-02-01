package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eff
  extends com.tencent.mm.bw.a
{
  public String Mdz;
  public int MmV;
  public String NfB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152708);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.MmV);
      if (this.Mdz != null) {
        paramVarArgs.e(2, this.Mdz);
      }
      if (this.NfB != null) {
        paramVarArgs.e(3, this.NfB);
      }
      AppMethodBeat.o(152708);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.MmV) + 0;
      paramInt = i;
      if (this.Mdz != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Mdz);
      }
      i = paramInt;
      if (this.NfB != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.NfB);
      }
      AppMethodBeat.o(152708);
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
      AppMethodBeat.o(152708);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      eff localeff = (eff)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152708);
        return -1;
      case 1: 
        localeff.MmV = locala.UbS.zi();
        AppMethodBeat.o(152708);
        return 0;
      case 2: 
        localeff.Mdz = locala.UbS.readString();
        AppMethodBeat.o(152708);
        return 0;
      }
      localeff.NfB = locala.UbS.readString();
      AppMethodBeat.o(152708);
      return 0;
    }
    AppMethodBeat.o(152708);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eff
 * JD-Core Version:    0.7.0.1
 */