package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aam
  extends com.tencent.mm.bw.a
{
  public String dNI;
  public long iAQ;
  public int idx;
  public String path;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124473);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.iAQ);
      paramVarArgs.aM(2, this.idx);
      if (this.dNI != null) {
        paramVarArgs.e(3, this.dNI);
      }
      if (this.path != null) {
        paramVarArgs.e(4, this.path);
      }
      AppMethodBeat.o(124473);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.iAQ) + 0 + g.a.a.b.b.a.bu(2, this.idx);
      paramInt = i;
      if (this.dNI != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.dNI);
      }
      i = paramInt;
      if (this.path != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.path);
      }
      AppMethodBeat.o(124473);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(124473);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      aam localaam = (aam)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124473);
        return -1;
      case 1: 
        localaam.iAQ = locala.UbS.zl();
        AppMethodBeat.o(124473);
        return 0;
      case 2: 
        localaam.idx = locala.UbS.zi();
        AppMethodBeat.o(124473);
        return 0;
      case 3: 
        localaam.dNI = locala.UbS.readString();
        AppMethodBeat.o(124473);
        return 0;
      }
      localaam.path = locala.UbS.readString();
      AppMethodBeat.o(124473);
      return 0;
    }
    AppMethodBeat.o(124473);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aam
 * JD-Core Version:    0.7.0.1
 */