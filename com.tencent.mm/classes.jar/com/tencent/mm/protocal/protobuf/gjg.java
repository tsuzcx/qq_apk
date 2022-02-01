package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gjg
  extends com.tencent.mm.bx.a
{
  public String YHe;
  public String acfA;
  public String acfz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258315);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.acfz != null) {
        paramVarArgs.g(1, this.acfz);
      }
      if (this.acfA != null) {
        paramVarArgs.g(2, this.acfA);
      }
      if (this.YHe != null) {
        paramVarArgs.g(3, this.YHe);
      }
      AppMethodBeat.o(258315);
      return 0;
    }
    if (paramInt == 1) {
      if (this.acfz == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.acfz) + 0;; i = 0)
    {
      paramInt = i;
      if (this.acfA != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.acfA);
      }
      i = paramInt;
      if (this.YHe != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YHe);
      }
      AppMethodBeat.o(258315);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258315);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gjg localgjg = (gjg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258315);
          return -1;
        case 1: 
          localgjg.acfz = locala.ajGk.readString();
          AppMethodBeat.o(258315);
          return 0;
        case 2: 
          localgjg.acfA = locala.ajGk.readString();
          AppMethodBeat.o(258315);
          return 0;
        }
        localgjg.YHe = locala.ajGk.readString();
        AppMethodBeat.o(258315);
        return 0;
      }
      AppMethodBeat.o(258315);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gjg
 * JD-Core Version:    0.7.0.1
 */