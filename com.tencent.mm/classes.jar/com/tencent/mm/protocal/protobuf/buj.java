package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class buj
  extends com.tencent.mm.bw.a
{
  public long id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209721);
    if (paramInt == 0)
    {
      ((g.a.a.c.a)paramVarArgs[0]).bb(1, this.id);
      AppMethodBeat.o(209721);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.r(1, this.id);
      AppMethodBeat.o(209721);
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
      AppMethodBeat.o(209721);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      buj localbuj = (buj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209721);
        return -1;
      }
      localbuj.id = locala.UbS.zl();
      AppMethodBeat.o(209721);
      return 0;
    }
    AppMethodBeat.o(209721);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buj
 * JD-Core Version:    0.7.0.1
 */