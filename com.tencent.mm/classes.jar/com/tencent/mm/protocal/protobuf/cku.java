package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cku
  extends com.tencent.mm.bv.a
{
  public String cDC;
  public String cDz;
  public int dqG;
  public String extInfo;
  public int fQD;
  public long fSm;
  public String text;
  public int type;
  public int uJc;
  public int uKd;
  public int uKe;
  public int uKf;
  public long xUH;
  public int xUI;
  public long xUJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(55706);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.cDC != null) {
        paramVarArgs.e(1, this.cDC);
      }
      paramVarArgs.aO(2, this.uKd);
      paramVarArgs.aO(3, this.uKe);
      paramVarArgs.am(4, this.fSm);
      paramVarArgs.aO(5, this.uJc);
      paramVarArgs.aO(6, this.type);
      if (this.text != null) {
        paramVarArgs.e(7, this.text);
      }
      if (this.cDz != null) {
        paramVarArgs.e(8, this.cDz);
      }
      paramVarArgs.am(9, this.xUH);
      paramVarArgs.aO(10, this.uKf);
      paramVarArgs.aO(11, this.xUI);
      paramVarArgs.am(12, this.xUJ);
      paramVarArgs.aO(13, this.dqG);
      paramVarArgs.aO(14, this.fQD);
      if (this.extInfo != null) {
        paramVarArgs.e(15, this.extInfo);
      }
      AppMethodBeat.o(55706);
      return 0;
    }
    if (paramInt == 1) {
      if (this.cDC == null) {
        break label882;
      }
    }
    label882:
    for (paramInt = e.a.a.b.b.a.f(1, this.cDC) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.uKd) + e.a.a.b.b.a.bl(3, this.uKe) + e.a.a.b.b.a.p(4, this.fSm) + e.a.a.b.b.a.bl(5, this.uJc) + e.a.a.b.b.a.bl(6, this.type);
      paramInt = i;
      if (this.text != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.text);
      }
      i = paramInt;
      if (this.cDz != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.cDz);
      }
      i = i + e.a.a.b.b.a.p(9, this.xUH) + e.a.a.b.b.a.bl(10, this.uKf) + e.a.a.b.b.a.bl(11, this.xUI) + e.a.a.b.b.a.p(12, this.xUJ) + e.a.a.b.b.a.bl(13, this.dqG) + e.a.a.b.b.a.bl(14, this.fQD);
      paramInt = i;
      if (this.extInfo != null) {
        paramInt = i + e.a.a.b.b.a.f(15, this.extInfo);
      }
      AppMethodBeat.o(55706);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(55706);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cku localcku = (cku)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(55706);
          return -1;
        case 1: 
          localcku.cDC = locala.CLY.readString();
          AppMethodBeat.o(55706);
          return 0;
        case 2: 
          localcku.uKd = locala.CLY.sl();
          AppMethodBeat.o(55706);
          return 0;
        case 3: 
          localcku.uKe = locala.CLY.sl();
          AppMethodBeat.o(55706);
          return 0;
        case 4: 
          localcku.fSm = locala.CLY.sm();
          AppMethodBeat.o(55706);
          return 0;
        case 5: 
          localcku.uJc = locala.CLY.sl();
          AppMethodBeat.o(55706);
          return 0;
        case 6: 
          localcku.type = locala.CLY.sl();
          AppMethodBeat.o(55706);
          return 0;
        case 7: 
          localcku.text = locala.CLY.readString();
          AppMethodBeat.o(55706);
          return 0;
        case 8: 
          localcku.cDz = locala.CLY.readString();
          AppMethodBeat.o(55706);
          return 0;
        case 9: 
          localcku.xUH = locala.CLY.sm();
          AppMethodBeat.o(55706);
          return 0;
        case 10: 
          localcku.uKf = locala.CLY.sl();
          AppMethodBeat.o(55706);
          return 0;
        case 11: 
          localcku.xUI = locala.CLY.sl();
          AppMethodBeat.o(55706);
          return 0;
        case 12: 
          localcku.xUJ = locala.CLY.sm();
          AppMethodBeat.o(55706);
          return 0;
        case 13: 
          localcku.dqG = locala.CLY.sl();
          AppMethodBeat.o(55706);
          return 0;
        case 14: 
          localcku.fQD = locala.CLY.sl();
          AppMethodBeat.o(55706);
          return 0;
        }
        localcku.extInfo = locala.CLY.readString();
        AppMethodBeat.o(55706);
        return 0;
      }
      AppMethodBeat.o(55706);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cku
 * JD-Core Version:    0.7.0.1
 */