package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ful
  extends com.tencent.mm.bx.a
{
  public String YYZ;
  public int aaZv;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258946);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.g(1, this.url);
      }
      paramVarArgs.bS(2, this.aaZv);
      if (this.YYZ != null) {
        paramVarArgs.g(3, this.YYZ);
      }
      AppMethodBeat.o(258946);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = i.a.a.b.b.a.h(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.aaZv);
      paramInt = i;
      if (this.YYZ != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.YYZ);
      }
      AppMethodBeat.o(258946);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258946);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ful localful = (ful)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258946);
          return -1;
        case 1: 
          localful.url = locala.ajGk.readString();
          AppMethodBeat.o(258946);
          return 0;
        case 2: 
          localful.aaZv = locala.ajGk.aar();
          AppMethodBeat.o(258946);
          return 0;
        }
        localful.YYZ = locala.ajGk.readString();
        AppMethodBeat.o(258946);
        return 0;
      }
      AppMethodBeat.o(258946);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ful
 * JD-Core Version:    0.7.0.1
 */