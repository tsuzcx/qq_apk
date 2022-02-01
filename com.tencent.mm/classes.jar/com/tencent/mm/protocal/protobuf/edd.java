package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class edd
  extends com.tencent.mm.bx.a
{
  public String ZZR;
  public String abit;
  public String abiu;
  public boolean abiv;
  public String abiw;
  public String hAk;
  public String word_color;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72547);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZZR != null) {
        paramVarArgs.g(1, this.ZZR);
      }
      if (this.word_color != null) {
        paramVarArgs.g(2, this.word_color);
      }
      if (this.hAk != null) {
        paramVarArgs.g(3, this.hAk);
      }
      if (this.abit != null) {
        paramVarArgs.g(4, this.abit);
      }
      if (this.abiu != null) {
        paramVarArgs.g(5, this.abiu);
      }
      paramVarArgs.di(6, this.abiv);
      if (this.abiw != null) {
        paramVarArgs.g(7, this.abiw);
      }
      AppMethodBeat.o(72547);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZZR == null) {
        break label558;
      }
    }
    label558:
    for (int i = i.a.a.b.b.a.h(1, this.ZZR) + 0;; i = 0)
    {
      paramInt = i;
      if (this.word_color != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.word_color);
      }
      i = paramInt;
      if (this.hAk != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.hAk);
      }
      paramInt = i;
      if (this.abit != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abit);
      }
      i = paramInt;
      if (this.abiu != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abiu);
      }
      i += i.a.a.b.b.a.ko(6) + 1;
      paramInt = i;
      if (this.abiw != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.abiw);
      }
      AppMethodBeat.o(72547);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72547);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        edd localedd = (edd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72547);
          return -1;
        case 1: 
          localedd.ZZR = locala.ajGk.readString();
          AppMethodBeat.o(72547);
          return 0;
        case 2: 
          localedd.word_color = locala.ajGk.readString();
          AppMethodBeat.o(72547);
          return 0;
        case 3: 
          localedd.hAk = locala.ajGk.readString();
          AppMethodBeat.o(72547);
          return 0;
        case 4: 
          localedd.abit = locala.ajGk.readString();
          AppMethodBeat.o(72547);
          return 0;
        case 5: 
          localedd.abiu = locala.ajGk.readString();
          AppMethodBeat.o(72547);
          return 0;
        case 6: 
          localedd.abiv = locala.ajGk.aai();
          AppMethodBeat.o(72547);
          return 0;
        }
        localedd.abiw = locala.ajGk.readString();
        AppMethodBeat.o(72547);
        return 0;
      }
      AppMethodBeat.o(72547);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edd
 * JD-Core Version:    0.7.0.1
 */