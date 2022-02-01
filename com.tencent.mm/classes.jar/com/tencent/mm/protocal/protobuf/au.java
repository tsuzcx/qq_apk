package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class au
  extends com.tencent.mm.cd.a
{
  public String tpe;
  public String tpf;
  public String tpg;
  public String tph;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113931);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.tpe != null) {
        paramVarArgs.f(1, this.tpe);
      }
      if (this.tpf != null) {
        paramVarArgs.f(2, this.tpf);
      }
      if (this.tpg != null) {
        paramVarArgs.f(3, this.tpg);
      }
      if (this.tph != null) {
        paramVarArgs.f(4, this.tph);
      }
      AppMethodBeat.o(113931);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tpe == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.g(1, this.tpe) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tpf != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.tpf);
      }
      i = paramInt;
      if (this.tpg != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.tpg);
      }
      paramInt = i;
      if (this.tph != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.tph);
      }
      AppMethodBeat.o(113931);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(113931);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        au localau = (au)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113931);
          return -1;
        case 1: 
          localau.tpe = locala.abFh.readString();
          AppMethodBeat.o(113931);
          return 0;
        case 2: 
          localau.tpf = locala.abFh.readString();
          AppMethodBeat.o(113931);
          return 0;
        case 3: 
          localau.tpg = locala.abFh.readString();
          AppMethodBeat.o(113931);
          return 0;
        }
        localau.tph = locala.abFh.readString();
        AppMethodBeat.o(113931);
        return 0;
      }
      AppMethodBeat.o(113931);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.au
 * JD-Core Version:    0.7.0.1
 */