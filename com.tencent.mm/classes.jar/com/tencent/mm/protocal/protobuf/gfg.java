package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gfg
  extends com.tencent.mm.bx.a
{
  public int Tqb;
  public String wwH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259571);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.wwH != null) {
        paramVarArgs.g(1, this.wwH);
      }
      paramVarArgs.bS(2, this.Tqb);
      AppMethodBeat.o(259571);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wwH == null) {
        break label254;
      }
    }
    label254:
    for (paramInt = i.a.a.b.b.a.h(1, this.wwH) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.Tqb);
      AppMethodBeat.o(259571);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259571);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gfg localgfg = (gfg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259571);
          return -1;
        case 1: 
          localgfg.wwH = locala.ajGk.readString();
          AppMethodBeat.o(259571);
          return 0;
        }
        localgfg.Tqb = locala.ajGk.aar();
        AppMethodBeat.o(259571);
        return 0;
      }
      AppMethodBeat.o(259571);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gfg
 * JD-Core Version:    0.7.0.1
 */