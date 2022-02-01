package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class ffr
  extends com.tencent.mm.cd.a
{
  public b Sth;
  public int Vh;
  public String uuid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147789);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Vh);
      if (this.uuid != null) {
        paramVarArgs.f(2, this.uuid);
      }
      if (this.Sth != null) {
        paramVarArgs.c(3, this.Sth);
      }
      AppMethodBeat.o(147789);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.Vh) + 0;
      paramInt = i;
      if (this.uuid != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.uuid);
      }
      i = paramInt;
      if (this.Sth != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.Sth);
      }
      AppMethodBeat.o(147789);
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
      AppMethodBeat.o(147789);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ffr localffr = (ffr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(147789);
        return -1;
      case 1: 
        localffr.Vh = locala.abFh.AK();
        AppMethodBeat.o(147789);
        return 0;
      case 2: 
        localffr.uuid = locala.abFh.readString();
        AppMethodBeat.o(147789);
        return 0;
      }
      localffr.Sth = locala.abFh.iUw();
      AppMethodBeat.o(147789);
      return 0;
    }
    AppMethodBeat.o(147789);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ffr
 * JD-Core Version:    0.7.0.1
 */