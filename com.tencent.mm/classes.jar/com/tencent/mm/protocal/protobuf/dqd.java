package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dqd
  extends com.tencent.mm.cd.a
{
  public String SjH;
  public int Sqp;
  public int TWT;
  public String UserName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32393);
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
      AppMethodBeat.o(32393);
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
      AppMethodBeat.o(32393);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32393);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dqd localdqd = (dqd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32393);
          return -1;
        case 1: 
          localdqd.UserName = locala.abFh.readString();
          AppMethodBeat.o(32393);
          return 0;
        case 2: 
          localdqd.SjH = locala.abFh.readString();
          AppMethodBeat.o(32393);
          return 0;
        case 3: 
          localdqd.TWT = locala.abFh.AK();
          AppMethodBeat.o(32393);
          return 0;
        }
        localdqd.Sqp = locala.abFh.AK();
        AppMethodBeat.o(32393);
        return 0;
      }
      AppMethodBeat.o(32393);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqd
 * JD-Core Version:    0.7.0.1
 */