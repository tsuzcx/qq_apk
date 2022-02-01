package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class fpe
  extends com.tencent.mm.cd.a
{
  public b SrE;
  public String appid;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50124);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.type);
      if (this.SrE != null) {
        paramVarArgs.c(2, this.SrE);
      }
      if (this.appid != null) {
        paramVarArgs.f(3, this.appid);
      }
      AppMethodBeat.o(50124);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.type) + 0;
      paramInt = i;
      if (this.SrE != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.SrE);
      }
      i = paramInt;
      if (this.appid != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.appid);
      }
      AppMethodBeat.o(50124);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(50124);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fpe localfpe = (fpe)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50124);
        return -1;
      case 1: 
        localfpe.type = locala.abFh.AK();
        AppMethodBeat.o(50124);
        return 0;
      case 2: 
        localfpe.SrE = locala.abFh.iUw();
        AppMethodBeat.o(50124);
        return 0;
      }
      localfpe.appid = locala.abFh.readString();
      AppMethodBeat.o(50124);
      return 0;
    }
    AppMethodBeat.o(50124);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fpe
 * JD-Core Version:    0.7.0.1
 */