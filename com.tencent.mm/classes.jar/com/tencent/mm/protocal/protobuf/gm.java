package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gm
  extends com.tencent.mm.bv.a
{
  public String gwS;
  public String jJA;
  public String jKG;
  public int mOJ;
  public String woB;
  public int wsQ;
  public String wsR;
  public String wsS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28323);
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
      paramVarArgs.aO(4, this.wsQ);
      if (this.wsR != null) {
        paramVarArgs.e(5, this.wsR);
      }
      if (this.gwS != null) {
        paramVarArgs.e(6, this.gwS);
      }
      if (this.wsS != null) {
        paramVarArgs.e(7, this.wsS);
      }
      paramVarArgs.aO(8, this.mOJ);
      AppMethodBeat.o(28323);
      return 0;
    }
    if (paramInt == 1) {
      if (this.woB == null) {
        break label624;
      }
    }
    label624:
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
      i += e.a.a.b.b.a.bl(4, this.wsQ);
      paramInt = i;
      if (this.wsR != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wsR);
      }
      i = paramInt;
      if (this.gwS != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.gwS);
      }
      paramInt = i;
      if (this.wsS != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.wsS);
      }
      i = e.a.a.b.b.a.bl(8, this.mOJ);
      AppMethodBeat.o(28323);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28323);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        gm localgm = (gm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28323);
          return -1;
        case 1: 
          localgm.woB = locala.CLY.readString();
          AppMethodBeat.o(28323);
          return 0;
        case 2: 
          localgm.jKG = locala.CLY.readString();
          AppMethodBeat.o(28323);
          return 0;
        case 3: 
          localgm.jJA = locala.CLY.readString();
          AppMethodBeat.o(28323);
          return 0;
        case 4: 
          localgm.wsQ = locala.CLY.sl();
          AppMethodBeat.o(28323);
          return 0;
        case 5: 
          localgm.wsR = locala.CLY.readString();
          AppMethodBeat.o(28323);
          return 0;
        case 6: 
          localgm.gwS = locala.CLY.readString();
          AppMethodBeat.o(28323);
          return 0;
        case 7: 
          localgm.wsS = locala.CLY.readString();
          AppMethodBeat.o(28323);
          return 0;
        }
        localgm.mOJ = locala.CLY.sl();
        AppMethodBeat.o(28323);
        return 0;
      }
      AppMethodBeat.o(28323);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gm
 * JD-Core Version:    0.7.0.1
 */