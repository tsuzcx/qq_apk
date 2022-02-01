package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cos
  extends com.tencent.mm.bx.a
{
  public String YFY;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259506);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.g(1, this.url);
      }
      if (this.YFY != null) {
        paramVarArgs.g(2, this.YFY);
      }
      AppMethodBeat.o(259506);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YFY != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.YFY);
      }
      AppMethodBeat.o(259506);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259506);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        cos localcos = (cos)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259506);
          return -1;
        case 1: 
          localcos.url = locala.ajGk.readString();
          AppMethodBeat.o(259506);
          return 0;
        }
        localcos.YFY = locala.ajGk.readString();
        AppMethodBeat.o(259506);
        return 0;
      }
      AppMethodBeat.o(259506);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cos
 * JD-Core Version:    0.7.0.1
 */