package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class axa
  extends com.tencent.mm.bx.a
{
  public String link;
  public int style;
  public String title;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168952);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.link != null) {
        paramVarArgs.g(1, this.link);
      }
      if (this.title != null) {
        paramVarArgs.g(2, this.title);
      }
      paramVarArgs.bS(3, this.type);
      paramVarArgs.bS(4, this.style);
      AppMethodBeat.o(168952);
      return 0;
    }
    if (paramInt == 1) {
      if (this.link == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = i.a.a.b.b.a.h(1, this.link) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.title);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.type);
      int j = i.a.a.b.b.a.cJ(4, this.style);
      AppMethodBeat.o(168952);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(168952);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        axa localaxa = (axa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(168952);
          return -1;
        case 1: 
          localaxa.link = locala.ajGk.readString();
          AppMethodBeat.o(168952);
          return 0;
        case 2: 
          localaxa.title = locala.ajGk.readString();
          AppMethodBeat.o(168952);
          return 0;
        case 3: 
          localaxa.type = locala.ajGk.aar();
          AppMethodBeat.o(168952);
          return 0;
        }
        localaxa.style = locala.ajGk.aar();
        AppMethodBeat.o(168952);
        return 0;
      }
      AppMethodBeat.o(168952);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axa
 * JD-Core Version:    0.7.0.1
 */