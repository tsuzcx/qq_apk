package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cvt
  extends com.tencent.mm.bv.a
{
  public int Scene;
  public int gvH;
  public String pqx;
  public String xHJ;
  public String xqX;
  public String yed;
  public String yee;
  public String yef;
  public String yeg;
  public String yeh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(93804);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.yed != null) {
        paramVarArgs.e(1, this.yed);
      }
      if (this.yee != null) {
        paramVarArgs.e(2, this.yee);
      }
      if (this.xqX != null) {
        paramVarArgs.e(3, this.xqX);
      }
      if (this.xHJ != null) {
        paramVarArgs.e(4, this.xHJ);
      }
      paramVarArgs.aO(5, this.gvH);
      if (this.pqx != null) {
        paramVarArgs.e(6, this.pqx);
      }
      if (this.yef != null) {
        paramVarArgs.e(7, this.yef);
      }
      if (this.yeg != null) {
        paramVarArgs.e(8, this.yeg);
      }
      paramVarArgs.aO(9, this.Scene);
      if (this.yeh != null) {
        paramVarArgs.e(19, this.yeh);
      }
      AppMethodBeat.o(93804);
      return 0;
    }
    if (paramInt == 1) {
      if (this.yed == null) {
        break label770;
      }
    }
    label770:
    for (int i = e.a.a.b.b.a.f(1, this.yed) + 0;; i = 0)
    {
      paramInt = i;
      if (this.yee != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.yee);
      }
      i = paramInt;
      if (this.xqX != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xqX);
      }
      paramInt = i;
      if (this.xHJ != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xHJ);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.gvH);
      paramInt = i;
      if (this.pqx != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.pqx);
      }
      i = paramInt;
      if (this.yef != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.yef);
      }
      paramInt = i;
      if (this.yeg != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.yeg);
      }
      i = paramInt + e.a.a.b.b.a.bl(9, this.Scene);
      paramInt = i;
      if (this.yeh != null) {
        paramInt = i + e.a.a.b.b.a.f(19, this.yeh);
      }
      AppMethodBeat.o(93804);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(93804);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cvt localcvt = (cvt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        default: 
          AppMethodBeat.o(93804);
          return -1;
        case 1: 
          localcvt.yed = locala.CLY.readString();
          AppMethodBeat.o(93804);
          return 0;
        case 2: 
          localcvt.yee = locala.CLY.readString();
          AppMethodBeat.o(93804);
          return 0;
        case 3: 
          localcvt.xqX = locala.CLY.readString();
          AppMethodBeat.o(93804);
          return 0;
        case 4: 
          localcvt.xHJ = locala.CLY.readString();
          AppMethodBeat.o(93804);
          return 0;
        case 5: 
          localcvt.gvH = locala.CLY.sl();
          AppMethodBeat.o(93804);
          return 0;
        case 6: 
          localcvt.pqx = locala.CLY.readString();
          AppMethodBeat.o(93804);
          return 0;
        case 7: 
          localcvt.yef = locala.CLY.readString();
          AppMethodBeat.o(93804);
          return 0;
        case 8: 
          localcvt.yeg = locala.CLY.readString();
          AppMethodBeat.o(93804);
          return 0;
        case 9: 
          localcvt.Scene = locala.CLY.sl();
          AppMethodBeat.o(93804);
          return 0;
        }
        localcvt.yeh = locala.CLY.readString();
        AppMethodBeat.o(93804);
        return 0;
      }
      AppMethodBeat.o(93804);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvt
 * JD-Core Version:    0.7.0.1
 */