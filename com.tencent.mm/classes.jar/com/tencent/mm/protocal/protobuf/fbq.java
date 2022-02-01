package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fbq
  extends com.tencent.mm.bw.a
{
  public int KSa;
  public String NxM;
  public String NxN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123682);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.KSa);
      if (this.NxM != null) {
        paramVarArgs.e(2, this.NxM);
      }
      if (this.NxN != null) {
        paramVarArgs.e(3, this.NxN);
      }
      AppMethodBeat.o(123682);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.KSa) + 0;
      paramInt = i;
      if (this.NxM != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.NxM);
      }
      i = paramInt;
      if (this.NxN != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.NxN);
      }
      AppMethodBeat.o(123682);
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
      AppMethodBeat.o(123682);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fbq localfbq = (fbq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123682);
        return -1;
      case 1: 
        localfbq.KSa = locala.UbS.zi();
        AppMethodBeat.o(123682);
        return 0;
      case 2: 
        localfbq.NxM = locala.UbS.readString();
        AppMethodBeat.o(123682);
        return 0;
      }
      localfbq.NxN = locala.UbS.readString();
      AppMethodBeat.o(123682);
      return 0;
    }
    AppMethodBeat.o(123682);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbq
 * JD-Core Version:    0.7.0.1
 */