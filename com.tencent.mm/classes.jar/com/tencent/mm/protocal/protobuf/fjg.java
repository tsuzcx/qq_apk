package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fjg
  extends com.tencent.mm.cd.a
{
  public int CRP;
  public com.tencent.mm.cd.b UIy;
  public String UserName;
  public String lpy;
  public String rWI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32527);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: UserName");
        AppMethodBeat.o(32527);
        throw paramVarArgs;
      }
      if (this.rWI == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: NickName");
        AppMethodBeat.o(32527);
        throw paramVarArgs;
      }
      if (this.lpy == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(32527);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.CRP);
      if (this.UserName != null) {
        paramVarArgs.f(2, this.UserName);
      }
      if (this.rWI != null) {
        paramVarArgs.f(3, this.rWI);
      }
      if (this.lpy != null) {
        paramVarArgs.f(4, this.lpy);
      }
      if (this.UIy != null) {
        paramVarArgs.c(5, this.UIy);
      }
      AppMethodBeat.o(32527);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.CRP) + 0;
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UserName);
      }
      i = paramInt;
      if (this.rWI != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.rWI);
      }
      paramInt = i;
      if (this.lpy != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.lpy);
      }
      i = paramInt;
      if (this.UIy != null) {
        i = paramInt + g.a.a.b.b.a.b(5, this.UIy);
      }
      AppMethodBeat.o(32527);
      return i;
    }
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
        paramVarArgs = new g.a.a.b("Not all required fields were included: UserName");
        AppMethodBeat.o(32527);
        throw paramVarArgs;
      }
      if (this.rWI == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: NickName");
        AppMethodBeat.o(32527);
        throw paramVarArgs;
      }
      if (this.lpy == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(32527);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32527);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fjg localfjg = (fjg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32527);
        return -1;
      case 1: 
        localfjg.CRP = locala.abFh.AK();
        AppMethodBeat.o(32527);
        return 0;
      case 2: 
        localfjg.UserName = locala.abFh.readString();
        AppMethodBeat.o(32527);
        return 0;
      case 3: 
        localfjg.rWI = locala.abFh.readString();
        AppMethodBeat.o(32527);
        return 0;
      case 4: 
        localfjg.lpy = locala.abFh.readString();
        AppMethodBeat.o(32527);
        return 0;
      }
      localfjg.UIy = locala.abFh.iUw();
      AppMethodBeat.o(32527);
      return 0;
    }
    AppMethodBeat.o(32527);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fjg
 * JD-Core Version:    0.7.0.1
 */