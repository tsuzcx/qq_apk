package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends com.tencent.mm.cd.a
{
  public String InB;
  public int type;
  public String url;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(250007);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.type);
      if (this.url != null) {
        paramVarArgs.f(2, this.url);
      }
      if (this.username != null) {
        paramVarArgs.f(3, this.username);
      }
      if (this.InB != null) {
        paramVarArgs.f(4, this.InB);
      }
      AppMethodBeat.o(250007);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.type) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.url);
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.username);
      }
      paramInt = i;
      if (this.InB != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.InB);
      }
      AppMethodBeat.o(250007);
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
      AppMethodBeat.o(250007);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      f localf = (f)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(250007);
        return -1;
      case 1: 
        localf.type = locala.abFh.AK();
        AppMethodBeat.o(250007);
        return 0;
      case 2: 
        localf.url = locala.abFh.readString();
        AppMethodBeat.o(250007);
        return 0;
      case 3: 
        localf.username = locala.abFh.readString();
        AppMethodBeat.o(250007);
        return 0;
      }
      localf.InB = locala.abFh.readString();
      AppMethodBeat.o(250007);
      return 0;
    }
    AppMethodBeat.o(250007);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.f
 * JD-Core Version:    0.7.0.1
 */