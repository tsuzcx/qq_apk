package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ho
  extends com.tencent.mm.bx.a
{
  public String FAa;
  public long FAb;
  public double FAc;
  public int FAd;
  public String FAe;
  public String FzS;
  public String FzT;
  public int FzU;
  public long FzV;
  public int FzW;
  public long FzX;
  public long FzY;
  public long FzZ;
  public String Id;
  public int nDG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(87872);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.d(1, this.Id);
      }
      if (this.FzS != null) {
        paramVarArgs.d(2, this.FzS);
      }
      if (this.FzT != null) {
        paramVarArgs.d(3, this.FzT);
      }
      paramVarArgs.aS(4, this.FzU);
      paramVarArgs.aY(5, this.FzV);
      paramVarArgs.aS(6, this.FzW);
      paramVarArgs.aS(7, this.nDG);
      paramVarArgs.aY(8, this.FzX);
      paramVarArgs.aY(9, this.FzY);
      paramVarArgs.aY(10, this.FzZ);
      if (this.FAa != null) {
        paramVarArgs.d(11, this.FAa);
      }
      paramVarArgs.aY(12, this.FAb);
      paramVarArgs.e(13, this.FAc);
      paramVarArgs.aS(14, this.FAd);
      if (this.FAe != null) {
        paramVarArgs.d(15, this.FAe);
      }
      AppMethodBeat.o(87872);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Id == null) {
        break label897;
      }
    }
    label897:
    for (int i = f.a.a.b.b.a.e(1, this.Id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FzS != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FzS);
      }
      i = paramInt;
      if (this.FzT != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FzT);
      }
      i = i + f.a.a.b.b.a.bz(4, this.FzU) + f.a.a.b.b.a.p(5, this.FzV) + f.a.a.b.b.a.bz(6, this.FzW) + f.a.a.b.b.a.bz(7, this.nDG) + f.a.a.b.b.a.p(8, this.FzX) + f.a.a.b.b.a.p(9, this.FzY) + f.a.a.b.b.a.p(10, this.FzZ);
      paramInt = i;
      if (this.FAa != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.FAa);
      }
      i = paramInt + f.a.a.b.b.a.p(12, this.FAb) + f.a.a.b.b.a.alT(13) + f.a.a.b.b.a.bz(14, this.FAd);
      paramInt = i;
      if (this.FAe != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.FAe);
      }
      AppMethodBeat.o(87872);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(87872);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ho localho = (ho)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(87872);
          return -1;
        case 1: 
          localho.Id = locala.NPN.readString();
          AppMethodBeat.o(87872);
          return 0;
        case 2: 
          localho.FzS = locala.NPN.readString();
          AppMethodBeat.o(87872);
          return 0;
        case 3: 
          localho.FzT = locala.NPN.readString();
          AppMethodBeat.o(87872);
          return 0;
        case 4: 
          localho.FzU = locala.NPN.zc();
          AppMethodBeat.o(87872);
          return 0;
        case 5: 
          localho.FzV = locala.NPN.zd();
          AppMethodBeat.o(87872);
          return 0;
        case 6: 
          localho.FzW = locala.NPN.zc();
          AppMethodBeat.o(87872);
          return 0;
        case 7: 
          localho.nDG = locala.NPN.zc();
          AppMethodBeat.o(87872);
          return 0;
        case 8: 
          localho.FzX = locala.NPN.zd();
          AppMethodBeat.o(87872);
          return 0;
        case 9: 
          localho.FzY = locala.NPN.zd();
          AppMethodBeat.o(87872);
          return 0;
        case 10: 
          localho.FzZ = locala.NPN.zd();
          AppMethodBeat.o(87872);
          return 0;
        case 11: 
          localho.FAa = locala.NPN.readString();
          AppMethodBeat.o(87872);
          return 0;
        case 12: 
          localho.FAb = locala.NPN.zd();
          AppMethodBeat.o(87872);
          return 0;
        case 13: 
          localho.FAc = Double.longBitsToDouble(locala.NPN.grA());
          AppMethodBeat.o(87872);
          return 0;
        case 14: 
          localho.FAd = locala.NPN.zc();
          AppMethodBeat.o(87872);
          return 0;
        }
        localho.FAe = locala.NPN.readString();
        AppMethodBeat.o(87872);
        return 0;
      }
      AppMethodBeat.o(87872);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ho
 * JD-Core Version:    0.7.0.1
 */