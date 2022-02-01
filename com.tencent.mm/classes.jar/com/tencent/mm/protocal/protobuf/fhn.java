package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fhn
  extends com.tencent.mm.cd.a
{
  public String UHv;
  public String UHw;
  public String Uxb;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91726);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.f(1, this.title);
      }
      if (this.UHv != null) {
        paramVarArgs.f(2, this.UHv);
      }
      if (this.Uxb != null) {
        paramVarArgs.f(3, this.Uxb);
      }
      if (this.UHw != null) {
        paramVarArgs.f(4, this.UHw);
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
    for (int i = g.a.a.b.b.a.g(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UHv != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UHv);
      }
      i = paramInt;
      if (this.Uxb != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Uxb);
      }
      paramInt = i;
      if (this.UHw != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.UHw);
      }
      AppMethodBeat.o(91726);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91726);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fhn localfhn = (fhn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91726);
          return -1;
        case 1: 
          localfhn.title = locala.abFh.readString();
          AppMethodBeat.o(91726);
          return 0;
        case 2: 
          localfhn.UHv = locala.abFh.readString();
          AppMethodBeat.o(91726);
          return 0;
        case 3: 
          localfhn.Uxb = locala.abFh.readString();
          AppMethodBeat.o(91726);
          return 0;
        }
        localfhn.UHw = locala.abFh.readString();
        AppMethodBeat.o(91726);
        return 0;
      }
      AppMethodBeat.o(91726);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fhn
 * JD-Core Version:    0.7.0.1
 */