package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class oa
  extends com.tencent.mm.bx.a
{
  public String FIQ;
  public String FJb;
  public int FJc;
  public int FJd;
  public int FJe;
  public int FJf;
  public int FJg;
  public long FJh;
  public LinkedList<String> FJi;
  public int Fuj;
  public int FwD;
  public int dDp;
  public LinkedList<String> dcr;
  public int hbR;
  public int mrl;
  public String url;
  public int weight;
  
  public oa()
  {
    AppMethodBeat.i(207235);
    this.dcr = new LinkedList();
    this.FJi = new LinkedList();
    AppMethodBeat.o(207235);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124437);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FJb != null) {
        paramVarArgs.d(1, this.FJb);
      }
      paramVarArgs.aS(2, this.weight);
      paramVarArgs.aS(3, this.FJc);
      paramVarArgs.aS(4, this.dDp);
      if (this.url != null) {
        paramVarArgs.d(5, this.url);
      }
      paramVarArgs.aS(6, this.hbR);
      paramVarArgs.aS(7, this.FJd);
      paramVarArgs.aS(8, this.FJe);
      paramVarArgs.aS(9, this.FJf);
      paramVarArgs.aS(10, this.FJg);
      paramVarArgs.aS(11, this.Fuj);
      paramVarArgs.aS(12, this.FwD);
      paramVarArgs.aS(13, this.mrl);
      paramVarArgs.e(14, 1, this.dcr);
      paramVarArgs.aY(15, this.FJh);
      if (this.FIQ != null) {
        paramVarArgs.d(18, this.FIQ);
      }
      paramVarArgs.e(19, 1, this.FJi);
      AppMethodBeat.o(124437);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FJb == null) {
        break label990;
      }
    }
    label990:
    for (paramInt = f.a.a.b.b.a.e(1, this.FJb) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.weight) + f.a.a.b.b.a.bz(3, this.FJc) + f.a.a.b.b.a.bz(4, this.dDp);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.url);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.hbR) + f.a.a.b.b.a.bz(7, this.FJd) + f.a.a.b.b.a.bz(8, this.FJe) + f.a.a.b.b.a.bz(9, this.FJf) + f.a.a.b.b.a.bz(10, this.FJg) + f.a.a.b.b.a.bz(11, this.Fuj) + f.a.a.b.b.a.bz(12, this.FwD) + f.a.a.b.b.a.bz(13, this.mrl) + f.a.a.a.c(14, 1, this.dcr) + f.a.a.b.b.a.p(15, this.FJh);
      paramInt = i;
      if (this.FIQ != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.FIQ);
      }
      i = f.a.a.a.c(19, 1, this.FJi);
      AppMethodBeat.o(124437);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.dcr.clear();
        this.FJi.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(124437);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        oa localoa = (oa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 16: 
        case 17: 
        default: 
          AppMethodBeat.o(124437);
          return -1;
        case 1: 
          localoa.FJb = locala.NPN.readString();
          AppMethodBeat.o(124437);
          return 0;
        case 2: 
          localoa.weight = locala.NPN.zc();
          AppMethodBeat.o(124437);
          return 0;
        case 3: 
          localoa.FJc = locala.NPN.zc();
          AppMethodBeat.o(124437);
          return 0;
        case 4: 
          localoa.dDp = locala.NPN.zc();
          AppMethodBeat.o(124437);
          return 0;
        case 5: 
          localoa.url = locala.NPN.readString();
          AppMethodBeat.o(124437);
          return 0;
        case 6: 
          localoa.hbR = locala.NPN.zc();
          AppMethodBeat.o(124437);
          return 0;
        case 7: 
          localoa.FJd = locala.NPN.zc();
          AppMethodBeat.o(124437);
          return 0;
        case 8: 
          localoa.FJe = locala.NPN.zc();
          AppMethodBeat.o(124437);
          return 0;
        case 9: 
          localoa.FJf = locala.NPN.zc();
          AppMethodBeat.o(124437);
          return 0;
        case 10: 
          localoa.FJg = locala.NPN.zc();
          AppMethodBeat.o(124437);
          return 0;
        case 11: 
          localoa.Fuj = locala.NPN.zc();
          AppMethodBeat.o(124437);
          return 0;
        case 12: 
          localoa.FwD = locala.NPN.zc();
          AppMethodBeat.o(124437);
          return 0;
        case 13: 
          localoa.mrl = locala.NPN.zc();
          AppMethodBeat.o(124437);
          return 0;
        case 14: 
          localoa.dcr.add(locala.NPN.readString());
          AppMethodBeat.o(124437);
          return 0;
        case 15: 
          localoa.FJh = locala.NPN.zd();
          AppMethodBeat.o(124437);
          return 0;
        case 18: 
          localoa.FIQ = locala.NPN.readString();
          AppMethodBeat.o(124437);
          return 0;
        }
        localoa.FJi.add(locala.NPN.readString());
        AppMethodBeat.o(124437);
        return 0;
      }
      AppMethodBeat.o(124437);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oa
 * JD-Core Version:    0.7.0.1
 */