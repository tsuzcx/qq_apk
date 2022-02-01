package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fat
  extends com.tencent.mm.bw.a
{
  public String IEA;
  public String IEB;
  public long IEC;
  public String IED;
  public String IEE;
  public String IEF;
  public String IEG;
  public String IEH;
  public String IEI;
  public String IEJ;
  public long IEK;
  public String IEL;
  public String IEy;
  public String IEz;
  public String eby;
  public String msN;
  public String rCq;
  public String source;
  public String thumbUrl;
  public String xDQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153016);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.IEy != null) {
        paramVarArgs.e(1, this.IEy);
      }
      if (this.IEz != null) {
        paramVarArgs.e(2, this.IEz);
      }
      if (this.IEA != null) {
        paramVarArgs.e(3, this.IEA);
      }
      if (this.IEB != null) {
        paramVarArgs.e(4, this.IEB);
      }
      paramVarArgs.bb(5, this.IEC);
      if (this.IEG != null) {
        paramVarArgs.e(6, this.IEG);
      }
      if (this.rCq != null) {
        paramVarArgs.e(7, this.rCq);
      }
      if (this.msN != null) {
        paramVarArgs.e(8, this.msN);
      }
      if (this.xDQ != null) {
        paramVarArgs.e(9, this.xDQ);
      }
      if (this.IED != null) {
        paramVarArgs.e(10, this.IED);
      }
      if (this.IEE != null) {
        paramVarArgs.e(11, this.IEE);
      }
      if (this.IEF != null) {
        paramVarArgs.e(12, this.IEF);
      }
      if (this.source != null) {
        paramVarArgs.e(13, this.source);
      }
      if (this.eby != null) {
        paramVarArgs.e(14, this.eby);
      }
      if (this.IEH != null) {
        paramVarArgs.e(15, this.IEH);
      }
      if (this.IEI != null) {
        paramVarArgs.e(16, this.IEI);
      }
      if (this.IEJ != null) {
        paramVarArgs.e(17, this.IEJ);
      }
      paramVarArgs.bb(18, this.IEK);
      if (this.thumbUrl != null) {
        paramVarArgs.e(19, this.thumbUrl);
      }
      if (this.IEL != null) {
        paramVarArgs.e(20, this.IEL);
      }
      AppMethodBeat.o(153016);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IEy == null) {
        break label1354;
      }
    }
    label1354:
    for (int i = g.a.a.b.b.a.f(1, this.IEy) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IEz != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.IEz);
      }
      i = paramInt;
      if (this.IEA != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.IEA);
      }
      paramInt = i;
      if (this.IEB != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.IEB);
      }
      i = paramInt + g.a.a.b.b.a.r(5, this.IEC);
      paramInt = i;
      if (this.IEG != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.IEG);
      }
      i = paramInt;
      if (this.rCq != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.rCq);
      }
      paramInt = i;
      if (this.msN != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.msN);
      }
      i = paramInt;
      if (this.xDQ != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.xDQ);
      }
      paramInt = i;
      if (this.IED != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.IED);
      }
      i = paramInt;
      if (this.IEE != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.IEE);
      }
      paramInt = i;
      if (this.IEF != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.IEF);
      }
      i = paramInt;
      if (this.source != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.source);
      }
      paramInt = i;
      if (this.eby != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.eby);
      }
      i = paramInt;
      if (this.IEH != null) {
        i = paramInt + g.a.a.b.b.a.f(15, this.IEH);
      }
      paramInt = i;
      if (this.IEI != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.IEI);
      }
      i = paramInt;
      if (this.IEJ != null) {
        i = paramInt + g.a.a.b.b.a.f(17, this.IEJ);
      }
      i += g.a.a.b.b.a.r(18, this.IEK);
      paramInt = i;
      if (this.thumbUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(19, this.thumbUrl);
      }
      i = paramInt;
      if (this.IEL != null) {
        i = paramInt + g.a.a.b.b.a.f(20, this.IEL);
      }
      AppMethodBeat.o(153016);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(153016);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fat localfat = (fat)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153016);
          return -1;
        case 1: 
          localfat.IEy = locala.UbS.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 2: 
          localfat.IEz = locala.UbS.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 3: 
          localfat.IEA = locala.UbS.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 4: 
          localfat.IEB = locala.UbS.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 5: 
          localfat.IEC = locala.UbS.zl();
          AppMethodBeat.o(153016);
          return 0;
        case 6: 
          localfat.IEG = locala.UbS.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 7: 
          localfat.rCq = locala.UbS.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 8: 
          localfat.msN = locala.UbS.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 9: 
          localfat.xDQ = locala.UbS.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 10: 
          localfat.IED = locala.UbS.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 11: 
          localfat.IEE = locala.UbS.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 12: 
          localfat.IEF = locala.UbS.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 13: 
          localfat.source = locala.UbS.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 14: 
          localfat.eby = locala.UbS.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 15: 
          localfat.IEH = locala.UbS.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 16: 
          localfat.IEI = locala.UbS.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 17: 
          localfat.IEJ = locala.UbS.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 18: 
          localfat.IEK = locala.UbS.zl();
          AppMethodBeat.o(153016);
          return 0;
        case 19: 
          localfat.thumbUrl = locala.UbS.readString();
          AppMethodBeat.o(153016);
          return 0;
        }
        localfat.IEL = locala.UbS.readString();
        AppMethodBeat.o(153016);
        return 0;
      }
      AppMethodBeat.o(153016);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fat
 * JD-Core Version:    0.7.0.1
 */