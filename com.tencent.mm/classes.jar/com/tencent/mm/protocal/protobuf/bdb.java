package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bdb
  extends com.tencent.mm.bv.a
{
  public String color;
  public String jVh;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48886);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.jVh != null) {
        paramVarArgs.e(1, this.jVh);
      }
      if (this.color != null) {
        paramVarArgs.e(2, this.color);
      }
      if (this.url != null) {
        paramVarArgs.e(4, this.url);
      }
      AppMethodBeat.o(48886);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jVh == null) {
        break label338;
      }
    }
    label338:
    for (int i = e.a.a.b.b.a.f(1, this.jVh) + 0;; i = 0)
    {
      paramInt = i;
      if (this.color != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.color);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.url);
      }
      AppMethodBeat.o(48886);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48886);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bdb localbdb = (bdb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 3: 
        default: 
          AppMethodBeat.o(48886);
          return -1;
        case 1: 
          localbdb.jVh = locala.CLY.readString();
          AppMethodBeat.o(48886);
          return 0;
        case 2: 
          localbdb.color = locala.CLY.readString();
          AppMethodBeat.o(48886);
          return 0;
        }
        localbdb.url = locala.CLY.readString();
        AppMethodBeat.o(48886);
        return 0;
      }
      AppMethodBeat.o(48886);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdb
 * JD-Core Version:    0.7.0.1
 */