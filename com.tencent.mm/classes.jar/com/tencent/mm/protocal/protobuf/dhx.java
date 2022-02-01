package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class dhx
  extends com.tencent.mm.bw.a
{
  public int him;
  public String sTh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134251);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.sTh == null)
      {
        paramVarArgs = new b("Not all required fields were included: jsonData");
        AppMethodBeat.o(134251);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.him);
      if (this.sTh != null) {
        paramVarArgs.e(2, this.sTh);
      }
      AppMethodBeat.o(134251);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.him) + 0;
      paramInt = i;
      if (this.sTh != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.sTh);
      }
      AppMethodBeat.o(134251);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.sTh == null)
      {
        paramVarArgs = new b("Not all required fields were included: jsonData");
        AppMethodBeat.o(134251);
        throw paramVarArgs;
      }
      AppMethodBeat.o(134251);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dhx localdhx = (dhx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(134251);
        return -1;
      case 1: 
        localdhx.him = locala.UbS.zi();
        AppMethodBeat.o(134251);
        return 0;
      }
      localdhx.sTh = locala.UbS.readString();
      AppMethodBeat.o(134251);
      return 0;
    }
    AppMethodBeat.o(134251);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhx
 * JD-Core Version:    0.7.0.1
 */