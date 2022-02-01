package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class axk
  extends com.tencent.mm.cd.a
{
  public int SJK;
  public int SJX;
  public int SJZ;
  public String SnB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230647);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SJK);
      paramVarArgs.aY(102, this.SJX);
      if (this.SnB != null) {
        paramVarArgs.f(103, this.SnB);
      }
      paramVarArgs.aY(104, this.SJZ);
      AppMethodBeat.o(230647);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.SJK) + 0 + g.a.a.b.b.a.bM(102, this.SJX);
      paramInt = i;
      if (this.SnB != null) {
        paramInt = i + g.a.a.b.b.a.g(103, this.SnB);
      }
      i = g.a.a.b.b.a.bM(104, this.SJZ);
      AppMethodBeat.o(230647);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(230647);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      axk localaxk = (axk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(230647);
        return -1;
      case 1: 
        localaxk.SJK = locala.abFh.AK();
        AppMethodBeat.o(230647);
        return 0;
      case 102: 
        localaxk.SJX = locala.abFh.AK();
        AppMethodBeat.o(230647);
        return 0;
      case 103: 
        localaxk.SnB = locala.abFh.readString();
        AppMethodBeat.o(230647);
        return 0;
      }
      localaxk.SJZ = locala.abFh.AK();
      AppMethodBeat.o(230647);
      return 0;
    }
    AppMethodBeat.o(230647);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axk
 * JD-Core Version:    0.7.0.1
 */