package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bai
  extends com.tencent.mm.bv.a
{
  public String jJA;
  public int jJS;
  public String jKG;
  public String qsu;
  public String wJq;
  public String wJr;
  public String wYu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(73732);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.qsu != null) {
        paramVarArgs.e(1, this.qsu);
      }
      if (this.jJA != null) {
        paramVarArgs.e(2, this.jJA);
      }
      paramVarArgs.aO(3, this.jJS);
      if (this.wJq != null) {
        paramVarArgs.e(4, this.wJq);
      }
      if (this.wJr != null) {
        paramVarArgs.e(5, this.wJr);
      }
      if (this.jKG != null) {
        paramVarArgs.e(6, this.jKG);
      }
      if (this.wYu != null) {
        paramVarArgs.e(7, this.wYu);
      }
      AppMethodBeat.o(73732);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qsu == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = e.a.a.b.b.a.f(1, this.qsu) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.jJA != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.jJA);
      }
      i += e.a.a.b.b.a.bl(3, this.jJS);
      paramInt = i;
      if (this.wJq != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wJq);
      }
      i = paramInt;
      if (this.wJr != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wJr);
      }
      paramInt = i;
      if (this.jKG != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.jKG);
      }
      i = paramInt;
      if (this.wYu != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.wYu);
      }
      AppMethodBeat.o(73732);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(73732);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bai localbai = (bai)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(73732);
          return -1;
        case 1: 
          localbai.qsu = locala.CLY.readString();
          AppMethodBeat.o(73732);
          return 0;
        case 2: 
          localbai.jJA = locala.CLY.readString();
          AppMethodBeat.o(73732);
          return 0;
        case 3: 
          localbai.jJS = locala.CLY.sl();
          AppMethodBeat.o(73732);
          return 0;
        case 4: 
          localbai.wJq = locala.CLY.readString();
          AppMethodBeat.o(73732);
          return 0;
        case 5: 
          localbai.wJr = locala.CLY.readString();
          AppMethodBeat.o(73732);
          return 0;
        case 6: 
          localbai.jKG = locala.CLY.readString();
          AppMethodBeat.o(73732);
          return 0;
        }
        localbai.wYu = locala.CLY.readString();
        AppMethodBeat.o(73732);
        return 0;
      }
      AppMethodBeat.o(73732);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bai
 * JD-Core Version:    0.7.0.1
 */