package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ctn
  extends com.tencent.mm.bx.a
{
  public String FGE;
  public long HlH;
  public int HlI;
  public boolean HlJ;
  public boolean HlK;
  public int HlL;
  public boolean HlM;
  public int ujD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124546);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FGE != null) {
        paramVarArgs.d(1, this.FGE);
      }
      paramVarArgs.aY(2, this.HlH);
      paramVarArgs.aS(3, this.HlI);
      paramVarArgs.bt(4, this.HlJ);
      paramVarArgs.bt(5, this.HlK);
      paramVarArgs.aS(6, this.HlL);
      paramVarArgs.aS(7, this.ujD);
      paramVarArgs.bt(8, this.HlM);
      AppMethodBeat.o(124546);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FGE == null) {
        break label530;
      }
    }
    label530:
    for (paramInt = f.a.a.b.b.a.e(1, this.FGE) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.p(2, this.HlH);
      int j = f.a.a.b.b.a.bz(3, this.HlI);
      int k = f.a.a.b.b.a.alV(4);
      int m = f.a.a.b.b.a.alV(5);
      int n = f.a.a.b.b.a.bz(6, this.HlL);
      int i1 = f.a.a.b.b.a.bz(7, this.ujD);
      int i2 = f.a.a.b.b.a.alV(8);
      AppMethodBeat.o(124546);
      return paramInt + i + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(124546);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ctn localctn = (ctn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124546);
          return -1;
        case 1: 
          localctn.FGE = locala.NPN.readString();
          AppMethodBeat.o(124546);
          return 0;
        case 2: 
          localctn.HlH = locala.NPN.zd();
          AppMethodBeat.o(124546);
          return 0;
        case 3: 
          localctn.HlI = locala.NPN.zc();
          AppMethodBeat.o(124546);
          return 0;
        case 4: 
          localctn.HlJ = locala.NPN.grw();
          AppMethodBeat.o(124546);
          return 0;
        case 5: 
          localctn.HlK = locala.NPN.grw();
          AppMethodBeat.o(124546);
          return 0;
        case 6: 
          localctn.HlL = locala.NPN.zc();
          AppMethodBeat.o(124546);
          return 0;
        case 7: 
          localctn.ujD = locala.NPN.zc();
          AppMethodBeat.o(124546);
          return 0;
        }
        localctn.HlM = locala.NPN.grw();
        AppMethodBeat.o(124546);
        return 0;
      }
      AppMethodBeat.o(124546);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctn
 * JD-Core Version:    0.7.0.1
 */