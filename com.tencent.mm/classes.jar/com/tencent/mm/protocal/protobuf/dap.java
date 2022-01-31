package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dap
  extends com.tencent.mm.bv.a
{
  public String path;
  public String username;
  public int wAy;
  public String xuE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96342);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      if (this.xuE != null) {
        paramVarArgs.e(2, this.xuE);
      }
      paramVarArgs.aO(3, this.wAy);
      if (this.path != null) {
        paramVarArgs.e(4, this.path);
      }
      AppMethodBeat.o(96342);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = e.a.a.b.b.a.f(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xuE != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.xuE);
      }
      i += e.a.a.b.b.a.bl(3, this.wAy);
      paramInt = i;
      if (this.path != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.path);
      }
      AppMethodBeat.o(96342);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(96342);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        dap localdap = (dap)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(96342);
          return -1;
        case 1: 
          localdap.username = locala.CLY.readString();
          AppMethodBeat.o(96342);
          return 0;
        case 2: 
          localdap.xuE = locala.CLY.readString();
          AppMethodBeat.o(96342);
          return 0;
        case 3: 
          localdap.wAy = locala.CLY.sl();
          AppMethodBeat.o(96342);
          return 0;
        }
        localdap.path = locala.CLY.readString();
        AppMethodBeat.o(96342);
        return 0;
      }
      AppMethodBeat.o(96342);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dap
 * JD-Core Version:    0.7.0.1
 */