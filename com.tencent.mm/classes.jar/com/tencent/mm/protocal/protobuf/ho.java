package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ho
  extends com.tencent.mm.bv.a
{
  public String imei;
  public String wul;
  public String wum;
  public String wun;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(2536);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.imei != null) {
        paramVarArgs.e(1, this.imei);
      }
      if (this.wul != null) {
        paramVarArgs.e(2, this.wul);
      }
      if (this.wum != null) {
        paramVarArgs.e(3, this.wum);
      }
      if (this.wun != null) {
        paramVarArgs.e(4, this.wun);
      }
      AppMethodBeat.o(2536);
      return 0;
    }
    if (paramInt == 1) {
      if (this.imei == null) {
        break label404;
      }
    }
    label404:
    for (int i = e.a.a.b.b.a.f(1, this.imei) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wul != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wul);
      }
      i = paramInt;
      if (this.wum != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wum);
      }
      paramInt = i;
      if (this.wun != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wun);
      }
      AppMethodBeat.o(2536);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(2536);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ho localho = (ho)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(2536);
          return -1;
        case 1: 
          localho.imei = locala.CLY.readString();
          AppMethodBeat.o(2536);
          return 0;
        case 2: 
          localho.wul = locala.CLY.readString();
          AppMethodBeat.o(2536);
          return 0;
        case 3: 
          localho.wum = locala.CLY.readString();
          AppMethodBeat.o(2536);
          return 0;
        }
        localho.wun = locala.CLY.readString();
        AppMethodBeat.o(2536);
        return 0;
      }
      AppMethodBeat.o(2536);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ho
 * JD-Core Version:    0.7.0.1
 */