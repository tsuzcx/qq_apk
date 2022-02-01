package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class fat
  extends com.tencent.mm.bx.a
{
  public String ZVg;
  public String mdK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259651);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZVg != null) {
        paramVarArgs.g(1, this.ZVg);
      }
      if (this.mdK != null) {
        paramVarArgs.g(2, this.mdK);
      }
      AppMethodBeat.o(259651);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZVg == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZVg) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.mdK != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.mdK);
      }
      AppMethodBeat.o(259651);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259651);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fat localfat = (fat)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259651);
          return -1;
        case 1: 
          localfat.ZVg = locala.ajGk.readString();
          AppMethodBeat.o(259651);
          return 0;
        }
        localfat.mdK = locala.ajGk.readString();
        AppMethodBeat.o(259651);
        return 0;
      }
      AppMethodBeat.o(259651);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fat
 * JD-Core Version:    0.7.0.1
 */