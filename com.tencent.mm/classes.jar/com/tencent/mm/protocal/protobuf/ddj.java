package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ddj
  extends com.tencent.mm.cd.a
{
  public int TLg;
  public String desc;
  public String qDz;
  public String scope;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82463);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.scope != null) {
        paramVarArgs.f(1, this.scope);
      }
      if (this.desc != null) {
        paramVarArgs.f(2, this.desc);
      }
      paramVarArgs.aY(3, this.TLg);
      if (this.qDz != null) {
        paramVarArgs.f(4, this.qDz);
      }
      AppMethodBeat.o(82463);
      return 0;
    }
    if (paramInt == 1) {
      if (this.scope == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = g.a.a.b.b.a.g(1, this.scope) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.desc != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.desc);
      }
      i += g.a.a.b.b.a.bM(3, this.TLg);
      paramInt = i;
      if (this.qDz != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.qDz);
      }
      AppMethodBeat.o(82463);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(82463);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ddj localddj = (ddj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82463);
          return -1;
        case 1: 
          localddj.scope = locala.abFh.readString();
          AppMethodBeat.o(82463);
          return 0;
        case 2: 
          localddj.desc = locala.abFh.readString();
          AppMethodBeat.o(82463);
          return 0;
        case 3: 
          localddj.TLg = locala.abFh.AK();
          AppMethodBeat.o(82463);
          return 0;
        }
        localddj.qDz = locala.abFh.readString();
        AppMethodBeat.o(82463);
        return 0;
      }
      AppMethodBeat.o(82463);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddj
 * JD-Core Version:    0.7.0.1
 */