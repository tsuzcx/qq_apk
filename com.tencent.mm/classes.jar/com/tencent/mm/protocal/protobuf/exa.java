package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class exa
  extends com.tencent.mm.bw.a
{
  public String Nkr;
  public String Nuu;
  public String Nuv;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91726);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.Nuu != null) {
        paramVarArgs.e(2, this.Nuu);
      }
      if (this.Nkr != null) {
        paramVarArgs.e(3, this.Nkr);
      }
      if (this.Nuv != null) {
        paramVarArgs.e(4, this.Nuv);
      }
      AppMethodBeat.o(91726);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Nuu != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Nuu);
      }
      i = paramInt;
      if (this.Nkr != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Nkr);
      }
      paramInt = i;
      if (this.Nuv != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Nuv);
      }
      AppMethodBeat.o(91726);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91726);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        exa localexa = (exa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91726);
          return -1;
        case 1: 
          localexa.title = locala.UbS.readString();
          AppMethodBeat.o(91726);
          return 0;
        case 2: 
          localexa.Nuu = locala.UbS.readString();
          AppMethodBeat.o(91726);
          return 0;
        case 3: 
          localexa.Nkr = locala.UbS.readString();
          AppMethodBeat.o(91726);
          return 0;
        }
        localexa.Nuv = locala.UbS.readString();
        AppMethodBeat.o(91726);
        return 0;
      }
      AppMethodBeat.o(91726);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.exa
 * JD-Core Version:    0.7.0.1
 */