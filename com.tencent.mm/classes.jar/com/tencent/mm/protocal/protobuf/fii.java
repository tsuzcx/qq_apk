package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class fii
  extends com.tencent.mm.bx.a
{
  public String QCC;
  public int QCD;
  public String QCE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118441);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.QCC == null)
      {
        paramVarArgs = new b("Not all required fields were included: clientID");
        AppMethodBeat.o(118441);
        throw paramVarArgs;
      }
      if (this.QCC != null) {
        paramVarArgs.g(1, this.QCC);
      }
      paramVarArgs.bS(2, this.QCD);
      if (this.QCE != null) {
        paramVarArgs.g(3, this.QCE);
      }
      AppMethodBeat.o(118441);
      return 0;
    }
    if (paramInt == 1) {
      if (this.QCC == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = i.a.a.b.b.a.h(1, this.QCC) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.QCD);
      paramInt = i;
      if (this.QCE != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.QCE);
      }
      AppMethodBeat.o(118441);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.QCC == null)
        {
          paramVarArgs = new b("Not all required fields were included: clientID");
          AppMethodBeat.o(118441);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118441);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fii localfii = (fii)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(118441);
          return -1;
        case 1: 
          localfii.QCC = locala.ajGk.readString();
          AppMethodBeat.o(118441);
          return 0;
        case 2: 
          localfii.QCD = locala.ajGk.aar();
          AppMethodBeat.o(118441);
          return 0;
        }
        localfii.QCE = locala.ajGk.readString();
        AppMethodBeat.o(118441);
        return 0;
      }
      AppMethodBeat.o(118441);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fii
 * JD-Core Version:    0.7.0.1
 */