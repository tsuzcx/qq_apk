package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bon
  extends com.tencent.mm.bx.a
{
  public int FHr;
  public String FpZ;
  public long GJf;
  public String GJh;
  public int GJj;
  public int GJk;
  public String GJl;
  public String GyY;
  public int mrl;
  public int oxC;
  public String ozd;
  public String pkr;
  public int state;
  public String vjr;
  public String xSC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72506);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GyY != null) {
        paramVarArgs.d(1, this.GyY);
      }
      if (this.FpZ != null) {
        paramVarArgs.d(2, this.FpZ);
      }
      paramVarArgs.aY(3, this.GJf);
      paramVarArgs.aS(4, this.state);
      paramVarArgs.aS(5, this.FHr);
      paramVarArgs.aS(6, this.oxC);
      paramVarArgs.aS(7, this.GJj);
      paramVarArgs.aS(8, this.GJk);
      if (this.GJl != null) {
        paramVarArgs.d(9, this.GJl);
      }
      if (this.ozd != null) {
        paramVarArgs.d(10, this.ozd);
      }
      if (this.vjr != null) {
        paramVarArgs.d(11, this.vjr);
      }
      if (this.pkr != null) {
        paramVarArgs.d(12, this.pkr);
      }
      if (this.xSC != null) {
        paramVarArgs.d(13, this.xSC);
      }
      if (this.GJh != null) {
        paramVarArgs.d(14, this.GJh);
      }
      paramVarArgs.aS(15, this.mrl);
      AppMethodBeat.o(72506);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GyY == null) {
        break label954;
      }
    }
    label954:
    for (paramInt = f.a.a.b.b.a.e(1, this.GyY) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FpZ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FpZ);
      }
      i = i + f.a.a.b.b.a.p(3, this.GJf) + f.a.a.b.b.a.bz(4, this.state) + f.a.a.b.b.a.bz(5, this.FHr) + f.a.a.b.b.a.bz(6, this.oxC) + f.a.a.b.b.a.bz(7, this.GJj) + f.a.a.b.b.a.bz(8, this.GJk);
      paramInt = i;
      if (this.GJl != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GJl);
      }
      i = paramInt;
      if (this.ozd != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.ozd);
      }
      paramInt = i;
      if (this.vjr != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.vjr);
      }
      i = paramInt;
      if (this.pkr != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.pkr);
      }
      paramInt = i;
      if (this.xSC != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.xSC);
      }
      i = paramInt;
      if (this.GJh != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.GJh);
      }
      paramInt = f.a.a.b.b.a.bz(15, this.mrl);
      AppMethodBeat.o(72506);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72506);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bon localbon = (bon)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72506);
          return -1;
        case 1: 
          localbon.GyY = locala.NPN.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 2: 
          localbon.FpZ = locala.NPN.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 3: 
          localbon.GJf = locala.NPN.zd();
          AppMethodBeat.o(72506);
          return 0;
        case 4: 
          localbon.state = locala.NPN.zc();
          AppMethodBeat.o(72506);
          return 0;
        case 5: 
          localbon.FHr = locala.NPN.zc();
          AppMethodBeat.o(72506);
          return 0;
        case 6: 
          localbon.oxC = locala.NPN.zc();
          AppMethodBeat.o(72506);
          return 0;
        case 7: 
          localbon.GJj = locala.NPN.zc();
          AppMethodBeat.o(72506);
          return 0;
        case 8: 
          localbon.GJk = locala.NPN.zc();
          AppMethodBeat.o(72506);
          return 0;
        case 9: 
          localbon.GJl = locala.NPN.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 10: 
          localbon.ozd = locala.NPN.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 11: 
          localbon.vjr = locala.NPN.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 12: 
          localbon.pkr = locala.NPN.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 13: 
          localbon.xSC = locala.NPN.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 14: 
          localbon.GJh = locala.NPN.readString();
          AppMethodBeat.o(72506);
          return 0;
        }
        localbon.mrl = locala.NPN.zc();
        AppMethodBeat.o(72506);
        return 0;
      }
      AppMethodBeat.o(72506);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bon
 * JD-Core Version:    0.7.0.1
 */