package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bqt
  extends com.tencent.mm.bv.a
{
  public String info;
  public int wPd;
  public int wPe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94551);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wPd);
      paramVarArgs.aO(2, this.wPe);
      if (this.info != null) {
        paramVarArgs.e(3, this.info);
      }
      AppMethodBeat.o(94551);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.wPd) + 0 + e.a.a.b.b.a.bl(2, this.wPe);
      paramInt = i;
      if (this.info != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.info);
      }
      AppMethodBeat.o(94551);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(94551);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bqt localbqt = (bqt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(94551);
        return -1;
      case 1: 
        localbqt.wPd = locala.CLY.sl();
        AppMethodBeat.o(94551);
        return 0;
      case 2: 
        localbqt.wPe = locala.CLY.sl();
        AppMethodBeat.o(94551);
        return 0;
      }
      localbqt.info = locala.CLY.readString();
      AppMethodBeat.o(94551);
      return 0;
    }
    AppMethodBeat.o(94551);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqt
 * JD-Core Version:    0.7.0.1
 */