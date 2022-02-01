package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class app
  extends com.tencent.mm.bw.a
{
  public int LBx;
  public int LBy;
  public int LBz;
  public String country;
  public int fuA;
  public String fuJ;
  public String fuK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168946);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.country != null) {
        paramVarArgs.e(1, this.country);
      }
      if (this.fuJ != null) {
        paramVarArgs.e(2, this.fuJ);
      }
      if (this.fuK != null) {
        paramVarArgs.e(3, this.fuK);
      }
      paramVarArgs.aM(4, this.fuA);
      paramVarArgs.aM(5, this.LBx);
      paramVarArgs.aM(6, this.LBy);
      paramVarArgs.aM(7, this.LBz);
      AppMethodBeat.o(168946);
      return 0;
    }
    if (paramInt == 1) {
      if (this.country == null) {
        break label522;
      }
    }
    label522:
    for (int i = g.a.a.b.b.a.f(1, this.country) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fuJ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.fuJ);
      }
      i = paramInt;
      if (this.fuK != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.fuK);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.fuA);
      int j = g.a.a.b.b.a.bu(5, this.LBx);
      int k = g.a.a.b.b.a.bu(6, this.LBy);
      int m = g.a.a.b.b.a.bu(7, this.LBz);
      AppMethodBeat.o(168946);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(168946);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        app localapp = (app)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(168946);
          return -1;
        case 1: 
          localapp.country = locala.UbS.readString();
          AppMethodBeat.o(168946);
          return 0;
        case 2: 
          localapp.fuJ = locala.UbS.readString();
          AppMethodBeat.o(168946);
          return 0;
        case 3: 
          localapp.fuK = locala.UbS.readString();
          AppMethodBeat.o(168946);
          return 0;
        case 4: 
          localapp.fuA = locala.UbS.zi();
          AppMethodBeat.o(168946);
          return 0;
        case 5: 
          localapp.LBx = locala.UbS.zi();
          AppMethodBeat.o(168946);
          return 0;
        case 6: 
          localapp.LBy = locala.UbS.zi();
          AppMethodBeat.o(168946);
          return 0;
        }
        localapp.LBz = locala.UbS.zi();
        AppMethodBeat.o(168946);
        return 0;
      }
      AppMethodBeat.o(168946);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.app
 * JD-Core Version:    0.7.0.1
 */