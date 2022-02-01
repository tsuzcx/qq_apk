package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aki
  extends com.tencent.mm.bw.a
{
  public int Ltq;
  public int Ltr;
  public int Lts;
  public int count;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(220699);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Ltq);
      paramVarArgs.aM(2, this.Ltr);
      paramVarArgs.aM(3, this.Lts);
      paramVarArgs.aM(4, this.count);
      AppMethodBeat.o(220699);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.Ltq);
      int i = g.a.a.b.b.a.bu(2, this.Ltr);
      int j = g.a.a.b.b.a.bu(3, this.Lts);
      int k = g.a.a.b.b.a.bu(4, this.count);
      AppMethodBeat.o(220699);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(220699);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      aki localaki = (aki)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(220699);
        return -1;
      case 1: 
        localaki.Ltq = locala.UbS.zi();
        AppMethodBeat.o(220699);
        return 0;
      case 2: 
        localaki.Ltr = locala.UbS.zi();
        AppMethodBeat.o(220699);
        return 0;
      case 3: 
        localaki.Lts = locala.UbS.zi();
        AppMethodBeat.o(220699);
        return 0;
      }
      localaki.count = locala.UbS.zi();
      AppMethodBeat.o(220699);
      return 0;
    }
    AppMethodBeat.o(220699);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aki
 * JD-Core Version:    0.7.0.1
 */