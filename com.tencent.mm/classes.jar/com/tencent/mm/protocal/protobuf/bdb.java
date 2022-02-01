package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class bdb
  extends com.tencent.mm.cd.a
{
  public b SOn;
  public String SOo;
  public int infoType;
  public int mbp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(229923);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.infoType);
      if (this.SOn != null) {
        paramVarArgs.c(2, this.SOn);
      }
      if (this.SOo != null) {
        paramVarArgs.f(3, this.SOo);
      }
      paramVarArgs.aY(4, this.mbp);
      AppMethodBeat.o(229923);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.infoType) + 0;
      paramInt = i;
      if (this.SOn != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.SOn);
      }
      i = paramInt;
      if (this.SOo != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SOo);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.mbp);
      AppMethodBeat.o(229923);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(229923);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bdb localbdb = (bdb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(229923);
        return -1;
      case 1: 
        localbdb.infoType = locala.abFh.AK();
        AppMethodBeat.o(229923);
        return 0;
      case 2: 
        localbdb.SOn = locala.abFh.iUw();
        AppMethodBeat.o(229923);
        return 0;
      case 3: 
        localbdb.SOo = locala.abFh.readString();
        AppMethodBeat.o(229923);
        return 0;
      }
      localbdb.mbp = locala.abFh.AK();
      AppMethodBeat.o(229923);
      return 0;
    }
    AppMethodBeat.o(229923);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdb
 * JD-Core Version:    0.7.0.1
 */