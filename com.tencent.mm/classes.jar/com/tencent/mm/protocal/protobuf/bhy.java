package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bhy
  extends com.tencent.mm.bv.a
{
  public String aOg;
  public String cAr;
  public String kqd;
  public String xxb;
  public String xxc;
  public int xxd;
  public String xxe;
  public String xxf;
  public String xxg;
  public int xxh;
  public int xxi;
  public int xxj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80126);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.aOg != null) {
        paramVarArgs.e(1, this.aOg);
      }
      if (this.xxb != null) {
        paramVarArgs.e(2, this.xxb);
      }
      if (this.xxc != null) {
        paramVarArgs.e(3, this.xxc);
      }
      paramVarArgs.aO(4, this.xxd);
      if (this.cAr != null) {
        paramVarArgs.e(5, this.cAr);
      }
      if (this.xxe != null) {
        paramVarArgs.e(6, this.xxe);
      }
      if (this.xxf != null) {
        paramVarArgs.e(7, this.xxf);
      }
      if (this.kqd != null) {
        paramVarArgs.e(8, this.kqd);
      }
      if (this.xxg != null) {
        paramVarArgs.e(9, this.xxg);
      }
      paramVarArgs.aO(10, this.xxh);
      paramVarArgs.aO(11, this.xxi);
      paramVarArgs.aO(12, this.xxj);
      AppMethodBeat.o(80126);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aOg == null) {
        break label830;
      }
    }
    label830:
    for (int i = e.a.a.b.b.a.f(1, this.aOg) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xxb != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xxb);
      }
      i = paramInt;
      if (this.xxc != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xxc);
      }
      i += e.a.a.b.b.a.bl(4, this.xxd);
      paramInt = i;
      if (this.cAr != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.cAr);
      }
      i = paramInt;
      if (this.xxe != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.xxe);
      }
      paramInt = i;
      if (this.xxf != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.xxf);
      }
      i = paramInt;
      if (this.kqd != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.kqd);
      }
      paramInt = i;
      if (this.xxg != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.xxg);
      }
      i = e.a.a.b.b.a.bl(10, this.xxh);
      int j = e.a.a.b.b.a.bl(11, this.xxi);
      int k = e.a.a.b.b.a.bl(12, this.xxj);
      AppMethodBeat.o(80126);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(80126);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bhy localbhy = (bhy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(80126);
          return -1;
        case 1: 
          localbhy.aOg = locala.CLY.readString();
          AppMethodBeat.o(80126);
          return 0;
        case 2: 
          localbhy.xxb = locala.CLY.readString();
          AppMethodBeat.o(80126);
          return 0;
        case 3: 
          localbhy.xxc = locala.CLY.readString();
          AppMethodBeat.o(80126);
          return 0;
        case 4: 
          localbhy.xxd = locala.CLY.sl();
          AppMethodBeat.o(80126);
          return 0;
        case 5: 
          localbhy.cAr = locala.CLY.readString();
          AppMethodBeat.o(80126);
          return 0;
        case 6: 
          localbhy.xxe = locala.CLY.readString();
          AppMethodBeat.o(80126);
          return 0;
        case 7: 
          localbhy.xxf = locala.CLY.readString();
          AppMethodBeat.o(80126);
          return 0;
        case 8: 
          localbhy.kqd = locala.CLY.readString();
          AppMethodBeat.o(80126);
          return 0;
        case 9: 
          localbhy.xxg = locala.CLY.readString();
          AppMethodBeat.o(80126);
          return 0;
        case 10: 
          localbhy.xxh = locala.CLY.sl();
          AppMethodBeat.o(80126);
          return 0;
        case 11: 
          localbhy.xxi = locala.CLY.sl();
          AppMethodBeat.o(80126);
          return 0;
        }
        localbhy.xxj = locala.CLY.sl();
        AppMethodBeat.o(80126);
        return 0;
      }
      AppMethodBeat.o(80126);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhy
 * JD-Core Version:    0.7.0.1
 */