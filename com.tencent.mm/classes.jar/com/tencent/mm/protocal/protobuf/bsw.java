package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bsw
  extends com.tencent.mm.bv.a
{
  public int xBD;
  public String xGw;
  public String xGx;
  public int xGy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56956);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xBD);
      if (this.xGw != null) {
        paramVarArgs.e(2, this.xGw);
      }
      if (this.xGx != null) {
        paramVarArgs.e(3, this.xGx);
      }
      paramVarArgs.aO(4, this.xGy);
      AppMethodBeat.o(56956);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.xBD) + 0;
      paramInt = i;
      if (this.xGw != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xGw);
      }
      i = paramInt;
      if (this.xGx != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xGx);
      }
      paramInt = e.a.a.b.b.a.bl(4, this.xGy);
      AppMethodBeat.o(56956);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(56956);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bsw localbsw = (bsw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(56956);
        return -1;
      case 1: 
        localbsw.xBD = locala.CLY.sl();
        AppMethodBeat.o(56956);
        return 0;
      case 2: 
        localbsw.xGw = locala.CLY.readString();
        AppMethodBeat.o(56956);
        return 0;
      case 3: 
        localbsw.xGx = locala.CLY.readString();
        AppMethodBeat.o(56956);
        return 0;
      }
      localbsw.xGy = locala.CLY.sl();
      AppMethodBeat.o(56956);
      return 0;
    }
    AppMethodBeat.o(56956);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsw
 * JD-Core Version:    0.7.0.1
 */