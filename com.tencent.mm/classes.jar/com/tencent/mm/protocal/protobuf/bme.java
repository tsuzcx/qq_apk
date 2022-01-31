package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bme
  extends com.tencent.mm.bv.a
{
  public String poq;
  public String xAA;
  public String xAB;
  public String xAC;
  public String xAD;
  public boolean xAE;
  public String xAF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48921);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xAA != null) {
        paramVarArgs.e(1, this.xAA);
      }
      if (this.xAB != null) {
        paramVarArgs.e(2, this.xAB);
      }
      if (this.poq != null) {
        paramVarArgs.e(3, this.poq);
      }
      if (this.xAC != null) {
        paramVarArgs.e(4, this.xAC);
      }
      if (this.xAD != null) {
        paramVarArgs.e(5, this.xAD);
      }
      paramVarArgs.aS(6, this.xAE);
      if (this.xAF != null) {
        paramVarArgs.e(7, this.xAF);
      }
      AppMethodBeat.o(48921);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xAA == null) {
        break label562;
      }
    }
    label562:
    for (int i = e.a.a.b.b.a.f(1, this.xAA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xAB != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xAB);
      }
      i = paramInt;
      if (this.poq != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.poq);
      }
      paramInt = i;
      if (this.xAC != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xAC);
      }
      i = paramInt;
      if (this.xAD != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xAD);
      }
      i += e.a.a.b.b.a.eW(6) + 1;
      paramInt = i;
      if (this.xAF != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.xAF);
      }
      AppMethodBeat.o(48921);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48921);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bme localbme = (bme)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(48921);
          return -1;
        case 1: 
          localbme.xAA = locala.CLY.readString();
          AppMethodBeat.o(48921);
          return 0;
        case 2: 
          localbme.xAB = locala.CLY.readString();
          AppMethodBeat.o(48921);
          return 0;
        case 3: 
          localbme.poq = locala.CLY.readString();
          AppMethodBeat.o(48921);
          return 0;
        case 4: 
          localbme.xAC = locala.CLY.readString();
          AppMethodBeat.o(48921);
          return 0;
        case 5: 
          localbme.xAD = locala.CLY.readString();
          AppMethodBeat.o(48921);
          return 0;
        case 6: 
          localbme.xAE = locala.CLY.emu();
          AppMethodBeat.o(48921);
          return 0;
        }
        localbme.xAF = locala.CLY.readString();
        AppMethodBeat.o(48921);
        return 0;
      }
      AppMethodBeat.o(48921);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bme
 * JD-Core Version:    0.7.0.1
 */