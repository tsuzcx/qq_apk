package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bdl
  extends com.tencent.mm.bv.a
{
  public int gwP;
  public String gwQ;
  public String gwR;
  public String gwS;
  public String gwY;
  public String jJA;
  public int jKs;
  public String wJq;
  public String wJr;
  public int xtk;
  public int xtl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28551);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.jJA != null) {
        paramVarArgs.e(1, this.jJA);
      }
      paramVarArgs.aO(2, this.jKs);
      paramVarArgs.aO(3, this.gwP);
      if (this.gwR != null) {
        paramVarArgs.e(4, this.gwR);
      }
      if (this.gwQ != null) {
        paramVarArgs.e(5, this.gwQ);
      }
      if (this.gwS != null) {
        paramVarArgs.e(6, this.gwS);
      }
      paramVarArgs.aO(7, this.xtk);
      paramVarArgs.aO(8, this.xtl);
      if (this.gwY != null) {
        paramVarArgs.e(9, this.gwY);
      }
      if (this.wJq != null) {
        paramVarArgs.e(10, this.wJq);
      }
      if (this.wJr != null) {
        paramVarArgs.e(11, this.wJr);
      }
      AppMethodBeat.o(28551);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jJA == null) {
        break label775;
      }
    }
    label775:
    for (paramInt = e.a.a.b.b.a.f(1, this.jJA) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.jKs) + e.a.a.b.b.a.bl(3, this.gwP);
      paramInt = i;
      if (this.gwR != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.gwR);
      }
      i = paramInt;
      if (this.gwQ != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.gwQ);
      }
      paramInt = i;
      if (this.gwS != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.gwS);
      }
      i = paramInt + e.a.a.b.b.a.bl(7, this.xtk) + e.a.a.b.b.a.bl(8, this.xtl);
      paramInt = i;
      if (this.gwY != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.gwY);
      }
      i = paramInt;
      if (this.wJq != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.wJq);
      }
      paramInt = i;
      if (this.wJr != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.wJr);
      }
      AppMethodBeat.o(28551);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28551);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bdl localbdl = (bdl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28551);
          return -1;
        case 1: 
          localbdl.jJA = locala.CLY.readString();
          AppMethodBeat.o(28551);
          return 0;
        case 2: 
          localbdl.jKs = locala.CLY.sl();
          AppMethodBeat.o(28551);
          return 0;
        case 3: 
          localbdl.gwP = locala.CLY.sl();
          AppMethodBeat.o(28551);
          return 0;
        case 4: 
          localbdl.gwR = locala.CLY.readString();
          AppMethodBeat.o(28551);
          return 0;
        case 5: 
          localbdl.gwQ = locala.CLY.readString();
          AppMethodBeat.o(28551);
          return 0;
        case 6: 
          localbdl.gwS = locala.CLY.readString();
          AppMethodBeat.o(28551);
          return 0;
        case 7: 
          localbdl.xtk = locala.CLY.sl();
          AppMethodBeat.o(28551);
          return 0;
        case 8: 
          localbdl.xtl = locala.CLY.sl();
          AppMethodBeat.o(28551);
          return 0;
        case 9: 
          localbdl.gwY = locala.CLY.readString();
          AppMethodBeat.o(28551);
          return 0;
        case 10: 
          localbdl.wJq = locala.CLY.readString();
          AppMethodBeat.o(28551);
          return 0;
        }
        localbdl.wJr = locala.CLY.readString();
        AppMethodBeat.o(28551);
        return 0;
      }
      AppMethodBeat.o(28551);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdl
 * JD-Core Version:    0.7.0.1
 */