package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cit
  extends com.tencent.mm.bx.a
{
  public String CXN;
  public String CZf;
  public long CZr;
  public long CZs;
  public long CZt;
  public int CZu;
  public int CZv;
  public long CZw;
  public String Dhj;
  public String HcD;
  public String HcE;
  public String HcF;
  public int HcG;
  public String dDH;
  public String dxD;
  public String title;
  public String type;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91578);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.d(1, this.url);
      }
      if (this.dxD != null) {
        paramVarArgs.d(2, this.dxD);
      }
      if (this.dDH != null) {
        paramVarArgs.d(3, this.dDH);
      }
      if (this.Dhj != null) {
        paramVarArgs.d(4, this.Dhj);
      }
      if (this.CZf != null) {
        paramVarArgs.d(5, this.CZf);
      }
      if (this.HcD != null) {
        paramVarArgs.d(6, this.HcD);
      }
      if (this.type != null) {
        paramVarArgs.d(7, this.type);
      }
      if (this.title != null) {
        paramVarArgs.d(8, this.title);
      }
      paramVarArgs.aY(9, this.CZr);
      paramVarArgs.aY(10, this.CZs);
      if (this.CXN != null) {
        paramVarArgs.d(11, this.CXN);
      }
      paramVarArgs.aY(12, this.CZt);
      paramVarArgs.aS(13, this.CZu);
      paramVarArgs.aS(14, this.CZv);
      if (this.HcE != null) {
        paramVarArgs.d(15, this.HcE);
      }
      if (this.HcF != null) {
        paramVarArgs.d(16, this.HcF);
      }
      paramVarArgs.aY(17, this.CZw);
      paramVarArgs.aS(18, this.HcG);
      AppMethodBeat.o(91578);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label1146;
      }
    }
    label1146:
    for (int i = f.a.a.b.b.a.e(1, this.url) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dxD != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dxD);
      }
      i = paramInt;
      if (this.dDH != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dDH);
      }
      paramInt = i;
      if (this.Dhj != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Dhj);
      }
      i = paramInt;
      if (this.CZf != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CZf);
      }
      paramInt = i;
      if (this.HcD != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HcD);
      }
      i = paramInt;
      if (this.type != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.type);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.title);
      }
      i = paramInt + f.a.a.b.b.a.p(9, this.CZr) + f.a.a.b.b.a.p(10, this.CZs);
      paramInt = i;
      if (this.CXN != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.CXN);
      }
      i = paramInt + f.a.a.b.b.a.p(12, this.CZt) + f.a.a.b.b.a.bz(13, this.CZu) + f.a.a.b.b.a.bz(14, this.CZv);
      paramInt = i;
      if (this.HcE != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.HcE);
      }
      i = paramInt;
      if (this.HcF != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.HcF);
      }
      paramInt = f.a.a.b.b.a.p(17, this.CZw);
      int j = f.a.a.b.b.a.bz(18, this.HcG);
      AppMethodBeat.o(91578);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91578);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cit localcit = (cit)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91578);
          return -1;
        case 1: 
          localcit.url = locala.NPN.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 2: 
          localcit.dxD = locala.NPN.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 3: 
          localcit.dDH = locala.NPN.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 4: 
          localcit.Dhj = locala.NPN.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 5: 
          localcit.CZf = locala.NPN.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 6: 
          localcit.HcD = locala.NPN.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 7: 
          localcit.type = locala.NPN.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 8: 
          localcit.title = locala.NPN.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 9: 
          localcit.CZr = locala.NPN.zd();
          AppMethodBeat.o(91578);
          return 0;
        case 10: 
          localcit.CZs = locala.NPN.zd();
          AppMethodBeat.o(91578);
          return 0;
        case 11: 
          localcit.CXN = locala.NPN.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 12: 
          localcit.CZt = locala.NPN.zd();
          AppMethodBeat.o(91578);
          return 0;
        case 13: 
          localcit.CZu = locala.NPN.zc();
          AppMethodBeat.o(91578);
          return 0;
        case 14: 
          localcit.CZv = locala.NPN.zc();
          AppMethodBeat.o(91578);
          return 0;
        case 15: 
          localcit.HcE = locala.NPN.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 16: 
          localcit.HcF = locala.NPN.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 17: 
          localcit.CZw = locala.NPN.zd();
          AppMethodBeat.o(91578);
          return 0;
        }
        localcit.HcG = locala.NPN.zc();
        AppMethodBeat.o(91578);
        return 0;
      }
      AppMethodBeat.o(91578);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cit
 * JD-Core Version:    0.7.0.1
 */