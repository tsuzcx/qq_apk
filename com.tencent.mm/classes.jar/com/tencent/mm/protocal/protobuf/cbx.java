package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cbx
  extends com.tencent.mm.bw.a
{
  public String Cjw;
  public int Gaz;
  public String KBN;
  public String LWD;
  public long MhJ;
  public String MhL;
  public int MhN;
  public int MhO;
  public String MhP;
  public int nHh;
  public int pRN;
  public String pTn;
  public String qGB;
  public int state;
  public String yPK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72506);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LWD != null) {
        paramVarArgs.e(1, this.LWD);
      }
      if (this.KBN != null) {
        paramVarArgs.e(2, this.KBN);
      }
      paramVarArgs.bb(3, this.MhJ);
      paramVarArgs.aM(4, this.state);
      paramVarArgs.aM(5, this.Gaz);
      paramVarArgs.aM(6, this.pRN);
      paramVarArgs.aM(7, this.MhN);
      paramVarArgs.aM(8, this.MhO);
      if (this.MhP != null) {
        paramVarArgs.e(9, this.MhP);
      }
      if (this.pTn != null) {
        paramVarArgs.e(10, this.pTn);
      }
      if (this.yPK != null) {
        paramVarArgs.e(11, this.yPK);
      }
      if (this.qGB != null) {
        paramVarArgs.e(12, this.qGB);
      }
      if (this.Cjw != null) {
        paramVarArgs.e(13, this.Cjw);
      }
      if (this.MhL != null) {
        paramVarArgs.e(14, this.MhL);
      }
      paramVarArgs.aM(15, this.nHh);
      AppMethodBeat.o(72506);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LWD == null) {
        break label954;
      }
    }
    label954:
    for (paramInt = g.a.a.b.b.a.f(1, this.LWD) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KBN != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.KBN);
      }
      i = i + g.a.a.b.b.a.r(3, this.MhJ) + g.a.a.b.b.a.bu(4, this.state) + g.a.a.b.b.a.bu(5, this.Gaz) + g.a.a.b.b.a.bu(6, this.pRN) + g.a.a.b.b.a.bu(7, this.MhN) + g.a.a.b.b.a.bu(8, this.MhO);
      paramInt = i;
      if (this.MhP != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.MhP);
      }
      i = paramInt;
      if (this.pTn != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.pTn);
      }
      paramInt = i;
      if (this.yPK != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.yPK);
      }
      i = paramInt;
      if (this.qGB != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.qGB);
      }
      paramInt = i;
      if (this.Cjw != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.Cjw);
      }
      i = paramInt;
      if (this.MhL != null) {
        i = paramInt + g.a.a.b.b.a.f(14, this.MhL);
      }
      paramInt = g.a.a.b.b.a.bu(15, this.nHh);
      AppMethodBeat.o(72506);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72506);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cbx localcbx = (cbx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72506);
          return -1;
        case 1: 
          localcbx.LWD = locala.UbS.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 2: 
          localcbx.KBN = locala.UbS.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 3: 
          localcbx.MhJ = locala.UbS.zl();
          AppMethodBeat.o(72506);
          return 0;
        case 4: 
          localcbx.state = locala.UbS.zi();
          AppMethodBeat.o(72506);
          return 0;
        case 5: 
          localcbx.Gaz = locala.UbS.zi();
          AppMethodBeat.o(72506);
          return 0;
        case 6: 
          localcbx.pRN = locala.UbS.zi();
          AppMethodBeat.o(72506);
          return 0;
        case 7: 
          localcbx.MhN = locala.UbS.zi();
          AppMethodBeat.o(72506);
          return 0;
        case 8: 
          localcbx.MhO = locala.UbS.zi();
          AppMethodBeat.o(72506);
          return 0;
        case 9: 
          localcbx.MhP = locala.UbS.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 10: 
          localcbx.pTn = locala.UbS.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 11: 
          localcbx.yPK = locala.UbS.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 12: 
          localcbx.qGB = locala.UbS.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 13: 
          localcbx.Cjw = locala.UbS.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 14: 
          localcbx.MhL = locala.UbS.readString();
          AppMethodBeat.o(72506);
          return 0;
        }
        localcbx.nHh = locala.UbS.zi();
        AppMethodBeat.o(72506);
        return 0;
      }
      AppMethodBeat.o(72506);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbx
 * JD-Core Version:    0.7.0.1
 */