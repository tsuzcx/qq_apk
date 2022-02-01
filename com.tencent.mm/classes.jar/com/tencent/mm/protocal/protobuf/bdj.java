package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bdj
  extends com.tencent.mm.cd.a
{
  public long SOr;
  public int SOs;
  public String jDU;
  public String nickname;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231163);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.f(1, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.f(2, this.nickname);
      }
      if (this.jDU != null) {
        paramVarArgs.f(3, this.jDU);
      }
      paramVarArgs.bm(4, this.SOr);
      paramVarArgs.aY(5, this.SOs);
      AppMethodBeat.o(231163);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label426;
      }
    }
    label426:
    for (int i = g.a.a.b.b.a.g(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.nickname);
      }
      i = paramInt;
      if (this.jDU != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.jDU);
      }
      paramInt = g.a.a.b.b.a.p(4, this.SOr);
      int j = g.a.a.b.b.a.bM(5, this.SOs);
      AppMethodBeat.o(231163);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(231163);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bdj localbdj = (bdj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(231163);
          return -1;
        case 1: 
          localbdj.username = locala.abFh.readString();
          AppMethodBeat.o(231163);
          return 0;
        case 2: 
          localbdj.nickname = locala.abFh.readString();
          AppMethodBeat.o(231163);
          return 0;
        case 3: 
          localbdj.jDU = locala.abFh.readString();
          AppMethodBeat.o(231163);
          return 0;
        case 4: 
          localbdj.SOr = locala.abFh.AN();
          AppMethodBeat.o(231163);
          return 0;
        }
        localbdj.SOs = locala.abFh.AK();
        AppMethodBeat.o(231163);
        return 0;
      }
      AppMethodBeat.o(231163);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdj
 * JD-Core Version:    0.7.0.1
 */