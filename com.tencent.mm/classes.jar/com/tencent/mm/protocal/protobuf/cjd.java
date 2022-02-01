package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class cjd
  extends com.tencent.mm.bx.a
{
  public String CIt;
  public long Eeu;
  public int Eev;
  public boolean Eew;
  public boolean Eex;
  public int Eey;
  public boolean Eez;
  public int sdA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124546);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CIt != null) {
        paramVarArgs.d(1, this.CIt);
      }
      paramVarArgs.aG(2, this.Eeu);
      paramVarArgs.aR(3, this.Eev);
      paramVarArgs.bg(4, this.Eew);
      paramVarArgs.bg(5, this.Eex);
      paramVarArgs.aR(6, this.Eey);
      paramVarArgs.aR(7, this.sdA);
      paramVarArgs.bg(8, this.Eez);
      AppMethodBeat.o(124546);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CIt == null) {
        break label534;
      }
    }
    label534:
    for (paramInt = f.a.a.b.b.a.e(1, this.CIt) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.q(2, this.Eeu);
      int j = f.a.a.b.b.a.bA(3, this.Eev);
      int k = f.a.a.b.b.a.fY(4);
      int m = f.a.a.b.b.a.fY(5);
      int n = f.a.a.b.b.a.bA(6, this.Eey);
      int i1 = f.a.a.b.b.a.bA(7, this.sdA);
      int i2 = f.a.a.b.b.a.fY(8);
      AppMethodBeat.o(124546);
      return paramInt + i + j + (k + 1) + (m + 1) + n + i1 + (i2 + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(124546);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cjd localcjd = (cjd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124546);
          return -1;
        case 1: 
          localcjd.CIt = locala.KhF.readString();
          AppMethodBeat.o(124546);
          return 0;
        case 2: 
          localcjd.Eeu = locala.KhF.xT();
          AppMethodBeat.o(124546);
          return 0;
        case 3: 
          localcjd.Eev = locala.KhF.xS();
          AppMethodBeat.o(124546);
          return 0;
        case 4: 
          localcjd.Eew = locala.KhF.fHu();
          AppMethodBeat.o(124546);
          return 0;
        case 5: 
          localcjd.Eex = locala.KhF.fHu();
          AppMethodBeat.o(124546);
          return 0;
        case 6: 
          localcjd.Eey = locala.KhF.xS();
          AppMethodBeat.o(124546);
          return 0;
        case 7: 
          localcjd.sdA = locala.KhF.xS();
          AppMethodBeat.o(124546);
          return 0;
        }
        localcjd.Eez = locala.KhF.fHu();
        AppMethodBeat.o(124546);
        return 0;
      }
      AppMethodBeat.o(124546);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjd
 * JD-Core Version:    0.7.0.1
 */