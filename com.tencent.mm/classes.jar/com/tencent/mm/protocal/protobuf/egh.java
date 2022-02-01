package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class egh
  extends com.tencent.mm.bw.a
{
  public String DTD;
  public String DTE;
  public String DTF;
  public String DTG;
  public long DTH;
  public String DTI;
  public String DTJ;
  public String DTK;
  public String DTL;
  public String DTM;
  public String DTN;
  public String DTO;
  public long DTP;
  public String DTQ;
  public String dJL;
  public String qlv;
  public String qlw;
  public String source;
  public String thumbUrl;
  public String uly;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153016);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DTD != null) {
        paramVarArgs.d(1, this.DTD);
      }
      if (this.DTE != null) {
        paramVarArgs.d(2, this.DTE);
      }
      if (this.DTF != null) {
        paramVarArgs.d(3, this.DTF);
      }
      if (this.DTG != null) {
        paramVarArgs.d(4, this.DTG);
      }
      paramVarArgs.aZ(5, this.DTH);
      if (this.DTL != null) {
        paramVarArgs.d(6, this.DTL);
      }
      if (this.qlv != null) {
        paramVarArgs.d(7, this.qlv);
      }
      if (this.qlw != null) {
        paramVarArgs.d(8, this.qlw);
      }
      if (this.uly != null) {
        paramVarArgs.d(9, this.uly);
      }
      if (this.DTI != null) {
        paramVarArgs.d(10, this.DTI);
      }
      if (this.DTJ != null) {
        paramVarArgs.d(11, this.DTJ);
      }
      if (this.DTK != null) {
        paramVarArgs.d(12, this.DTK);
      }
      if (this.source != null) {
        paramVarArgs.d(13, this.source);
      }
      if (this.dJL != null) {
        paramVarArgs.d(14, this.dJL);
      }
      if (this.DTM != null) {
        paramVarArgs.d(15, this.DTM);
      }
      if (this.DTN != null) {
        paramVarArgs.d(16, this.DTN);
      }
      if (this.DTO != null) {
        paramVarArgs.d(17, this.DTO);
      }
      paramVarArgs.aZ(18, this.DTP);
      if (this.thumbUrl != null) {
        paramVarArgs.d(19, this.thumbUrl);
      }
      if (this.DTQ != null) {
        paramVarArgs.d(20, this.DTQ);
      }
      AppMethodBeat.o(153016);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DTD == null) {
        break label1354;
      }
    }
    label1354:
    for (int i = f.a.a.b.b.a.e(1, this.DTD) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DTE != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DTE);
      }
      i = paramInt;
      if (this.DTF != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DTF);
      }
      paramInt = i;
      if (this.DTG != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DTG);
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.DTH);
      paramInt = i;
      if (this.DTL != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DTL);
      }
      i = paramInt;
      if (this.qlv != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.qlv);
      }
      paramInt = i;
      if (this.qlw != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.qlw);
      }
      i = paramInt;
      if (this.uly != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.uly);
      }
      paramInt = i;
      if (this.DTI != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.DTI);
      }
      i = paramInt;
      if (this.DTJ != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.DTJ);
      }
      paramInt = i;
      if (this.DTK != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.DTK);
      }
      i = paramInt;
      if (this.source != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.source);
      }
      paramInt = i;
      if (this.dJL != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.dJL);
      }
      i = paramInt;
      if (this.DTM != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.DTM);
      }
      paramInt = i;
      if (this.DTN != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.DTN);
      }
      i = paramInt;
      if (this.DTO != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.DTO);
      }
      i += f.a.a.b.b.a.p(18, this.DTP);
      paramInt = i;
      if (this.thumbUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.thumbUrl);
      }
      i = paramInt;
      if (this.DTQ != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.DTQ);
      }
      AppMethodBeat.o(153016);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(153016);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        egh localegh = (egh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153016);
          return -1;
        case 1: 
          localegh.DTD = locala.OmT.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 2: 
          localegh.DTE = locala.OmT.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 3: 
          localegh.DTF = locala.OmT.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 4: 
          localegh.DTG = locala.OmT.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 5: 
          localegh.DTH = locala.OmT.zd();
          AppMethodBeat.o(153016);
          return 0;
        case 6: 
          localegh.DTL = locala.OmT.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 7: 
          localegh.qlv = locala.OmT.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 8: 
          localegh.qlw = locala.OmT.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 9: 
          localegh.uly = locala.OmT.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 10: 
          localegh.DTI = locala.OmT.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 11: 
          localegh.DTJ = locala.OmT.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 12: 
          localegh.DTK = locala.OmT.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 13: 
          localegh.source = locala.OmT.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 14: 
          localegh.dJL = locala.OmT.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 15: 
          localegh.DTM = locala.OmT.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 16: 
          localegh.DTN = locala.OmT.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 17: 
          localegh.DTO = locala.OmT.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 18: 
          localegh.DTP = locala.OmT.zd();
          AppMethodBeat.o(153016);
          return 0;
        case 19: 
          localegh.thumbUrl = locala.OmT.readString();
          AppMethodBeat.o(153016);
          return 0;
        }
        localegh.DTQ = locala.OmT.readString();
        AppMethodBeat.o(153016);
        return 0;
      }
      AppMethodBeat.o(153016);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egh
 * JD-Core Version:    0.7.0.1
 */