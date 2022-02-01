package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bea
  extends com.tencent.mm.bx.a
{
  public String ZlX;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258894);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZlX != null) {
        paramVarArgs.g(1, this.ZlX);
      }
      paramVarArgs.bS(2, this.scene);
      AppMethodBeat.o(258894);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZlX == null) {
        break label254;
      }
    }
    label254:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZlX) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.scene);
      AppMethodBeat.o(258894);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258894);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bea localbea = (bea)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258894);
          return -1;
        case 1: 
          localbea.ZlX = locala.ajGk.readString();
          AppMethodBeat.o(258894);
          return 0;
        }
        localbea.scene = locala.ajGk.aar();
        AppMethodBeat.o(258894);
        return 0;
      }
      AppMethodBeat.o(258894);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bea
 * JD-Core Version:    0.7.0.1
 */