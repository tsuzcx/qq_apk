package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cfq
  extends com.tencent.mm.bw.a
{
  public int Hsz;
  public String urL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152639);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Hsz);
      if (this.urL != null) {
        paramVarArgs.d(2, this.urL);
      }
      AppMethodBeat.o(152639);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Hsz) + 0;
      paramInt = i;
      if (this.urL != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.urL);
      }
      AppMethodBeat.o(152639);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(152639);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cfq localcfq = (cfq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152639);
        return -1;
      case 1: 
        localcfq.Hsz = locala.OmT.zc();
        AppMethodBeat.o(152639);
        return 0;
      }
      localcfq.urL = locala.OmT.readString();
      AppMethodBeat.o(152639);
      return 0;
    }
    AppMethodBeat.o(152639);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfq
 * JD-Core Version:    0.7.0.1
 */