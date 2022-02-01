package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eos
  extends com.tencent.mm.cd.a
{
  public int IyZ;
  public String Uro;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133200);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.IyZ);
      if (this.Uro != null) {
        paramVarArgs.f(2, this.Uro);
      }
      AppMethodBeat.o(133200);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.IyZ) + 0;
      paramInt = i;
      if (this.Uro != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Uro);
      }
      AppMethodBeat.o(133200);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(133200);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      eos localeos = (eos)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(133200);
        return -1;
      case 1: 
        localeos.IyZ = locala.abFh.AK();
        AppMethodBeat.o(133200);
        return 0;
      }
      localeos.Uro = locala.abFh.readString();
      AppMethodBeat.o(133200);
      return 0;
    }
    AppMethodBeat.o(133200);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eos
 * JD-Core Version:    0.7.0.1
 */