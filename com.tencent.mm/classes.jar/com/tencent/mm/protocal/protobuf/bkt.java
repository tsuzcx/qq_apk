package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bkt
  extends com.tencent.mm.bv.a
{
  public String qFq;
  public String url;
  public long xzu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48917);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.qFq != null) {
        paramVarArgs.e(1, this.qFq);
      }
      paramVarArgs.am(2, this.xzu);
      if (this.url != null) {
        paramVarArgs.e(3, this.url);
      }
      AppMethodBeat.o(48917);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qFq == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = e.a.a.b.b.a.f(1, this.qFq) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.p(2, this.xzu);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.url);
      }
      AppMethodBeat.o(48917);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48917);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bkt localbkt = (bkt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(48917);
          return -1;
        case 1: 
          localbkt.qFq = locala.CLY.readString();
          AppMethodBeat.o(48917);
          return 0;
        case 2: 
          localbkt.xzu = locala.CLY.sm();
          AppMethodBeat.o(48917);
          return 0;
        }
        localbkt.url = locala.CLY.readString();
        AppMethodBeat.o(48917);
        return 0;
      }
      AppMethodBeat.o(48917);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkt
 * JD-Core Version:    0.7.0.1
 */