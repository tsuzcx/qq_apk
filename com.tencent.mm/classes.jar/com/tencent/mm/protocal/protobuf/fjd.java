package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class fjd
  extends com.tencent.mm.cd.a
{
  public int CRP;
  public String fwr;
  public String lpy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32523);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fwr == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(32523);
        throw paramVarArgs;
      }
      if (this.lpy == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(32523);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.CRP);
      if (this.fwr != null) {
        paramVarArgs.f(2, this.fwr);
      }
      if (this.lpy != null) {
        paramVarArgs.f(3, this.lpy);
      }
      AppMethodBeat.o(32523);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.CRP) + 0;
      paramInt = i;
      if (this.fwr != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.fwr);
      }
      i = paramInt;
      if (this.lpy != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.lpy);
      }
      AppMethodBeat.o(32523);
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
      if (this.fwr == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(32523);
        throw paramVarArgs;
      }
      if (this.lpy == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(32523);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32523);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fjd localfjd = (fjd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32523);
        return -1;
      case 1: 
        localfjd.CRP = locala.abFh.AK();
        AppMethodBeat.o(32523);
        return 0;
      case 2: 
        localfjd.fwr = locala.abFh.readString();
        AppMethodBeat.o(32523);
        return 0;
      }
      localfjd.lpy = locala.abFh.readString();
      AppMethodBeat.o(32523);
      return 0;
    }
    AppMethodBeat.o(32523);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fjd
 * JD-Core Version:    0.7.0.1
 */