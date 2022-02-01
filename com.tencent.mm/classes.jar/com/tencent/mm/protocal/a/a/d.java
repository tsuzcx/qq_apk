package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends com.tencent.mm.cd.a
{
  public int Jnj;
  public int RCo;
  public com.tencent.mm.cd.b RCx;
  public int RCy;
  public int count;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143943);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RCx == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: value");
        AppMethodBeat.o(143943);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.RCo);
      if (this.RCx != null) {
        paramVarArgs.c(2, this.RCx);
      }
      paramVarArgs.aY(3, this.RCy);
      paramVarArgs.aY(4, this.Jnj);
      paramVarArgs.aY(5, this.count);
      AppMethodBeat.o(143943);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.RCo) + 0;
      paramInt = i;
      if (this.RCx != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.RCx);
      }
      i = g.a.a.b.b.a.bM(3, this.RCy);
      int j = g.a.a.b.b.a.bM(4, this.Jnj);
      int k = g.a.a.b.b.a.bM(5, this.count);
      AppMethodBeat.o(143943);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.RCx == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: value");
        AppMethodBeat.o(143943);
        throw paramVarArgs;
      }
      AppMethodBeat.o(143943);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143943);
        return -1;
      case 1: 
        locald.RCo = locala.abFh.AK();
        AppMethodBeat.o(143943);
        return 0;
      case 2: 
        locald.RCx = locala.abFh.iUw();
        AppMethodBeat.o(143943);
        return 0;
      case 3: 
        locald.RCy = locala.abFh.AK();
        AppMethodBeat.o(143943);
        return 0;
      case 4: 
        locald.Jnj = locala.abFh.AK();
        AppMethodBeat.o(143943);
        return 0;
      }
      locald.count = locala.abFh.AK();
      AppMethodBeat.o(143943);
      return 0;
    }
    AppMethodBeat.o(143943);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.d
 * JD-Core Version:    0.7.0.1
 */