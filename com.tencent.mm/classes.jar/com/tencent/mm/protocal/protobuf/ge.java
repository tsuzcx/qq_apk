package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ge
  extends com.tencent.mm.bw.a
{
  public String KJV;
  public int KJW;
  public int KJX;
  public long KJY;
  public int KJZ;
  public long iAQ;
  public int idx;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124388);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KJV != null) {
        paramVarArgs.e(1, this.KJV);
      }
      paramVarArgs.bb(2, this.iAQ);
      paramVarArgs.aM(3, this.idx);
      paramVarArgs.aM(4, this.KJW);
      paramVarArgs.aM(5, this.KJX);
      paramVarArgs.bb(6, this.KJY);
      paramVarArgs.aM(7, this.KJZ);
      if (this.url != null) {
        paramVarArgs.e(8, this.url);
      }
      AppMethodBeat.o(124388);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KJV == null) {
        break label534;
      }
    }
    label534:
    for (paramInt = g.a.a.b.b.a.f(1, this.KJV) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.iAQ) + g.a.a.b.b.a.bu(3, this.idx) + g.a.a.b.b.a.bu(4, this.KJW) + g.a.a.b.b.a.bu(5, this.KJX) + g.a.a.b.b.a.r(6, this.KJY) + g.a.a.b.b.a.bu(7, this.KJZ);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.url);
      }
      AppMethodBeat.o(124388);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(124388);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ge localge = (ge)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124388);
          return -1;
        case 1: 
          localge.KJV = locala.UbS.readString();
          AppMethodBeat.o(124388);
          return 0;
        case 2: 
          localge.iAQ = locala.UbS.zl();
          AppMethodBeat.o(124388);
          return 0;
        case 3: 
          localge.idx = locala.UbS.zi();
          AppMethodBeat.o(124388);
          return 0;
        case 4: 
          localge.KJW = locala.UbS.zi();
          AppMethodBeat.o(124388);
          return 0;
        case 5: 
          localge.KJX = locala.UbS.zi();
          AppMethodBeat.o(124388);
          return 0;
        case 6: 
          localge.KJY = locala.UbS.zl();
          AppMethodBeat.o(124388);
          return 0;
        case 7: 
          localge.KJZ = locala.UbS.zi();
          AppMethodBeat.o(124388);
          return 0;
        }
        localge.url = locala.UbS.readString();
        AppMethodBeat.o(124388);
        return 0;
      }
      AppMethodBeat.o(124388);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ge
 * JD-Core Version:    0.7.0.1
 */