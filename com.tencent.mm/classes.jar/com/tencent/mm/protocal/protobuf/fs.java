package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fs
  extends com.tencent.mm.bv.a
{
  public String scope;
  public int state;
  public String wrI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(102369);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.scope != null) {
        paramVarArgs.e(1, this.scope);
      }
      if (this.wrI != null) {
        paramVarArgs.e(2, this.wrI);
      }
      paramVarArgs.aO(3, this.state);
      AppMethodBeat.o(102369);
      return 0;
    }
    if (paramInt == 1) {
      if (this.scope == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = e.a.a.b.b.a.f(1, this.scope) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wrI != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.wrI);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.state);
      AppMethodBeat.o(102369);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(102369);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        fs localfs = (fs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(102369);
          return -1;
        case 1: 
          localfs.scope = locala.CLY.readString();
          AppMethodBeat.o(102369);
          return 0;
        case 2: 
          localfs.wrI = locala.CLY.readString();
          AppMethodBeat.o(102369);
          return 0;
        }
        localfs.state = locala.CLY.sl();
        AppMethodBeat.o(102369);
        return 0;
      }
      AppMethodBeat.o(102369);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fs
 * JD-Core Version:    0.7.0.1
 */