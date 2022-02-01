package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eeq
  extends com.tencent.mm.bx.a
{
  public String DBG;
  public String DBH;
  public String DBI;
  public String DBJ;
  public long DBK;
  public String DBL;
  public String DBM;
  public String DBN;
  public String DBO;
  public String DBP;
  public String DBQ;
  public String DBR;
  public long DBS;
  public String DBT;
  public String lox;
  public String qeQ;
  public String qeR;
  public String source;
  public String thumbUrl;
  public String uaw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153016);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DBG != null) {
        paramVarArgs.d(1, this.DBG);
      }
      if (this.DBH != null) {
        paramVarArgs.d(2, this.DBH);
      }
      if (this.DBI != null) {
        paramVarArgs.d(3, this.DBI);
      }
      if (this.DBJ != null) {
        paramVarArgs.d(4, this.DBJ);
      }
      paramVarArgs.aY(5, this.DBK);
      if (this.DBO != null) {
        paramVarArgs.d(6, this.DBO);
      }
      if (this.qeQ != null) {
        paramVarArgs.d(7, this.qeQ);
      }
      if (this.qeR != null) {
        paramVarArgs.d(8, this.qeR);
      }
      if (this.uaw != null) {
        paramVarArgs.d(9, this.uaw);
      }
      if (this.DBL != null) {
        paramVarArgs.d(10, this.DBL);
      }
      if (this.DBM != null) {
        paramVarArgs.d(11, this.DBM);
      }
      if (this.DBN != null) {
        paramVarArgs.d(12, this.DBN);
      }
      if (this.source != null) {
        paramVarArgs.d(13, this.source);
      }
      if (this.lox != null) {
        paramVarArgs.d(14, this.lox);
      }
      if (this.DBP != null) {
        paramVarArgs.d(15, this.DBP);
      }
      if (this.DBQ != null) {
        paramVarArgs.d(16, this.DBQ);
      }
      if (this.DBR != null) {
        paramVarArgs.d(17, this.DBR);
      }
      paramVarArgs.aY(18, this.DBS);
      if (this.thumbUrl != null) {
        paramVarArgs.d(19, this.thumbUrl);
      }
      if (this.DBT != null) {
        paramVarArgs.d(20, this.DBT);
      }
      AppMethodBeat.o(153016);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DBG == null) {
        break label1354;
      }
    }
    label1354:
    for (int i = f.a.a.b.b.a.e(1, this.DBG) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DBH != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DBH);
      }
      i = paramInt;
      if (this.DBI != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DBI);
      }
      paramInt = i;
      if (this.DBJ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DBJ);
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.DBK);
      paramInt = i;
      if (this.DBO != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DBO);
      }
      i = paramInt;
      if (this.qeQ != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.qeQ);
      }
      paramInt = i;
      if (this.qeR != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.qeR);
      }
      i = paramInt;
      if (this.uaw != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.uaw);
      }
      paramInt = i;
      if (this.DBL != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.DBL);
      }
      i = paramInt;
      if (this.DBM != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.DBM);
      }
      paramInt = i;
      if (this.DBN != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.DBN);
      }
      i = paramInt;
      if (this.source != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.source);
      }
      paramInt = i;
      if (this.lox != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.lox);
      }
      i = paramInt;
      if (this.DBP != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.DBP);
      }
      paramInt = i;
      if (this.DBQ != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.DBQ);
      }
      i = paramInt;
      if (this.DBR != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.DBR);
      }
      i += f.a.a.b.b.a.p(18, this.DBS);
      paramInt = i;
      if (this.thumbUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.thumbUrl);
      }
      i = paramInt;
      if (this.DBT != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.DBT);
      }
      AppMethodBeat.o(153016);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(153016);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        eeq localeeq = (eeq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153016);
          return -1;
        case 1: 
          localeeq.DBG = locala.NPN.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 2: 
          localeeq.DBH = locala.NPN.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 3: 
          localeeq.DBI = locala.NPN.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 4: 
          localeeq.DBJ = locala.NPN.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 5: 
          localeeq.DBK = locala.NPN.zd();
          AppMethodBeat.o(153016);
          return 0;
        case 6: 
          localeeq.DBO = locala.NPN.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 7: 
          localeeq.qeQ = locala.NPN.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 8: 
          localeeq.qeR = locala.NPN.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 9: 
          localeeq.uaw = locala.NPN.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 10: 
          localeeq.DBL = locala.NPN.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 11: 
          localeeq.DBM = locala.NPN.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 12: 
          localeeq.DBN = locala.NPN.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 13: 
          localeeq.source = locala.NPN.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 14: 
          localeeq.lox = locala.NPN.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 15: 
          localeeq.DBP = locala.NPN.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 16: 
          localeeq.DBQ = locala.NPN.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 17: 
          localeeq.DBR = locala.NPN.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 18: 
          localeeq.DBS = locala.NPN.zd();
          AppMethodBeat.o(153016);
          return 0;
        case 19: 
          localeeq.thumbUrl = locala.NPN.readString();
          AppMethodBeat.o(153016);
          return 0;
        }
        localeeq.DBT = locala.NPN.readString();
        AppMethodBeat.o(153016);
        return 0;
      }
      AppMethodBeat.o(153016);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eeq
 * JD-Core Version:    0.7.0.1
 */