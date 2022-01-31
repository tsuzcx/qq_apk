package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bfk
  extends com.tencent.mm.bv.a
{
  public String Desc;
  public String Title;
  public String jJA;
  public long pIG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118281);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.e(2, this.Desc);
      }
      if (this.jJA != null) {
        paramVarArgs.e(3, this.jJA);
      }
      paramVarArgs.am(4, this.pIG);
      AppMethodBeat.o(118281);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label378;
      }
    }
    label378:
    for (int i = e.a.a.b.b.a.f(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.Desc);
      }
      i = paramInt;
      if (this.jJA != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.jJA);
      }
      paramInt = e.a.a.b.b.a.p(4, this.pIG);
      AppMethodBeat.o(118281);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(118281);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bfk localbfk = (bfk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(118281);
          return -1;
        case 1: 
          localbfk.Title = locala.CLY.readString();
          AppMethodBeat.o(118281);
          return 0;
        case 2: 
          localbfk.Desc = locala.CLY.readString();
          AppMethodBeat.o(118281);
          return 0;
        case 3: 
          localbfk.jJA = locala.CLY.readString();
          AppMethodBeat.o(118281);
          return 0;
        }
        localbfk.pIG = locala.CLY.sm();
        AppMethodBeat.o(118281);
        return 0;
      }
      AppMethodBeat.o(118281);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfk
 * JD-Core Version:    0.7.0.1
 */