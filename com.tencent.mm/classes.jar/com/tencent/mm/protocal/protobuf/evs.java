package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class evs
  extends com.tencent.mm.bw.a
{
  public String KDQ;
  public boolean Ntt;
  public String Ntu;
  public int Ntv;
  public int Ntw;
  public int Ntx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147805);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.cc(1, this.Ntt);
      if (this.KDQ != null) {
        paramVarArgs.e(2, this.KDQ);
      }
      if (this.Ntu != null) {
        paramVarArgs.e(3, this.Ntu);
      }
      paramVarArgs.aM(4, this.Ntv);
      paramVarArgs.aM(5, this.Ntw);
      paramVarArgs.aM(6, this.Ntx);
      AppMethodBeat.o(147805);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.fS(1) + 1 + 0;
      paramInt = i;
      if (this.KDQ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KDQ);
      }
      i = paramInt;
      if (this.Ntu != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Ntu);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.Ntv);
      int j = g.a.a.b.b.a.bu(5, this.Ntw);
      int k = g.a.a.b.b.a.bu(6, this.Ntx);
      AppMethodBeat.o(147805);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(147805);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      evs localevs = (evs)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(147805);
        return -1;
      case 1: 
        localevs.Ntt = locala.UbS.yZ();
        AppMethodBeat.o(147805);
        return 0;
      case 2: 
        localevs.KDQ = locala.UbS.readString();
        AppMethodBeat.o(147805);
        return 0;
      case 3: 
        localevs.Ntu = locala.UbS.readString();
        AppMethodBeat.o(147805);
        return 0;
      case 4: 
        localevs.Ntv = locala.UbS.zi();
        AppMethodBeat.o(147805);
        return 0;
      case 5: 
        localevs.Ntw = locala.UbS.zi();
        AppMethodBeat.o(147805);
        return 0;
      }
      localevs.Ntx = locala.UbS.zi();
      AppMethodBeat.o(147805);
      return 0;
    }
    AppMethodBeat.o(147805);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.evs
 * JD-Core Version:    0.7.0.1
 */