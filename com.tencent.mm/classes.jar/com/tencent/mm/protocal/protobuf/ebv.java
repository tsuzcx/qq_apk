package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ebv
  extends com.tencent.mm.cd.a
{
  public String SuR;
  public String UgL;
  public String UgM;
  public String UserName;
  public String fwr;
  public String rWI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212650);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fwr != null) {
        paramVarArgs.f(1, this.fwr);
      }
      if (this.UserName != null) {
        paramVarArgs.f(2, this.UserName);
      }
      if (this.SuR != null) {
        paramVarArgs.f(3, this.SuR);
      }
      if (this.rWI != null) {
        paramVarArgs.f(4, this.rWI);
      }
      if (this.UgL != null) {
        paramVarArgs.f(5, this.UgL);
      }
      if (this.UgM != null) {
        paramVarArgs.f(6, this.UgM);
      }
      AppMethodBeat.o(212650);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fwr == null) {
        break label518;
      }
    }
    label518:
    for (int i = g.a.a.b.b.a.g(1, this.fwr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UserName);
      }
      i = paramInt;
      if (this.SuR != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SuR);
      }
      paramInt = i;
      if (this.rWI != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.rWI);
      }
      i = paramInt;
      if (this.UgL != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.UgL);
      }
      paramInt = i;
      if (this.UgM != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.UgM);
      }
      AppMethodBeat.o(212650);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(212650);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ebv localebv = (ebv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(212650);
          return -1;
        case 1: 
          localebv.fwr = locala.abFh.readString();
          AppMethodBeat.o(212650);
          return 0;
        case 2: 
          localebv.UserName = locala.abFh.readString();
          AppMethodBeat.o(212650);
          return 0;
        case 3: 
          localebv.SuR = locala.abFh.readString();
          AppMethodBeat.o(212650);
          return 0;
        case 4: 
          localebv.rWI = locala.abFh.readString();
          AppMethodBeat.o(212650);
          return 0;
        case 5: 
          localebv.UgL = locala.abFh.readString();
          AppMethodBeat.o(212650);
          return 0;
        }
        localebv.UgM = locala.abFh.readString();
        AppMethodBeat.o(212650);
        return 0;
      }
      AppMethodBeat.o(212650);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebv
 * JD-Core Version:    0.7.0.1
 */