package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class edy
  extends com.tencent.mm.cd.a
{
  public String RIS;
  public long RIT;
  public String UhZ;
  public String myd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152690);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.myd == null)
      {
        paramVarArgs = new b("Not all required fields were included: tp_username");
        AppMethodBeat.o(152690);
        throw paramVarArgs;
      }
      if (this.UhZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: verify_content");
        AppMethodBeat.o(152690);
        throw paramVarArgs;
      }
      if (this.RIS == null)
      {
        paramVarArgs = new b("Not all required fields were included: antispam_ticket");
        AppMethodBeat.o(152690);
        throw paramVarArgs;
      }
      if (this.myd != null) {
        paramVarArgs.f(1, this.myd);
      }
      if (this.UhZ != null) {
        paramVarArgs.f(2, this.UhZ);
      }
      if (this.RIS != null) {
        paramVarArgs.f(3, this.RIS);
      }
      paramVarArgs.bm(4, this.RIT);
      AppMethodBeat.o(152690);
      return 0;
    }
    if (paramInt == 1) {
      if (this.myd == null) {
        break label522;
      }
    }
    label522:
    for (int i = g.a.a.b.b.a.g(1, this.myd) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UhZ != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UhZ);
      }
      i = paramInt;
      if (this.RIS != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RIS);
      }
      paramInt = g.a.a.b.b.a.p(4, this.RIT);
      AppMethodBeat.o(152690);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.myd == null)
        {
          paramVarArgs = new b("Not all required fields were included: tp_username");
          AppMethodBeat.o(152690);
          throw paramVarArgs;
        }
        if (this.UhZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: verify_content");
          AppMethodBeat.o(152690);
          throw paramVarArgs;
        }
        if (this.RIS == null)
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
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        edy localedy = (edy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152690);
          return -1;
        case 1: 
          localedy.myd = locala.abFh.readString();
          AppMethodBeat.o(152690);
          return 0;
        case 2: 
          localedy.UhZ = locala.abFh.readString();
          AppMethodBeat.o(152690);
          return 0;
        case 3: 
          localedy.RIS = locala.abFh.readString();
          AppMethodBeat.o(152690);
          return 0;
        }
        localedy.RIT = locala.abFh.AN();
        AppMethodBeat.o(152690);
        return 0;
      }
      AppMethodBeat.o(152690);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edy
 * JD-Core Version:    0.7.0.1
 */