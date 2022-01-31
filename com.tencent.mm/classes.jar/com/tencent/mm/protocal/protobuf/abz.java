package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class abz
  extends com.tencent.mm.bv.a
{
  public int jJS;
  public String wDo;
  public int wDp;
  public String wJF;
  public String wJG;
  public String wJH;
  public int wJI;
  public String wSt;
  public int wSu;
  public String wxt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51389);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wJF != null) {
        paramVarArgs.e(1, this.wJF);
      }
      if (this.wJG != null) {
        paramVarArgs.e(2, this.wJG);
      }
      if (this.wJH != null) {
        paramVarArgs.e(3, this.wJH);
      }
      paramVarArgs.aO(4, this.wJI);
      if (this.wSt != null) {
        paramVarArgs.e(5, this.wSt);
      }
      if (this.wDo != null) {
        paramVarArgs.e(6, this.wDo);
      }
      paramVarArgs.aO(7, this.wDp);
      if (this.wxt != null) {
        paramVarArgs.e(8, this.wxt);
      }
      paramVarArgs.aO(9, this.jJS);
      paramVarArgs.aO(10, this.wSu);
      AppMethodBeat.o(51389);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wJF == null) {
        break label702;
      }
    }
    label702:
    for (int i = e.a.a.b.b.a.f(1, this.wJF) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wJG != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wJG);
      }
      i = paramInt;
      if (this.wJH != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wJH);
      }
      i += e.a.a.b.b.a.bl(4, this.wJI);
      paramInt = i;
      if (this.wSt != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wSt);
      }
      i = paramInt;
      if (this.wDo != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.wDo);
      }
      i += e.a.a.b.b.a.bl(7, this.wDp);
      paramInt = i;
      if (this.wxt != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wxt);
      }
      i = e.a.a.b.b.a.bl(9, this.jJS);
      int j = e.a.a.b.b.a.bl(10, this.wSu);
      AppMethodBeat.o(51389);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(51389);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        abz localabz = (abz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(51389);
          return -1;
        case 1: 
          localabz.wJF = locala.CLY.readString();
          AppMethodBeat.o(51389);
          return 0;
        case 2: 
          localabz.wJG = locala.CLY.readString();
          AppMethodBeat.o(51389);
          return 0;
        case 3: 
          localabz.wJH = locala.CLY.readString();
          AppMethodBeat.o(51389);
          return 0;
        case 4: 
          localabz.wJI = locala.CLY.sl();
          AppMethodBeat.o(51389);
          return 0;
        case 5: 
          localabz.wSt = locala.CLY.readString();
          AppMethodBeat.o(51389);
          return 0;
        case 6: 
          localabz.wDo = locala.CLY.readString();
          AppMethodBeat.o(51389);
          return 0;
        case 7: 
          localabz.wDp = locala.CLY.sl();
          AppMethodBeat.o(51389);
          return 0;
        case 8: 
          localabz.wxt = locala.CLY.readString();
          AppMethodBeat.o(51389);
          return 0;
        case 9: 
          localabz.jJS = locala.CLY.sl();
          AppMethodBeat.o(51389);
          return 0;
        }
        localabz.wSu = locala.CLY.sl();
        AppMethodBeat.o(51389);
        return 0;
      }
      AppMethodBeat.o(51389);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abz
 * JD-Core Version:    0.7.0.1
 */