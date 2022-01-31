package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aut
  extends com.tencent.mm.bv.a
{
  public String xjU;
  public String xjV;
  public String xjW;
  public String xjX;
  public String xjY;
  public String xjZ;
  public String xka;
  public String xkb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56844);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xjU != null) {
        paramVarArgs.e(1, this.xjU);
      }
      if (this.xjV != null) {
        paramVarArgs.e(2, this.xjV);
      }
      if (this.xjW != null) {
        paramVarArgs.e(3, this.xjW);
      }
      if (this.xjX != null) {
        paramVarArgs.e(4, this.xjX);
      }
      if (this.xjY != null) {
        paramVarArgs.e(5, this.xjY);
      }
      if (this.xjZ != null) {
        paramVarArgs.e(6, this.xjZ);
      }
      if (this.xka != null) {
        paramVarArgs.e(7, this.xka);
      }
      if (this.xkb != null) {
        paramVarArgs.e(8, this.xkb);
      }
      AppMethodBeat.o(56844);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xjU == null) {
        break label642;
      }
    }
    label642:
    for (int i = e.a.a.b.b.a.f(1, this.xjU) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xjV != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xjV);
      }
      i = paramInt;
      if (this.xjW != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xjW);
      }
      paramInt = i;
      if (this.xjX != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xjX);
      }
      i = paramInt;
      if (this.xjY != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xjY);
      }
      paramInt = i;
      if (this.xjZ != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xjZ);
      }
      i = paramInt;
      if (this.xka != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.xka);
      }
      paramInt = i;
      if (this.xkb != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.xkb);
      }
      AppMethodBeat.o(56844);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56844);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        aut localaut = (aut)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56844);
          return -1;
        case 1: 
          localaut.xjU = locala.CLY.readString();
          AppMethodBeat.o(56844);
          return 0;
        case 2: 
          localaut.xjV = locala.CLY.readString();
          AppMethodBeat.o(56844);
          return 0;
        case 3: 
          localaut.xjW = locala.CLY.readString();
          AppMethodBeat.o(56844);
          return 0;
        case 4: 
          localaut.xjX = locala.CLY.readString();
          AppMethodBeat.o(56844);
          return 0;
        case 5: 
          localaut.xjY = locala.CLY.readString();
          AppMethodBeat.o(56844);
          return 0;
        case 6: 
          localaut.xjZ = locala.CLY.readString();
          AppMethodBeat.o(56844);
          return 0;
        case 7: 
          localaut.xka = locala.CLY.readString();
          AppMethodBeat.o(56844);
          return 0;
        }
        localaut.xkb = locala.CLY.readString();
        AppMethodBeat.o(56844);
        return 0;
      }
      AppMethodBeat.o(56844);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aut
 * JD-Core Version:    0.7.0.1
 */