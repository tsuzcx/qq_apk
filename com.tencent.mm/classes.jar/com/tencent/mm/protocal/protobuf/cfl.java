package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cfl
  extends com.tencent.mm.bw.a
{
  public String Cqk;
  public int action;
  public String dQx;
  public String url;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72510);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dQx != null) {
        paramVarArgs.e(1, this.dQx);
      }
      paramVarArgs.aM(2, this.action);
      if (this.url != null) {
        paramVarArgs.e(3, this.url);
      }
      if (this.username != null) {
        paramVarArgs.e(4, this.username);
      }
      if (this.Cqk != null) {
        paramVarArgs.e(5, this.Cqk);
      }
      AppMethodBeat.o(72510);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dQx == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = g.a.a.b.b.a.f(1, this.dQx) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.action);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.url);
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.username);
      }
      paramInt = i;
      if (this.Cqk != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.Cqk);
      }
      AppMethodBeat.o(72510);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72510);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cfl localcfl = (cfl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72510);
          return -1;
        case 1: 
          localcfl.dQx = locala.UbS.readString();
          AppMethodBeat.o(72510);
          return 0;
        case 2: 
          localcfl.action = locala.UbS.zi();
          AppMethodBeat.o(72510);
          return 0;
        case 3: 
          localcfl.url = locala.UbS.readString();
          AppMethodBeat.o(72510);
          return 0;
        case 4: 
          localcfl.username = locala.UbS.readString();
          AppMethodBeat.o(72510);
          return 0;
        }
        localcfl.Cqk = locala.UbS.readString();
        AppMethodBeat.o(72510);
        return 0;
      }
      AppMethodBeat.o(72510);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfl
 * JD-Core Version:    0.7.0.1
 */