package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ebo
  extends com.tencent.mm.bx.a
{
  public String NjO;
  public long abhf;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72541);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.NjO != null) {
        paramVarArgs.g(1, this.NjO);
      }
      paramVarArgs.bv(2, this.abhf);
      if (this.url != null) {
        paramVarArgs.g(3, this.url);
      }
      AppMethodBeat.o(72541);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NjO == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = i.a.a.b.b.a.h(1, this.NjO) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.abhf);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.url);
      }
      AppMethodBeat.o(72541);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72541);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ebo localebo = (ebo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72541);
          return -1;
        case 1: 
          localebo.NjO = locala.ajGk.readString();
          AppMethodBeat.o(72541);
          return 0;
        case 2: 
          localebo.abhf = locala.ajGk.aaw();
          AppMethodBeat.o(72541);
          return 0;
        }
        localebo.url = locala.ajGk.readString();
        AppMethodBeat.o(72541);
        return 0;
      }
      AppMethodBeat.o(72541);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebo
 * JD-Core Version:    0.7.0.1
 */