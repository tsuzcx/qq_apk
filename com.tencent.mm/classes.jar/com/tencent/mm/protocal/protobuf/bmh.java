package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bmh
  extends com.tencent.mm.bx.a
{
  public String ZUY;
  public String ZUZ;
  public String ZVa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259073);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZUY != null) {
        paramVarArgs.g(1, this.ZUY);
      }
      if (this.ZUZ != null) {
        paramVarArgs.g(2, this.ZUZ);
      }
      if (this.ZVa != null) {
        paramVarArgs.g(3, this.ZVa);
      }
      AppMethodBeat.o(259073);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZUY == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.ZUY) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZUZ != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZUZ);
      }
      i = paramInt;
      if (this.ZVa != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZVa);
      }
      AppMethodBeat.o(259073);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259073);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bmh localbmh = (bmh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259073);
          return -1;
        case 1: 
          localbmh.ZUY = locala.ajGk.readString();
          AppMethodBeat.o(259073);
          return 0;
        case 2: 
          localbmh.ZUZ = locala.ajGk.readString();
          AppMethodBeat.o(259073);
          return 0;
        }
        localbmh.ZVa = locala.ajGk.readString();
        AppMethodBeat.o(259073);
        return 0;
      }
      AppMethodBeat.o(259073);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmh
 * JD-Core Version:    0.7.0.1
 */