package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cmq
  extends com.tencent.mm.cd.a
{
  public int RMr;
  public String Tug;
  public String auth_desc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82432);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Tug != null) {
        paramVarArgs.f(1, this.Tug);
      }
      paramVarArgs.aY(2, this.RMr);
      if (this.auth_desc != null) {
        paramVarArgs.f(3, this.auth_desc);
      }
      AppMethodBeat.o(82432);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Tug == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.g(1, this.Tug) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.RMr);
      paramInt = i;
      if (this.auth_desc != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.auth_desc);
      }
      AppMethodBeat.o(82432);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(82432);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cmq localcmq = (cmq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82432);
          return -1;
        case 1: 
          localcmq.Tug = locala.abFh.readString();
          AppMethodBeat.o(82432);
          return 0;
        case 2: 
          localcmq.RMr = locala.abFh.AK();
          AppMethodBeat.o(82432);
          return 0;
        }
        localcmq.auth_desc = locala.abFh.readString();
        AppMethodBeat.o(82432);
        return 0;
      }
      AppMethodBeat.o(82432);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmq
 * JD-Core Version:    0.7.0.1
 */