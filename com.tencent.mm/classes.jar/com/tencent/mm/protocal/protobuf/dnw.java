package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dnw
  extends com.tencent.mm.bx.a
{
  public String EVK;
  public int ZMg;
  public int ZPI;
  public String hVy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258475);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hVy != null) {
        paramVarArgs.g(1, this.hVy);
      }
      paramVarArgs.bS(2, this.ZMg);
      paramVarArgs.bS(3, this.ZPI);
      if (this.EVK != null) {
        paramVarArgs.g(4, this.EVK);
      }
      AppMethodBeat.o(258475);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hVy == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = i.a.a.b.b.a.h(1, this.hVy) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.ZMg) + i.a.a.b.b.a.cJ(3, this.ZPI);
      paramInt = i;
      if (this.EVK != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.EVK);
      }
      AppMethodBeat.o(258475);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258475);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dnw localdnw = (dnw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258475);
          return -1;
        case 1: 
          localdnw.hVy = locala.ajGk.readString();
          AppMethodBeat.o(258475);
          return 0;
        case 2: 
          localdnw.ZMg = locala.ajGk.aar();
          AppMethodBeat.o(258475);
          return 0;
        case 3: 
          localdnw.ZPI = locala.ajGk.aar();
          AppMethodBeat.o(258475);
          return 0;
        }
        localdnw.EVK = locala.ajGk.readString();
        AppMethodBeat.o(258475);
        return 0;
      }
      AppMethodBeat.o(258475);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnw
 * JD-Core Version:    0.7.0.1
 */