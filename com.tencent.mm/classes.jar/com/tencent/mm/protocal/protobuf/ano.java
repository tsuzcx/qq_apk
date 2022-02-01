package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ano
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> Lyn;
  public LinkedList<String> Lyo;
  
  public ano()
  {
    AppMethodBeat.i(127490);
    this.Lyn = new LinkedList();
    this.Lyo = new LinkedList();
    AppMethodBeat.o(127490);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127491);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.Lyn);
      paramVarArgs.e(2, 1, this.Lyo);
      AppMethodBeat.o(127491);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 1, this.Lyn);
      int i = g.a.a.a.c(2, 1, this.Lyo);
      AppMethodBeat.o(127491);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Lyn.clear();
      this.Lyo.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(127491);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ano localano = (ano)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127491);
        return -1;
      case 1: 
        localano.Lyn.add(locala.UbS.readString());
        AppMethodBeat.o(127491);
        return 0;
      }
      localano.Lyo.add(locala.UbS.readString());
      AppMethodBeat.o(127491);
      return 0;
    }
    AppMethodBeat.o(127491);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ano
 * JD-Core Version:    0.7.0.1
 */