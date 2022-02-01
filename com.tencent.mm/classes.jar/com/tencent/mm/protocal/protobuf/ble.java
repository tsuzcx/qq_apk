package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ble
  extends com.tencent.mm.bx.a
{
  public int BZj;
  public String ZUh;
  public String ZUi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259388);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZUh != null) {
        paramVarArgs.g(1, this.ZUh);
      }
      paramVarArgs.bS(2, this.BZj);
      if (this.ZUi != null) {
        paramVarArgs.g(3, this.ZUi);
      }
      AppMethodBeat.o(259388);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZUh == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZUh) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.BZj);
      paramInt = i;
      if (this.ZUi != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ZUi);
      }
      AppMethodBeat.o(259388);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259388);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ble localble = (ble)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259388);
          return -1;
        case 1: 
          localble.ZUh = locala.ajGk.readString();
          AppMethodBeat.o(259388);
          return 0;
        case 2: 
          localble.BZj = locala.ajGk.aar();
          AppMethodBeat.o(259388);
          return 0;
        }
        localble.ZUi = locala.ajGk.readString();
        AppMethodBeat.o(259388);
        return 0;
      }
      AppMethodBeat.o(259388);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ble
 * JD-Core Version:    0.7.0.1
 */