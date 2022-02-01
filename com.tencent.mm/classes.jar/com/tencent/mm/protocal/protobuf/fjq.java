package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fjq
  extends com.tencent.mm.cd.a
{
  public int COi;
  public String Nickname;
  public long RMZ;
  public long RNj;
  public boolean UIL;
  public com.tencent.mm.cd.b UIM;
  public String Ueg;
  public String lpy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32539);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Nickname == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Nickname");
        AppMethodBeat.o(32539);
        throw paramVarArgs;
      }
      if (this.lpy == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(32539);
        throw paramVarArgs;
      }
      if (this.Ueg == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32539);
        throw paramVarArgs;
      }
      paramVarArgs.bm(1, this.RNj);
      if (this.Nickname != null) {
        paramVarArgs.f(2, this.Nickname);
      }
      if (this.lpy != null) {
        paramVarArgs.f(3, this.lpy);
      }
      paramVarArgs.aY(4, this.COi);
      if (this.Ueg != null) {
        paramVarArgs.f(5, this.Ueg);
      }
      paramVarArgs.bm(6, this.RMZ);
      paramVarArgs.co(7, this.UIL);
      if (this.UIM != null) {
        paramVarArgs.c(8, this.UIM);
      }
      AppMethodBeat.o(32539);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.RNj) + 0;
      paramInt = i;
      if (this.Nickname != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Nickname);
      }
      i = paramInt;
      if (this.lpy != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.lpy);
      }
      i += g.a.a.b.b.a.bM(4, this.COi);
      paramInt = i;
      if (this.Ueg != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Ueg);
      }
      i = paramInt + g.a.a.b.b.a.p(6, this.RMZ) + (g.a.a.b.b.a.gL(7) + 1);
      paramInt = i;
      if (this.UIM != null) {
        paramInt = i + g.a.a.b.b.a.b(8, this.UIM);
      }
      AppMethodBeat.o(32539);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.Nickname == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Nickname");
        AppMethodBeat.o(32539);
        throw paramVarArgs;
      }
      if (this.lpy == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(32539);
        throw paramVarArgs;
      }
      if (this.Ueg == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32539);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32539);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fjq localfjq = (fjq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32539);
        return -1;
      case 1: 
        localfjq.RNj = locala.abFh.AN();
        AppMethodBeat.o(32539);
        return 0;
      case 2: 
        localfjq.Nickname = locala.abFh.readString();
        AppMethodBeat.o(32539);
        return 0;
      case 3: 
        localfjq.lpy = locala.abFh.readString();
        AppMethodBeat.o(32539);
        return 0;
      case 4: 
        localfjq.COi = locala.abFh.AK();
        AppMethodBeat.o(32539);
        return 0;
      case 5: 
        localfjq.Ueg = locala.abFh.readString();
        AppMethodBeat.o(32539);
        return 0;
      case 6: 
        localfjq.RMZ = locala.abFh.AN();
        AppMethodBeat.o(32539);
        return 0;
      case 7: 
        localfjq.UIL = locala.abFh.AB();
        AppMethodBeat.o(32539);
        return 0;
      }
      localfjq.UIM = locala.abFh.iUw();
      AppMethodBeat.o(32539);
      return 0;
    }
    AppMethodBeat.o(32539);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fjq
 * JD-Core Version:    0.7.0.1
 */