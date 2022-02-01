package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class ggr
  extends com.tencent.mm.bx.a
{
  public int IJG;
  public String MD5;
  public String YYC;
  public String abvu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32556);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abvu == null)
      {
        paramVarArgs = new b("Not all required fields were included: Talker");
        AppMethodBeat.o(32556);
        throw paramVarArgs;
      }
      if (this.MD5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: MD5");
        AppMethodBeat.o(32556);
        throw paramVarArgs;
      }
      if (this.YYC == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductId");
        AppMethodBeat.o(32556);
        throw paramVarArgs;
      }
      if (this.abvu != null) {
        paramVarArgs.g(1, this.abvu);
      }
      if (this.MD5 != null) {
        paramVarArgs.g(2, this.MD5);
      }
      if (this.YYC != null) {
        paramVarArgs.g(3, this.YYC);
      }
      paramVarArgs.bS(4, this.IJG);
      AppMethodBeat.o(32556);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abvu == null) {
        break label536;
      }
    }
    label536:
    for (int i = i.a.a.b.b.a.h(1, this.abvu) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MD5 != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.MD5);
      }
      i = paramInt;
      if (this.YYC != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YYC);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.IJG);
      AppMethodBeat.o(32556);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.abvu == null)
        {
          paramVarArgs = new b("Not all required fields were included: Talker");
          AppMethodBeat.o(32556);
          throw paramVarArgs;
        }
        if (this.MD5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: MD5");
          AppMethodBeat.o(32556);
          throw paramVarArgs;
        }
        if (this.YYC == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductId");
          AppMethodBeat.o(32556);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32556);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ggr localggr = (ggr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32556);
          return -1;
        case 1: 
          localggr.abvu = locala.ajGk.readString();
          AppMethodBeat.o(32556);
          return 0;
        case 2: 
          localggr.MD5 = locala.ajGk.readString();
          AppMethodBeat.o(32556);
          return 0;
        case 3: 
          localggr.YYC = locala.ajGk.readString();
          AppMethodBeat.o(32556);
          return 0;
        }
        localggr.IJG = locala.ajGk.aar();
        AppMethodBeat.o(32556);
        return 0;
      }
      AppMethodBeat.o(32556);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ggr
 * JD-Core Version:    0.7.0.1
 */