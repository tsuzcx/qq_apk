package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eqa
  extends com.tencent.mm.cd.a
{
  public String SjH;
  public int Sqp;
  public int TWT;
  public String UserName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32460);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.f(1, this.UserName);
      }
      if (this.SjH != null) {
        paramVarArgs.f(2, this.SjH);
      }
      paramVarArgs.aY(3, this.TWT);
      paramVarArgs.aY(4, this.Sqp);
      AppMethodBeat.o(32460);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label376;
      }
    }
    label376:
    for (paramInt = g.a.a.b.b.a.g(1, this.UserName) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SjH != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.SjH);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.TWT);
      int j = g.a.a.b.b.a.bM(4, this.Sqp);
      AppMethodBeat.o(32460);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32460);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eqa localeqa = (eqa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32460);
          return -1;
        case 1: 
          localeqa.UserName = locala.abFh.readString();
          AppMethodBeat.o(32460);
          return 0;
        case 2: 
          localeqa.SjH = locala.abFh.readString();
          AppMethodBeat.o(32460);
          return 0;
        case 3: 
          localeqa.TWT = locala.abFh.AK();
          AppMethodBeat.o(32460);
          return 0;
        }
        localeqa.Sqp = locala.abFh.AK();
        AppMethodBeat.o(32460);
        return 0;
      }
      AppMethodBeat.o(32460);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqa
 * JD-Core Version:    0.7.0.1
 */