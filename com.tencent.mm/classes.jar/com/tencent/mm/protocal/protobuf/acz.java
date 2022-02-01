package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class acz
  extends com.tencent.mm.bw.a
{
  public int Lnt;
  public String openid;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90961);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Lnt);
      if (this.openid != null) {
        paramVarArgs.e(2, this.openid);
      }
      paramVarArgs.aM(3, this.status);
      AppMethodBeat.o(90961);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.Lnt) + 0;
      paramInt = i;
      if (this.openid != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.openid);
      }
      i = g.a.a.b.b.a.bu(3, this.status);
      AppMethodBeat.o(90961);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(90961);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      acz localacz = (acz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(90961);
        return -1;
      case 1: 
        localacz.Lnt = locala.UbS.zi();
        AppMethodBeat.o(90961);
        return 0;
      case 2: 
        localacz.openid = locala.UbS.readString();
        AppMethodBeat.o(90961);
        return 0;
      }
      localacz.status = locala.UbS.zi();
      AppMethodBeat.o(90961);
      return 0;
    }
    AppMethodBeat.o(90961);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acz
 * JD-Core Version:    0.7.0.1
 */