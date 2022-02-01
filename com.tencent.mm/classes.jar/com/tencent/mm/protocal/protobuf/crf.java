package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class crf
  extends com.tencent.mm.bw.a
{
  public String FLO;
  public String FLP;
  public String FLQ;
  public String FLR;
  public String FLS;
  public String FLT;
  public ekl FLU;
  public String FYh;
  public String GMW;
  public String HCA;
  public String HCB;
  public int HCC;
  public String HCs;
  public int HCt;
  public LinkedList<cxn> HCu;
  public String HCv;
  public String HCw;
  public String HCx;
  public String HCy;
  public String HCz;
  public int HpA;
  public String gvv;
  public int uqv;
  public String urv;
  public String uuo;
  
  public crf()
  {
    AppMethodBeat.i(152664);
    this.HCu = new LinkedList();
    AppMethodBeat.o(152664);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152665);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.gvv != null) {
        paramVarArgs.d(1, this.gvv);
      }
      if (this.uuo != null) {
        paramVarArgs.d(2, this.uuo);
      }
      if (this.FLQ != null) {
        paramVarArgs.d(3, this.FLQ);
      }
      if (this.GMW != null) {
        paramVarArgs.d(4, this.GMW);
      }
      if (this.FLP != null) {
        paramVarArgs.d(5, this.FLP);
      }
      if (this.FLO != null) {
        paramVarArgs.d(6, this.FLO);
      }
      if (this.HCs != null) {
        paramVarArgs.d(7, this.HCs);
      }
      paramVarArgs.aS(8, this.HCt);
      paramVarArgs.e(9, 8, this.HCu);
      if (this.FLR != null) {
        paramVarArgs.d(10, this.FLR);
      }
      if (this.HCv != null) {
        paramVarArgs.d(11, this.HCv);
      }
      if (this.HCw != null) {
        paramVarArgs.d(12, this.HCw);
      }
      paramVarArgs.aS(13, this.HpA);
      if (this.FYh != null) {
        paramVarArgs.d(14, this.FYh);
      }
      if (this.urv != null) {
        paramVarArgs.d(15, this.urv);
      }
      if (this.FLS != null) {
        paramVarArgs.d(16, this.FLS);
      }
      if (this.HCx != null) {
        paramVarArgs.d(17, this.HCx);
      }
      if (this.HCy != null) {
        paramVarArgs.d(18, this.HCy);
      }
      if (this.FLT != null) {
        paramVarArgs.d(19, this.FLT);
      }
      if (this.HCz != null) {
        paramVarArgs.d(20, this.HCz);
      }
      if (this.HCA != null) {
        paramVarArgs.d(21, this.HCA);
      }
      if (this.FLU != null)
      {
        paramVarArgs.lJ(22, this.FLU.computeSize());
        this.FLU.writeFields(paramVarArgs);
      }
      if (this.HCB != null) {
        paramVarArgs.d(23, this.HCB);
      }
      paramVarArgs.aS(24, this.HCC);
      paramVarArgs.aS(25, this.uqv);
      AppMethodBeat.o(152665);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gvv == null) {
        break label1806;
      }
    }
    label1806:
    for (int i = f.a.a.b.b.a.e(1, this.gvv) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uuo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uuo);
      }
      i = paramInt;
      if (this.FLQ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FLQ);
      }
      paramInt = i;
      if (this.GMW != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GMW);
      }
      i = paramInt;
      if (this.FLP != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FLP);
      }
      paramInt = i;
      if (this.FLO != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FLO);
      }
      i = paramInt;
      if (this.HCs != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.HCs);
      }
      i = i + f.a.a.b.b.a.bz(8, this.HCt) + f.a.a.a.c(9, 8, this.HCu);
      paramInt = i;
      if (this.FLR != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FLR);
      }
      i = paramInt;
      if (this.HCv != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.HCv);
      }
      paramInt = i;
      if (this.HCw != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.HCw);
      }
      i = paramInt + f.a.a.b.b.a.bz(13, this.HpA);
      paramInt = i;
      if (this.FYh != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.FYh);
      }
      i = paramInt;
      if (this.urv != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.urv);
      }
      paramInt = i;
      if (this.FLS != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.FLS);
      }
      i = paramInt;
      if (this.HCx != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.HCx);
      }
      paramInt = i;
      if (this.HCy != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.HCy);
      }
      i = paramInt;
      if (this.FLT != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.FLT);
      }
      paramInt = i;
      if (this.HCz != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.HCz);
      }
      i = paramInt;
      if (this.HCA != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.HCA);
      }
      paramInt = i;
      if (this.FLU != null) {
        paramInt = i + f.a.a.a.lI(22, this.FLU.computeSize());
      }
      i = paramInt;
      if (this.HCB != null) {
        i = paramInt + f.a.a.b.b.a.e(23, this.HCB);
      }
      paramInt = f.a.a.b.b.a.bz(24, this.HCC);
      int j = f.a.a.b.b.a.bz(25, this.uqv);
      AppMethodBeat.o(152665);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HCu.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152665);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        crf localcrf = (crf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152665);
          return -1;
        case 1: 
          localcrf.gvv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 2: 
          localcrf.uuo = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 3: 
          localcrf.FLQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 4: 
          localcrf.GMW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 5: 
          localcrf.FLP = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 6: 
          localcrf.FLO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 7: 
          localcrf.HCs = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 8: 
          localcrf.HCt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152665);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcrf.HCu.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152665);
          return 0;
        case 10: 
          localcrf.FLR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 11: 
          localcrf.HCv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 12: 
          localcrf.HCw = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 13: 
          localcrf.HpA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152665);
          return 0;
        case 14: 
          localcrf.FYh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 15: 
          localcrf.urv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 16: 
          localcrf.FLS = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 17: 
          localcrf.HCx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 18: 
          localcrf.HCy = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 19: 
          localcrf.FLT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 20: 
          localcrf.HCz = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 21: 
          localcrf.HCA = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ekl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ekl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcrf.FLU = ((ekl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152665);
          return 0;
        case 23: 
          localcrf.HCB = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 24: 
          localcrf.HCC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152665);
          return 0;
        }
        localcrf.uqv = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(152665);
        return 0;
      }
      AppMethodBeat.o(152665);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crf
 * JD-Core Version:    0.7.0.1
 */