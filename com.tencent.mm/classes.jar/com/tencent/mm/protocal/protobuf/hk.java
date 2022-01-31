package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hk
  extends com.tencent.mm.bv.a
{
  public String wud;
  public String wue;
  public String wuf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11694);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wud != null) {
        paramVarArgs.e(1, this.wud);
      }
      if (this.wue != null) {
        paramVarArgs.e(2, this.wue);
      }
      if (this.wuf != null) {
        paramVarArgs.e(3, this.wuf);
      }
      AppMethodBeat.o(11694);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wud == null) {
        break label343;
      }
    }
    label343:
    for (int i = e.a.a.b.b.a.f(1, this.wud) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wue != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wue);
      }
      i = paramInt;
      if (this.wuf != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wuf);
      }
      AppMethodBeat.o(11694);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(11694);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        hk localhk = (hk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(11694);
          return -1;
        case 1: 
          localhk.wud = locala.CLY.readString();
          AppMethodBeat.o(11694);
          return 0;
        case 2: 
          localhk.wue = locala.CLY.readString();
          AppMethodBeat.o(11694);
          return 0;
        }
        localhk.wuf = locala.CLY.readString();
        AppMethodBeat.o(11694);
        return 0;
      }
      AppMethodBeat.o(11694);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hk
 * JD-Core Version:    0.7.0.1
 */