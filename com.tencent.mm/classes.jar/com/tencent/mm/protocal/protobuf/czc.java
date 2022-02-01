package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class czc
  extends com.tencent.mm.cd.a
{
  public String SjI;
  public String SjJ;
  public int TGZ;
  public int THa;
  public b THb;
  public String THc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32353);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.TGZ);
      paramVarArgs.aY(2, this.THa);
      if (this.THb != null) {
        paramVarArgs.c(3, this.THb);
      }
      if (this.THc != null) {
        paramVarArgs.f(4, this.THc);
      }
      if (this.SjI != null) {
        paramVarArgs.f(5, this.SjI);
      }
      if (this.SjJ != null) {
        paramVarArgs.f(6, this.SjJ);
      }
      AppMethodBeat.o(32353);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.TGZ) + 0 + g.a.a.b.b.a.bM(2, this.THa);
      paramInt = i;
      if (this.THb != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.THb);
      }
      i = paramInt;
      if (this.THc != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.THc);
      }
      paramInt = i;
      if (this.SjI != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.SjI);
      }
      i = paramInt;
      if (this.SjJ != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.SjJ);
      }
      AppMethodBeat.o(32353);
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
      AppMethodBeat.o(32353);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      czc localczc = (czc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32353);
        return -1;
      case 1: 
        localczc.TGZ = locala.abFh.AK();
        AppMethodBeat.o(32353);
        return 0;
      case 2: 
        localczc.THa = locala.abFh.AK();
        AppMethodBeat.o(32353);
        return 0;
      case 3: 
        localczc.THb = locala.abFh.iUw();
        AppMethodBeat.o(32353);
        return 0;
      case 4: 
        localczc.THc = locala.abFh.readString();
        AppMethodBeat.o(32353);
        return 0;
      case 5: 
        localczc.SjI = locala.abFh.readString();
        AppMethodBeat.o(32353);
        return 0;
      }
      localczc.SjJ = locala.abFh.readString();
      AppMethodBeat.o(32353);
      return 0;
    }
    AppMethodBeat.o(32353);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czc
 * JD-Core Version:    0.7.0.1
 */