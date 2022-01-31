package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class boy
  extends com.tencent.mm.bv.a
{
  public String jJA;
  public String wJp;
  public int wNX;
  public int xDb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28596);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.jJA != null) {
        paramVarArgs.e(1, this.jJA);
      }
      if (this.wJp != null) {
        paramVarArgs.e(2, this.wJp);
      }
      paramVarArgs.aO(3, this.xDb);
      paramVarArgs.aO(4, this.wNX);
      AppMethodBeat.o(28596);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jJA == null) {
        break label376;
      }
    }
    label376:
    for (paramInt = e.a.a.b.b.a.f(1, this.jJA) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wJp != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.wJp);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.xDb);
      int j = e.a.a.b.b.a.bl(4, this.wNX);
      AppMethodBeat.o(28596);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28596);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        boy localboy = (boy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28596);
          return -1;
        case 1: 
          localboy.jJA = locala.CLY.readString();
          AppMethodBeat.o(28596);
          return 0;
        case 2: 
          localboy.wJp = locala.CLY.readString();
          AppMethodBeat.o(28596);
          return 0;
        case 3: 
          localboy.xDb = locala.CLY.sl();
          AppMethodBeat.o(28596);
          return 0;
        }
        localboy.wNX = locala.CLY.sl();
        AppMethodBeat.o(28596);
        return 0;
      }
      AppMethodBeat.o(28596);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boy
 * JD-Core Version:    0.7.0.1
 */