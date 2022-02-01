package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dgf
  extends com.tencent.mm.bx.a
{
  public String Zwg;
  public String vgW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258008);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Zwg != null) {
        paramVarArgs.g(1, this.Zwg);
      }
      if (this.vgW != null) {
        paramVarArgs.g(2, this.vgW);
      }
      AppMethodBeat.o(258008);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Zwg == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.Zwg) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.vgW != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.vgW);
      }
      AppMethodBeat.o(258008);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258008);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dgf localdgf = (dgf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258008);
          return -1;
        case 1: 
          localdgf.Zwg = locala.ajGk.readString();
          AppMethodBeat.o(258008);
          return 0;
        }
        localdgf.vgW = locala.ajGk.readString();
        AppMethodBeat.o(258008);
        return 0;
      }
      AppMethodBeat.o(258008);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgf
 * JD-Core Version:    0.7.0.1
 */