package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class aqu
  extends com.tencent.mm.cd.a
{
  public b SDY;
  public int cmdId;
  public int retCode;
  public String tVH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168939);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.cmdId);
      paramVarArgs.aY(2, this.retCode);
      if (this.tVH != null) {
        paramVarArgs.f(3, this.tVH);
      }
      if (this.SDY != null) {
        paramVarArgs.c(4, this.SDY);
      }
      AppMethodBeat.o(168939);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.cmdId) + 0 + g.a.a.b.b.a.bM(2, this.retCode);
      paramInt = i;
      if (this.tVH != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tVH);
      }
      i = paramInt;
      if (this.SDY != null) {
        i = paramInt + g.a.a.b.b.a.b(4, this.SDY);
      }
      AppMethodBeat.o(168939);
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
      AppMethodBeat.o(168939);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      aqu localaqu = (aqu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(168939);
        return -1;
      case 1: 
        localaqu.cmdId = locala.abFh.AK();
        AppMethodBeat.o(168939);
        return 0;
      case 2: 
        localaqu.retCode = locala.abFh.AK();
        AppMethodBeat.o(168939);
        return 0;
      case 3: 
        localaqu.tVH = locala.abFh.readString();
        AppMethodBeat.o(168939);
        return 0;
      }
      localaqu.SDY = locala.abFh.iUw();
      AppMethodBeat.o(168939);
      return 0;
    }
    AppMethodBeat.o(168939);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqu
 * JD-Core Version:    0.7.0.1
 */