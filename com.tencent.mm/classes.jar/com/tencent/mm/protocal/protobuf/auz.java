package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class auz
  extends com.tencent.mm.bv.a
{
  public String dataPath;
  public String value;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152444);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.value != null) {
        paramVarArgs.e(1, this.value);
      }
      if (this.dataPath != null) {
        paramVarArgs.e(2, this.dataPath);
      }
      AppMethodBeat.o(152444);
      return 0;
    }
    if (paramInt == 1) {
      if (this.value == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = e.a.a.b.b.a.f(1, this.value) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dataPath != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.dataPath);
      }
      AppMethodBeat.o(152444);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(152444);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        auz localauz = (auz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152444);
          return -1;
        case 1: 
          localauz.value = locala.CLY.readString();
          AppMethodBeat.o(152444);
          return 0;
        }
        localauz.dataPath = locala.CLY.readString();
        AppMethodBeat.o(152444);
        return 0;
      }
      AppMethodBeat.o(152444);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auz
 * JD-Core Version:    0.7.0.1
 */