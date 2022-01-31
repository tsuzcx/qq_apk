package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cgj
  extends com.tencent.mm.bv.a
{
  public String Name;
  public String xRe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80190);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Name != null) {
        paramVarArgs.e(1, this.Name);
      }
      if (this.xRe != null) {
        paramVarArgs.e(2, this.xRe);
      }
      AppMethodBeat.o(80190);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Name == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = e.a.a.b.b.a.f(1, this.Name) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xRe != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.xRe);
      }
      AppMethodBeat.o(80190);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(80190);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cgj localcgj = (cgj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(80190);
          return -1;
        case 1: 
          localcgj.Name = locala.CLY.readString();
          AppMethodBeat.o(80190);
          return 0;
        }
        localcgj.xRe = locala.CLY.readString();
        AppMethodBeat.o(80190);
        return 0;
      }
      AppMethodBeat.o(80190);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgj
 * JD-Core Version:    0.7.0.1
 */