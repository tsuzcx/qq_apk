package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class dgs
  extends com.tencent.mm.cd.a
{
  public String TNx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123631);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TNx != null) {
        paramVarArgs.f(1, this.TNx);
      }
      AppMethodBeat.o(123631);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TNx == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = g.a.a.b.b.a.g(1, this.TNx) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(123631);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(123631);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dgs localdgs = (dgs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123631);
          return -1;
        }
        localdgs.TNx = locala.abFh.readString();
        AppMethodBeat.o(123631);
        return 0;
      }
      AppMethodBeat.o(123631);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgs
 * JD-Core Version:    0.7.0.1
 */