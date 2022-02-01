package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class bak
  extends com.tencent.mm.cd.a
{
  public String SEn;
  public b SHN;
  public boolean SKV;
  public String lqp;
  public String nickname;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231111);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.f(1, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.f(2, this.nickname);
      }
      if (this.lqp != null) {
        paramVarArgs.f(3, this.lqp);
      }
      if (this.SEn != null) {
        paramVarArgs.f(4, this.SEn);
      }
      if (this.SHN != null) {
        paramVarArgs.c(5, this.SHN);
      }
      paramVarArgs.co(6, this.SKV);
      AppMethodBeat.o(231111);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label498;
      }
    }
    label498:
    for (int i = g.a.a.b.b.a.g(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.nickname);
      }
      i = paramInt;
      if (this.lqp != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.lqp);
      }
      paramInt = i;
      if (this.SEn != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SEn);
      }
      i = paramInt;
      if (this.SHN != null) {
        i = paramInt + g.a.a.b.b.a.b(5, this.SHN);
      }
      paramInt = g.a.a.b.b.a.gL(6);
      AppMethodBeat.o(231111);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(231111);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bak localbak = (bak)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(231111);
          return -1;
        case 1: 
          localbak.username = locala.abFh.readString();
          AppMethodBeat.o(231111);
          return 0;
        case 2: 
          localbak.nickname = locala.abFh.readString();
          AppMethodBeat.o(231111);
          return 0;
        case 3: 
          localbak.lqp = locala.abFh.readString();
          AppMethodBeat.o(231111);
          return 0;
        case 4: 
          localbak.SEn = locala.abFh.readString();
          AppMethodBeat.o(231111);
          return 0;
        case 5: 
          localbak.SHN = locala.abFh.iUw();
          AppMethodBeat.o(231111);
          return 0;
        }
        localbak.SKV = locala.abFh.AB();
        AppMethodBeat.o(231111);
        return 0;
      }
      AppMethodBeat.o(231111);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bak
 * JD-Core Version:    0.7.0.1
 */