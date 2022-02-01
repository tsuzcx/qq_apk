package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fby
  extends com.tencent.mm.bw.a
{
  public int NxZ;
  public String Nya;
  public String Nyb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124575);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.NxZ);
      if (this.Nya != null) {
        paramVarArgs.e(2, this.Nya);
      }
      if (this.Nyb != null) {
        paramVarArgs.e(3, this.Nyb);
      }
      AppMethodBeat.o(124575);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.NxZ) + 0;
      paramInt = i;
      if (this.Nya != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Nya);
      }
      i = paramInt;
      if (this.Nyb != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Nyb);
      }
      AppMethodBeat.o(124575);
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
      AppMethodBeat.o(124575);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fby localfby = (fby)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124575);
        return -1;
      case 1: 
        localfby.NxZ = locala.UbS.zi();
        AppMethodBeat.o(124575);
        return 0;
      case 2: 
        localfby.Nya = locala.UbS.readString();
        AppMethodBeat.o(124575);
        return 0;
      }
      localfby.Nyb = locala.UbS.readString();
      AppMethodBeat.o(124575);
      return 0;
    }
    AppMethodBeat.o(124575);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fby
 * JD-Core Version:    0.7.0.1
 */