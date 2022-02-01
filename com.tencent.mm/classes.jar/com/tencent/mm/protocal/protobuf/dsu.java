package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class dsu
  extends com.tencent.mm.bx.a
{
  public boolean LXS;
  public String aaXV;
  public b cookie;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259638);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaXV != null) {
        paramVarArgs.g(1, this.aaXV);
      }
      if (this.cookie != null) {
        paramVarArgs.d(2, this.cookie);
      }
      paramVarArgs.di(3, this.LXS);
      AppMethodBeat.o(259638);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaXV == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = i.a.a.b.b.a.h(1, this.aaXV) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.cookie != null) {
        i = paramInt + i.a.a.b.b.a.c(2, this.cookie);
      }
      paramInt = i.a.a.b.b.a.ko(3);
      AppMethodBeat.o(259638);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259638);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dsu localdsu = (dsu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259638);
          return -1;
        case 1: 
          localdsu.aaXV = locala.ajGk.readString();
          AppMethodBeat.o(259638);
          return 0;
        case 2: 
          localdsu.cookie = locala.ajGk.kFX();
          AppMethodBeat.o(259638);
          return 0;
        }
        localdsu.LXS = locala.ajGk.aai();
        AppMethodBeat.o(259638);
        return 0;
      }
      AppMethodBeat.o(259638);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsu
 * JD-Core Version:    0.7.0.1
 */