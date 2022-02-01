package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cbh
  extends com.tencent.mm.bw.a
{
  public int DRh;
  public String thr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125753);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DRh);
      if (this.thr != null) {
        paramVarArgs.d(2, this.thr);
      }
      AppMethodBeat.o(125753);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.DRh) + 0;
      paramInt = i;
      if (this.thr != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.thr);
      }
      AppMethodBeat.o(125753);
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
      AppMethodBeat.o(125753);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cbh localcbh = (cbh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125753);
        return -1;
      case 1: 
        localcbh.DRh = locala.LVo.xF();
        AppMethodBeat.o(125753);
        return 0;
      }
      localcbh.thr = locala.LVo.readString();
      AppMethodBeat.o(125753);
      return 0;
    }
    AppMethodBeat.o(125753);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbh
 * JD-Core Version:    0.7.0.1
 */