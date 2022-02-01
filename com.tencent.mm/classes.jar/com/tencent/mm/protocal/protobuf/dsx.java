package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dsx
  extends com.tencent.mm.bx.a
{
  public String AGA;
  public String AGB;
  public String AGC;
  public String AGD;
  public long AGE;
  public String AGF;
  public String AGs;
  public String AGt;
  public String AGu;
  public String AGv;
  public long AGw;
  public String AGx;
  public String AGy;
  public String AGz;
  public String kqB;
  public String oYa;
  public String oYb;
  public String rUO;
  public String source;
  public String thumbUrl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153016);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.AGs != null) {
        paramVarArgs.d(1, this.AGs);
      }
      if (this.AGt != null) {
        paramVarArgs.d(2, this.AGt);
      }
      if (this.AGu != null) {
        paramVarArgs.d(3, this.AGu);
      }
      if (this.AGv != null) {
        paramVarArgs.d(4, this.AGv);
      }
      paramVarArgs.aG(5, this.AGw);
      if (this.AGA != null) {
        paramVarArgs.d(6, this.AGA);
      }
      if (this.oYa != null) {
        paramVarArgs.d(7, this.oYa);
      }
      if (this.oYb != null) {
        paramVarArgs.d(8, this.oYb);
      }
      if (this.rUO != null) {
        paramVarArgs.d(9, this.rUO);
      }
      if (this.AGx != null) {
        paramVarArgs.d(10, this.AGx);
      }
      if (this.AGy != null) {
        paramVarArgs.d(11, this.AGy);
      }
      if (this.AGz != null) {
        paramVarArgs.d(12, this.AGz);
      }
      if (this.source != null) {
        paramVarArgs.d(13, this.source);
      }
      if (this.kqB != null) {
        paramVarArgs.d(14, this.kqB);
      }
      if (this.AGB != null) {
        paramVarArgs.d(15, this.AGB);
      }
      if (this.AGC != null) {
        paramVarArgs.d(16, this.AGC);
      }
      if (this.AGD != null) {
        paramVarArgs.d(17, this.AGD);
      }
      paramVarArgs.aG(18, this.AGE);
      if (this.thumbUrl != null) {
        paramVarArgs.d(19, this.thumbUrl);
      }
      if (this.AGF != null) {
        paramVarArgs.d(20, this.AGF);
      }
      AppMethodBeat.o(153016);
      return 0;
    }
    if (paramInt == 1) {
      if (this.AGs == null) {
        break label1354;
      }
    }
    label1354:
    for (int i = f.a.a.b.b.a.e(1, this.AGs) + 0;; i = 0)
    {
      paramInt = i;
      if (this.AGt != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.AGt);
      }
      i = paramInt;
      if (this.AGu != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.AGu);
      }
      paramInt = i;
      if (this.AGv != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.AGv);
      }
      i = paramInt + f.a.a.b.b.a.q(5, this.AGw);
      paramInt = i;
      if (this.AGA != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.AGA);
      }
      i = paramInt;
      if (this.oYa != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.oYa);
      }
      paramInt = i;
      if (this.oYb != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.oYb);
      }
      i = paramInt;
      if (this.rUO != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.rUO);
      }
      paramInt = i;
      if (this.AGx != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.AGx);
      }
      i = paramInt;
      if (this.AGy != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.AGy);
      }
      paramInt = i;
      if (this.AGz != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.AGz);
      }
      i = paramInt;
      if (this.source != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.source);
      }
      paramInt = i;
      if (this.kqB != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.kqB);
      }
      i = paramInt;
      if (this.AGB != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.AGB);
      }
      paramInt = i;
      if (this.AGC != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.AGC);
      }
      i = paramInt;
      if (this.AGD != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.AGD);
      }
      i += f.a.a.b.b.a.q(18, this.AGE);
      paramInt = i;
      if (this.thumbUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.thumbUrl);
      }
      i = paramInt;
      if (this.AGF != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.AGF);
      }
      AppMethodBeat.o(153016);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(153016);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dsx localdsx = (dsx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153016);
          return -1;
        case 1: 
          localdsx.AGs = locala.KhF.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 2: 
          localdsx.AGt = locala.KhF.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 3: 
          localdsx.AGu = locala.KhF.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 4: 
          localdsx.AGv = locala.KhF.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 5: 
          localdsx.AGw = locala.KhF.xT();
          AppMethodBeat.o(153016);
          return 0;
        case 6: 
          localdsx.AGA = locala.KhF.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 7: 
          localdsx.oYa = locala.KhF.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 8: 
          localdsx.oYb = locala.KhF.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 9: 
          localdsx.rUO = locala.KhF.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 10: 
          localdsx.AGx = locala.KhF.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 11: 
          localdsx.AGy = locala.KhF.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 12: 
          localdsx.AGz = locala.KhF.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 13: 
          localdsx.source = locala.KhF.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 14: 
          localdsx.kqB = locala.KhF.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 15: 
          localdsx.AGB = locala.KhF.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 16: 
          localdsx.AGC = locala.KhF.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 17: 
          localdsx.AGD = locala.KhF.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 18: 
          localdsx.AGE = locala.KhF.xT();
          AppMethodBeat.o(153016);
          return 0;
        case 19: 
          localdsx.thumbUrl = locala.KhF.readString();
          AppMethodBeat.o(153016);
          return 0;
        }
        localdsx.AGF = locala.KhF.readString();
        AppMethodBeat.o(153016);
        return 0;
      }
      AppMethodBeat.o(153016);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsx
 * JD-Core Version:    0.7.0.1
 */