package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class flm
  extends com.tencent.mm.cd.a
{
  public String CHR;
  public String PyQ;
  public String PyR;
  public String PyS;
  public String PyT;
  public long PyU;
  public String PyV;
  public String PyW;
  public String PyX;
  public String PyY;
  public String PyZ;
  public String Pza;
  public String Pzb;
  public long Pzc;
  public String Pzd;
  public String fVx;
  public String pqW;
  public String source;
  public String thumbUrl;
  public String vhY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153016);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.PyQ != null) {
        paramVarArgs.f(1, this.PyQ);
      }
      if (this.PyR != null) {
        paramVarArgs.f(2, this.PyR);
      }
      if (this.PyS != null) {
        paramVarArgs.f(3, this.PyS);
      }
      if (this.PyT != null) {
        paramVarArgs.f(4, this.PyT);
      }
      paramVarArgs.bm(5, this.PyU);
      if (this.PyY != null) {
        paramVarArgs.f(6, this.PyY);
      }
      if (this.vhY != null) {
        paramVarArgs.f(7, this.vhY);
      }
      if (this.pqW != null) {
        paramVarArgs.f(8, this.pqW);
      }
      if (this.CHR != null) {
        paramVarArgs.f(9, this.CHR);
      }
      if (this.PyV != null) {
        paramVarArgs.f(10, this.PyV);
      }
      if (this.PyW != null) {
        paramVarArgs.f(11, this.PyW);
      }
      if (this.PyX != null) {
        paramVarArgs.f(12, this.PyX);
      }
      if (this.source != null) {
        paramVarArgs.f(13, this.source);
      }
      if (this.fVx != null) {
        paramVarArgs.f(14, this.fVx);
      }
      if (this.PyZ != null) {
        paramVarArgs.f(15, this.PyZ);
      }
      if (this.Pza != null) {
        paramVarArgs.f(16, this.Pza);
      }
      if (this.Pzb != null) {
        paramVarArgs.f(17, this.Pzb);
      }
      paramVarArgs.bm(18, this.Pzc);
      if (this.thumbUrl != null) {
        paramVarArgs.f(19, this.thumbUrl);
      }
      if (this.Pzd != null) {
        paramVarArgs.f(20, this.Pzd);
      }
      AppMethodBeat.o(153016);
      return 0;
    }
    if (paramInt == 1) {
      if (this.PyQ == null) {
        break label1354;
      }
    }
    label1354:
    for (int i = g.a.a.b.b.a.g(1, this.PyQ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.PyR != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.PyR);
      }
      i = paramInt;
      if (this.PyS != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.PyS);
      }
      paramInt = i;
      if (this.PyT != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.PyT);
      }
      i = paramInt + g.a.a.b.b.a.p(5, this.PyU);
      paramInt = i;
      if (this.PyY != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.PyY);
      }
      i = paramInt;
      if (this.vhY != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.vhY);
      }
      paramInt = i;
      if (this.pqW != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.pqW);
      }
      i = paramInt;
      if (this.CHR != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.CHR);
      }
      paramInt = i;
      if (this.PyV != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.PyV);
      }
      i = paramInt;
      if (this.PyW != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.PyW);
      }
      paramInt = i;
      if (this.PyX != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.PyX);
      }
      i = paramInt;
      if (this.source != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.source);
      }
      paramInt = i;
      if (this.fVx != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.fVx);
      }
      i = paramInt;
      if (this.PyZ != null) {
        i = paramInt + g.a.a.b.b.a.g(15, this.PyZ);
      }
      paramInt = i;
      if (this.Pza != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.Pza);
      }
      i = paramInt;
      if (this.Pzb != null) {
        i = paramInt + g.a.a.b.b.a.g(17, this.Pzb);
      }
      i += g.a.a.b.b.a.p(18, this.Pzc);
      paramInt = i;
      if (this.thumbUrl != null) {
        paramInt = i + g.a.a.b.b.a.g(19, this.thumbUrl);
      }
      i = paramInt;
      if (this.Pzd != null) {
        i = paramInt + g.a.a.b.b.a.g(20, this.Pzd);
      }
      AppMethodBeat.o(153016);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(153016);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        flm localflm = (flm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153016);
          return -1;
        case 1: 
          localflm.PyQ = locala.abFh.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 2: 
          localflm.PyR = locala.abFh.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 3: 
          localflm.PyS = locala.abFh.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 4: 
          localflm.PyT = locala.abFh.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 5: 
          localflm.PyU = locala.abFh.AN();
          AppMethodBeat.o(153016);
          return 0;
        case 6: 
          localflm.PyY = locala.abFh.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 7: 
          localflm.vhY = locala.abFh.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 8: 
          localflm.pqW = locala.abFh.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 9: 
          localflm.CHR = locala.abFh.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 10: 
          localflm.PyV = locala.abFh.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 11: 
          localflm.PyW = locala.abFh.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 12: 
          localflm.PyX = locala.abFh.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 13: 
          localflm.source = locala.abFh.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 14: 
          localflm.fVx = locala.abFh.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 15: 
          localflm.PyZ = locala.abFh.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 16: 
          localflm.Pza = locala.abFh.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 17: 
          localflm.Pzb = locala.abFh.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 18: 
          localflm.Pzc = locala.abFh.AN();
          AppMethodBeat.o(153016);
          return 0;
        case 19: 
          localflm.thumbUrl = locala.abFh.readString();
          AppMethodBeat.o(153016);
          return 0;
        }
        localflm.Pzd = locala.abFh.readString();
        AppMethodBeat.o(153016);
        return 0;
      }
      AppMethodBeat.o(153016);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.flm
 * JD-Core Version:    0.7.0.1
 */