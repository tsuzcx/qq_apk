package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dvh
  extends com.tencent.mm.bx.a
{
  public long Bev;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258773);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.g(1, this.url);
      }
      paramVarArgs.bv(2, this.Bev);
      AppMethodBeat.o(258773);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label254;
      }
    }
    label254:
    for (paramInt = i.a.a.b.b.a.h(1, this.url) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.q(2, this.Bev);
      AppMethodBeat.o(258773);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258773);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dvh localdvh = (dvh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258773);
          return -1;
        case 1: 
          localdvh.url = locala.ajGk.readString();
          AppMethodBeat.o(258773);
          return 0;
        }
        localdvh.Bev = locala.ajGk.aaw();
        AppMethodBeat.o(258773);
        return 0;
      }
      AppMethodBeat.o(258773);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvh
 * JD-Core Version:    0.7.0.1
 */