package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class go
  extends com.tencent.mm.bv.a
{
  public int csV;
  public String data;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114950);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      if (this.data != null) {
        paramVarArgs.e(2, this.data);
      }
      paramVarArgs.aO(3, this.csV);
      AppMethodBeat.o(114950);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = e.a.a.b.b.a.f(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.data != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.data);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.csV);
      AppMethodBeat.o(114950);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(114950);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        go localgo = (go)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(114950);
          return -1;
        case 1: 
          localgo.username = locala.CLY.readString();
          AppMethodBeat.o(114950);
          return 0;
        case 2: 
          localgo.data = locala.CLY.readString();
          AppMethodBeat.o(114950);
          return 0;
        }
        localgo.csV = locala.CLY.sl();
        AppMethodBeat.o(114950);
        return 0;
      }
      AppMethodBeat.o(114950);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.go
 * JD-Core Version:    0.7.0.1
 */