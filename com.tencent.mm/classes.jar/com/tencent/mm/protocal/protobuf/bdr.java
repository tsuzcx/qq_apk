package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bdr
  extends com.tencent.mm.bx.a
{
  public String ZOt;
  public int ZOu;
  public long ZOv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258955);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZOt != null) {
        paramVarArgs.g(1, this.ZOt);
      }
      paramVarArgs.bS(101, this.ZOu);
      paramVarArgs.bv(102, this.ZOv);
      AppMethodBeat.o(258955);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZOt == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZOt) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(101, this.ZOu);
      int j = i.a.a.b.b.a.q(102, this.ZOv);
      AppMethodBeat.o(258955);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258955);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bdr localbdr = (bdr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258955);
          return -1;
        case 1: 
          localbdr.ZOt = locala.ajGk.readString();
          AppMethodBeat.o(258955);
          return 0;
        case 101: 
          localbdr.ZOu = locala.ajGk.aar();
          AppMethodBeat.o(258955);
          return 0;
        }
        localbdr.ZOv = locala.ajGk.aaw();
        AppMethodBeat.o(258955);
        return 0;
      }
      AppMethodBeat.o(258955);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdr
 * JD-Core Version:    0.7.0.1
 */