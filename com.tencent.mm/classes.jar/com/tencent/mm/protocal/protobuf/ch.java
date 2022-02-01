package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ch
  extends com.tencent.mm.cd.a
{
  public int RHV;
  public String RHW;
  public String app_id;
  public String path;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207765);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.RHV);
      if (this.app_id != null) {
        paramVarArgs.f(2, this.app_id);
      }
      if (this.path != null) {
        paramVarArgs.f(3, this.path);
      }
      if (this.RHW != null) {
        paramVarArgs.f(4, this.RHW);
      }
      AppMethodBeat.o(207765);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.RHV) + 0;
      paramInt = i;
      if (this.app_id != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.app_id);
      }
      i = paramInt;
      if (this.path != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.path);
      }
      paramInt = i;
      if (this.RHW != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RHW);
      }
      AppMethodBeat.o(207765);
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
      AppMethodBeat.o(207765);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ch localch = (ch)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(207765);
        return -1;
      case 1: 
        localch.RHV = locala.abFh.AK();
        AppMethodBeat.o(207765);
        return 0;
      case 2: 
        localch.app_id = locala.abFh.readString();
        AppMethodBeat.o(207765);
        return 0;
      case 3: 
        localch.path = locala.abFh.readString();
        AppMethodBeat.o(207765);
        return 0;
      }
      localch.RHW = locala.abFh.readString();
      AppMethodBeat.o(207765);
      return 0;
    }
    AppMethodBeat.o(207765);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ch
 * JD-Core Version:    0.7.0.1
 */