package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ckz
  extends com.tencent.mm.bw.a
{
  public String dfn;
  public int ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124543);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.ret);
      if (this.dfn != null) {
        paramVarArgs.d(2, this.dfn);
      }
      AppMethodBeat.o(124543);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.ret) + 0;
      paramInt = i;
      if (this.dfn != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dfn);
      }
      AppMethodBeat.o(124543);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(124543);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ckz localckz = (ckz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124543);
        return -1;
      case 1: 
        localckz.ret = locala.LVo.xF();
        AppMethodBeat.o(124543);
        return 0;
      }
      localckz.dfn = locala.LVo.readString();
      AppMethodBeat.o(124543);
      return 0;
    }
    AppMethodBeat.o(124543);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckz
 * JD-Core Version:    0.7.0.1
 */