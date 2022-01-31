package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class rm
  extends com.tencent.mm.bv.a
{
  public String wJF;
  public String wJG;
  public String wJH;
  public int wJI;
  public int wJJ;
  public String wJK;
  public int wJL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51377);
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
      paramVarArgs.aO(5, this.wJJ);
      if (this.wJK != null) {
        paramVarArgs.e(6, this.wJK);
      }
      paramVarArgs.aO(7, this.wJL);
      AppMethodBeat.o(51377);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wJF == null) {
        break label530;
      }
    }
    label530:
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
      i = i + e.a.a.b.b.a.bl(4, this.wJI) + e.a.a.b.b.a.bl(5, this.wJJ);
      paramInt = i;
      if (this.wJK != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wJK);
      }
      i = e.a.a.b.b.a.bl(7, this.wJL);
      AppMethodBeat.o(51377);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(51377);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        rm localrm = (rm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(51377);
          return -1;
        case 1: 
          localrm.wJF = locala.CLY.readString();
          AppMethodBeat.o(51377);
          return 0;
        case 2: 
          localrm.wJG = locala.CLY.readString();
          AppMethodBeat.o(51377);
          return 0;
        case 3: 
          localrm.wJH = locala.CLY.readString();
          AppMethodBeat.o(51377);
          return 0;
        case 4: 
          localrm.wJI = locala.CLY.sl();
          AppMethodBeat.o(51377);
          return 0;
        case 5: 
          localrm.wJJ = locala.CLY.sl();
          AppMethodBeat.o(51377);
          return 0;
        case 6: 
          localrm.wJK = locala.CLY.readString();
          AppMethodBeat.o(51377);
          return 0;
        }
        localrm.wJL = locala.CLY.sl();
        AppMethodBeat.o(51377);
        return 0;
      }
      AppMethodBeat.o(51377);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rm
 * JD-Core Version:    0.7.0.1
 */