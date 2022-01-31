package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class azx
  extends com.tencent.mm.bv.a
{
  public String jJA;
  public String jKG;
  public String wJq;
  public String wJr;
  public String wYu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118275);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.jJA != null) {
        paramVarArgs.e(1, this.jJA);
      }
      if (this.jKG != null) {
        paramVarArgs.e(2, this.jKG);
      }
      if (this.wJq != null) {
        paramVarArgs.e(3, this.wJq);
      }
      if (this.wJr != null) {
        paramVarArgs.e(4, this.wJr);
      }
      if (this.wYu != null) {
        paramVarArgs.e(5, this.wYu);
      }
      AppMethodBeat.o(118275);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jJA == null) {
        break label454;
      }
    }
    label454:
    for (int i = e.a.a.b.b.a.f(1, this.jJA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jKG != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.jKG);
      }
      i = paramInt;
      if (this.wJq != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wJq);
      }
      paramInt = i;
      if (this.wJr != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wJr);
      }
      i = paramInt;
      if (this.wYu != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wYu);
      }
      AppMethodBeat.o(118275);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(118275);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        azx localazx = (azx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(118275);
          return -1;
        case 1: 
          localazx.jJA = locala.CLY.readString();
          AppMethodBeat.o(118275);
          return 0;
        case 2: 
          localazx.jKG = locala.CLY.readString();
          AppMethodBeat.o(118275);
          return 0;
        case 3: 
          localazx.wJq = locala.CLY.readString();
          AppMethodBeat.o(118275);
          return 0;
        case 4: 
          localazx.wJr = locala.CLY.readString();
          AppMethodBeat.o(118275);
          return 0;
        }
        localazx.wYu = locala.CLY.readString();
        AppMethodBeat.o(118275);
        return 0;
      }
      AppMethodBeat.o(118275);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azx
 * JD-Core Version:    0.7.0.1
 */