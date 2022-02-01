package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class efa
  extends com.tencent.mm.bx.a
{
  public String URL;
  public String YAQ;
  public int abkw;
  public String abkx;
  public String hAP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259813);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAP != null) {
        paramVarArgs.g(1, this.hAP);
      }
      if (this.URL != null) {
        paramVarArgs.g(2, this.URL);
      }
      paramVarArgs.bS(3, this.abkw);
      if (this.abkx != null) {
        paramVarArgs.g(4, this.abkx);
      }
      if (this.YAQ != null) {
        paramVarArgs.g(5, this.YAQ);
      }
      AppMethodBeat.o(259813);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hAP == null) {
        break label434;
      }
    }
    label434:
    for (paramInt = i.a.a.b.b.a.h(1, this.hAP) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.URL != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.URL);
      }
      i += i.a.a.b.b.a.cJ(3, this.abkw);
      paramInt = i;
      if (this.abkx != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abkx);
      }
      i = paramInt;
      if (this.YAQ != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YAQ);
      }
      AppMethodBeat.o(259813);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259813);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        efa localefa = (efa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259813);
          return -1;
        case 1: 
          localefa.hAP = locala.ajGk.readString();
          AppMethodBeat.o(259813);
          return 0;
        case 2: 
          localefa.URL = locala.ajGk.readString();
          AppMethodBeat.o(259813);
          return 0;
        case 3: 
          localefa.abkw = locala.ajGk.aar();
          AppMethodBeat.o(259813);
          return 0;
        case 4: 
          localefa.abkx = locala.ajGk.readString();
          AppMethodBeat.o(259813);
          return 0;
        }
        localefa.YAQ = locala.ajGk.readString();
        AppMethodBeat.o(259813);
        return 0;
      }
      AppMethodBeat.o(259813);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efa
 * JD-Core Version:    0.7.0.1
 */