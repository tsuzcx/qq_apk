package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dzr
  extends com.tencent.mm.bw.a
{
  public int MZn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117929);
    if (paramInt == 0)
    {
      ((g.a.a.c.a)paramVarArgs[0]).aM(1, this.MZn);
      AppMethodBeat.o(117929);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.MZn);
      AppMethodBeat.o(117929);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(117929);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dzr localdzr = (dzr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117929);
        return -1;
      }
      localdzr.MZn = locala.UbS.zi();
      AppMethodBeat.o(117929);
      return 0;
    }
    AppMethodBeat.o(117929);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzr
 * JD-Core Version:    0.7.0.1
 */