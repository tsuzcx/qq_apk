package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class gfz
  extends com.tencent.mm.bx.a
{
  public long YKx;
  public String abvu;
  public String hAP;
  public String nUB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32533);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abvu == null)
      {
        paramVarArgs = new b("Not all required fields were included: Talker");
        AppMethodBeat.o(32533);
        throw paramVarArgs;
      }
      if (this.hAP == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(32533);
        throw paramVarArgs;
      }
      if (this.nUB == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(32533);
        throw paramVarArgs;
      }
      if (this.abvu != null) {
        paramVarArgs.g(1, this.abvu);
      }
      if (this.hAP != null) {
        paramVarArgs.g(2, this.hAP);
      }
      if (this.nUB != null) {
        paramVarArgs.g(3, this.nUB);
      }
      paramVarArgs.bv(4, this.YKx);
      AppMethodBeat.o(32533);
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
      if (this.hAP != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.hAP);
      }
      i = paramInt;
      if (this.nUB != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.nUB);
      }
      paramInt = i.a.a.b.b.a.q(4, this.YKx);
      AppMethodBeat.o(32533);
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
          AppMethodBeat.o(32533);
          throw paramVarArgs;
        }
        if (this.hAP == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(32533);
          throw paramVarArgs;
        }
        if (this.nUB == null)
        {
          paramVarArgs = new b("Not all required fields were included: Content");
          AppMethodBeat.o(32533);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32533);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gfz localgfz = (gfz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32533);
          return -1;
        case 1: 
          localgfz.abvu = locala.ajGk.readString();
          AppMethodBeat.o(32533);
          return 0;
        case 2: 
          localgfz.hAP = locala.ajGk.readString();
          AppMethodBeat.o(32533);
          return 0;
        case 3: 
          localgfz.nUB = locala.ajGk.readString();
          AppMethodBeat.o(32533);
          return 0;
        }
        localgfz.YKx = locala.ajGk.aaw();
        AppMethodBeat.o(32533);
        return 0;
      }
      AppMethodBeat.o(32533);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gfz
 * JD-Core Version:    0.7.0.1
 */