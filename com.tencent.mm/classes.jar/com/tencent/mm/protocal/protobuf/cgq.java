package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cgq
  extends com.tencent.mm.bw.a
{
  public int FuL;
  public int FuM;
  public String FuN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125754);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FuL);
      paramVarArgs.aR(2, this.FuM);
      if (this.FuN != null) {
        paramVarArgs.d(3, this.FuN);
      }
      AppMethodBeat.o(125754);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.FuL) + 0 + f.a.a.b.b.a.bx(2, this.FuM);
      paramInt = i;
      if (this.FuN != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FuN);
      }
      AppMethodBeat.o(125754);
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
      AppMethodBeat.o(125754);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cgq localcgq = (cgq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125754);
        return -1;
      case 1: 
        localcgq.FuL = locala.LVo.xF();
        AppMethodBeat.o(125754);
        return 0;
      case 2: 
        localcgq.FuM = locala.LVo.xF();
        AppMethodBeat.o(125754);
        return 0;
      }
      localcgq.FuN = locala.LVo.readString();
      AppMethodBeat.o(125754);
      return 0;
    }
    AppMethodBeat.o(125754);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgq
 * JD-Core Version:    0.7.0.1
 */