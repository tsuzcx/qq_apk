package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class erf
  extends com.tencent.mm.bw.a
{
  public int bottom;
  public int left;
  public int right;
  public int top;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169093);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.left);
      paramVarArgs.aM(2, this.top);
      paramVarArgs.aM(3, this.right);
      paramVarArgs.aM(4, this.bottom);
      AppMethodBeat.o(169093);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.left);
      int i = g.a.a.b.b.a.bu(2, this.top);
      int j = g.a.a.b.b.a.bu(3, this.right);
      int k = g.a.a.b.b.a.bu(4, this.bottom);
      AppMethodBeat.o(169093);
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
      AppMethodBeat.o(169093);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      erf localerf = (erf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169093);
        return -1;
      case 1: 
        localerf.left = locala.UbS.zi();
        AppMethodBeat.o(169093);
        return 0;
      case 2: 
        localerf.top = locala.UbS.zi();
        AppMethodBeat.o(169093);
        return 0;
      case 3: 
        localerf.right = locala.UbS.zi();
        AppMethodBeat.o(169093);
        return 0;
      }
      localerf.bottom = locala.UbS.zi();
      AppMethodBeat.o(169093);
      return 0;
    }
    AppMethodBeat.o(169093);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.erf
 * JD-Core Version:    0.7.0.1
 */