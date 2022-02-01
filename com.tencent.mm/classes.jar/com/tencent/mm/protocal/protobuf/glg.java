package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class glg
  extends com.tencent.mm.bx.a
{
  public String acgP;
  public int acgQ;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123704);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.acgP != null) {
        paramVarArgs.g(1, this.acgP);
      }
      paramVarArgs.bS(2, this.scene);
      paramVarArgs.bS(3, this.acgQ);
      AppMethodBeat.o(123704);
      return 0;
    }
    if (paramInt == 1) {
      if (this.acgP == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = i.a.a.b.b.a.h(1, this.acgP) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.scene);
      int j = i.a.a.b.b.a.cJ(3, this.acgQ);
      AppMethodBeat.o(123704);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(123704);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        glg localglg = (glg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123704);
          return -1;
        case 1: 
          localglg.acgP = locala.ajGk.readString();
          AppMethodBeat.o(123704);
          return 0;
        case 2: 
          localglg.scene = locala.ajGk.aar();
          AppMethodBeat.o(123704);
          return 0;
        }
        localglg.acgQ = locala.ajGk.aar();
        AppMethodBeat.o(123704);
        return 0;
      }
      AppMethodBeat.o(123704);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.glg
 * JD-Core Version:    0.7.0.1
 */