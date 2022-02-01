package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aje
  extends com.tencent.mm.bw.a
{
  public int EDP;
  public int EDQ;
  public int EDR;
  public String country;
  public int exL;
  public String exV;
  public String exW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168946);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.country != null) {
        paramVarArgs.d(1, this.country);
      }
      if (this.exV != null) {
        paramVarArgs.d(2, this.exV);
      }
      if (this.exW != null) {
        paramVarArgs.d(3, this.exW);
      }
      paramVarArgs.aR(4, this.exL);
      paramVarArgs.aR(5, this.EDP);
      paramVarArgs.aR(6, this.EDQ);
      paramVarArgs.aR(7, this.EDR);
      AppMethodBeat.o(168946);
      return 0;
    }
    if (paramInt == 1) {
      if (this.country == null) {
        break label522;
      }
    }
    label522:
    for (int i = f.a.a.b.b.a.e(1, this.country) + 0;; i = 0)
    {
      paramInt = i;
      if (this.exV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.exV);
      }
      i = paramInt;
      if (this.exW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.exW);
      }
      paramInt = f.a.a.b.b.a.bx(4, this.exL);
      int j = f.a.a.b.b.a.bx(5, this.EDP);
      int k = f.a.a.b.b.a.bx(6, this.EDQ);
      int m = f.a.a.b.b.a.bx(7, this.EDR);
      AppMethodBeat.o(168946);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(168946);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aje localaje = (aje)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(168946);
          return -1;
        case 1: 
          localaje.country = locala.LVo.readString();
          AppMethodBeat.o(168946);
          return 0;
        case 2: 
          localaje.exV = locala.LVo.readString();
          AppMethodBeat.o(168946);
          return 0;
        case 3: 
          localaje.exW = locala.LVo.readString();
          AppMethodBeat.o(168946);
          return 0;
        case 4: 
          localaje.exL = locala.LVo.xF();
          AppMethodBeat.o(168946);
          return 0;
        case 5: 
          localaje.EDP = locala.LVo.xF();
          AppMethodBeat.o(168946);
          return 0;
        case 6: 
          localaje.EDQ = locala.LVo.xF();
          AppMethodBeat.o(168946);
          return 0;
        }
        localaje.EDR = locala.LVo.xF();
        AppMethodBeat.o(168946);
        return 0;
      }
      AppMethodBeat.o(168946);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aje
 * JD-Core Version:    0.7.0.1
 */