package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gdh
  extends com.tencent.mm.bx.a
{
  public String acbp;
  public int acbq;
  public String pSo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32507);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.acbp != null) {
        paramVarArgs.g(1, this.acbp);
      }
      if (this.pSo != null) {
        paramVarArgs.g(2, this.pSo);
      }
      paramVarArgs.bS(3, this.acbq);
      AppMethodBeat.o(32507);
      return 0;
    }
    if (paramInt == 1) {
      if (this.acbp == null) {
        break label323;
      }
    }
    label323:
    for (paramInt = i.a.a.b.b.a.h(1, this.acbp) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.pSo != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.pSo);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.acbq);
      AppMethodBeat.o(32507);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32507);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gdh localgdh = (gdh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32507);
          return -1;
        case 1: 
          localgdh.acbp = locala.ajGk.readString();
          AppMethodBeat.o(32507);
          return 0;
        case 2: 
          localgdh.pSo = locala.ajGk.readString();
          AppMethodBeat.o(32507);
          return 0;
        }
        localgdh.acbq = locala.ajGk.aar();
        AppMethodBeat.o(32507);
        return 0;
      }
      AppMethodBeat.o(32507);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gdh
 * JD-Core Version:    0.7.0.1
 */