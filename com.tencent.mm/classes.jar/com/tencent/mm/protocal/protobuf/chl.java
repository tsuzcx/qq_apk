package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class chl
  extends com.tencent.mm.bv.a
{
  public String Id;
  public String Url;
  public int cIp;
  public String cqq;
  public float duration;
  public int jKs;
  public int subType;
  public int xrR;
  public String xrS;
  public int xrT;
  public int xse;
  public long xsf;
  public String xsg;
  public String xsh;
  public int xsi;
  public String xsj;
  public String xsk;
  public int xsl;
  public String xsm;
  public String xsn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56527);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.e(1, this.Id);
      }
      paramVarArgs.aO(2, this.jKs);
      if (this.Url != null) {
        paramVarArgs.e(3, this.Url);
      }
      paramVarArgs.aO(4, this.xrR);
      if (this.xrS != null) {
        paramVarArgs.e(5, this.xrS);
      }
      paramVarArgs.aO(6, this.xrT);
      paramVarArgs.aO(7, this.subType);
      if (this.cqq != null) {
        paramVarArgs.e(8, this.cqq);
      }
      if (this.xsn != null) {
        paramVarArgs.e(9, this.xsn);
      }
      paramVarArgs.aO(10, this.cIp);
      paramVarArgs.aO(11, this.xse);
      paramVarArgs.am(12, this.xsf);
      if (this.xsg != null) {
        paramVarArgs.e(13, this.xsg);
      }
      if (this.xsh != null) {
        paramVarArgs.e(14, this.xsh);
      }
      paramVarArgs.aO(15, this.xsi);
      if (this.xsj != null) {
        paramVarArgs.e(16, this.xsj);
      }
      if (this.xsk != null) {
        paramVarArgs.e(17, this.xsk);
      }
      paramVarArgs.aO(18, this.xsl);
      if (this.xsm != null) {
        paramVarArgs.e(19, this.xsm);
      }
      paramVarArgs.q(20, this.duration);
      AppMethodBeat.o(56527);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Id == null) {
        break label1221;
      }
    }
    label1221:
    for (paramInt = e.a.a.b.b.a.f(1, this.Id) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.jKs);
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.Url);
      }
      i = paramInt + e.a.a.b.b.a.bl(4, this.xrR);
      paramInt = i;
      if (this.xrS != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.xrS);
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.xrT) + e.a.a.b.b.a.bl(7, this.subType);
      paramInt = i;
      if (this.cqq != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.cqq);
      }
      i = paramInt;
      if (this.xsn != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.xsn);
      }
      i = i + e.a.a.b.b.a.bl(10, this.cIp) + e.a.a.b.b.a.bl(11, this.xse) + e.a.a.b.b.a.p(12, this.xsf);
      paramInt = i;
      if (this.xsg != null) {
        paramInt = i + e.a.a.b.b.a.f(13, this.xsg);
      }
      i = paramInt;
      if (this.xsh != null) {
        i = paramInt + e.a.a.b.b.a.f(14, this.xsh);
      }
      i += e.a.a.b.b.a.bl(15, this.xsi);
      paramInt = i;
      if (this.xsj != null) {
        paramInt = i + e.a.a.b.b.a.f(16, this.xsj);
      }
      i = paramInt;
      if (this.xsk != null) {
        i = paramInt + e.a.a.b.b.a.f(17, this.xsk);
      }
      i += e.a.a.b.b.a.bl(18, this.xsl);
      paramInt = i;
      if (this.xsm != null) {
        paramInt = i + e.a.a.b.b.a.f(19, this.xsm);
      }
      i = e.a.a.b.b.a.eW(20);
      AppMethodBeat.o(56527);
      return paramInt + (i + 4);
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56527);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        chl localchl = (chl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56527);
          return -1;
        case 1: 
          localchl.Id = locala.CLY.readString();
          AppMethodBeat.o(56527);
          return 0;
        case 2: 
          localchl.jKs = locala.CLY.sl();
          AppMethodBeat.o(56527);
          return 0;
        case 3: 
          localchl.Url = locala.CLY.readString();
          AppMethodBeat.o(56527);
          return 0;
        case 4: 
          localchl.xrR = locala.CLY.sl();
          AppMethodBeat.o(56527);
          return 0;
        case 5: 
          localchl.xrS = locala.CLY.readString();
          AppMethodBeat.o(56527);
          return 0;
        case 6: 
          localchl.xrT = locala.CLY.sl();
          AppMethodBeat.o(56527);
          return 0;
        case 7: 
          localchl.subType = locala.CLY.sl();
          AppMethodBeat.o(56527);
          return 0;
        case 8: 
          localchl.cqq = locala.CLY.readString();
          AppMethodBeat.o(56527);
          return 0;
        case 9: 
          localchl.xsn = locala.CLY.readString();
          AppMethodBeat.o(56527);
          return 0;
        case 10: 
          localchl.cIp = locala.CLY.sl();
          AppMethodBeat.o(56527);
          return 0;
        case 11: 
          localchl.xse = locala.CLY.sl();
          AppMethodBeat.o(56527);
          return 0;
        case 12: 
          localchl.xsf = locala.CLY.sm();
          AppMethodBeat.o(56527);
          return 0;
        case 13: 
          localchl.xsg = locala.CLY.readString();
          AppMethodBeat.o(56527);
          return 0;
        case 14: 
          localchl.xsh = locala.CLY.readString();
          AppMethodBeat.o(56527);
          return 0;
        case 15: 
          localchl.xsi = locala.CLY.sl();
          AppMethodBeat.o(56527);
          return 0;
        case 16: 
          localchl.xsj = locala.CLY.readString();
          AppMethodBeat.o(56527);
          return 0;
        case 17: 
          localchl.xsk = locala.CLY.readString();
          AppMethodBeat.o(56527);
          return 0;
        case 18: 
          localchl.xsl = locala.CLY.sl();
          AppMethodBeat.o(56527);
          return 0;
        case 19: 
          localchl.xsm = locala.CLY.readString();
          AppMethodBeat.o(56527);
          return 0;
        }
        localchl.duration = Float.intBitsToFloat(locala.CLY.emx());
        AppMethodBeat.o(56527);
        return 0;
      }
      AppMethodBeat.o(56527);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chl
 * JD-Core Version:    0.7.0.1
 */