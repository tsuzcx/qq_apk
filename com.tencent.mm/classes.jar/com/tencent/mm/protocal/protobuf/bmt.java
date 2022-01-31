package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bmt
  extends com.tencent.mm.bv.a
{
  public String gwR;
  public String gwY;
  public float wDh;
  public float wDi;
  public String xBc;
  public String xBd;
  public long xBe;
  public String xlb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124333);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xBc != null) {
        paramVarArgs.e(1, this.xBc);
      }
      if (this.gwY != null) {
        paramVarArgs.e(2, this.gwY);
      }
      if (this.gwR != null) {
        paramVarArgs.e(3, this.gwR);
      }
      if (this.xlb != null) {
        paramVarArgs.e(4, this.xlb);
      }
      paramVarArgs.q(5, this.wDi);
      paramVarArgs.q(6, this.wDh);
      if (this.xBd != null) {
        paramVarArgs.e(7, this.xBd);
      }
      paramVarArgs.am(8, this.xBe);
      AppMethodBeat.o(124333);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xBc == null) {
        break label592;
      }
    }
    label592:
    for (int i = e.a.a.b.b.a.f(1, this.xBc) + 0;; i = 0)
    {
      paramInt = i;
      if (this.gwY != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.gwY);
      }
      i = paramInt;
      if (this.gwR != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.gwR);
      }
      paramInt = i;
      if (this.xlb != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xlb);
      }
      i = paramInt + (e.a.a.b.b.a.eW(5) + 4) + (e.a.a.b.b.a.eW(6) + 4);
      paramInt = i;
      if (this.xBd != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.xBd);
      }
      i = e.a.a.b.b.a.p(8, this.xBe);
      AppMethodBeat.o(124333);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(124333);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bmt localbmt = (bmt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124333);
          return -1;
        case 1: 
          localbmt.xBc = locala.CLY.readString();
          AppMethodBeat.o(124333);
          return 0;
        case 2: 
          localbmt.gwY = locala.CLY.readString();
          AppMethodBeat.o(124333);
          return 0;
        case 3: 
          localbmt.gwR = locala.CLY.readString();
          AppMethodBeat.o(124333);
          return 0;
        case 4: 
          localbmt.xlb = locala.CLY.readString();
          AppMethodBeat.o(124333);
          return 0;
        case 5: 
          localbmt.wDi = Float.intBitsToFloat(locala.CLY.emx());
          AppMethodBeat.o(124333);
          return 0;
        case 6: 
          localbmt.wDh = Float.intBitsToFloat(locala.CLY.emx());
          AppMethodBeat.o(124333);
          return 0;
        case 7: 
          localbmt.xBd = locala.CLY.readString();
          AppMethodBeat.o(124333);
          return 0;
        }
        localbmt.xBe = locala.CLY.sm();
        AppMethodBeat.o(124333);
        return 0;
      }
      AppMethodBeat.o(124333);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmt
 * JD-Core Version:    0.7.0.1
 */