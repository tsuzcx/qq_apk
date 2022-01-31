package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bqx
  extends com.tencent.mm.bv.a
{
  public String csW;
  public int ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11798);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.ret);
      if (this.csW != null) {
        paramVarArgs.e(2, this.csW);
      }
      AppMethodBeat.o(11798);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.ret) + 0;
      paramInt = i;
      if (this.csW != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.csW);
      }
      AppMethodBeat.o(11798);
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
      AppMethodBeat.o(11798);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bqx localbqx = (bqx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(11798);
        return -1;
      case 1: 
        localbqx.ret = locala.CLY.sl();
        AppMethodBeat.o(11798);
        return 0;
      }
      localbqx.csW = locala.CLY.readString();
      AppMethodBeat.o(11798);
      return 0;
    }
    AppMethodBeat.o(11798);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqx
 * JD-Core Version:    0.7.0.1
 */