package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cuh
  extends com.tencent.mm.bw.a
{
  public int MzA;
  public String desc;
  public String nBo;
  public String scope;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82463);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.scope != null) {
        paramVarArgs.e(1, this.scope);
      }
      if (this.desc != null) {
        paramVarArgs.e(2, this.desc);
      }
      paramVarArgs.aM(3, this.MzA);
      if (this.nBo != null) {
        paramVarArgs.e(4, this.nBo);
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
    for (paramInt = g.a.a.b.b.a.f(1, this.scope) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.desc != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.desc);
      }
      i += g.a.a.b.b.a.bu(3, this.MzA);
      paramInt = i;
      if (this.nBo != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.nBo);
      }
      AppMethodBeat.o(82463);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(82463);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cuh localcuh = (cuh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82463);
          return -1;
        case 1: 
          localcuh.scope = locala.UbS.readString();
          AppMethodBeat.o(82463);
          return 0;
        case 2: 
          localcuh.desc = locala.UbS.readString();
          AppMethodBeat.o(82463);
          return 0;
        case 3: 
          localcuh.MzA = locala.UbS.zi();
          AppMethodBeat.o(82463);
          return 0;
        }
        localcuh.nBo = locala.UbS.readString();
        AppMethodBeat.o(82463);
        return 0;
      }
      AppMethodBeat.o(82463);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuh
 * JD-Core Version:    0.7.0.1
 */