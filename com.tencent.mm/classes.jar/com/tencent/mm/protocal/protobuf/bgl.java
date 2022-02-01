package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bgl
  extends com.tencent.mm.bx.a
{
  public int CJd;
  public String CsC;
  public long DEl;
  public String DEn;
  public int DEp;
  public int DEq;
  public String DEr;
  public String Duy;
  public int lpz;
  public int nrh;
  public String nsJ;
  public String odo;
  public String sYt;
  public int state;
  public String vuQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72506);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Duy != null) {
        paramVarArgs.d(1, this.Duy);
      }
      if (this.CsC != null) {
        paramVarArgs.d(2, this.CsC);
      }
      paramVarArgs.aG(3, this.DEl);
      paramVarArgs.aR(4, this.state);
      paramVarArgs.aR(5, this.CJd);
      paramVarArgs.aR(6, this.nrh);
      paramVarArgs.aR(7, this.DEp);
      paramVarArgs.aR(8, this.DEq);
      if (this.DEr != null) {
        paramVarArgs.d(9, this.DEr);
      }
      if (this.nsJ != null) {
        paramVarArgs.d(10, this.nsJ);
      }
      if (this.sYt != null) {
        paramVarArgs.d(11, this.sYt);
      }
      if (this.odo != null) {
        paramVarArgs.d(12, this.odo);
      }
      if (this.vuQ != null) {
        paramVarArgs.d(13, this.vuQ);
      }
      if (this.DEn != null) {
        paramVarArgs.d(14, this.DEn);
      }
      paramVarArgs.aR(15, this.lpz);
      AppMethodBeat.o(72506);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Duy == null) {
        break label954;
      }
    }
    label954:
    for (paramInt = f.a.a.b.b.a.e(1, this.Duy) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CsC != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.CsC);
      }
      i = i + f.a.a.b.b.a.q(3, this.DEl) + f.a.a.b.b.a.bA(4, this.state) + f.a.a.b.b.a.bA(5, this.CJd) + f.a.a.b.b.a.bA(6, this.nrh) + f.a.a.b.b.a.bA(7, this.DEp) + f.a.a.b.b.a.bA(8, this.DEq);
      paramInt = i;
      if (this.DEr != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.DEr);
      }
      i = paramInt;
      if (this.nsJ != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.nsJ);
      }
      paramInt = i;
      if (this.sYt != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.sYt);
      }
      i = paramInt;
      if (this.odo != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.odo);
      }
      paramInt = i;
      if (this.vuQ != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.vuQ);
      }
      i = paramInt;
      if (this.DEn != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.DEn);
      }
      paramInt = f.a.a.b.b.a.bA(15, this.lpz);
      AppMethodBeat.o(72506);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72506);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bgl localbgl = (bgl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72506);
          return -1;
        case 1: 
          localbgl.Duy = locala.KhF.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 2: 
          localbgl.CsC = locala.KhF.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 3: 
          localbgl.DEl = locala.KhF.xT();
          AppMethodBeat.o(72506);
          return 0;
        case 4: 
          localbgl.state = locala.KhF.xS();
          AppMethodBeat.o(72506);
          return 0;
        case 5: 
          localbgl.CJd = locala.KhF.xS();
          AppMethodBeat.o(72506);
          return 0;
        case 6: 
          localbgl.nrh = locala.KhF.xS();
          AppMethodBeat.o(72506);
          return 0;
        case 7: 
          localbgl.DEp = locala.KhF.xS();
          AppMethodBeat.o(72506);
          return 0;
        case 8: 
          localbgl.DEq = locala.KhF.xS();
          AppMethodBeat.o(72506);
          return 0;
        case 9: 
          localbgl.DEr = locala.KhF.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 10: 
          localbgl.nsJ = locala.KhF.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 11: 
          localbgl.sYt = locala.KhF.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 12: 
          localbgl.odo = locala.KhF.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 13: 
          localbgl.vuQ = locala.KhF.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 14: 
          localbgl.DEn = locala.KhF.readString();
          AppMethodBeat.o(72506);
          return 0;
        }
        localbgl.lpz = locala.KhF.xS();
        AppMethodBeat.o(72506);
        return 0;
      }
      AppMethodBeat.o(72506);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgl
 * JD-Core Version:    0.7.0.1
 */