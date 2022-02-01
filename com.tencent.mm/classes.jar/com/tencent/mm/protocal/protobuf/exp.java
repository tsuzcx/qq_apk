package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class exp
  extends com.tencent.mm.bx.a
{
  public String YFT;
  public long YFU;
  public String abzp;
  public String psp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152690);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.psp == null)
      {
        paramVarArgs = new b("Not all required fields were included: tp_username");
        AppMethodBeat.o(152690);
        throw paramVarArgs;
      }
      if (this.abzp == null)
      {
        paramVarArgs = new b("Not all required fields were included: verify_content");
        AppMethodBeat.o(152690);
        throw paramVarArgs;
      }
      if (this.YFT == null)
      {
        paramVarArgs = new b("Not all required fields were included: antispam_ticket");
        AppMethodBeat.o(152690);
        throw paramVarArgs;
      }
      if (this.psp != null) {
        paramVarArgs.g(1, this.psp);
      }
      if (this.abzp != null) {
        paramVarArgs.g(2, this.abzp);
      }
      if (this.YFT != null) {
        paramVarArgs.g(3, this.YFT);
      }
      paramVarArgs.bv(4, this.YFU);
      AppMethodBeat.o(152690);
      return 0;
    }
    if (paramInt == 1) {
      if (this.psp == null) {
        break label518;
      }
    }
    label518:
    for (int i = i.a.a.b.b.a.h(1, this.psp) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abzp != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abzp);
      }
      i = paramInt;
      if (this.YFT != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YFT);
      }
      paramInt = i.a.a.b.b.a.q(4, this.YFU);
      AppMethodBeat.o(152690);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.psp == null)
        {
          paramVarArgs = new b("Not all required fields were included: tp_username");
          AppMethodBeat.o(152690);
          throw paramVarArgs;
        }
        if (this.abzp == null)
        {
          paramVarArgs = new b("Not all required fields were included: verify_content");
          AppMethodBeat.o(152690);
          throw paramVarArgs;
        }
        if (this.YFT == null)
        {
          paramVarArgs = new b("Not all required fields were included: antispam_ticket");
          AppMethodBeat.o(152690);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152690);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        exp localexp = (exp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152690);
          return -1;
        case 1: 
          localexp.psp = locala.ajGk.readString();
          AppMethodBeat.o(152690);
          return 0;
        case 2: 
          localexp.abzp = locala.ajGk.readString();
          AppMethodBeat.o(152690);
          return 0;
        case 3: 
          localexp.YFT = locala.ajGk.readString();
          AppMethodBeat.o(152690);
          return 0;
        }
        localexp.YFU = locala.ajGk.aaw();
        AppMethodBeat.o(152690);
        return 0;
      }
      AppMethodBeat.o(152690);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.exp
 * JD-Core Version:    0.7.0.1
 */