package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class frj
  extends com.tencent.mm.bx.a
{
  public String abBq;
  public int abBu;
  public String abBw;
  public String content;
  public int hAV;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153308);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abBw != null) {
        paramVarArgs.g(1, this.abBw);
      }
      paramVarArgs.bS(2, this.hAV);
      if (this.content != null) {
        paramVarArgs.g(3, this.content);
      }
      if (this.abBq != null) {
        paramVarArgs.g(4, this.abBq);
      }
      paramVarArgs.bS(5, this.abBu);
      paramVarArgs.bS(6, this.state);
      AppMethodBeat.o(153308);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abBw == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = i.a.a.b.b.a.h(1, this.abBw) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.hAV);
      paramInt = i;
      if (this.content != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.content);
      }
      i = paramInt;
      if (this.abBq != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.abBq);
      }
      paramInt = i.a.a.b.b.a.cJ(5, this.abBu);
      int j = i.a.a.b.b.a.cJ(6, this.state);
      AppMethodBeat.o(153308);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(153308);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        frj localfrj = (frj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153308);
          return -1;
        case 1: 
          localfrj.abBw = locala.ajGk.readString();
          AppMethodBeat.o(153308);
          return 0;
        case 2: 
          localfrj.hAV = locala.ajGk.aar();
          AppMethodBeat.o(153308);
          return 0;
        case 3: 
          localfrj.content = locala.ajGk.readString();
          AppMethodBeat.o(153308);
          return 0;
        case 4: 
          localfrj.abBq = locala.ajGk.readString();
          AppMethodBeat.o(153308);
          return 0;
        case 5: 
          localfrj.abBu = locala.ajGk.aar();
          AppMethodBeat.o(153308);
          return 0;
        }
        localfrj.state = locala.ajGk.aar();
        AppMethodBeat.o(153308);
        return 0;
      }
      AppMethodBeat.o(153308);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.frj
 * JD-Core Version:    0.7.0.1
 */