package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;

public final class mf
  extends com.tencent.mm.bv.a
{
  public int port;
  public int type;
  public b wAG;
  public b wAH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(58894);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.type);
      paramVarArgs.aO(2, this.port);
      if (this.wAG != null) {
        paramVarArgs.c(3, this.wAG);
      }
      if (this.wAH != null) {
        paramVarArgs.c(4, this.wAH);
      }
      AppMethodBeat.o(58894);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.type) + 0 + e.a.a.b.b.a.bl(2, this.port);
      paramInt = i;
      if (this.wAG != null) {
        paramInt = i + e.a.a.b.b.a.b(3, this.wAG);
      }
      i = paramInt;
      if (this.wAH != null) {
        i = paramInt + e.a.a.b.b.a.b(4, this.wAH);
      }
      AppMethodBeat.o(58894);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(58894);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      mf localmf = (mf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(58894);
        return -1;
      case 1: 
        localmf.type = locala.CLY.sl();
        AppMethodBeat.o(58894);
        return 0;
      case 2: 
        localmf.port = locala.CLY.sl();
        AppMethodBeat.o(58894);
        return 0;
      case 3: 
        localmf.wAG = locala.CLY.eqS();
        AppMethodBeat.o(58894);
        return 0;
      }
      localmf.wAH = locala.CLY.eqS();
      AppMethodBeat.o(58894);
      return 0;
    }
    AppMethodBeat.o(58894);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mf
 * JD-Core Version:    0.7.0.1
 */