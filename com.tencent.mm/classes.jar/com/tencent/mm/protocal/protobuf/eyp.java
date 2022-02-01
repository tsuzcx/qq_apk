package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eyp
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b Nvo;
  public String UserName;
  public String iAc;
  public String oUJ;
  public int xNF;
  
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
      if (this.oUJ == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: NickName");
        AppMethodBeat.o(32527);
        throw paramVarArgs;
      }
      if (this.iAc == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(32527);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.xNF);
      if (this.UserName != null) {
        paramVarArgs.e(2, this.UserName);
      }
      if (this.oUJ != null) {
        paramVarArgs.e(3, this.oUJ);
      }
      if (this.iAc != null) {
        paramVarArgs.e(4, this.iAc);
      }
      if (this.Nvo != null) {
        paramVarArgs.c(5, this.Nvo);
      }
      AppMethodBeat.o(32527);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.xNF) + 0;
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.UserName);
      }
      i = paramInt;
      if (this.oUJ != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.oUJ);
      }
      paramInt = i;
      if (this.iAc != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.iAc);
      }
      i = paramInt;
      if (this.Nvo != null) {
        i = paramInt + g.a.a.b.b.a.b(5, this.Nvo);
      }
      AppMethodBeat.o(32527);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.UserName == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: UserName");
        AppMethodBeat.o(32527);
        throw paramVarArgs;
      }
      if (this.oUJ == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: NickName");
        AppMethodBeat.o(32527);
        throw paramVarArgs;
      }
      if (this.iAc == null)
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
      eyp localeyp = (eyp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32527);
        return -1;
      case 1: 
        localeyp.xNF = locala.UbS.zi();
        AppMethodBeat.o(32527);
        return 0;
      case 2: 
        localeyp.UserName = locala.UbS.readString();
        AppMethodBeat.o(32527);
        return 0;
      case 3: 
        localeyp.oUJ = locala.UbS.readString();
        AppMethodBeat.o(32527);
        return 0;
      case 4: 
        localeyp.iAc = locala.UbS.readString();
        AppMethodBeat.o(32527);
        return 0;
      }
      localeyp.Nvo = locala.UbS.hPo();
      AppMethodBeat.o(32527);
      return 0;
    }
    AppMethodBeat.o(32527);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eyp
 * JD-Core Version:    0.7.0.1
 */