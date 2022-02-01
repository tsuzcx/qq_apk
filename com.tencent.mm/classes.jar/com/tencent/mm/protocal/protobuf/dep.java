package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dep
  extends com.tencent.mm.cd.a
{
  public int RYY;
  public int SmH;
  public int TMm;
  public String TMn;
  public String TMp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43114);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.RYY);
      if (this.TMp != null) {
        paramVarArgs.f(3, this.TMp);
      }
      paramVarArgs.aY(4, this.TMm);
      paramVarArgs.aY(5, this.SmH);
      if (this.TMn != null) {
        paramVarArgs.f(6, this.TMn);
      }
      AppMethodBeat.o(43114);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.RYY) + 0;
      paramInt = i;
      if (this.TMp != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.TMp);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.TMm) + g.a.a.b.b.a.bM(5, this.SmH);
      paramInt = i;
      if (this.TMn != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.TMn);
      }
      AppMethodBeat.o(43114);
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
      AppMethodBeat.o(43114);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dep localdep = (dep)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 2: 
      default: 
        AppMethodBeat.o(43114);
        return -1;
      case 1: 
        localdep.RYY = locala.abFh.AK();
        AppMethodBeat.o(43114);
        return 0;
      case 3: 
        localdep.TMp = locala.abFh.readString();
        AppMethodBeat.o(43114);
        return 0;
      case 4: 
        localdep.TMm = locala.abFh.AK();
        AppMethodBeat.o(43114);
        return 0;
      case 5: 
        localdep.SmH = locala.abFh.AK();
        AppMethodBeat.o(43114);
        return 0;
      }
      localdep.TMn = locala.abFh.readString();
      AppMethodBeat.o(43114);
      return 0;
    }
    AppMethodBeat.o(43114);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dep
 * JD-Core Version:    0.7.0.1
 */