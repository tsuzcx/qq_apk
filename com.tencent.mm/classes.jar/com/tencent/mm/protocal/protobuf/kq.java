package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class kq
  extends com.tencent.mm.bv.a
{
  public String wyb;
  public String wyh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11701);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wyh != null) {
        paramVarArgs.e(2, this.wyh);
      }
      if (this.wyb != null) {
        paramVarArgs.e(3, this.wyb);
      }
      AppMethodBeat.o(11701);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wyh == null) {
        break label282;
      }
    }
    label282:
    for (paramInt = e.a.a.b.b.a.f(2, this.wyh) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wyb != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wyb);
      }
      AppMethodBeat.o(11701);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(11701);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        kq localkq = (kq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(11701);
          return -1;
        case 2: 
          localkq.wyh = locala.CLY.readString();
          AppMethodBeat.o(11701);
          return 0;
        }
        localkq.wyb = locala.CLY.readString();
        AppMethodBeat.o(11701);
        return 0;
      }
      AppMethodBeat.o(11701);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.kq
 * JD-Core Version:    0.7.0.1
 */