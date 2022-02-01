package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bol
  extends com.tencent.mm.bx.a
{
  public String FWt;
  public int GJe;
  public long GJf;
  public long GJg;
  public long Gbu;
  public String GyY;
  public String dDH;
  public int mrl;
  public String ozd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72504);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FWt != null) {
        paramVarArgs.d(1, this.FWt);
      }
      paramVarArgs.aY(2, this.Gbu);
      paramVarArgs.aS(3, this.GJe);
      paramVarArgs.aY(4, this.GJf);
      paramVarArgs.aY(5, this.GJg);
      if (this.GyY != null) {
        paramVarArgs.d(6, this.GyY);
      }
      if (this.ozd != null) {
        paramVarArgs.d(7, this.ozd);
      }
      paramVarArgs.aS(8, this.mrl);
      if (this.dDH != null) {
        paramVarArgs.d(9, this.dDH);
      }
      AppMethodBeat.o(72504);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FWt == null) {
        break label618;
      }
    }
    label618:
    for (paramInt = f.a.a.b.b.a.e(1, this.FWt) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.Gbu) + f.a.a.b.b.a.bz(3, this.GJe) + f.a.a.b.b.a.p(4, this.GJf) + f.a.a.b.b.a.p(5, this.GJg);
      paramInt = i;
      if (this.GyY != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GyY);
      }
      i = paramInt;
      if (this.ozd != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.ozd);
      }
      i += f.a.a.b.b.a.bz(8, this.mrl);
      paramInt = i;
      if (this.dDH != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.dDH);
      }
      AppMethodBeat.o(72504);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72504);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bol localbol = (bol)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72504);
          return -1;
        case 1: 
          localbol.FWt = locala.NPN.readString();
          AppMethodBeat.o(72504);
          return 0;
        case 2: 
          localbol.Gbu = locala.NPN.zd();
          AppMethodBeat.o(72504);
          return 0;
        case 3: 
          localbol.GJe = locala.NPN.zc();
          AppMethodBeat.o(72504);
          return 0;
        case 4: 
          localbol.GJf = locala.NPN.zd();
          AppMethodBeat.o(72504);
          return 0;
        case 5: 
          localbol.GJg = locala.NPN.zd();
          AppMethodBeat.o(72504);
          return 0;
        case 6: 
          localbol.GyY = locala.NPN.readString();
          AppMethodBeat.o(72504);
          return 0;
        case 7: 
          localbol.ozd = locala.NPN.readString();
          AppMethodBeat.o(72504);
          return 0;
        case 8: 
          localbol.mrl = locala.NPN.zc();
          AppMethodBeat.o(72504);
          return 0;
        }
        localbol.dDH = locala.NPN.readString();
        AppMethodBeat.o(72504);
        return 0;
      }
      AppMethodBeat.o(72504);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bol
 * JD-Core Version:    0.7.0.1
 */