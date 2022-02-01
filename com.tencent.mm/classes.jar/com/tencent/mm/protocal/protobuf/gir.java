package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gir
  extends com.tencent.mm.bx.a
{
  public String acfb;
  public boolean acfc;
  public int acfd;
  public int acfe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110856);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.acfb != null) {
        paramVarArgs.g(1, this.acfb);
      }
      paramVarArgs.di(2, this.acfc);
      paramVarArgs.bS(3, this.acfd);
      paramVarArgs.bS(4, this.acfe);
      AppMethodBeat.o(110856);
      return 0;
    }
    if (paramInt == 1) {
      if (this.acfb == null) {
        break label346;
      }
    }
    label346:
    for (paramInt = i.a.a.b.b.a.h(1, this.acfb) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.ko(2);
      int j = i.a.a.b.b.a.cJ(3, this.acfd);
      int k = i.a.a.b.b.a.cJ(4, this.acfe);
      AppMethodBeat.o(110856);
      return paramInt + (i + 1) + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(110856);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gir localgir = (gir)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(110856);
          return -1;
        case 1: 
          localgir.acfb = locala.ajGk.readString();
          AppMethodBeat.o(110856);
          return 0;
        case 2: 
          localgir.acfc = locala.ajGk.aai();
          AppMethodBeat.o(110856);
          return 0;
        case 3: 
          localgir.acfd = locala.ajGk.aar();
          AppMethodBeat.o(110856);
          return 0;
        }
        localgir.acfe = locala.ajGk.aar();
        AppMethodBeat.o(110856);
        return 0;
      }
      AppMethodBeat.o(110856);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gir
 * JD-Core Version:    0.7.0.1
 */