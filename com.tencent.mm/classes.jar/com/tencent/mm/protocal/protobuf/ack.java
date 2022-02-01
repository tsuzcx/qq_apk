package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ack
  extends com.tencent.mm.cd.a
{
  public boolean SnY;
  public int SnZ;
  public int fOu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(187432);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.fOu);
      paramVarArgs.co(2, this.SnY);
      paramVarArgs.aY(3, this.SnZ);
      AppMethodBeat.o(187432);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.fOu);
      int i = g.a.a.b.b.a.gL(2);
      int j = g.a.a.b.b.a.bM(3, this.SnZ);
      AppMethodBeat.o(187432);
      return paramInt + 0 + (i + 1) + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(187432);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ack localack = (ack)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(187432);
        return -1;
      case 1: 
        localack.fOu = locala.abFh.AK();
        AppMethodBeat.o(187432);
        return 0;
      case 2: 
        localack.SnY = locala.abFh.AB();
        AppMethodBeat.o(187432);
        return 0;
      }
      localack.SnZ = locala.abFh.AK();
      AppMethodBeat.o(187432);
      return 0;
    }
    AppMethodBeat.o(187432);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ack
 * JD-Core Version:    0.7.0.1
 */