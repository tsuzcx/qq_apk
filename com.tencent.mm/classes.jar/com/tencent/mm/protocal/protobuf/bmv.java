package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bmv
  extends com.tencent.mm.bv.a
{
  public String cyA;
  public String tVo;
  public int type;
  public String uaJ;
  public String uaL;
  public String ugl;
  public String xBg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(141133);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.cyA != null) {
        paramVarArgs.e(1, this.cyA);
      }
      paramVarArgs.aO(2, this.type);
      if (this.uaJ != null) {
        paramVarArgs.e(3, this.uaJ);
      }
      if (this.ugl != null) {
        paramVarArgs.e(4, this.ugl);
      }
      if (this.uaL != null) {
        paramVarArgs.e(5, this.uaL);
      }
      if (this.xBg != null) {
        paramVarArgs.e(6, this.xBg);
      }
      if (this.tVo != null) {
        paramVarArgs.e(7, this.tVo);
      }
      AppMethodBeat.o(141133);
      return 0;
    }
    if (paramInt == 1) {
      if (this.cyA == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = e.a.a.b.b.a.f(1, this.cyA) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.type);
      paramInt = i;
      if (this.uaJ != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.uaJ);
      }
      i = paramInt;
      if (this.ugl != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.ugl);
      }
      paramInt = i;
      if (this.uaL != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.uaL);
      }
      i = paramInt;
      if (this.xBg != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.xBg);
      }
      paramInt = i;
      if (this.tVo != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.tVo);
      }
      AppMethodBeat.o(141133);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(141133);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bmv localbmv = (bmv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(141133);
          return -1;
        case 1: 
          localbmv.cyA = locala.CLY.readString();
          AppMethodBeat.o(141133);
          return 0;
        case 2: 
          localbmv.type = locala.CLY.sl();
          AppMethodBeat.o(141133);
          return 0;
        case 3: 
          localbmv.uaJ = locala.CLY.readString();
          AppMethodBeat.o(141133);
          return 0;
        case 4: 
          localbmv.ugl = locala.CLY.readString();
          AppMethodBeat.o(141133);
          return 0;
        case 5: 
          localbmv.uaL = locala.CLY.readString();
          AppMethodBeat.o(141133);
          return 0;
        case 6: 
          localbmv.xBg = locala.CLY.readString();
          AppMethodBeat.o(141133);
          return 0;
        }
        localbmv.tVo = locala.CLY.readString();
        AppMethodBeat.o(141133);
        return 0;
      }
      AppMethodBeat.o(141133);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmv
 * JD-Core Version:    0.7.0.1
 */