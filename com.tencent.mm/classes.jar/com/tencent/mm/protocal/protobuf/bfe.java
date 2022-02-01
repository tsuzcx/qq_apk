package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bfe
  extends com.tencent.mm.cd.a
{
  public int SFD;
  public String fCl;
  public String sessionId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203898);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SFD);
      if (this.fCl != null) {
        paramVarArgs.f(2, this.fCl);
      }
      if (this.sessionId != null) {
        paramVarArgs.f(3, this.sessionId);
      }
      AppMethodBeat.o(203898);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.SFD) + 0;
      paramInt = i;
      if (this.fCl != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.fCl);
      }
      i = paramInt;
      if (this.sessionId != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.sessionId);
      }
      AppMethodBeat.o(203898);
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
      AppMethodBeat.o(203898);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bfe localbfe = (bfe)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(203898);
        return -1;
      case 1: 
        localbfe.SFD = locala.abFh.AK();
        AppMethodBeat.o(203898);
        return 0;
      case 2: 
        localbfe.fCl = locala.abFh.readString();
        AppMethodBeat.o(203898);
        return 0;
      }
      localbfe.sessionId = locala.abFh.readString();
      AppMethodBeat.o(203898);
      return 0;
    }
    AppMethodBeat.o(203898);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfe
 * JD-Core Version:    0.7.0.1
 */