package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class erb
  extends com.tencent.mm.cd.a
{
  public int Utn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259354);
    if (paramInt == 0)
    {
      ((g.a.a.c.a)paramVarArgs[0]).aY(1, this.Utn);
      AppMethodBeat.o(259354);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.Utn);
      AppMethodBeat.o(259354);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(259354);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      erb localerb = (erb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259354);
        return -1;
      }
      localerb.Utn = locala.abFh.AK();
      AppMethodBeat.o(259354);
      return 0;
    }
    AppMethodBeat.o(259354);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.erb
 * JD-Core Version:    0.7.0.1
 */