package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aer
  extends com.tencent.mm.bw.a
{
  public int kem;
  public String ken;
  public String keo;
  public String kep;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117864);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.kem);
      if (this.ken != null) {
        paramVarArgs.e(2, this.ken);
      }
      if (this.keo != null) {
        paramVarArgs.e(3, this.keo);
      }
      if (this.kep != null) {
        paramVarArgs.e(4, this.kep);
      }
      AppMethodBeat.o(117864);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.kem) + 0;
      paramInt = i;
      if (this.ken != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.ken);
      }
      i = paramInt;
      if (this.keo != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.keo);
      }
      paramInt = i;
      if (this.kep != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.kep);
      }
      AppMethodBeat.o(117864);
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
      AppMethodBeat.o(117864);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      aer localaer = (aer)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117864);
        return -1;
      case 1: 
        localaer.kem = locala.UbS.zi();
        AppMethodBeat.o(117864);
        return 0;
      case 2: 
        localaer.ken = locala.UbS.readString();
        AppMethodBeat.o(117864);
        return 0;
      case 3: 
        localaer.keo = locala.UbS.readString();
        AppMethodBeat.o(117864);
        return 0;
      }
      localaer.kep = locala.UbS.readString();
      AppMethodBeat.o(117864);
      return 0;
    }
    AppMethodBeat.o(117864);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aer
 * JD-Core Version:    0.7.0.1
 */