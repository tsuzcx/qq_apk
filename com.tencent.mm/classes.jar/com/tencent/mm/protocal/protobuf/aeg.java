package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aeg
  extends com.tencent.mm.bv.a
{
  public String jJA;
  public String jKG;
  public String nqE;
  public String wKX;
  public String wXi;
  public String wXj;
  public String wXk;
  public int wkZ;
  public String woB;
  public String wvC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28414);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.woB != null) {
        paramVarArgs.e(1, this.woB);
      }
      if (this.jKG != null) {
        paramVarArgs.e(2, this.jKG);
      }
      if (this.jJA != null) {
        paramVarArgs.e(3, this.jJA);
      }
      if (this.nqE != null) {
        paramVarArgs.e(4, this.nqE);
      }
      if (this.wXi != null) {
        paramVarArgs.e(5, this.wXi);
      }
      if (this.wXj != null) {
        paramVarArgs.e(6, this.wXj);
      }
      if (this.wvC != null) {
        paramVarArgs.e(7, this.wvC);
      }
      if (this.wKX != null) {
        paramVarArgs.e(8, this.wKX);
      }
      if (this.wXk != null) {
        paramVarArgs.e(9, this.wXk);
      }
      paramVarArgs.aO(10, this.wkZ);
      AppMethodBeat.o(28414);
      return 0;
    }
    if (paramInt == 1) {
      if (this.woB == null) {
        break label766;
      }
    }
    label766:
    for (int i = e.a.a.b.b.a.f(1, this.woB) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jKG != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.jKG);
      }
      i = paramInt;
      if (this.jJA != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.jJA);
      }
      paramInt = i;
      if (this.nqE != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.nqE);
      }
      i = paramInt;
      if (this.wXi != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wXi);
      }
      paramInt = i;
      if (this.wXj != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wXj);
      }
      i = paramInt;
      if (this.wvC != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.wvC);
      }
      paramInt = i;
      if (this.wKX != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wKX);
      }
      i = paramInt;
      if (this.wXk != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.wXk);
      }
      paramInt = e.a.a.b.b.a.bl(10, this.wkZ);
      AppMethodBeat.o(28414);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28414);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        aeg localaeg = (aeg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28414);
          return -1;
        case 1: 
          localaeg.woB = locala.CLY.readString();
          AppMethodBeat.o(28414);
          return 0;
        case 2: 
          localaeg.jKG = locala.CLY.readString();
          AppMethodBeat.o(28414);
          return 0;
        case 3: 
          localaeg.jJA = locala.CLY.readString();
          AppMethodBeat.o(28414);
          return 0;
        case 4: 
          localaeg.nqE = locala.CLY.readString();
          AppMethodBeat.o(28414);
          return 0;
        case 5: 
          localaeg.wXi = locala.CLY.readString();
          AppMethodBeat.o(28414);
          return 0;
        case 6: 
          localaeg.wXj = locala.CLY.readString();
          AppMethodBeat.o(28414);
          return 0;
        case 7: 
          localaeg.wvC = locala.CLY.readString();
          AppMethodBeat.o(28414);
          return 0;
        case 8: 
          localaeg.wKX = locala.CLY.readString();
          AppMethodBeat.o(28414);
          return 0;
        case 9: 
          localaeg.wXk = locala.CLY.readString();
          AppMethodBeat.o(28414);
          return 0;
        }
        localaeg.wkZ = locala.CLY.sl();
        AppMethodBeat.o(28414);
        return 0;
      }
      AppMethodBeat.o(28414);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aeg
 * JD-Core Version:    0.7.0.1
 */