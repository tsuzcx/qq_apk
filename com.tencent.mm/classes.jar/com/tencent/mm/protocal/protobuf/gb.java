package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gb
  extends com.tencent.mm.bv.a
{
  public String poq;
  public String wsj;
  public String wsk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96199);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wsj != null) {
        paramVarArgs.e(1, this.wsj);
      }
      if (this.wsk != null) {
        paramVarArgs.e(2, this.wsk);
      }
      if (this.poq != null) {
        paramVarArgs.e(3, this.poq);
      }
      AppMethodBeat.o(96199);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wsj == null) {
        break label334;
      }
    }
    label334:
    for (int i = e.a.a.b.b.a.f(1, this.wsj) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wsk != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wsk);
      }
      i = paramInt;
      if (this.poq != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.poq);
      }
      AppMethodBeat.o(96199);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(96199);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        gb localgb = (gb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(96199);
          return -1;
        case 1: 
          localgb.wsj = locala.CLY.readString();
          AppMethodBeat.o(96199);
          return 0;
        case 2: 
          localgb.wsk = locala.CLY.readString();
          AppMethodBeat.o(96199);
          return 0;
        }
        localgb.poq = locala.CLY.readString();
        AppMethodBeat.o(96199);
        return 0;
      }
      AppMethodBeat.o(96199);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gb
 * JD-Core Version:    0.7.0.1
 */