package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class ezc
  extends com.tencent.mm.cd.a
{
  public String RIC;
  public String Sqe;
  public String UserName;
  public String UzH;
  public String mVD;
  public String rWI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117939);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(117939);
        throw paramVarArgs;
      }
      if (this.UzH == null)
      {
        paramVarArgs = new b("Not all required fields were included: MatchWord");
        AppMethodBeat.o(117939);
        throw paramVarArgs;
      }
      if (this.UserName != null) {
        paramVarArgs.f(1, this.UserName);
      }
      if (this.UzH != null) {
        paramVarArgs.f(2, this.UzH);
      }
      if (this.rWI != null) {
        paramVarArgs.f(3, this.rWI);
      }
      if (this.Sqe != null) {
        paramVarArgs.f(4, this.Sqe);
      }
      if (this.mVD != null) {
        paramVarArgs.f(5, this.mVD);
      }
      if (this.RIC != null) {
        paramVarArgs.f(6, this.RIC);
      }
      AppMethodBeat.o(117939);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label614;
      }
    }
    label614:
    for (int i = g.a.a.b.b.a.g(1, this.UserName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UzH != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UzH);
      }
      i = paramInt;
      if (this.rWI != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.rWI);
      }
      paramInt = i;
      if (this.Sqe != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Sqe);
      }
      i = paramInt;
      if (this.mVD != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.mVD);
      }
      paramInt = i;
      if (this.RIC != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RIC);
      }
      AppMethodBeat.o(117939);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.UserName == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(117939);
          throw paramVarArgs;
        }
        if (this.UzH == null)
        {
          paramVarArgs = new b("Not all required fields were included: MatchWord");
          AppMethodBeat.o(117939);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117939);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ezc localezc = (ezc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117939);
          return -1;
        case 1: 
          localezc.UserName = locala.abFh.readString();
          AppMethodBeat.o(117939);
          return 0;
        case 2: 
          localezc.UzH = locala.abFh.readString();
          AppMethodBeat.o(117939);
          return 0;
        case 3: 
          localezc.rWI = locala.abFh.readString();
          AppMethodBeat.o(117939);
          return 0;
        case 4: 
          localezc.Sqe = locala.abFh.readString();
          AppMethodBeat.o(117939);
          return 0;
        case 5: 
          localezc.mVD = locala.abFh.readString();
          AppMethodBeat.o(117939);
          return 0;
        }
        localezc.RIC = locala.abFh.readString();
        AppMethodBeat.o(117939);
        return 0;
      }
      AppMethodBeat.o(117939);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezc
 * JD-Core Version:    0.7.0.1
 */