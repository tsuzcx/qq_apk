package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cgu
  extends com.tencent.mm.bw.a
{
  public String FuQ;
  public String FuR;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153294);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.type);
      if (this.FuQ != null) {
        paramVarArgs.d(2, this.FuQ);
      }
      if (this.FuR != null) {
        paramVarArgs.d(3, this.FuR);
      }
      AppMethodBeat.o(153294);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.type) + 0;
      paramInt = i;
      if (this.FuQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FuQ);
      }
      i = paramInt;
      if (this.FuR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FuR);
      }
      AppMethodBeat.o(153294);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(153294);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cgu localcgu = (cgu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153294);
        return -1;
      case 1: 
        localcgu.type = locala.LVo.xF();
        AppMethodBeat.o(153294);
        return 0;
      case 2: 
        localcgu.FuQ = locala.LVo.readString();
        AppMethodBeat.o(153294);
        return 0;
      }
      localcgu.FuR = locala.LVo.readString();
      AppMethodBeat.o(153294);
      return 0;
    }
    AppMethodBeat.o(153294);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgu
 * JD-Core Version:    0.7.0.1
 */