package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class fj
  extends com.tencent.mm.bx.a
{
  public String YGS;
  public String YGT;
  public String content;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50079);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.content == null)
      {
        paramVarArgs = new b("Not all required fields were included: content");
        AppMethodBeat.o(50079);
        throw paramVarArgs;
      }
      if (this.content != null) {
        paramVarArgs.g(1, this.content);
      }
      if (this.YGS != null) {
        paramVarArgs.g(2, this.YGS);
      }
      if (this.YGT != null) {
        paramVarArgs.g(3, this.YGT);
      }
      AppMethodBeat.o(50079);
      return 0;
    }
    if (paramInt == 1) {
      if (this.content == null) {
        break label378;
      }
    }
    label378:
    for (int i = i.a.a.b.b.a.h(1, this.content) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YGS != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YGS);
      }
      i = paramInt;
      if (this.YGT != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YGT);
      }
      AppMethodBeat.o(50079);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.content == null)
        {
          paramVarArgs = new b("Not all required fields were included: content");
          AppMethodBeat.o(50079);
          throw paramVarArgs;
        }
        AppMethodBeat.o(50079);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fj localfj = (fj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50079);
          return -1;
        case 1: 
          localfj.content = locala.ajGk.readString();
          AppMethodBeat.o(50079);
          return 0;
        case 2: 
          localfj.YGS = locala.ajGk.readString();
          AppMethodBeat.o(50079);
          return 0;
        }
        localfj.YGT = locala.ajGk.readString();
        AppMethodBeat.o(50079);
        return 0;
      }
      AppMethodBeat.o(50079);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fj
 * JD-Core Version:    0.7.0.1
 */