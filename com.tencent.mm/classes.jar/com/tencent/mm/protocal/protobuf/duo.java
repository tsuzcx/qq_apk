package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class duo
  extends com.tencent.mm.bx.a
{
  public String abaA;
  public String abaB;
  public String abaC;
  public int action;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259037);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abaA != null) {
        paramVarArgs.g(1, this.abaA);
      }
      if (this.abaB != null) {
        paramVarArgs.g(2, this.abaB);
      }
      if (this.abaC != null) {
        paramVarArgs.g(3, this.abaC);
      }
      paramVarArgs.bS(4, this.action);
      AppMethodBeat.o(259037);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abaA == null) {
        break label374;
      }
    }
    label374:
    for (int i = i.a.a.b.b.a.h(1, this.abaA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abaB != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abaB);
      }
      i = paramInt;
      if (this.abaC != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abaC);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.action);
      AppMethodBeat.o(259037);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259037);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        duo localduo = (duo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259037);
          return -1;
        case 1: 
          localduo.abaA = locala.ajGk.readString();
          AppMethodBeat.o(259037);
          return 0;
        case 2: 
          localduo.abaB = locala.ajGk.readString();
          AppMethodBeat.o(259037);
          return 0;
        case 3: 
          localduo.abaC = locala.ajGk.readString();
          AppMethodBeat.o(259037);
          return 0;
        }
        localduo.action = locala.ajGk.aar();
        AppMethodBeat.o(259037);
        return 0;
      }
      AppMethodBeat.o(259037);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duo
 * JD-Core Version:    0.7.0.1
 */